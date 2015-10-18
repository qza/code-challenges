package codechallenges.java8;

import java.util.Arrays;
import java.util.List;

import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;

import java.util.stream.Collectors;

public class FunctionsBasics {

	static List<String> filterNonEmpty(List<String> data) {
		Predicate<String> predicate = x -> x != null && !x.trim().isEmpty();
		return data.parallelStream().filter(predicate).collect(Collectors.toList());
	}

	static int sum(int[] data) {
		IntBinaryOperator intBinaryOperator = (x, y) -> x + y;
		return Arrays.stream(data).parallel().reduce(0, intBinaryOperator);
	}

	static int max(int[] data) {
		IntBinaryOperator intBinaryOperator = Integer::max;
		return Arrays.stream(data).parallel().reduce(0, intBinaryOperator);
	}

	public static void main(String[] args) {

		List<String> stringList = Arrays.asList("", "a", "", "b", "c", "", null, " ", "d");
		System.out.println("# = " + FunctionsBasics.filterNonEmpty(stringList).size());

		int[] sumData = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println("sum = " + FunctionsBasics.sum(sumData));

		int[] maxData = new int[] { 1, 7, 4, 6, 0, 8, 3, 9 };
		System.out.println("max = " + FunctionsBasics.max(maxData));

	}

}
