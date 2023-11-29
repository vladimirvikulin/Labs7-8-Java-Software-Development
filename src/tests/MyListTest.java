package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exceptions.ExceptionHandler;
import list.MyList;
import sweets.Candy;
import sweets.Lollipop;
import sweets.Sweet;
import sweets.Waffle;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MyListTest {
    private MyList myList;
    private Candy sweet1;
    private Waffle sweet2;
    private Lollipop sweet3;

    @BeforeEach
    void setUp() {
        myList = new MyList();
        sweet1 = new Candy("Candy1", 50.0, 1, 50, "Sweet", 30.0, true);
        sweet2 = new Waffle("Candy2", 40.0, 2, 0, "Chocolate", 50.0, "American");
        sweet3 = new Lollipop("Candy3", 60.0, 3, 75, "Fruity", 20.0, "Star");
    }

    @AfterEach
    void clear() {
        myList.clear();
    }

    @Test
    void testAdd() {
        assertTrue(myList.add(sweet1));
        assertTrue(myList.contains(sweet1));
        assertEquals(1, myList.size());
    }


    @Test
    void testAddInvalidElement() {
        sweet1 = null;

        ExceptionHandler exception = assertThrows(ExceptionHandler.class, () -> myList.add(sweet1));
        assertEquals("Sweet is null", exception.getMessage());
    }

    @Test
    void testRemove() {
        myList.add(sweet1);
        assertTrue(myList.remove(sweet1));
        assertFalse(myList.contains(sweet1));
        assertEquals(0, myList.size());
    }

    @Test
    void testRemoveInvalidElement() {
        sweet1 = null;
        ExceptionHandler exception = assertThrows(ExceptionHandler.class, () -> myList.remove(sweet1));
        assertEquals("Sweet is null", exception.getMessage());
    }

    @Test
    void testSet() {
        myList.add(sweet1);
        assertEquals(sweet1, myList.set(0, sweet2));
        assertEquals(sweet2, myList.get(0));
    }

    @Test
    void testSetInvalidIndex() {
        myList.addAll(Arrays.asList(sweet1, sweet2, sweet3));

        ExceptionHandler exception = assertThrows(ExceptionHandler.class, () -> myList.set(5, sweet2));
        assertEquals("Index is out of range", exception.getMessage());
    }

    @Test
    void testAddAtIndex() {
        myList.add(sweet1);
        myList.add(0, sweet2);
        assertEquals(sweet2, myList.get(0));
        assertEquals(sweet1, myList.get(1));
    }

    @Test
    void testAddInvalidIndex() {
        myList.addAll(Arrays.asList(sweet1, sweet2, sweet3));

        ExceptionHandler exception = assertThrows(ExceptionHandler.class, () -> myList.add(5, sweet2));
        assertEquals("Index is out of range", exception.getMessage());
    }


    @Test
    void testRemoveAtIndex() {
        myList.addAll(Arrays.asList(sweet1, sweet2, sweet3));
        assertEquals(sweet2, myList.remove(1));
        assertEquals(sweet1, myList.get(0));
        assertEquals(sweet3, myList.get(1));
        assertEquals(2, myList.size());
    }

    @Test
    void testRemoveInvalidIndex() {
        myList.addAll(Arrays.asList(sweet1, sweet2, sweet3));

        ExceptionHandler exception = assertThrows(ExceptionHandler.class, () -> myList.remove(5));
        assertEquals("Index is out of range", exception.getMessage());
    }

    @Test
    void testContainsAll() {
        myList.add(sweet1);
        myList.add(sweet2);

        Sweet[] sweetsArray = {sweet1, sweet2};
        assertTrue(myList.containsAll(Arrays.asList(sweetsArray)));

        Sweet sweet3 = new Sweet("Candy3", 60.0, 3, 75, "Fruity", 20.0);
        assertFalse(myList.containsAll(Arrays.asList(sweetsArray, sweet3)));
    }

    @Test
    void testContainsAllWithNullCollection() {
        myList.add(sweet1);
        myList.add(sweet2);
    
        ExceptionHandler exception = assertThrows(ExceptionHandler.class, () -> myList.containsAll(null));
        assertEquals("Error while checking containment for all elements", exception.getMessage());
    }

    @Test
    void testClear() {
        myList.add(sweet1);
        myList.add(sweet2);

        myList.clear();

        assertTrue(myList.isEmpty());
        assertEquals(0, myList.size());
    }

    @Test
    void testGet() {
        myList.add(sweet1);
        myList.add(sweet2);

        assertEquals(sweet1, myList.get(0));
        assertEquals(sweet2, myList.get(1));
    }

    @Test
    void testGetInvalidIndex() {
        myList.addAll(Arrays.asList(sweet1, sweet2, sweet3));

        ExceptionHandler exception = assertThrows(ExceptionHandler.class, () -> myList.get(5));
        assertEquals("Index is out of range", exception.getMessage());
    }

    @Test
    void testContains() {
        myList.add(sweet1);
        assertTrue(myList.contains(sweet1));
        assertFalse(myList.contains(sweet2));
    }

    @Test
    void testSize() {
        assertEquals(0, myList.size());
        myList.add(sweet1);
        myList.add(sweet2);
        assertEquals(2, myList.size());
    }

    @Test
    void testIsEmpty() {
        assertTrue(myList.isEmpty());
        myList.add(sweet1);
        assertFalse(myList.isEmpty());
    }

    @Test
    void testToArray() {
        myList.add(sweet1);
        myList.add(sweet2);

        Object[] array = myList.toArray();
        assertEquals(2, array.length);
        assertTrue(Arrays.asList(array).contains(sweet1));
        assertTrue(Arrays.asList(array).contains(sweet2));
    }

    @Test
    void testAddAll() {
        assertTrue(myList.addAll(Collections.singleton(sweet1)));
        assertTrue(myList.contains(sweet1));
        assertEquals(1, myList.size());

        assertTrue(myList.addAll(Arrays.asList(sweet2, sweet3)));
        assertTrue(myList.containsAll(Arrays.asList(sweet1, sweet2, sweet3)));
        assertEquals(3, myList.size());
    }

    @Test
    void testAddAllWithNullCollection() {
    ExceptionHandler exception = assertThrows(ExceptionHandler.class, () -> myList.addAll(null));
    assertEquals("Error while adding elements to the list", exception.getMessage());
}

    @Test
    void testRemoveAll() {
        myList.addAll(Arrays.asList(sweet1, sweet2, sweet3));

        assertTrue(myList.removeAll(Collections.singleton(sweet2)));
        assertFalse(myList.contains(sweet2));
        assertEquals(2, myList.size());
    }

    @Test
    void testRemoveAllWithNullCollection() {
        ExceptionHandler exception = assertThrows(ExceptionHandler.class, () -> myList.removeAll(null));
        assertEquals("Error while removing elements from the list", exception.getMessage());
    }

    @Test
    void testRetainAll() {
        myList.addAll(Arrays.asList(sweet1, sweet2, sweet3));

        assertTrue(myList.retainAll(Collections.singleton(sweet2)));
        assertTrue(myList.contains(sweet2));
        assertFalse(myList.contains(sweet1));
        assertFalse(myList.contains(sweet3));
        assertEquals(1, myList.size());
    }

    @Test
    void testRetainAllWithNullCollection() {
        ExceptionHandler exception = assertThrows(ExceptionHandler.class, () -> myList.retainAll(null));
        assertEquals("Error while retaining elements in the list", exception.getMessage());
    }

    @Test
    void testIndexOf() {
        myList.addAll(Arrays.asList(sweet1, sweet2, sweet3));

        assertEquals(0, myList.indexOf(sweet1));
        assertEquals(1, myList.indexOf(sweet2));
        assertEquals(2, myList.indexOf(sweet3));
        assertEquals(-1, myList.indexOf(new Sweet("Nonexistent", 0, 0, 0, "", 0)));
    }

    @Test
    void testLastIndexOf() {
        myList.addAll(Arrays.asList(sweet1, sweet2, sweet3, sweet1));

        assertEquals(3, myList.lastIndexOf(sweet1));
        assertEquals(1, myList.lastIndexOf(sweet2));
        assertEquals(2, myList.lastIndexOf(sweet3));
        assertEquals(-1, myList.lastIndexOf(new Sweet("Nonexistent", 0, 0, 0, "", 0)));
    }

    @Test
    void testAddAllAtIndex() {
        myList.add(sweet1);
        myList.add(sweet2);

        List<Sweet> sweetsToAdd = Arrays.asList(sweet3, sweet2);

        assertTrue(myList.addAll(1, sweetsToAdd));
        assertEquals(4, myList.size());
        assertEquals(sweet1, myList.get(0));
        assertEquals(sweet3, myList.get(1));
        assertEquals(sweet2, myList.get(2));
        assertEquals(sweet2, myList.get(3));
    }

    @Test
    void testAddAllAtIndexInvalidIndex() {
        List<Sweet> sweetsToAdd = Arrays.asList(sweet1);

        ExceptionHandler exception = assertThrows(ExceptionHandler.class, () -> myList.addAll(2, sweetsToAdd));
        assertEquals("Index is out of range", exception.getMessage());
        assertEquals(0, myList.size());
    }

    @Test
    void testSubList() {
        myList.addAll(Arrays.asList(sweet1, sweet2, sweet3));

        List<Sweet> subList = myList.subList(1, 3);

        assertEquals(2, subList.size());
        assertEquals(sweet2, subList.get(0));
        assertEquals(sweet3, subList.get(1));
    }

    @Test
    void testSubListInvalidRange() {
        myList.add(sweet1);

        ExceptionHandler exception = assertThrows(ExceptionHandler.class, () -> myList.subList(1, 1));
        assertEquals("Index is out of range", exception.getMessage());
    }
}
