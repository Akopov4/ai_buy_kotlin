package pages.topMenu


import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component;
import pages.BasePage
import org.openqa.selenium.WebDriver
@Component
@Scope("prototype")
class TopMenu(driver:WebDriver): BasePage(driver) {


    fun clickOnItem(itemText: String) {
        val itemLocator =
            generateDynamicXpath(topMenuLocators().TOP_MENU_ITEM, listOf(itemText))
        findElement(itemLocator).click()
    }

    fun getColorOfSubMenu(): String {
        var element = findElement(topMenuLocators().SUB_MENU)
        return element.getCssValue("background-image")

    }

    fun getSubMenuItemsText(): List<String> {
        var subMenuItemText: MutableList<String> = mutableListOf()
        var subMenuItems = findElements(topMenuLocators().SUB_MENU_ITEMS_TEXT)
        for (item in subMenuItems) {
            subMenuItemText.add(item.text)
        }
        return subMenuItemText
    }



    fun clickOnSubmenuItem(item: String) {
        val locator = generateDynamicXpath(
            topMenuLocators().TOP_MENU_ITEM,
            listOf(item)
        )
        waitUntilElementIsVisible(locator)
        findElement(locator).click()


    }
    fun isSubHeadingVisible(heading:String):Boolean{
        val locator = generateDynamicXpath(topMenuLocators().SUB_HEADINGS, mutableListOf(heading))
        return isElementVisible(locator)
    }

    fun isIndustriesDropDownVisible(): Boolean{
        return isElementVisible(topMenuLocators().DROP_DOWN)
    }

    fun getTextFromDropDownItems():List<String>{
        var itemstext = getTextFromDropdown(topMenuLocators().DROP_DOWN_TEXT)
        return itemstext

    }
    fun isTopLogoVisible():Boolean{
        return isElementVisible(topMenuLocators().TOP_LOGO)
    }

    fun getTextOfTopMenuItems():List<String> {
        val menuItems = findElements(topMenuLocators().TOP_MENU_ITEMS)
        var textOfMenuItems: MutableList<String> = mutableListOf()
        for (item in menuItems) {
            textOfMenuItems.add(getTextOfElement(item))
        }
        return textOfMenuItems
    }
    fun isSubMenuVisible():Boolean{
        return  isElementVisible(topMenuLocators().SUB_MENU)

    }

}