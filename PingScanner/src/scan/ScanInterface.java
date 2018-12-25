package scan;

import java.io.IOException;
import java.net.NetworkInterface;
import java.net.SocketException;

/**
 * Responsible for providing the methods for finding the preferred network
 * adapter to transmit data from and for attempting to see if a host is 
 * alive on the network 
 * @author Richard Howe 
 */
public interface ScanInterface {
	/** 
	 * Returns the string value of the preferred 
	 * network adapters name to use
	 * @return adapter The preferred network adapter to use 
	 */
	String getPreferredAdapter();
	
	/**
	 * Sets the value of the preferred adapter to use for scanning
	 * @throws SocketException 
	 */
	void setPreferredAdapter(NetworkInterface NIC);
	
	/** 
	 * Checks to see if an IP Address is alive
	 * @return True if the IP address is alive 
	 * @throws IOException, InterruptedException
	 */
	void ScanNetRange() throws IOException, InterruptedException;
} // End ScanInterface 
