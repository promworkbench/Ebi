package org.processmining.ebi;

import org.processmining.framework.plugin.annotations.Plugin;

@Plugin(name = "Your plug-in name", parameterLabels = { "Name of your first input", "Name of your second input", "Name of your parameters" }, 
	    returnLabels = { "Name of your output" }, returnTypes = { Object.class }, help = "Call Ebi from ProM")
public class CallEbi {
	
	// This declares that the static `hello` method will be provided
    // a native library.
	/*
	 * How to get the header file:
	 * copy all .jar files from the Ivy cache to the lib folder of the ProM package
	 * javac -h . -cp .ebi.jar:lib/* src/org/processmining/ebi/plugins/EbiPlugin.java
	 */
    public static native String call_ebi(String command_name, String output_format, String[] inputs);
    
    private static String lpn = "labelled Petri net\n"
    		+ "# number of places\n"
    		+ "3\n"
    		+ "# initial marking\n"
    		+ "1\n"
    		+ "0\n"
    		+ "0\n"
    		+ "# number of transitions\n"
    		+ "5\n"
    		+ "# transition 0\n"
    		+ "label a\n"
    		+ "# number of input places\n"
    		+ "1\n"
    		+ "0\n"
    		+ "# number of output places\n"
    		+ "1\n"
    		+ "1\n"
    		+ "# transition 1\n"
    		+ "label b\n"
    		+ "# number of input places\n"
    		+ "1\n"
    		+ "0\n"
    		+ "# number of output places\n"
    		+ "1\n"
    		+ "2\n"
    		+ "# transition 2\n"
    		+ "label a\n"
    		+ "# number of input places\n"
    		+ "1\n"
    		+ "1\n"
    		+ "# number of output places\n"
    		+ "0\n"
    		+ "# transition 3\n"
    		+ "label b\n"
    		+ "# number of input places\n"
    		+ "1\n"
    		+ "1\n"
    		+ "# number of output places\n"
    		+ "0\n"
    		+ "# transition 4\n"
    		+ "label a\n"
    		+ "# number of input places\n"
    		+ "1\n"
    		+ "2\n"
    		+ "# number of output places\n"
    		+ "0";

    static {
        // This actually loads the shared object that we'll be creating.
        // The actual location of the .so or .dll may differ based on your
        // platform.
        System.loadLibrary("ebi");
    }
    
