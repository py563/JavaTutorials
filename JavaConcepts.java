package JavaTutorials;

import java.util.ArrayList;

// Denonstrates OOPS concepts
// person class - super class 
class Person {
    //common variables
    private String name;
    private String address;
    
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
    public void schedule(String[] days){
        System.out.println("Person class schedule doesn't call this method when using subclass");
    }

}
// student class
class Student extends Person{
    //student class variables
    private int id;
    private String college;
    //constructors
    public Student() {
        super();
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
    @Override
    public void schedule(String[] days){
        System.out.print(getName() +" has Classes on");
        for (String day : days)
            System.out.print(", "+day);
        System.out.println(".");
 }
    
}
// employee class
class Employee extends Person{
    // employee specific variables
    private int employeeID;
    private String company;
    // constructors
    public Employee(){
        super();
    }
    /**
     * @param company the company to set
     */
    public void setCompany(String company) {
        this.company = company;
    }
    /**
     * @param employeeID the employeeID to set
     */
    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }
    /**
     * @return the employeeID
     */
    public int getEmployeeID() {
        return employeeID;
    }
    /**
     * @return the company
     */
    public String getCompany() {
        return company;
    }
    // schedule method
    @Override
    public void schedule(String[] days){
        System.out.print(getName() +" goes to Work on");
        for (String day : days)
            System.out.print(", "+ day);
        System.out.println(".");
 }
}
// main class
public class JavaConcepts {
 public static void main(String[] args) {
    String[] days = {"Monday", "Friday"};  
    //Student object
     Student tom = new Student();
     tom.setName("tom");
     tom.setAddress("66 aaa");
     tom.setId(11);
     tom.setCollege("sheridan");
     tom.schedule(days);
     //Employee Object
     Employee jim = new Employee();
     jim.setName("Jim");
     jim.setAddress("66 aaa");
     jim.setEmployeeID(11);
     jim.setCompany("sheridan");
     jim.schedule(days);

     //Student object through Person class
     Person tim = new Person();
     tim.setName("tim");
     tim.setAddress("66 aaa");
     // will throw an error 
     //tim.setId(11);
     tim.schedule(days);

     ArrayList<Person> al = new ArrayList<Person>();
     al.add(tom);
     al.add(jim);
     al.add(tim);
     for ( Person a : al){
        System.out.println(a.getClass());
     }
     

 }
}
