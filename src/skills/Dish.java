package skills;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Dish {
	private final String name;
	private final boolean vegetarian;
	private final int calories;
	private final Type type;
	
	public Dish(String name, boolean vegetarian, int calories, Type type) {
		super();
		this.name = name;
		this.vegetarian = vegetarian;
		this.calories = calories;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public boolean isVegetarian() {
		return vegetarian;
	}

	public int getCalories() {
		return calories;
	}

	public Type getType() {
		return type;
	}

	@Override
	public String toString() {
		return "Dish [name=" + name + "]";
	}
	
	public enum Type {MEAT, FISH, OTHER}
	
	public static void main(String[] args) {
		List<Dish> menu = Arrays.asList(
				new Dish("pork", false, 800, Dish.Type.MEAT),
				new Dish("beef", false, 700, Dish.Type.MEAT),
				new Dish("chicken", false, 400, Dish.Type.MEAT),
				new Dish("french fries", true, 530, Dish.Type.OTHER),
				new Dish("rice", true, 350, Dish.Type.OTHER),
				new Dish("season fruit", true, 120, Dish.Type.OTHER),
				new Dish("pizza", true, 550, Dish.Type.OTHER),
				new Dish("prawns", false, 300, Dish.Type.FISH),
				new Dish("salmon", false, 450, Dish.Type.FISH)
				);
		
		List<String> highCaloricDish = menu.stream()
										 .filter(dish-> dish.getCalories() > 300)
										 .map(Dish::getName)
										 .collect(Collectors.toList());
		
		Optional<Dish> smallest = menu.stream().min(Comparator.comparing(Dish::getCalories));
				
	}
	
}

class Trader {
	private final String name;
	private final String city;
	
	public Trader(String n, String c) {
		name = n;
		city = c;
	}

	public String getName() {
		return name;
	}

	public String getCity() {
		return city;
	}
	
}

class Transaction {
	private final Trader trader;
	private final int year;
	private final int value;
	
	public Transaction(Trader trader, int year, int value) {
		super();
		this.trader = trader;
		this.year = year;
		this.value = value;
	}

	public Trader getTrader() {
		return trader;
	}

	public int getYear() {
		return year;
	}

	public int getValue() {
		return value;
	}
	
	
}

