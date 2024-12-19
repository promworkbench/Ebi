package org.processmining.ebi.objects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.math3.fraction.BigFraction;
import org.processmining.framework.plugin.PluginContext;
import org.processmining.models.connections.petrinets.behavioral.InitialMarkingConnection;
import org.processmining.models.graphbased.directed.petrinet.Petrinet;
import org.processmining.models.graphbased.directed.petrinet.PetrinetEdge;
import org.processmining.models.graphbased.directed.petrinet.PetrinetNode;
import org.processmining.models.graphbased.directed.petrinet.elements.Place;
import org.processmining.models.graphbased.directed.petrinet.elements.Transition;
import org.processmining.models.graphbased.directed.petrinet.impl.PetrinetImpl;
import org.processmining.models.semantics.petrinet.Marking;
import org.processmining.plugins.InductiveMiner.efficienttree.EfficientTree;
import org.processmining.plugins.InductiveMiner.efficienttree.EfficientTreeImpl;
import org.processmining.plugins.InductiveMiner.efficienttree.EfficientTree.NodeType;
import org.processmining.stochasticlabelledpetrinets.plugins.StochasticLabelledPetriNetImportPlugin;
import org.python.google.common.primitives.Ints;

import com.google.common.primitives.Doubles;

import gnu.trove.iterator.TObjectIntIterator;
import gnu.trove.map.TIntObjectMap;
import gnu.trove.map.TObjectIntMap;
import gnu.trove.map.hash.TIntObjectHashMap;
import gnu.trove.map.hash.TObjectIntHashMap;

public class EbiProcessTree {

	private static int node_to_string(EfficientTree tree, int indent, int node, StringBuilder w) {
		String id = "\t".repeat(indent);
		if (tree.isActivity(node)) {
			w.append(id + "activity " + tree.getActivityName(node));
            return node + 1;
		} else if (tree.isTau(node)) {
			w.append(id + "tau"); 
            return node + 1;
		} else {
			w.append(id + tree.getNodeType(node));
			w.append(id + "# number of children\n" + id + tree.getNumberOfChildren(node));
			int child = node + 1;
            for (int x = 0; x < tree.getNumberOfChildren(node); x++) {
                child = node_to_string(tree, indent + 1, child, w);
            }
            return child;
		}
	}
	
	///read one node, recursively
    public static void string_to_tree(BufferedReader r, List<Integer> nodes, TObjectIntMap<String> activity2int) throws IOException {
        String node_type_line = StochasticLabelledPetriNetImportPlugin.getNextLine(r);

        if (node_type_line.trim().startsWith("tau")) {        
            nodes.add(NodeType.tau.code);
        } else if (node_type_line.trim().startsWith("activity ")) {
            String label = node_type_line.trim().substring(9);
            int activity = activity2int.adjustOrPutValue(label, 0, activity2int.size());
            nodes.add(activity);
        } else { 
        	NodeType operator;
        	switch (node_type_line) {
				case "xor":
					operator = NodeType.xor;
					break;
				case "sequence":
					operator = NodeType.sequence;
					break;
				case "parallel":
				case "concurrent":
					operator = NodeType.concurrent;
					break;
				case "interleaved":
					operator = NodeType.interleaved;
					break;
				case "loop":
					operator = NodeType.loop;
					break;
				case "or":
					operator = NodeType.or;
					break;
				default:
					throw new RuntimeException("unknown operator");
			} 
        	
        
        	int number_of_children = parseInteger(StochasticLabelledPetriNetImportPlugin.getNextLine(r).trim());
            if (number_of_children < 1) {
                throw new RuntimeException("node has no children");
            }
            nodes.add(operator.code - EfficientTreeImpl.childrenFactor * (number_of_children + 1));
            for (int i = 0; i < number_of_children; i++) {
                string_to_tree(r, nodes, activity2int);
            }
        }
    }
    
    public static Integer parseInteger(String string) {
		return Integer.valueOf(string);
	}

	public static String EfficientTree2EbiString(PluginContext context, EfficientTree tree) throws Exception {
		StringBuilder w = new StringBuilder();

		w.append("process tree\n");
		node_to_string(tree, 0, 0, w);

		return w.toString();
	}

	public static EfficientTree EbiString2EfficientTree(PluginContext context, String input) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(IOUtils.toInputStream(input, "UTF-8")));
		StochasticLabelledPetriNetImportPlugin.getNextLine(r); // read the header
		List<Integer> nodeList = new ArrayList<>();
		TObjectIntMap<String> activity2int = EfficientTreeImpl.getEmptyActivity2int();
		
		string_to_tree(r, nodeList, activity2int);
		
		r.close();
		
		String[] int2activity = new String[activity2int.size()];
		for (TObjectIntIterator<String> it = activity2int.iterator();it.hasNext();) {
			it.advance();
			
			int2activity[it.value()] = it.key();
		}
		
		return new EfficientTreeImpl(Ints.toArray(nodeList), activity2int, int2activity);
	}
}