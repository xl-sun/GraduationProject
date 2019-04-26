package qztc.sxl.msmcodeserver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import org.json.JSONException;
import org.json.JSONObject;

import android.telephony.SmsManager;
import android.util.Log;

public class ServiceThread extends Thread{

	private static final String TAG="ServiceThread";
	private boolean isRun=false;
	
	private Socket  socket = null;
	private ServerSocket sc = null;
	private int port =15311;
	
	public void stopRun(){
		isRun = false;

		try {
			if(sc!=null)
				sc.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Log.i(TAG,"ServiceThreedRunStop");
	}
	
	
	public boolean isRun(){
		return isRun;
	}
	
	public void createServerSoket(){
		try {
			if(sc==null)
				sc = new ServerSocket(port);
		} catch (IOException e) {
			// TODO Auto-generated catch block

			Log.i(TAG,"createServerSoketEEEE");
			//e.printStackTrace();
			stopRun();
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//super.run();
		isRun=true;
		createServerSoket();
		Log.i(TAG,"ServiceThreed");
		while(isRun){
			BufferedReader in = null;
			BufferedWriter out = null;
			JSONObject json = null;
			try {
				//接收请求
				socket = sc.accept();
				//创建输入输出流
				in = new BufferedReader(new InputStreamReader(
						socket.getInputStream()));
				out = new BufferedWriter(new OutputStreamWriter(
						socket.getOutputStream()));
				while(isRun){
				//接收请求
				String msg = in.readLine().trim();
				json = new JSONObject(msg);
				//处理请求
				Log.i(TAG,"Socket MSG is:"+msg);
				//Log.i(TAG,"p1:"+json.optString("phone"));
				//Log.i(TAG,"p2:"+json.optString("msg"));
				SmsManager smsManager =SmsManager.getDefault();
				smsManager.sendTextMessage(json.optString("phone"), null, json.optString("msg"), null, null);
				//返回结果
				String result = "COPY";
				out.write(result + "\r\n");
				out.flush();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
			
			
			
			
			
			
			/*
			try {
				Thread.sleep(500);
				Log.i(TAG,"ServiceThreed");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}
	}

	
}
