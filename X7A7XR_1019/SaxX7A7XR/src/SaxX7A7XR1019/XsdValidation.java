package SaxX7A7XR1019;
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.*;

import org.xml.sax.SAXException;


public class XsdValidation {

	public static void main(String[] args) {
		try {
			
			SchemaFactory schemaFactory = SchemaFactory.newDefaultInstance();
			Schema schema = schemaFactory.newSchema(new File("src/SaxX7A7XR1019/szemelyekX7A7XR.xsd"));
			
			SAXParserFactory saxParserFactory=SAXParserFactory.newInstance();
			
			saxParserFactory.setValidating(true);
			saxParserFactory.setSchema(schema);
			
			SAXParser saxParser= saxParserFactory.newSAXParser();
			
			SaxHandler saxHandler= new SaxHandler();
			
			saxParser.parse(new File("src/SaxX7A7XR1019/szemelyekX7A7XR.xml"), saxHandler);
			
		}catch(ParserConfigurationException | SAXException | IOException e)
		{
			e.printStackTrace();
			System.out.println("validation error");
			System.exit(1);
		}
		System.out.println("Successful validation!");
	}

}


