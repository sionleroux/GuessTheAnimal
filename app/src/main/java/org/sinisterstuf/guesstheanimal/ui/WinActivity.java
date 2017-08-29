package org.sinisterstuf.guesstheanimal.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import org.sinisterstuf.guesstheanimal.Animal;
import org.sinisterstuf.guesstheanimal.Game;
import org.sinisterstuf.guesstheanimal.R;

public class WinActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.win);
	}
	
	public void startNewGame(View view) {
		Intent intent = new Intent(this, GuessActivity.class);
		intent.putExtra(Animal.ANIMAL, Game.firstAnimal);
		intent.putExtra(GuessActivity.FINAL_GUESS, false);
		startActivity(intent);
	}

}
