import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach; 
 
public class ContactTest { 
private Contact contact;
 
  @BeforeEach
  void setUp() {
    contact = new Contact("Chris Silvestro", "1.978.886.9097");
  } 
    @Test 
  void constructor_setsNameCorrectly() { 
    Contact c = new Contact("Chris Silvestro", "1.978.886.9097"); 
    assertEquals("Chris Silvestro", c.getName()); 
  } 
 
  @Test
  void constructor_setsPhoneCorrectly() { 
    Contact c = new Contact("Chris Silvestro", "1.978.886.9097"); 
    assertEquals("1.978.886.9097", c.getPhone()); 
  } 
 
  @Test
  void getName_returnsExactString_notTransformed() { 
    Contact c = new Contact("Grace Hopper", "555-0000"); 
    assertEquals("Grace Hopper", c.getName());
  } 
 
  @Test
  void toString_containsName() { 
    Contact c = new Contact("Alan Turing", "555-0001"); 
    assertTrue(c.toString().contains("Alan Turing"));
  } 
 
  @Test
  void toString_containsPhone() {
    Contact c = new Contact("Alan Turing", "555-0001");
    assertTrue(c.toString().contains("555-0001"));
  }
  @Test
void contactsWithSameName_areIndependentObjects() {
    Contact first = new Contact("Chris Silvestro", "1.978.886.9097");
    Contact second = new Contact("Chris Silvestro", "1.801.555.0101");

    assertNotSame(first, second);
    assertEquals("Chris Silvestro", first.getName());
    assertEquals("Chris Silvestro", second.getName());
    assertEquals("1.978.886.9097", first.getPhone());
    assertEquals("1.801.555.0101", second.getPhone());
}
} 