    // The rest is just regular ol' Java!
    public static void main(String[] args) {
        String output = call_ebi("Ebi discover uniform", ".slpn", new String[] { lpn } );
        System.out.println(output);
    }

//	/**
//	 * The plug-in variant that runs in any context and requires a parameters.
//	 * 
//	 * @param context The context to run in.
//	 * @param input1 The first input.
//	 * @param input2 The second input.
//	 * @param parameters The parameters to use.
//	 * @return The output.
//	 */
//	@UITopiaVariant(affiliation = IMMiningDialog.affiliation, author = IMMiningDialog.author, email = IMMiningDialog.email)
//	@PluginVariant(variantLabel = "Your plug-in name, parameters", requiredParameterLabels = { 0, 1, 2 })
//	public YourOutput run(PluginContext context, YourFirstInput input1, YourSecondInput input2, YourParameters parameters) {
//		// Apply the algorithm depending on whether a connection already exists.
//	    return runConnections(context, input1, input2, parameters);
//	}
//	
//	/**
//	 * The plug-in variant that runs in any context and uses the default parameters.
//	 * 
//	 * @param context The context to run in.
//	 * @param input1 The first input.
//	 * @param input2 The second input.
//	 * @return The output.
//	 */
//	@UITopiaVariant(affiliation = "Your affiliation", author = "Your name", email = "Your e-mail address")
//	@PluginVariant(variantLabel = "Your plug-in name, parameters", requiredParameterLabels = { 0, 1 })
//	public YourOutput runDefault(PluginContext context, YourFirstInput input1, YourSecondInput input2) {
//		// Get the default parameters.
//	    YourParameters parameters = new YourParameters(input1, input2);
//		// Apply the algorithm depending on whether a connection already exists.
//	    return runConnections(context, input1, input2, parameters);
//	}
//	
//	/**
//	 * The plug-in variant that runs in a UI context and uses a dialog to get the parameters.
//	 * 
//	 * @param context The context to run in.
//	 * @param input1 The first input.
//	 * @param input2 The second input.
//	 * @return The output.
//	 */
//	@UITopiaVariant(affiliation = "Your affiliation", author = "Your name", email = "Your e-mail address")
//	@PluginVariant(variantLabel = "Your plug-in name, dialog", requiredParameterLabels = { 0, 1 })
//	public YourOutput runUI(UIPluginContext context, YourFirstInput input1, YourSecondInput input2) {
//		// Get the default parameters.
//	    YourParameters parameters = new YourParameters(input1, input2);
//	    // Get a dialog for this parameters.
//	    YourDialog dialog = new YourDialog(context, input1, input2, parameters);
//	    // Show the dialog. User can now change the parameters.
//	    InteractionResult result = context.showWizard("Your dialog title", true, true, dialog);
//	    // User has close the dialog.
//	    if (result == InteractionResult.FINISHED) {
//			// Apply the algorithm depending on whether a connection already exists.
//	    	return runConnections(context, input1, input2, parameters);
//	    }
//	    // Dialog got canceled.
//	    return null;
//	}	
//	
//	/**
//	 * The plug-in variant that allows one to test the dialog to get the parameters.
//	 * 
//	 * @param context The context to run in.
//	 * @return The output.
//	 */
//	@UITopiaVariant(affiliation = "Your affiliation", author = "Your name", email = "Your e-mail address")
//	@PluginVariant(variantLabel = "Your plug-in name, dialog", requiredParameterLabels = { })
//	public YourOutput testUI(UIPluginContext context) {
//		// Create default inputs.
//		YourFirstInput input1 = new YourFirstInput();
//		YourSecondInput input2 = new YourSecondInput();
//		// Get the default parameters.
//	    YourParameters parameters = new YourParameters(input1, input2);
//	    // Get a dialog for this parameters.
//	    YourDialog dialog = new YourDialog(context, input1, input2, parameters);
//	    // Show the dialog. User can now change the parameters.
//	    InteractionResult result = context.showWizard("Your dialog title", true, true, dialog);
//	    // User has close the dialog.
//	    if (result == InteractionResult.FINISHED) {
//			// Apply the algorithm depending on whether a connection already exists.
//	    	return runConnections(context, input1, input2, parameters);
//	    }
//	    // Dialog got canceled.
//	    return null;
//	}	
//	
//	/**
//	 * Apply the algorithm depending on whether a connection already exists.
//	 * 
//	 * @param context The context to run in.
//	 * @param input1 The first input.
//	 * @param input2 The second input.
//	 * @return The output.
//	 */
//	private YourOutput runConnections(PluginContext context, YourFirstInput input1, YourSecondInput input2, YourParameters parameters) {
//		if (parameters.isTryConnections()) {
//			// Try to found a connection that matches the inputs and the parameters.
//			Collection<YourConnection> connections;
//			try {
//				connections = context.getConnectionManager().getConnections(
//						YourConnection.class, context, input1, input2);
//				for (YourConnection connection : connections) {
//					if (connection.getObjectWithRole(YourConnection.FIRSTINPUT)
//							.equals(input1) && connection.getObjectWithRole(YourConnection.SECONDINPUT)
//							.equals(input2) && connection.getParameters().equals(parameters)) {
//						// Found a match. Return the associated output as result of the algorithm.
//						return connection
//								.getObjectWithRole(YourConnection.OUTPUT);
//					}
//				}
//			} catch (ConnectionCannotBeObtained e) {
//			}
//		}
//		// No connection found. Apply the algorithm to compute a fresh output result.
//		YourOutput output = apply(context, input1, input2, parameters);
//		if (parameters.isTryConnections()) {
//			// Store a connection containing the inputs, output, and parameters.
//			context.getConnectionManager().addConnection(
//					new YourConnection(input1, input2, output, parameters));
//		}
//		// Return the output.
//		return output;
//	}

}
