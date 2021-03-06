import org.gjt.sp.jedit.AbstractOptionPane;
import org.gjt.sp.jedit.jEdit;

import javax.swing.ButtonGroup;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagConstraints;

public class LispIndentOptionPane extends AbstractOptionPane {
	int p_inset = 10;
	int c_inset = 20;
	
	// file ending settings
	JCheckBox check_ending;
	JTextField file_endings;
	
	// vertical indent settings
	JRadioButton use_defun_indent_by_default;
	JRadioButton use_align_indent_by_default;
	JCheckBox check_pattern_for_defun_indent;
	JCheckBox check_pattern_for_align_indent; // sexy, same line length
	JTextArea defun_indent_pattern;
	JTextArea align_indent_pattern;
	
	public LispIndentOptionPane() { super("lispindent"); }
	
	String getProperty(String name) {
		return jEdit.getProperty(LispIndentPlugin.OPTIONS_PREFIX + name);
	}
	void setProperty(String name, String value) {
		jEdit.setProperty(LispIndentPlugin.OPTIONS_PREFIX + name, value);
	}
	boolean getBooleanProperty(String name) {
		return jEdit.getBooleanProperty(LispIndentPlugin.OPTIONS_PREFIX + name);
	}
	void setBooleanProperty(String name, boolean value) {
		jEdit.setBooleanProperty(LispIndentPlugin.OPTIONS_PREFIX + name, value);
	}
	
	JPanel inset_panel(JComponent component, int inset) {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		panel.add(Box.createRigidArea(new Dimension(inset, 0)));
		panel.add(component);
		panel.add(Box.createRigidArea(new Dimension(inset, 0)));
		return panel;
	}
	
	void add_component(JPanel panel, JComponent component) {
		component.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel.add(component);
	}
	
	void set_preset(String preset_name) {
		LispIndentPreset preset = LispIndentPresets.get_preset(preset_name);
		check_ending.setSelected(preset.check_ending);
		file_endings.setText(preset.file_endings);
		file_endings.setEnabled(preset.check_ending);
		
		if(preset.use_defun_indent_by_default) {
			use_defun_indent_by_default.setSelected(true);
		}
		else { use_align_indent_by_default.setSelected(true); }
		check_pattern_for_defun_indent.setSelected(preset.check_pattern_for_defun_indent);
		check_pattern_for_align_indent.setSelected(preset.check_pattern_for_align_indent);
		defun_indent_pattern.setText(preset.defun_indent_pattern);
		align_indent_pattern.setText(preset.align_indent_pattern);
		update_indent_pattern_enable();
	}
	
