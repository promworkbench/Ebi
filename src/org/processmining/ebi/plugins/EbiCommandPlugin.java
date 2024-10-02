package org.processmining.ebi.plugins;

import org.processmining.ebi.CallEbi;


/**
 * This file is automatically generated by Ebi. Do not edit it manually.
 * @author sander
 *
 */
public class EbiCommandPlugin {



// == command Ebi analyse all-traces == 



// == command Ebi analyse completeness == 

	public static org.processmining.framework.util.HTMLToString Ebi_analyse_completeness__as__fraction__to__fraction_html(org.deckfour.xes.model.XLog input_0) {
		String result = CallEbi.call_ebi("Ebi analyse completeness", ".frac", new String[] {org.processmining.ebi.objects.EbiEventLog.XLogToEbiEventLog(input_0)});
		return org.processmining.ebi.objects.EbiFraction.fromEbiString(result);
	}



// == command Ebi analyse medoid == 



// == command Ebi analyse minimum-probability-traces == 



// == command Ebi analyse mode == 



// == command Ebi analyse most-likely-traces == 



// == command Ebi analyse-non-stochastic alignment == 



// == command Ebi analyse-non-stochastic cluster == 



// == command Ebi analyse-non-stochastic medoid == 



// == command Ebi association all-trace-attributes == 

	//command cannot be called from Java as it takes non-standard input from the command line



// == command Ebi association trace-attribute == 

	//command cannot be called from Java as it takes non-standard input from the command line



// == command Ebi conformance entropic-relevance == 

	public static org.processmining.framework.util.HTMLToString Ebi_conformance_entropic_relevance__as__logdiv__to__logdiv_html(org.deckfour.xes.model.XLog input_0, org.deckfour.xes.model.XLog input_1) {
		String result = CallEbi.call_ebi("Ebi conformance entropic-relevance", ".logdiv", new String[] {org.processmining.ebi.objects.EbiEventLog.XLogToEbiEventLog(input_0), org.processmining.ebi.objects.EbiEventLog.XLogToEbiEventLog(input_1)});
		return org.processmining.ebi.objects.EbiLogDiv.fromEbiString(result);
	}

	public static org.processmining.framework.util.HTMLToString Ebi_conformance_entropic_relevance__as__logdiv__to__logdiv_html(org.deckfour.xes.model.XLog input_0, org.processmining.stochasticlabelledpetrinets.StochasticLabelledPetriNet input_1) {
		String result = CallEbi.call_ebi("Ebi conformance entropic-relevance", ".logdiv", new String[] {org.processmining.ebi.objects.EbiEventLog.XLogToEbiEventLog(input_0), org.processmining.ebi.objects.EbiStochasticLabelledPetriNet.LabelledPetriNet2EbiLabelledPetriNet(input_1)});
		return org.processmining.ebi.objects.EbiLogDiv.fromEbiString(result);
	}



// == command Ebi conformance jensen-shannon == 

	public static org.processmining.framework.util.HTMLToString Ebi_conformance_jensen_shannon__as__rootlogdiv__to__logdiv_html(org.deckfour.xes.model.XLog input_0, org.processmining.stochasticlabelledpetrinets.StochasticLabelledPetriNet input_1) {
		String result = CallEbi.call_ebi("Ebi conformance jensen-shannon", ".rldiv", new String[] {org.processmining.ebi.objects.EbiEventLog.XLogToEbiEventLog(input_0), org.processmining.ebi.objects.EbiStochasticLabelledPetriNet.LabelledPetriNet2EbiLabelledPetriNet(input_1)});
		return org.processmining.ebi.objects.EbiRootLogDiv.fromEbiString(result);
	}

	public static org.processmining.framework.util.HTMLToString Ebi_conformance_jensen_shannon__as__rootlogdiv__to__logdiv_html(org.deckfour.xes.model.XLog input_0, org.deckfour.xes.model.XLog input_1) {
		String result = CallEbi.call_ebi("Ebi conformance jensen-shannon", ".rldiv", new String[] {org.processmining.ebi.objects.EbiEventLog.XLogToEbiEventLog(input_0), org.processmining.ebi.objects.EbiEventLog.XLogToEbiEventLog(input_1)});
		return org.processmining.ebi.objects.EbiRootLogDiv.fromEbiString(result);
	}



// == command Ebi conformance jensen-shannon-sample == 

