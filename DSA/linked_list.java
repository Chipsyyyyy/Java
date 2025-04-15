package DSA;
import java.util.*;
public class linked_list {
    public static LinkedList<Integer> list = new LinkedList<>();
    public static Scanner scan = new Scanner(System.in);
    public static Random rand = new Random();
    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            addToList();
            displayListInfo();
            running = askToContinue();
        }
    }

    public static void addToList() {
        System.out.println("How many numbers do you want to add to the list?");
        int numOfItems = scan.nextInt();
        for (int i = 0; i < numOfItems; i++) {
//            System.out.println("Insert a number:");
//            int num = scan.nextInt();
            list.add(rand.nextInt(100) +  1);
        }

        while (true) {
            System.out.println("Do you want to add another number? (y/n)");
            String answer = scan.next();
            if (answer.equals("n")) {
                break;
            } else if (answer.equals("y")) {
                addToList();
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        }
    }

    public static void displayListInfo() {
        System.out.println("The list contains: " + list);
        System.out.println("The head of the list is: " + list.getFirst());
        System.out.println("The tail of the list is: " + list.getLast());
        System.out.println("List size: " + list.size());
    }

    static boolean askToContinue(){
        while (true){
            System.out.println("Would you like to perform another operation? (y/n)");
            String operationChoice = scan.next();
            if (operationChoice.equals("n") || operationChoice.equals("N")) {
                System.out.println("Goodbye!");
                return false;
            } else if (operationChoice.equals("y") || operationChoice.equals("Y")) {
                operations();
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        }
    }

    public static void operations(){
        System.out.println("What operation would you like to perform? (remove, search)");
        String operation = scan.next().toLowerCase();

        switch (operation){
            case "remove":
                scan.nextLine();
                System.out.println("Which number would you like to remove?");
                int numToRemove = scan.nextInt();
                removeFromList(numToRemove);
                break;
            case "search":
                scan.nextLine();
                System.out.println("Which number would you like to search for?");
                int numToSearch = scan.nextInt();
                searchList(numToSearch);
        }
    }

    public static void searchList(int num) {
        int current = list.getFirst();
        int counter = 0;
        if(list.contains(num)){
            current = list.get(counter);
            System.out.println("The number " + num + " was found at index " + list.indexOf(num));
        }
        else {
            System.out.println("The number " + num + " was not found in the list");
        }
    }

    public static void removeFromList(int num) {
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) == num){
                list.remove(i);
            }
        }

//        int start = list.getFirst();
//        int end = list.getLast();
//        int mid = start + (end - start) / 2;
//        while(list.get(mid) != num && start <= end){
//            if (list.get(mid) == num){
//                list.remove(mid);
//            }
//            else if(list.get(mid) < num){
//                start = mid + 1;
//            }
//            else {
//                end = mid - 1;
//            }
//            mid = start + (end - start) / 2;
//        }

//        if(list.remove(Integer.valueOf(num))){
//            System.out.println("The number " + num + " was removed from the list");
//            System.out.println("The list contains: " + list);
//        }
//        else {
//            System.out.println("The number " + num + " was not found in the list");
//        }
    }
}
