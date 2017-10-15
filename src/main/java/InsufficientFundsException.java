/**
 * Created by Filip on 2017-10-15.
 */
public class InsufficientFundsException extends Exception {

    public InsufficientFundsException(){
        super("Sorry, insufficient funds.");
    }
}