	public static org.processmining.framework.util.HTMLToString Ebi_conformance_jensen_shannon_sample__as__rootlogdiv__to__logdiv_html(org.processmining.stochasticlabelledpetrinets.StochasticLabelledPetriNet input_0, org.deckfour.xes.model.XLog input_1, int input_2) {
		String result = CallEbi.call_ebi("Ebi conformance jensen-shannon-sample", ".rldiv", new String[] {org.processmining.ebi.objects.EbiStochasticLabelledPetriNet.LabelledPetriNet2EbiLabelledPetriNet(input_0), org.processmining.ebi.objects.EbiEventLog.XLogToEbiEventLog(input_1), org.processmining.ebi.objects.EbiInteger.toEbiString(input_2)});
		return org.processmining.ebi.objects.EbiRootLogDiv.fromEbiString(result);
	}

	public static org.processmining.framework.util.HTMLToString Ebi_conformance_jensen_shannon_sample__as__rootlogdiv__to__logdiv_html(org.processmining.stochasticlabelledpetrinets.StochasticLabelledPetriNet input_0, org.processmining.stochasticlabelledpetrinets.StochasticLabelledPetriNet input_1, int input_2) {
		String result = CallEbi.call_ebi("Ebi conformance jensen-shannon-sample", ".rldiv", new String[] {org.processmining.ebi.objects.EbiStochasticLabelledPetriNet.LabelledPetriNet2EbiLabelledPetriNet(input_0), org.processmining.ebi.objects.EbiStochasticLabelledPetriNet.LabelledPetriNet2EbiLabelledPetriNet(input_1), org.processmining.ebi.objects.EbiInteger.toEbiString(input_2)});
		return org.processmining.ebi.objects.EbiRootLogDiv.fromEbiString(result);
	}

	public static org.processmining.framework.util.HTMLToString Ebi_conformance_jensen_shannon_sample__as__rootlogdiv__to__logdiv_html(org.deckfour.xes.model.XLog input_0, org.deckfour.xes.model.XLog input_1, int input_2) {
		String result = CallEbi.call_ebi("Ebi conformance jensen-shannon-sample", ".rldiv", new String[] {org.processmining.ebi.objects.EbiEventLog.XLogToEbiEventLog(input_0), org.processmining.ebi.objects.EbiEventLog.XLogToEbiEventLog(input_1), org.processmining.ebi.objects.EbiInteger.toEbiString(input_2)});
		return org.processmining.ebi.objects.EbiRootLogDiv.fromEbiString(result);
	}

	public static org.processmining.framework.util.HTMLToString Ebi_conformance_jensen_shannon_sample__as__rootlogdiv__to__logdiv_html(org.deckfour.xes.model.XLog input_0, org.processmining.stochasticlabelledpetrinets.StochasticLabelledPetriNet input_1, int input_2) {
		String result = CallEbi.call_ebi("Ebi conformance jensen-shannon-sample", ".rldiv", new String[] {org.processmining.ebi.objects.EbiEventLog.XLogToEbiEventLog(input_0), org.processmining.ebi.objects.EbiStochasticLabelledPetriNet.LabelledPetriNet2EbiLabelledPetriNet(input_1), org.processmining.ebi.objects.EbiInteger.toEbiString(input_2)});
		return org.processmining.ebi.objects.EbiRootLogDiv.fromEbiString(result);
	}



// == command Ebi conformance unit-earth-movers-stochastic-conformance == 

	public static org.processmining.framework.util.HTMLToString Ebi_conformance_unit_earth_movers_stochastic_conformance__as__fraction__to__fraction_html(org.deckfour.xes.model.XLog input_0, org.processmining.stochasticlabelledpetrinets.StochasticLabelledPetriNet input_1) {
		String result = CallEbi.call_ebi("Ebi conformance unit-earth-movers-stochastic-conformance", ".frac", new String[] {org.processmining.ebi.objects.EbiEventLog.XLogToEbiEventLog(input_0), org.processmining.ebi.objects.EbiStochasticLabelledPetriNet.LabelledPetriNet2EbiLabelledPetriNet(input_1)});
		return org.processmining.ebi.objects.EbiFraction.fromEbiString(result);
	}

	public static org.processmining.framework.util.HTMLToString Ebi_conformance_unit_earth_movers_stochastic_conformance__as__fraction__to__fraction_html(org.deckfour.xes.model.XLog input_0, org.deckfour.xes.model.XLog input_1) {
		String result = CallEbi.call_ebi("Ebi conformance unit-earth-movers-stochastic-conformance", ".frac", new String[] {org.processmining.ebi.objects.EbiEventLog.XLogToEbiEventLog(input_0), org.processmining.ebi.objects.EbiEventLog.XLogToEbiEventLog(input_1)});
		return org.processmining.ebi.objects.EbiFraction.fromEbiString(result);
	}



// == command Ebi convert finite-stochastic-language == 



// == command Ebi convert labelled-Petri-net == 