	JButton get_preset_button() {
		JButton button = new JButton("Use preset");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object selection = JOptionPane.showInputDialog(getComponent(), 
					"Select your language.\n\nWARNING: This will erase all your current settings.", "",
					JOptionPane.PLAIN_MESSAGE, null, LispIndentPresets.get_available(), "none");
				set_preset((String)selection);
			}
		});
		return button;
	}
	
	void show_webpage_dialog() {
		JTextArea ta = new JTextArea(1, 40);
		ta.setText("https://github.com/odyssomay/LispIndent#readme");
		ta.setEditable(false);
		JOptionPane.showMessageDialog(getComponent(), ta);
	}
	
	JButton get_visit_webpage_button() {
		JButton button = new JButton("Visit LispIndent webpage");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
				if(desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
					try {
						java.net.URI uri = new java.net.URI("https://github.com/odyssomay/LispIndent#readme");
						desktop.browse(uri);
					}
					catch(Exception e) { show_webpage_dialog(); }
				}
				else { show_webpage_dialog(); }
			}
		});
		return button;
	}
	
	void init_file_ending_settings() {
		check_ending = new JCheckBox("Only use lisp indenting if the file name matches regex:",
			getBooleanProperty("check_ending"));
		file_endings = new JTextField(getProperty("file_endings_regex"));
		
		file_endings.setEnabled(check_ending.isSelected());
		check_ending.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				file_endings.setEnabled(check_ending.isSelected());
			}
		});
		
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		add_component(panel, check_ending);
		add_component(panel, inset_panel(file_endings, c_inset));
		addComponent(inset_panel(panel, p_inset));
	}
	
	void update_indent_pattern_enable() {
		boolean defun_indent = use_defun_indent_by_default.isSelected();
		check_pattern_for_defun_indent.setEnabled(!defun_indent);
		defun_indent_pattern.setEnabled(!defun_indent && check_pattern_for_defun_indent.isSelected());
		check_pattern_for_align_indent.setEnabled(defun_indent);
		align_indent_pattern.setEnabled(defun_indent && check_pattern_for_align_indent.isSelected());
	}
	
	void addPatternEnableListener(javax.swing.AbstractButton component) {
		component.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update_indent_pattern_enable();
			}
		});
	}
	
	void init_vertical_indent_settings() {
		use_defun_indent_by_default = new JRadioButton("two spaces");
		use_align_indent_by_default = new JRadioButton("to function arguments");
		ButtonGroup bg = new ButtonGroup();
		bg.add(use_defun_indent_by_default);
		bg.add(use_align_indent_by_default);
		
		if(getBooleanProperty("use_defun_indent_by_default")) {
			use_defun_indent_by_default.setSelected(true);
		}
		else { use_align_indent_by_default.setSelected(true); }
		
		check_pattern_for_defun_indent = new JCheckBox("Indent two spaces if operator matches regex:");
		check_pattern_for_align_indent = new JCheckBox("Indent to function arguments if operator matches regex:");
		check_pattern_for_defun_indent.setSelected(getBooleanProperty("check_pattern_for_defun_indent"));
		check_pattern_for_align_indent.setSelected(getBooleanProperty("check_pattern_for_align_indent"));
		
		defun_indent_pattern = new JTextArea(2, 2);
		align_indent_pattern = new JTextArea(2, 2);
		defun_indent_pattern.setText(getProperty("defun_indent_pattern"));
		align_indent_pattern.setText(getProperty("align_indent_pattern"));
		
		addPatternEnableListener(use_defun_indent_by_default);
		addPatternEnableListener(use_align_indent_by_default);
		addPatternEnableListener(check_pattern_for_defun_indent);
		addPatternEnableListener(check_pattern_for_align_indent);
		update_indent_pattern_enable();
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		add_component(panel, new JLabel("By default, indent:"));
		add_component(panel, inset_panel(use_defun_indent_by_default, c_inset));
		add_component(panel, inset_panel(use_align_indent_by_default, c_inset));
		add_component(panel, check_pattern_for_defun_indent);
		add_component(panel, inset_panel(new JScrollPane(defun_indent_pattern), c_inset));
		add_component(panel, check_pattern_for_align_indent);
		add_component(panel, inset_panel(new JScrollPane(align_indent_pattern), c_inset));
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		add(inset_panel(panel, p_inset), c);
	}
	
	public void _init() {
		addComponent(get_help_panel());
		addSeparator("options.lispindent.file_ending_options.label");
		init_file_ending_settings();
		addSeparator("options.lispindent.indent_options.label");
		init_vertical_indent_settings();
	}
	
	void save_file_ending_settings() {
		setBooleanProperty("check_ending", check_ending.isSelected());
		setProperty("file_endings_regex", file_endings.getText());
	}
	
	void save_vertical_indent_settings() {
		setBooleanProperty("use_defun_indent_by_default", use_defun_indent_by_default.isSelected());
		setBooleanProperty("check_pattern_for_defun_indent", check_pattern_for_defun_indent.isSelected());
		setBooleanProperty("check_pattern_for_align_indent", check_pattern_for_align_indent.isSelected());
		setProperty("defun_indent_pattern", defun_indent_pattern.getText());
		setProperty("align_indent_pattern", align_indent_pattern.getText());
	}
	
	public void _save() {
		save_file_ending_settings();
		save_vertical_indent_settings();
	}
	
	JPanel get_help_panel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		panel.add(new JLabel("To get help and info about LispIndent, click below."));
		panel.add(get_visit_webpage_button());
		
		panel.add(new JLabel("To get started, select a preset for your language by clicking below."));
		panel.add(get_preset_button());
		
		JPanel outer_panel = new JPanel();
		outer_panel.setLayout(new BoxLayout(outer_panel, BoxLayout.Y_AXIS));
		outer_panel.add(inset_panel(panel, p_inset));
		return outer_panel;
	}
}
