package org.processmining.ebi.objects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.processmining.acceptingpetrinet.models.AcceptingPetriNet;
import org.processmining.framework.plugin.PluginContext;
import org.processmining.models.graphbased.directed.petrinet.Petrinet;
import org.processmining.models.graphbased.directed.petrinet.PetrinetEdge;
import org.processmining.models.graphbased.directed.petrinet.PetrinetNode;
import org.processmining.models.graphbased.directed.petrinet.elements.Place;
import org.processmining.models.graphbased.directed.petrinet.elements.Transition;
import org.processmining.models.graphbased.directed.petrinet.impl.PetrinetImpl;
import org.processmining.models.semantics.petrinet.Marking;
import org.processmining.stochasticlabelledpetrinets.StochasticLabelledPetriNetSimpleWeightsImpl;
import org.processmining.stochasticlabelledpetrinets.plugins.StochasticLabelledPetriNetImportPlugin;

import gnu.trove.map.TIntObjectMap;
import gnu.trove.map.TObjectIntMap;
import gnu.trove.map.hash.TIntObjectHashMap;
import gnu.trove.map.hash.TObjectIntHashMap;

public class EbiLabelledPetriNet {

	public static String AcceptingPetriNet2EbiString(PluginContext context, AcceptingPetriNet apn) throws Exception {
		StringBuilder w = new StringBuilder();

		w.append("stochastic labelled Petri net\n");
		w.append("# number of places\\n");
		w.append(apn.getNet().getPlaces().size() + "\n");

		w.append("# initial marking\\n");
		TObjectIntMap<Place> placemap = new TObjectIntHashMap<>();
		{
			int place = 0;
			for (Place place_object : apn.getNet().getPlaces()) {
				placemap.put(place_object, place);

				// initial marking
				for (int x = 0; x < apn.getInitialMarking().occurrences(place_object); x++) {
					w.append(place + "\n");
				}

				place++;
			}
		}

		w.append("# number of transitions\\n");
		w.append(apn.getNet().getTransitions().size() + "\n");
		int transition = 0;
		for (Transition transition_object : apn.getNet().getTransitions()) {
			w.append("# transition " + transition + "\n");
			if (transition_object.isInvisible()) {
				w.append("silent\n");
			} else {
				w.append("label " + StringEscapeUtils.escapeJava(transition_object.getLabel()) + "\n");
			}

			w.append("# number of input places\n");
			w.append(apn.getNet().getInEdges(transition_object).size() + "\n");
			for (PetrinetEdge<? extends PetrinetNode, ? extends PetrinetNode> edge : apn.getNet()
					.getInEdges(transition_object)) {
				Place place_object = (Place) edge.getSource();
				int place = placemap.get(place_object);
				w.append(place + "\n");
			}

			w.append("# number of output places\n");
			w.append(apn.getNet().getOutEdges(transition_object).size() + "\n");
			for (PetrinetEdge<? extends PetrinetNode, ? extends PetrinetNode> edge : apn.getNet()
					.getOutEdges(transition_object)) {
				Place place_object = (Place) edge.getTarget();
				int place = placemap.get(place_object);
				w.append(place + "\n");
			}

			transition++;
		}

		return w.toString();
	}

