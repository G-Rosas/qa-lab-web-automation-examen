package com.nttdata.page;

import org.openqa.selenium.By;

public class StoreProducto1Page {
    public static By cantInput = By.xpath("//*[@id=\"quantity_wanted\"]");
    public static By btnAgregar = By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button");
    public static By lblProducto1Agregado = By.xpath("//div[@class='modal-header']/h4[@class='modal-title h6 text-sm-center']");

    public static By lblProducto1Precio = By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[1]/div/div[2]/p");
    public static By lblProducto1Cant = By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[1]/div/div[2]/span[3]/strong");
    public static By lblTotalCalculado = By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/p[4]/span[2]");
    public static By btnFinalizarCompra = By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a");
}
