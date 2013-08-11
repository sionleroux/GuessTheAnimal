package org.sinisterstuf.guesstheanimal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Guess extends Activity {
	
	private Animal animal;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.guess);
		
		Intent intent = getIntent();
		animal = (Animal) intent.getSerializableExtra("org.sinisterstuf.guesstheanimal.Animal");
		
		// write guess text
		TextView guessText = (TextView)findViewById(R.id.guessText);
		guessText.setText(animal.question);
	}
	
	/**
	 * Called when the user chooses Yes
	 */
	public void parseYes(View view) {
		parseChoice(true);
	}

	/**
	 * Called when the user chooses No
	 */
	public void parseNo(View view) {
		parseChoice(false);
	}

	/**
	 * Compares the user's <code>choice</code> to the desired answer for this
	 * <code>Animal</code> from <code>Animal.answerWhenMe</code>
	 * @param choice the user's choice
	 */
	private void parseChoice(boolean choice) {
		if (choice == animal.answerWhenMe) {
			// they chose me!
		} else {
			// see if there's another animal...
		}
	}

}
