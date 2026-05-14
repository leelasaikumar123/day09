import java.util.Scanner;

public class AddressBookSystem{
 public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("Welcome to address book program in address book system proogram in addresss book system in main branch");
    System.out.println("Enter First Name");
    String firstName=sc.nextLine();
     System.out.println("Enter last Name");
    String lastName=sc.nextLine();
     System.out.println("Enter address");
    String address=sc.nextLine();
     System.out.println("Enter city");
    String city=sc.nextLine();
     System.out.println("Enter state");
    String State=sc.nextLine(); 
     System.out.println("Enter zip");
    int zip=sc.nextInt();
     System.out.println("Enter phonenumber");
   long phoneNumber=sc.nextLong();
   sc.nextLine();
    System.out.println("Enter email");
    String email=sc.next();
  Contacts contacts=new Contacts(firstName, lastName, address, city, State, zip, phoneNumber, email);
  System.out.println("One Contact is added");
  System.out.println(contacts);
contacts.editContact();
System.out.println(contacts);
 }
}
class Contacts{
    public static Scanner sc=new Scanner(System.in);
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private int zip;
    private long phoneNumber;
    private String email;
    public Contacts(String firstName,String lastName,String address,String city,String state,int zip,long phoneNumber,String email){
  this.firstName=firstName;
  this.lastName=lastName;
  this.address=address;
  this.city=city;
  this.state=state;
  this.zip=zip;
  this.phoneNumber=phoneNumber;
  this.email=email;
    }
    public void editContact(){
 System.out.println("Enter correct First Name");
    String firstName=sc.nextLine();
     System.out.println("Enter correct last Name");
    String lastName=sc.nextLine();
     System.out.println("Enter correct address");
    String address=sc.nextLine();
     System.out.println("Enter correct city");
    String city=sc.nextLine();
     System.out.println("Enter correct state");
    String state=sc.nextLine(); 
     System.out.println("Enter correct zip");
    int zip=sc.nextInt();
     System.out.println("Enter correct phonenumber");
   long phoneNumber=sc.nextLong();
   sc.nextLine();
    System.out.println("Enter correct email");
    String email=sc.next();
    this.firstName=firstName;
      this.lastName=lastName;
  this.address=address;
  this.city=city;
  this.state=state;
  this.zip=zip;
  this.phoneNumber=phoneNumber;
  this.email=email;
    }
    public String toString(){
        return firstName+" "+lastName+" "+address+" "+city+" "+state+" "+zip+" "+phoneNumber+" "+email;
    }
}