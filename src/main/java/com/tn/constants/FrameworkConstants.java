package com.tn.constants;

import com.tn.enums.ConfigProperties;
import com.tn.utils.PropertyUtils;

public final class FrameworkConstants {

	private FrameworkConstants() {}

	public static final String RESOURCESPATH = System.getProperty("user.dir") + "/src/test/resources";
	public static final String CHROMEDRIVERPATH = RESOURCESPATH + "/executables/chromedriver.exe";
	private static final String GECKODRIVERPATH = RESOURCESPATH + "/executables/geckodriver.exe";
	private static final String CONFIGFILEPATH = RESOURCESPATH + "/config/config.properties";
	private static final int EXPLICITWAIT = 10;
	private static final String EXTENTREPORTFOLDERPATH = System.getProperty("user.dir") + "/extent-test-output/";
	private static String extentReportFilePath = "";
	private static final String RUNMANGERSHEET = "RUNMANAGER";
	private static final String EXCELPATH = RESOURCESPATH + "/excel/testdata.xlsx";
	private static final String ITERATIONDATASHEET = "DATA";

	public static String getExtentReportFilePath() {
		if (extentReportFilePath.isEmpty()) {
			extentReportFilePath = createReportPath();
		}
		return extentReportFilePath;
	}

	private static String createReportPath()  {
		if (PropertyUtils.get(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no")) {
			return EXTENTREPORTFOLDERPATH + System.currentTimeMillis() + "/index.html";
		} else {
			return EXTENTREPORTFOLDERPATH + "/index.html";
		}
	}

	public static String getConfigFilePath() {
		return CONFIGFILEPATH;
	}

	public static String getResourcesPath() {
		return RESOURCESPATH;
	}

	public static String getChromedriverpath() {
		return CHROMEDRIVERPATH;
	}
	
	public static String getGeckoDriverPath() {
		return GECKODRIVERPATH;
	}

	public static int getExplicitwait() {
		return EXPLICITWAIT;
	}

	public static String getExcelpath() {
		return EXCELPATH;
	}

	public static String getRunmangerDatasheet() {
		return RUNMANGERSHEET;
	}

	public static String getIterationDatasheet() {
		return ITERATIONDATASHEET;
	}

}
