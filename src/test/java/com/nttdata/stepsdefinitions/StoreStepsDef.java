package com.nttdata.stepsdefinitions;

import com.nttdata.core.DriverManager;
import com.nttdata.steps.CartSteps;
import com.nttdata.steps.LoginSteps;
import com.nttdata.steps.StoreSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.junit.jupiter.api.Assertions;

public class StoreStepsDef {

    private LoginSteps loginSteps = new LoginSteps(DriverManager.getDriver());
    private StoreSteps storeSteps = new StoreSteps(DriverManager.getDriver());
    private CartSteps cartSteps = new CartSteps(DriverManager.getDriver());

    // precio del popup para comparar luego en el carrito
    private String precioPopup;
    private String totalPopup;

    @Given("estoy en la página de la tienda")
    public void estoy_en_la_pagina_de_la_tienda() {
        DriverManager.getDriver().get("https://qalab.bensg.com/store/en/login");
        DriverManager.screenShot();
    }

    @And("me logueo con mi usuario {string} y clave {string}")
    public void me_logueo_con_mi_usuario_y_clave(String usuario, String clave) {
        loginSteps.ingresar(usuario, clave);
    }

    @When("navego a la categoria {string} y subcategoria {string}")
    public void navego_a_la_categoria_y_subcategoria(String categoria, String subCategoria) {
        storeSteps.navegarCategoriaYSubcategoria(categoria, subCategoria);
    }

    @And("agrego {int} unidades del primer producto al carrito")
    public void agrego_unidades_del_primer_producto_al_carrito(int cantidad) {
        storeSteps.agregarPrimerProductoAlCarrito(cantidad);
    }

    @Then("valido en el popup la confirmación del producto agregado")
    public void valido_en_el_popup_la_confirmacion_del_producto_agregado() {
        String nombreProducto = storeSteps.obtenerNombreProductoPopup();
        Assertions.assertFalse(nombreProducto.isEmpty(), "El nombre del producto en el popup no debe estar vacío");
        precioPopup = storeSteps.obtenerTotalPopup();
        DriverManager.screenShot();
    }

    @And("valido en el popup que el monto total sea calculado correctamente")
    public void valido_en_el_popup_que_el_monto_total_sea_calculado_correctamente() {
        String itemsTexto = storeSteps.obtenerConteoItemsPopup();
        Assertions.assertFalse(itemsTexto.isEmpty(), "El conteo de items en el popup no debe estar vacío");
        totalPopup = storeSteps.obtenerTotalPopup();
        Assertions.assertFalse(totalPopup.isEmpty(), "El total del popup no debe estar vacío");
        DriverManager.screenShot();
    }

    @When("finalizo la compra")
    public void finalizo_la_compra() {
        storeSteps.procederAlCheckout();
    }

    @Then("valido el titulo de la pagina del carrito")
    public void valido_el_titulo_de_la_pagina_del_carrito() {
        String titulo = cartSteps.obtenerTituloCarrito();
        Assertions.assertEquals("SHOPPING CART", titulo, "El título de la página del carrito no es el esperado");
        DriverManager.screenShot();
    }

    @And("vuelvo a validar el calculo de precios en el carrito")
    public void vuelvo_a_validar_el_calculo_de_precios_en_el_carrito() {
        String totalCarrito = cartSteps.obtenerTotalCarrito();
        Assertions.assertFalse(totalCarrito.isEmpty(), "El total del carrito no debe estar vacío");
        Assertions.assertEquals(totalPopup, totalCarrito, "El total del carrito debe coincidir con el total del popup");
        DriverManager.screenShot();
    }
}