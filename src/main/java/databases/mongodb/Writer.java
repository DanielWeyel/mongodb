package databases.mongodb;

import java.util.HashSet;
import java.util.Set;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

public class Writer {
			
	public static void writeRandomObjects(long number, MongoCollection<Document> collection){
		
		Set<String> props = new HashSet<String>();
		props.add("Augenfarbe grün");
		props.add("Größe 170 cm");
		props.add("stark");		
		
		for (int i = 0; i<number; i++){			
			MyObject object = new MyObject(i, "Objekt:"+i, props);
			
			Document doc = new Document().append(Constants.ID, i).append("JSON", object.toJSON());
			collection.insertOne(doc);
			
		}		
	}

}
