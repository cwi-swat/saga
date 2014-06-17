package nl.cwi.saga.breader;

import java.io.*;

public class BReader {
	
	BufferedReader readFile(String fileLoc) throws IOException {
		String thisLine;
		
    		BufferedReader br = new BufferedReader(new FileReader(fileLoc));
    		while ((thisLine = br.readLine()) != null) {
    			System.out.println(thisLine);
    		}
    		return br;
	}

	public static void main(String[] args) throws IOException {
	    BReader b = new BReader();
	    BufferedReader br = b.readFile(args[0]);
	    br.close();
	}
}
