package quick.sort;

import java.util.Arrays;
import java.util.Random;
import static quick.sort.RQuickSort.swap;

/**
 *
 * @author student
 */
class RandQuickSort {

  // method to find the partition position
  static int partition(int array[], int low, int high,int pivot) {
    
    // choose the rightmost element as pivot
   
    
    // pointer for greater element
    int i = (low - 1);

    // traverse through all elements
    // compare each element with pivot
    for (int j = low; j < high; j++) {
      if (array[j] <= pivot) {

        // if element smaller than pivot is found
        // swap it with the greater element pointed by i
        i++;

        // swapping element at i with element at j
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
      }

    }

    // swapt the pivot element with the greater element specified by i
    int temp = array[i + 1];
    array[i + 1] = array[high];
    array[high] = temp;

    // return the position from where partition is done
    return (i + 1);
  }

  static void quickSort(int array[], int low, int high) {
      
      if (high- low <= 0)
                return;
       Random rand = new Random();

                int pivotIndex = low + rand.nextInt(high - low + 1);

                swap(pivotIndex, high);

                int pivot = array[high];
		System.out.println(" Pivot = " + pivot);
      
      
  

      // find pivot element such that
      // elements smaller than pivot are on the left
      // elements greater than pivot are on the right
      int pi = partition(array, low, high,pivot);
      System.out.println(Arrays.toString(array));
      // recursive call on the left of pivot
      quickSort(array, low, pi - 1);
      System.out.println(Arrays.toString(array));

      // recursive call on the right of pivot
      quickSort(array, pi + 1, high);
      System.out.println(Arrays.toString(array));
    
  }
}

// Main class
class MainC {
  public static void main(String args[]) {

    int[] data = { 8, 7, 2, 1, 0, 9, 6 };
    System.out.println("Unsorted Array");
    System.out.println(Arrays.toString(data));

    int size = data.length;

    // call quicksort() on array data
    RandQuickSort.quickSort(data, 0, size - 1);

    System.out.println("Sorted Array in Ascending Order ");
    System.out.println(Arrays.toString(data));
  }
}