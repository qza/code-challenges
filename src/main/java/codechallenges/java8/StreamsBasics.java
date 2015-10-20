package codechallenges.java8;

import java.util.Arrays;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import static java.lang.System.out;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class StreamsBasics {

	static List<String> namesOfTheCitizensInTheCity(List<Citizen> data, String city) {
		Predicate<Citizen> filter = x -> x.getCity().equals(city);
		return data.parallelStream().filter(filter).map(Citizen::getName).collect(toList());
	}

	static long maxNumberOfCitizensInCity(List<Citizen> data) {
		Map<String, Long> map = data.parallelStream().collect(groupingBy(Citizen::getCity, counting()));
		return map.values().parallelStream().reduce((x, y) -> Long.max(x, y)).get();
	}
	
	static void print(Citizen[] citizens) {
		Arrays.stream(citizens).map(Citizen::getName).forEach(out::println);
	}

	public static void main(String[] args) {

		Citizen citizen1 = new Citizen("mark", "newyork");
		Citizen citizen2 = new Citizen("john", "london");
		Citizen citizen3 = new Citizen("tom", "berlin");
		Citizen citizen4 = new Citizen("carl", "london");

		List<Citizen> citizenData = Arrays.asList(citizen1, citizen2, citizen3, citizen4);

		StreamsBasics.namesOfTheCitizensInTheCity(citizenData, "london").forEach((el) -> out.println(el));

		System.out.println(StreamsBasics.maxNumberOfCitizensInCity(citizenData));
		
		StreamsBasics.print(new Citizen[]{citizen1, citizen2});
	}

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
	}

}
