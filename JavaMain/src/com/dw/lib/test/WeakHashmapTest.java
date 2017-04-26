package com.dw.lib.test;

import java.util.IdentityHashMap;
import java.util.UUID;
import java.util.WeakHashMap;

public class WeakHashmapTest {

	public static void main(String[] args) {
		
		UUID uuid = UUID.randomUUID();
		String accessToken = uuid.toString();
		
		System.out.println(accessToken);
		
		WeakHashMap<Integer, Student> map = new WeakHashMap<>();
		Student s1 = new Student(12345, "John", "Smith");
		Student s2 = new Student(24680, "Jane", "Smith");
		Student s3 = new Student(13579, "Adam", "Smith");
		Student s4 = new Student(67890, "Tom", "Jones");
		map.put(s1.getStudentID(), s1);
		map.put(s2.getStudentID(), s2);
		map.put(s3.getStudentID(), s3);
		map.put(s4.getStudentID(), s4);
		System.out.println("The map initially contained " + map.size() + " entries");
		System.gc();
		System.out.println("The map now contains " + map.size() + " entries");
		
		IdentityHashMap<Integer,Student> map2 = new IdentityHashMap<>();

		map2.put(s1.getStudentID(), s1);
		map2.put(s1.getStudentID(), s1);
		System.out.println(map2.size());
		
		for (Student s : map.values()) {
			System.out.println(s.getStudentID() + " " + s.getFullName());
		}
	}
}
