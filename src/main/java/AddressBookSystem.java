import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import com.google.gson.Gson;
import com.opencsv.*;
import java.io.*;

public class AddressBookSystem {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println(
        "Welcome to address book program in address book system proogram in addresss book system in main branch");
    ContactRecord record = new ContactRecord();
    
    record.addPersons();
  record.writeDataToJson();
    System.out.println("reading data from json file");
    record.readDataFromJson();
    System.out.println("Contact details before Editing");
    // record.writeContactsToCSV();
    // System.out.println("Reading CSV");
    // record.readContactsFromCSV();
    // record.diaplayContactPersons();
    System.out.println("Input the first name of the person you want to edit");
    String name = sc.nextLine();
    record.editAPerson(name);
    System.out.println("Contacts After Editing");
    record.diaplayContactPersons();
    System.out.println("Input the first name of the person you want to delete");
    String deleteContactNmae = sc.nextLine();
    record.deleteAContact(deleteContactNmae);
    System.out.println("After Deletion Our Contacts are");
    record.diaplayContactPersons();
    System.out.println("Enter city to search");
    String cityName = sc.nextLine();

    record.searchPersonByCity(cityName);

    System.out.println("Enter state to search");
    String stateName = sc.nextLine();

    record.searchPersonByState(stateName);
    System.out.println("Enter city");
    String city = sc.nextLine();

    record.viewPersonsByCity(city);

    System.out.println("Enter state");
    String state = sc.nextLine();

    record.viewPersonsByState(state);
    System.out.println("Count By City");
    record.countByCity();

    System.out.println("Count By State");
    record.countByState();
  }
}

class Contacts {
  public static Scanner sc = new Scanner(System.in);
  private String firstName;
  private String lastName;
  private String address;
  private String city;
  private String state;
  private int zip;
  private long phoneNumber;
  private String email;

  public Contacts(String firstName, String lastName, String address, String city, String state, int zip,
      long phoneNumber, String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.city = city;
    this.state = state;
    this.zip = zip;
    this.phoneNumber = phoneNumber;
    this.email = email;
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

  public String toString() {
    return firstName + "," + lastName + "," + address + "," + city + "," + state + "," + zip + "," + phoneNumber + ","
        + email;
  }
}

class ContactRecord {
  public static List<Contacts> list = new ArrayList<>();
  public static LinkedHashMap<String, Contacts> map = new LinkedHashMap<>();
  public static LinkedHashMap<String, List<Contacts>> cityMap = new LinkedHashMap<>();
  public static LinkedHashMap<String, List<Contacts>> stateMap = new LinkedHashMap<>();
  public static Scanner sc = new Scanner(System.in);

  public void addPersons() {
    boolean flag = true;
    while (flag) {
      System.out.println("enter first name so that we can check weather its is unquie or all ready taken");
      String firstName = sc.nextLine();
      if (map.containsKey(firstName)) {
        System.out.println("This Name Already Exists so Please Enter a New Name");
        continue;
      }
      // list.add(addPersonToContacts());
      Contacts contact = addPersonToContacts(firstName);
      map.put(firstName, contact);
      addPersonToCityDictionary(contact);
      addPersonToStateDictionary(contact);
      System.out
          .println("If You Still Want To ADD persons type true of if you are finished enetering persons type false");
      flag = sc.nextBoolean();
      sc.nextLine();
    }

  }

  public Contacts addPersonToContacts(String firstName) {
    System.out.println("Enter last Name");
    String lastName = sc.nextLine();
    System.out.println("Enter address");
    String address = sc.nextLine();
    System.out.println("Enter city");
    String city = sc.nextLine();
    System.out.println("Enter state");
    String State = sc.nextLine();
    System.out.println("Enter zip");
    int zip = sc.nextInt();
    System.out.println("Enter phonenumber");
    long phoneNumber = sc.nextLong();
    sc.nextLine();
    System.out.println("Enter email");
    String email = sc.nextLine();
    Contacts contacts = new Contacts(firstName, lastName, address, city, State, zip, phoneNumber, email);
    return contacts;
  }

