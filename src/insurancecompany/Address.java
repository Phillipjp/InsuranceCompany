package insurancecompany;

/**
 * A class to represent a client's address.
 * 
 * @author Phillip
 */
public class Address implements Comparable<Address>{
    private String street; //The client's street, has a house number followed
    //by a street name
    private String city;//The client's home city 
    private String postCode;//The client's post code
    
    /** 
     * Creates a new instance of Address
     * @param street      the street of the customer
     * @param city        the city or town the customer lives in  
     * @param postCode    the post code of the customer
     */
    public Address(String street, String city, String postCode){
        this.street=street;
        this.city=city;
        this.postCode=postCode;
    }
    
    /**
     * @return the street of this Address
     */
    public String getStreet(){
        return street;
    }
    
    /**
     * @return the town or city of this Address
     */
    public String getCity(){
        return city;
    }
    
    /**
     * @return the post code of this Address
     */
    public String getPostCode(){
        return postCode;
    }
    
    /**
     * Sets a new street
     * 
     * @param s the street that is being set
     */
    public void setStreet(String s){
        street=s;
    }
    
    /**
     * Sets a new city
     * @param c the city that is being set
     */
    public void setCity (String c){
        city=c;
    }
    
    /**
     * Sets a new postCode
     * @param p the postCode that is being set
     */
    public void setPostCode(String p){
        postCode=p;
    }
    
    /**
     * A method to check if two different addresses are the same as each other.
     * @param other
     * @return 0 if the addresses are the same or 1 if they are not.
     */
    @Override
    public int compareTo(Address other){
        if (street != null && other.street != null){
            if (city != null && other.city != null){
                if (postCode != null && other.postCode != null){
                    if(street.compareTo(other.street) == 0 &&
                    city.compareTo(other.city) == 0 &&
                    postCode.compareTo(other.postCode) == 0){
                    return 0;
                    }
                }
            }
        }
        return 1;
    }
    
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("Street: ").append(street).append("\n");
        str.append("City: ").append(city).append("\n");
        str.append("Post Code: ").append(postCode).append("\n");
        return str.toString();
    }
}
