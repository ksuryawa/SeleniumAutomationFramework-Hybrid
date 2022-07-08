package com.ksuryawa.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.ksuryawa.config.factory.ConfigFactory;
import com.ksuryawa.enums.LogType;
import com.ksuryawa.utils.ScreenshotUtils;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 * @author Kapil Suryawanshi
 * 08/07/2022
 */
public final class FrameworkLogger {

	/**
	 * Private constructor to avoid external instantiation
	 */
	private FrameworkLogger() {
	}

	private static final Consumer<String> PASS = message-> ExtentManager.getExtentTest().pass(message);
	private static final Consumer<String> FAIL = message-> ExtentManager.getExtentTest().fail(message);
	private static final Consumer<String> INFO = message-> ExtentManager.getExtentTest().info(message);
	private static final Consumer<String> SKIP = message-> ExtentManager.getExtentTest().skip(message);
	private static final Consumer<String> CONSOLE = message -> System.out.println("INFO---->" + message);
	private static final Consumer<String> EXTENT_AND_CONSOLE = PASS.andThen(CONSOLE);

	private static final Consumer<String> TAKESCREENSHOT = message -> ExtentManager.getExtentTest().info("",
			MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
	private static final Map<LogType,Consumer<String>> LOGMAP= new EnumMap<>(LogType.class);
	private static final Map<LogType,Consumer<String>> SCREENSHOTMAP= new EnumMap<>(LogType.class);


	static {
		LOGMAP.put(LogType.PASS, PASS);
		LOGMAP.put(LogType.FAIL, FAIL.andThen(TAKESCREENSHOT));
		LOGMAP.put(LogType.SKIP, SKIP);
		LOGMAP.put(LogType.INFO, INFO);
		LOGMAP.put(LogType.CONSOLE, CONSOLE);
		LOGMAP.put(LogType.EXTENTANDCONSOLE, EXTENT_AND_CONSOLE);

		SCREENSHOTMAP.put(LogType.PASS, PASS.andThen(TAKESCREENSHOT));
		SCREENSHOTMAP.put(LogType.FAIL, FAIL.andThen(TAKESCREENSHOT));
		SCREENSHOTMAP.put(LogType.SKIP, SKIP.andThen(TAKESCREENSHOT));
		SCREENSHOTMAP.put(LogType.INFO,INFO);
		SCREENSHOTMAP.put(LogType.CONSOLE,CONSOLE);
		SCREENSHOTMAP.put(LogType.EXTENTANDCONSOLE,EXTENT_AND_CONSOLE.andThen(TAKESCREENSHOT));
	}

	public static void log(LogType status, String message){
		if(Boolean.TRUE.equals(ConfigFactory.getConfig().passedStepsScreenshots()))
		{
			SCREENSHOTMAP.getOrDefault(status,EXTENT_AND_CONSOLE).accept(message);
		}
		else
		{
			LOGMAP.getOrDefault(status,EXTENT_AND_CONSOLE).accept(message);
		}

	}
}