package com.example.ai_buy_kotlin.pages.topMenu

class topMenuLocators {
    val TOP_LOGO:String =
        "//div[@data-elementor-type=\"header\"]//img[contains(@class,\"large\")]//div[@data-elementor-type=\"header\"]" +
                "//img[contains(@class,\"large\")]"
    val TOP_MENU_ITEMS = "//a[contains(@class,\"ekit-menu-nav-link\")]"
    val TOP_MENU_ITEM = "//a[contains(@class,'ekit-menu-nav-link')][text()=\"{0}\"]/.."
    val SUB_MENU = "//ul[@class=\"elementor-nav-menu\"]/ancestor::section"
    val SUB_MENU_ITEM = "//nav[contains(@class,\"elementor-nav-menu--main\")]//li/a[text()={0}]/.."
    val SUB_MENU_ITEMS_TEXT = "//nav[contains(@class,\"elementor-nav-menu--main\")]//li/a]"
    val SUB_HEADINGS ="//h2[contains(@class,\"elementor-heading\") and  text()={0}]"
    val DROP_DOWN ="//div[@class=\"elementskit-megamenu-panel\"]"
    val DROP_DOWN_TEXT = "//ul[@class=\"elementor-icon-list-items\"]//span"
}