package mtr;

/**
 * @author Ollie
 * @version 1.0
 * 
 * REVISIONS
 * 1.0 - Create class and constructor
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
	
	public void insertElement(Node<T> element) {
		
	}

}
