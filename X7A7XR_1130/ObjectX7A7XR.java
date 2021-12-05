package domx7a7xr1026;

import org.json.simple.JSONObject;
import java.io.File;

public class ObjectX7A7XR {

	public static void main(String[] args) {

		
		
		try {
			JSONObject json=new JSONObject();
			json.put("Név", "BLászló");
			json.put("Fizetes", new Double(1000000));
			json.put("Kor", new Integer(21));
			
			System.out.println(json.toJSONString());
		}catch(Exception e) {
			
		}

	}

}
