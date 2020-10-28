/**
 * 
 */
package search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import DataSetup.CreateList;

/**
 * @author sidha
 *
 */
public class InterpolationSearch {
	/**
	 * @param args
	 */
	CreateList createList;
	Integer maxLength;
	Integer maxRecordValue;

	public InterpolationSearch(Integer maxLength, Integer maxRecordValue) {
		this.maxLength = maxLength;
		this.maxRecordValue = maxRecordValue;
	}

	public InterpolationSearch(CreateList createList) {
		// Data Setup
		this.createList = createList;
	}

	public void run(Integer runTimes) {
		Long startTime, endTime, duration;
		startTime = System.nanoTime();
		for (Integer index = 0; index < runTimes; index++) {

			createList = new CreateList(maxLength, maxRecordValue);

			search();

		}
		endTime = System.nanoTime();
		duration = (endTime - startTime) / 1000000; // divide by 1000000 to get milliseconds.
		System.out.println("InterpolationSearch: " + duration);
	}

	void search() {

		ArrayList<Integer> arrList = createList.getSortedList();

		Integer toSearch = createList.getRandomIndex();
//		System.out.println("Size: " + arrList);
//		System.out.println("List Size: " + arrList.size());
//		System.out.println("To Search: " + toSearch);
		// Binary Search
		Integer start = 0, end = arrList.size() - 1, indexFound = -1;
		try {
			while (start <= end) {
				if (start == end && toSearch.equals(arrList.get(start))) {
					indexFound = start;
					break;
				}
				Integer index = 0;
				Integer a1 = toSearch - arrList.get(start);
				Integer a2 = end - start;
				Integer a3 = arrList.get(end) - arrList.get(start);
				Integer a4 = (a2 / (a3==0?1:a3)) * a1;
				// Double a5 = a4/a3;
//				System.out.println("Start: " + start + ",a1: " + a1+",a2: " + a2+",a3: " + a3+",a4: " + a4);
//				try {
				index = start + a4;
//				System.out.println("index: " + index);
//				} catch (Exception e) {
//					return;
//				}
				Integer value = arrList.get(index);
//				System.out.println("Start: " + start + ",End: " + end + ",Index: " + index + ",Value: " + value + ",search: " + toSearch + " " + (toSearch.equals(value)));
				if (toSearch.equals(value)) {
					indexFound = index;
					break;
				} else {
					if (toSearch > value) {
						start = index + 1;
					} else {
						end = index - 1;
					}
				}
			}
			if (indexFound > -1) {
//			System.out.println("Found at Index: "+indexFound+",");
			} else {

				System.out.println("****Not Found" + ",");
			}
//		System.out.println();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			System.out.println("Error: " + e.getCause());
		}
	}
}