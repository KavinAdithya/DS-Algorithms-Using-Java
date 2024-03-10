package concept.dataStructure;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LinkedListTest {
    LinkedList<String> listName=new LinkedList<>();
    int n=-1;
    @BeforeAll
    public void showBefore(){
        System.out.println("Its A Linked List Designed By Techcrack Which is similar to Collection API LinkedList!!!");
    }
    @AfterAll
    public void showAfter(){
        System.out.println("All The Test Case Has Been SuccessFully Passed...");
    }
    @Test
    void add() {
        assertTrue(listName.add("Dharani"));
        assertTrue(listName.add("Kavin"));
        System.out.println("IN Add "+(++n));
    }

    @Test
    void size() {
        assertEquals(6,listName.size());
        System.out.println("In Size "+(++n));
    }

    @Test
    void isEmpty() {
        assertFalse(listName.isEmpty());
        System.out.println("In IsEmpty "+(++n));
    }

    @Test
    void get() {
        listName.add("Dharani");
        listName.add("Kavin");
        assertEquals("Kavin",listName.get(2));
        System.out.println("In Get "+(++n));
    }
    @Test
    void getException(){
        assertThrows(ArrayIndexOutOfBoundsException.class,()->listName.get(-1));
        System.out.println("In Get Exception "+(++n));
    }

    @Test
    void remove() {
        listName.add("Dharani");
        listName.add("Kavin");
        assertEquals("Kavin",listName.remove(1));
        System.out.println("IN remove "+(++n));
    }
    @Test
    void removeException(){
        assertThrows(ArrayIndexOutOfBoundsException.class,()->listName.remove(-1));
        System.out.println("In remove Exception "+(++n));
    }
}