package Cart;
import  java.io.*;   
import  java.util.*;   
  
public class ShoppingCartApplication  {   
   
    private static BufferedReader  stdIn =   
        new  BufferedReader(new  InputStreamReader(System.in));   
    private static PrintWriter  stdOut =   
        new  PrintWriter(System.out, true);   
    private static PrintWriter  stdErr =   
        new  PrintWriter(System.err, true);   
   
    private ShoppingCart cart;   
  
    public static void main(String[]  args) throws IOException  {   
   
        ShoppingCartApplication application = new  ShoppingCartApplication();   
   
        application.run();   
    }   
  
    private void run() throws IOException  {   
   
        cart = new  ShoppingCart();   
   
        int  choice = getChoice();   
   
        while (choice != 0)  {   
   
            if (choice == 1)  {   
                cart.addProduct(readProduct());   
            } else if (choice == 2)  {   
                stdOut.println(cart.toString());   
            } else if (choice == 3)  {   
                stdOut.println(cart.getTotalValue());   
            }   
   
            choice = getChoice();   
        }   
    }   
   
    private int  getChoice() throws IOException  {   
   
        do  {   
   
            int input;   
   
            try  {   
                stdErr.println();   
                stdErr.print("[0]  Quit\n"   
                             + "[1]  Add Product\n"   
                             + "[2]  Display Products\n"   
                             + "[3]  Display Total\n"   
                             + "choice>");   
                stdErr.flush();   
   
                input = Integer.parseInt(stdIn.readLine());   
   
                if (0 <= input && 3 >= input)  {   
   
                    return  input;   
   
                } else {   
                    stdErr.println("Invalid choice:  " + input);   
                }   
            } catch (NumberFormatException  nfe)  {   
                stdErr.println(nfe);   
            }   
        }  while (true);   
    }   
   
    private Product readProduct() throws IOException {   
   
        String name = "";   
        int quantity = 0;   
        double price = 0.0;   
outer:while(true){   
            stdOut.print("product [name_qty_price]> ");   
            stdOut.flush();   
            try{   
        StringTokenizer  tokenizer =   
            new  StringTokenizer(stdIn.readLine(),"_");   
        if (tokenizer.countTokens() != 3) {   
            stdErr.println("Invalid input");   
            continue outer;   
        }    
        else {   
            name = tokenizer.nextToken();   
            quantity = Integer.parseInt(tokenizer.nextToken());   
            price = Double.parseDouble(tokenizer.nextToken());   
        }   
        if (quantity<=0||price<0.0D){   
            stdErr.println("Invalid input");   
            continue outer;}   
            }   
        catch (NumberFormatException  nfe)  {   
           
            stdErr.println(nfe);    
            continue outer;   
        }   
        return new Product(name, quantity, price);   
        }   
    }   
}  