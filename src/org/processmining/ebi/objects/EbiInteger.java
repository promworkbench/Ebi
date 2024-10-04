package org.processmining.ebi.objects;

import org.processmining.ebi.plugins.EbiDialog.EbiDialogPanel;
import org.processmining.framework.plugin.PluginContext;
import org.processmining.framework.util.HTMLToString;

public class EbiInteger {

	public static String toEbiString(PluginContext context, int value) {
		// TODO Auto-generated method stub
		return null;
	}

	public static HTMLToString fromEbiString(PluginContext context, java.lang.String value) {
		return new HTMLToString() {

			@Override
			public String toHTMLString(boolean includeHTMLTags) {
				return value;
			}
			
		};
	}

	public static EbiDialogPanel create_input_panel(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
