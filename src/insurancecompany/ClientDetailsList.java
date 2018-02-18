package insurancecompany;
import java.util.ArrayList;
import java.util.Iterator;
/**
 * A class to model a list of client records for an insurance company.
 * @author Phillip
 */
public class ClientDetailsList {
    
    private ArrayList<ClientDetails>clientList;
    
    /**
     * Creates an empty ClientDetailsList.
     */
    public ClientDetailsList()
    {
        clientList = new ArrayList<ClientDetails>();
    }
    
    /**
     * Store details of a new client into this ClientDetailsList.
     * @param newClient     The CustomerDetails to be stored.
     */
    public void addClient(ClientDetails newClient)
    {
        clientList.add(newClient);
    }
    
    /**
     * A method to determine the number of clients the company has records for.
     * @return          The number of client's details currently held in 
     *                  the company's clients records.
     */
    public int numberOfClients()
    {
        return clientList.size();
    }
    
    /**
    * A method to determine whether or not a given person, identified by a
    * surname and a postcode is a client of the Insurance company.
    * If so, the client’s ID should be returned.
    * @param lastName the surname of the person to be searched for.
    * @param code the postcode of the address of the person to be
    * searched for.
    * @return the Client ID if the person has at least one policy
    * with the company, null otherwise.
    */
    public String findClient(String lastName, String code){
        Iterator<ClientDetails> it = clientList.iterator();
        
        while ( it.hasNext()){
            ClientDetails cDetails = it.next();
            String surname = cDetails.getFullName().getSurname();
            String pCode = cDetails.getAddress().getPostCode();
            
            if(surname.equals(lastName) && pCode.equals(code))
                return cDetails.getClientID();
        }
        
        return null;
    }



/**
* A method to get the client details corresponding to a given client ID
*
* @param givenID the client ID whose details are required.
*
* @return the required ClientDetails if found,
* null otherwise.
*/
public ClientDetails getClientDetails(String givenID){
    
    Iterator<ClientDetails> it = clientList.iterator();
        while ( it.hasNext()){
            ClientDetails  cDetails = it.next();
            String clientID = cDetails.getClientID();           
            
            if ( clientID.equals(givenID) )
                return cDetails;
        }
        return null;
    }


    /**
    * A method to determine another client who has the same address as
    * the client whose details are given.
    *
    * @param cDetails the client details whose address is to be
    * searched for.
    * @return the ClientDetails of a client with the same
    * address if there is one, null otherwise.
    */
    public ClientDetails sameAddressCheck(ClientDetails cDetails){
        Iterator<ClientDetails> it = clientList.iterator();
            while ( it.hasNext()){
                ClientDetails  details = it.next();       
                
                if(details.getAddress().compareTo(cDetails.getAddress())==0){
                 return details;   
                }   
            }
            return null;
    }

    @Override
    public String toString(){
        StringBuilder listClientDetails = new StringBuilder();
        for (Iterator<ClientDetails> it = clientList.iterator(); it.hasNext();){
            ClientDetails newClient = it.next();
            listClientDetails.append("\n\n").append(newClient.toString());
        }
        return listClientDetails.toString();
    }
}