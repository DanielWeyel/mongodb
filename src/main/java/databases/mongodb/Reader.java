package databases.mongodb;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.bson.Document;
import org.json.JSONArray;
import org.json.JSONObject;

import com.mongodb.client.MongoCollection;

public class Reader {
	
	public static List<MyObject> readRandomObjects(long number, MongoCollection<Document> collection){
		
		List<MyObject> resultList = new ArrayList<MyObject>();
		
		for (Document doc : collection.find()) {
			
			//Eigenschaften
			Set<String> props = new HashSet<String>();
			
			String json = doc.getString("JSON");
			
			//JSONObjekte
			JSONObject jsonObject = new JSONObject(json);
			
			JSONArray jsonArray = jsonObject.getJSONArray(Constants.PROPERTIES);
			
			for (Object prop : jsonArray){
				props.add((String) prop);
			}
			
			resultList.add(new MyObject(jsonObject.getInt(Constants.ID), jsonObject.getString(Constants.NAME), props));
			
		}
				
		return resultList;
		
	}
	
}
