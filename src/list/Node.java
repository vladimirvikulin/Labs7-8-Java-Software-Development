package list;

import sweets.Sweet;

/**
 * The Node class represents a node in a linked list used by the MyList class.
 * Each node contains a Sweet object and a reference to the next node in the list.
 *
 * @author [Volodymyr Vikulin]
 * @version 1.0
 */
public class Node {
    private Sweet sweet;
    private Node next;

    /**
     * Constructs a new Node with the specified Sweet and next Node reference.
     *
     * @param sweet The Sweet object to be stored in the node.
     * @param next  The reference to the next node in the linked list.
     */
    public Node(Sweet sweet, Node next) {
        this.sweet = sweet;
        this.next = next;
    }

    /**
     * Sets the next node in the linked list.
     *
     * @param next The reference to the next node.
     */
    public void setNext(Node next) {
        this.next = next;
    }

    /**
     * Gets the Sweet object stored in the node.
     *
     * @return The Sweet object stored in the node.
     */
    public Sweet getSweet() {
        return sweet;
    }

    /**
     * Sets a new Sweet object in the node.
     *
     * @param sweet The new Sweet object to be stored in the node.
     */
    public void setSweet(Sweet sweet) {
        this.sweet = sweet;
    }

    /**
     * Gets the reference to the next node in the linked list.
     *
     * @return The reference to the next node.
     */
    public Node getNext() {
        return next;
    }
}
