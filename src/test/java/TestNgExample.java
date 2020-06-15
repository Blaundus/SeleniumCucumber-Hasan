import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestNgExample {

    @BeforeClass
    public static void beforeAll() {
        System.out.println("Beginning of the class");
    }

    @BeforeMethod
    public void setUp() {
        System.out.println("Before each test");
    }

    @AfterMethod
    public void teardown() {
        System.out.println("After each test");
    }

    @AfterClass
    public static void afterAll() {
        System.out.println("After Class");
    }

    @Test
    public void addToNumbres(){
        System.out.println("Add test");
        int a = 4;
        int b = 3;
        int expectedResult = 7;

        assertEquals(a+b,expectedResult, "Add is not correct");
    }

    @Test
    public void testContains() {
        System.out.println("Contains test");
        String a = "This a Selenium course";
        String b = "Selenium";

        assertTrue(a.contains(b), "Not contains");
    }
}
