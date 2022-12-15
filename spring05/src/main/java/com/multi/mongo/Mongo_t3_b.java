package com.multi.mongo;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Updates;

public class Mongo_t3_b {
	// b
	public static void main(String[] args) {
		try {
			// 1. 몽고DB에 연결
			MongoClient client = new MongoClient("localhost", 27017);
			// 2. shop2 db에 연결
			MongoDatabase database = client.getDatabase("shop2");
			// 3. member collection에 연결
			MongoCollection<Document> collection = database.getCollection("memo");
			// 4. crud(updateOne(document))
			// 수정할 조건
			Document filter = new Document("office","busan");
			// 수정할 내용
			Bson update = Updates.set("phone", "9999");
			Bson update2 = Updates.set("name", "songsong2");
			Bson update3 = Updates.set("age", 555);
			List<Bson> list = new ArrayList<Bson>();
			list.add(update);
			list.add(update2);
			list.add(update3);
			Bson all = Updates.combine(list);

			collection.updateMany(filter, all);
			client.close();
			System.out.println("updateMany 성공");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
