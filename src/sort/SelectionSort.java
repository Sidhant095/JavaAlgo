/**
 * 
 */
package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import DataSetup.CreateList;

/**
 * @author sidha
 *
 */
public class SelectionSort {
	/**
	 * @param args
	 */
	CreateList createList;
	Integer maxLength;
	Integer maxRecordValue;

	public SelectionSort(Integer maxLength, Integer maxRecordValue) {
		this.maxLength = maxLength;
		this.maxRecordValue = maxRecordValue;
	}

	public SelectionSort(CreateList createList) {
		// Data Setup
		this.createList = createList;
	}

	public void run(Integer runTimes) {
		Long startTime, endTime, duration;
		startTime = System.nanoTime();
		for (Integer index = 0; index < runTimes; index++) {
			createList = new CreateList(maxLength, maxRecordValue);
			sort();
		}
		endTime = System.nanoTime();
		duration = (endTime - startTime) / 1000000; // divide by 1000000 to get milliseconds.
		System.out.println("SelectionSort: " + duration);
	}

	ArrayList<Integer> swap(ArrayList<Integer> arrList, Integer i, Integer j) {
		Integer temp = arrList.get(i);
		arrList.set(i, arrList.get(j));
		arrList.set(j, temp);
		return arrList;
	}

	void sort() {

		ArrayList<Integer> arrList = createList.getList();

		// Selection Sort
		for (Integer i = 0; i < arrList.size(); i++) {
			Integer minSoFarIndex = i;
			for (Integer j = i; j < arrList.size(); j++) {
				if (arrList.get(minSoFarIndex) > arrList.get(j)) {
					minSoFarIndex = j;
				}
			}
			swap(arrList, minSoFarIndex, i);
//			System.out.println("arrList: " + arrList);
		}
		Boolean flag = false;
		ArrayList<Integer> arrSortedList = createList.getSortedList();
		for (Integer i = 0; i < arrList.size(); i++) {
			if(!arrSortedList.get(i).equals(arrList.get(i))) {
				flag = true;
			}
		}
		if(flag) {
			System.out.println("Not Sorted");
		}
//		System.out.println("Final arrList: " + arrList);

	}
}