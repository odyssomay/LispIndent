
import org.gjt.sp.jedit.AbstractOptionPane;
import org.gjt.sp.jedit.jEdit;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JCheckBox;

public class LispIndentOptionPane extends AbstractOptionPane {
	JCheckBox check_ending;
	JTextField file_endings;
	
	public LispIndentOptionPane() { super("lispindent"); }
	
	public void _init() {
		//org.gjt.sp.util.Log.log(org.gjt.sp.util.Log.DEBUG, null, "starting option pane");
		check_ending = new JCheckBox("Check file ending before indenting",
			jEdit.getBooleanProperty(LispIndentPlugin.OPTIONS_PREFIX + "check_ending"));
		file_endings = new JTextField(jEdit.getProperty(
			LispIndentPlugin.OPTIONS_PREFIX + "file_endings"), 25);
		addComponent(check_ending);
		addComponent(new JLabel("Lisp file endings (delimited by |)"));
		addComponent(file_endings);
	}
	
	public void _save() {
		jEdit.setBooleanProperty(LispIndentPlugin.OPTIONS_PREFIX + "check_ending",
			check_ending.isSelected());
		jEdit.setProperty(LispIndentPlugin.OPTIONS_PREFIX + "file_endings",
			file_endings.getText());
	}
}
