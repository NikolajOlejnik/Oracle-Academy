package dev.olejnik.parsers;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import dev.olejnik.models.Goods;

public class SAXHandler extends DefaultHandler {

	private ArrayList<Goods> goodsList;
	private Goods good = new Goods();
	String thisElement = "";

	public ArrayList<Goods> getResult() {
		return goodsList;
	}

	@Override
	public void startDocument() throws SAXException {
		System.out.println("Start parse XML...");
		goodsList = new ArrayList<Goods>();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (qName.equalsIgnoreCase("Goods")) {
			System.out.println("Goods found. Id: "+attributes.getValue("id"));
			Goods temp = new Goods();
			this.goodsList.add(temp);
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		
		String value = new String(ch, start, length).trim();
		if(value.length() == 0) return;
		
		System.out.println("Found!!!");

			goodsList.add(new Goods());

			if (thisElement.equals("id")) {

				good.setId(new Long(new String(ch, start, length)));
			}
			if (thisElement.equals("name")) {
				good.setName(new String(ch, start, length));
			}
			if (thisElement.equals("price")) {
				good.setPrice(Double.parseDouble((new String(ch, start, length))));
			}

			if (thisElement.equals("category")) {
				good.setCategory(new String(ch, start, length));
			}
			if (thisElement.equals("description")) {
				good.setDescription(new String(ch, start, length));
			}
		

	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
	
	}

	@Override
	public void endDocument() {
		System.out.println("Stop parse XML...");
	}
}
