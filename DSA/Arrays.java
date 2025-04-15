package DSA;

public class Arrays {
    public static void main(String[] args) {
        int[] newArray = {1, 2, 3}; 
        int result = newArray[0];
        System.out.println(result);
        
        for(int i = 0; i < newArray.length; i++){
            if(newArray.equals(i)){
                System.out.println(true);
            }
        }
        
        
    }
}
