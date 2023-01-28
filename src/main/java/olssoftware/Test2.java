package olssoftware;

public class Test2 {
    private static String name;
    public static void main(String[] args) {
        Test2 t = new Test2();
        if(name.equals("null")){
            t.printName();
        } else {
            System.out.println("No es null");
        }
    }
    public void printName(){
        System.out.println(this.name);
    }
}
