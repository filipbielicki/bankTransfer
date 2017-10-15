import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Filip on 2017-10-15.
 */
@RunWith(JUnitParamsRunner.class)
public class TransferTest {

    private Transfer testedObject;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        testedObject = new Transfer();
    }



    private Object[][] parametersForSpecificTransfers() {
        return new Object[][]{
                {2000, 1000, 1000, 1000, 2000},
                {0, 0, 0, 0, 0},
                {50, 60, 0, 50, 60},
                {50, 0, 50, 0, 50},
        };
    }


    @Test
    @Parameters(method = "parametersForSpecificTransfers")
    public void shouldTransferMoneyFromOneAccountToAnother(double accountOneBalance, double accountTwoBalance,
                                                           double moneyToTransfer, double expectedBalanceOfAccountOneAfterTransfer,
                                                           double expectedBalanceOfAccountTwoAfterTransfer) throws Exception {
        Account accountOne = new Account();
        accountOne.setBalance(accountOneBalance);

        Account accountTwo = new Account();
        accountTwo.setBalance(accountTwoBalance);

        testedObject.transferMoney(accountOne, accountTwo, moneyToTransfer);

        assertThat(accountOne.getBalance()).isEqualTo(expectedBalanceOfAccountOneAfterTransfer);
        assertThat(accountTwo.getBalance()).isEqualTo(expectedBalanceOfAccountTwoAfterTransfer);
    }


    @Test
    public void shouldThrowExceptionWhenInsufficientFunds() throws Exception {
        thrown.expect(InsufficientFundsException.class);
        thrown.expectMessage("Sorry, insufficient funds.");
        Account accountOne = new Account();
        accountOne.setBalance(200);

        Account accountTwo = new Account();
        accountTwo.setBalance(300);

        testedObject.transferMoney(accountOne, accountTwo, 201);
    }
}
