package com.framework.execute;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

public class ExecuteTestSuite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				TestNG runner=new TestNG();
				List<String> suitefiles=new ArrayList<String>();
				suitefiles.add("/Users/apple/rose/testingframework/AutomationTest/src/com/framework/testscrips/TestSuiteSetUp.java");
				runner.setTestSuites(suitefiles);
				runner.run();
	}
}
