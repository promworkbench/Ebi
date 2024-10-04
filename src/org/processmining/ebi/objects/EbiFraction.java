package org.processmining.ebi.objects;

import java.math.BigInteger;

import javax.swing.JComponent;

import org.apache.commons.math3.fraction.BigFraction;
import org.processmining.contexts.uitopia.annotations.UITopiaVariant;
import org.processmining.contexts.uitopia.annotations.Visualizer;
import org.processmining.contexts.util.HtmlPanel;
import org.processmining.framework.plugin.PluginContext;
import org.processmining.framework.plugin.annotations.Plugin;
import org.processmining.framework.plugin.annotations.PluginVariant;
import org.processmining.framework.util.HTMLToString;
import org.processmining.plugins.InductiveMiner.plugins.dialogs.IMMiningDialog;

public class EbiFraction {

	public static String toEbiString(PluginContext context, BigFraction value) {
		return value.toString();
	}

	public static BigFraction fromEbiString(PluginContext context, String value) {
		//Ebi returns the value on the first line
		String[] arr = value.split("\\R", 2);
		
		//split in numerator/denominator
		String[] arr2 = arr[0].split("/");
		BigInteger num = new BigInteger(arr2[0]);
		BigInteger den = new BigInteger(arr2[1]);
		
		return new BigFraction(num, den);
	}

	@Plugin(name = "Fraction", returnLabels = {"fraction visualisation" }, returnTypes = {
			JComponent.class }, parameterLabels = { "fraction" }, userAccessible = true)
	@Visualizer
	@UITopiaVariant(affiliation = IMMiningDialog.affiliation, author = IMMiningDialog.author, email = IMMiningDialog.email)
	@PluginVariant(variantLabel = "Visualise stochastic trace alignments", requiredParameterLabels = { 0 })
	public JComponent fancy(PluginContext context, BigFraction fraction) {
		return new HtmlPanel("Approximate value: " + fraction.doubleValue() + "<br>Exact value:<br>" + fraction.getNumerator() + "<br>/<br>" + fraction.getDenominator());
	}
}