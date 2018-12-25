package manager;

import scan.Scanner;
import java.io.IOException;
import java.net.NetworkInterface;

/**
 * Controller for the PingScan implementation
 * Responsible for receiving the net range input to scan and 
 * received the list of output containing all live IP Addresses and 
 * passes it to the GUI
 * @author Richard Howe 
 */
public class PingScan {
	/** String type array that holds all live IP's in a given net range **/ 
	private String[] addressList;
	/** Instance of Scanner to scan IP addresses **/
	private Scanner netScan;
	
	/**
	 * Constructor for the PingScan class 
	 */
	public PingScan(NetworkInterface NIC) {
		netScan = new Scanner(NIC);
	} // End PingScan
	
	
	public String[] getLiveAddressesAsString() throws IOException, InterruptedException {
		netScan.ScanNetRange();
		addressList = netScan.getListAsArray();	
		return addressList;
	} // End getLiveAddresses
} // End PingScan
