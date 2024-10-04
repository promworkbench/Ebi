package org.processmining.ebi.objects;

import java.math.BigInteger;

import javax.swing.JComponent;

import org.processmining.contexts.uitopia.annotations.UITopiaVariant;
import org.processmining.contexts.uitopia.annotations.Visualizer;
import org.processmining.contexts.util.HtmlPanel;
import org.processmining.framework.plugin.PluginContext;
import org.processmining.framework.plugin.annotations.Plugin;
import org.processmining.framework.plugin.annotations.PluginVariant;
import org.processmining.plugins.InductiveMiner.plugins.dialogs.IMMiningDialog;

public class EbiLogDiv {
	
	public BigInteger a;
	public BigInteger b;
	public BigInteger c;
	
	public String approximate;

	public static EbiLogDiv fromEbiString(PluginContext context, String value) {
		//Ebi returns the value on the first line
		String[] arr = value.split("\\R", 2);
		
		//split in numerator/denominator
		String[] arr2 = arr[0].split("/");
		
		EbiLogDiv result = new EbiLogDiv();
		result.a = new BigInteger(arr2[0].substring(4));
		result.b = new BigInteger(arr2[1].substring(0, arr2[1].length() - 1));
		result.c = new BigInteger(arr2[2]);
		
		result.approximate = arr[0].substring(15);
		
		return result;
	}

	@Plugin(name = "LogDiv", returnLabels = {"logdiv visualisation" }, returnTypes = {
			JComponent.class }, parameterLabels = { "logdiv" }, userAccessible = true)
	@Visualizer
	@UITopiaVariant(affiliation = IMMiningDialog.affiliation, author = IMMiningDialog.author, email = IMMiningDialog.email)
	@PluginVariant(variantLabel = "Visualise logdiv", requiredParameterLabels = { 0 })
	public JComponent fancy(PluginContext context, EbiLogDiv logdiv) {
		return new HtmlPanel("Approximate value: " + logdiv.approximate + "<br>Exact value: log(<br>" + logdiv.a + "<br>/<br>" + logdiv.b + ") / <br>" + logdiv.c);
	}
}