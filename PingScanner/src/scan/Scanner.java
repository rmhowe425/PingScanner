package scan;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Collections;
import java.util.Enumeration;
import util.SortedLinkedList;
import java.net.SocketException;
import java.net.NetworkInterface;

/**
 * Responsible for scanning a network range with a specified
 * adapter and maintaining a list of live IP addresses
 * @author Richard Howe 
 * @param <E>
 */
public class Scanner implements ScanInterface {
	/** Contains all available IP addresses **/
	public SortedLinkedList<String> IPList;
	/** The adapter to scan IP addresses with **/ 
	private String adapter;
	/** The local IP address of the machine on the chosen adapter **/ 
	private String localIP;
	/** IP address passed to a new thread **/ 
	private String ipAddress;
	
	/**
	 * Constructor for the Scanner class 
	 */
	public Scanner(NetworkInterface adapter) {
		IPList = new SortedLinkedList<String>();
		setPreferredAdapter(adapter);
	} // End Scanner 
	
	/**
	 * Returns the local IP address of the machine 
	 * on a predetermined NIC 
	 * @return ipAddress the local IP address of the machine 
	 */
	
	
	/** 
	 * Checks all available network devices and returns 
	 * the string value of the one based on given filters
	 */
	@Override
	public String getPreferredAdapter() {
		return adapter;
	} // End getPreferredAdapter
	
	public String getLocalIP() {
		return localIP;
	} // End getLocalIP
	
	/**
	 * Returns the sorted linked list as an array for user output
	 * @return ipArray String type array containing a sorted list of all available IP addresses 
	 */
	public String[] getListAsArray() {
		String[] ipArray = new String[IPList.size()];
		
		for(int i = 0; i < IPList.size(); i++) {
			ipArray[i] = IPList.get(i);
		} // End For Loop 
		return ipArray;
	} // End getIPListAsArray

	/**
	 * Sets the value of the preferred adapter to use for scanning
	 * @throws SocketException 
	 */
	@Override
	public void setPreferredAdapter(NetworkInterface NIC)  {
		if(NIC == null) {
			throw new NullPointerException("Adapter has to be a valid NIC");
		} // End If Statement
		
		// Set adapter 
		adapter = NIC.getName();
		
		Enumeration<InetAddress> inetAddresses = NIC.getInetAddresses();
		
		// Set Local IP Address 
		for (InetAddress inetAddress : Collections.list(inetAddresses)) {
			if(inetAddress.isSiteLocalAddress()) {
				localIP = inetAddress.getHostAddress();
			} // End If Statement 
        } // End For Loop 
	} // End setPreferredAdapter
	
	public void ScanNetRange() {
		ipAddress = localIP.substring(0, localIP.lastIndexOf(".") + 1);
		

		ThreadPing newThread = new ThreadPing(ipAddress + String.valueOf(i));
		newThread.start();
		} // End For Loop
	} // End ScanNetRange
	
	
	/**
	 * Inner class that handles multi threading 
	 * @author Richard Howe 
	 *
	 */
	class ThreadPing extends Thread {
		String ipAddress;
		/**
		 * Constructor for the parent class 
		 * @param s Parameter passe to the new thread
		 */
		public ThreadPing (String ip) {
			super(ip);
			ipAddress = ip;
		} // End ThreadPing 
		
		/**
		 * Method that is ran inside of the new thread 
		 */
		public void run() {
			for(int i = 0; i < 256; i++) {
				Process p = null;
				
				try {
					p = Runtime.getRuntime().exec("ping -c 1 " + ipAddress +  String.valueOf(i));
				} // End Try Block
				catch (IOException e) {
					e.printStackTrace();
				} // End Catch Block 
				
				
				try {
					p.waitFor();
					
					if(p.exitValue() == 0) {
						IPList.add(ipAddress +  String.valueOf(i));
						System.out.println(IPList.size());
					} // End If Statement 
					
				} // End Try Block 
				catch (InterruptedException e) {
					e.printStackTrace();
				} // End Catch Block 
		} // End run
	} // End ThreadPing
} // End Scanner 

