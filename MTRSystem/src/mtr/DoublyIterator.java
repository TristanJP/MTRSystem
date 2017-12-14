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
	
	private Node<T> currentNode = null;
	private int count;
	/**
	 * 
	 */
	public DoublyIterator(Node<T> firstNode, int size) {
		this.currentNode = firstNode;
		count = size;
	}
	
	public boolean hasNext() {
		return (currentNode.getNext() != null);
	}
	
	public boolean hasPrevious() {
		return (currentNode.getPrevious() != null);
	}
	
	public void remove() {
		
	}

	@Override
	public T next() {
		currentNode = currentNode.getNext();
		return  (T) currentNode;
	}

	@Override
	public int nextIndex() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public T previous() {
		currentNode = currentNode.getPrevious();
		return (T) currentNode;
	}

	@Override
	public int previousIndex() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void set(T arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add(T e) {
		// TODO Auto-generated method stub
		
	}
	
	public T get() {
		return (T)this.currentNode;
	}
	
	

}
