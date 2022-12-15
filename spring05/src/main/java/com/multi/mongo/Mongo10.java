package com.multi.mongo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Mongo10 {

	public static void main(String[] args) {
		try {
			// 1. 몽고DB에 연결
			MongoClient client = new MongoClient("localhost", 27017);
			
			// 2. shop2 db에 연결
			MongoDatabase database = client.getDatabase("shop2");
			
			// 3. member collection에 연결
			MongoCollection<Document> collection = database.getCollection("member");
			// document는 org.bson
			
			// 4. crud
			// 정렬 조건
//			Document filter = new Document("name", 1);
			Document filter = new Document("name", -1);
			
			// 검색
			FindIterable<Document> result = collection.find().sort(filter);
			// iterate : 반복하다
			//[doc, doc, doc, ...]
			System.out.println(result.first().get("id"));
			System.out.println(result.first().get("name"));
			System.out.println(result.first().get("pw"));
			System.out.println(result.first().get("tel"));
			
			System.out.println("-----------------");
			
//			for (Document doc : result) {
//				System.out.print(doc.get("id") + "\t");
//				System.out.print(doc.get("name") + "\t");
//				System.out.print(doc.get("pw") + "\t");
//				System.out.print(doc.get("tel") + "\n");
//			}
			
			System.out.println("find 검색 성공");
			
			System.out.println("-----------------");
			
			//document와 제일 유사한 자바의 자료구조(map)
			//doc --> map
//			Map<String, Object> map = new HashMap<String, Object>();
//			map.put("id", result.first().get("id"));
//			map.put("name", result.first().get("name"));
//			map.put("pw", result.first().get("pw"));
//			map.put("tel", result.first().get("tel"));
//			System.out.println(map);
			
			ArrayList<Map> list = new ArrayList<Map>();
			for (Document doc : result) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("id", doc.get("id"));
				map.put("name", doc.get("name"));
				map.put("pw", doc.get("pw"));
				map.put("tel", doc.get("tel"));
				list.add(map);
			}
			System.out.println(list);
			
			client.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
