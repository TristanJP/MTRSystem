package mtr;

import java.util.Iterator;

/**
 * @author Ollie
 * @version 1.0
 * 
 * REVISIONS
 * 1.0 - Create class and constructor
 */
public class DoublyIterator<T> implements Iterator {
	
	private Node<T> currentNode = null;

	/**
	 * 
	 */
	public DoublyIterator(Node<T> firstNode) {
		this.currentNode = firstNode;
	}
	
	public Node<T> next() {
		currentNode = currentNode.getNext();
		return currentNode;
	}
	
	public Node<T> previous() {
		currentNode = currentNode.getPrevious();
		return currentNode;
	}
	
	public boolean hasNext() {
		return (currentNode.getNext() != null);
	}
	
	public boolean hasPrevious() {
		return (currentNode.getPrevious() != null);
	}
	
	public void remove() {
		
	}
	
	

}
