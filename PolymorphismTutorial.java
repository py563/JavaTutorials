package JavaTutorials;

public class PolymorphismTutorial {
    public int add(int a, int b){
        return a+b;
    }
    public int add(int a, int b, int c){
        return add(a,b)+c;
    }
    public static void main(String[] args) {
        PolymorphismTutorial p = new PolymorphismTutorial();
        System.out.println(p.add(1,3));
        System.out.println(p.add(2,3,4));
    }
 
}
