package org.sinisterstuf.guesstheanimal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Lose extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lose);
	}
	
	public void startNewGame(View view) {
		Animal firstAnimal = new Animal("a pig", "Does it have a curly tail?",  true);
		firstAnimal.noAnimal = new Animal("a dog", "Does it have 4 legs?", true);
		Intent intent = new Intent(this, Guess.class);
		intent.putExtra(Animal.ANIMAL, firstAnimal);
		intent.putExtra("org.sinisterstuf.guesstheanimal.finalguess", false);
		startActivity(intent);
	}

}
