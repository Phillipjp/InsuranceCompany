
package insurancecompany;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
/**
 *  A class containing a static method to read an insurance company's client  
 *  data from a file
 * @author Phillip
 */
public class InputData {
    
    public static ClientDetailsList readFile( File inputFile )
throws IOException, IllegalPolicyException, IllegalAgeException, 
            IllegalRiskException, IllegalNoClaimException{
        ClientDetailsList  clientDetailsList = new ClientDetailsList();
        Scanner fileScan = new Scanner( inputFile );
        
        while(fileScan.hasNextLine()){
             
            String [] details = fileScan.nextLine().split("/");
            details[details.length-1] = details[details.length-1].replaceAll
                                                                      ("#", "");
           
            
            Name name = new Name(details[1],details[2],details[3]);
            Address address = new Address(details[4], details[5], details[6]);
            
            PolicyList policyList = new PolicyList();
            
            
                
                for(int i =7;i<details.length;){
                    
                    switch (details[i+1].charAt(0)){
                        case 'B':
                            BuildingPolicy buildingPolicy = new BuildingPolicy(
                                details[i+1], Integer.parseInt(details[i]),
                                    Double.parseDouble(details[i+2]),
                                    Double.parseDouble(details[i+3]));
                            
                            i+=4;
                            policyList.addPolicy(buildingPolicy);
                            
                            break;
                        case 'C':
                            ContentPolicy contentPolicy = new ContentPolicy(
                            details[i+1], Integer.parseInt(details[i]),
                                    Double.parseDouble(details[i+2]),
                                    Double.parseDouble(details[i+3]));
                            
                           i+=4;
                            policyList.addPolicy(contentPolicy);
                            break;
                        case 'L':
                            LifePolicy lifePolicy = new LifePolicy(
                            details[i+1], Integer.parseInt(details[i]),
                                    Double.parseDouble(details[i+4]),
                                    Integer.parseInt(details[i+3]),
                                    Integer.parseInt(details[i+2]));
                            
                            i+=5;
                            policyList.addPolicy(lifePolicy);
                            
                            break;
                        case 'V':
                            CarPolicy carPolicy = new CarPolicy(details[i+1], 
                                    Integer.parseInt(details[i]),
                                    Double.parseDouble(details[i+2]),
                                    Integer.parseInt(details[i+3]),
                                    Integer.parseInt(details[i+4]), 
                                    Boolean.parseBoolean(details[i+5]));
                            
                            i+=6;
                            policyList.addPolicy(carPolicy);
                            break;
                            
                    }
                    
                }
                
                ClientDetails clientDetails = new ClientDetails(details[0],
                        name, address, policyList);
                clientDetailsList.addClient(clientDetails);
        }
        
        
        
        return clientDetailsList;
    }
    
}
