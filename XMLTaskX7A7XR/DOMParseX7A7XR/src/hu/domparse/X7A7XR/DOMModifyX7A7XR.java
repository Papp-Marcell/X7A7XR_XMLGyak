package hu.domparse.X7A7XR;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class DOMModifyX7A7XR {

	public static void main(String[] args) {
		try {
			DocumentBuilderFactory factory =
			DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(new File("XMLX7A7XR.xml"));
			document.getDocumentElement().normalize();
			
			//m1 azonosítójú menhely nevének megváltoztatása
			
			NodeList shelters=document.getElementsByTagName("Menhely");
			for(int i=0;i<shelters.getLength();i++) {
				if(shelters.item(i).getNodeType()==Node.ELEMENT_NODE) {
					Element element = (Element) shelters.item(i);
					//System.out.println(element.getAttribute("M_azonosito"));
					if(element.getAttribute("M_azonosito").equals("m1")) {
						element.getElementsByTagName("Nev").item(0).setTextContent("Modositott nev");
					}
				}
			}
			
			// Kiírás konzolra
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
	        Transformer transformer = transformerFactory.newTransformer();
	        DOMSource source = new DOMSource(document);
	        System.out.println("-----------Modified File-----------");
	        StreamResult consoleResult = new StreamResult(System.out);
	        transformer.transform(source, consoleResult);
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
