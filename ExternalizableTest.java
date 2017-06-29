package com.sk.TrainsientTest;

import java.io.Externalizable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class ExternalizableTest implements Externalizable
{
	private transient String content="哈哈~我将会被序列化，不管我是否是被transient关键字修饰";
	
	@Override
	public void writeExternal(ObjectOutput out) throws IOException
	{
		out.writeObject(content);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException
	{
		content=(String) in.readObject();
	}

	public static void main(String[] args)
	{
		ExternalizableTest externalizableTest=new ExternalizableTest();
		ObjectOutput out;
		try
		{
			out = new ObjectOutputStream(new FileOutputStream(
					new File("ext0000")));
			out.writeObject(externalizableTest);
			ObjectInput in=new ObjectInputStream(new FileInputStream(
					new File("ext0000")));
			ExternalizableTest externalizableTest2=(ExternalizableTest) in.readObject();
			System.out.println(externalizableTest2.content);
			out.close();
			in.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	
		
	}
}
