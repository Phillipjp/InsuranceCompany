
package insurancecompany;

/**
 * A class that defines an exception that will be given when something is wrong 
 * the number of years of no claims.
 * @author Phillip
 */
class IllegalNoClaimException extends Exception {
    /*
    * Creates an IllegalNoClaimException with a given message
    * * @param message       A message given stating why the exception occured. 
    */
    
    public IllegalNoClaimException(String message) {
        super(message);
    }
}
