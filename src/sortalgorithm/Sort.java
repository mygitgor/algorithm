package sortalgorithm;

import java.util.List;
import java.util.ArrayList;

public class Sort {

    public static void main(String[] args) {
        // List<Integer> avilabeDivider = findSimpleNumber(100);
        // for(Integer integer : avilabeDivider){
        //     System.out.println(integer);
        // }

        int[] array = new int[]{
            1,5,7,9,4,5,0,6,2,0
        };

        insertSort(array);
        for (int i = 0; i < array.length; i++){
            System.out.print(i);
        }

    }
    
    public static List<Integer> findAvilableDivider(int number){
        List<Integer>result = new ArrayList<>();
        for (int i = 1; i < number; i++) {
           if (number % i == 0){
            result.add(i);
           }
        }
        return result;
    }


    public static List<Integer> findSimpleNumber(int max){
        List<Integer>result = new ArrayList<>();
        for (int i = 1; i <= max; i++) {
            boolean simple = true;
            for(int j = 2; j < i; j++){
                if(i % j == 0){
                    simple = false;
                }
            }
            if (simple){
                result.add(i);
            }
        }return result;
    }


    public static void boblSort(int[] array){
        boolean finish;
        do{
            finish = true;
            for (int i = 0; i < array.length-1; i++) {
            if (array[i] > array[i+1]){
                int temp = array[i];
                array[i] = array[i+1];
                array[i+1] = temp;
                finish = false;
            }
        }
        }while(!finish);
        
    }


    public static void dyrectSort(int[] array){

        for (int i = 0; i < array.length-1; i++) { //proxhodit & sravnivaet
            int minposition = i;  //zopominaet minimalnoe pozitia
            for (int j = i + 1; j < array.length; j++){ //sleduyshi element
                if (array[j] < array[minposition]){ //sravnivanie sleduyshi element & minimalnoe pozitia
                    minposition = j; //zomena elementa
                }
            }
            if ( i != minposition ){
                int temp = array[i];
                array[i] = array[minposition];
                array[minposition] = temp;
            }
        }
    }


    public static void insertSort(int[] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                if(array[j] < array[i]){
                    int temp = array[i];
                    array[j] = temp;
                    array[i] = array[j];
                }
            }          
        }
    }

    
}
