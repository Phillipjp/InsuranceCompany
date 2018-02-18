
package insurancecompany;

/**
 * A class that defines an exception that will be given when something is wrong 
 * the age.
 * 
 * @author Phillip
 */
public class IllegalAgeException extends Exception{
    
    
    /*
    * Creates an IllegalAgeException with a given message
    * * @param message       A message given stating why the exception occured. 
    */
    
    public IllegalAgeException(String message) {
        super(message);
    }
}
