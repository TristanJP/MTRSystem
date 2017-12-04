package mtr;

/**
 * @author Ollie
 * @version 1.0
 */
/*
 * REVISIONS
 * 1.0 - Create class and constructor
 */
public class Node<T> {
	
	private Node head;
	private Node tail;
	private T content;

	/**
	 * 
	 */
	public Node(T content) {
		this.content = content;
		this.head = null;
		this.tail = null;
	}
	
	public Node<T> getPrevious() {
		return (tail == null)?null:tail;
	}
	
	public void setPrevious(Node<T> newTail) {
		this.tail = newTail;
		
	}
	
	public Node<T> getNext() {
		return (head == null)?null:head;
	}
	
	public void setNext(Node<T> newHead) {
		this.head = newHead;
	}

	public String toString() {
		return this.content.toString();
	}
}
