package com.example.capturingShoeprints;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;


import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {
	static String ipAddress ="10.225.54.14";
	//EditText textOut;
	TextView textIn;
	Button button;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Context context = this;
        //textOut = (EditText)findViewById(R.id.textout);
        ImageButton  buttonSend = (ImageButton)findViewById(R.id.send);
        buttonSend.setAdjustViewBounds(true);
        buttonSend.setMaxHeight(600);
        buttonSend.setMaxWidth(600);
        textIn = (TextView)findViewById(R.id.textin);
        buttonSend.setOnClickListener(buttonSendOnClickListener);
        
//       addListenerOnButton();
        
//        if(ipAddress==null || ipAddress.equals("")){
//        	Intent intent = new Intent(context, App2Activity.class);
//            startActivity(intent);
//        }
        
        textIn.setText("Connected to "+ipAddress);
    }
    
    ImageButton.OnClickListener buttonSendOnClickListener
    = new ImageButton.OnClickListener(){

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Socket socket = null;
			DataOutputStream dataOutputStream = null;
			DataInputStream dataInputStream = null;
			
			try {
				socket = new Socket(ipAddress.toString(), 8888);
				dataOutputStream = new DataOutputStream(socket.getOutputStream());
				dataInputStream = new DataInputStream(socket.getInputStream());
				dataOutputStream.writeUTF("1");//textOut.getText().toString());
				//textIn.setText(dataInputStream.readUTF());
				Thread.sleep(35000);
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				if (socket != null){
					try {
						socket.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				if (dataOutputStream != null){
					try {
						dataOutputStream.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				if (dataInputStream != null){
					try {
						dataInputStream.close();
						textIn.setText("");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
			
		}};
		
		
		
		
		
		// Initiating Menu XML file (menu.xml)
	    @Override
	    public boolean onCreateOptionsMenu(Menu menu)
	    {
	        MenuInflater menuInflater = getMenuInflater();
	        menuInflater.inflate(R.layout.menu, menu);
	        return true;
	    }
		
	    @Override
	    public boolean onOptionsItemSelected(MenuItem item) {
	        switch(item.getItemId()) {
	        case R.id.menu_ip:
	            Intent intent = new Intent(this, App2Activity.class);
	            this.startActivity(intent);
	            break;
	        default:
	            return super.onOptionsItemSelected(item);
	        }

	        return true;
	    }
		
		///////////////////////////////////////////////////////////////////////////////
//		public void addListenerOnButton() {
//			
//			final Context context = this;
//	 
//			button = (Button) findViewById(R.id.button1);
//	 
//			button.setOnClickListener(new OnClickListener() {
//	 
//				public void onClick(View arg0) {
//	 
//				    Intent intent = new Intent(context, App2Activity.class);
//	                            startActivity(intent);   
//	 
//				}
//	 
//			});
//	 
//		}
}
