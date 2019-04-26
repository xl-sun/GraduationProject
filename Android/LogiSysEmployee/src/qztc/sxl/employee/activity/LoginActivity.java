package qztc.sxl.employee.activity;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import qztc.sxl.employee.Constant;
import qztc.sxl.employee.R;
import qztc.sxl.employee.R.id;
import qztc.sxl.employee.R.layout;
import qztc.sxl.employee.R.menu;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class LoginActivity extends Activity {

	private EditText edt_id;
	private EditText edt_code;
	private Button btn_getcode;
	private Button btn_login;
	

	InputStream is = null;
    Properties props = new Properties();
    Handler handler = new Handler();
	Runnable runnable;
	int time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
		bindView();
		bindEvent();
	    try {
	    		is = getResources().getAssets().open("conf.properties");
	    			props.load(is);
	    } catch (IOException e) {
	    	// TODO Auto-generated catch block
	    	e.printStackTrace();
	    }
	    runnable = new Runnable(){
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				time--;
				btn_getcode.setText("已发送:\t"+time);
				handler.postDelayed(this, 1000);
				if(time<=0){
					handler.removeCallbacks(this);
					btn_getcode.setEnabled(true);
					btn_getcode.setText("获取登录码");
				}
			}
		};
    }


    private void bindEvent() {
		btn_getcode.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				btn_getcode.setEnabled(false);
			    time = 30;
				handler.postDelayed(runnable,1000);
				getCode();
			}
			
		});
		
		btn_login.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				login();
			}
			
		});
		
	}


	private void bindView() {
		edt_id = (EditText)findViewById(R.id.edt_id);
		edt_code = (EditText)findViewById(R.id.edt_code);
		btn_getcode = (Button)findViewById(R.id.btn_getcode);
		btn_login = (Button)findViewById(R.id.btn_login);
		
	}


	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.login, menu);
        return true;
    }
	
	
	public void getCode(){
		String url=props.getProperty("connection.login")+"?method=getcode&id="+edt_id.getText().toString().trim();
		RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
		StringRequest request = new StringRequest(Request.Method.GET,url,new Response.Listener<String>() {

			@Override
			public void onResponse(String response) {
				// TODO Auto-generated method stub
				Log.i("response:", response);
				if(response.equals("发送成功"))
					btn_login.setEnabled(true);
				else
			    	time = 0;
		    	Toast.makeText(LoginActivity.this, response, Toast.LENGTH_LONG).show();
			}
		},new Response.ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {
				// TODO Auto-generated method stub
				try{
				Log.e("error",error.getMessage());
				}catch(Exception e) {
			    	// TODO Auto-generated catch block
			    	e.printStackTrace();
			    	Toast.makeText(LoginActivity.this, "连接异常", Toast.LENGTH_LONG).show();
			    	time = 0;
				}
			}
		})
		{	//重写解决session问题 https://blog.csdn.net/ABOUT_time/article/details/50583233
			/* (non-Javadoc)
			 * @see com.android.volley.toolbox.StringRequest#parseNetworkResponse(com.android.volley.NetworkResponse)
			 */
			@Override
			protected Response<String> parseNetworkResponse(
					NetworkResponse response) {
				// TODO Auto-generated method stub
				String cookies = response.headers.get("Set-Cookie");
				if(cookies!=null)
					Constant.localCookie = cookies.substring(0, cookies.indexOf(";"));
				return super.parseNetworkResponse(response);
			}

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
	
	private void login(){
		final String id = edt_id.getText().toString().trim();
		final String code = edt_code.getText().toString().trim();
		//验证输入框
		if(id.equals("")){
			Toast.makeText(LoginActivity.this, "用户名不能为空", Toast.LENGTH_LONG).show();return;
		}else if(code.equals("")){
			Toast.makeText(LoginActivity.this, "登录码不能为空", Toast.LENGTH_LONG).show();return;
		}
		//发送登录请求
		String url=props.getProperty("connection.login");
		RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
		StringRequest request = new StringRequest(Request.Method.POST,url,
				new Response.Listener<String>(){

					@Override
					public void onResponse(String response) {
						// TODO Auto-generated method stub
						//验证登录结果
						//错误->提示
						Toast.makeText(LoginActivity.this, response, Toast.LENGTH_LONG).show();
						//正确->跳转
				    	if(response.equals("登录成功")){
							Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
							intent.putExtra("id",edt_id.getText().toString());
							startActivity(intent);
				    	}
					}
			
				},new Response.ErrorListener() {
	
				@Override
				public void onErrorResponse(VolleyError error) {
					// TODO Auto-generated method stub
					
				}
		}){


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

			/* (non-Javadoc)
			 * @see com.android.volley.Request#getParams() 
			 */
			@Override
			protected Map<String, String> getParams() throws AuthFailureError {
				// TODO Auto-generated method stub
				Map<String, String> map = new HashMap<String, String>();  
                map.put("id", id);  
                map.put("code",code);  
                return map;
			}
			
		};
		queue.add(request);
	}
    
}
