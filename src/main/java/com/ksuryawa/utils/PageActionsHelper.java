package com.ksuryawa.utils;

import com.ksuryawa.constants.FrameworkConstants;
import com.ksuryawa.driver.DriverManager;
import com.ksuryawa.enums.LogType;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

import static com.ksuryawa.reports.FrameworkLogger.log;

/**
 * @author Kapil Suryawanshi
 * 20/06/2022
 */
public class PageActionsHelper {

	//region Navigation
	protected void enterUrl(String url) {
		DriverManager.getDriver().get(url);
	}

	protected String getUrl() {
		return DriverManager.getDriver().getCurrentUrl();
	}

	protected void navigateTo(String url) {
		DriverManager.getDriver().navigate().to(url);
	}

	protected void navigateBack() {
		DriverManager.getDriver().navigate().back();
	}

	protected void navigateForward() {
		DriverManager.getDriver().navigate().forward();
	}

	protected void navigateTo(WebElement element) {
		DriverManager.getDriver().navigate().to(element.getAttribute("href"));
	}

	protected void refresh() {
		DriverManager.getDriver().navigate().refresh();
	}



	//endregion

	//region Browser
	protected String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}

	protected void refreshPage() {
		DriverManager.getDriver().navigate().refresh();
	}

	//endregion

	//region Click
	protected void click(By elementLocator) {
		WebElement element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
				.until(ExpectedConditions.elementToBeClickable(elementLocator));
		element.click();

	}

	protected void click(By elementLocator,String elementName) {
		WebElement element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
				.until(ExpectedConditions.elementToBeClickable(elementLocator));
		element.click();

		log(LogType.PASS,elementName+" is clicked");

	}

	//endregion

	//region SendKeys
	protected void sendKeys(By elementLocator, String text) {
		WebElement element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
				.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
		element.sendKeys(text);
	}

	protected void sendKeys(By elementLocator, String text,String elementName) {
		WebElement element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
				.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
		element.sendKeys(text);

		log(LogType.PASS,text + " entered successfully in " + elementName);
	}
	protected void sendKeysAndTab(By elementLocator, String text) {
		WebElement element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
				.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
		element.click();
		element.sendKeys(text);
		element.sendKeys(Keys.TAB);
	}

	protected void clearAndSendKeys(By elementLocator, String text) {
		WebElement element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
				.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
		element.clear();
		element.sendKeys(text);
	}

	protected void blankAndSendKeys(By elementLocator, String text) {
		if (Objects.isNull(text)) {
			text = "";
		}

		WebElement element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
				.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
		element.click();
		element.sendKeys(Keys.CONTROL + "a");
		element.sendKeys(Keys.DELETE);
		element.sendKeys(text);
	}

	protected void blankAndSendKeysAndTab(By elementLocator, String text) {
		WebElement element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
				.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
		element.click();
		element.sendKeys(Keys.CONTROL + "a");
		element.sendKeys(Keys.DELETE);
		element.sendKeys(text);
		element.sendKeys(Keys.TAB);
	}

	//endregion

	//region GetElementData

	protected String getText(By elementLocator) {
		WebElement element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
				.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
		return element.getText();
	}

	protected String getAttribute(By elementLocator, String attribute) {
		WebElement element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
				.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
		return element.getAttribute(attribute);
	}

	protected String getCssValue(By elementLocator, String cssValue) {
		WebElement element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
				.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
		return element.getCssValue(cssValue);
	}

	protected String getTagName(By elementLocator) {
		WebElement element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
				.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
		return element.getTagName();
	}

	protected String getValueFromElement(By elementLocator) {
		WebElement element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
				.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
		return element.getAttribute("value");

	}
	//endregion

	//region isElement
	protected boolean isElementDisplayed(By elementLocator) {
		WebElement element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
				.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
		return element.isDisplayed();
	}

	protected boolean isElementEnabled(By elementLocator) {
		WebElement element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
				.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
		return element.isEnabled();
	}

	protected boolean isElementSelected(By elementLocator) {
		WebElement element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
				.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
		return element.isSelected();
	}

	protected boolean isElementPresent(By elementLocator) {
		try {
			new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
					.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	protected boolean isElementNotPresent(By elementLocator) {
		try {
			new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
					.until(ExpectedConditions.invisibilityOfElementLocated(elementLocator));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	//endregion

	//region Select
	protected void selectByVisibleText(By elementLocator, String text) {
		WebElement element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
				.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	protected void selectByValue(By elementLocator, String value) {
		WebElement element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
				.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
		Select select = new Select(element);
		select.selectByValue(value);
	}

	protected void selectByIndex(By elementLocator, int index) {
		WebElement element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
				.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	protected WebElement getSelectedOption(By elementLocator) {
		WebElement element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
				.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
		Select select = new Select(element);
		return select.getFirstSelectedOption();
	}

	protected String getSelectedText(By elementLocator) {
		WebElement element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
				.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
		Select select = new Select(element);
		return select.getFirstSelectedOption().getText();
	}

	protected int getSelectedIndex(By elementLocator) {
		WebElement element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
				.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
		Select select = new Select(element);
		return select.getOptions().indexOf(select.getFirstSelectedOption());
	}

	protected List<WebElement> getAllSelectedOptions(By elementLocator) {
		WebElement element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
				.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
		Select select = new Select(element);
		return select.getAllSelectedOptions();
	}

	protected List<WebElement> getOptions(By elementLocator) {
		WebElement element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
				.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
		Select select = new Select(element);
		return select.getOptions();
	}

	protected Boolean isMultiple(WebElement elements) {
		Select select = new Select(elements);
		return select.isMultiple();
	}

	protected void deselectByVisibleText(By elementLocator, String text) {
		WebElement element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
				.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
		Select select = new Select(element);
		select.deselectByVisibleText(text);
	}

	protected void deselectByValue(By elementLocator, String value) {
		WebElement element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
				.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
		Select select = new Select(element);
		select.deselectByValue(value);
	}

	protected void deselectByIndex(By elementLocator, int index) {
		WebElement element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
				.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
		Select select = new Select(element);
		select.deselectByIndex(index);
	}

	protected void deselectAll(By elementLocator) {
		WebElement element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
				.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
		Select select = new Select(element);
		select.deselectAll();
	}


	//endregion

	//region Wait

	protected void waitForElementToBeDisplayed(By elementLocator) {
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()));
		wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
	}

	protected void waitForElementToBeClickable(By elementLocator) {
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()));
		wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
	}

	protected void waitForElementToBeInvisible(By elementLocator) {
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(elementLocator));
	}

	protected void waitForElementToBeSelected(By elementLocator) {
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()));
		wait.until(ExpectedConditions.elementToBeSelected(elementLocator));
	}

	protected void waitForTextToBePresentInElement(By elementLocator, String text) {
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(elementLocator, text));
	}

	protected void waitForTextToBePresentInElementValue(By elementLocator, String text) {
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()));
		wait.until(ExpectedConditions.textToBePresentInElementValue(elementLocator, text));
	}

	//endregion

	//region Actions
	protected void rightClick(By elementLocator) {
		WebElement element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
				.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
		Actions actions = new Actions(DriverManager.getDriver());
		actions.click(element).build().perform();
	}

	protected void doubleClick(By elementLocator) {
		WebElement element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
				.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
		Actions actions = new Actions(DriverManager.getDriver());
		actions.doubleClick(element).build().perform();
	}

	protected void dragAndDrop(By elementLocator, By targetLocator) {
		WebElement element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
				.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
		WebElement target = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
				.until(ExpectedConditions.visibilityOfElementLocated(targetLocator));
		Actions actions = new Actions(DriverManager.getDriver());
		actions.dragAndDrop(element, target).build().perform();
	}

	protected void dragAndDropBy(By elementLocator, int xOffset, int yOffset) {
		WebElement element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
				.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
		Actions actions = new Actions(DriverManager.getDriver());
		actions.dragAndDropBy(element, xOffset, yOffset).build().perform();
	}

	protected void moveToElement(By elementLocator) {
		WebElement element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
				.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
		Actions actions = new Actions(DriverManager.getDriver());
		actions.moveToElement(element).build().perform();
	}

	protected void moveToElement(By elementLocator, int xOffset, int yOffset) {
		WebElement element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
				.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
		Actions actions = new Actions(DriverManager.getDriver());
		actions.moveToElement(element, xOffset, yOffset).build().perform();
	}

	protected void contextClick(By elementLocator) {
		WebElement element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
				.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
		Actions actions = new Actions(DriverManager.getDriver());
		actions.contextClick(element).build().perform();
	}

	protected void doubleClickAndHold(By elementLocator) {
		WebElement element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
				.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
		Actions actions = new Actions(DriverManager.getDriver());
		actions.click().clickAndHold(element).build().perform();
	}

	protected void clickAndHold(By elementLocator) {
		WebElement element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
				.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
		Actions actions = new Actions(DriverManager.getDriver());
		actions.clickAndHold(element).build().perform();
	}

	protected void release(By elementLocator) {
		WebElement element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
				.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
		Actions actions = new Actions(DriverManager.getDriver());
		actions.release(element).build().perform();
	}
	//endregion

	//region Alerts
	protected void acceptAlert() {
		Alert alert = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
				.until(ExpectedConditions.alertIsPresent());
		alert.accept();
	}

	protected void dismissAlert() {
		Alert alert = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
				.until(ExpectedConditions.alertIsPresent());
		alert.dismiss();
	}

	protected void sendKeysToAlert(String text) {
		Alert alert = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
				.until(ExpectedConditions.alertIsPresent());
		alert.sendKeys(text);
	}

	protected String getTextFromAlert() {
		Alert alert = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
				.until(ExpectedConditions.alertIsPresent());
		return alert.getText();
	}
	//endregion

	//region Frames
	protected void switchToFrame(By elementLocator) {
		WebElement element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
				.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
		DriverManager.getDriver().switchTo().frame(element);
	}

	protected void switchToFrame(int index) {
		DriverManager.getDriver().switchTo().frame(index);
	}

	protected void switchToFrame(String frameName) {
		DriverManager.getDriver().switchTo().frame(frameName);
	}

	protected void switchToDefaultContent() {
		DriverManager.getDriver().switchTo().defaultContent();
	}

	protected void switchToParentFrame() {
		DriverManager.getDriver().switchTo().parentFrame();
	}
	//endregion

	//region Windows

	protected void switchToWindow(String windowTitle) {
		DriverManager.getDriver().switchTo().window(windowTitle);
	}

	protected void switchToWindow(int index) {
		String windowHandle = DriverManager.getDriver().getWindowHandles().toArray()[index].toString();
		DriverManager.getDriver().switchTo().window(windowHandle);
	}

	protected void switchToLastWindow() {
		String windowHandle = DriverManager.getDriver().getWindowHandles().toArray()[DriverManager.getDriver().getWindowHandles().size() - 1].toString();
		DriverManager.getDriver().switchTo().window(windowHandle);
	}

	protected void switchToFirstWindow() {
		String windowHandle = DriverManager.getDriver().getWindowHandles().toArray()[0].toString();
		DriverManager.getDriver().switchTo().window(windowHandle);
	}

	protected void closeWindow() {
		DriverManager.getDriver().close();
	}

	protected void closeWindow(String windowTitle) {
		DriverManager.getDriver().switchTo().window(windowTitle);
		DriverManager.getDriver().close();
	}

	protected void closeWindow(int index) {
		String windowHandle = DriverManager.getDriver().getWindowHandles().toArray()[index].toString();
		DriverManager.getDriver().switchTo().window(windowHandle);
		DriverManager.getDriver().close();
	}

	protected void closeLastWindow() {
		String windowHandle = DriverManager.getDriver().getWindowHandles().toArray()[DriverManager.getDriver().getWindowHandles().size() - 1].toString();
		DriverManager.getDriver().switchTo().window(windowHandle);
		DriverManager.getDriver().close();
	}

	protected void closeFirstWindow() {
		String windowHandle = DriverManager.getDriver().getWindowHandles().toArray()[0].toString();
		DriverManager.getDriver().switchTo().window(windowHandle);
		DriverManager.getDriver().close();
	}

	protected void closeAllWindows() {
		for (String windowHandle : DriverManager.getDriver().getWindowHandles()) {
			DriverManager.getDriver().switchTo().window(windowHandle);
			DriverManager.getDriver().close();
		}
	}

	protected void maximizeWindow() {
		DriverManager.getDriver().manage().window().maximize();
	}

	protected void minimizeWindow() {
		DriverManager.getDriver().manage().window().setPosition(new Point(0, 0));
	}

	protected void resizeWindow(int width, int height) {
		DriverManager.getDriver().manage().window().setSize(new Dimension(width, height));
	}

	protected void resizeWindow(Dimension dimension) {
		DriverManager.getDriver().manage().window().setSize(dimension);
	}

	protected void resizeWindow(int width, int height, int x, int y) {
		DriverManager.getDriver().manage().window().setPosition(new Point(x, y));
		DriverManager.getDriver().manage().window().setSize(new Dimension(width, height));
	}

	protected void resizeWindow(Dimension dimension, int x, int y) {
		DriverManager.getDriver().manage().window().setPosition(new Point(x, y));
		DriverManager.getDriver().manage().window().setSize(dimension);
	}

	protected void resizeWindow(int width, int height, Point point) {
		DriverManager.getDriver().manage().window().setPosition(point);
		DriverManager.getDriver().manage().window().setSize(new Dimension(width, height));
	}

	protected void resizeWindow(Dimension dimension, Point point) {
		DriverManager.getDriver().manage().window().setPosition(point);
		DriverManager.getDriver().manage().window().setSize(dimension);
	}
	//endregion

	//region Javascript
	protected void scrollToElement(By elementLocator) {
		WebElement element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
				.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	protected void executeScript(String script) {
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		js.executeScript(script);
	}

	protected void executeScript(String script, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		js.executeScript(script, element);
	}

	protected void executeScript(String script, Object... args) {
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		js.executeScript(script, args);
	}

	//endregion

	//region Sleep
	protected static void sleep(Integer seconds) {
		try {
			Thread.sleep(seconds * 1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
			// Restore interrupted state...
			Thread.currentThread().interrupt();
		}
	}

	protected static void sleep(Long milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
			// Restore interrupted state...
			Thread.currentThread().interrupt();
		}
	}

	protected static void sleep(Duration duration) {
		try {
			Thread.sleep(duration.toMillis());
		} catch (InterruptedException e) {
			e.printStackTrace();
			// Restore interrupted state...
			Thread.currentThread().interrupt();
		}
	}

	//endregion

}