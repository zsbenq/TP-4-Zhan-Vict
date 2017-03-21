package logic_layer;

import java.util.HashMap;
import java.util.Map;

public class ParameterBox {
	private Map<String, String> map = new HashMap<String, String>();

	public void add(String key, String value) {
		map.put(key, value);
	}

	public boolean isEmpty() {
		return map.isEmpty();
	}

	public String get(String key) {
		return map.get(key);
	}

	
}
