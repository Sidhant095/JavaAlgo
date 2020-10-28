/**
 * 
 */
package search;

import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Random;
import DataSetup.CreateList;

/**
 * @author sidha
 *
 */
public class LinearSearch {

	/**
	 * @param args
	 */
	CreateList createList;
	Integer maxLength;
	Integer maxRecordValue;
	public LinearSearch(Integer maxLength, Integer maxRecordValue) {
		 this.maxLength = maxLength;
		 this.maxRecordValue = maxRecordValue;
	}
	public LinearSearch(CreateList createList) {
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
		System.out.println("LinearSearch: "+duration);
	}
	void search(){
		// Data Setup
		ArrayList<Integer> arrList  = createList.getList();
		//System.out.println("List: "+arrList);
//		System.out.println("List Size: "+arrList.size());
		Integer search = createList.getRandomIndex();
//		System.out.println("To Search: "+search);
		
		//Linear Search
		Integer indexFound = -1;
		for(Integer index = 0; index < arrList.size(); index++ ) {
			if(search == arrList.get(index)) {
				indexFound = index;
				break;
			}
		}
		if(indexFound > -1) {
//			System.out.println("Found at Index: "+indexFound+",");
		}else {
			System.out.println("Not Found"+",");
		}
//		System.out.println();
		//System.out.println();
	}

}
