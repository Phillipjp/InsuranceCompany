
package insurancecompany;

/**
 * A class that defines an exception that will be given when something is wrong 
 * the policy number.
 * 
 * @author Phillip
 */
public class IllegalPolicyException extends Exception {
    /*
    * Creates an IllegalPolicyException with a given message
    * * @param message       A message given stating why the exception occured. 
    */
    
    public IllegalPolicyException(String message) {
        super(message);
    }
}
