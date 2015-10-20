package codechallenges.java8;

import java.util.Arrays;
import java.util.List;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

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

	static Callable<String> sayCallable(String sayWhat) {
		return () -> {
			return sayWhat;
		};
	}

	public static void main(String[] args) throws Exception {

		List<String> stringList = Arrays.asList("", "a", "", "b", "c", "", null, " ", "d");
		System.out.println("# = " + FunctionsBasics.filterNonEmpty(stringList).size());

		int[] sumData = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println("sum = " + FunctionsBasics.sum(sumData));

		int[] maxData = new int[] { 1, 7, 4, 6, 0, 8, 3, 9 };
		System.out.println("max = " + FunctionsBasics.max(maxData));

		Future<String> callableResponse = Executors.newSingleThreadExecutor().submit(FunctionsBasics.sayCallable("hi"));
		System.out.println("callable: " + callableResponse.get());
	}

}
