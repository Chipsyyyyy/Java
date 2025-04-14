package DSA;
public class LinearSearchExample {
    public static int linearSearch(int [] data, int key){
        for(int index = 0; index < data.length; index++){
            if (data[index] == key){
                return index;
            }
        }

        return -1;
    }

    public static void main(String[] args){
        int [] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int result = linearSearch(numbers, 12);
        System.out.println(result);
    }
}
