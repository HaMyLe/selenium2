package utils.helpers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import utils.data.TestData;

public class JsonHelper {
	private final static String jsonPath = "src/main/resources/data/";

	public static synchronized JSONObject getData(String fileName, String testName, String vale) {

		JSONObject dataObject = null;
		try {
			// Read json data
			FileReader reader = new FileReader(getPathFile(jsonPath + fileName));
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
			dataObject = (JSONObject) jsonObject;
			System.out.println(dataObject);

			// Check for the test name in the json file
			boolean blnTCExist = (boolean) dataObject.get(testName);
			if (!blnTCExist) {
				return dataObject;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return dataObject;
	}

	public static String getPathFile(String filename) throws IOException {
		String filePath = null;
		filePath = new File(filename).getAbsolutePath();
		return filePath;
	}

	public static void main(String[] args) {
		try {
			getDataFile("data.json", "DA_LOGIN_TC002");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	public static synchronized Object[][] getData(String fileName, String testCaseName) throws FileNotFoundException {
		JsonElement jsonData = new JsonParser().parse(new FileReader(jsonPath + fileName));
		JsonElement dataSet = jsonData.getAsJsonObject().get(testCaseName);
		List<TestData> testData = new Gson().fromJson(dataSet, new TypeToken<List<TestData>>() {
		}.getType());
		Object[][] returnValue = new Object[testData.size()][1];
		int index = 0;
		for (Object[] each : returnValue) {
			each[0] = testData.get(index++);
		}
		System.out.print(testData);
		return returnValue;
	}

	@SuppressWarnings("deprecation")
	public static synchronized Object[][] getDataFile(String fileName, String testName) throws FileNotFoundException {

		Object[][] data = new Object[0][1];

		// Read json file data using Gson library
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(getPathFile(jsonPath + fileName)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JsonElement jsonElement = new JsonParser().parse(br);
		JsonObject jsonObject = jsonElement.getAsJsonObject();

		// Get test data for the specific test case
		JsonArray jsonArray = jsonObject.getAsJsonArray(testName);
		data = jsonArrayToObjectArray(jsonArray);
		return data;
	}

	public static synchronized Object[][] jsonArrayToObjectArray(JsonArray jsonArray) {

		Object[][] data = new Object[0][1];
		int index = 0;
		Gson gson = new Gson();

		if (jsonArray.size() > 0) {
			data = new Object[jsonArray.size()][1];
			for (Object obj : jsonArray) {
				Hashtable<String, String> hashTable = new Hashtable<String, String>();
				data[index][0] = gson.fromJson((JsonElement) obj, hashTable.getClass());
				index++;
			}
		}
		return data;
	}

}
