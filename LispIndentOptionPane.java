
import org.gjt.sp.jedit.AbstractOptionPane;
import org.gjt.sp.jedit.jEdit;


import javax.swing.JCheckBox;

public class LispIndentOptionPane extends AbstractOptionPane {
	JCheckBox check_ending;
	
	public LispIndentOptionPane() { super("lispindent"); }
	
	public void _init() {
		//org.gjt.sp.util.Log.log(org.gjt.sp.util.Log.DEBUG, null, "starting option pane");
		check_ending = new JCheckBox("Check file ending before indenting",
			jEdit.getBooleanProperty(LispIndentPlugin.OPTIONS_PREFIX + "check_ending"));
		addComponent(check_ending);
	}
	
	public void _save() {
		jEdit.setBooleanProperty(LispIndentPlugin.OPTIONS_PREFIX + "check_ending",
			check_ending.isSelected());
	}
}
