package insurancecompany;

/**
 * A class to model a building insurance policy of an insurance company.
 * 
 * @author Phillip
 */
public class BuildingPolicy extends Policy{
    //Fields specific to this type of policy
    private double reBuildCost; // The estimated cost of re-building the 
    //property being insured.
    private double risk; // The risk of insuring the property (between 0 and 1,
    //(0 is a low risk and 1 is a very high risk)
    
    final double REBUILD_FACTOR=0.001;//A constant for working out the 
    //cost of a premium
    
    /**
     * Creates a new instance of BuildingPolicy
     * 
     * @param policyNum  Unique for this policy
     * @param yearOfIssue
     * @param reBuildCost
     * @param risk
     * @throws IllegalPolicyException
     * @throws insurancecompany.IllegalRiskException
     */
    public BuildingPolicy(String policyNum, int yearOfIssue, 
            double reBuildCost, double risk)
                            throws IllegalPolicyException, IllegalRiskException{
        super(policyNum, yearOfIssue);
         
        if (policyNum.charAt(0) != 'B'){
            throw new IllegalPolicyException("Policy number begin with a 'B' "
                    + "for a building policy.");
        }
        else if(risk<=1 && risk>=0){
                this.reBuildCost=reBuildCost;
                this.risk=risk;
        }
        else{
         throw new IllegalRiskException("The risk must be between 0 and 1.");
        }
    }    
    
    /**
     * @return the estimated cost to rebuild property of this BuildingPolicy
     */
    public double getReBuildCost(){
        return reBuildCost;
    }
    
    /**
     * @return the risk of insuring   BuildingPolicy
     */
    public double getRisk(){
        return risk;
    }
    
    /**
     * Sets the cost of re-building the property
     *
     * @param c the cost to re-build the property
     */
    public void setReBuildCost(double c){
        reBuildCost = c;
    }
    
    /**
     * Makes sure the risk being set is between 0 and 1 then sets the risk of 
     * insuring the building
     * 
     * @param r the risk of insuring this building
     * @throws insurancecompany.IllegalRiskException
     * 
     */
    public void setRisk(double r)throws IllegalRiskException{
        //Checks that the risk is between 0 and 1
        if(r<=1 && r>=0){
            risk=r;
        }
        else{
            throw new IllegalRiskException("The risk must be between 0 and 1.");
        }
    }
    
    /**
     * @return the calculated premium of this BuildingPolicy
     */
    @Override
    public double getPremium(){
        return reBuildCost * REBUILD_FACTOR * (1 + risk); 
    }
    
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder(super.toString());
        str.append("Re-build cost: ").append(reBuildCost).append("\n");
        str.append("Risk: ").append(risk).append("\n");
        return str.toString();
    }
}