package org.sinisterstuf.guesstheanimal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Guess extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.guess);
		
		Intent intent = getIntent();
		Animal animal = (Animal) intent.getSerializableExtra("org.sinisterstuf.guesstheanimal.Animal");
		
		// write guess text
		TextView guessText = (TextView)findViewById(R.id.guessText);
		guessText.setText(animal.question);
	}

}
