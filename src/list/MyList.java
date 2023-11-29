package list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;

import exceptions.ExceptionHandler;
import sweets.Sweet;

/**
 * MyList is a custom implementation of the List interface, specifically designed to
 * store objects of the Sweet class. It provides methods to manipulate and access
 * elements in the list.
 *
 * @author [Volodymyr Vikulin]
 * @version 1.0
 */
public class MyList implements List<Sweet> {
    private Node head;
    private Node tail;
    private int size;

    /**
     * Constructs an empty MyList.
     */
    public MyList() {
    }

    /**
     * Constructs a MyList containing the specified Sweet.
     *
     * @param sweet The Sweet to be added to the list.
     */
    public MyList(Sweet sweet) {
        add(sweet);
    }

    /**
     * Constructs a MyList containing elements of the specified collection.
     *
     * @param collection The collection whose elements are to be added to this list.
     */
    public MyList(Collection<? extends Sweet> collection) {
        addAll(collection);
    }

    /**
     * Returns the number of elements in the list.
     *
     * @return The number of elements in the list.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns true if the list contains no elements.
     *
     * @return True if the list is empty, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns true if the list contains the specified element.
     *
     * @param o The object to be checked for containment in the list.
     * @return True if the list contains the specified element, false otherwise.
     */
    @Override
    public boolean contains(Object o) {
        try {
            for (Sweet sweet : this) {
                if (sweet.equals(o)) {
                    return true;
                }
            }
        } catch (Exception e) {
            throw new ExceptionHandler("Error while checking for containment", e);
        }
        return false;
    }

    /**
     * Returns an iterator over the elements in the list.
     *
     * @return An iterator over the elements in the list.
     */
    @Override
    public Iterator<Sweet> iterator() {
        return new MyIterator();
    }

    /**
     * MyIterator is an iterator implementation for MyList.
     */
    private class MyIterator implements Iterator<Sweet> {
        private Node currentNode = head;
        private Node lastReturned = null;
        private int currentIndex = 0;

        /**
         * Returns true if the iteration has more elements.
         *
         * @return True if the iteration has more elements, false otherwise.
         */
        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return The next element in the iteration.
         * @throws ExceptionHandler if the iteration has no more elements.
         */
        @Override
        public Sweet next() {
            if (!hasNext()) {
                throw new ExceptionHandler("Iteration has no more elements");
            }
            lastReturned = currentNode;
            Sweet sweet = currentNode.getSweet();
            currentNode = currentNode.getNext();
            currentIndex++;
            return sweet;
        }

        /**
         * Removes the last element returned by the iterator from the list.
         *
         * @throws ExceptionHandler if the next method has not yet been called,
         *         or the remove method has already been called after the last call
         *         to the next method.
         */
        @Override
        public void remove() {
            if (lastReturned == null) {
                throw new ExceptionHandler("Next method has not yet been called/Remove method has already been called");
            }

            Node nextNode = lastReturned.getNext();
            if (lastReturned == head) {
                head = nextNode;
                if (nextNode == null) {
                    tail = null;
                }
            } else {
                Node prevNode = getNodeByIndex(currentIndex - 2);
                prevNode.setNext(nextNode);
                if (nextNode == null) {
                    tail = prevNode;
                }
            }

            lastReturned = null;
            size--;
            currentIndex--;
        }

        /**
         * Returns the Node at the specified index in the list.
         *
         * @param index The index of the Node to be retrieved.
         * @return The Node at the specified index in the list.
         * @throws ExceptionHandler if the index is out of range.
         */
        private Node getNodeByIndex(int index) {
            if (index < 0 || index >= size) {
                throw new ExceptionHandler("Index is out of range");
            }

            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }

