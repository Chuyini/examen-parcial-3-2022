package edu.uaslp.objetos.shoppingcart.ShoppingCart;

import java.util.List;

public class ShoppingCart {
    private boolean empty;
    private  float TotalCost;
    private Item head;
    private Item tail;
    private int size=0;


    public boolean isEmpty() {
        return empty;
    }

    public float getTotalCost() {
        return TotalCost;



    }

    public void addItem(Item item) {

        if(head==null)
        {
             head=item;
            size++;
        }else
        {
            Item aux=head;
            for(int cont=0;cont<size;cont++)
            {

                aux=aux.next;
            }
            aux.next=item;
            tail=item;

        }



    }

    public boolean getItemsCount() {
        return false;
    }

    public List<Item> getItems() {
        return null;
    }

    public void removeItem(String itemCode1) {
    }
}
