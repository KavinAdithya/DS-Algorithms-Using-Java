package concept.dataStructure;

import com.techcrack.DSA.ArrayBinarySearch.MaximumYear;
import org.junit.jupiter.api.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ArrayListTest {
    ArrayList<Integer> list=new ArrayList<>(15);
    @Test
    void add() {
        assertTrue(list.add(90));
    }

    @Test
    void set() {
        list.add(19);
        assertTrue(list.set(0,43));
    }

    @Test
    void size() {
        assertNotEquals(1,list.size(),"Size has been Matched");
    }

    @Test
    void addAll() throws Exception{
        System.out.println("In Add All");
        ArrayList<Integer> list1=new ArrayList<>(3);
        list1.add(2);
        list1.add(9);
        list1.add(24);
        assertTrue(list.addAll(list1));
    }

    @Test
    void indexAdd() {
        System.out.println("It Was last I Think...");
        list.add(1);
        list.add(3);
        list.add(4);
        assertFalse(false);
        assertTrue(true,()->"ReQuire True!!!");
        assertFalse(false,()->"ReQuire False!!!");
        assertTrue(list.add(1,2));
    }

    @Test
    void get()  {
        list.add(89);
        assertThrows(Exception.class,()->list.get(222));
        //assertEquals(19,list.get(0));
    }
    @Test
    void getMembersAsArray() {
        list.add(10);
        list.add(20);
//        for(int k=0;k<list.size();k++){
//            System.out.println(list.get(k));
//        }
        Integer []listExpected={2,9,24,10,20};
        assertArrayEquals(listExpected,list.getMembersAsArray());
    }
    @Test
    void printArray(){
        assertTimeout(Duration.ofMillis(26),()->list.printArray());
    }

    @Test
    void clear() {
        assertTrue(list.clear());
    }

    @Test
    void isEmpty() {
        assertTrue(list.isEmpty());
    }

    @Test
    void containsAll() {
        list.add(12);
        list.add(19);
        list.add(43);
        ArrayList<Integer> list1=new ArrayList<>();
        list1.add(12);
        list1.add(19);
        assertTrue(list.containsAll(list1));
    }

    @Test
    void contains() {
        list.add(19);
        list.add(43);
        assertTrue(list.contains(19));
    }

    @Test
    void retainAll() {
        list.add(19);
        list.add(43);
        ArrayList<Integer> list1=new ArrayList();
        list1.add(19);
        assertEquals(2,list.size());
        assertTrue(list.retainAll(list1));
        assertEquals(1,list.size());
    }


    @Test
    public void maximumYearTest(){
        MaximumYear my=new MaximumYear();

        int[][] actual={
            {1982,1998},
            {2013,2042},
            {2010,2035},
            {2022,2050},
            {2047,2048}
        };

        int[][] actual1={
           {1993,1999},
           {2000,2010}
        };

        int[][] actual2={
            {1950,1961},
            {1960,1971},
            {1970,1981}
        };
        int[][] actual3={
            {1987,2047},
            {1952,2006},
            {2021,2042},
            {2047,2049},
            {2036,2040},
            {1994,2009}
        };
        assertEquals(2022,my.maximumPopulation(actual));
        assertEquals(1993,my.maximumPopulation(actual1));
        assertEquals(1960,my.maximumPopulation(actual2));
        assertEquals(1994,my.maximumPopulation(actual3));

    }
}