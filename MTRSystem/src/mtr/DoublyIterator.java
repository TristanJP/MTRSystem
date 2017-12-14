package mtr;

import java.util.Iterator;
import java.util.ListIterator;

/**
 * @author Ollie, Tristan
 * @version 1.2
 */
/*
 * REVISIONS
 * 1.0 - Create class and constructor
 * 1.1 - Add next, previous, hasNext, hasPrevious methods
 * 1.2 - Changed DoublyIterator so it can be implemented by DoublyLinkedList, made it implement ListIterator
 */
public class DoublyIterator<T> implements ListIterator<T> {
	
	/**
	 * Field to store the current Node the iterator is on
	 */
	private Node<T> currentNode = null;
	
	/**
	 * Field to store the index. Size of the DoublyLinkedList you are on
	 */
	private int index;
	
	/**
	 * Constructor makes an instance of DoublyIterator, sets the currentNode to the first in the list and the index to the size of the list
	 * @param firstNode The first node in the list
	 * @param size The size of the list
	 */
	public DoublyIterator(Node<T> firstNode, int size) {
		this.currentNode = firstNode;
		index = size;
	}
	
	/**
	 * Checks to see if there is another node next in the list
	 * @return True if there is another node after currentNode, else false
	 */
	public boolean hasNext() {
		return (currentNode.getNext() != null);
	}
	
	/**
	 * Checks to see if there is another node infront of the currentNode in the List
	 * @return True if there is another node before currentNode, else false
	 */
	public boolean hasPrevious() {
		return (currentNode.getPrevious() != null);
	}
	
	/**
	 * Gets the currentNode
	 * @return currentNode The node currently on
	 */
	public T get() {
		return (T)this.currentNode;
	}
	
	/**
	 * removes a node from the list
	 */
	public void remove() {
		//Not needed
	}

	/**
	 * Gets the next node after the currentNode in the List
	 * @return The next node in the list
	 */
	@Override
	public T next() {
		currentNode = currentNode.getNext();
		return  (T) currentNode;
	}

	/**
	 * Gets the next index after the currentNode's index in the List
	 * @return The next node's index
	 */
	@Override
	public int nextIndex() {
		// not needed
		return 0;
	}

	/**
	 * Gets the previous node before the currentNode in the List
	 * @return The previous node in the list
	 */
	@Override
	public T previous() {
		currentNode = currentNode.getPrevious();
		return (T) currentNode;
	}

	/**
	 * Gets the previous index before the currentNode's index in the List
	 * @return The previous node's index
	 */
	@Override
	public int previousIndex() {
		// not needed
		return 0;
	}

	/**
	 * Sets the current Node
	 * @param What to set to
	 */
	@Override
	public void set(T arg0) {
		// not needed
		
	}

	/**
	 * Adds a Node
	 * @param Node being added
	 */
	@Override
	public void add(T e) {
		// not needed
	}
}
