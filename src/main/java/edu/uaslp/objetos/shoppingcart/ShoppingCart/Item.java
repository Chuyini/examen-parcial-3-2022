package edu.uaslp.objetos.shoppingcart.ShoppingCart;

import edu.uaslp.objetos.shoppingcart.exception.InvalidDataException;

import java.math.BigDecimal;

public class Item {

    private String codigo;
    private BigDecimal precioUnitario;
    private int cantida;
    private  String codigoProvedor;
    protected Item next;
    protected Item previus;

    public Item(String itemCode1, String providerCode1, BigDecimal bigDecimal, int i) {

        if(itemCode1==null)
        {
            throw new InvalidDataException();

        }else if(providerCode1=="")
        {
            throw new InvalidDataException("Null or empty string not allowed for provider code");

        }else if(bigDecimal.intValue()<0)
        {
            throw new InvalidDataException("Cost must be greater than zero");
        }else if(i<1||i>5)
        {
            throw new InvalidDataException("Quantity must be greater than zero and lower than 5");

        }else
        {
            this.codigo=itemCode1;
            this.codigoProvedor=providerCode1;
            this.precioUnitario=bigDecimal;
            this.cantida=i;
        }



    }

    public Item() {

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

    public String getCode() {
        return codigo;
    }


    public String getProviderCode() {
        return codigoProvedor;
    }

    public int getQuantity() {
        return cantida;
    }

    public BigDecimal getUnitCost() {
        return precioUnitario;
    }
}
