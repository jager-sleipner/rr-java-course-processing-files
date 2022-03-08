package com.martin.learningfilereader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//also 
//import java.io.*;

//Old way to handle file reading, messy with a lot of try and catch. Next lesson (34) he will show a modern way to do it.
public class Application {

	public static void main(String[] args) {
		File file = new File("myfilewrong.txt");
		BufferedReader bufferedReader = null;
		
		try {
			//FileReader reads the whole file at one go
			FileReader fileReader = new FileReader(file);
			//Reads the file line by line. 
			bufferedReader = new BufferedReader(fileReader);
			
			String line = bufferedReader.readLine();
			
			while(line != null) {
				System.out.println(line);
				line = bufferedReader.readLine();
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Problem reading the file" + file.getName());
		} finally {
			try {
				bufferedReader.close();
			} catch (IOException e) {
				System.out.println("Unable to close the file " + file.getName());
			// You should never catch NullPointException, this just demonstrate that you could. Exception should be used for EXCEPTIONAL conditions, never for ordinary control flow
			} catch(NullPointerException ex) {
				System.out.println(" file was probably never opened " + ex);
			}
		}

	}

}
