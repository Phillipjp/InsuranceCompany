package insurancecompany;

/**
 * A class to represent a client's name.
 * 
 * @author Phillip
 */
public class Name {
    private String title;//The title of the client
    private String initials;//The initals of the client
    private String surname;//The surname of the client
    
      /** Creates a new instance of Name
     * @param title     
     * @param initials
     * @param surname 
     */
    public Name(String title, String initials, String surname){
        this.title=title;
        this.initials=initials;
        this.surname=surname;
    }
    
    /**
     * @return the title (Mr, Ms etc) of this Name
     */
    public String getTitle(){
        return title;
    }
    
    /**
     * @return the initials of the forenames of this Name
     */
    public String getInitials(){
        return initials;
    }
    
    /**
     * @return the surname of this Name
     */
    public String getSurname(){
        return surname;
    }
    
    /**
     *  Sets the title of the client
     * @param t
     */
    public void setTitle(String t){
        title = t;
    }
    
    /**
     *  Sets the initials of the client
     * @param i
     */
    public void setInitials(String i){
        initials=i;
    }
    
    /**
     *  Sets the surname of the client
     * @param s
     */
    public void setSurname(String s){
        surname=s;
    }
    
    @Override
    public String toString(){
        StringBuilder name = new StringBuilder();
        name.append(title).append(". ").append(initials);
        name.append(" ").append(surname);
        return name.toString();
    }
}
