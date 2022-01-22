import java.util.Collections;

public class Problem3 {
    public static void sortArray(int [] arrayInt, int size){
        int temp;
        for (int i = 0; i < size - 1; ++i){
            for (int j = 0; j < size - i - 1; ++j){
                if (arrayInt[j] < arrayInt[j+1]){
                    temp = arrayInt[j];
                    arrayInt[j] = arrayInt[j+1];
                    arrayInt[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args){
        int[] arrayInt = {2,4,5,6,2,8,7,0,-3};
        System.out.println("Before sorting:");
        for (int i = 0; i < arrayInt.length; ++i){
            System.out.print(arrayInt[i] + " ");
        }
        System.out.println();
        sortArray(arrayInt, arrayInt.length);
        System.out.println("After sorting:");
        for (int i = 0; i < arrayInt.length; ++i){
            System.out.print(arrayInt[i] + " ");
        }
    }
}
