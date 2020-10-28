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
public class BinarySearch {
	/**
	 * @param args
	 */
	CreateList createList;
	Integer maxLength;
	Integer maxRecordValue;
	public BinarySearch(Integer maxLength, Integer maxRecordValue) {
		 this.maxLength = maxLength;
		 this.maxRecordValue = maxRecordValue;
	}
	public BinarySearch(CreateList createList) {
		// Data Setup
		this.createList = createList;
	}
	public void run(Integer runTimes) {
		Long startTime,endTime,duration ;
		startTime = System.nanoTime();
		for(Integer index = 0; index < runTimes; index++ ) {
			createList = new CreateList(maxLength,maxRecordValue);
			search();
		}
		endTime = System.nanoTime();
		duration = (endTime - startTime)/1000000;  //divide by 1000000 to get milliseconds.
		System.out.println("BinarySearch: "+duration);
	}
	void search(){

		ArrayList<Integer> arrList  = createList.getSortedList();

		Integer search = createList.getRandomIndex();
		
		//Binary Search
		Integer start= 0,end=arrList.size()-1,indexFound=-1;
		while(start<=end) {
			Integer index = (start+end)/2;
			Integer value = arrList.get(index);
			//System.out.println("Start: "+start+",End: "+end+",Index: "+index+",Value: "+value+",search: "+search+" "+(search == value));
			if(search.equals(value)) {
				indexFound = index;
				break;
			}else {
				if(search > value) {
					start = index+1;
				}else {
					end = index-1;
				}
			}
		}
//		System.out.println("indexFound: "+indexFound);
		if(indexFound > -1) {
//			System.out.println("Found at Index: "+indexFound+",");
		}else {
			System.out.println("Size: "+arrList);
			System.out.println("List Size: "+arrList.size());
			System.out.println("To Search: "+search);
			System.out.println("****Not Found"+",");
		}
//		System.out.println();
	}
}