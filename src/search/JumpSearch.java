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
public class JumpSearch {
	/**
	 * @param args
	 */
	CreateList createList;
	Integer maxLength;
	Integer maxRecordValue;
	public JumpSearch(Integer maxLength, Integer maxRecordValue) {
		 this.maxLength = maxLength;
		 this.maxRecordValue = maxRecordValue;
	}
	public JumpSearch(CreateList createList) {
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
		System.out.println("JumpSearch: "+duration);
	}
	void search(){
		
		ArrayList<Integer> arrList  = new ArrayList<Integer>(Arrays.asList(9862792, 29845253, 50059825, 50546026, 51875150, 54825123, 74000547, 97945667)); 
				//createList.getSortedList();
		Integer toSearch = 54825123;//createList.getRandomIndex();
//		System.out.println("Size: "+arrList);
//		System.out.println("List Size: "+arrList.size());
//		System.out.println("To Search: "+toSearch);
		//Jump Search
		Integer maxHopSize = ((Double)Math.sqrt(arrList.size())).intValue();
//		System.out.println("maxHopSize : "+maxHopSize);
		Integer maxLength = arrList.size();
		Integer indexFound = -1;
		for(Integer i=0 ; i < maxLength ; i+=maxHopSize) {
//			System.out.println("index: "+i+", maxLength: "+maxLength+", Value: "+arrList.get(i));
			if(toSearch.equals(arrList.get(i))) {
				indexFound = i;
			}else if(toSearch < arrList.get(i)) {
				i -= maxHopSize;
				maxLength = i + maxHopSize;
				maxHopSize = 1;
//				System.out.println("New index: "+i+", maxLength: "+maxLength+", maxHopSize: "+maxHopSize);
			}
		}
		
//		System.out.println("indexFound: "+indexFound);
		if(indexFound > -1) {
//			System.out.println("Found at Index: "+indexFound+",");
		}else {
			System.out.println("Size: "+arrList);
			System.out.println("List Size: "+arrList.size());
			System.out.println("To Search: "+toSearch);
			System.out.println("****Not Found"+",");
		}
//		System.out.println();
	}
}