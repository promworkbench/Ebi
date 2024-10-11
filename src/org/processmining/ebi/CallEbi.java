package org.processmining.ebi;

import org.processmining.framework.plugin.annotations.Plugin;

@Plugin(name = "Your plug-in name", parameterLabels = { "Name of your first input", "Name of your second input", "Name of your parameters" }, 
	    returnLabels = { "Name of your output" }, returnTypes = { Object.class }, help = "Call Ebi from ProM")
public class CallEbi {
	
	// This declares that the static `hello` method will be provided
    // a native library.
	/*
	 * How to get the header file:
	 * copy all .jar files from the Ivy cache to the lib folder of the ProM package
	 * javac -h . -cp .ebi.jar:lib/* src/org/processmining/ebi/CallEbi.java
	 */
    static native String call_ebi_internal(String command_name, String output_format, String[] inputs);
    
    
    /**
     * For ProM developers: 
     * 
     * - Download a version of Ebi for your Operating System from  
     */
    
    static {
        try {
        	System.loadLibrary("ebi");
        	System.out.println("Ebi library loaded");
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }
    
    public static String call_ebi(String command_name, String output_format, String[] inputs) {
    	for (String input: inputs) {
    		if (input == null) {
    			throw new RuntimeException("Ebi does not support null parameters.");
    		}
    	}
    	
    	String result = call_ebi_internal(command_name, output_format, inputs);
    	System.out.println("== ProM received");
    	System.out.println(result);
    	return result;
    }
    
}