	public static org.processmining.acceptingpetrinet.models.AcceptingPetriNet Ebi_convert_labelled_Petri_net__as__labelled_Petri_net__to__AcceptingPetriNet(org.processmining.stochasticlabelledpetrinets.StochasticLabelledPetriNet input_0) {
		String result = CallEbi.call_ebi("Ebi convert labelled-Petri-net", ".lpn", new String[] {org.processmining.ebi.objects.EbiStochasticLabelledPetriNet.LabelledPetriNet2EbiLabelledPetriNet(input_0)});
		return org.processmining.ebi.objects.EbiLabelledPetriNet.EbiLabelledPetriNet2AcceptingPetrinet(result);
	}

	public static org.processmining.acceptingpetrinet.models.AcceptingPetriNet Ebi_convert_labelled_Petri_net__as__labelled_Petri_net__to__AcceptingPetriNet(org.processmining.acceptingpetrinet.models.AcceptingPetriNet input_0) {
		String result = CallEbi.call_ebi("Ebi convert labelled-Petri-net", ".lpn", new String[] {org.processmining.ebi.objects.EbiLabelledPetriNet.AcceptingPetrinet2EbiLabelledPetriNet(input_0)});
		return org.processmining.ebi.objects.EbiLabelledPetriNet.EbiLabelledPetriNet2AcceptingPetrinet(result);
	}



// == command Ebi convert stochastic-finite-deterministic-automaton == 

	public static org.processmining.acceptingpetrinet.models.AcceptingPetriNet Ebi_convert_stochastic_finite_deterministic_automaton__as__labelled_Petri_net__to__AcceptingPetriNet(org.deckfour.xes.model.XLog input_0) {
		String result = CallEbi.call_ebi("Ebi convert stochastic-finite-deterministic-automaton", ".lpn", new String[] {org.processmining.ebi.objects.EbiEventLog.XLogToEbiEventLog(input_0)});
		return org.processmining.ebi.objects.EbiLabelledPetriNet.EbiLabelledPetriNet2AcceptingPetrinet(result);
	}



// == command Ebi discover alignments == 

	public static org.processmining.acceptingpetrinet.models.AcceptingPetriNet Ebi_discover_alignments__as__labelled_Petri_net__to__AcceptingPetriNet(org.deckfour.xes.model.XLog input_0, org.processmining.stochasticlabelledpetrinets.StochasticLabelledPetriNet input_1) {
		String result = CallEbi.call_ebi("Ebi discover alignments", ".lpn", new String[] {org.processmining.ebi.objects.EbiEventLog.XLogToEbiEventLog(input_0), org.processmining.ebi.objects.EbiStochasticLabelledPetriNet.LabelledPetriNet2EbiLabelledPetriNet(input_1)});
		return org.processmining.ebi.objects.EbiLabelledPetriNet.EbiLabelledPetriNet2AcceptingPetrinet(result);
	}

	public static org.processmining.acceptingpetrinet.models.AcceptingPetriNet Ebi_discover_alignments__as__labelled_Petri_net__to__AcceptingPetriNet(org.deckfour.xes.model.XLog input_0, org.processmining.acceptingpetrinet.models.AcceptingPetriNet input_1) {
		String result = CallEbi.call_ebi("Ebi discover alignments", ".lpn", new String[] {org.processmining.ebi.objects.EbiEventLog.XLogToEbiEventLog(input_0), org.processmining.ebi.objects.EbiLabelledPetriNet.AcceptingPetrinet2EbiLabelledPetriNet(input_1)});
		return org.processmining.ebi.objects.EbiLabelledPetriNet.EbiLabelledPetriNet2AcceptingPetrinet(result);
	}

	public static org.processmining.stochasticlabelledpetrinets.StochasticLabelledPetriNet Ebi_discover_alignments__as__stochastic_labelled_Petri_net__to__StochasticLabelledPetriNet(org.deckfour.xes.model.XLog input_0, org.processmining.stochasticlabelledpetrinets.StochasticLabelledPetriNet input_1) {
		String result = CallEbi.call_ebi("Ebi discover alignments", ".slpn", new String[] {org.processmining.ebi.objects.EbiEventLog.XLogToEbiEventLog(input_0), org.processmining.ebi.objects.EbiStochasticLabelledPetriNet.LabelledPetriNet2EbiLabelledPetriNet(input_1)});
		return org.processmining.ebi.objects.EbiStochasticLabelledPetriNet.EbiLabelledPetriNet2LabelledPetriNet(result);
	}

