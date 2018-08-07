import java.io.File;
import java.io.IOException;
import java.util.*;
import javax.swing.JFileChooser;

public class SortArray {
	// File Parameters
	String filePath;
	String fileName;
	String keyPath;
	String keyName;
	// End of File Parameters

	// Sequential Search Parameters
	double AATx;// this is the Average Access Time
	// Successful search
	double numKeys;
	double numComps;

	// unsuccessful search
	double numUnsucess;
	double numUnsComps;
	// End of Sequential Search Parameters

	// Binary Search Parameters
	double AATBinary;// this is the Average Access Time
	// Successful search
	double numKeysBinary;
	double numComsBinary;

	// unsuccessful search
	double numUnBinary;
	double numUnComBinary;
	// End of Binary Search

	// setting the array.
	int[] orginalFile = new int[9999999];
	int[] sortFile ;
	int[] keysFile = new int[9999999];

	// We are setting everything to 0
	int dataItems = 0;
	int numbOfKeys = 0;
	static int totalComps = 0;

	long diffTime = 0;
	public SortArray() {
		filePath = null;
		fileName = null;
		keyPath = null;
		keyName = null;
	}

	public void OpenDataFile() throws IOException {// This method is opening the data File and throws IOException  handles the external files.
		JFileChooser chooser = new JFileChooser();
		chooser.setDialogType(JFileChooser.OPEN_DIALOG);
		chooser.setDialogTitle("Open Data File");

		int returnVal = chooser.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {// in the dialog you get to file the file.
			filePath = chooser.getSelectedFile().getPath();
			fileName = chooser.getSelectedFile().getName();
		}

		if (filePath != null) {

			try {

				int integer = 0;
				Scanner integerTextFile  = new Scanner(new File(filePath));
				while (integerTextFile .hasNext()) { // Return true if the Scanner has a token in its output

					orginalFile[integer] = integerTextFile .nextInt();
					integer++;
				}
				integerTextFile .close();
				dataItems = integer;
			}

			catch (IOException ioe) {// after the try block the constructor throws the IOExecption ioe

				System.exit(0);
			}
		} 
		else
			dataItems = 0;
	}



	// Method for OpenKeyFile 
	public void OpenKeyFile() throws IOException { // This method is opening the data File and throws IOException  handles the external files.
		JFileChooser chooser = new JFileChooser();
		chooser.setDialogType(JFileChooser.OPEN_DIALOG);
		chooser.setDialogTitle("Open Data File");

		int returnVal = chooser.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) { // in the dialog you get to file the file.
			keyPath = chooser.getSelectedFile().getPath();
			keyName = chooser.getSelectedFile().getName();
		}
		if (filePath != null) {// The path file 
			try {
				int integer = 0;
				Scanner integerTextFile  = new Scanner(new File(keyPath));
				while (integerTextFile .hasNext()) { // Return true if the Scanner has a token in its output
					orginalFile[integer] = integerTextFile .nextInt();
					integer++;
				}
				integerTextFile .close();
				numbOfKeys = integer;
			} 
			catch (IOException ioe) { // after the try block the constructor throws the IOExecption ioe
				System.exit(0);
			}
		} 
		else{
			numbOfKeys = 0;
		}
	}


	//Method for SequentialSearch
	public  void SequentialSearch() {// This method build the Sequential Search.

		//double AATx = 0;
		// Successful search
		//double numKeys = 0;
		//double numComps = 0;
		// unsuccessful search
		//double numUnsucess = 0;
		//double numUnsComps = 0;
		int totalComps;
		//long timeStart;
		//long diffTime;

		long timeStart = System.nanoTime();

		for (int as = 0; as < numbOfKeys; as++) {// Comparing the keys

			boolean found = false;
			int Key = keysFile[as];
			totalComps = 0;
			//System.out.println("hello World!");

			for (int count = 0; count < dataItems; count++) {// Note:
				totalComps++;
				if (Key == orginalFile[count]) {
					found = true;
				}
				if (found)
					break; // If this is true it stops the search.
			}
			if (found) { // when data or key is found their will be a loop that 
				numComps = numComps + totalComps;
				numKeys++;
			} 
			else { // if that 
				numUnsComps = numUnsComps + totalComps;
				numUnsucess++;
			}
		}

		diffTime = System.nanoTime() - timeStart;
		System.out.println( Math.abs((diffTime / numbOfKeys)));
		if (numbOfKeys != 0) {
			AATx = Math.abs((diffTime / numbOfKeys));
		}
		else {
			AATx = 0;

		}
		if (numComps != 0) {
			numComps = Math.abs((numComps / numKeys) * 100) / 100;
		} else {
			numComps = 0;
		}
		if (numUnsucess != 0) {
			numUnsComps = Math.abs((numUnsComps / numUnsucess) * 100) / 100;
		} 
		else {
			numUnsucess = 0;
		}
		return;
	}
	//Method for searchBinary
	public static int searchBinary( int [] arr, int key )
	{
		int start = 0;
		int end = arr.length - 1;
		int middle;
		while ( end >= start )
		{
			middle = ( start + end )/ 2;
			totalComps++;// element in middle of array
			if ( arr[middle] == key )
			{  
				return middle;
			}                                // key found at middle
			else if ( arr[middle] > key )
			{  end = middle - 1;  }                           // search left side of array
			else
			{  start = middle + 1; }                          // search right side of array
		}
		return -1;
	}

	//Method for BinarySearch
	public void BinarySearch() {

		//	
		// Successful search
		//double numKeysBinary = 0;
		//double numComsBinary = 0;
		// unsuccessful search
		//double numUnBinay = 0;
		//double numUnComBinary = 0;
		//int totalComps;
		//long timeStart;
		//long diffTime;

		//int[] orginalFile = new int[199999];
		//int[] sortFile;
		int[] sortFile = new int[dataItems];

		for (int af = 0; af < dataItems; af++) {
			//boolean found = false;
			sortFile[af] = orginalFile[af];
		}
		for (int number : sortFile ){

		}
	
		java.util.Arrays.sort(sortFile);//The array will be sorted here.

		long timeStart = System.nanoTime();//This is were the time calculation starts.
		//totalComps = 0;
		for (int count = 0; count < numbOfKeys; count++) {
			/*totalComps++;*/
			int keyBinarySearch = keysFile[count];
			totalComps = 0;
			int found = searchBinary(sortFile,keyBinarySearch);

			//if (Key == orginalFile[count]) {
			//	found = true;
			//}
			//if (found)
			//	break;
			//}
			if (found>=0) {
				numComsBinary = numComsBinary + totalComps;
				numKeysBinary++;
			} 
			if(found < 0) {
				numUnComBinary = numUnComBinary + totalComps;
				numUnBinary++;
			}
			diffTime = System.nanoTime()- timeStart;


			System.out.println( Math.abs((diffTime / numbOfKeys)));
			if (numbOfKeys != 0) {//start the calculation to the number of keys.
				AATBinary = Math.abs(diffTime / numbOfKeys);
			} 
			else {
				AATBinary = 0;
			}
			if (numComsBinary != 0) {
				numComsBinary = Math.abs((numComsBinary / numKeysBinary) * 100) / 100;
			} 
			else {
				numComsBinary = 0;
			}
			if (numUnBinary != 0) {
				numUnComBinary = Math.abs((numUnComBinary / numUnBinary) * 100) / 100;
			} 
			else {
				numUnBinary = 0;
			}
			return;
		}
	}



}



