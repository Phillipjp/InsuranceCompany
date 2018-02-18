
package insurancecompany;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
/**
 * A class to simulate the output of client details of an insurance company

 * @author Phillip
 */
public class InsuranceCoDemo {

    /**
     * 
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws insurancecompany.IllegalPolicyException
     * @throws insurancecompany.IllegalRiskException
     * @throws insurancecompany.IllegalAgeException
     * @throws insurancecompany.IllegalNoClaimException
     */
    public static void main(String[] args) throws IOException,
            IllegalPolicyException, 
            IllegalRiskException, IllegalAgeException, IllegalNoClaimException {
        //Tests the program runs succsefully when the data is read from an
        //external file
        File clientDetailData = new File("ClientDetailsInput.txt");
        System.out.print(InputData.readFile(clientDetailData));

    }
    
    
}
