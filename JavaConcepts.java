package JavaTutorials;
// person class - super class 
class Person {
    private String name;
    private String address;
    public Person(String name, String address){
        this.name = name;
        this.address = address;
    }
    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

}
// student class
class Student extends Person{
    private int id;
    private String college;
    public Student(int id, String college, String name, String address) {
        super(name, address);
        this.id = id;
        this.college = college;
    }
    /**
     * @param college the college to set
     */
    public void setCollege(String college) {
        this.college = college;
    }
    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * @return the college
     */
    public String getCollege() {
        return college;
    }
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
// schedule method
 public void schedule(String[] days){
     System.out.println(getName() +" has Classes on");
     for (String day : days)
        System.out.print(day+", ");
 }
    
}
// main class
public class JavaConcepts {
 public static void main(String[] args) {
     Person tom = new Person("tom", "55 Gage Ave");
     tom.setName("thomas");
     System.out.println(tom.getName());
     Student tim = new Student(11, "sheridan", "tim", "66 aaa");
     String[] days = {"Monday", "Friday"};
     tim.schedule(days);
     tim.setAddress("65 aaa");
     tim.setId(12);
 }
}
