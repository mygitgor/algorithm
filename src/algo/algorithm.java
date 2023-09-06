package algo;

import java.util.Arrays;

public class algorithm {
    public static void main(String[] args) {
        // int[] array = {2 ,4,  6,4, 6,  2, 7};
        // int oddOccurrence = findOddOccurrence(array);
        // System.out.println(oddOccurrence);

        String[] inputArr = {"Hello World", "Java Programming", "Spaces Removed"};
        String[] resultArr = removeSpace(inputArr);
        System.out.println("Result Array: " + Arrays.toString(resultArr));
    }



    public static int findOddOccurrence(int[] array) {
        int result = 0;
        for (int num : array) {
            // Применяем операцию XOR к каждому элементу массива
            result ^= num;
        }
        return result;
    }


    public static String[] removeSpace(String[] inputArr){
        if (inputArr == null){
           return null; 
        } 

        String[] result = new String[inputArr.length];
        for (int i = 0; i < inputArr.length; i++) {
            result[i] = inputArr[i].replaceAll("\\s","");
        }
        return result;
    }

    
    
}
