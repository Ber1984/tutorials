package olssoftware;

public class A2 {
    String convierteString(Long i){
        return new String(String.valueOf(i));
    }
    public static void main(String[] args) {
        A2 aObj = new A2();
        System.out.println(aObj.convierteString(1L));
    }
}
