javac -cp /usr/share/jedit/jedit.jar LispIndentPlugin.java
jar cf LispIndent.jar LispIndentPlugin.class LispIndentPlugin\$Indenter.class LispIndent.props actions.xml
cp LispIndent.jar ~/.jedit/jars/
