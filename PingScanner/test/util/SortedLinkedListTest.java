package util;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests the functionality of the SortedLinkedList class 
 * @author Richard Howe 
 */
public class SortedLinkedListTest {
	SortedLinkedList<String> ipList = new SortedLinkedList<String>();

	/**
	 * Tests the constructor and size methods for
	 * the SortedLinkedList class 
	 */
	@Test
	public void testSortedLinkedListAndSize() {
		assertTrue(ipList instanceof SortedLinkedList);
		assertEquals(0, ipList.size());
	} // End testSortedLinkedList


	/**
	 * Tests the get and add methods for
	 * the SortedLinkedList class 
	 */
	@Test
	public void testAddAndGet() {
		//Ensure initial size is 0
		assertEquals(0, ipList.size());
		
		//Add items to the list
		ipList.add("Item 1");
		ipList.add("Item 2");
		ipList.add("Item 3");
		ipList.add("Item 4");
		
		// Verify size
		assertEquals(4, ipList.size());
		
		//Verify elements contain their intended values
		assertEquals("Item 1", ipList.get(0));
		assertEquals("Item 2", ipList.get(1));
		assertEquals("Item 3", ipList.get(2));
		assertEquals("Item 4", ipList.get(3));
		
		// Attempt to add a duplicate entry
		try {
			ipList.add("Item 1");
			fail();
		} // End Try Block
		catch(Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		} // End Catch Block 
		
		// Attempt to add a null entry 
		try {
			ipList.add(null);
			fail();
		} // End Try Block
		catch(Exception e) {
			assertTrue(e instanceof NullPointerException);
		} // End Catch Block 
		
		// Attempt to add an empty string 
		try {
			ipList.add("");
			fail();
		} // End Try Block
		catch(Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		} // End Catch Block 
	} // End testAddAndGet
} // End SortedLinkedListTest
