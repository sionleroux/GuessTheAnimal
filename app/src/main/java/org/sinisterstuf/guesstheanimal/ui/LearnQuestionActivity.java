package org.sinisterstuf.guesstheanimal.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import org.sinisterstuf.guesstheanimal.Animal;
import org.sinisterstuf.guesstheanimal.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LearnQuestionActivity extends Activity {

    @BindView(R.id.learnText)
    TextView learnText;
    @BindView(R.id.userInput)
    EditText userInput;

    private Animal previous;
    private boolean prevReq;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.learn_question);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        previous = (Animal) intent.getSerializableExtra(Animal.ANIMAL);
        prevReq = intent.getBooleanExtra(Animal.NEXT_REQ, false);
        name = intent.getStringExtra(Animal.NAME);

        // set the text
        String templateText = learnText.getText().toString();
        String fullText = String.format(templateText, name, previous.name);
        learnText.setText(fullText);
    }

    @OnClick(R.id.okButton)
    public void learn() {
        String question = userInput.getText().toString();
        Intent intent = new Intent(this, LearnYesNoActivity.class);
        intent.putExtra(Animal.ANIMAL, previous);
        intent.putExtra(Animal.NEXT_REQ, prevReq);
        intent.putExtra(Animal.NAME, name);
        intent.putExtra(Animal.QUESTION, question);
        startActivity(intent);
    }

}
