
/**
 * 
 */
import DataSetup.CreateList;
import sort.*;

/**
 * @author sidha
 *
 */
public class SortClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		SelectionSort selectionSort;
		BubbleSort bubbleSort;
		InsertionSort insertionSort;
		MergeSort mergeSort;

		selectionSort = new SelectionSort(1000, 1000000);
		bubbleSort = new BubbleSort(1000, 1000);
		insertionSort = new InsertionSort(1000, 1000);
		mergeSort = new MergeSort(1000,100);

		selectionSort.run(1000);
		bubbleSort.run(1000);
		insertionSort.run(1000);
		mergeSort.run(1000);

	}

}
