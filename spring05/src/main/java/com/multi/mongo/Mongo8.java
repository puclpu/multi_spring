package com.multi.mongo;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Updates;

public class Mongo8 {

	public static void main(String[] args) {
		try {
			// 1. 몽고DB에 연결
			MongoClient client = new MongoClient("localhost", 27017);
			
			// 2. shop2 db에 연결
			MongoDatabase database = client.getDatabase("shop2");
			
			// 3. member collection에 연결
			MongoCollection<Document> collection = database.getCollection("member");
			// document는 org.bson
			
			// 4. crud(insertOne(document))
			// 수정할 조건
			Document filter = new Document();
			filter.append("id", "apple4");
			// 업데이트할 내용이 많은 경우
			// 1) bson 객체로 각각을 만든다
			Bson update = Updates.set("name", "happy");
			Bson update2 = Updates.set("tel", "5555");
			// 2) Bson 겍체의 list를 만든다
			List<Bson> list = new ArrayList<Bson>();
			list.add(update);
			list.add(update2);
			// 3) list를 Bson으로 만든다
			Bson all = Updates.combine(list);
			
			collection.updateOne(filter, all);
			client.close();
			System.out.println("updateOne 성공");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
