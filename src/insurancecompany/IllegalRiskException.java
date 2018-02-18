
package insurancecompany;

/**
* A class that defines an exception that will be given when something is wrong 
 * the risk. 
 * @author Phillip
 */
public class IllegalRiskException extends Exception {
    
    /*
    * Creates an IllegalRiskException with a given message
    * * @param message       A message given stating why the exception occured. 
    */
    
    public IllegalRiskException(String message) {
        super(message);
    }
}
