package DataSetup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class CreateList {
	private ArrayList<Integer> arrList;
	private ArrayList<Integer> arrSortedList;
//	private Integer randomIndex;
	Random rand;
	public CreateList(Integer maxLength, Integer maxRecordValue) {
		rand = new Random();
		Integer size = rand.nextInt(maxLength);
		while(size == 0) {
			size = rand.nextInt(maxLength);
		}
		arrList = new ArrayList<Integer>();// Arrays.asList(10,11)
		for (Integer i = 0; i < size; i++) {
			arrList.add(rand.nextInt(maxRecordValue));
		}
		arrSortedList = new ArrayList<Integer>();
		arrSortedList.addAll(arrList);
		Collections.sort(arrSortedList);
	}

	public ArrayList<Integer> getList() {
		return arrList;
	}
	public ArrayList<Integer> getSortedList() {
		return arrSortedList;
	}

	public Integer getRandomIndex() {
		rand = new Random();
		Integer arrSize = arrList.size();
		Integer index = rand.nextInt(arrSize);
		Integer data = arrList.get(index);

		return data;
	}
}