            return current;
        }
    }

    /**
     * Returns an array containing all of the elements in the list in proper
     * sequence (from first to last element).
     *
     * @return An array containing all of the elements in the list.
     */
    @Override
    public Object[] toArray() {
        try {
            Object[] arraySweet = new Sweet[size];
            int index = 0;
            for (Sweet sweet : this) {
                arraySweet[index] = sweet;
                index++;
            }
            return arraySweet;
        } catch (Exception e) {
            throw new ExceptionHandler("Error while converting the list to an array", e);
        }
    }

    /**
     * Appends the specified element to the end of the list.
     *
     * @param sweet The Sweet to be added to the list.
     * @return Always true, as the element is always added.
     */
    @Override
    public boolean add(Sweet sweet) {
        if (sweet == null) throw new ExceptionHandler("Sweet is null");
        try {
            Node node = new Node(sweet, null);
            if (head == null) {
                head = node;
            } else {
                tail.setNext(node);
            }
            tail = node;
            size++;
            return true;
        } catch (Exception e) {
            throw new ExceptionHandler("Error while adding the element", e);
        }
    }

    /**
     * Removes the first occurrence of the specified element from the list,
     * if it is present.
     *
     * @param o The object to be removed from the list.
     * @return True if the list contained the specified element, false otherwise.
     */
    @Override
    public boolean remove(Object o) {
        if (o == null) throw new ExceptionHandler("Sweet is null");
        try {
            Node current = head;
            Node previous = null;
    
            while (current != null) {
                if (current.getSweet().equals(o)) {
                    if (previous == null) {
                        head = current.getNext();
                        if (head == null) {
                            tail = null;
                        }
                    } else {
                        previous.setNext(current.getNext());
                        if (current.getNext() == null) {
                            tail = previous;
                        }
                    }
    
                    size--;
                    return true;
                }
    
                previous = current;
                current = current.getNext();
            }
        } catch (Exception e) {
            throw new ExceptionHandler("Error while removing the element", e);
        }
        return false;
    }

    /**
     * Returns true if the list contains all of the elements of the specified
     * collection.
     *
     * @param collection The collection to be checked for containment in the list.
     * @return True if the list contains all of the elements of the specified
     *         collection, false otherwise.
     */
    @Override
    public boolean containsAll(Collection<?> collection) {
        try {
            boolean isAllInCollection = true;
            for (Object o : collection) {
                isAllInCollection &= this.contains(o);
            }
            return isAllInCollection;
        } catch (Exception e) {
            throw new ExceptionHandler("Error while checking containment for all elements", e);
        }
    }
    
    /**
     * Appends all of the elements in the specified collection to the end of
     * the list, in the order that they are returned by the specified
     * collection's iterator.
     *
     * @param collection The collection whose elements are to be added to this list.
     * @return True if the list changed as a result of the call, false otherwise.
     */
    @Override
    public boolean addAll(Collection<? extends Sweet> collection) {
        try {
            boolean isCollectionChanged = false;
        for (Sweet sweet : collection) {
            isCollectionChanged |= this.add(sweet);
        }
            return isCollectionChanged;
        } catch (Exception e) {
            throw new ExceptionHandler("Error while adding elements to the list", e);
        }

    }

    /**
     * Removes from the list all of its elements that are contained in the
     * specified collection.
     *
     * @param collection The collection containing elements to be removed from this list.
     * @return True if the list changed as a result of the call, false otherwise.
     */
    @Override
    public boolean removeAll(Collection<?> collection) {
        try {
            Objects.requireNonNull(collection);
            boolean modified = false;
    
            List<Sweet> sweetsToRemove = new ArrayList<>();
            for (Object obj : collection) {
                if (obj instanceof Sweet) {
                    sweetsToRemove.add((Sweet) obj);
                }
            }
    
            Iterator<Sweet> iterator = iterator();
            while (iterator.hasNext()) {
                Sweet currentSweet = iterator.next();
                if (sweetsToRemove.contains(currentSweet)) {
                    iterator.remove();
                    modified = true;
                }
            }
    
            return modified;
        } catch (Exception e) {
            throw new ExceptionHandler("Error while removing elements from the list", e);
        }
    }

    /**
     * Retains only the elements in the list that are contained in the specified
     * collection.
     *
     * @param collection The collection containing elements to be retained in this list.
     * @return True if the list changed as a result of the call, false otherwise.
     */
    @Override
    public boolean retainAll(Collection<?> collection) {
        try {
            Objects.requireNonNull(collection);
            boolean modified = false;
    
            List<Sweet> sweetsToRetain = new ArrayList<>();
            for (Object obj : collection) {
                if (obj instanceof Sweet) {
                    sweetsToRetain.add((Sweet) obj);
                }
            }
    
            Iterator<Sweet> iterator = iterator();
            while (iterator.hasNext()) {
                Sweet currentSweet = iterator.next();
                if (!sweetsToRetain.contains(currentSweet)) {
                    iterator.remove();
                    modified = true;
                }
            }
    
            return modified;
        } catch (Exception e) {
            throw new ExceptionHandler("Error while retaining elements in the list", e);
        }
    }

    /**
     * Removes all of the elements from the list.
     */
    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }
    /**
    * Returns the element at the specified position in this list.
    *
    * @param index The index of the element to be retrieved.
    * @return The element at the specified position in this list.
    * @throws ExceptionHandler if the index is out of range.
    */
    @Override
    public Sweet get(int i) {
        int index = 0;
        if (i < 0 || i >= size) {
            throw new ExceptionHandler("Index is out of range");
        } else {
            for (Sweet sweet : this) {
                if (index == i) {
                    return sweet;
                }
                index++;
            }
        }
        return null;
    }

    
    /**
    * Replaces the element at the specified position in this list with the specified element.
    *
    * @param index The index of the element to be replaced.
    * @param sweet The new element to be stored at the specified position.
    * @return The element previously at the specified position.
    * @throws ExceptionHandler if the index is out of range.
    */
    @Override
    public Sweet set(int index, Sweet sweet) {
        if (index < 0 || index >= size) {
            throw new ExceptionHandler("Index is out of range");
        }

        Node current = getNodeByIndex(index);
        Sweet oldSweet = current.getSweet();
        current.setSweet(sweet);

        return oldSweet;
    }

    /**
    * Inserts the specified element at the specified position in this list.
    *
    * @param index The index at which the specified element is to be inserted.
    * @param sweet The element to be inserted.
    * @throws ExceptionHandler if the index is out of range.
    */
    @Override
    public void add(int index, Sweet sweet) {
        if (index < 0 || index > size) {
            throw new ExceptionHandler("Index is out of range");
        }

        if (index == size) {
            add(sweet);
        } else {
            Node newNode = new Node(sweet, null);

            if (index == 0) {
                newNode.setNext(head);
                head = newNode;
            } else {
                Node prevNode = getNodeByIndex(index - 1);
                newNode.setNext(prevNode.getNext());
                prevNode.setNext(newNode);
            }

            size++;
        }
    }

    /**
    * Removes the element at the specified position in this list.
    *
    * @param index The index of the element to be removed.
    * @return The element that was removed from the list.
    * @throws ExceptionHandler if the index is out of range.
    */
    @Override
    public Sweet remove(int index) {
        if (index < 0 || index >= size) {
            throw new ExceptionHandler("Index is out of range");
        }

        Node removedNode;

        if (index == 0) {
            removedNode = head;
            head = head.getNext();
            if (head == null) {
                tail = null;
            }
        } else {
            Node prevNode = getNodeByIndex(index - 1);
            removedNode = prevNode.getNext();
            prevNode.setNext(removedNode.getNext());
            if (removedNode == tail) {
                tail = prevNode;
            }
        }

        size--;
        return removedNode.getSweet();
    }

    /**
    * Returns the index of the first occurrence of the specified element in this list,
    * or -1 if this list does not contain the element.
    *
    * @param o The object to search for.
    * @return The index of the first occurrence of the specified element, or -1 if not found.
    */
    @Override
    public int indexOf(Object o) {
        try {
            int index = 0;
            for (Sweet sweet : this) {
                if (sweet.equals(o)) {
                    return index;
                }
                index++;
            }
        } catch (Exception e) {
            throw new ExceptionHandler("Error while finding the index of the element", e);
        }
        return -1;
    }    

    /**
    * Returns the index of the last occurrence of the specified element in this list,
    * or -1 if this list does not contain the element.
    *
    * @param o The object to search for.
    * @return The index of the last occurrence of the specified element, or -1 if not found.
    */
    @Override
    public int lastIndexOf(Object o) {
        try {
            int index = -1;
            int counter = 0;
            for (Sweet sweet : this) {
                if (sweet.equals(o)) {
                    index = counter;
                }
                counter++;
            }
            return index;
        } catch (Exception e) {
            throw new ExceptionHandler("Error while finding the last index of the element", e);
        }
    }
    /**
    * Returns the node at the specified index in this list.
    *
    * @param index The index of the node to be retrieved.
    * @return The node at the specified index in this list.
    * @throws ExceptionHandler if the index is out of range.
    */
    private Node getNodeByIndex(int index) {
        if (index < 0 || index >= size) {
            throw new ExceptionHandler("Index is out of range");
        }
    
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
    
        return current;
    }
    /**
    * Inserts all the elements in the specified collection into this list at the
    * specified position. Shifts the element currently at that position (if any)
    * and any subsequent elements to the right (increases their indices). The new
    * elements will appear in the list in the order they are returned by the
    * collection's iterator.
    *
    * @param index The index at which to insert the first element from the
    *              specified collection.
    * @param collection The collection containing elements to be added to this list.
    * @return {@code true} if this list changed as a result of the call.
    * @throws ExceptionHandler If the index is out of range
    *                                   (index < 0 || index > size).
    */
    @Override
    public boolean addAll(int index, Collection<? extends Sweet> collection) {
        if (index < 0 || index > size) {
            throw new ExceptionHandler("Index is out of range");
        }

        List<Sweet> sweetsToAdd = new ArrayList<>(collection);
        Node prevNode = index == 0 ? null : getNodeByIndex(index - 1);
        Node nextNode = index == size ? null : getNodeByIndex(index);

        for (Sweet sweet : sweetsToAdd) {
            Node newNode = new Node(sweet, nextNode);
            if (prevNode == null) {
                head = newNode;
            } else {
                prevNode.setNext(newNode);
            }
            prevNode = newNode;
            size++;
        }

        if (nextNode == null) {
            tail = prevNode;
        }

        return !sweetsToAdd.isEmpty();
    }

    /**
    * Returns a view of the portion of this list between the specified
    * {@code fromIndex}, inclusive, and {@code toIndex}, exclusive. (If
    * {@code fromIndex} and {@code toIndex} are equal, the returned list is
    * empty.) The returned list is backed by this list, so non-structural
    * changes in the returned list are reflected in this list, and vice-versa.
    * The returned list supports all of the optional list operations.
    *
    * @param fromIndex The starting index (inclusive) of the sublist.
    * @param toIndex The ending index (exclusive) of the sublist.
    * @return A view of the specified range within this list.
    * @throws ExceptionHandler If {@code fromIndex} is negative,
    * greater than {@code toIndex}, or {@code toIndex} is greater than the size of this list.
    */
    @Override
    public List<Sweet> subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > size || fromIndex > toIndex) {
            throw new ExceptionHandler("Invalid sublist range");
        }

        List<Sweet> subList = new ArrayList<>();
        Node current = getNodeByIndex(fromIndex);

        for (int i = fromIndex; i < toIndex; i++) {
            subList.add(current.getSweet());
            current = current.getNext();
        }

        return subList;
    }

    @Override
    public <T> T[] toArray(T[] ts) {
        throw new ExceptionHandler("Unsupproted operation");
    }

    @Override
    public ListIterator<Sweet> listIterator() {
        throw new ExceptionHandler("Unsupproted operation");
    }

    @Override
    public ListIterator<Sweet> listIterator(int i) {
        throw new ExceptionHandler("Unsupproted operation");
    }


}