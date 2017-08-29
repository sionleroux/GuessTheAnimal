package org.sinisterstuf.guesstheanimal.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.sinisterstuf.guesstheanimal.Animal;
import org.sinisterstuf.guesstheanimal.Game;
import org.sinisterstuf.guesstheanimal.R;

public class LearnYesNoActivity extends Activity {
	private Animal previous;
	private String name;
	private String question;
	private boolean prevReq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.learn_yesno);

        Intent intent = getIntent();
        previous = (Animal)intent.getSerializableExtra(Animal.ANIMAL);
        prevReq = intent.getBooleanExtra(Animal.NEXT_REQ, false);
        name = intent.getStringExtra(Animal.NAME);
        question = intent.getStringExtra(Animal.QUESTION);
        
        // set the text
        TextView learnText = (TextView)findViewById(R.id.learnText);
        String templateText = learnText.getText().toString();
        String fullText = String.format(templateText, name);
        learnText.setText(fullText);
    }
    
    public void parseYes(View view) {
    	learn(true);
    }
    
    public void parseNo(View view) {
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
