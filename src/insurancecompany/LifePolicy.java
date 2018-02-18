
package insurancecompany;

/**
 * A class to model a life insurance policy of an insurance company.
 * 
 * @author Phillip
 */
public class LifePolicy extends Policy{
    //Fields specific to this type of policy
    private int age;//The age of the client
    private int amount;//The amount of money the life of the client is insured for
    private double risk;// The risk of insuring the client's life (between 0 and 5,
    //(0 is a low risk and 5 a is very high risk)
    
    final double BASIC_AMOUNT = 100;//The lowest possible value of a premium
    final double AGE_THRESHOLD = 70;//A constant age to check how the clients premium
    //will be calculated
    
    
    /**
     * Creates a new instance of LifePolicy
     * 
     * @param policyNum     Unique for this policy
     * @param yearOfIssue
     * @param risk
     * @param age
     * @param amount
     * @throws IllegalPolicyException
     * @throws IllegalRiskException
     */
    public LifePolicy(String policyNum, int yearOfIssue, double risk, int age
    , int amount)throws IllegalPolicyException,IllegalRiskException{
            
        super(policyNum, yearOfIssue);
        if (policyNum.charAt(0) != 'L'){
            throw new IllegalPolicyException("Policy number begin with a 'L' "
                    + "for a life policy.");
        }
        else if( risk>=0 && risk<=5){
        this.age=age;
        this.amount=amount;
        this.risk=risk;
        }
        else{
            throw new IllegalRiskException("The risk for a life policy must be "
            + "between 0 and 5.");
        }
    }
    
    /**
     * @return the age of this LifePolicy holder
     */
    public int getAge(){
        return age;
    }
    
    /**
     * @return the amount the life is covered for of this LifePolicy holder
     */
    public int getAmount(){
        return amount;
    }
    
    /**
     * @return the risk of insuring this LifePolicy holder
     */
    public double getRisk(){
        return risk;
    }
    
    /**
     *  Sets the age of the client for this life policy
     * @param a
     */
    public void setAge(int a){
        age = a;
    }
    
    /**
     *  Sets the amount the client's is insured for, for this life policy
     * @param am
     */
    public void setAmount(int am){
        amount=am;
    }
    
    /**
     * Checks that the risk is between 0 and 5 then sets the risk for this life
     * policy
     * @param r the risk of insuring this clients life
     * @throws insurancecompany.IllegalRiskException
     */
    public void setRisk(double r) throws IllegalRiskException{
        if(r<=5 && r>=0){
            risk=r;
        }
        else{
            throw new IllegalRiskException("The risk must be between 0 and 5.");
        }
    }
    
    /**
     * @return the calculated final premium of this LifePolicy holder
     */
    @Override
    public double getPremium(){
        
        double finalPremium;
        double initialPremium;
        
        if(amount%1000==0){
        initialPremium = (BASIC_AMOUNT * (amount/1000));
        }
        //if the amount is not a multiple of 1000 the initial premium is 
        //BASIC_AMOUNT timesed by the amount rounded up to the next 1000
        //divided by 1000
        else{
                int multiplier = (amount/1000) + 1;
            
            initialPremium = (BASIC_AMOUNT*multiplier);
        }
        
        initialPremium *= (1+risk);
        
        if(age<AGE_THRESHOLD){
            finalPremium = initialPremium;
        }
        //if the client's age is greater than the AGE_THRESHOLD finalPremium is
        //initialPremium times by the client's age divided by the AGE_THRESHOLD
        else{
            finalPremium = initialPremium * (age/AGE_THRESHOLD);
        }
        
        return Math.round(finalPremium*100.0)/100.0;
    }
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder(super.toString());
        str.append("Age: ").append(age).append("\n");
        str.append("Amount: ").append(amount).append("\n");
        str.append("Risk: ").append(risk).append("\n");
        return str.toString();
    }
}