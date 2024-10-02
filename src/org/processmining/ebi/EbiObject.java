package org.processmining.ebi;

/**
 * Contract: must also have a static T fromEbiString(String) method.
 * @author sander
 *
 * @param <T>
 */
public interface EbiObject {
	String toEbiString();
	
}
