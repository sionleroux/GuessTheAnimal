package org.sinisterstuf.guesstheanimal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Greeting extends Activity {
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.greeting);
    }

	public void guessAnAnimal(View view) {
		Animal firstAnimal = new Animal("a pig", "Does it have a curly tail?",  true);
		firstAnimal.prevAnimal = null;
		firstAnimal.noAnimal = new Animal("a dog", "Does it have 4 legs?", true);
		// reverse-linked list traversal:
		firstAnimal.noAnimal.prevAnimal = firstAnimal;
		Game.firstAnimal = firstAnimal;
		Intent intent = new Intent(this, Guess.class);
		intent.putExtra(Animal.ANIMAL, firstAnimal);
		intent.putExtra("org.sinisterstuf.guesstheanimal.finalguess", false);
		startActivity(intent);
	}

}
