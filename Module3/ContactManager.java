import java.util.ArrayList;
import java.util.HashMap; 
 
public class ContactManager { 
 
    public static void main(String[] args) { 
 
        HashMap<String, Contact> contacts = new HashMap<>(); 
 
        // Step 4: add contacts here 

contacts.put("Chris Silvestro",
        new Contact("Chris Silvestro", "1.978.886.9097"));

contacts.put("Lindsey Silvestro",
    new Contact("Lindsey Silvestro", "1.801.403.1419"));

contacts.put("Tyler Silvestro",
    new Contact("Tyler Silvestro", "1.801.661.9883"));

contacts.put("Nia Silvestro",
    new Contact("Nia Silvestro", "1.385.201.6961"));

contacts.put("Mystic Media",
    new Contact("Mystic Media", "1.801.994.6885"));


        // Step 5: look up a contact 

Contact foundContact = contacts.get("Chris Silvestro");
if (foundContact != null) {
    System.out.println("Found contact: " + foundContact);
} else {
    System.out.println("Contact not found.");
}

        // Step 6: print sorted list 
ArrayList<Contact> sorted = new ArrayList<>(contacts.values());  
    sorted.sort((a, b) -> a.getName().compareTo(b.getName()));  
System.out.println("=== All Contacts ===");
    for (Contact contact : sorted) {
    System.out.println(contact);


    } 
}
}