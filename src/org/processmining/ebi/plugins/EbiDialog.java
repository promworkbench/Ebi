package org.processmining.ebi.plugins;

import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import org.apache.commons.math3.fraction.BigFraction;

public class EbiDialog extends JPanel {

	private static final long serialVersionUID = -6166488057077674334L;

	public interface EbiDialogPanel {
		public JComponent create_left();

		public JComponent create_right();

		public Object getValue();
	}

	private ArrayList<EbiDialogPanel> panels = new ArrayList<>();
	private SpringLayout layout;
	private JComponent last_left;

	private int leftColumnWidth = 200;
	private int columnMargin = 20;
	private int rowHeight = 40;

	public EbiDialog() {

		layout = new SpringLayout();
		setLayout(layout);
	}

	public void add_input(EbiDialogPanel panel) {

		JComponent left = panel.create_left();
		add(left);
		left.setPreferredSize(left.getMaximumSize());
		if (panels.isEmpty()) {
			layout.putConstraint(SpringLayout.NORTH, left, 5, SpringLayout.NORTH, this);
			layout.putConstraint(SpringLayout.EAST, left, leftColumnWidth, SpringLayout.WEST, this);
		} else {
			layout.putConstraint(SpringLayout.VERTICAL_CENTER, left, rowHeight, SpringLayout.VERTICAL_CENTER,
					last_left);
			layout.putConstraint(SpringLayout.EAST, left, leftColumnWidth, SpringLayout.WEST, this);
		}
		last_left = left;

		JComponent right = panel.create_right();
		right.setPreferredSize(right.getMaximumSize());
		add(right);
		layout.putConstraint(SpringLayout.WEST, right, columnMargin, SpringLayout.EAST, left);
		layout.putConstraint(SpringLayout.VERTICAL_CENTER, right, 0, SpringLayout.VERTICAL_CENTER, left);
		
		panels.add(panel);
	}

	public Integer get_parameter_Integer(int panel_index) {
		return (Integer) panels.get(panel_index).getValue();
	}
	
	public String get_parameter_String(int panel_index) {
		return (String) panels.get(panel_index).getValue();
	}

	public BigFraction get_parameter_org_apache_commons_math3_fraction_BigFraction(int panel_index) {
		return (BigFraction) panels.get(panel_index).getValue();
	}
}