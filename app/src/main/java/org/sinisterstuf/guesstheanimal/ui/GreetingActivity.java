package org.sinisterstuf.guesstheanimal.ui;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import org.sinisterstuf.guesstheanimal.Animal;
import org.sinisterstuf.guesstheanimal.Game;
import org.sinisterstuf.guesstheanimal.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class GreetingActivity extends Activity {

	private static final String TAG = "AnimalGreeting";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.greeting);
		ButterKnife.bind(this);
	}

	@OnClick(R.id.okButton)
	public void guessAnAnimal() {
		File file = new File(getFilesDir().getPath(), "animals");
		Log.e("ANIMAL", "Filename: " + file.getPath());
		Animal firstAnimal = null;
		if (file.exists()) {
			// load animal data from storage
			try {
				FileInputStream fileIn = new FileInputStream(file);
				ObjectInputStream objectIn = new ObjectInputStream(fileIn);
				firstAnimal = (Animal)objectIn.readObject();
			} catch (java.io.IOException e) {
				Log.wtf(TAG, "guessAnAnimal: file should still exist", e);
			} catch (ClassNotFoundException e) {
				Log.wtf(TAG, "guessAnAnimal: file should be deserialiseable", e);
			}
		} else {
			// create example first animal
			firstAnimal = new Animal(
					getString(R.string.pig),
					getString(R.string.pig_question),
					true);
			firstAnimal.noAnimal = new Animal(
					getString(R.string.dog),
					getString(R.string.dog_question),
					true);
			// reverse-linked list traversal:
			firstAnimal.noAnimal.prevAnimal = firstAnimal;
			firstAnimal.prevAnimal = null;
		}
		Game.firstAnimal = firstAnimal;
		GuessActivity.start(this);
	}

}
