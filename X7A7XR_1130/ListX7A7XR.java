package domx7a7xr1026;

import org.json.simple.JSONArray;

public class ListX7A7XR {

	public static void main(String[] args) {
		try {
			JSONArray json=new JSONArray();
			json.add("BL");
			json.add(new Double(1000000));
			json.add(new Integer(21));
			
			for(Object obj : json) {
				System.out.print(obj+" ");
			}
		}catch(Exception e) {
			
		}

	}

}
