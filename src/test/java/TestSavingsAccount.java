import org.junit.jupiter.api.*;

public class TestSavingsAccount {

    public static Account account;

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Tests started");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Tests completed");
    }

    @BeforeEach
    public void beforeEach() {
        account = new SavingsAccount();
        System.out.println("Test started");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("Test completed");
    }

    @Test
    public void testPay() {
        //arrange
        Account account = new SavingsAccount();
        var expected = RuntimeException.class;

        //assert
        Assertions.assertThrows(expected,
                // act
                () -> account.pay(1));
    }

    @Test
    public void testAddMoney() {
        //arrange
        int expected = 1;

        //act
        account.addMoney(1);

        //assert
        Assertions.assertEquals(account.getMoney(), expected);
    }

    @Test
    public void testTransferToSavingAccount() {
        //arrange
        Account accountTransfer = new SavingsAccount();
        account.addMoney(1);
        int expectedAccount1 = 0;
        int expectedAccount2 = 1;

        //act
        account.transfer(accountTransfer, 1);

        //assert
        Assertions.assertEquals(account.getMoney(), expectedAccount1);
        Assertions.assertEquals(accountTransfer.getMoney(), expectedAccount2);
    }

    @Test
    public void testTransferToCreditAccountWithException() {
        //arrange
        Account accountTransfer = new CreditAccount();
        account.addMoney(5);
        int exceptedSumAccount1 = 5;
        int expectedSumAccount2 = 0;
        var excepted = IllegalArgumentException.class;

        //assert
        Assertions.assertThrows(excepted,
                //act
                () -> account.transfer(accountTransfer, 1));
        Assertions.assertEquals(exceptedSumAccount1, account.getMoney());
        Assertions.assertEquals(expectedSumAccount2, accountTransfer.getMoney());
    }

    @Test
    public void  testTransferWithMoneyLess0Exception() {
        // arrange
        Account accountTransfer = new CheckingAccount();
        var excepted = IllegalArgumentException.class;
        int exceptedAccounts = 0;

        //assert
        Assertions.assertThrows(excepted,
                //act
                () -> account.transfer(accountTransfer, 1));
        Assertions.assertEquals(exceptedAccounts, account.getMoney());
        Assertions.assertEquals(exceptedAccounts, account.getMoney());
    }
}