	public static PetrinetImpl EbiString2Petrinet(PluginContext context, String input) throws IOException {
		PetrinetImpl result = new PetrinetImpl("");
		Marking marking = new Marking();

		BufferedReader r = new BufferedReader(new InputStreamReader(IOUtils.toInputStream(input, "UTF-8")));
		StochasticLabelledPetriNetImportPlugin.getNextLine(r); // read the header

		// initial marking
		int numberOfPlaces = Integer.parseInt(StochasticLabelledPetriNetImportPlugin.getNextLine(r));
		TIntObjectMap<Place> placemap = new TIntObjectHashMap<>();
		for (int place = 0; place < numberOfPlaces; place++) {
			Place place_object = result.addPlace("");

			int inInitialMarking = Integer.parseInt(StochasticLabelledPetriNetImportPlugin.getNextLine(r));
			if (inInitialMarking > 0) {
				marking.add(place_object, inInitialMarking);
			}
		}

		int numberOfTransitions = Integer.parseInt(StochasticLabelledPetriNetImportPlugin.getNextLine(r));
		for (int transition = 0; transition < numberOfTransitions; transition++) {
			Transition transition_object;
			String line = StochasticLabelledPetriNetImportPlugin.getNextLine(r);
			if (line.startsWith("silent")) {
				transition_object = result.addTransition("");
				transition_object.setInvisible(true);
			} else if (line.startsWith("label ")) {
				transition_object = result.addTransition(line.substring(6));
				transition_object.setInvisible(false);
			} else {
				throw new RuntimeException("invalid transition");
			}

			// incoming places
			{
				int numberOfIncomingPlaces = Integer.parseInt(StochasticLabelledPetriNetImportPlugin.getNextLine(r));
				for (int p = 0; p < numberOfIncomingPlaces; p++) {
					int place = Integer.parseInt(StochasticLabelledPetriNetImportPlugin.getNextLine(r));
					Place place_object = placemap.get(place);
					result.addArc(place_object, transition_object);
				}
			}

			// outgoing places
			{
				int numberOfOutgoingPlaces = Integer.parseInt(StochasticLabelledPetriNetImportPlugin.getNextLine(r));
				for (int p = 0; p < numberOfOutgoingPlaces; p++) {
					int place = Integer.parseInt(StochasticLabelledPetriNetImportPlugin.getNextLine(r));
					Place place_object = placemap.get(place);
					result.addArc(transition_object, place_object);
				}
			}
		}

		r.close();

		return result;
	}
<<<<<<< HEAD
	
//	public static String PetriNet2EbiString(PluginContext context, Petrinet apn) {
//		StringBuilder w = new StringBuilder();
//		
//		w.append("stochastic labelled Petri net\n");
//		w.append("# number of places\\n");
//		w.append(apn.getPlaces().size() + "\n");
//
//		w.append("# initial marking\\n");
//		TObjectIntMap<Place> placemap = new TObjectIntHashMap<>();
//		{
//			int place = 0;
//			for (Place place_object: apn.getPlaces()) {
//				placemap.put(place_object, place);
//				
//				//initial marking
//				for (int x = 0; x < apn.getInitialMarking().occurrences(place_object); x++) {
//					w.append(place + "\n");
//				}
//				
//				place++;
//			}
//		}
//
//		w.append("# number of transitions\\n");
//		w.append(apn.getTransitions().size() + "\n");
//		int transition = 0;
//		for (Transition transition_object: apn.getTransitions()) {
//			w.append("# transition " + transition + "\n");
//			if (transition_object.isInvisible()) {
//				w.append("silent\n");
//			} else {
//				w.append("label " + StringEscapeUtils.escapeJava(transition_object.getLabel()) + "\n");
//			}
//
//			w.append("# number of input places\n");
//			w.append(apn.getInEdges(transition_object).size() + "\n");
//			for (PetrinetEdge<? extends PetrinetNode, ? extends PetrinetNode> edge : apn.getInEdges(transition_object)) {
//				Place place_object = (Place) edge.getSource();
//				int place = placemap.get(place_object);
//				w.append(place + "\n");
//			}
//
//			w.append("# number of output places\n");
//			w.append(apn.getOutEdges(transition_object).size() + "\n");
//			for (PetrinetEdge<? extends PetrinetNode, ? extends PetrinetNode> edge : apn.getOutEdges(transition_object)) {
//				Place place_object = (Place) edge.getTarget();
//				int place = placemap.get(place_object);
//				w.append(place + "\n");
//			}
//			
//			transition++;
//		}
//		
//		return w.toString();
//	}
=======

	public static String PetriNet2EbiString(PluginContext context, Petrinet apn) {
		StringBuilder w = new StringBuilder();

		w.append("stochastic labelled Petri net\n");
		w.append("# number of places\\n");
		w.append(apn.getPlaces().size() + "\n");

		w.append("# initial marking\\n");
		TObjectIntMap<Place> placemap = new TObjectIntHashMap<>();
		{
			int place = 0;
			for (Place place_object : apn.getPlaces()) {
				placemap.put(place_object, place);

				// initial marking
				for (int x = 0; x < apn.getInitialMarking().occurrences(place_object); x++) {
					w.append(place + "\n");
				}

				place++;
			}
		}

		w.append("# number of transitions\\n");
		w.append(apn.getTransitions().size() + "\n");
		int transition = 0;
		for (Transition transition_object : apn.getTransitions()) {
			w.append("# transition " + transition + "\n");
			if (transition_object.isInvisible()) {
				w.append("silent\n");
			} else {
				w.append("label " + StringEscapeUtils.escapeJava(transition_object.getLabel()) + "\n");
			}

			w.append("# number of input places\n");
			w.append(apn.getInEdges(transition_object).size() + "\n");
			for (PetrinetEdge<? extends PetrinetNode, ? extends PetrinetNode> edge : apn
					.getInEdges(transition_object)) {
				Place place_object = (Place) edge.getSource();
				int place = placemap.get(place_object);
				w.append(place + "\n");
			}

			w.append("# number of output places\n");
			w.append(apn.getOutEdges(transition_object).size() + "\n");
			for (PetrinetEdge<? extends PetrinetNode, ? extends PetrinetNode> edge : apn
					.getOutEdges(transition_object)) {
				Place place_object = (Place) edge.getTarget();
				int place = placemap.get(place_object);
				w.append(place + "\n");
			}

			transition++;
		}

		return w.toString();
	}
>>>>>>> 5359fd65f07a439ba05800bf133fef17b39dfbd4

}