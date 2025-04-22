package org.processmining.ebi.objects;

import org.processmining.framework.plugin.PluginContext;

public class EbiBoolean {

	public static String toEbiString(PluginContext context, boolean value) {
		return Boolean.toString(value);
	}

	public static boolean fromEbiString(PluginContext context, String value) {
		return Boolean.parseBoolean(value);
	}

}