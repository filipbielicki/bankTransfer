/**
 * Created by Filip on 2017-10-15.
 */
public class Transfer {

    public void transferMoney(Account accountOne, Account accountTwo, double moneyToTransfer)throws InsufficientFundsException {

        if(hasSufficientFunds(accountOne, moneyToTransfer)) {
            conductTransfer(accountOne, accountTwo, moneyToTransfer);
        }

    }

    private boolean hasSufficientFunds(Account accountOne, double moneyToTransfer)throws InsufficientFundsException{

        if(accountOne.getBalance() < moneyToTransfer){
            throw new InsufficientFundsException();
        } else {
            return true;
        }
    }

    private void conductTransfer(Account accountOne, Account accountTwo, double moneyToTransfer){
        accountOne.setBalance(accountOne.getBalance() - moneyToTransfer);
        accountTwo.setBalance(accountTwo.getBalance() + moneyToTransfer);
    }
}
