package tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        final ReadBlackTree readBlackTree = new ReadBlackTree();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            while (true){
                try {
                    int value = Integer.parseInt(reader.readLine());
                    readBlackTree.add(value);
                    System.out.println("finished");
                }catch (Exception ignored){
                   
                }
            }
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
