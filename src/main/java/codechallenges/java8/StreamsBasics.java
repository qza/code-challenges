package codechallenges.java8;

import java.util.Arrays;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

import java.util.stream.Collector;

import static java.lang.System.out;

import static java.util.stream.Collectors.toList;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class StreamsBasics {

	public static void namesOfTheCitizensInTheCity(List<Citizen> data, String city) {
		Predicate<Citizen> filterPredicate = x -> x.getCity().equals(city);
		Function<? super Citizen, ? extends String> mapFunction = Citizen::getName;
		Collector<String, ?, List<String>> listCollector = toList();
		List<String> names = data.parallelStream().filter(filterPredicate).map(mapFunction).collect(listCollector);
		names.forEach((el) -> out.println("from " + city + ": " + el));
	}

	public static void maxNumberOfCitizensInCity(List<Citizen> data) {
		Map<String, Long> map = data.parallelStream().collect(groupingBy(Citizen::getCity, counting()));
		Long maxNumber = map.values().parallelStream().reduce((x, y) -> Long.max(x, y)).get();
		out.println("max number of citizens in one city: " + maxNumber);
	}

	public static void mostCommonNameAndTheCity(List<Citizen> citizens) {
		Map<String, Long> collect = citizens.parallelStream().collect(groupingBy(Citizen::toKey, counting()));
		BinaryOperator<Entry<String, Long>> reduceFunction = (e1, e2) -> e1.getValue() > e2.getValue() ? e1 : e2;
		Entry<String, Long> entry = collect.entrySet().parallelStream().reduce(reduceFunction).get();
		String name = entry.getKey().split("_")[0];
		String city = entry.getKey().split("_")[1];
		out.println("most common name: " + name + ", city: " + city + " (" + entry.getValue() + ")");
	}

	public static void parallelism(List<Citizen> citizens) {

		ForkJoinPool commonPool = ForkJoinPool.commonPool();

		Predicate<Citizen> notNullFilter = c -> {
			logWithThread("filter " + c);
			return Optional.of(c).isPresent();
		};

		Function<Citizen, String> cityMapper = c -> {
			logWithThread("mapper " + c);
			return c.getCity();
		};

		BiFunction<String, String, String> cityAccumulator = (l, c) -> {
			logWithThread("accumulator " + c);
			return l + "," + c;
		};

		BinaryOperator<String> cityCombiner = (l1, l2) -> {
			logWithThread("combiner " + l1 + " / " + l2);
			return l1 + "," + l2;
		};

		String reduce = citizens.parallelStream().filter(notNullFilter).map(cityMapper).distinct().reduce("",
				cityAccumulator, cityCombiner);

		reduce = reduce.startsWith(",") ? reduce.substring(1) : reduce;
		reduce = reduce.endsWith(",") ? reduce.substring(0, reduce.length() - 1) : reduce;
		reduce = reduce.replace(",,", ",");

		out.println("\nparallelism:" + commonPool.getParallelism() + "\n");
		out.println("\nall city names: " + reduce);
	}

	public static void logWithThread(String logLine) {
		out.printf("%s\t%s", "(thread: " + Thread.currentThread().getId() + ")", logLine);
	}

	public static void main(String[] args) {

		Citizen citizen1 = new Citizen("mark", "newyork");
		Citizen citizen2 = new Citizen("john", "london");
		Citizen citizen3 = new Citizen("tom", "berlin");
		Citizen citizen4 = new Citizen("tom", "berlin");
		Citizen citizen5 = new Citizen("carl", "london");
		Citizen citizen6 = new Citizen("sharlote", "london");

		List<Citizen> citizenData = Arrays.asList(citizen1, citizen2, citizen3, citizen4, citizen5, citizen6);

		StreamsBasics.namesOfTheCitizensInTheCity(citizenData, "london");

		StreamsBasics.maxNumberOfCitizensInCity(citizenData);

		StreamsBasics.mostCommonNameAndTheCity(citizenData);

		StreamsBasics.parallelism(citizenData);
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

		@Override
		public String toString() {
			return name + " (" + city + ")";
		}

	}

}
