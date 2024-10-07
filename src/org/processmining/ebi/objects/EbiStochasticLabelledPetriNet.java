package org.processmining.ebi.objects;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.processmining.framework.plugin.PluginContext;
import org.processmining.stochasticlabelledpetrinets.StochasticLabelledPetriNetSimpleWeights;
import org.processmining.stochasticlabelledpetrinets.plugins.StochasticLabelledPetriNetExportPlugin;
import org.processmining.stochasticlabelledpetrinets.plugins.StochasticLabelledPetriNetImportPlugin;

public class EbiStochasticLabelledPetriNet {

	public static String StochasticLabelledPetriNet2EbiString(PluginContext context, StochasticLabelledPetriNetSimpleWeights slpn) throws IOException {
		return StochasticLabelledPetriNetExportPlugin.export(slpn).toString();
	}

	public static StochasticLabelledPetriNetSimpleWeights EbiString2StochasticLabelledPetriNet(PluginContext context, String value) throws IOException {
		InputStream stream = IOUtils.toInputStream(value, "UTF-8");
		return StochasticLabelledPetriNetImportPlugin.read(stream);
	}

}
