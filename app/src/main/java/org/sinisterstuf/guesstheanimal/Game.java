package org.sinisterstuf.guesstheanimal;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Game {

	private static final String TAG = "AnimalGame";

	public static Animal firstAnimal;

	// Persist learnt animals to file
	public static void save(Context context) {
		String filename = "animals";
		FileOutputStream fileOut;
		ObjectOutputStream objectOut;
		try {
			fileOut = context.openFileOutput(filename, Context.MODE_PRIVATE);
			objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(Game.firstAnimal);
			objectOut.close();
		} catch (java.io.IOException e) {
			Log.wtf(TAG, "guessAnAnimal: internal file should always be writeable", e);
		}
	}

	public static void load(Context context) {
		File file = new File(context.getFilesDir().getPath(), "animals");
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
					context.getString(R.string.pig),
					context.getString(R.string.pig_question),
					true);
			firstAnimal.noAnimal = new Animal(
					context.getString(R.string.dog),
					context.getString(R.string.dog_question),
					true);
			// reverse-linked list traversal:
			firstAnimal.noAnimal.prevAnimal = firstAnimal;
			firstAnimal.prevAnimal = null;
		}
		Game.firstAnimal = firstAnimal;
	}

}
