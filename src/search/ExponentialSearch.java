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
public class ExponentialSearch {
	/**
	 * @param args
	 */
	CreateList createList;
	Integer maxLength;
	Integer maxRecordValue;
	public ExponentialSearch(Integer maxLength, Integer maxRecordValue) {
		 this.maxLength = maxLength;
		 this.maxRecordValue = maxRecordValue;
	}
	public ExponentialSearch(CreateList createList) {
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
		System.out.println("ExponentialSearch: "+duration);
	}
	void search(){
		
		ArrayList<Integer> arrList  = createList.getSortedList();
		Integer toSearch = createList.getRandomIndex();
//		System.out.println("Size: "+arrList);
//		System.out.println("List Size: "+arrList.size());
//		System.out.println("To Search: "+toSearch);
		//Jump Search
//		Integer maxHopSize = ((Double)Math.sqrt(arrList.size())).intValue();
//		System.out.println("maxHopSize : "+maxHopSize);
		Integer maxLength = arrList.size();
		Integer indexFound = -1;
		Integer i = 1;
		while(i<=maxLength){
//			System.out.println("index: "+i+", maxLength: "+maxLength+", Value: "+arrList.get(i-1));
			if(toSearch.equals(arrList.get(i-1))) {
				indexFound = i;
			}else if(toSearch < arrList.get(i-1)) {
				break;
			}
			i = i*2;
		}
//		System.out.println("i: "+i);
		Integer start= i/2,end=(i>maxLength)?maxLength-1:i-1;
		while(start<=end) {
			Integer index = (start+end)/2;
			Integer value = arrList.get(index);
//			System.out.println("Start: "+start+",End: "+end+",Index: "+index+",Value: "+value+",search: "+toSearch+" "+(toSearch == value));
			if(toSearch.equals(value)) {
				indexFound = index;
				break;
			}else {
				if(toSearch > value) {
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
			System.out.println("To Search: "+toSearch);
			System.out.println("****Not Found"+",");
		}
//		System.out.println();
	}
}