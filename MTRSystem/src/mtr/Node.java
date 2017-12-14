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
	
	/**
	 * Field to hold the Node that is before this Node
	 */
	private Node<T> head;
	/**
	 * Field to hold the Node that is after this Node
	 */
	private Node<T> tail;
	/**
	 * Field to hold the content of this Node
	 */
	private T content;

	/**
	 * Constructor of Node
	 * Sets head and tail to null
	 * @param content The content of the Node being created
	 */
	public Node(T content) {
		this.content = content;
		this.head = null;
		this.tail = null;
	}
	
	/**
	 * Gets the Node before this Node in the List
	 * @return tail The node before this node, null if there is no previous node
	 */
	public Node<T> getPrevious() {
		return (tail == null)?null:tail;
	}
	
	/**
	 * Sets the Node before this Node in the List
	 * @param newTail The Node that will be set as being infront of this Node in the List
	 */
	public void setPrevious(Node<T> newTail) {
		this.tail = newTail;
		
	}
	
	/**
	 * Gets the Node after this Node in the List
	 * @return head The node after this node, null if there is no next node
	 */
	public Node<T> getNext() {
		return (head == null)?null:head;
	}
	
	/**
	 * Sets the Node after this Node in the List
	 * @param newHead The Node that will be set as being after of this Node in the List
	 */
	public void setNext(Node<T> newHead) {
		this.head = newHead;
	}

	/**
	 * Returns this node in String format
	 * @return String The content of this node as a String
	 */
	public String toString() {
		return this.content.toString();
	}
	
	/**
	 * Gets the content of this Node
	 * @return content The content of this Node
	 */
	public T getContent() {
		return this.content;
	}
}
