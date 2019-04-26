package qztc.sxl.employee;

import java.util.HashMap;
import java.util.Map;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.StringRequest;

public  class StringRequestWithSession extends StringRequest {

	Map<String, String> map=null;

	public StringRequestWithSession(int method, String url,
			Listener<String> listener, ErrorListener errorListener) {
		super(method, url, listener, errorListener);
		// TODO Auto-generated constructor stub
	}

	/*
	 * @警告：仅POST可用
	 * @Warning:POST ONLY
	  */
	public StringRequestWithSession(int method, String url,Map<String, String> params,
			Listener<String> listener, ErrorListener errorListener) {
		super(method, url, listener, errorListener);
		map = params;
	}
	
	/* (non-Javadoc)
	 * @see com.android.volley.Request#getParams()
	 * */
	@Override
	protected Map<String, String> getParams() throws AuthFailureError {
		// TODO Auto-generated method stub
		return map;
	}
	
	/* (non-Javadoc)
	 * @see com.android.volley.toolbox.StringRequest#parseNetworkResponse(com.android.volley.NetworkResponse)
	 */
	@Override
	protected Response<String> parseNetworkResponse(NetworkResponse response) {
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

}
