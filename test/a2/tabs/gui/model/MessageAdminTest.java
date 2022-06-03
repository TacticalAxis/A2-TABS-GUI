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

public class MessageAdminTest {
    
    private MessageAdmin instance;
    private DBConnection db;
    private User user;
    
    public MessageAdminTest() {
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
        this.user = new User("someUsername", "somePassword", "someemail@gmail.com", "Bab", "Nato", LocalDate.of(2002, Month.JANUARY, 23), false);
        this.db = new DBConnection();
        db.dropAllTables();
        this.instance = new MessageAdmin(user, "Some Message", System.currentTimeMillis());
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getUser method, of class MessageUser.
     */
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        User expResult = user;
        User result = instance.getUser();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMessage method, of class MessageUser.
     */
    @Test
    public void testGetMessage() {
        System.out.println("getMessage");
        String expResult = "Some Message";
        String result = instance.getMessage();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTimestamp method, of class MessageUser.
     */
    @Test
    public void testGetTimestamp() {
        System.out.println("getTimestamp");
        long expResult = System.currentTimeMillis();
        long result = instance.getTimestamp();
        assertEquals(expResult, result);
    }
}
