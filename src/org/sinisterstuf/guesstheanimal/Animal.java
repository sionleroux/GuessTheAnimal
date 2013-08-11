package org.sinisterstuf.guesstheanimal;

import java.io.Serializable;

public class Animal implements Serializable {
	
	/**
	 * ID for keeping track of backwards compatibility.
	 */
	private static final long serialVersionUID = 2L;
	
	/**
	 * String name for referring to this class when passing it with Intents.
	 */
	public static String ANIMAL = "org.sinisterstuf.guesstheanimal.Animal";

	public String name;
	public String question;
	public Boolean answerWhenMe;
	public Animal yesAnimal = null;
	public Animal noAnimal = null;
	
	public Animal(String name, String question, Boolean answerWhenMe) {
		this.name = name;
		this.question = question;
		this.answerWhenMe = answerWhenMe;
	}
	
}
