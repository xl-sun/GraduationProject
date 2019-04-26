package qztc.sxl.msmcodeserver;



import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MainService extends Service {
	private static final String TAG="MainService";
	ServiceThread serThread = null;
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		Log.i(TAG,"onCreate");
		super.onCreate();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub

		if(serThread == null){
			serThread = new ServiceThread();
		}
		
		if(!serThread.isRun()){

			Log.i(TAG,"onStartCommand");
			serThread.start();
		}

		
		
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		if(serThread != null){
			serThread.stopRun();
		}
		super.onDestroy();
	}
	
	

}
