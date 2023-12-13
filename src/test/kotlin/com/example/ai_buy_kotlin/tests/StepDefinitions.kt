package com.example.ai_buy_kotlin.tests

import io.cucumber.java.en.Given


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service


import com.example.ai_buy_kotlin.pages.topMenu.TopMenu

@Service
class StepDefinitions @Autowired constructor(private val topMenu: TopMenu){



    @Given("Home page is loaded")
    public fun isTopLogoLoaded(){
        assert (topMenu.isTopLogoVisible())

    }
    @Then("Home, Solutions, Industries, Patents,News are present in the TOP Menu")
    fun areTopMenuItems() {
        var itemText= mutableListOf<String>()
        val textToVerifY = listOf<String>("home", "solutions", "industries", "patents", "news")
        for (text in topMenu.getTextOfTopMenuItems()){
            itemText.add(text)

        }
        assert(textToVerifY.containsAll(itemText))
    }
    @When("Click on item Solution in the Top bar")
    fun clickOnSolutionItem(){
        topMenu.clickOnItem("Solutions")
    }
    @Then("Sub menu occurs")
    fun isSubMenuVisible(){
        assert(topMenu.isSubMenuVisible())
    }
    @Then ("sub menu has green background")
    fun  checkColorOfSubMenu(){
        assert( "#93DA45" in topMenu.getColorOfSubMenu())
    }

    @Then("Our Solutions and Our Platforms are present in Green submenu")
    fun checkTextOfSubMenu(){

        val subMenuItemsText = topMenu.getSubMenuItemsText()
        assert(listOf("Our Solutions", "Our Platforms").containsAll(subMenuItemsText))

    }
    @When("User clicks on {string}")
    fun clickOnSubMenuItem(greenSubMenuItem:String) {
        topMenu.clickOnSubmenuItem(greenSubMenuItem)
    }
    @Then("{string} is visible")
    fun isSubHeadingVisibl(){
        assert (topMenu.isSubHeadingVisible("{string}"))
    }
    @When ("click on Industries in the top bar")
    fun clickOnIndustriesTopBar() {
        topMenu.clickOnItem("Industries")
        assert(topMenu.isIndustriesDropDownVisible())

    }
    @Then("appropriate values in dropdown are visible")
    fun dropDownItemsText(){

        val text = topMenu.getTextFromDropDownItems()
        val listToVerify = listOf<String>("OTT","Online Retail", "Entertainment", "Online Media", "Influencers")
        assert(text.containsAll(listToVerify))
    }

}