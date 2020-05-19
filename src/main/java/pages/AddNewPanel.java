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
	private Link radioDataLabel            = new Link("//td//label[contains(text(),'Series')]");
	
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
	
	public void selectLegend(String legend) {
		radioLegends.setDynamicValue(legend);
		radioLegends.waitForVisibility();
		radioLegends.click();
	}
	
	public void selectDataLabel(String dataLabel) {
		radioDataLabel.setDynamicValue(dataLabel);
		radioDataLabel.waitForVisibility();
		radioDataLabel.click();
	}
	
	public void enterDisplayName(String displayName) {
		txtDisplayName.enter(displayName);
	}
	
	public void enterChartTitle(String chartTitle) {
		txtChartTitle.enter(chartTitle);
	}
	
	public void enterCaptionOfCategory(String caption) {
		txtCaptionOfCategory.enter(caption);
	}
	
	public void enterCaptionOfSeries(String caption) {
		txtCaptionOfSeries.enter(caption);
	}
	
	
	public void fillChartSetting(String chartTitle,boolean isShowTitle, String chartType, String style, String category, String captionOfCategory,
			String series, String captionOfSeries, String legends, String dataLabel) {
		enterChartTitle(chartTitle);
		chkShowTitle.click();
		cbbChartType.select(chartType);
		selectStyle(style);
		cbbCategory.select(category);
		enterCaptionOfCategory(captionOfCategory);
		cbbSeries.select(series);
		enterCaptionOfSeries(captionOfSeries);
		selectLegend(legends);
		selectDataLabel(dataLabel);
	}
	
	public void fillNewPanelPage(String type, String dataProfile, String displayName, String chartTitle,
			boolean isShowTitle, String chartType, String style, String category, String captionOfCategory,
			String series, String captionOfSeries, String legends, String dataLabel) {
		selectType(type);
		cbbDataProfile.select(dataProfile);
		enterDisplayName(displayName);
		fillChartSetting(chartTitle, isShowTitle, chartType, style, category, captionOfCategory, series, captionOfSeries, legends, dataLabel);
	}

}
