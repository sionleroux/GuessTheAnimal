package org.sinisterstuf.guesstheanimal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class Lose extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lose);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.okButton)
    public void startNewGame() {
        Intent intent = new Intent(this, Guess.class);
        intent.putExtra(Animal.ANIMAL, Game.firstAnimal);
        intent.putExtra(Guess.FINAL_GUESS, false);
        startActivity(intent);
    }

}