	public static org.processmining.stochasticlabelledpetrinets.StochasticLabelledPetriNet Ebi_discover_alignments__as__stochastic_labelled_Petri_net__to__StochasticLabelledPetriNet(org.deckfour.xes.model.XLog input_0, org.processmining.acceptingpetrinet.models.AcceptingPetriNet input_1) {
		String result = CallEbi.call_ebi("Ebi discover alignments", ".slpn", new String[] {org.processmining.ebi.objects.EbiEventLog.XLogToEbiEventLog(input_0), org.processmining.ebi.objects.EbiLabelledPetriNet.AcceptingPetrinet2EbiLabelledPetriNet(input_1)});
		return org.processmining.ebi.objects.EbiStochasticLabelledPetriNet.EbiLabelledPetriNet2LabelledPetriNet(result);
	}



// == command Ebi discover occurrence == 

	public static org.processmining.acceptingpetrinet.models.AcceptingPetriNet Ebi_discover_occurrence__as__labelled_Petri_net__to__AcceptingPetriNet(org.deckfour.xes.model.XLog input_0, org.processmining.stochasticlabelledpetrinets.StochasticLabelledPetriNet input_1) {
		String result = CallEbi.call_ebi("Ebi discover occurrence", ".lpn", new String[] {org.processmining.ebi.objects.EbiEventLog.XLogToEbiEventLog(input_0), org.processmining.ebi.objects.EbiStochasticLabelledPetriNet.LabelledPetriNet2EbiLabelledPetriNet(input_1)});
		return org.processmining.ebi.objects.EbiLabelledPetriNet.EbiLabelledPetriNet2AcceptingPetrinet(result);
	}

	public static org.processmining.acceptingpetrinet.models.AcceptingPetriNet Ebi_discover_occurrence__as__labelled_Petri_net__to__AcceptingPetriNet(org.deckfour.xes.model.XLog input_0, org.processmining.acceptingpetrinet.models.AcceptingPetriNet input_1) {
		String result = CallEbi.call_ebi("Ebi discover occurrence", ".lpn", new String[] {org.processmining.ebi.objects.EbiEventLog.XLogToEbiEventLog(input_0), org.processmining.ebi.objects.EbiLabelledPetriNet.AcceptingPetrinet2EbiLabelledPetriNet(input_1)});
		return org.processmining.ebi.objects.EbiLabelledPetriNet.EbiLabelledPetriNet2AcceptingPetrinet(result);
	}

	public static org.processmining.stochasticlabelledpetrinets.StochasticLabelledPetriNet Ebi_discover_occurrence__as__stochastic_labelled_Petri_net__to__StochasticLabelledPetriNet(org.deckfour.xes.model.XLog input_0, org.processmining.stochasticlabelledpetrinets.StochasticLabelledPetriNet input_1) {
		String result = CallEbi.call_ebi("Ebi discover occurrence", ".slpn", new String[] {org.processmining.ebi.objects.EbiEventLog.XLogToEbiEventLog(input_0), org.processmining.ebi.objects.EbiStochasticLabelledPetriNet.LabelledPetriNet2EbiLabelledPetriNet(input_1)});
		return org.processmining.ebi.objects.EbiStochasticLabelledPetriNet.EbiLabelledPetriNet2LabelledPetriNet(result);
	}

	public static org.processmining.stochasticlabelledpetrinets.StochasticLabelledPetriNet Ebi_discover_occurrence__as__stochastic_labelled_Petri_net__to__StochasticLabelledPetriNet(org.deckfour.xes.model.XLog input_0, org.processmining.acceptingpetrinet.models.AcceptingPetriNet input_1) {
		String result = CallEbi.call_ebi("Ebi discover occurrence", ".slpn", new String[] {org.processmining.ebi.objects.EbiEventLog.XLogToEbiEventLog(input_0), org.processmining.ebi.objects.EbiLabelledPetriNet.AcceptingPetrinet2EbiLabelledPetriNet(input_1)});
		return org.processmining.ebi.objects.EbiStochasticLabelledPetriNet.EbiLabelledPetriNet2LabelledPetriNet(result);
	}



// == command Ebi discover uniform == 

