package com.framework.commonutils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.opencsv.CSVReader;

public class ReaderCSV {
	
		
		/** reads the CSV file with Headers and returns the file as a List< HashMap<String,String>>
		 * @param csvFileToReadWithPath
		 * @return List< HashMap<String,String>> 
		 */
		public static List< HashMap<String,String>> readCSVWithHeaderRow(String csvFileToReadWithPath) {
		 CSVReader cr = null;  
		  String[] line = {};  
		  HashMap<String,String> oneRow;
		  List< HashMap<String,String>> allRows= new ArrayList< HashMap<String,String>>();
		  
		  try {  		  
			  cr = new CSVReader(new FileReader(csvFileToReadWithPath)); 
			  String[] headers= cr.readNext();		  
			  while ((line = cr.readNext()) != null) {
				  oneRow =  new HashMap<String,String>();
				  for(int n=0; n<line.length;n++) {				 
					  oneRow.put(headers[n], line[n]);
				  }
				  allRows.add(oneRow);
			  } //end while 		  
		  } catch (FileNotFoundException e) {  
			  System.out.println(e);
			  e.printStackTrace();
		  } catch (IOException e) {  
			  System.out.println(e);
			  e.printStackTrace();
		  } finally {  
			  if (cr != null) {  
				  try {  
					  	cr.close();  
				  } catch (IOException e) {  
					  e.printStackTrace();
				  }  
			  }  
		  }  		  
		  System.out.println("Done with reading CSV");
		  return allRows;
		}
		
		/**
		 * reads the CSV file without Headers(need to pass the headers as a List<String>)  and returns the file as a List< HashMap<String,String>>
		 * @param csvFileToReadWithPath
		 * @param headers
		 * @return List< HashMap<String,String>> 
		 */
		public static List< HashMap<String,String>> readCSVWithoutHeaderRow(String csvFileToReadWithPath,List<String> headers) {
			 CSVReader cr = null;  
			  String[] line = {};  
			  HashMap<String,String> oneRow;
			  List< HashMap<String,String>> allRows= new ArrayList< HashMap<String,String>>();		  		  
			  try {  		  
				  cr = new CSVReader(new FileReader(csvFileToReadWithPath)); 			  		  
				  while ((line = cr.readNext()) != null) {
					  oneRow =  new HashMap<String,String>();
					  for(int n=0; n<line.length;n++) {				 
						  oneRow.put(headers.get(n), line[n]);
					  }
					  allRows.add(oneRow);
				  } //end while 		  
			  } catch (FileNotFoundException e) {  
				  System.out.println(e);
			  } catch (IOException e) {  
				  System.out.println(e);
			  } finally {  
				  if (cr != null) {  
					  try {  
						  	cr.close();  
					  } catch (IOException e) {  
						  System.out.println(e);  
					  }  
				  }  
			  }  		  
			  System.out.println("Done with reading CSV");
			  return allRows;
			}
		
		/*public static void main(String[] args) {
			List< HashMap<String,String>> allRows = readCSVWithHeaders("C:\\Users\\yume\\Desktop\\PubExc_80_81.csv");
			System.out.println(allRows);
		}*/
		
	


}
