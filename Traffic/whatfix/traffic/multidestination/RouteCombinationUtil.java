package whatfix.traffic.multidestination;

import java.util.ArrayList;
import java.util.List;

/**
 * This class helps to find out all possible permutations of route
 */
public class RouteCombinationUtil {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);

		System.out.println(getCombinationList(list));
	}

	public static List<List<Integer>> getCombinationList(List<Integer> inputList) {
		List<Integer> path = new ArrayList<>();
		List<List<Integer>> retList = new ArrayList<>();
		permutate(path, inputList, retList);
		return retList;
	}

	private static void permutate(List<Integer> path, List<Integer> list, List<List<Integer>> retList) {
		if (list.size() == path.size()) {
			retList.add(new ArrayList<>(path));
			return;
		}
		for (int i = 0; i < list.size(); i++) {
			Integer tmp = list.get(i);
			if (path.contains(tmp)) {
				continue;
			}
			path.add(tmp);
			permutate(path, list, retList);
			path.remove(tmp);
		}
	}

}
