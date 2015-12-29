package com.example.capturingShoeprints;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
public class App2Activity extends Activity {
	Button button;
	 
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main2);
		final Context context = this;
		final EditText input = (EditText) findViewById(R.id.textEdit1);
		button = (Button) findViewById(R.id.button2);
		input.setText(MainActivity.ipAddress);
		button.setOnClickListener(new OnClickListener() {
 
			public void onClick(View arg0) {
				MainActivity.ipAddress=input.getText().toString();
			    Intent intent = new Intent(context, MainActivity.class);
                            startActivity(intent);   
 
			}
 
		});
	}
}
