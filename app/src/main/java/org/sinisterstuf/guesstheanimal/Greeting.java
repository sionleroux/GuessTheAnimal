package org.sinisterstuf.guesstheanimal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class Greeting extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.greeting);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.okButton)
    public void guessAnAnimal() {
        Animal firstAnimal = new Animal("a pig", "Does it have a curly tail?", true);
        firstAnimal.prevAnimal = null;
        firstAnimal.noAnimal = new Animal("a dog", "Does it have 4 legs?", true);
        // reverse-linked list traversal:
        firstAnimal.noAnimal.prevAnimal = firstAnimal;
        Game.firstAnimal = firstAnimal;
        Intent intent = new Intent(this, Guess.class);
        intent.putExtra(Animal.ANIMAL, firstAnimal);
        intent.putExtra(Guess.FINAL_GUESS, false);
        startActivity(intent);
    }

}
