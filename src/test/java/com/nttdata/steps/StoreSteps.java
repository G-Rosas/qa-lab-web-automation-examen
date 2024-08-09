package com.nttdata.steps;

import com.nttdata.page.*;
import com.nttdata.page.StoreFrontPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.TimeoutException;

import java.time.Duration;

public class StoreSteps {
    private WebDriver driver;

    public StoreSteps(WebDriver driver){
        this.driver = driver;
    }

    public void typeUser(String user){
        WebElement userInputElement = driver.findElement(StoreLoginPage.userInput);
        userInputElement.sendKeys(user);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(StoreLoginPage.btnLogin));


    }
    public void typePassword(String password){
        this.driver.findElement(StoreLoginPage.passInput).sendKeys(password);
    }

    public void login(){
        this.driver.findElement(StoreLoginPage.btnLogin).click();
    }

    public void goToLogin(){
        this.driver.findElement(StoreFrontPage.btnIniciarSesion).click();
    }

    public void goToClothes() {
        this.driver.findElement(StoreFrontPage.btnClothes).click();
    }

    public void goToMen() {
        this.driver.findElement(StoreClothesPage.btnMen).click();
    }

    public void typeCant(String cant) {
        WebElement inputElement = this.driver.findElement(StoreProducto1Page.cantInput);
        inputElement.sendKeys(Keys.CONTROL + "a");
        inputElement.sendKeys(Keys.DELETE);
        inputElement.sendKeys(cant);

    }

    public void goToProducto1() {
        this.driver.findElement(StoreClothesMenPage.btnProducto1).click();
    }

    public void agregarACarrito() {
        this.driver.findElement(StoreProducto1Page.btnAgregar).click();
    }

    public String getTitleAgregado() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(StoreProducto1Page.lblProducto1Agregado));
        return this.driver.findElement(StoreProducto1Page.lblProducto1Agregado).getText();
    }

    public void validarMontoTotalCalculadoCorrectamente() {
        String precioText = driver.findElement(StoreProducto1Page.lblProducto1Precio).getText().replace("S/ ", "").trim();
        String cantidadText = driver.findElement(StoreProducto1Page.lblProducto1Cant).getText().trim();

        double precio = Double.parseDouble(precioText);
        int cantidad = Integer.parseInt(cantidadText);

        double totalEsperado = Math.round(precio * cantidad * 100.0) / 100.0;

        String totalCalculadoText = driver.findElement(StoreProducto1Page.lblTotalCalculado).getText().replace("S/ ", "").trim();
        double totalCalculado = Double.parseDouble(totalCalculadoText);

        Assertions.assertEquals(totalEsperado, totalCalculado, "El total calculado en el popup es incorrecto.");
    }

    public void finalizarCompra() {
        this.driver.findElement(StoreProducto1Page.btnFinalizarCompra).click();
    }

    public String getTitleCarrito() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(StoreCarritoPage.lblCarrito));
        return this.driver.findElement(StoreCarritoPage.lblCarrito).getText();
    }

    public void validarMontoTotalDeCarritoCalculadoCorrectamente() {
        String precioText = driver.findElement(StoreCarritoPage.lblPrecioProd1).getText().replace("S/ ", "").trim();
        String cantidadText = driver.findElement(StoreCarritoPage.lblCantProd1).getAttribute("value").trim();

        double precio = Double.parseDouble(precioText);
        int cantidad = Integer.parseInt(cantidadText);

        double totalEsperado = Math.round(precio * cantidad * 100.0) / 100.0;

        String totalCalculadoText = driver.findElement(StoreCarritoPage.lblCarritoTotal).getText().replace("S/ ", "").trim();
        double totalCalculado = Double.parseDouble(totalCalculadoText);

        Assertions.assertEquals(totalEsperado, totalCalculado, "El total calculado en el carrito es incorrecto.");
    }

    public String elSistemaMuestraUnMensajeDeErrorYNoAccedoALaPantallaPrincipal() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(StoreLoginPage.lblMensajeError));
        return this.driver.findElement(StoreLoginPage.lblMensajeError).getText();
    }

    public void goToAutos() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(StoreFrontPage.btnAutos));
            element.click();
        } catch (TimeoutException e) {
            throw new RuntimeException("Error: No se encuentra el elemento 'Autos' o no es clickeable", e);
        }
    }

    public void goToCars() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(StoreFrontPage.btnCars));
            element.click();
        } catch (TimeoutException e) {
            throw new RuntimeException("Error: No se encuentra el elemento 'Cars' o no es clickeable", e);
        }
    }
}
