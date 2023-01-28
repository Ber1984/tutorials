package oracleCertification;

public class Ex6 {
    public static void main(String[] args) {
        int x = 0, y=10;
        try {
            y /= x;
        }
        //System.out.println("/ by 0");
        catch (Exception e){
            System.out.println("error");
        }
 } }
