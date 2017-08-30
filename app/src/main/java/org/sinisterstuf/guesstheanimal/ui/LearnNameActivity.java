package org.sinisterstuf.guesstheanimal.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import org.sinisterstuf.guesstheanimal.Animal;
import org.sinisterstuf.guesstheanimal.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LearnNameActivity extends Activity {

	@BindView(R.id.userInput)
	EditText userInput;

	private Animal previous;
	private boolean prevReq;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.learn_name);
		ButterKnife.bind(this);
		Intent intent = getIntent();
		previous = (Animal) intent.getSerializableExtra(Animal.ANIMAL);
		prevReq = intent.getBooleanExtra(Animal.NEXT_REQ, false);
	}

	@OnClick(R.id.okButton)
	public void learn() {
		String name = userInput.getText().toString();
		if(userInput.getText().toString().trim().equals("")) {
			userInput.setError(getString(R.string.missing_name));
		} else {
			Intent intent = new Intent(this, LearnQuestionActivity.class);
			intent.putExtra(Animal.NAME, name);
			intent.putExtra(Animal.ANIMAL, previous);
			intent.putExtra(Animal.NEXT_REQ, prevReq);
			startActivity(intent);
		}
	}

}
