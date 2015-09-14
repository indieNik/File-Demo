package com.psl.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamDemo {
	public static void main(String[] args) {
		
		File f = new File("abc.txt");
		
		if(f.exists()){
			System.out.println("File Exists!");
		}
		else{
			System.out.println("File Not Found!");
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(f);
			String str = "Writing to My File";
			fos.write(str.getBytes());
			
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally{
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(f);
			
			int i = 0;
			while((i = fis.read()) != -1){
				System.out.print((char)i);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
