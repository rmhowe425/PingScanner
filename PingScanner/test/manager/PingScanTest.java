package manager;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Enumeration;
import org.junit.Test;

/**
 * Tests the functionality of the PingScan class 
 * @author Richard Howe 
 */
public class PingScanTest {
	private PingScan ping;
	
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
	 * tests the constructor for the PingScan class 
	 * @throws SocketException 
	 */
	@Test
	public void testPingScan() throws SocketException {
		ping = new PingScan(findNIC());
		assertTrue(ping instanceof PingScan);
	} // End testPingScan
	
	/**
	 * Tests the getLiveAddressesAs String method 
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	@Test
	public void testGetLiveAddressesAsString() throws IOException, InterruptedException {
		ping = new PingScan(findNIC());
		String[] x = ping.getLiveAddressesAsString();
		
		
		for(int i = 0; i < x.length; i++) {
			System.out.println(x[i]);
		}
	} // End testGetLiveAddressesAsString
} // End PingScan Test 
