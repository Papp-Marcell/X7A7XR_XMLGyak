package hu.domparse.X7A7XR;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMQueryX7A7XR {

	public static void main(String[] args) {
		try {
			DocumentBuilderFactory factory =
			DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(new File("XMLX7A7XR.xml"));
			document.getDocumentElement().normalize();
			
			//Query azoknak az önkénteseknek a nevei akik legalább 11-órát önkénteskedtek
			
			NodeList volunteers=document.getElementsByTagName("Onkentes");
			for(int i=0;i<volunteers.getLength();i++) {
				if(volunteers.item(i).getNodeType()==Node.ELEMENT_NODE) {
					Element element = (Element) volunteers.item(i);
					if(Integer.parseInt(element.getElementsByTagName("OnkentesOrak").item(0).getTextContent())>=11) {
						System.out.println(element.getElementsByTagName("Nev").item(0).getTextContent());
					}
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
