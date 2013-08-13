package org.sinisterstuf.guesstheanimal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Guess extends Activity {
	
	private Animal animal;
	private static String FINAL_GUESS = "org.sinisterstuf.guesstheanimal.finalguess";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.guess);
		
		Intent intent = getIntent();
		boolean finalGuess = (boolean) intent.getBooleanExtra(FINAL_GUESS, false);
		animal = (Animal) intent.getSerializableExtra("org.sinisterstuf.guesstheanimal.Animal");
		TextView guessText = (TextView)findViewById(R.id.guessText);

		if (finalGuess) {
			// write animal name
			String finalGuessFormat = getString(R.string.final_guess);
			guessText.setText(String.format(finalGuessFormat, animal.name));
		} else {
			// write question
			guessText.setText(animal.question);
		}
	}
	
	/**
	 * Called when the user chooses Yes
	 */
	public void parseYes(View view) {
		parseChoice(true, animal.yesAnimal);
	}

	/**
	 * Called when the user chooses No
	 */
	public void parseNo(View view) {
		parseChoice(false, animal.noAnimal);
	}

	/**
	 * Compares the user's <code>choice</code> to the desired answer for this
	 * <code>Animal</code> from <code>Animal.answerWhenMe</code>
	 * @param choice the user's choice
	 */
	private void parseChoice(boolean choice, Animal next) {
		if (choice == animal.answerWhenMe) {
			Intent intent = new Intent(this, Guess.class);
			intent.putExtra(Animal.ANIMAL, animal);
			intent.putExtra(FINAL_GUESS, true);
			startActivity(intent);
		} else {
			if (next == null) {
				// learn new animal
			} else {
				Intent intent = new Intent(this, Guess.class);
				intent.putExtra(Animal.ANIMAL, next);
				intent.putExtra(FINAL_GUESS, false);
				startActivity(intent);
			}
		}
	}

}
