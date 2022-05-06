package edu.uaslp.objetos.shoppingcart.ShoppingCart;

import edu.uaslp.objetos.shoppingcart.exception.EmptyShoppingCartException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ShoppingCart implements List {
    private boolean empty=true;
    private BigDecimal TotalCost;
    private Item head;
    private Item tail;
    private int size=0;


    @Override
    public int size() {
        return size;
    }

    public boolean isEmpty() {

        return empty;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object item) {


        int cont;
        if(head==null)
        {
            head= (Item) item;
            tail=(Item)item;
            size++;
        }else
        {
            Item aux=head;
            for( cont=0;cont<=size-1 ;cont++)
            {
                if (aux.next==null)
                {
                    aux.next= (Item) item;
                    tail= (Item) item;
                    size++;
                    return true;
                }

                aux=aux.next;
            }


        }
        if(size>0)
        {
            empty=false;
        }
        return true;

    }

    @Override
    public boolean remove(Object aux) {
        Item aux2=(Item) aux;
        if(aux2.next==null)
        {
            aux2=null;
        }else if(aux2==head)
        {
            head=head.next;
            aux2=null;
        }else
        {

            aux2.previus.next=aux2.next;
            aux2.next.previus=aux2.previus;
            aux2=null;



        }
        return true;

    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Object get(int index) {
        Item aux=head;
        if(aux==null)
        {
            throw  new EmptyShoppingCartException();
        }
        for(int cont=0;cont<index;cont++)
        {
            aux=aux.next;
        }

        return aux;
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int index, Object element) {


    }

    @Override
    public Object remove( int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    public BigDecimal getTotalCost() {
        Item aux=head;
        BigDecimal cost=BigDecimal.ZERO;

        double trun;
        String trun2;
        float trun3;

        float costin=0;
        BigDecimal totalCost = BigDecimal.ZERO;

        if(empty==false)
        {
            for(int cont=0;cont<=size-1;cont++)
            {


                costin= (float) (( aux.getQuantity()*aux.getUnitCost().doubleValue())+costin);

                aux=aux.next;

            }
            BigDecimal truc = new BigDecimal(costin);

            cost=truc.setScale(2, RoundingMode.DOWN);





            return cost;





        }else
        {
            throw new EmptyShoppingCartException();
        }

    }

    public void addItem(Item item) {

        Item aux2 =foundIteam(item);

        if(aux2!=null) {
            if(aux2.getUnitCost().floatValue()==item.getUnitCost().floatValue())
            {
                aux2.setQuantity(aux2.getQuantity()+item.getQuantity());

                return;
            }else {
                add(item);

                return;




            }

        }

        if(head==null)
        {
             head=item;
             tail=head;
            size++;
        }else
        {
            Item aux=head;
            for(int cont=0;cont<size-1;cont++)
            {

                aux=aux.next;
            }
            aux.next=item;
            tail=item;
            size++;

        }
        if(size>0)
        {
            empty=false;
        }





    }

    public int getItemsCount() {

        int itemsCount=0;
        Item aux=head;
        for(int cont=0;cont<=size-1;cont++)
        {
            if(aux.next==null)
            {
                itemsCount=aux.getQuantity()+itemsCount;
                return itemsCount;
            }
            itemsCount=aux.getQuantity()+itemsCount;

            aux=aux.next;

        }


        return itemsCount;
    }

    public List<Item> getItems() {
        ShoppingCart list=new ShoppingCart();
        List<Item> items = list;
        Item aux=head;
        int cont;


        for(cont=0;cont<=size-1;cont++)
        {


            Item copia=new Item(aux.getCode(), aux.getProviderCode(), aux.getUnitCost(), aux.getQuantity());
            items.add(copia);

            aux=aux.next;
        }

        return items;

    }

    public void removeItem(String itemCode1) {
        Item aux=head;

        for(int cont=0;cont<=size-1;cont++)
        {
            if(aux.getCode()==itemCode1)
            {
                aux.setQuantity(aux.getQuantity()-1);
                if(aux.getQuantity()==0)
                {

                    remove(aux);
                    size--;



                }



                return;

            }
            aux=aux.next;
        }

    }

    private Item foundIteam(Item item)
    {
        Item aux=head;
        for(int cont=0;cont<=size-1;cont++)
        {
            if(aux.getCode()==item.getCode())
            {
                return aux;
            }
            aux=aux.next;
        }
        return null;
    }


}

