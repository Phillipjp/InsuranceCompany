package insurancecompany;

import java.util.ArrayList;
/**
 * A class to model a list of policies
 * @author Phillip
 */
public class PolicyList {
    
    private ArrayList<Policy>policies;
    
    /** Creates a new instance of PolicyList */
    public PolicyList() {
        // initialise an empty list of policies
        policies = new ArrayList<Policy>();
    }
    
    /**
     * Add a new Policy to the list.
     * @param p the Policy record to be added to this List.
     * @throws IllegalPolicyException
     */
    public void addPolicy(Policy p)throws IllegalPolicyException {
        //Checks that the policy list doesn't already contain the type of policy
        //that is being added
      
        for(Policy l: policies){
            
            if(l.getPolicyNum().startsWith
                                (String.valueOf(p.getPolicyNum().charAt(0)))){
              throw new IllegalPolicyException("Can't have two types of "
                                               + "the same policy per client.");
            }
            
        }
        policies.add(p);
    }
    
     /**
     * @return      the number of Policies in this  List             
     */
    public int numberOfPolicies() {
        return policies.size();
    }
    
    
    
    @Override
    public String toString(){
        StringBuilder listPolicies = new StringBuilder();
        for (Policy p : policies) {
            listPolicies.append("\n\n").append(p.toString());
        }
        return listPolicies.toString();
    }
}
