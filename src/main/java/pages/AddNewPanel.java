package pages;

import controls.common.Button;
import controls.common.CheckBox;
import controls.common.ComboBox;
import controls.common.TextBox;
import controls.common.Link;

public class AddNewPanel extends GeneralPage {
	
	private Link radioType          = new Link("//tbody/tr/td/label[contains(text(),'%s')]");
	private ComboBox cbbDataProfile = new ComboBox("id=cbbProfile");
	private TextBox txtDisplayName  = new TextBox("id=txtDisplayName");
	private TextBox txtChartTitle   = new TextBox("id=txtChartTitle");
	private CheckBox chkShowTitle   = new CheckBox("id=chkShowTitle");
	private ComboBox cbbChartType   = new ComboBox("id=cbbChartType");
	private Link radioStyle         = new Link("//input[@type='radio' and @value='%s']");
	private ComboBox cbbCategory    = new ComboBox("id=cbbCategoryField");
	private TextBox txtCaptionOfCategory = new TextBox("id=txtCategoryXAxis");
	private ComboBox cbbSeries           = new ComboBox("id=cbbSeriesField");
	private TextBox txtCaptionOfSeries   = new TextBox("id=txtValueYAxis");
	private Link radioLegends            = new Link("//input[@value='%s']");
	private CheckBox chkSeries           = new CheckBox("id=chkSeriesName");
	private CheckBox chkCategories       = new CheckBox("id=chkCategoriesName");
	private CheckBox chkValue            = new CheckBox("id=chkValue");
	private CheckBox chkPercentage       = new CheckBox("id=chkPercentage");
	
	public void selectType(String type) {
		radioType.setDynamicValue(type);
		radioType.waitForVisibility();
		radioType.click();
	}
	
	public void selectStyle(String style) {
		radioStyle.setDynamicValue(style);
		radioStyle.waitForVisibility();
		radioStyle.click();
	}
	
	public void selectLegendse(String legend) {
		radioLegends.setDynamicValue(legend);
		radioLegends.waitForVisibility();
		radioLegends.click();
	}
	

}
