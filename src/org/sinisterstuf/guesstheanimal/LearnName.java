package org.sinisterstuf.guesstheanimal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LearnName extends Activity {
	
	private Animal previous;
	private boolean prevReq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.learn_name);
        Intent intent = getIntent();
        previous = (Animal)intent.getSerializableExtra(Animal.ANIMAL);
        prevReq = (boolean)intent.getBooleanExtra(Animal.NEXT_REQ, false);
    }
    
    public void learn(View view) {
    	EditText textInput = (EditText)findViewById(R.id.userInput);
    	String name = textInput.getText().toString();
    	Intent intent = new Intent(this, LearnQuestion.class);
    	intent.putExtra(Animal.NAME, name);
    	intent.putExtra(Animal.ANIMAL, previous);
    	intent.putExtra(Animal.NEXT_REQ, prevReq);
    	startActivity(intent);
    }
    
}
