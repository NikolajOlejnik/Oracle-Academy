package dev.olejnik.runners;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import dev.olejnik.models.Goods;
import dev.olejnik.parsers.SAXHandler;

public class SAXParserRunner {

	public static void main(String[] args) {
		Goods temp = new Goods();
		
		SAXParserFactory factory = SAXParserFactory.newInstance(); 
		SAXParser parser = null;
		SAXHandler handler = new SAXHandler();
		
		try {
			parser = factory.newSAXParser();
		} catch (ParserConfigurationException | SAXException e) {
			e.printStackTrace();
		} 
		 
		try {
			parser.parse(new File("XMLFile.xml"), handler);
		} catch (SAXException | IOException e) {
			e.printStackTrace();
		} 
		
		
		for(Goods goods: handler.getResult())
		      System.out.println("goods = " + goods.getName());
		  }
	}

