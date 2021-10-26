package domx7a7xr1026;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class DomWriteX7A7XR {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			DocumentBuilderFactory factory =
			DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(new File("src/domx7a7xr1026/usersX7A7XR.xml"));
			document.getDocumentElement().normalize();
			
			System.out.println("Root element: " + document.getDocumentElement().getNodeName());
			document.getDocumentElement().setAttribute("xmlns", "domX7A7XR");
			NodeList nList = document.getElementsByTagName("user");
			
			for (int temp = 0; temp < nList.getLength(); temp++) {
	            Node nNode = nList.item(temp);
	            System.out.println("\nCurrent Element :" + nNode.getNodeName());
	            
	            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	               Element eElement = (Element) nNode;
	               System.out.println("User id: " + eElement.getAttribute("id"));
	               System.out.println("First Name : " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
	               System.out.println("Last Name : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
	               System.out.println("Profession : " + eElement.getElementsByTagName("profession").item(0).getTextContent());
	               
	            }
	         }
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
	         Transformer transformer = transformerFactory.newTransformer();
	         DOMSource source = new DOMSource(document);
	         StreamResult result = new StreamResult(new File("users1X7A7XR.xml"));
	         transformer.transform(source, result);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