	public static org.processmining.acceptingpetrinet.models.AcceptingPetriNet Ebi_discover_uniform__as__labelled_Petri_net__to__AcceptingPetriNet(org.processmining.acceptingpetrinet.models.AcceptingPetriNet input_0) {
		String result = CallEbi.call_ebi("Ebi discover uniform", ".lpn", new String[] {org.processmining.ebi.objects.EbiLabelledPetriNet.AcceptingPetrinet2EbiLabelledPetriNet(input_0)});
		return org.processmining.ebi.objects.EbiLabelledPetriNet.EbiLabelledPetriNet2AcceptingPetrinet(result);
	}

	public static org.processmining.acceptingpetrinet.models.AcceptingPetriNet Ebi_discover_uniform__as__labelled_Petri_net__to__AcceptingPetriNet(org.processmining.stochasticlabelledpetrinets.StochasticLabelledPetriNet input_0) {
		String result = CallEbi.call_ebi("Ebi discover uniform", ".lpn", new String[] {org.processmining.ebi.objects.EbiStochasticLabelledPetriNet.LabelledPetriNet2EbiLabelledPetriNet(input_0)});
		return org.processmining.ebi.objects.EbiLabelledPetriNet.EbiLabelledPetriNet2AcceptingPetrinet(result);
	}

	public static org.processmining.stochasticlabelledpetrinets.StochasticLabelledPetriNet Ebi_discover_uniform__as__stochastic_labelled_Petri_net__to__StochasticLabelledPetriNet(org.processmining.acceptingpetrinet.models.AcceptingPetriNet input_0) {
		String result = CallEbi.call_ebi("Ebi discover uniform", ".slpn", new String[] {org.processmining.ebi.objects.EbiLabelledPetriNet.AcceptingPetrinet2EbiLabelledPetriNet(input_0)});
		return org.processmining.ebi.objects.EbiStochasticLabelledPetriNet.EbiLabelledPetriNet2LabelledPetriNet(result);
	}

	public static org.processmining.stochasticlabelledpetrinets.StochasticLabelledPetriNet Ebi_discover_uniform__as__stochastic_labelled_Petri_net__to__StochasticLabelledPetriNet(org.processmining.stochasticlabelledpetrinets.StochasticLabelledPetriNet input_0) {
		String result = CallEbi.call_ebi("Ebi discover uniform", ".slpn", new String[] {org.processmining.ebi.objects.EbiStochasticLabelledPetriNet.LabelledPetriNet2EbiLabelledPetriNet(input_0)});
		return org.processmining.ebi.objects.EbiStochasticLabelledPetriNet.EbiLabelledPetriNet2LabelledPetriNet(result);
	}



// == command Ebi information == 

	public static String Ebi_information__as__string__to__string_html(org.deckfour.xes.model.XLog input_0) {
		String result = CallEbi.call_ebi("Ebi information", ".txt", new String[] {org.processmining.ebi.objects.EbiEventLog.XLogToEbiEventLog(input_0)});
		return org.processmining.ebi.objects.EbiString.fromEbiString(result);
	}

	public static String Ebi_information__as__string__to__string_html(org.processmining.stochasticlabelledpetrinets.StochasticLabelledPetriNet input_0) {
		String result = CallEbi.call_ebi("Ebi information", ".txt", new String[] {org.processmining.ebi.objects.EbiStochasticLabelledPetriNet.LabelledPetriNet2EbiLabelledPetriNet(input_0)});
		return org.processmining.ebi.objects.EbiString.fromEbiString(result);
	}

	public static String Ebi_information__as__string__to__string_html(org.processmining.acceptingpetrinet.models.AcceptingPetriNet input_0) {
		String result = CallEbi.call_ebi("Ebi information", ".txt", new String[] {org.processmining.ebi.objects.EbiLabelledPetriNet.AcceptingPetrinet2EbiLabelledPetriNet(input_0)});
		return org.processmining.ebi.objects.EbiString.fromEbiString(result);
	}



// == command Ebi latex-help graph == 

	public static String Ebi_latex_help_graph__as__string__to__string_html() {
		String result = CallEbi.call_ebi("Ebi latex-help graph", ".txt", new String[] {});
		return org.processmining.ebi.objects.EbiString.fromEbiString(result);
	}



// == command Ebi latex-help java == 

	public static String Ebi_latex_help_java__as__string__to__string_html() {
		String result = CallEbi.call_ebi("Ebi latex-help java", ".txt", new String[] {});
		return org.processmining.ebi.objects.EbiString.fromEbiString(result);
	}



// == command Ebi latex-help manual == 

