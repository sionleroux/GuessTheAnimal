package org.sinisterstuf.guesstheanimal.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import org.sinisterstuf.guesstheanimal.Animal;
import org.sinisterstuf.guesstheanimal.Game;
import org.sinisterstuf.guesstheanimal.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class GreetingActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.greeting);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.okButton)
    public void guessAnAnimal(View view) {
        Animal firstAnimal = new Animal("a pig", "Does it have a curly tail?", true);
        firstAnimal.prevAnimal = null;
        firstAnimal.noAnimal = new Animal("a dog", "Does it have 4 legs?", true);
        // reverse-linked list traversal:
        firstAnimal.noAnimal.prevAnimal = firstAnimal;
        Game.firstAnimal = firstAnimal;
        Intent intent = new Intent(this, GuessActivity.class);
        intent.putExtra(Animal.ANIMAL, firstAnimal);
        intent.putExtra(GuessActivity.FINAL_GUESS, false);
        startActivity(intent);
    }

}
