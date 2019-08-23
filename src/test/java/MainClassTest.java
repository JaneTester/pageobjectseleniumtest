import org.junit.*;

public class MainClassTest {
//    @BeforeClass
//    public void beforeClassMethod() {
//
//    }//выполняется перед остальными тестами, подготавливает все для тестов
//
//    @Before
//    public void SetUp() {
//
//    }// позволяет указать метод, который будет выполняться перед каждовым тестовым методом

    @Test
    public void method1() {
        Assert.assertTrue("Value are not equals", 1 + 1 == 2);
       // Assert.assertFalse(1 + 1 == 10);
    }

//    @Test
//    @Ignore
//    public void method2() {
//        Assert.assertNull();
//        Assert.assertNotNull();
//    }

    @Test
    public void method3() {
        Assert.assertEquals(10, 5 + 5);
        //Assert.assertNotEquals(5, 5 + 5);
    }


//    @After
//    public void tearDown() {
//
//    }// позволяет указать метод, который будет выполняться после каждого тестового метода
//
//    @AfterClass
//    public void afterClassMethod() {
//
//    }//выполняется после всех тестов

}
