package SeleLv2.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import driver.DriverType;
import driver.DriverUtils;
import driver.manager.DriverManager;
import driver.manager.DriverManagerFactory;
import utils.Constants;

public class BaseTest {
	DriverManager driverManager;
	WebDriver driver;

	// Initiate log4j property system
        log4jConfiguration();
        DOMConfigurator.configure("resources/suites/log4j.xml");

	
	@BeforeMethod
	public void setUp() {
		driverManager = DriverManagerFactory.getDriverManager(DriverType.CHROME);
		driver = driverManager.getWebDriver();
		openBrowser();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	public void openBrowser() {
		DriverUtils.maximumBrowser();
		driver.get(Constants.URL);
	}

	@DataProvider
    public synchronized Object[][] getDataForTest() throws IOException {
        return getData(testCaseName, DataFilePath, logClass);
    }

    public static synchronized Object[][] getData(String testName, String dataFilePath, ExtentTest logTest) throws IOException {

        Object[][] data = new Object[0][1];

        //Read json file data using Gson library
        BufferedReader br = new BufferedReader(new FileReader(dataFilePath));
        JsonElement jsonElement = new JsonParser().parse(br);
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        //Check for the test name in the json file
        boolean blnTCExist = jsonObject.has(testName);
        if (!blnTCExist) {
            logTest.fail(testName + " is not present in the data.json file - " + dataFilePath);
            return data;
        }

        //Get test data for the specific test case
        JsonArray jsonArray = jsonObject.getAsJsonArray(testName);
        data = jsonArrayToObjectArray(jsonArray);
        return data;
    }

    public static synchronized Object[][] jsonArrayToObjectArray(JsonArray jsonArray){

        Object[][] data = new Object[0][1];
        int index = 0;
        Gson gson = new Gson();

        if (jsonArray.size()>0) {
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
