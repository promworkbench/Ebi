package org.processmining.ebi.objects;

import org.processmining.framework.plugin.PluginContext;
import org.processmining.framework.util.HTMLToString;

public class EbiContainsRoot {
	public static HTMLToString fromEbiString(PluginContext context, String value) {
		//Ebi returns the value on the first line
		return new HTMLToString() {
			
			@Override
			public String toHTMLString(boolean includeHTMLTags) {
				return value;
			}
		};
	}
}