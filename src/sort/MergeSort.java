/**
 * 
 */
package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import DataSetup.CreateList;

/**
 * @author sidha
 *
 */
public class MergeSort {
	/**
	 * @param args
	 */
	CreateList createList;
	Integer maxLength;
	Integer maxRecordValue;
	ArrayList<Integer> arrList;

	public MergeSort(Integer maxLength, Integer maxRecordValue) {
		this.maxLength = maxLength;
		this.maxRecordValue = maxRecordValue;
		createList = new CreateList(maxLength, maxRecordValue);
		arrList = createList.getList();
//		System.out.println("arrList: " + arrList);
//		System.out.println("arrList: " + arrList.size());
	}

	public MergeSort(CreateList createList) {
		// Data Setup
		this.createList = createList;
	}

	public void run(Integer runTimes) {
		Long startTime, endTime, duration;
		startTime = System.nanoTime();
		if(runTimes == 1 ) {
			sort();
		}else {
			for (Integer index = 0; index < runTimes; index++) {
				this.arrList = createList.getList();
				sort();
			}
		}
		endTime = System.nanoTime();
		duration = (endTime - startTime) / 1000000; // divide by 1000000 to get milliseconds.
		System.out.println("MergeSort: " + duration);
	}

	ArrayList<Integer> swap(Integer i, Integer j) {
		Integer temp = this.arrList.get(i);
		this.arrList.set(i, this.arrList.get(j));
		this.arrList.set(j, temp);
		return this.arrList;
	}
	boolean compareAsc(Integer i, Integer j) {
		if(this.arrList.get(i) > this.arrList.get(j)) {
			return true;
		}
		else {
			return false;
		}
	}

	void sort() {
		// merge Sort
		merge(arrList,0,arrList.size()-1,0);
//		System.out.println("arrList: " + arrList);
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
	}
	void merge(ArrayList<Integer> arrList, Integer low, Integer high, Integer rec) {

		Integer mid = (low + high)/2;
//		System.out.println("merge "+rec+" low: " + low+", mid: " + mid+", high: " + high);
		if( low < high) {
			++rec;
			merge(arrList,low,mid,rec);
			merge(arrList,mid+1,high,rec);
			mergeSort(arrList,low,mid,high);
		}

	}
	void mergeSort(ArrayList<Integer> arrList, Integer low, Integer mid, Integer high) {
		//System.out.println("mergeSort low: " + low+", mid: " + mid+", high: " + high);
		
		Integer n1 = mid-low+1;
        Integer n2 = high - mid;
		
		List<Integer> left = new ArrayList<Integer>();
        left.addAll(arrList.subList(low, low + n1));
        
        List<Integer> right = new ArrayList<Integer>();
        right.addAll(arrList.subList(mid+1, mid + 1 + n2));
        
        
//        System.out.println("*left: " + left);
//        System.out.println("*right: " + right);
        Integer i = 0,j=0;
//        System.out.println("** arrList: " + arrList);
        while(i<n1 && j<n2) {
//        	System.out.print("*** left: " + left.get(i)+", right: " + right.get(j));
			if(left.get(i) > right.get(j)) {
//				System.out.print(", Using Right low: "+ low);
				arrList.set(low, right.get(j));
				j++;
			}else {
//				System.out.print(", Using Left low: "+ low);
				arrList.set(low, left.get(i));
				i++;
			}
//			System.out.println(", arrList: " + arrList);
			low++;
		}
//        System.out.println("**** arrList: " + arrList);
		while(i<n1) {
//			System.out.print("****** low : "+low +", i: " + i+", left value: "+ left.get(i));
			arrList.set(low, left.get(i));
			low++;i++;
//			System.out.println(", arrList: " + arrList);
		}
		while(j<n2) {
//			System.out.print("****** low : "+low +", j: " + j+", right value: "+ right.get(j));
			arrList.set(low, right.get(j));
			low++;j++;
//			System.out.println(", arrList: " + arrList);
		}
//		System.out.println("Afeter arrList: " + arrList);
	}
}