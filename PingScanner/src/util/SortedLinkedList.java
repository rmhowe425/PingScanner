package util;

/**
 * Responsible for maintaining a sorted linked list of live IP addresses.
 * Sorted by the net range, from the smallest IP address to the largest
 * @author Richard Howe
 */
public class SortedLinkedList <E extends Comparable<E>> {
	private ListNode<E> front;
	private int size;
	
	
	/**
	 * Constructor for the SortedLinkedList class 
	 */
	public SortedLinkedList() {
		size = 0;
	} // End SortedLinkedList 
	
	
	/**
	 * Returns the size of the linked list 
	 * @return size The size of the linked list 
	 */
	public int size() {
		return size;
	} // End size

	
	/**
	 * Returns an element at the specified index
	 * @param index The place in the list containing the desired element
	 * @return current.data The data contained in the desired element
	 */
	public E get(int index) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		} // End If Statement 
		
		ListNode<E> current = front;
		
		for(int i = 0; i < index; i++) {
			current = current.next;
		} // End For Loop 
		
		return current.data;
	} // End get
	
	
	/**
	 * Adds an IP address to the sorted linked list 
	 * @return True if the IP address is properly added 
	 */
	public boolean add(E element) {
		// Check for null data 
	    if (element == null) {
			throw new NullPointerException("Data must be a valid IP address.");
		} // End If Statement
	    
	    if (element.equals("")) {
			throw new IllegalArgumentException("Data must be a valid IP address.");
		} // End If Statement

	    // Check for a duplicate node
	    for(int i = 0; i < size; i++) {
	    	if(element.equals(get(i))) {
	    		throw new IllegalArgumentException("Can not have a duplicate IP address.");
	    	} // End If Statement
	    } // End For Loop
	   
	    // Check for an empty list, add an item
	    if(size == 0) {
	    	front = new ListNode<E>(element);
	    } // End If Statement 
	    
	    // Check if element is smaller than the first element in the list 
	    else if(element.compareTo((E) front.data) < 0) {
	    	front = new ListNode<E>(element, front);
	    } // End Else If Statement
	    
	    else {
	    	ListNode<E> current = front;
	    	
	    	while(current.next != null && element.compareTo((E) current.next.data) > 0) {
	    		current = current.next;
	    	} // End While Loop
	    	current.next = new ListNode<E>(element, current.next);
	    } // End Else Statement
	  size++;
	  return true;
	} // End add
	
	
	/**
	 * Class responsible for creating Node objects for the SortedLinkedList class
	 * @author Richard Howe 
	 * @param <E> Generic type object given to the ListNode class
	 */
	@SuppressWarnings("hiding")
	private class ListNode<E extends Comparable<E>> {
		protected E data;
		private ListNode<E> next;
		
		/**
		 * Constructor for the ListNode class 
		 * @param data Data stored for a given ListNode
		 * @param next The next ListNode in the SortedLinkedList
		 */
		public ListNode(E data, ListNode<E> next) {
			this.data = data;
			this.next = next;
		} // End ListNode
		
		/**
		 * Constructor for the ListNode class
		 * @param data Data stored in a ListNode object
		 */
		public ListNode(E data) {
			this.data = data;
		} // End ListNode
	} // End ListNode 
} // End SortedLinked List 
