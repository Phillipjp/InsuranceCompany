package insurancecompany;

/**
 * A class to model a client of an insurance company.
 * @author Phillip
 */
public class ClientDetails {
    
    private String clientID; //A unique code for a client
    private Name fullName; //The client's full name
    private Address fullAddress;//The client's full address
    private PolicyList list;
    
    
    /**
     * Creates a new instance of ClientDetails
     * @param clientID        unique client ID
     * @param fullName        client's name
     * @param fullAddress     client's address
     * @param list            list of policies for a specific client
     */
    public ClientDetails(String clientID, Name fullName, Address fullAddress, 
                                                               PolicyList list){
        this.clientID=clientID;
        this.fullName=fullName;
        this.fullAddress=fullAddress;
        this.list=list;
    }
    
    /**
   * @return the insurance company's ID for this client
   */
    public String getClientID(){
        return clientID;
    }
    
    /**
   * @return the full name for this client
   */
    public Name getFullName(){
        return fullName;
    }
    
    /**
   * @return the full address for this client
   */
    public Address getAddress(){
        return fullAddress;
    } 
    
    /**
   * @return the list of policies for this client
   */
    public PolicyList getList(){
        return list;
    }
    
    /**
     *  Sets the clientID for this client
     * @param ID
     */
    public void setClientID(String ID){
        clientID=ID;
    }
    
    /**
     *  Sets the fullName for this client
     * @param n
     */
    public void setFullName(Name n){
        fullName=n;
    }
    
    /**
     *  Sets the fullAddress for this client
     * @param a
     */
    public void setFullAddress(Address a){
        fullAddress=a;
    }
    
    /**
     * Sets the policyList for this client
     * @param l
     */
    public void setPolicyList(PolicyList l){
        list=l;
    }
    
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("____________________________________" +
                   "_______________________________________\n");
        str.append("Client ID: ").append(clientID).append("\n");
        str.append("Full Name: ").append(fullName).append("\n");
        str.append("Full Address: ").append(fullAddress).append("\n");
        str.append("Policies: ").append(list).append("\n");
        return str.toString();
    }
}
