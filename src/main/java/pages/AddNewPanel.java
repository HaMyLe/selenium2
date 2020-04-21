package pages;

import controls.common.Button;
import controls.common.CheckBox;
import controls.common.ComboBox;
import controls.common.TextBox;
import controls.common.Link;

public class AddNewPanel extends GeneralPage {
	
	private Link radioType = new Link("//tbody/tr/td/label[contains(text(),' %s')]");
	private ComboBox cbbDataProfile = new ComboBox("id=cbbProfile");
	private TextBox txtDisplayName = new TextBox("id=txtDisplayName");
	private TextBox txtChartTitle = new TextBox("id=txtChartTitle");
	private CheckBox chkShowTitle = new CheckBox("id=chkShowTitle");
	
	private TextBox txtPageName = new TextBox("id=name");
	private Button btnOK = new Button("//input[@id='OK']");
	private ComboBox cbbParentPage = new ComboBox("id=parent");
	private ComboBox cbbNumberOfColumns = new ComboBox("id=columnnumber");
	private ComboBox cbbDisplayAfter = new ComboBox("id=afterpage");
	private CheckBox chkIsPublic = new CheckBox("id=ispublic");

}
