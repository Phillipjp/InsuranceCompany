
package insurancecompany;

/**
 * A class to model a car insurance policy of an insurance company.
 * 
 * @author Phillip
 */
public class CarPolicy extends Policy{
    //Fields specific to this type of policy
    private double vehicleValue; //The value of the vehicle being insured
    private int age; //The age of the driver being insured
    private int noClaim;//The number of years of no claims the driver has
    private boolean fullyComprehensive;//Whether or not the policy is fully
    //comprehensive or not
    
    final int BASIC_COVER=100;//The lowest possible valie of a premium
    final double FIXED_VEHICLE_PERCENTAGE = 0.1;//A company standard value to 
    //find 10% of the vehicle's value
    
    /**
     * Creates a new instance of a CarPolicy
     * @param policyNum     Unique for this policy
     * @param yearOfIssue
     * @param vehicleValue
     * @param age
     * @param noClaim
     * @param fullyComprehensive
     * @throws IllegalPolicyException
     * @throws insurancecompany.IllegalAgeException
     * @throws insurancecompany.IllegalNoClaimException
     */
    public CarPolicy(String policyNum, int yearOfIssue,
            double vehicleValue, int age, int noClaim, 
            boolean fullyComprehensive)throws IllegalPolicyException,
            IllegalAgeException,IllegalNoClaimException{
            
        super(policyNum, yearOfIssue);
        
        if (policyNum.charAt(0) != 'V'){
            throw new IllegalPolicyException("Policy number begin with a 'V' "
                    + "for a car policy.");
        }
        else if(noClaim < 0){
            throw new IllegalNoClaimException("Years of no claims must be"
                    + " 0 or higher.");
        }
        else if(age>=17&&age<=99){
            this.vehicleValue=vehicleValue;
            this.age=age;
            this.fullyComprehensive=fullyComprehensive;
            this.noClaim = noClaim; 
        }
        else{
            throw new IllegalAgeException("Policies can't be issued to"
                    + " people younger than 17 or older than 99."); 
        }
    }
    
    /**
     * @return the value of the vehicle for this CarPolicy
     */
    public double getVehicleValue(){
        return vehicleValue;
    }
    
    /**
     * @return the driver's age for this CarPolicy
     */
    public int getAge(){
        return age;
    }
    
    /**
     * @return the number of years no claims have been made for this CarPolicy
     */
    public int getNoClaim(){
        return noClaim;
    }
    
    /**
     * @return if the policy is full comprehensive for this CarPolicy
     */
    public boolean getFullyComprehensive(){
        return fullyComprehensive;
    }
    
    /**
     * Sets the value of the vehicle being insured
     * 
     * @param v the value of the vehicle being insured
     */
    public void setVehicleValue(double v){
        vehicleValue = v;
    }
    
    /**
     * Checks that the age of the client is between 17 and 19 then sets the
     * age for that client
     * 
     * @param a the age of the client
     * @throws insurancecompany.IllegalAgeException
    
     */
    public void setAge(int a) throws IllegalAgeException{
        if(age<17||age>99){
            throw new IllegalAgeException("Policies can't be issued to "
                    + "people younger than 17 or older than 99.");
        }
        else{
            age=a;
        }
    }
    
    /**
     * Sets fullyComprehensive to true or false
     * @param c
     */
    public void setFullyComprehensive(boolean c){
        fullyComprehensive = c;
    }
    
    /**
     * Sets the number of years the client hasn't made a claim for
     * 
     * @param nC the number of years the client hasn't made a claim for
     */
    public void setNoClaim(int nC){
        noClaim=nC;
    }

    /**
     * If the client has less then 5 years of no claims the noClaimBonus is 
     * noClaim*0.075 if the client has 5 or more years of no claims it's 5*0.075
     * 
     * @return the noClaimBonus for the client
     */
    public double noClaimBonus(){
        double noClaimBonus;
        //if noClaim is less then 5 noClaimBonus equals noClaim time 0.075
        if(noClaim<5){
            noClaimBonus = noClaim * 0.075;
        }
        //if noClaim is 5 or greater noClaimBonus equals 5 time 0.075
        else{
            noClaimBonus = 5*0.075;
        }
        return noClaimBonus;
    }
    
    /**
     * @return the calculated final premium for this CarPolicy
     */
    @Override
    public double getPremium(){
        //initialPremium equals the biggest between basic cover and 10% of 
        //the vehicle value
        double initialPremium = Math.max
        ( BASIC_COVER, FIXED_VEHICLE_PERCENTAGE * vehicleValue);
        //If the policy is fully comprehensive the premium is increased by 50%
        if(fullyComprehensive == true){
            initialPremium = initialPremium * 1.5;
        }
        //If the age of the client is 25 or less the premium is increased by 50%
        if(age<26){
            initialPremium = initialPremium * 1.5;
        }
        double finalPremium = initialPremium - (initialPremium*noClaimBonus()); 
        return Math.round(finalPremium*100.0)/100.0;
    }
    
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder(super.toString());
        str.append("Age: ").append(age).append("\n");
        str.append("Vehicle value: ").append(vehicleValue).append("\n");
        str.append("Years without claim: ").append(noClaim).append("\n");
        str.append("Fully comprehensive: ").append(fullyComprehensive);
        str.append("\n");
        return str.toString();
    }
}