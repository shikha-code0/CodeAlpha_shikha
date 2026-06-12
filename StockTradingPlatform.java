import java.util.HashMap;
import java.util.Scanner;

class Stock{
    String symbol;
    double price;
    Stock(String symbol,double price){
        this.symbol=symbol;
        this.price=price;

    }
}
class User{
    double balance;
    HashMap<String,Integer> portfolio=new HashMap<>();
    User(double balance){
        this.balance=balance;
    }
    void buyStock(Stock stock,int qty){
        double cost=stock.price*qty;
        if(balance>=cost){
            balance-=cost;
            portfolio.put(stock.symbol,portfolio.getOrDefault(stock.symbol,0)+qty);
            System.out.println("stock bought suuccessfully");
        }
        else{
            System.out.println("insufficient balance");
        }
    }
    void sellStock(Stock stock,int qty){
        int owned= portfolio.getOrDefault(stock.symbol,0);
        if(owned>=qty){
            balance+=stock.price*qty;
            portfolio.put(stock.symbol,owned-qty);
            System.out.println("stock sold successfully");
        }else{
            System.out.println("not enogh shares");
        }
    }
    void showportfolio(){
        System.out.println("portfolio");
        for(String stock :portfolio.keySet()){
            System.out.println(stock+" : "+portfolio.get(stock)+"shares");
        }
        System.out.println("balance: "+balance);

    }
}

public class StockTradingPlatform {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter initial balance: ");
        double balance=sc.nextDouble();
        User user=new User(balance);
        System.out.println("enter stock name: ");
        String stockName=sc.next();
        System.out.println("enter stock price: ");
        double stockPrice=sc.nextDouble();
        Stock stock =new Stock(stockName,stockPrice);
        int choice ;

            System.out.println("Stock trading list");
            System.out.println("1. buy stock");
            System.out.println("2. Sell stock");
            System.out.println(" 3. view portfolio");
            System.out.println("exit");
           do {
               System.out.println("enter choice");
               choice = sc.nextInt();
               switch (choice) {
                   case 1:
                       System.out.println("enter quantity to buy");
                       int buyqty = sc.nextInt();
                       user.buyStock(stock, buyqty);
                       break;
                   case 2:
                       System.out.println(" enter quantity to sell");
                       int sellqty = sc.nextInt();
                       user.sellStock(stock, sellqty);
                       break;
                   case 3:
                       user.showportfolio();
                       break;
                   case 4:
                       System.out.println("Thank you");
                       break;
                   default:
                       System.out.println("invalid choice");
               }
           }while ( choice != 4);
        sc.close();

    }
}
