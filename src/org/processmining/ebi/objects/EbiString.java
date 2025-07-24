package org.processmining.ebi.objects;

import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.processmining.ebi.plugins.EbiDialog.EbiDialogPanel;
import org.processmining.framework.plugin.PluginContext;

import com.fluxicon.slickerbox.components.NiceIntegerSlider;
import com.fluxicon.slickerbox.components.NiceSlider.Orientation;
import com.fluxicon.slickerbox.factory.SlickerFactory;

public class EbiString {

	public static String toEbiString(PluginContext context, String value) {
		return value;
	}

	public static String fromEbiString(PluginContext context, String value) {
		return value;
	}

	public static EbiDialogPanel create_input_panel(String explanation) {
		SlickerFactory factory = SlickerFactory.instance();
		return new EbiDialogPanel() {
			
			private String value = "";

			@Override
			public JComponent create_left() {
				return factory.createLabel(explanation);
			}

			@Override
			public JComponent create_right() {
				JTextField right = new JTextField();
				right.getDocument().addDocumentListener(new DocumentListener() {
					
					@Override
					public void removeUpdate(DocumentEvent e) {
						value = right.getText();
					}
					
					@Override
					public void insertUpdate(DocumentEvent e) {
						value = right.getText();	
					}
					
					@Override
					public void changedUpdate(DocumentEvent e) {
						value = right.getText();
					}
				});
				return right;
			}

			@Override
			public Object getValue() {
				return value;
			}
			
		};
	}
	
}
