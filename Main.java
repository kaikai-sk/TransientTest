package com.sk.TrainsientTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

public class Main implements Serializable
{
	private transient int classValue=10;
	private transient Date date=new Date();
	private static int staticValue=10;
	
	public static void main(String[] args)
	{
		Main main=new Main();
		main.classValue=11;
		main.staticValue=11;
		
		ObjectOutputStream out;
		try
		{
			out = new ObjectOutputStream(new FileOutputStream(
					new File("0xjh000")));
			out.writeObject(main);
			out.close();
			ObjectInputStream in=new ObjectInputStream(new FileInputStream(new 
					File("0xjh000")));
			Main main1=(Main) in.readObject();
			System.out.println(main1.classValue);
			System.out.println(main1.date==null?"date is null":"date is not null");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
}
