javac -cp /usr/share/jedit/jedit.jar LispIndentPlugin.java LispIndentOptionPane.java LispIndentPreset.java LispIndentPresets.java
jar cf LispIndent.jar *.class LispIndent.props actions.xml
cp LispIndent.jar ~/.jedit/jars/
