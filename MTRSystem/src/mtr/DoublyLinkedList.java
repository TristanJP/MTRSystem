package mtr;

/**
 * @author Ollie
 * @version 1.1
 * 
 * REVISIONS
 * 1.0 - Create class and constructor
 * 1.1 - Add insertElement method
 */
public abstract class DoublyLinkedList<T> {
	
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
		front.setNext(element);
		this.front = element;
	}
	
	public void insertElement(Node<T> nextElement, Node<T> newElement) { // Will insert before next element
		Node<T> prevElement = nextElement.getPrevious();
		prevElement.setNext(newElement);
		newElement.setPrevious(prevElement);
		nextElement.setPrevious(newElement);
		newElement.setNext(nextElement);
	}

}
