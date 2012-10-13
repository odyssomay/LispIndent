javac -cp /usr/share/jedit/jedit.jar LispIndentPlugin.java LispIndentOptionPane.java
jar cf LispIndent.jar LispIndentPlugin.class LispIndentOptionPane.class LispIndent.props actions.xml
cp LispIndent.jar ~/.jedit/jars/
