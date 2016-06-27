package databases.mongodb;

import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import databases.redis.MyObject;

public class MongoDBConnect {
	public static void main(String[] args) {
		
		MongoClient client = new MongoClient("build", 27017);	
		MongoDatabase db = client.getDatabase("test");
		
		//Test Range
		int range = 50000;
	
		//Collection holen und zurücksetzen
		MongoCollection<Document> myCollection = db.getCollection("objekte");
		myCollection.drop();
		
		//Schreiben
		long beginnWrite = System.currentTimeMillis();
		Writer.writeRandomObjects(range, myCollection);
		long dauerWrite = Math.round((System.currentTimeMillis()-beginnWrite)/1000);
		System.out.println("Schreiben dauerte: " + dauerWrite + " Sekunden.");
		
		//Lesen
		long beginnRead = System.currentTimeMillis();		
		List<MyObject> result = Reader.readRandomObjects(range, myCollection);
		long dauerRead = Math.round((System.currentTimeMillis()-beginnRead)/1000);
		System.out.println("Lesen dauerte: " + dauerRead + " Sekunden. Es sind " + result.size() + " Objekte in der Liste.");
		
		client.close();
	}
}
