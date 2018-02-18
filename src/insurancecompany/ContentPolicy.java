package insurancecompany;

/**
 * A class to model a content insurance policy of an insurance company.
 * 
 * @author Phillip
 */
public class ContentPolicy extends Policy {
    //Fields specific to this type of policy
    private double contentsValue;//The value of the items being insured
    private double risk;// The risk of insuring the contents of a property 
    //(between 0 and 1,(0 is a low risk and 1 is a very high risk)
    
    final double CONTENTS_FACTOR = 0.01;//A constant for working out the cost 
    //of a premium
    
    /**
     * Creates a new instance of ContentPolicy
     * 
     * @param policyNum     Unique for this policy
     * @param yearOfIssue
     * @param contentsValue
     * @param risk
     * @throws IllegalPolicyException
     * @throws insurancecompany.IllegalRiskException
     */
    public ContentPolicy(String policyNum, int yearOfIssue, 
            double contentsValue, double risk)
            throws IllegalPolicyException, IllegalRiskException{
        super(policyNum, yearOfIssue);
        
        if (policyNum.charAt(0) != 'C'){
            throw new IllegalPolicyException("Policy number begin with a 'C' "
                    + "for a content policy.");
        }
        else if(risk<=1 && risk>=0){
            this.contentsValue=contentsValue;
            this.risk=risk;
        }
        else{
            throw new IllegalRiskException("The risk must be between 0 and 1.");
        }
    }
    
    /**
     * @return the insured value of the contents ContentsPolicy
     */
    public double getContentsValue(){
        return contentsValue;
    }
    
    /**
     * @return the risk of insuring this ContentsPolicy
     */
    public double getRisk(){
        return risk;
    }
    
    /**
     *  Sets the contentsValue for this content policy
     * @param v
     */
    public void setContentsValue(double v){
        contentsValue = v;
    }
    
    /**
     *  Checks the risk is between 0 and 1 then sets the risk for this content
     *  policy
     * @param r
     * @throws IllegalAgeException
     */
    public void setRisk(double r) throws IllegalAgeException {
        if(r<=1 && r>=0){
            risk=r;
        }
        else{
            throw new IllegalAgeException("The risk must be between 0 and 1.");
        }
    }
    
    /**
     * @return the calculated premium of this ContentsPolicy
     */
    @Override
    public double getPremium(){
        double finalPremium =contentsValue * CONTENTS_FACTOR * (1 + risk);
        return finalPremium; 
    }
    
     @Override
    public String toString(){
        StringBuilder str = new StringBuilder(super.toString());
        str.append("Contents value: ").append(contentsValue).append("\n");
        str.append("Risk: ").append(risk).append("\n");
        return str.toString();
    }
}
