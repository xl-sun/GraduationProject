package qztc.sxl.employee.activity;


import qztc.sxl.employee.R;


import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public abstract class MenuActivity extends Activity {

	protected TextView txt_title;
	protected Button btn_back;
	protected Button btn_set;
	protected Button btn_list;
	protected Button btn_scan;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
		bindView();
		bindEvent();
	}

	private void bindView() {
		txt_title = (TextView)findViewById(R.id.txt_title);
		btn_back = (Button)findViewById(R.id.btn_back);
		btn_set = (Button)findViewById(R.id.btn_set);
		btn_list = (Button)findViewById(R.id.btn_list);
		btn_scan = (Button)findViewById(R.id.btn_scan);
		
		
	}
	
	protected abstract void bindEvent();

}
