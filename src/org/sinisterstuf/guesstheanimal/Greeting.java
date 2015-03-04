package org.sinisterstuf.guesstheanimal;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

import org.sinisterstuf.guesstheanimal.Guess;

public class Greeting extends Activity {
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.greeting);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

	public void guessAnAnimal(View view) {
		Animal firstAnimal = new Animal("a pig", "Does it have a curly tail?",  true);
		firstAnimal.noAnimal = new Animal("a dog", "Does it have 4 legs?", true);
		Game.firstAnimal = firstAnimal;
		Intent intent = new Intent(this, Guess.class);
		intent.putExtra(Animal.ANIMAL, firstAnimal);
		intent.putExtra("org.sinisterstuf.guesstheanimal.finalguess", false);
		startActivity(intent);
	}

}
