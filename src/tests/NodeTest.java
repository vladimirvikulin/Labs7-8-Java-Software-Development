package tests;
import org.junit.jupiter.api.Test;

import list.MyList;
import list.Node;
import sweets.Candy;
import sweets.Waffle;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class NodeTest {
    private MyList myList;
    private Candy sweet1;
    private Waffle sweet2;

    @BeforeEach
    void setUp() {
        myList = new MyList();
        sweet1 = new Candy("Candy1", 50.0, 1, 50, "Sweet", 30.0, true);
        sweet2 = new Waffle("Candy2", 40.0, 2, 0, "Chocolate", 50.0, "American");
    }

    @AfterEach
    void clear() {
        myList.clear();
    }

    @Test
    void testSetSweet() {
        Node node = new Node(sweet1, null);
        node.setSweet(sweet2);
        assertEquals(sweet2, node.getSweet());
    }

    @Test
    void testSetNext() {
        Node node1 = new Node(sweet1, null);
        Node node2 = new Node(sweet2, null);
        node1.setNext(node2);
        assertEquals(node2, node1.getNext());
    }

    @Test
    void testGetSweet() {
        Node node = new Node(sweet1, null);
        assertEquals(sweet1, node.getSweet());
    }

    @Test
    void testGetNext() {
        Node node1 = new Node(sweet1, null);
        Node node2 = new Node(sweet2, null);
        node1.setNext(node2);
        assertEquals(node2, node1.getNext());
    }
}
