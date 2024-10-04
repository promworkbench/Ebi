package org.processmining.ebi.objects;

import org.processmining.framework.plugin.PluginContext;
import org.processmining.framework.util.HTMLToString;

public class EbiLogDiv {

	public static HTMLToString fromEbiString(PluginContext context, java.lang.String value) {
		return new HTMLToString() {

			@Override
			public String toHTMLString(boolean includeHTMLTags) {
				return value;
			}
			
		};
	}

}
