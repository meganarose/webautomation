package com.framework.commonutils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

public class IndeedJobSearchDataProvider {
	
	  @DataProvider(name = "dataFromCSV")
		public Iterator<Object[]> getCsvData() {
			HashMap<String,String> val = null;
			ReaderCSV readCSV = new ReaderCSV();
			List<HashMap<String,String>> values = readCSV.readCSVWithHeaderRow("./testdata/testdata.csv");
			Collection<Object[]> dp = new ArrayList<Object[]>();
			for(HashMap<String, String> value:values) {
				dp.add(new Object[] {value});
			}
			return dp.iterator();
			
		}
	  
	  public static void main(String args[]) {

			HashMap<String,String> val = new HashMap<String,String>();
			ReaderCSV readCSV = new ReaderCSV();
			List<HashMap<String,String>> values = readCSV.readCSVWithHeaderRow("./testdata/testdata.csv");
			System.out.println(values);
			Collection<Object[]> dp = new ArrayList<Object[]>();
			for(HashMap<String, String> value:values) {
				dp.add(new Object[] {value});
			}
			System.out.println(dp);
			
		
	  }
}
