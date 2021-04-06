package Cart;

import java.util.ArrayList;
import java.util.Iterator;

public class ShoppingCart
{

    public ShoppingCart()
    {
        cart = new ArrayList();
    }

    public void addProduct(Product product)
    {
        cart.add(product);
    }

    public String toString()
    {
        if(cart.size() == 0)
            return "empty";
        Iterator iterator = cart.iterator();
        StringBuffer stringbuffer = new StringBuffer(((Product)iterator.next()).toString());
        for(; iterator.hasNext(); stringbuffer.append(((Product)iterator.next()).toString()))
            stringbuffer.append("\n");

        return stringbuffer.toString();
    }

    public double getTotalValue()
    {
        double d = 0.0D;
        for(Iterator iterator = cart.iterator(); iterator.hasNext();)
        {
            Product product = (Product)iterator.next();
            d += product.getValue();
        }

        return d;
    }

    private ArrayList cart;
}
