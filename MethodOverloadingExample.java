package JavaTutorials;

public class MethodOverloadingExample {
    public int add(int a, int b){
        return a+b;
    }
    public int add(int a, int b, int c){
        return a+b+c;
    }
    public static void main(String[] args) {
        MethodOverloadingExample p = new MethodOverloadingExample();
        System.out.println(p.add(1,3));
        System.out.println(p.add(2,3,4));
    }
 
}
