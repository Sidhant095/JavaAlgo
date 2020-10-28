/**
 * 
 */
import DataSetup.CreateList;
import search.*;
/**
 * @author sidha
 *
 */
public class SearchClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CreateList createList = new CreateList(100000,100000000);
		BinarySearch binarySearch;
		LinearSearch linearSearch;
		JumpSearch jumpSearch;
		InterpolationSearch interpolationSearch;
		ExponentialSearch exponentialSearch;
		
		
//		linearSearch =  new LinearSearch(createList);
		linearSearch =  new LinearSearch(100, 1000000);
 
//		binarySearch =  new BinarySearch(createList);
		binarySearch =  new BinarySearch(100,1000000);
		
//		jumpSearch =  new JumpSearch(createList);
		jumpSearch =  new JumpSearch(100,1000000);
		
		
//		interpolationSearch = new InterpolationSearch(createList);
		interpolationSearch = new InterpolationSearch(100,1000000);
		
//		exponentialSearch = new ExponentialSearch(createList);
		exponentialSearch = new ExponentialSearch(1000,1000000);
		
		

		linearSearch.run(100000);
		binarySearch.run(100000);
		jumpSearch.run(100000);
		interpolationSearch.run(100000);
		exponentialSearch.run(10000);

	}

}
