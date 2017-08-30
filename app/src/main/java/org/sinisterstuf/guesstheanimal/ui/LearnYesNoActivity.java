package org.sinisterstuf.guesstheanimal.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.sinisterstuf.guesstheanimal.Animal;
import org.sinisterstuf.guesstheanimal.Game;
import org.sinisterstuf.guesstheanimal.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LearnYesNoActivity extends Activity {

    @BindView(R.id.learnText)
    TextView learnText;

    private Animal previous;
    private String name;
    private String question;
    private boolean prevReq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.learn_yesno);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        previous = (Animal) intent.getSerializableExtra(Animal.ANIMAL);
        prevReq = intent.getBooleanExtra(Animal.NEXT_REQ, false);
        name = intent.getStringExtra(Animal.NAME);
        question = intent.getStringExtra(Animal.QUESTION);

        // set the text
        String templateText = learnText.getText().toString();
        String fullText = String.format(templateText, name);
        learnText.setText(fullText);
    }

    @OnClick(R.id.yesButton)
    public void parseYes() {
        learn(true);
    }

    @OnClick(R.id.noButton)
    public void parseNo() {
        learn(false);
    }

    private void learn(Boolean answerWhenMe) {
        Animal next = new Animal(name, question, answerWhenMe);
        next.prevAnimal = previous;

        if (prevReq) {
            previous.yesAnimal = next;
        } else {
            previous.noAnimal = next;
        }

        // Save first animal in list to Game.firstAnimal
        Animal first = next;
        while (true) {
            first = first.prevAnimal;
            if (first.prevAnimal == null) {
                break;
            }
        }
        Game.firstAnimal = first;

        Intent intent = new Intent(this, LoseActivity.class);
        startActivity(intent);
    }

}
