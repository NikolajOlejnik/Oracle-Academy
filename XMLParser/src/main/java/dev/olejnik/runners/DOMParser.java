package dev.olejnik.runners;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMParser {

	public static void main(String[] args) {
		File inputFile = new File("XMLFile.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		Document doc = null;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(inputFile);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}

		doc.getDocumentElement().normalize();
		System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
		NodeList nList = doc.getElementsByTagName("goods");
		for (int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i);
			System.out.println("\nCurrent Element: " + nNode.getNodeName());
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				System.out.println("Goods id : " + eElement.getAttribute("id"));
				System.out.println("Goods name : " + eElement.getElementsByTagName("name").item(0).getTextContent());
				System.out.println("Goods price: "
						+ Double.parseDouble(eElement.getElementsByTagName("priсe").item(0).getTextContent()));
				System.out.println(
						"Goods category : " + eElement.getElementsByTagName("category").item(0).getTextContent());
				System.out.println(
						"Goods description : " + eElement.getElementsByTagName("description").item(0).getTextContent());
			}
		}
	}
}
