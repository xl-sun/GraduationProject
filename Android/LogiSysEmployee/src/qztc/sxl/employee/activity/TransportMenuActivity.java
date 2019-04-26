package qztc.sxl.employee.activity;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.json.JSONException;
import org.json.JSONObject;

import qztc.sxl.employee.Constant;
import qztc.sxl.employee.StringRequestWithSession;
import qztc.sxl.employee.pojo.LogisticsInfo;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.zxing.activity.CaptureActivity;
import com.zxing.decoding.Intents;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TransportMenuActivity extends MenuActivity {

	Intent intent;
	Context context  = this;
	/*
	protected TextView txt_title;
	protected Button btn_back;
	protected Button btn_set;
	protected Button btn_list;
	protected Button btn_scan;
	*/
	
	InputStream is = null;
    Properties props = new Properties();
	/* (non-Javadoc)
	 * @see qztc.sxl.employee.activity.MenuActivity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		init();
	}


	/* (non-Javadoc)
	 * @see android.app.Activity#onActivityResult(int, int, android.content.Intent)
	 */
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		super.onActivityResult(requestCode, resultCode, data);if (resultCode == RESULT_OK) {
			Bundle bundle = data.getExtras();
			String scanResult = bundle.getString("result");
			//txt_title.setText("扫描结果："+scanResult);
			checkWaybill(scanResult);
 		}
	}

	@Override
	protected void bindEvent() {
		// TODO Auto-generated method stub
		btn_back.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}});
		
		btn_set.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				final EditText edt = new EditText(context);
				edt.setText(Constant.Transport.info);
				new AlertDialog.Builder(context)
				.setTitle("设置日志信息")
		        .setView(edt)
		        .setPositiveButton("保存",new DialogInterface.OnClickListener(){

					@Override
					public void onClick(DialogInterface dialog,
							int which) {
						// TODO Auto-generated method stub
						Constant.Transport.info=edt.getText().toString();
					}})
		        .setNegativeButton("关闭",null)
		        .show();
			}});
		
		btn_list.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}});
		
		btn_scan.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(TransportMenuActivity.this,CaptureActivity.class);
		    	//startActivity(intent);
				intent.putExtra(Intents.Scan.SCAN_FORMATS, "QR_CODE");
		    	startActivityForResult(intent, 0);
			}});
	}
	

	private void init() {
		// TODO Auto-generated method stub
		intent = getIntent();
		txt_title.setText(intent.getStringExtra("title"));
		try {
			is = getResources().getAssets().open("conf.properties");
			props.load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private void  checkWaybill(String scanResult){
		JSONObject json = null;
		try {
			json = new JSONObject(scanResult);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		final String id=json.optString("id");
		final String des=json.optString("des");
		//Log.i(TAG,"checkWaybill 136");
		String url=props.getProperty("connection.updatelog")+"?id="+id+"&method="+new Short(LogisticsInfo.SORTED).toString();
		RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
		//Log.i(TAG,"checkWaybill 141");
		StringRequestWithSession request = new StringRequestWithSession(Request.Method.GET,url,
				new Response.Listener<String>(){

					@Override
					public void onResponse(String response) {
						// TODO Auto-generated method stub
						JSONObject json = null;
						try {
							json = new JSONObject(response);
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						String result = json.optString("result");
						if(json.optBoolean("success"))
							updateLog(id,(short)-1,Constant.Transport.info);
						else{
							new AlertDialog.Builder(context)
					        .setMessage(result)
					        .setNeutralButton("关闭", null)
					        .show();
						}
					}},
				new Response.ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError error) {
						// TODO Auto-generated method stub
						
					}
				});
		queue.add(request);
	}
	
	private void updateLog(String id, Short tid,String info){
		String url=props.getProperty("connection.updatelog");
		RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
		
		Map<String, String> map = new HashMap<String, String>();  
		map.put("method",new Short(LogisticsInfo.TRANSPORTED).toString());  
		map.put("id", id);  
		map.put("tid",tid.toString());  
        map.put("info",info); 

		//Log.i(TAG,"updateLog 185");
		StringRequestWithSession request = new StringRequestWithSession(Request.Method.POST,url,map,
				new Response.Listener<String>(){

					@Override
					public void onResponse(String response) {
						// TODO Auto-generated method stub
						Toast.makeText(context, response, Toast.LENGTH_SHORT).show();
					}},
				new Response.ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError error) {
						// TODO Auto-generated method stub
						
					}
				});
		
		queue.add(request);
	}
	
	
	
}
