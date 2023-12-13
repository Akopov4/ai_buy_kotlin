package com.example.ai_buy_kotlin

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary

@Configuration

public class WebDriver{
    @Bean
    @ConditionalOnProperty(prefix = "browser", havingValue = "Chrome")
    @Primary
    public fun getChromeDriver(): WebDriver {
        WebDriverManager.chromedriver().setup()
        return ChromeDriver()
    }
    @Bean
    @ConditionalOnProperty(prefix = "browser", havingValue = "FireFox")
    @Primary
    public fun getFireFoxDriver():WebDriver{
        WebDriverManager.firefoxdriver().setup()
        return FirefoxDriver()
    }

}

