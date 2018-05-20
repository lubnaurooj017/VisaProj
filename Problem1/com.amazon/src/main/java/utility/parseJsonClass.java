package utility;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.JSONObject;

public class parseJsonClass {

	public JSONObject getJsonTestDataObject()
	{
		String jsonData = "";
		BufferedReader br = null;
		String line;
		try {
			br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/testData/amazonTestData.json"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			while ((line = br.readLine()) != null)
			{
				jsonData += line + "\n";
			}			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JSONObject obj = new JSONObject(jsonData);
		return obj;
	}
	
	public String parseJsonTestData(JSONObject jsonObj, String testCaseName, String testValue )
	{
		String returnTestValue= (String) jsonObj.getJSONObject(testCaseName).get(testValue);
		return returnTestValue;
	}
}
