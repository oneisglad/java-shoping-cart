package Cart;
import java.lang.Object;
public class Product extends Object
{

    public Product(String s, int i, double d)
    {
        name = s;
        quantity = i;
        price = d;
    }

    public String getName()
    {
        return name;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public double getPrice()
    {
        return price;
    }

    public String toString()
    {
        return (new StringBuilder()).append(getName()).append("_").append(getQuantity()).append("_").append(getPrice()).toString();
    }

    public double getValue()
    {
        return (double)getQuantity() * getPrice();
    }

    private String name;
    private int quantity;
    private double price;
}