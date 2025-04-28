import java.util.*;

public class Shop {
    public static Scanner myScanner = new Scanner(System.in);

    public static class Store {
        String name = this.name; //Name
        boolean isOpen = this.isOpen; //Open or not

    }

    public static class item {
        String name = this.name;
        int price = this.price;
        String description = this.description;
        int inventory = this.inventory;
        String status = this.status;
    }

    public static void main(String[] args) {
        start();
    }

    public static void start() {
        System.out.println("----------");
        System.out.println("Welcome to the Java shop");
        System.out.println("What shop do you want to visit");
        System.out.println("----------");
        String shopNameInput = myScanner.next();
        shopOpen(shopNameInput);
    }

    public static void shopOpen(String name) {
//        if(name.equals(Store.name) && Store.isOpen == false){
//            storeMenu(false, name);
//        }
//        else{
//            storeMenu(true, name);
//        }
        storeMenu(!name.equals(Store.name) || Store.isOpen != false, name);
    }

    public static void storeMenu(boolean status, String name) {
        if (!status) {
            System.out.println("That store is not open, do you want to try another store?");
        } else {
            System.out.println("Welcome to the " + name + "store");
        }
    }
}