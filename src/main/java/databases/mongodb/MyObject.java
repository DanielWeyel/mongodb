package databases.mongodb;

import java.util.HashSet;
import java.util.Set;

import org.json.JSONObject;

public final class MyObject {

	@Override
	public String toString() {
		return "MyObject [id=" + id + ", name=" + name + ", eigenschaften=" + eigenschaften + "]";
	}

	private final int id;
	private final String name;
	private final Set<String> eigenschaften = new HashSet<String>();
	
	public MyObject(int id, String name, Set<String> eigenschaften) {
		super();
		this.id = id;
		this.name = name;
		this.eigenschaften.addAll(eigenschaften);
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Set<String> getEigenschaften() {
		return eigenschaften;
	}
	
	public void addProperty(String property){
		eigenschaften.add(property);
	}
	
	public String toJSON(){
		JSONObject jsonObject = new JSONObject();
		jsonObject.put(Constants.NAME, this.getName());
		jsonObject.put(Constants.ID, this.getId());
		jsonObject.put(Constants.PROPERTIES, this.getEigenschaften());
		
		return jsonObject.toString();
	}
	
}
