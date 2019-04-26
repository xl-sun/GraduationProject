package com.zxing.ericssonlabs;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;


import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;



import sxl.example.qrcodescaner.R;
import com.google.zxing.WriterException;


import com.zxing.activity.CaptureActivity;
import com.zxing.encoding.EncodingHandler;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Xml;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class BarCodeTestActivity extends Activity {
    /** Called when the activity is first created. */
	private TextView resultTextView;
	private EditText qrStrEditText;
	private Context mContext;
	private ImageView qrImgImageView;
	private Button b1;
	private Button b2;
	private EditText dh;
	private EditText dz;
	private class MyOnclick implements OnClickListener {

		@Override
		public void onClick(View v) {		
			switch(v.getId())
			{
			case R.id.button1:
			
			 Intent openCameraIntent = new Intent(BarCodeTestActivity.this,CaptureActivity.class);
			startActivityForResult(openCameraIntent, 0);
			 break;
			case R.id.button2:
				
				
			/*	Intent it = new Intent(BarCodeTestActivity.this,Pd.class);
				BarCodeTestActivity.this.startActivity(it);*/
			        break;
			       
			        
		}
		}

	}
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        b1=(Button) findViewById(R.id.button1);	
        b1.setOnClickListener(new MyOnclick());  
        b2=(Button) findViewById(R.id.button2);	
        b2.setOnClickListener(new MyOnclick());  
        mContext=BarCodeTestActivity.this;
        dh=(EditText) super.findViewById(R.id.dh);
        dz=(EditText) super.findViewById(R.id.dz);
        
        resultTextView = (TextView) this.findViewById(sxl.example.qrcodescaner.R.id.tv_scan_result);
    
        qrImgImageView = (ImageView) this.findViewById(R.id.iv_qr_image);
        
        Button scanBarCodeButton = (Button) this.findViewById(R.id.btn_scan_barcode);
        
        scanBarCodeButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
					
				Intent openCameraIntent = new Intent(BarCodeTestActivity.this,CaptureActivity.class);
				startActivityForResult(openCameraIntent, 0);
			}
		});                       
    }

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		 		if (resultCode == RESULT_OK) {
			Bundle bundle = data.getExtras();
			String scanResult = bundle.getString("result");
			
			
			 String UTF_Str="";  
		        String GB_Str="";  
		        boolean is_cN=false;  
		        try {  
		            System.out.println("------------"+scanResult);  
		            UTF_Str=new String(scanResult.getBytes("ISO-8859-1"),"UTF-8");  
		         
		            IsChineseOrNot ion=new IsChineseOrNot();
		            is_cN=ion.isChineseCharacter(UTF_Str);  
		            // 
		            boolean b=ion.isSpecialCharacter(scanResult);  
		            if(b){  
		                is_cN=true;  
		            }  
		            System.out.println("  "+is_cN);  
		            if(!is_cN){  
		                GB_Str=new String(scanResult.getBytes("ISO-8859-1"),"GB2312");  
		                
		            }  
		        } catch (UnsupportedEncodingException e) {  
		            // TODO Auto-generated catch block  
		            e.printStackTrace();  
		        }  
		          
		          
		        String results="", result="";
		        if(is_cN){  
		        	results=UTF_Str;
		        	
		        }else{  
		        	results=GB_Str;  
		        } 
		        
		      
	        	resultTextView.setText(results);  
			
			
			
			//resultTextView.setText(scanResult);
		
		 		}
	}
	 
	 
	 
	 public class IsChineseOrNot {  
	      
		    public final boolean isChineseCharacter(String chineseStr) {    
		        char[] charArray = chineseStr.toCharArray();    
		        for (int i = 0; i < charArray.length; i++) {       
		            // 
		            if ((charArray[i] >= '\u0000' && charArray[i] < '\uFFFD')||((charArray[i] > '\uFFFD' && charArray[i] < '\uFFFF'))) {    
		                continue;  
		            }  
		            else{  
		                return false;  
		            }  
		        }    
		        return true;    
		    }    
		      
		    public final boolean isSpecialCharacter(String str){  
		        //  
		        if(str.contains("ï¿½")){  
		            return true;  
		        }  
		        return false;  
		    }  
		}  
	
}