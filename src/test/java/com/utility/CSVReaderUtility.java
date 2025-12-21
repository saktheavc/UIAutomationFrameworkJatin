package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojo.User;

public class CSVReaderUtility {

	public static Iterator<User> readCSVFile(String fileName) {
		
		File csvFile = 
				new File(System.getProperty("user.dir")+"/testData/" + fileName);
		FileReader reader;
		CSVReader csvreader;
		String[] line;
		User userData = null;
		List<User> userList = null;
		try {
			reader = new FileReader(csvFile);
			csvreader = new CSVReader(reader);
			csvreader.readNext(); // skip 1st row data --> Headers EmailAddress & Password
			
			userList = new ArrayList<User>();
			while((line = csvreader.readNext()) != null) {
				userData = new User(line[0],line[1]); // store email and password for a row
				userList.add(userData);
			}
			
		} 
		
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		catch (CsvValidationException | IOException e) {
			e.printStackTrace();
		}
		
		return userList.iterator();
	}
}
