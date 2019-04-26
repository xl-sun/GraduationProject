package qztc.sxl.msmcodeserver;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	//private static final String TAG="MainActivity";
	Button btn_start = null;
	Button btn_stop = null;
	
	Intent intent =null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = new Intent(MainActivity.this,MainService.class);
        bindView();
        bindEvent();
    }

	private void bindView() {
		btn_start = (Button)findViewById(R.id.btn_start);
		btn_stop = (Button)findViewById(R.id.btn_stop);
		
	}
	private void bindEvent() {
		btn_start.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startService(intent);
			}
			
		});
		
		btn_stop.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				stopService(intent);
			}
			
		});
		
	}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
