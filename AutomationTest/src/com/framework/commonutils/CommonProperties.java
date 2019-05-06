package com.framework.commonutils;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class CommonProperties {
	
	public Map<Object,Object> readPropertiesFile(String filename) {
		Map<Object, Object> hp = new HashMap<Object, Object>();
		try(InputStream input= new FileInputStream("./config/UIconfi.properties")){
			Properties property = new Properties();
			
			if(input==null) {
				System.out.println("Sorry file is empty");
				
			}
			property.load(input);
			property.forEach((K,V)->hp.put(K, V));
			//Enumeration e = property.propertyNames();
         /*   while (e.hasMoreElements()) {
                String key = (String) e.nextElement();
                String value = property.getProperty(key);
                System.out.println("Key : " + key + ", Value : " + value);
                hp.put(key, value);
            }:*/
		hp.forEach((key,value)->System.out.println("Key =" +key));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hp;
		
	}
	
	   public static void main(String[] args) throws Exception
	   {
	      //Build reader instance
		   CSVParser csvParser = new CSVParserBuilder().withSeparator(',').build();
	      CSVReader reader = new CSVReaderBuilder(new FileReader("./testdata/testdata.csv")).withCSVParser(csvParser).build();
	       
	      //Read all rows at once
	      List<String[]> allRows = reader.readAll();
	       
	      //Read CSV line by line and use the string array as you want
	     for(String[] row : allRows){
	        System.out.println(Arrays.toString(row));
	     }
	   }

}
