package pages;

import controls.common.Button;
import controls.common.CheckBox;
import controls.common.ComboBox;
import controls.common.TextBox;

public class AddNewPage extends GeneralPage {
	
	private TextBox txtPageName = new TextBox("id=name");
	private Button btnOK = new Button("//input[@id='OK']");
	private ComboBox cbbParentPage = new ComboBox("id=parent");
	private ComboBox cbbNumberOfColumns = new ComboBox("id=columnnumber");
	private ComboBox cbbDisplayAfter = new ComboBox("id=afterpage");
	private CheckBox chkIsPublic = new CheckBox("id=ispublic");
	
//	private TextBox txtPageName = new TextBox("");

	public void enterPageName(String pageName) {
		txtPageName.enter(pageName);
	}
	
	public void fillNewPageForm(String pageName, String parentPage, int numberOfColumns, String displayAfter,
			boolean isPublic) {
		txtPageName.enter(pageName);
		cbbParentPage.select(parentPage);
		cbbNumberOfColumns.select(String.valueOf(numberOfColumns));
		cbbDisplayAfter.select(displayAfter);
		chkIsPublic.click();

	}

}
