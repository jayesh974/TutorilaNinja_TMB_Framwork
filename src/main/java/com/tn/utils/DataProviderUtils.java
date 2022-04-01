package com.tn.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.testng.annotations.DataProvider;
import com.tn.constants.FrameworkConstants;

public final class DataProviderUtils {
	
	private DataProviderUtils() {}
	
	private static List<Map<String, String>> list =	new ArrayList<>();
	
	/**
	 * Acts as a data provider for all the test cases.
	 * Parallel=true indicates that each of the iteration will be ran in parallel.
	 * 
	 * @author Amuthan Sakthivel
	 * Jan 22, 2021
	 * @param m {@link java.lang.reflect.Method} holds the information about the testcases at runtime
	 * @return Object[] containing the List. Each index of the list contains HashMap and each of them
	 * contains the test data needed to run the iterations.
	 *  
	 * 
	 * @see com.tmb.tests.AmazonDemoTest 
	 * @see com.tmb.listeners.AnnotationTransformer
	 */
	@DataProvider(parallel=false)
	public static Object[] getData(Method m) {
		String testname = m.getName();
		
		if(list.isEmpty()) {
			list = ExcelUtils.getTestDetails(FrameworkConstants.getIterationDatasheet());
			System.out.println(list);
		}
		
		List<Map<String, String>> smalllist = new ArrayList<>();
		
		for(int i=0;i<list.size();i++) {
			if(list.get(i).get("testname").equalsIgnoreCase(testname) &&  
					list.get(i).get("execute").equalsIgnoreCase("yes")) {
						smalllist.add(list.get(i));
			}
		}
		System.out.println("smalllist "+smalllist);
		return smalllist.toArray();
		
	}
	
}
