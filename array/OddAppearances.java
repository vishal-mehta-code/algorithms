package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class <code>OddAppearances</code> for finding element/s that appear odd times
 * in an array.
 */
public class OddAppearances {

	public static void main(String[] args) {
		int[] array = { 1, 2, 4, 3, 4, 2, 5, 7, 10, 12, 10 };
		findOddAppearancesWithLists(array);
		findOddAppearancesWithMaps(array);
	}

	/**
	 * Finds Elements that appear odd no of times in given array.
	 * <P>
	 * Maintain a list. Will add the element if list does not contains it
	 * otherwise will remove that which simply means at its second/even
	 * occurrence. At the last we would left with elements that appear odd no of
	 * times.
	 * </p>
	 * 
	 * @param array
	 */
	private static void findOddAppearancesWithLists(int[] array) {
		List<Integer> list = new ArrayList<Integer>();
		// Iteration is o(n).
		for (int index = 0; index < array.length; index++) {
			Integer item = array[index];
			// List operations is o(n) as internal implementation is an array.
			if (list.contains(item)) {
				list.remove(item);
			} else {
				list.add(item);
			}

		}
		System.out.println("Elements that appear odd no of times are : " + list);
	}

	/**
	 * Finds Elements that appear odd no of times in given array.
	 * <P>
	 * Maintain a map. Iterate over the array and add elements in the map keyed
	 * on item and its no of appearances. If an element is already in map update
	 * the counter. Iterate over the map and find the elements that appears odd
	 * no of times.
	 * </p>
	 * 
	 * @param array
	 */
	private static void findOddAppearancesWithMaps(int[] array) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		// Iteration is o(n).
		for (int i = 0; i < array.length; i++) {
			Integer item = array[i];
			if (map.containsKey(item)) {
				map.put(item, map.get(item) + 1);
			} else {
				map.put(item, 1);
			}

		}

		// Worst case could be 0(n) where all elements appears odd no of times.
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() % 2 != 0) {
				System.out.println(entry.getKey() + " appears odd no of times");
			}

		}

	}

}
