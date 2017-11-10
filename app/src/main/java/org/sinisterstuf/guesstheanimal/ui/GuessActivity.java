package org.sinisterstuf.guesstheanimal.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.sinisterstuf.guesstheanimal.Animal;
import org.sinisterstuf.guesstheanimal.Game;
import org.sinisterstuf.guesstheanimal.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GuessActivity extends Activity {

	public static final String FINAL_GUESS = "org.sinisterstuf.guesstheanimal.finalguess";

	@BindView(R.id.guessText)
	TextView guessText;

	private Animal animal;
	private boolean finalGuess;
	private boolean prevReq;

	public static void start(Context context, Animal animal, boolean isFinalGuess, boolean prevReq) {
		Intent intent = new Intent(context, GuessActivity.class);
		intent.putExtra(Animal.ANIMAL, animal);
		intent.putExtra(FINAL_GUESS, isFinalGuess);
		intent.putExtra(Animal.NEXT_REQ, prevReq);
		context.startActivity(intent);
	}

	public static void start(Context context) {
		start(context, Game.firstAnimal, false, false);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.guess);
		ButterKnife.bind(this);

		finalGuess = getIntent().getBooleanExtra(FINAL_GUESS, false);
		prevReq = getIntent().getBooleanExtra(Animal.NEXT_REQ, false);
		animal = (Animal) getIntent().getSerializableExtra(Animal.ANIMAL);

		if (finalGuess) {
			// write animal name
			String finalGuessFormat = getString(R.string.final_guess);
			guessText.setText(String.format(finalGuessFormat, animal.name));
		} else {
			// write question
			guessText.setText(animal.question);
		}
	}

	@OnClick(R.id.yesButton)
	public void parseYes() {
		if (finalGuess) {
			Intent intent = new Intent(this, WinActivity.class);
			startActivity(intent);
		} else {
			parseChoice(true, animal.yesAnimal);
		}
	}

	@OnClick(R.id.noButton)
	public void parseNo() {
		if (finalGuess) {
			learnNewAnimal(prevReq);
		} else {
			parseChoice(false, animal.noAnimal);
		}
	}

	private void parseChoice(boolean choice, Animal next) {
		if (choice == animal.answerWhenMe) {
			GuessActivity.start(this, animal, true, false);
		} else {
			if (next == null) {
				learnNewAnimal(choice);
			} else {
				GuessActivity.start(this, next, false, choice);
			}
		}
	}

	/**
	 * Start a new activity to learn an animal
	 */
	private void learnNewAnimal(Boolean nextReq) {
		Intent intent = new Intent(this, LearnNameActivity.class);
		intent.putExtra(Animal.ANIMAL, animal);
		intent.putExtra(Animal.NEXT_REQ, nextReq);
		startActivity(intent);
	}

}
