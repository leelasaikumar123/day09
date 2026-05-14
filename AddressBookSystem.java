public class AddressBookSystem{
 public static void main(String[] args) {
    System.out.println("Welcome to address book program in address book system proogram in addresss book system in main branch");
 }
}
class Contacts{
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
}