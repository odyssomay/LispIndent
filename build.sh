javac -cp /usr/share/jedit/jedit.jar LispIndentPlugin.java LispIndentOptionPane.java
#jar cf LispIndent.jar LispIndentPlugin.class LispIndentOptionPane.class LispIndentOptionPane\$CheckEndingListener.class LispIndent.props actions.xml
jar cf LispIndent.jar *.class LispIndent.props actions.xml
cp LispIndent.jar ~/.jedit/jars/
