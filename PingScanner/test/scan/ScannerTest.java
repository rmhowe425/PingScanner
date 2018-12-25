package scan;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Enumeration;

import org.junit.Test;

/**
 * Tests the functionality of the Scanner class 
 * @author Richard Howe 
 */
public class ScannerTest {
	
	/**
	 * Helper method that returns a valid hard coded NIC that is used for testing 
	 * @return NIC The network interface that is used for testing 
	 * @throws SocketException
	 */
	private NetworkInterface findNIC() throws SocketException {
		NetworkInterface NIC = null;
		
		Enumeration<NetworkInterface> nets = NetworkInterface.getNetworkInterfaces();
		for (NetworkInterface netint : Collections.list(nets))
			if(netint.getName().equals("wlx00c0ca6daed8")) {
				NIC = netint;
				break;
			} // End If Statement
		return NIC;
	} // End findNic
	
	/**
	 * Tests the Scanner classes constructor and setPreferredAdapter method indirectly
	 * @throws SocketException
	 */
	@Test
	public void testScanner() throws SocketException {
		Scanner scan = new Scanner(findNIC());
		
		// Verify scan is a Scanner object
	    assertTrue(scan instanceof Scanner);
	} // End testScanner 
	
	/**
	 * Tests the getPreferredAdapter method 
	 * @throws SocketException
	 */
	@Test
	public void testGetPreferredAdapter() throws SocketException {
		Scanner scan = new Scanner(findNIC());
		
		assertEquals("wlx00c0ca6daed8", scan.getPreferredAdapter());
	} // End testGetPreferredAdapter 
	
	/**
	 * Tests the helper method getLocalIP
	 * @throws SocketException
	 */
	@Test
	public void testGetLocalIP() throws SocketException {
		Scanner scan = new Scanner(findNIC());
		
		assertEquals("192.168.1.8", scan.getLocalIP());
	} // End testGetLocalIP

	/**
	 * Tests the CheckHostAlive method 
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	@Test
	public void testScanNetRange() throws IOException, InterruptedException {
		Scanner scan = new Scanner(findNIC());
		scan.ScanNetRange();
	} // End testCheckHostAlive
} // End ScannerTest 
