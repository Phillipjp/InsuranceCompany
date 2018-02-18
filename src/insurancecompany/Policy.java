package insurancecompany;

/**
 * An abstract class to model the policies the insurance company provides.
 * 
 * @author Phillip
 */
public abstract class Policy {
    protected String policyNum;
    //policyNum is 9 characters long. It must start with a letter, 
    //'B' (Building Policy), 'C' (Content Policy), 'L' (Life Policy) or 'V'(Car Policy).
    //The remaining 8 characters must be numbers from 0 to 9.
    protected int yearOfIssue; //The year the policy was issued. A policy can only
    //be issued between 1990 and 2013.
    
    
    
    public Policy (String policyNum, int yearOfIssue)
                                                throws IllegalPolicyException{
        //Checks the policy is issued between 1990 and 2013
        if(yearOfIssue<1990||yearOfIssue>2013){
            throw new IllegalPolicyException("The year entered is not possible."
            +" A policy must be issued between 1990 and 2013.");
        }
        //Checks the policy number is 9 characters long
        if(policyNum.length()!= 9){
            throw new IllegalPolicyException("The policy number must be 9"
                    + " characters long.");
        }
        //Checks the first character of the policy number begins with a 'B',
        //'C', 'L' or 'V'.
        else if(policyNum.charAt(0)=='B'||policyNum.charAt(0)=='C'||
                policyNum.charAt(0)=='V'||policyNum.charAt(0)=='L'){
                //Checks the last 8 characters of the policy number are
                //numbers between 0 and 9.
                int checker = 0;
                for(int i=1; i<9; i++){
                    char j='0';
                    for(int k =0;k<10;k++){
                        //System.out.println(j);
                        if(policyNum.charAt(i)==j){
                            checker ++;
                        }
                        j=(char)(j+1);
                    }
                }
                if(checker!=8){
                    throw new IllegalPolicyException("Invalid policy number"
                            + " entered. The last 8 characters in the policy "
                            + "number must be numbers between 0 and 9.");
                }
                else{
                    this.policyNum=policyNum;
                    this.yearOfIssue=yearOfIssue;
                }
                
        }    
        else{ 
            throw new IllegalPolicyException("Invalid policy number entered. " 
                + "A policy number must begin with a 'B', 'C', 'V' or an 'L'.");
        }
           
    }
   
    /**
     * @return the policy number of the policy
     */
    public String getPolicyNum(){
        return policyNum;
    }
    
    /**
     * @return the year the policy was issued
     */
    public int getYearOfIssue(){
        return yearOfIssue;
    }
    
    public abstract double getPremium();
            
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("Policy Number: ").append(policyNum).append("\n");
        str.append("Year of issue: ").append(yearOfIssue).append("\n");
        return str.toString();
    }
}
