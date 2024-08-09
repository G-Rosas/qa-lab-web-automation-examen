package com.nttdata.page;

import org.openqa.selenium.By;

public class StoreLoginPage {
    public static By userInput = By.xpath("//*[@id=\"field-email\"]");
    public static By passInput = By.xpath("//*[@id=\"field-password\"]");
    public static By btnLogin = By.id("submit-login");
    public static By lblMensajeError = By.xpath("//*[@id=\"content\"]/section/div/ul/li");


}
