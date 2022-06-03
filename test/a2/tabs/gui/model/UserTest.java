package a2.tabs.gui.model;

import a2.tabs.gui.database.DBConnection;
import java.time.LocalDate;
import java.time.Month;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserTest {
    
    private User instance;
    private DBConnection db;
    
    public UserTest() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        DBConnection.testing = true;
        this.instance = new User("someUsername", "somePassword", "someemail@gmail.com", "Bab", "Nato", LocalDate.of(2002, Month.JANUARY, 23), false);
        this.db = new DBConnection();
        db.dropAllTables();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getUsername method, of class User.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        String expResult = "someUsername";
        String result = instance.getUsername();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPassword method, of class User.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        String expResult = User.hash("somePassword");
        String result = instance.getPassword();
        assertEquals(expResult, result);
    }

    /**
     * Test of checkPassword method, of class User.
     */
    @Test
    public void testCheckPassword() {
        System.out.println("checkPassword");
        String password = "theWrongPassword";
        boolean expResult = false;
        boolean result = instance.checkPassword(password);
        assertEquals(expResult, result);
    }

    /**
     * Test of getEmail method, of class User.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        String expResult = "someemail@gmail.com";
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEmail method, of class User.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "someNewEmail@gmail.com";
        instance.setEmail(email);
        assertEquals(instance.getEmail(), email);
    }

    /**
     * Test of hash method, of class User.
     */
    @Test
    public void testHash() {
        System.out.println("hash");
        String password = "somePassword";
        String expResult = "be3bb966fe47ca01c1609a25873e0192";
        String result = User.hash(password);
        assertEquals(expResult, result);
    }
}
