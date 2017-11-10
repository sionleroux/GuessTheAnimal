package org.sinisterstuf.guesstheanimal.ui;

import android.app.Activity;
import android.os.Bundle;

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
	public void guessAnAnimal() {
		Game.load(this);
		GuessActivity.start(this);
	}

}
