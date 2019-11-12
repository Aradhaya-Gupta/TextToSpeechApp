package com.example.texttospeechapp;

import java.util.Locale;

import com.example.texttospeechapp.R.string;

import android.os.Bundle;
import android.app.Activity;
import android.speech.tts.TextToSpeech;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	EditText ed1;
	Button btn1;
	TextToSpeech ts;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ed1=(EditText)findViewById(R.id.editText1);
		btn1=(Button)findViewById(R.id.button1);
		ts=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
			
			@Override
			public void onInit(int arg0) {
				// TODO Auto-generated method stub
				if(TextToSpeech.ERROR!=0)
				{
					ts.setLanguage(Locale.CANADA);
				}
			}
		});
		btn1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String str=ed1.getText().toString();
				ts.speak(str, TextToSpeech.QUEUE_FLUSH, null);
			}
		});
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		if(ts!=null)
		{
			ts.stop();
			ts.shutdown();
		}
	}
}
