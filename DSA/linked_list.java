package DSA;
import java.util.*;
public class linked_list {
    public static LinkedList<Integer> list = new LinkedList<>();
    public static Scanner scan = new Scanner(System.in);
    public static Random rand = new Random();

    public static void main(String[] args) {
        operationsMenu();
    }

    public static void operationsMenu() {
        System.out.println("Welcome to the linked list operations menu!");
        System.out.println("What operation would you like to perform?");
        System.out.println("1. Add to list");
        System.out.println("2. Remove from list");
        System.out.println("3. Search list");
        System.out.println("4. Display list info");
        System.out.println("5. Exit");
        int operationChoice = scan.nextInt();
        switch (operationChoice) {
            case 1:
                addToList();
                break;
            case 2:
                removeFromList();
                break;
            case 3:
                searchList();
                break;
            case 4:
                displayListInfo();
                break;
            case 5:
                System.out.println("Goodbye!");
                System.exit(0);
            default:
                System.out.println("Invalid input. Please try again.");
                operationsMenu();
                break;
        }
    }

    public static void addToList() {
        boolean addMore = true;

        while (addMore) {
            try {
                System.out.println("How many numbers do you want to add to the list?");
                int numOfItems = scan.nextInt();

                if (numOfItems <= 0) {
                    System.out.println("Invalid input. Please enter a positive number.");
                    continue;
                }
                for (int i = 0; i < numOfItems; i++) {
                    list.add(rand.nextInt(1000) + 1);
                }

                // Ask if user wants to add more numbers
                while (true) {
                    System.out.println("Do you want to add anymore numbers? (y/n)");
                    String answer = scan.next().toLowerCase();

                    if (answer.equals("n")) {
                        addMore = false;
                        break;
                    } else if (answer.equals("y")) {
                        break; // Just break the inner loop to repeat main loop
                    } else {
                        System.out.println("Invalid input. Please enter 'y' or 'n'.");
                    }
                }

            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number!");
                scan.next(); // Clear the invalid input
            }
        }

        mergeSort(list);
        askToContinue();
    }

    public static void mergeSort(LinkedList<Integer> list){
        if(list.size() > 1){
            int mid = list.size() / 2;
            LinkedList<Integer> left = new LinkedList<>();
            LinkedList<Integer> right = new LinkedList<>();

            for(int i = 0; i < mid; i++){
                left.add(list.get(i));
            }
            for(int i = mid; i < list.size(); i++){
                right.add(list.get(i));
            }
            mergeSort(left);
            mergeSort(right);
            list.clear();
            merge(left, right, list);
        }
    }

    public static void merge(LinkedList<Integer> left, LinkedList<Integer> right, LinkedList<Integer> result){
        int i = 0, j = 0;
        while(i < left.size() && j < right.size()){
            if(left.get(i) <= right.get(j)){
                result.add(left.get(i++));
            }
            else {
                result.add(right.get(j++));
            }
        }
        while(i < left.size()) result.add(left.get(i++));
        while(j < right.size()) result.add(right.get(j++));
    }

    public static boolean verifyList(LinkedList<Integer> list){
        LinkedList<Integer> verifyList = new LinkedList<>();
        if(list.size() <= 1){
                return true;
            }
            for(int i = 0; i < list.size() - 1; i++){
                verifyList.add(list.get(i));
            }
            return list.get(0) < list.get(1) && verifyList(verifyList);
    }

    public static void displayListInfo() {
        System.out.println("The list contains: " + list);
        System.out.println("The head of the list is: " + list.getFirst());
        System.out.println("The tail of the list is: " + list.getLast());
        System.out.println("List size: " + list.size());
        if (verifyList(list)){
            System.out.println("The list is sorted");
        }
        else {
            System.out.println("The list is not sorted");
        }
        askToContinue();
    }

    public static void searchList() {
        int start = 0;
        int end = list.size();
        boolean found = false;
        System.out.println("Which number would you like to search for?");
        int num = scan.nextInt();

        try {
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (list.get(mid) == num) {
                    System.out.println("The number " + num + " was found at index " + list.indexOf(num));
                    found = true;
                    break;
                } else if (list.get(mid) < num) {
                    start = mid + 1;
                }
                else {
                    end = mid - 1;
                }
            }
            if (!found) {
                System.out.println("The number " + num + " was not found in the list");
            }
        } catch (IndexOutOfBoundsException e){
            System.out.println("The number " + num + " was not found in the list");
        }
        askToContinue();
    }

    public static void removeFromList() {
//        for(int i = 0; i < list.size(); i++){
//            if(list.get(i) == num){
//                list.remove(i);
//            }
//        }

//        int start = 0;
//        int end = list.size();
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
        System.out.println("Which number would you like to remove?");
        int num = scan.nextInt();
        if(list.remove(Integer.valueOf(num))){
            System.out.println("The number " + num + " was removed from the list");
            System.out.println("The list contains: " + list);
        }
        else {
            System.out.println("The number " + num + " was not found in the list");
        }
        askToContinue();
    }

    public static void askToContinue() {
        while(true){
            try {
                System.out.println("What would you like to do?");
                System.out.println("1. Return to menu");
                System.out.println("2. Exit");

                int choice = scan.nextInt();

                    switch (choice) {
                        case 1:
                            operationsMenu();
                            return;
                        case 2:
                            System.out.println("Goodbye!");
                            System.exit(0);
                        default:
                            System.out.println("Invalid input. Please try again.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please try again.");
                    scan.next();
                }
            }
        }

}
