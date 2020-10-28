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
public class BubbleSort {
	/**
	 * @param args
	 */
	CreateList createList;
	Integer maxLength;
	Integer maxRecordValue;
	public BubbleSort(Integer maxLength, Integer maxRecordValue) {
		 this.maxLength = maxLength;
		 this.maxRecordValue = maxRecordValue;
	}
	public BubbleSort(CreateList createList) {
		// Data Setup
		this.createList = createList;
	}
	public void run(Integer runTimes) {
		Long startTime,endTime,duration ;
		startTime = System.nanoTime();
		for(Integer index = 0; index < runTimes; index++ ) {
			createList = new CreateList(maxLength,maxRecordValue);
			sort();
		}
		endTime = System.nanoTime();
		duration = (endTime - startTime)/1000000;  //divide by 1000000 to get milliseconds.
		System.out.println("BubbleSort: "+duration);
	}
	ArrayList<Integer> swap(ArrayList<Integer> arrList,Integer i,Integer j) {
		Integer temp = arrList.get(i);
		arrList.set(i, arrList.get(j));
		arrList.set(j, temp);
		return arrList;
	}
	void sort(){

		ArrayList<Integer> arrList  = createList.getList();
//		System.out.println("Initial arrList: "+arrList);
		//Selection Sort
		for(Integer i=0;i<arrList.size()-1;i++) {
			Boolean flag = false;
			for(Integer j=0;j<arrList.size()-i-1;j++) {
				if(arrList.get(j) > arrList.get(j+1)) {
//					System.out.println("SWAP "+j+","+(j+1)+" value: "+arrList.get(j)+","+arrList.get(j+1));
					swap(arrList,j+1,j);
					flag = true;
				}
			}
			if(!flag) {
				break;
			}
			
//			System.out.println("arrList: "+arrList);
		}
//		System.out.println("Final arrList: "+arrList);
		Boolean flag = false;
		ArrayList<Integer> arrSortedList = createList.getSortedList();
		for (Integer i = 0; i < arrList.size(); i++) {
			if(!arrSortedList.get(i).equals(arrList.get(i))) {
				flag = true;
			}
		}
		if(flag) {
			System.out.println("Not Sorted");
		}else {
//			System.out.println("Sorted");
		}

	}
}