package a2.tabs.gui.model;

import a2.tabs.gui.database.DBConnection;
import a2.tabs.gui.model.util.ChargeType;
import java.time.LocalDate;
import java.time.Month;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ChargeTest {
    
    private Charge instance;
    private DBConnection db;
    private User user;
    
    
    public ChargeTest() {
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
        
        db.createTable(Charge.TABLE_NAME, Charge.model());
        db.createTable(User.TABLE_NAME, User.model());
        
        db.push(user);
        
        this.instance = new Charge(ChargeType.ELECTRICITY_BILL, user, LocalDate.now(), false);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getId method, of class Charge.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        int expResult = -1;
        int result = instance.getId();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetIDAfterAdding() {
        System.out.println("getID - after adding");
        int expResult = 1;
        instance.push(db);
        Charge charge = Charge.get(db).get(0);
        assertEquals(expResult, charge.getId());
    }

    /**
     * Test of getUser method, of class Charge.
     */
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        User expResult = user;
        User result = instance.getUser();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDate method, of class Charge.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        LocalDate expResult = LocalDate.now();
        LocalDate result = instance.getDate();
        assertEquals(expResult, result);
    }    
}
