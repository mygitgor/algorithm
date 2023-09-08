package algo;

import java.util.Arrays;

public class algorithm {
    public static void main(String[] args) {
        int[] nums = {-4, -2, 0, 1, 3};
        int[] sortedSquaresArray = sortedSquare(nums);
        System.out.println(Arrays.toString(sortedSquaresArray));

        // String[] inputArr = {"Hello World", "Java Programming", "Spaces Removed"};
        // String[] resultArr = removeSpace(inputArr);
        // System.out.println("Result Array: " + Arrays.toString(resultArr));
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

    public static int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int surentcount =0;
        for (int num : nums){
            if (num == 1){
                surentcount++;
                count = Math.max(count, surentcount);
            }else{
                surentcount =0;
            }
        }
        return count;
    }

    public static int[] sortedSquare(int[] values){
        int[] result = new int[values.length];

        for (int i = 0; i < values.length; i++) {
            result[i] = values[i] * values[i];
        }
        Arrays.sort(result);
        return result;
    }

    
}
