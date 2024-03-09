package concept.dataStructure;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SortingTest {
    Sorting sort=new Sorting();
    Integer[] actual={43,3,5,19,17,7};
    Integer[] expected={3,5,7,17,19,43};
    Double[] actual1={5.5,3.6,5.6,43.2,17.1};
    Double[] expected1={3.6,5.5,5.6,17.1,43.2};
    @Test
    void bubbleSort() {
        assertArrayEquals(expected,sort.<Integer>bubbleSort(actual));
    }

    @Test
    void selectionSort() {
        assertArrayEquals(expected,sort.<Integer>selectionSort(actual));
    }

    @Test
    void insertionSort() {
        assertArrayEquals(expected,sort.<Integer>insertionSort(actual));
    }

    @Test
    void quickSort() {
        System.out.print("Before Sorting Of An Array : ");
        for(Integer value:actual){
            System.out.print(value+" ");
        }
        sort.<Integer>quickSort(actual,0,actual.length-1);
        System.out.print("\nAfter Sorting Of An Array : ");
        for(Integer value:actual){
            System.out.print(value+" ");
        }
       // fail("Suumma fail panuraha???..");
    }

    @Test
    void mergeSort() {
        System.out.print("Before Sorting Of An Array : ");
        for(Integer value:actual){
            System.out.print(value+" ");
        }
        sort.<Integer>mergeSort(actual,0,actual.length-1);
        System.out.print("\nAfter Sorting Of An Array : ");
        for(Integer value:actual){
            System.out.print(value+" ");
        }
    }

    @Test
    void shellSort() {
        //assertArrayEquals(expected,sort.<Integer>shellSort(actual));
        Integer arr[]={45,78,56,96,68,13};
        System.out.println();
        sort.<Integer>shellSort(arr);
    }
}