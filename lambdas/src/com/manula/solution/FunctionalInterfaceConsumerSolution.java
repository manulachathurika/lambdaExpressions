package com.manula.solution;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import models.Person;

public class FunctionalInterfaceConsumerSolution {

	public static void main(String[] args) {
		
		List<Person> people = Arrays.asList(
					new Person("Charles", "Dickens", 42),
					new Person("Lewis", "Carroll", 42),
					new Person("Thomas", "Carlyle", 51),
					new Person("Charlotte", "Bronte", 45),
					new Person("Matthew", "Arnold", 39)
				);
		
		// Step 1 : Sort list by last name
		Collections.sort(people, (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));
		
		// Step 2 : Create a method that prints all elements in the list
		System.out.println("Printing all persons");
		performConditionally(people, p -> true, System.out::println);
		
		// Step 3 : Create a method that prints all people that have last name beginning with C
		System.out.println("\nPrinting all persions with last name begging with C");
		performConditionally(people, p -> p.getLastName().startsWith("C"), p -> System.out.println(p));
		
		System.out.println("\nPrinting all persions with first name begging with C");
		performConditionally(people, p -> p.getFirstName().startsWith("C"), p -> System.out.println(p.getFirstName()));
	}

	private static void performConditionally(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer) {
		for (Person p : people) {
			if (predicate.test(p)) {
				consumer.accept(p);
			}
		}
	}
}

