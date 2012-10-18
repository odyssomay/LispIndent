
public class LispIndentPresets {
	
	public static Object[] get_available() {
		String[] available = {"none", "clojure"};
		return available;
	}
	
	static LispIndentPreset get_clojure_preset() {
		LispIndentPreset preset = new LispIndentPreset() {
			public void init() {
				check_ending = true;
				file_endings = ".*\\.(clj|cljs)";
				use_defun_indent_by_default = false;
				check_pattern_for_defun_indent = true;
				check_pattern_for_align_indent = false;
				defun_indent_pattern = 
					"ns|fn|def|defn|bound-fn|if|if-not|case|condp|when|while|when-not|when-first|do|future|comment|doto|" +
					"locking|proxy|with-open|with-precision|with-local-vars|reify|deftype|defrecord|defprotocol|" +
					"extend|extend-protocol|extend-type|try|catch|finally|let|letfn|binding|loop|for|doseq|" +
					"dotimes|when-let|if-let|defstruct|struct-map|assoc|defmethod|" +
					"testing|deftest|use-fixtures|handler-case|handle|dotrace|deftrace";
				align_indent_pattern = "";
			}
		};
		preset.init();
		return preset;
	}
	
	static LispIndentPreset get_none_preset() {
		LispIndentPreset preset = new LispIndentPreset() {
			public void init() {
				check_ending = false;
				file_endings = "";
				use_defun_indent_by_default = true;
				check_pattern_for_defun_indent = false;
				check_pattern_for_align_indent = false;
				defun_indent_pattern = "";
				align_indent_pattern = "";
			}
		};
		preset.init();
		return preset;
	}
	
	public static LispIndentPreset get_preset(String preset_name) {
		switch(preset_name) {
			case "clojure": return get_clojure_preset();
			case "none": return get_none_preset();
			default: return get_none_preset();
		}
	}
}

