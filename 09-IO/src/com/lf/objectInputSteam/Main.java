package com.lf.objectInputSteam;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
//		Person person = new Person(20, 99, 70);
//		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("/Users/fengluo/Desktop/123/5/ObjectOutputStream_Person.txt"));
//		oos.writeObject(person);
//		oos.close();
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/Users/fengluo/Desktop/123/5/ObjectOutputStream_Person.txt"));
		Person p = (Person)ois.readObject();
		System.out.println(p);
		ois.close();
		
		
	}

}
