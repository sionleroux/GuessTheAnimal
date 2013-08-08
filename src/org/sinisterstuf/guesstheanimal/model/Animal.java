package org.sinisterstuf.guesstheanimal.model;

public class Animal {
	
	public String name;
	public String question;
	public Boolean answerWhenMe;
	public Animal next;
	
	public Animal(String name, String question, Boolean answerWhenMe) {
		this.name = name;
		this.question = question;
		this.answerWhenMe = answerWhenMe;
		this.next = null;
	}
	
	public void addNext(Animal animal) {
		next = animal;
	}

}
