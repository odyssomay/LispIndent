
import org.gjt.sp.jedit.AbstractOptionPane;
import org.gjt.sp.jedit.jEdit;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JCheckBox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LispIndentOptionPane extends AbstractOptionPane {
	JCheckBox check_ending;
	JTextField file_endings;
	
	public LispIndentOptionPane() { super("lispindent"); }
	
	public void _init() {
		check_ending = new JCheckBox("Only use lisp indenting if the file name matches:",
			jEdit.getBooleanProperty(LispIndentPlugin.OPTIONS_PREFIX + "check_ending"));
		file_endings = new JTextField(jEdit.getProperty(
			LispIndentPlugin.OPTIONS_PREFIX + "file_endings_regex"), 25);
		
		file_endings.setEnabled(check_ending.isSelected());
		check_ending.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				file_endings.setEnabled(check_ending.isSelected());
			}
		});
		
		addComponent(check_ending);
		addComponent(file_endings);
	}
	
	public void _save() {
		jEdit.setBooleanProperty(LispIndentPlugin.OPTIONS_PREFIX + "check_ending",
			check_ending.isSelected());
		jEdit.setProperty(LispIndentPlugin.OPTIONS_PREFIX + "file_endings_regex",
			file_endings.getText());
	}
}
