package com.multi.mongo;

import java.util.Scanner;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Mongo3 {

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
			// {"id" : "apple", "pw" : "1234", "name" : "apple", "tel" : "011"}
			// json --> document(BSON)
			Scanner kb = new Scanner(System.in);
			System.out.print("id >> ");
			String id = kb.next();
			System.out.print("pw >> ");
			String pw = kb.next();
			System.out.print("name >> ");
			String name = kb.next();
			System.out.print("tel >> ");
			String tel = kb.next();
			kb.close();
			
			Document doc = new Document();
			doc.append("id", id);
			doc.append("pw", pw);
			doc.append("name", name);
			doc.append("tel", tel);
			
			collection.insertOne(doc);
			client.close();
			System.out.println("insertOne 성공");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
