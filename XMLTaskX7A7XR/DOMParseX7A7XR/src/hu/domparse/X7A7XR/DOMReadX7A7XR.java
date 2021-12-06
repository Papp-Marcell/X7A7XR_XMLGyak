
/*
 *Ez a program szinte bármilyen XML fált beolvas és kiírja a konzolra a fájl faszerkezetét.
 *Ezt egy rekurzív metódussal teszi meg, a végigmegy az összes gyerekelemen, és ha van, 
 *akkor attribútumaikon és tartalmukon is.
*/

package hu.domparse.X7A7XR;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Attr;



public class DOMReadX7A7XR {

	public static void main(String[] args) {
		try {
			DocumentBuilderFactory factory =
			DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(new File("XMLX7A7XR.xml"));
			document.getDocumentElement().normalize();
			
			System.out.println("Root element: " + document.getDocumentElement().getNodeName());
			printNodes(0,document.getChildNodes());
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	//Rekurzívan kíír minden elemet és tartalmukat ha van
	private static void printNodes(int depth, NodeList nodeList) {
		for (int i = 0; i < nodeList.getLength(); i++) {
			if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) nodeList.item(i);
				String name = element.getNodeName();
				String indent = "";

				for (int indentIndex = 0; indentIndex<depth; indentIndex++) {
					indent += "  ";
				}
				
				
				
				if (element.getChildNodes().getLength() > 1) {
					System.out.println(indent + name + " : ");
					printAttributes(depth+1,element.getAttributes());
					printNodes(depth+1,element.getChildNodes());
				}
				else {
					System.out.println(indent + name + " : " + element.getTextContent());
				}
			}
		}
	}
	//Kiírja az attribútumokat, ha vannak
	private static void printAttributes(int depth, NamedNodeMap attributes) {
		String indent = "";

		for (int indentIndex = 0; indentIndex<depth; indentIndex++) {
			indent += "  ";
		}

		for (int i = 0; i<attributes.getLength(); i++) {
			Attr attribute = (Attr) attributes.item(i);
			String name = attribute.getNodeName();
			System.out.println(indent + name + " : " + attribute.getNodeValue());
		}
		
	}

}
