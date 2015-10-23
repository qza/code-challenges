package codechallenges.java8;

import java.util.Arrays;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.BinaryOperator;

import java.util.stream.Collector;

import static java.lang.System.out;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class StreamsBasics {

	static List<String> namesOfTheCitizensInTheCity(List<Citizen> data, String city) {
		Predicate<Citizen> filterPredicate = x -> x.getCity().equals(city);
		Function<? super Citizen, ? extends String> mapFunction = Citizen::getName;
		Collector<String, ?, List<String>> listCollector = toList();
		return data.parallelStream().filter(filterPredicate).map(mapFunction).collect(listCollector);
	}

	static long maxNumberOfCitizensInCity(List<Citizen> data) {
		Map<String, Long> map = data.parallelStream().collect(groupingBy(Citizen::getCity, counting()));
		return map.values().parallelStream().reduce((x, y) -> Long.max(x, y)).get();
	}

	static void mostCommonNameAndTheCity(List<Citizen> citizens) {
		Map<String, Long> collect = citizens.parallelStream().collect(groupingBy(Citizen::toKey, counting()));
		BinaryOperator<Entry<String, Long>> reduceFunction = (e1, e2) -> e1.getValue() > e2.getValue() ? e1 : e2;
		Entry<String, Long> entry = collect.entrySet().parallelStream().reduce(reduceFunction).get();
		String name = entry.getKey().split("_")[0];
		String city = entry.getKey().split("_")[1];
		out.println("most common name: " + name + ", city: " + city + " (" + entry.getValue() + ")");
	}

	public static void main(String[] args) {

		Citizen citizen1 = new Citizen("mark", "newyork");
		Citizen citizen2 = new Citizen("john", "london");
		Citizen citizen3 = new Citizen("tom", "berlin");
		Citizen citizen3_2 = new Citizen("tom", "berlin");
		Citizen citizen4 = new Citizen("carl", "london");
		Citizen citizen5 = new Citizen("sharlote", "london");

		List<Citizen> citizenData = Arrays.asList(citizen1, citizen2, citizen3, citizen3_2, citizen4, citizen5);

		StreamsBasics.namesOfTheCitizensInTheCity(citizenData, "london").forEach((el) -> out.println("from london: " + el));

		System.out.println("max number of citizens in one city: " + StreamsBasics.maxNumberOfCitizensInCity(citizenData));

		StreamsBasics.mostCommonNameAndTheCity(citizenData);
	}

	/**
	 * Example Citizen entity
	 */
	static class Citizen {

		String name;
		String city;

		Citizen(String name, String city) {
			this.name = name;
			this.city = city;
		}

		public String getName() {
			return name;
		}

		public String getCity() {
			return city;
		}

		public String toKey() {
			return name + "_" + city;
		}

	}

}
