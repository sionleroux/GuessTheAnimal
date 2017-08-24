package org.sinisterstuf.guesstheanimal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class LearnQuestion extends Activity {
	
	private Animal previous;
	private boolean prevReq;
	private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.learn_question);

        Intent intent = getIntent();
        previous = (Animal)intent.getSerializableExtra(Animal.ANIMAL);
        prevReq = (boolean)intent.getBooleanExtra(Animal.NEXT_REQ, false);
        name = intent.getStringExtra(Animal.NAME);
        
        // set the text
        TextView learnText = (TextView)findViewById(R.id.learnText);
        String templateText = learnText.getText().toString();
        String fullText = String.format(templateText, name, previous.name);
        learnText.setText(fullText);
    }
    
    public void learn(View view) {
    	EditText textInput = (EditText)findViewById(R.id.userInput);
    	String question = textInput.getText().toString();
    	Intent intent = new Intent(this, LearnYesNo.class);
    	intent.putExtra(Animal.ANIMAL, previous);
    	intent.putExtra(Animal.NEXT_REQ, prevReq);
    	intent.putExtra(Animal.NAME, name);
    	intent.putExtra(Animal.QUESTION, question);
    	startActivity(intent);
    }

}
