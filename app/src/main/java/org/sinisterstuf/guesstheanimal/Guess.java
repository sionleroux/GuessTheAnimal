package org.sinisterstuf.guesstheanimal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Guess extends Activity {

    @BindView(R.id.guessText)
    TextView guessText;

    private Animal animal;
    boolean finalGuess;
    boolean prevReq;
    public static final String FINAL_GUESS = "org.sinisterstuf.guesstheanimal.finalguess";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guess);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        finalGuess = intent.getBooleanExtra(FINAL_GUESS, false);
        prevReq = intent.getBooleanExtra(Animal.NEXT_REQ, false);
        animal = (Animal) intent.getSerializableExtra(Animal.ANIMAL);

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
            Intent intent = new Intent(this, Win.class);
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

    /**
     * Compares the user's <code>choice</code> to the desired answer for this
     * <code>Animal</code> from <code>Animal.answerWhenMe</code>
     *
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
                learnNewAnimal(choice);
            } else {
                Intent intent = new Intent(this, Guess.class);
                intent.putExtra(Animal.ANIMAL, next);
                intent.putExtra(Animal.NEXT_REQ, choice);
                intent.putExtra(FINAL_GUESS, false);
                startActivity(intent);
            }
        }
    }

    /**
     * Start a new activity to learn an animal
     */
    private void learnNewAnimal(Boolean nextReq) {
        Intent intent = new Intent(this, LearnName.class);
        intent.putExtra(Animal.ANIMAL, animal);
        intent.putExtra(Animal.NEXT_REQ, nextReq);
        startActivity(intent);
    }

}