  public void editAPerson(String name) {
    Set<String> firstNames = map.keySet();
    for (String s : firstNames) {
      if (s.equalsIgnoreCase(name)) {
        Contacts contact = map.get(s);
        String firstName = contact.getFirstName();
        String lastName = contact.getLastName();
        String aadress = contact.getAddress();
        String city = contact.getCity();
        String state = contact.getState();
        int zip = contact.getZip();
        long phoneNumber = contact.getPhoneNumber();
        String email = contact.getEmail();
        if (deceideChioce("firstName")) {
          map.remove(firstName);
          firstName = sc.nextLine();
          map.put(firstName, contact);
        }
        if (deceideChioce("lastName")) {
          lastName = sc.nextLine();
        }
        if (deceideChioce("Address")) {
          aadress = sc.nextLine();
        }
        if (deceideChioce("city")) {
          city = sc.nextLine();
        }
        if (deceideChioce("state")) {
          state = sc.nextLine();
        }
        if (deceideChioce("Zip")) {
          zip = sc.nextInt();
          sc.nextLine();
        }
        if (deceideChioce("Mobile Number")) {
          phoneNumber = sc.nextLong();
          sc.nextLine();
        }
        if (deceideChioce("Email")) {
          email = sc.nextLine();

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

  public boolean deceideChioce(String field) {
    System.out.println("If you Want To Edit " + field + " Field type true or else false");
    boolean value = sc.nextBoolean();
    sc.nextLine();
    return value;
  }

  public void diaplayContactPersons() {
    Set<String> firstNames = map.keySet();
    for (String keys : firstNames) {
      System.out.println(map.get(keys));
    }
  }

  public void deleteAContact(String name) {
    if (map.containsKey(name)) {
      map.remove(name, map.get(name));
    } else {
      System.out.println("The Contact is not available");
    }
  }

  public void searchPersonByCity(String cityName) {

    boolean found = false;

    Set<String> firstNames = map.keySet();

    for (String key : firstNames) {

      Contacts contact = map.get(key);

      if (contact.getCity()
          .equalsIgnoreCase(cityName)) {

        System.out.println(contact);
        found = true;
      }
    }

    if (!found) {
      System.out.println(
          "No person found in this city");
    }
  }

  public void searchPersonByState(String stateName) {

    boolean found = false;

    Set<String> firstNames = map.keySet();

    for (String key : firstNames) {

      Contacts contact = map.get(key);

      if (contact.getState()
          .equalsIgnoreCase(stateName)) {

        System.out.println(contact);
        found = true;
      }
    }

    if (!found) {
      System.out.println(
          "No person found in this state");
    }
  }

  public void addPersonToCityDictionary(
      Contacts contact) {

    String city = contact.getCity();

    if (cityMap.containsKey(city)) {

      cityMap.get(city).add(contact);

    } else {

      List<Contacts> list = new ArrayList<>();

      list.add(contact);

      cityMap.put(city, list);
    }
  }

  public void addPersonToStateDictionary(
      Contacts contact) {

    String state = contact.getState();

    if (stateMap.containsKey(state)) {

      stateMap.get(state).add(contact);

    } else {

      List<Contacts> list = new ArrayList<>();

      list.add(contact);

      stateMap.put(state, list);
    }
  }

  public void viewPersonsByCity(String city) {

    if (cityMap.containsKey(city)) {

      cityMap.get(city)
          .stream()
          .forEach(System.out::println);

    } else {

      System.out.println(
          "No persons found in city");
    }
  }

  public void viewPersonsByState(String state) {
    if (stateMap.containsKey(state)) {

      stateMap.get(state)
          .stream()
          .forEach(System.out::println);

    } else {

      System.out.println(
          "No persons found in state");
    }
  }

  public void countByCity() {
    cityMap.keySet().stream().forEach(city -> System.out.println(city + " : " + cityMap.get(city).size()));
  }

  public void countByState() {

    stateMap.keySet().stream().forEach(state -> System.out.println(state + " : " + stateMap.get(state).size()));
  }

  public void writeContactsToFile() {
    Path path = Paths.get("AddressBook.txt");
    List<String> contactData = new ArrayList<>();
    for (Contacts contact : map.values()) {
      contactData.add(contact.toString());
    }
    try {
      Files.write(path,
          contactData,
          StandardOpenOption.CREATE,
          StandardOpenOption.APPEND);
      System.out.println(
          "Contact Data Written To File Successfully");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void readContactsFromFile() {
    Path path = Paths.get("AddressBook.txt");
    try {
      Files.lines(path).forEach(System.out::println);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void readContactsFromCSV() {
    try (CSVReader reader = new CSVReader(new FileReader("contacts.csv"))) {
      String[] line;
      reader.readNext();
      while ((line = reader.readNext()) != null) {
        System.out.println("First Name: " + line[0] + ", Last Name: " + line[1] + ", City: " + line[3]);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void writeContactsToCSV() {
    try (CSVWriter writer = new CSVWriter(new FileWriter("contacts.csv"))) {
      writer.writeNext(
          new String[] { "firstName", "lastName", "address", "city", "state", "zip", "phoneNumber", "email" });
      for (Contacts contact : map.values()) {
        writer.writeNext(new String[] { contact.getFirstName(), contact.getLastName(), contact.getAddress(),
            contact.getCity(), contact.getState(), String.valueOf(contact.getZip()),
            String.valueOf(contact.getPhoneNumber()), contact.getEmail()
        });
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void readDataFromJson() {
    try {
      Gson gson = new Gson();
      FileReader reader = new FileReader("addressbook_records.json");
      AddressBook book = gson.fromJson(reader, AddressBook.class);
      for (Contacts contact : book.getContacts()) {
        System.out.println(contact);
        map.put(contact.getFirstName(), contact);
      }
    } catch (Exception e) {

    }
  }
  public void writeDataToJson() {
    try {
        Gson gson = new Gson();
        AddressBook book = new AddressBook();
        book.setContacts(new ArrayList<>(map.values()));
        FileWriter writer = new FileWriter("addressbook_records.json");
        gson.toJson(book, writer);
        writer.close();
        System.out.println("JSON file written successfully");
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}
