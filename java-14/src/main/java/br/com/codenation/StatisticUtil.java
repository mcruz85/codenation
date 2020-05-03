package br.com.codenation;

import java.util.*;
import java.util.stream.Collectors;

public class StatisticUtil {

	public static int average(int[] elements) {
		int sum = 0;
		for (int i = 0; i < elements.length; i++) {
			sum += elements[i];
		}
		return sum / elements.length;
	}

	public static int mode(int[] elements) {

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		toList(elements)
				.stream()
				.forEach((i) ->{
					if (!map.containsKey(i)) {
						map.put(i, 0);
					}
					map.put(i, map.get(i) + 1);
				});

		Map.Entry<Integer, Integer> entry = map.entrySet()
				.stream()
				.max(Comparator.comparing(Map.Entry::getValue))
				.get();


		return entry.getKey();
	}

	public static int median(int[] elements) {
		List<Integer> list = toList(elements);
		list = list.stream()
				.sorted()
				.collect(Collectors.toList());

		int metade = list.size() / 2;
		boolean isImpar = list.size() % 2 == 1;
		if (isImpar) {
			return list.get(metade);
		}

		return (list.get(metade) + list.get(metade -1)) / 2;
	}

	private static List<Integer> toList(int[] elements){
		return Arrays.stream(elements).boxed().collect(Collectors.toList());
	}

	public static void main(String[] args) {
		int mode = StatisticUtil.mode(new int[]{1, 2, 2, 3, 3, 1, 9, 3, 9});
		System.out.println("mode: " + mode);
		System.out.println(StatisticUtil.mode(new int[] {1,2,3,3}));
	}
}