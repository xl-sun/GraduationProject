package qztc.sxl.employee.activity;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.json.JSONException;
import org.json.JSONObject;

import qztc.sxl.employee.Constant;
import qztc.sxl.employee.R;
import qztc.sxl.employee.R.id;
import qztc.sxl.employee.R.layout;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.zxing.activity.CaptureActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends Activity {

	public static final String TAG = "HomeActivity";

	private TextView txt_user;
	private Button btn_logout;
	private Button btn_receive;
	private Button btn_sort;
	private Button btn_transport;
	private Button btn_delivery;
	
	InputStream is = null;
    Properties props = new Properties();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
		bindView();
		bindEvent();
		//初始化
		init();
	}

	private void bindView() {
		txt_user = (TextView)findViewById(R.id.txt_user);
		btn_logout = (Button)findViewById(R.id.btn_logout);
		btn_receive = (Button)findViewById(R.id.btn_receive);
		btn_sort = (Button)findViewById(R.id.btn_sort);
		btn_transport = (Button)findViewById(R.id.btn_transport);
		btn_delivery = (Button)findViewById(R.id.btn_delivery);
		
		
	}
	private void bindEvent() {
		btn_logout.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				logout();
			}
			
		});
		btn_receive.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(HomeActivity.this,RecieveMenuActivity.class);
				intent.putExtra("title", btn_receive.getText());
		    	startActivity(intent);
			}
			
		});
		btn_sort.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(HomeActivity.this,SortMenuActivity.class);
				intent.putExtra("title", btn_sort.getText());
		    	startActivity(intent);
			}
			
		});
		btn_transport.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(HomeActivity.this,TransportMenuActivity.class);
				intent.putExtra("title", btn_transport.getText());
		    	startActivity(intent);
			}
			
		});
	}
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onActivityResult(int, int, android.content.Intent)
	 */
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);if (resultCode == RESULT_OK) {
			Bundle bundle = data.getExtras();
			String scanResult = bundle.getString("result");
			Toast.makeText(HomeActivity.this, scanResult, Toast.LENGTH_LONG).show(); 
			//tv.setText("扫描结果："+scanResult);
 		}
	}

	private void init(){
		Log.i(TAG,"init");
		try {
			is = getResources().getAssets().open("conf.properties");
			props.load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url=props.getProperty("connection.home");
		RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
		StringRequest request = new StringRequest(Request.Method.GET,url,
				new Response.Listener<String>() {

					@Override
					public void onResponse(String response) {
						// TODO Auto-generated method stub
						JSONObject json;
						try {
							json = new JSONObject(response);
							String userInfo = "[%s:%s](%s)";
							userInfo = String.format(userInfo, json.optString("job"),json.optString("id"),json.optString("name"));
							txt_user.setText(userInfo);
							btn_sort.setEnabled(json.optBoolean("sort"));
							btn_receive.setEnabled(json.optBoolean("receive"));
							btn_transport.setEnabled(json.optBoolean("transport"));
							btn_delivery.setEnabled(json.optBoolean("delivery"));
							
							//json.getBoolean("sort");
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
			},new Response.ErrorListener() {
	
				@Override
				public void onErrorResponse(VolleyError error) {
					// TODO Auto-generated method stub
					
				}
			}
		){

			/* (non-Javadoc)
			 * @see com.android.volley.Request#getHeaders()
			 */
			@Override
			public Map<String, String> getHeaders() throws AuthFailureError {
				// TODO Auto-generated method stub
				if(Constant.localCookie != null && Constant.localCookie.length() > 0){
					HashMap<String, String> headers = new HashMap<String, String>();
					headers.put("cookie", Constant.localCookie);
					return headers;
				}
				return super.getHeaders();
			}
			
		};
		queue.add(request);
		
		
	}

	private void logout(){
		//移除登录状态
		String url=props.getProperty("connection.logout");
		RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
		StringRequest request = new StringRequest(Request.Method.GET,url,
				new Response.Listener<String>() {

					@Override
					public void onResponse(String response) {
						// TODO Auto-generated method stub

						
					}
			},new Response.ErrorListener() {
	
				@Override
				public void onErrorResponse(VolleyError error) {
					// TODO Auto-generated method stub
					
				}
			});
		queue.add(request);
		//跳转到登录页面
		Intent intent = new Intent(HomeActivity.this,LoginActivity.class);
		//https://blog.csdn.net/gao_blog/article/details/82052077 : 
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//关掉所要到的界面中间的 activity
		//intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);//设置不要刷新将要跳转的界面
		startActivity(intent);
		
	}
}