	public static String Ebi_latex_help_manual__as__string__to__string_html() {
		String result = CallEbi.call_ebi("Ebi latex-help manual", ".txt", new String[] {});
		return org.processmining.ebi.objects.EbiString.fromEbiString(result);
	}



// == command Ebi probability explain-trace == 

	//command cannot be called from Java as it takes non-standard input from the command line



// == command Ebi probability model == 

	public static org.processmining.framework.util.HTMLToString Ebi_probability_model__as__fraction__to__fraction_html(org.processmining.stochasticlabelledpetrinets.StochasticLabelledPetriNet input_0, org.deckfour.xes.model.XLog input_1) {
		String result = CallEbi.call_ebi("Ebi probability model", ".frac", new String[] {org.processmining.ebi.objects.EbiStochasticLabelledPetriNet.LabelledPetriNet2EbiLabelledPetriNet(input_0), org.processmining.ebi.objects.EbiEventLog.XLogToEbiEventLog(input_1)});
		return org.processmining.ebi.objects.EbiFraction.fromEbiString(result);
	}

	public static org.processmining.framework.util.HTMLToString Ebi_probability_model__as__fraction__to__fraction_html(org.deckfour.xes.model.XLog input_0, org.deckfour.xes.model.XLog input_1) {
		String result = CallEbi.call_ebi("Ebi probability model", ".frac", new String[] {org.processmining.ebi.objects.EbiEventLog.XLogToEbiEventLog(input_0), org.processmining.ebi.objects.EbiEventLog.XLogToEbiEventLog(input_1)});
		return org.processmining.ebi.objects.EbiFraction.fromEbiString(result);
	}



// == command Ebi probability trace == 

	//command cannot be called from Java as it takes non-standard input from the command line



// == command Ebi sample == 



// == command Ebi test log-categorical-attribute == 

	//command cannot be called from Java as it takes non-standard input from the command line



// == command Ebi validate == 

	//command cannot be called from Java as it takes non-standard input from the command line



// == command Ebi visualise svg == 

	public static com.kitfox.svg.SVGDiagram Ebi_visualise_svg__as__SVG__to__svg(org.processmining.acceptingpetrinet.models.AcceptingPetriNet input_0) {
		String result = CallEbi.call_ebi("Ebi visualise svg", ".svg", new String[] {org.processmining.ebi.objects.EbiLabelledPetriNet.AcceptingPetrinet2EbiLabelledPetriNet(input_0)});
		return org.processmining.ebi.objects.EbiSvg.fromEbiString(result);
	}

	public static com.kitfox.svg.SVGDiagram Ebi_visualise_svg__as__SVG__to__svg(org.processmining.stochasticlabelledpetrinets.StochasticLabelledPetriNet input_0) {
		String result = CallEbi.call_ebi("Ebi visualise svg", ".svg", new String[] {org.processmining.ebi.objects.EbiStochasticLabelledPetriNet.LabelledPetriNet2EbiLabelledPetriNet(input_0)});
		return org.processmining.ebi.objects.EbiSvg.fromEbiString(result);
	}



// == command Ebi visualise text == 

	public static String Ebi_visualise_text__as__string__to__string_html(org.processmining.acceptingpetrinet.models.AcceptingPetriNet input_0) {
		String result = CallEbi.call_ebi("Ebi visualise text", ".txt", new String[] {org.processmining.ebi.objects.EbiLabelledPetriNet.AcceptingPetrinet2EbiLabelledPetriNet(input_0)});
		return org.processmining.ebi.objects.EbiString.fromEbiString(result);
	}

	public static String Ebi_visualise_text__as__string__to__string_html(org.processmining.stochasticlabelledpetrinets.StochasticLabelledPetriNet input_0) {
		String result = CallEbi.call_ebi("Ebi visualise text", ".txt", new String[] {org.processmining.ebi.objects.EbiStochasticLabelledPetriNet.LabelledPetriNet2EbiLabelledPetriNet(input_0)});
		return org.processmining.ebi.objects.EbiString.fromEbiString(result);
	}

	public static String Ebi_visualise_text__as__string__to__string_html(org.deckfour.xes.model.XLog input_0) {
		String result = CallEbi.call_ebi("Ebi visualise text", ".txt", new String[] {org.processmining.ebi.objects.EbiEventLog.XLogToEbiEventLog(input_0)});
		return org.processmining.ebi.objects.EbiString.fromEbiString(result);
	}

}

