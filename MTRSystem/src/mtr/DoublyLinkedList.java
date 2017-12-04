package mtr;

/**
 * @author Ollie
 * @version 1.2
 */
/*
 * REVISIONS
 * 1.0 - Create class and constructor
 * 1.1 - Add insertElement method
 * 1.2 - Add remove methods and checks
 */
public class DoublyLinkedList<T> {
	
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
		this.front.setNext(element);
		this.front = element;
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
		Node<T> currentNode = this.front;
		while (currentNode != null) {
			returnString += currentNode.toString();
			currentNode = currentNode.getNext();
		}
		return returnString;
	}

}
