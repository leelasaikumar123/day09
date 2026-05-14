import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBookSystem{
 public static void main(String[] args) {
 Scanner sc=new Scanner(System.in);
   System.out.println("Welcome to address book program in address book system proogram in addresss book system in main branch");
   ContactRecord record=new ContactRecord();
   record.addPersons();  
  System.out.println("Contact details before Editing");
   record.diaplayContactPersons();
  System.out.println("Input the first name of the person you want to edit");
String name=sc.nextLine();
record.editAPerson(name);
System.out.println("Contacts After Editing");
record.diaplayContactPersons();
System.out.println("Input the first name of the person you want to delete");
String deleteContactNmae=sc.nextLine();
record.deleteAContact(deleteContactNmae);
System.out.println("After Deletion Our Contacts are");
record.diaplayContactPersons();

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
    public String getFirstName() {
    return firstName;
}

public void setFirstName(String firstName) {
    this.firstName = firstName;
}

public String getLastName() {
    return lastName;
}

public void setLastName(String lastName) {
    this.lastName = lastName;
}

public String getAddress() {
    return address;
}

public void setAddress(String address) {
    this.address = address;
}

public String getCity() {
    return city;
}

public void setCity(String city) {
    this.city = city;
}

public String getState() {
    return state;
}

public void setState(String state) {
    this.state = state;
}

public int getZip() {
    return zip;
}

public void setZip(int zip) {
    this.zip = zip;
}

public long getPhoneNumber() {
    return phoneNumber;
}

public void setPhoneNumber(long phoneNumber) {
    this.phoneNumber = phoneNumber;
}

public String getEmail() {
    return email;
}

public void setEmail(String email) {
    this.email = email;
}
   
    public String toString(){
        return firstName+" "+lastName+" "+address+" "+city+" "+state+" "+zip+" "+phoneNumber+" "+email;
    }
}


class ContactRecord{
 public static List<Contacts> list=new ArrayList<>();
 public static Scanner sc=new Scanner(System.in);
 public void addPersons(){
  boolean flag=true;
while(flag){

list.add(addPersonToContacts());
  System.out.println("If You Still Want To ADD persons type true of if you are finished enetering persons type false");
  flag=sc.nextBoolean();
  sc.nextLine();
}

 }
 public Contacts addPersonToContacts(){
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
    String email=sc.nextLine();
  Contacts contacts=new Contacts(firstName, lastName, address, city, State, zip, phoneNumber, email);
  return contacts;
 }
 public void editAPerson(String name){
    for(Contacts contact:list){
    String oldName=contact.getFirstName();
    if(oldName.equalsIgnoreCase(name)){
     String firstName=contact.getFirstName();
     String lastName=contact.getLastName();
     String aadress=contact.getAddress();
     String city=contact.getCity();
     String state=contact.getState();
     int zip=contact.getZip();
     long phoneNumber=contact.getPhoneNumber();
     String email=contact.getEmail();
    if(deceideChioce("firstName")){
      firstName=sc.nextLine();
    }
      if(deceideChioce("lastName")){
      lastName=sc.nextLine();
    }
    if(deceideChioce("Address")){
      aadress=sc.nextLine();
    }
    if(deceideChioce("city")){
      city=sc.nextLine();
    }
    if(deceideChioce("state")){
      state=sc.nextLine();
    }
    if(deceideChioce("Zip")){
      zip=sc.nextInt();
      sc.nextLine();
    }
    if(deceideChioce("Mobile Number")){
      phoneNumber=sc.nextLong();
      sc.nextLine();
    }
    if(deceideChioce("Email")){
      email=sc.nextLine();
  
    }
    contact.setFirstName(firstName);
    contact.setLastName(lastName);
    contact.setAddress(aadress);
    contact.setCity(city);
    contact.setState(state);
    contact.setZip(zip);
    contact.setPhoneNumber(phoneNumber);
    contact.setEmail(email);
    break;
    }
    
  }
 }
 public boolean deceideChioce(String field){
  System.out.println("If you Want To Edit "+field+" Field type true or else false");
 boolean value=sc.nextBoolean();
 sc.nextLine();
  return value;
 }
 public void diaplayContactPersons(){
  for(Contacts contact:list){
    System.out.println(contact);
  }
 }
 public void deleteAContact(String name){
for(int i=0;i<list.size();i++){
  Contacts contact=list.get(i);
   String oldName=contact.getFirstName();
   if(oldName.equalsIgnoreCase(name)){
    list.remove(i);
    break;
   }
}
}
}