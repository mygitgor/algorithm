package sortalgorithm;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Sort {

    public static void main(String[] args) {
        // List<Integer> avilabeDivider = findSimpleNumber(100);
        // for(Integer integer : avilabeDivider){
        //     System.out.println(integer);
        // }

        int[] array = {4, 10, 3, 5, 1};
        sort(array);
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length; i++){
            System.out.print(i);
        }

    }
    

    public static void quickSort(int[] array, int startposition, int endposition) {
        int leftposition = startposition;
        int rightposition = endposition;
        int pivot = array[(startposition + endposition) / 2];
        
        do {
            while (array[leftposition] < pivot) {
                leftposition++;
            }
            while (array[rightposition] > pivot) {
                rightposition--;
            }
            
            if (leftposition <= rightposition) {
                if (leftposition < rightposition) {
                    int temp = array[leftposition];
                    array[leftposition] = array[rightposition];
                    array[rightposition] = temp;
                }
                leftposition++;
                rightposition--;
            }
            
        } while (leftposition <= rightposition);
    
        if (leftposition < endposition) {
            quickSort(array, leftposition, endposition);
        }
    
        if (startposition < rightposition) {
            quickSort(array, startposition, rightposition);
        }
    }

    public static void sort(int[] array){
        //postroenie kuci (peregrupiruem masiv)
        for (int i = array.length / 2 - 1; i >= 0; i--) 
            heapify(array, array.length, i);

        //odin za drugim izvlekaem iz kuchi
        for (int i = array.length - 1; i > 0; i--) {
            //peremeshaem tekushi koren kionec
           int temp = array[0];
            array[0] = array[i];
            array[i] = temp; 

            //vizivaem heapify na umenshenom kuche
            heapify(array, i, 0);
        }
    }

    public static void heapify(int[] array, int heapSize, int rootIndex) {
        int largest = rootIndex; // Initialize the largest element as the root
        int leftChild = 2 * rootIndex + 1; // Left child
        int rightChild = 2 * rootIndex + 2; // Right child
    
        // If the left child is larger than the root
        if (leftChild < heapSize && array[leftChild] > array[largest]) {
            largest = leftChild;
        }
    
        // If the right child is larger than the largest so far
        if (rightChild < heapSize && array[rightChild] > array[largest]) {
            largest = rightChild;
        }
    
        // If the largest element is not the root
        if (largest != rootIndex) {
            int temp = array[rootIndex];
            array[rootIndex] = array[largest];
            array[largest] = temp;
    
            // Recursively heapify the affected sub-tree
            heapify(array, heapSize, largest);
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

    public static int find(int[] array, int valeue){
        for (int i = 0; i < array.length; i++) {
            if (array[i] == valeue){
                return i;
            }            
            
        }return -1;
    }

    public static int search(int value, int[] array, int min, int max){
        int midpoint;
        if (max < min){
            return -1;
        }else{
            midpoint = (max - min)/2 + min;
        }
        if (array[midpoint] < value){
            return search(value, array, midpoint + 1, max);
        }else{
            if (array[midpoint] < value){
                return search(value, array, min, midpoint - 1);
            }else{
                return midpoint;
            }
            
        }
    }



}
