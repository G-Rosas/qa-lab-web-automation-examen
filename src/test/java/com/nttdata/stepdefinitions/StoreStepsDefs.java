package com.nttdata.stepdefinitions;

import com.nttdata.steps.StoreSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;

public class StoreStepsDefs {

    private WebDriver driver;

    private StoreSteps inventorySteps(WebDriver driver){
        return new StoreSteps(driver);
    }

    @Given("estoy en la página de la tienda")
    public void estoyEnLaPáginaDeLaTienda() {
        driver = getDriver();
        driver.get("https://qalab.bensg.com/store/pe/");
        screenShot();
    }


    @And("me logueo con mi usuario {string} y clave {string}")
    public void meLogueoConMiUsuarioYClave(String user, String password) {
        StoreSteps storeSteps = new StoreSteps(driver);
        storeSteps.goToLogin();
        storeSteps.typeUser(user);
        storeSteps.typePassword(password);
        storeSteps.login();
        screenShot();
    }


    @When("navego a la categoria {string} y subcategoria {string}")
    public void navegoALaCategoriaYSubcategoria(String arg0, String arg1) {
        StoreSteps storeSteps = new StoreSteps(driver);
        storeSteps.goToClothes();
        storeSteps.goToMen();
        screenShot();
    }

    @And("agrego {string} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(String cant) {
        StoreSteps storeSteps = new StoreSteps(driver);
        storeSteps.goToProducto1();
        storeSteps.typeCant(cant);
        storeSteps.agregarACarrito();
        screenShot();
    }


    @Then("valido en el popup la confirmación del producto agregado: {string}")
    public void validoEnElPopupLaConfirmaciónDelProductoAgregado(String expectedTitle) {
        StoreSteps storeSteps = new StoreSteps(driver);
        String title =  storeSteps.getTitleAgregado();
        Assertions.assertEquals(expectedTitle, title);
        screenShot();
    }

    @And("valido en el popup que el monto total sea calculado correctamente")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() {
        StoreSteps storeSteps = new StoreSteps(driver);
        storeSteps.validarMontoTotalCalculadoCorrectamente();
    }

    @When("finalizo la compra")
    public void finalizoLaCompra() {
        StoreSteps storeSteps = new StoreSteps(driver);
        storeSteps.finalizarCompra();
    }

    @Then("valido el título de la página del carrito: {string}")
    public void validoElTítuloDeLaPáginaDelCarrito(String expectedTitle) {
        StoreSteps storeSteps = new StoreSteps(driver);
        String title =  storeSteps.getTitleCarrito();
        Assertions.assertEquals(expectedTitle, title);
        screenShot();
    }

    @And("vuelvo a validar el cálculo de precios en el carrito")
    public void vuelvoAValidarElCálculoDePreciosEnElCarrito() {
        StoreSteps storeSteps = new StoreSteps(driver);
        storeSteps.validarMontoTotalDeCarritoCalculadoCorrectamente();
    }

    @Then("el sistema valida el mensaje de: {string}")
    public void elSistemaMuestraUnMensajeDeErrorYNoAccedoALaPantallaPrincipal(String expectedTitle) {
        StoreSteps storeSteps = new StoreSteps(driver);
        String title =  storeSteps.elSistemaMuestraUnMensajeDeErrorYNoAccedoALaPantallaPrincipal();
        Assertions.assertEquals(expectedTitle, title);
        screenShot();
    }


    @When("navego a la categoria que no existe {string} y subcategoria {string} y el sistema muestra un mensaje de error y no puedo continuar")
    public void navegoALaCategoriaQueNoExisteYSubcategoria(String arg0, String arg1) {
        StoreSteps storeSteps = new StoreSteps(driver);
        try {
            storeSteps.goToAutos();
            storeSteps.goToCars();
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
            screenShot();
            throw e;
        }

    }
}
