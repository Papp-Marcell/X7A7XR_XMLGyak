package domx7a7xr1026;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DomModifyX7A7XR {

	public static void main(String[] args) {
		try {
			DocumentBuilderFactory factory =
			DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(new File("src/domx7a7xr1026/carsX7A7XR.xml"));
			document.getDocumentElement().normalize();
			Node cars = document.getFirstChild();
			Node supercar = document.getElementsByTagName("supercars").item(0);
			
			NamedNodeMap attr = supercar.getAttributes();
	        Node nodeAttr = attr.getNamedItem("company");
	        nodeAttr.setTextContent("Lamborigini");
	        
	        
	        NodeList list = supercar.getChildNodes();
	         
	         for (int temp = 0; temp < list.getLength(); temp++) {
	            Node node = list.item(temp);
	            if (node.getNodeType() == Node.ELEMENT_NODE) {
	               Element eElement = (Element) node;
	               if ("carname".equals(eElement.getNodeName())) {
	                  if("Ferrari 101".equals(eElement.getTextContent())) {
	                     eElement.setTextContent("Lamborigini 001");
	                  }
	                  if("Ferrari 202".equals(eElement.getTextContent()))
	                     eElement.setTextContent("Lamborigini 002");
	               }
	            }
	         }
	         
	         NodeList childNodes = cars.getChildNodes();
	         
	         for(int count = 0; count < childNodes.getLength(); count++) {
	            Node node = childNodes.item(count);
	            
	            if("luxurycars".equals(node.getNodeName()))
	               cars.removeChild(node);
	         }
			
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
