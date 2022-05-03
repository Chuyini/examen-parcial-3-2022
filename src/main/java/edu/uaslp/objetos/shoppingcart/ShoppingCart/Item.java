package edu.uaslp.objetos.shoppingcart.ShoppingCart;

import java.math.BigDecimal;

public class Item {

    private String codigo;
    private BigDecimal precioUnitario;
    private int cantida;
    private  String codigoProvedor;
    protected Item next;
    protected Item previus;

    public Item(String itemCode1, String providerCode1, BigDecimal bigDecimal, int i) {

    }


    public void setCode(String itemCode) {
        this.codigo=itemCode;
    }

    public void setProviderCode(String providerCode) {
        this.codigoProvedor=providerCode;
    }

    public void setQuantity(int i) {
        this.cantida=i;
    }

    public void setUnitCost(BigDecimal bigDecimal) {
        this.precioUnitario=bigDecimal;
    }

    public boolean getCode() {
        return false;
    }

    public boolean getProviderCode() {
        return false;
    }

    public boolean getQuantity() {
        return false;
    }

    public boolean getUnitCost() {
        return false;
    }
}
