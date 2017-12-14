package mtr;

/**
 * @author Ollie
 * @version 1.2
 */
/*
 * REVISIONS
 * 1.0 - Create class and constructor
 * 1.1 - Add methods
 * 1.2 - Add abstract type to head and tail
 */
public class Node<T> {
	
	private Node<T> head;
	private Node<T> tail;
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
	
	public T getContent() {
		return this.content;
	}
}
