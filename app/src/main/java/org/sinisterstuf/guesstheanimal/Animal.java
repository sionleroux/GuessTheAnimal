package org.sinisterstuf.guesstheanimal;

import java.io.Serializable;

public class Animal implements Serializable {
	
	/**
	 * ID for keeping track of backwards compatibility.
	 */
	private static final long serialVersionUID = 3L;
	
	/**
	 * String name for referring to this class and its public fields
	 * when passing it with Intents.
	 */
	public static final String ANIMAL = "org.sinisterstuf.guesstheanimal.Animal";
	public static final String NAME = "org.sinisterstuf.guesstheanimal.Animal.name";
	public static final String QUESTION = "org.sinisterstuf.guesstheanimal.Animal.question";
	public static final String NEXT_REQ = "org.sinisterstuf.guesstheanimal.Animal.next_req";

	public String name;
	public String question;
	public Boolean answerWhenMe;
	public Animal yesAnimal = null;
	public Animal noAnimal = null;
	public Animal prevAnimal = null;
	
	public Animal(String name, String question, Boolean answerWhenMe) {
		this.name = name;
		this.question = question;
		this.answerWhenMe = answerWhenMe;
	}
	
}
