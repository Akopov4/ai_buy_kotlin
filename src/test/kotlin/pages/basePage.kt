package pages


import jakarta.annotation.PostConstruct
import org.openqa.selenium.*
import org.springframework.beans.factory.annotation.Autowired
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import org.springframework.stereotype.Component
import java.time.Duration
import kotlin.NoSuchElementException
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Value

@Component
public class BasePage @Autowired constructor(private val driver:WebDriver){

    @Value("\${app.url}")
    private lateinit var appurl:String

    @PostConstruct
    public fun initDriver() {
        PageFactory.initElements(driver, this);
        this.driver.navigate().to(appurl)
    }


    protected fun generateDynamicXpath(xpath:String, parammeters:List<String>):String{
        var locator = xpath
        for (i in 0 until parammeters.size) {
            locator = locator.replace("{${i}}", parammeters[i])
        }
        return locator


    }  fun getTextOfElement(webElement: WebElement): String {
        val text = webElement.text
        return text
    }
    fun findElement(elementLocator: String, timeout: Long = 5): WebElement {
        waitUntilElementIsPresent(elementLocator, timeout = timeout)
        var timeDuration = Duration.ofSeconds(timeout)
        var element = WebDriverWait(driver, timeDuration).until(
            ExpectedConditions.visibilityOfElementLocated(
                By.ByXPath(elementLocator)
            )
        )
        return (element)
    }
    fun waitUntilElementIsPresent(elementLocator: String, attempts: Int = 3, timeout: Long) {
        val range = 1.rangeTo(10)
        val timeDuration = Duration.ofSeconds(timeout)
        val timeperiod = timeout * attempts

        for (i in range) {
            try {
                WebDriverWait(
                    driver,
                    timeDuration
                ).until(ExpectedConditions.presenceOfElementLocated(By.ByXPath(elementLocator)))
                break
            } catch (ex: Exception) {
                when (ex) {
                    is TimeoutException,
                    is StaleElementReferenceException -> {
                        throw NoSuchElementException(
                            "Element $elementLocator not present in DOM after " +
                                    "$timeperiod seconds or it has been changed"
                        )
                    }
                }
            }

        }
    }

    fun waitUntilElementIsVisible(elementLocator: String, timeout: Long=3) {
        val timeDuration = Duration.ofSeconds(timeout)
        try {
            WebDriverWait(driver, timeDuration).until(
                ExpectedConditions.visibilityOfElementLocated(
                    By.ByXPath(
                        elementLocator
                    )
                )
            )
        } catch (e: NoSuchElementException) {
            throw NoSuchElementException("Element $elementLocator not visible after $timeout seconds")
        }
    }
    fun isElementVisible(elementLocator: String, timeout: Long = 5): Boolean {
        try {
            waitUntilElementIsVisible(elementLocator, timeout)
            return true
        } catch (e: NoSuchElementException) {
            return false
        }

    }
    fun getTextFromDropdown(elementLocator: String): List<String>{
        val items = findElements(elementLocator)
        val item_text = mutableListOf<String>()
        for (item in items) {
            item_text.add(item.text)
        }
        return item_text
    }
    fun findElements(elementLocator: String, timeout: Long = 5, wait: Boolean = true): List<WebElement> {
        if (wait) {
            waitUntilElementIsPresent(elementLocator, timeout = timeout)

        }
        val elements = driver.findElements(By.ByXPath(elementLocator))
        return elements
    }
    fun isDropDownVisible(elementLocator: String):Boolean{
        return isElementVisible(elementLocator)
    }

}