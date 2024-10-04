package org.processmining.ebi.objects;

import javax.swing.JComponent;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.processmining.ebi.plugins.EbiDialog.EbiDialogPanel;
import org.processmining.framework.plugin.PluginContext;

import com.fluxicon.slickerbox.components.NiceIntegerSlider;
import com.fluxicon.slickerbox.components.NiceSlider.Orientation;
import com.fluxicon.slickerbox.factory.SlickerFactory;

public class EbiInteger {

	public static String toEbiString(PluginContext context, Integer value) {
		return value.toString();
	}

	public static Integer fromEbiString(PluginContext context, String value) {
		return Integer.parseInt(value);
	}

	public static EbiDialogPanel create_input_panel(String explanation) {
		SlickerFactory factory = SlickerFactory.instance();
		return new EbiDialogPanel() {
			
			private int value = 500;

			@Override
			public JComponent create_left() {
				return factory.createLabel(explanation);
			}

			@Override
			public JComponent create_right() {
				NiceIntegerSlider right = factory.createNiceIntegerSlider("", 0, Integer.MAX_VALUE, value, Orientation.HORIZONTAL);
				right.addChangeListener(new ChangeListener() {
					@Override
					public void stateChanged(ChangeEvent e) {
						value = right.getValue();
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
