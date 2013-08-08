package org.sinisterstuf.guesstheanimal;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Guess extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.guess);
		
		// write guess text
		TextView guessText = (TextView)findViewById(R.id.guessText);
		guessText.setText("This is my guess text...");
	}

}
