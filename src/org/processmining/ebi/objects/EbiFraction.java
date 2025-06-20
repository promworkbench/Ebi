package org.processmining.ebi.objects;

import java.math.BigInteger;

import javax.swing.JComponent;
import javax.swing.JSlider;
import javax.swing.SwingConstants;

import org.apache.commons.math3.fraction.BigFraction;
import org.processmining.contexts.uitopia.annotations.UITopiaVariant;
import org.processmining.contexts.uitopia.annotations.Visualizer;
import org.processmining.contexts.util.HtmlPanel;
import org.processmining.ebi.plugins.EbiDialog.EbiDialogPanel;
import org.processmining.framework.plugin.PluginContext;
import org.processmining.framework.plugin.annotations.Plugin;
import org.processmining.framework.plugin.annotations.PluginVariant;
import org.processmining.plugins.InductiveMiner.plugins.dialogs.IMMiningDialog;

import com.fluxicon.slickerbox.factory.SlickerFactory;

public class EbiFraction {

	public static String toEbiString(PluginContext context, BigFraction value) {
		return value.toString().replaceAll(" ", "");
	}

	public static BigFraction fromEbiString(PluginContext context, String value) {
		//Ebi returns the value on the first line
		String[] arr = value.split("\\R", 2);
		
		//split in numerator/denominator
		String[] arr2 = arr[0].split("/");
		BigInteger num = new BigInteger(arr2[0]);
		BigInteger den;
		if (arr2.length > 1) {
			den = new BigInteger(arr2[1]);
		} else {
			den = new BigInteger("1");
		}
		
		return new BigFraction(num, den);
	}
	
	

	@Plugin(name = "Fraction", returnLabels = {"fraction visualisation" }, returnTypes = {
			JComponent.class }, parameterLabels = { "fraction" }, userAccessible = true)
	@Visualizer
	@UITopiaVariant(affiliation = IMMiningDialog.affiliation, author = IMMiningDialog.author, email = IMMiningDialog.email)
	@PluginVariant(variantLabel = "Visualise fraction", requiredParameterLabels = { 0 })
	public JComponent fancy(PluginContext context, BigFraction fraction) {
		return new HtmlPanel("Approximate value: " + fraction.doubleValue() + "<br>Exact value:<br>" + fraction.getNumerator() + "<br>/<br>" + fraction.getDenominator());
	}

	public static EbiDialogPanel create_input_panel(String string) {
		SlickerFactory factory = SlickerFactory.instance();
		
		return new EbiDialogPanel() {
			
			JSlider noiseSlider;
			
			@Override
			public Object getValue() {
				return new BigFraction(noiseSlider.getValue(), 1000);
			}
			
			@Override
			public JComponent create_right() {
				noiseSlider = factory.createSlider(SwingConstants.HORIZONTAL);
				noiseSlider.setMinimum(0);
				noiseSlider.setMaximum(1000);
				noiseSlider.setValue((int) (0 * 1000));
				return noiseSlider;
			}
			
			@Override
			public JComponent create_left() {
				return factory.createLabel(string);
			}
		};
	}
}