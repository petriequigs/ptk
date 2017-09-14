//------------------------------------------------------------------------------
// File..: HackerReader.java
// Desc..: Reads STDIN input lines commonly used by HackerRank
//------------------------------------------------------------------------------
import java.util.*;
import java.io.*;


class HackerReader {

    public static void main(String[] args){

	List<String> linesRead = new ArrayList<String>();

	Scanner scanner = new Scanner(System.in);
	while(scanner.hasNext()){
	    String myString = scanner.nextLine();
	    linesRead.add(myString);
	}
	
	//Display the entire input
	for(int cntr=0; cntr<linesRead.size(); cntr++){
	    System.out.println(linesRead.get(cntr));
	}

	//Display just the first line broken into a list
	if(linesRead.size()>0){
	    List parts = lineParts_SpaceSplit(linesRead.get(0));
	    System.out.println(parts);
	}
	

    }

    //---------------------------------------------------------------------------
    // Method.: ineParts_SpaceSplit
    // Desc...: List of line parts based on a space delimiter
    //---------------------------------------------------------------------------
    static List lineParts_SpaceSplit(String line){

	List<String> lineParts = new ArrayList<String>();

	String[] lparts = line.split(" ");

	for(int lcntr=0;lcntr<lparts.length;lcntr++){
	    lineParts.add(lparts[lcntr]);
	}

	return lineParts;
    }
}
