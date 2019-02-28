/*
	Author: Adam Carling
	Date: 02/27/19


	Description: Two generic Quicksort methods. one uses comparator, the other uses comparable. 
*/

import java.util.*;


public class QuickSort {
	
	public static <E extends Comparable<E>> void quickSort(E[] list) {
		quickSort(list, 0, list.length -1);
	}
	
	public static <E extends Comparable<E>> void quickSort(E[] list, int first, int last) {
		if (last > first){
			int pivotIndex = partition(list, first, last);
			quickSort(list, first, pivotIndex - 1);
			quickSort(list, pivotIndex + 1, last);
		}
	}
	
	/** Partition the array list[first..last] */
	public static <E extends Comparable<E>> int partition(E[] list, int first, int last) {
	E pivot = list[first]; // Choose the first element as the pivot 17 int low = first + 1; // Index for forward search
	int high = last; // Index for backward search
	int low = 0;
	 while (high > low) {
	 // Search forward from left
		 while (low <= high && list[low].compareTo(pivot) <= 0)
			 low++;
		
		 // Search backward from right
		 while (low <= high && list[high].compareTo(pivot) > 0)
		 	high--;
		
		if (high > low){
			E temp = list[high];
			list[high] = list[low];
			list[low] = temp;
		}
	}
	
	while (high > first && list[high].compareTo(pivot) >= 0)
		high--;
		// Swap pivot with list[high]
	if (pivot.compareTo(list[high]) > 0) { 
		list[first] = list[high]; 
		list[high] = pivot;
		 return high;
	}
	else {
		return first;
		}
	}
//}




/******New Class*********/
//public class QuickSortComparator {
		
		public static <E> void quickSort(E[] list, Comparator<? super E> comparator) {
			quickSort(list, 0, list.length -1, comparator);
		}
		
		public static <E> void quickSort(E[] list,  int first, int last, Comparator<? super E> comparator) {
			if (last > first){
				int pivotIndex = partition(list, first, last, comparator);
				quickSort(list, first, pivotIndex - 1, comparator);
				quickSort(list, pivotIndex + 1, last, comparator);
			}
		}
		
		/** Partition the array list[first..last] */
		public static <E> int partition(E[] list, int first, int last, Comparator<? super E> comparator) {
		E pivot = list[first]; // Choose the first element as the pivot 17 int low = first + 1; // Index for forward search
		int high = last; // Index for backward search
		int low = 0;
		 while (high > low) {
		 // Search forward from left
			 while (low <= high && comparator.compare(list[low], pivot) <= 0)
				 low++;
			
			 // Search backward from right
			 while (low <= high && comparator.compare(list[high], pivot) > 0)
			 	high--;
			
			if (high > low){
				E temp = list[high];
				list[high] = list[low];
				list[low] = temp;
			}
		}
		
		while (high > first && comparator.compare(list[high], pivot) >= 0)
			high--;
			// Swap pivot with list[high]
		if (comparator.compare(pivot, list[high]) > 0) { 
			list[first] = list[high]; 
			list[high] = pivot;
			 return high;
		}
		else {
			return first;
			}
		}		
 }




