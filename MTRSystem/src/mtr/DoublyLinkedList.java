package mtr;

import java.util.Iterator;

/**
 * @author Ollie, Tristan
 * @version 1.5
 */
/*
 * REVISIONS
 * 1.0 - Create class and constructor
 * 1.1 - Add insertElement method
 * 1.2 - Add remove methods and checks
 * 1.3 - Fix addElement method
 * 1.4 - Add first element handler to addElement
 * 1.5 - Add findNodeAt method, made Iterable
 */
public class DoublyLinkedList<T> implements Iterable<T>{

	protected Node<T> rear;
	protected Node<T> front;
	protected int count;

	/**
	 * 
	 */
	public DoublyLinkedList() {
		rear = null;
		front = null;
		count = 0;
	}

	public void addElement(Node<T> element) {
		if (front == null) { // This be the first
			this.rear = element;
			this.front = element;
			this.front.setPrevious(this.rear);
			this.rear.setNext(this.front);
		} else {
			this.front.setNext(element);
			element.setPrevious(this.front);
			this.front = element;
		}
		this.count += 1;
	}

	public void insertElement(Node<T> nextElement, Node<T> newElement) { // Will insert before next element
		Node<T> prevElement = nextElement.getPrevious();
		prevElement.setNext(newElement);
		newElement.setPrevious(prevElement);
		nextElement.setPrevious(newElement);
		newElement.setNext(nextElement);
		count++;
	}

	public void removeElement(Node<T> element) {
		if (getFrontElement() == element) {
			removeFront();
		} else if (getRearElement() == element) {
			removeRear();
		} else {
			element.getPrevious().setNext(element.getNext());
			element.getNext().setPrevious(element.getPrevious());
			count--;
		}
	}

	private void removeFront() {
		Node<T> oldNode = this.front;
		this.front = this.front.getNext();
		oldNode = null;
		count--;
	}

	private void removeRear() {
		Node<T> oldNode = this.rear;
		this.rear = this.rear.getPrevious();
		oldNode = null;
		count--;
	}

	public Node<T> getFrontElement() {
		return this.front;
	}

	public Node<T> getRearElement() {
		return this.rear;
	}

	public String toString() {
		String returnString = "";
		Node<T> currentNode = this.rear;
		while (currentNode != null) {
			returnString += currentNode.toString() + ((currentNode.getNext() != null)?", ":"");
			currentNode = currentNode.getNext();
		}
		return returnString;
	}

	/**
	 * Finds the node at a position in the list
	 * @param position The position in the list
	 * @return the node at that position
	 */
	public Node<T> findNodeAt(int position){
		Node<T> currentNode = front;
		int count = 1;

		if (this.count == 0 || position < 1 || position > this.count) {
			System.out.print("NO!!!!!!!");
		}
		else {
			while (count < position) {
				currentNode = currentNode.getNext();
				count ++;
			}
		}

		return currentNode;
	}

	@Override
	public Iterator<T> iterator() {
		return new DoublyIterator(front, count);
	}

}
