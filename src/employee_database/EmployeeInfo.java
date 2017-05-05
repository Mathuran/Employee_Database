package employee_database; 

public class EmployeeInfo{

//Attributes~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private int empNumber;
    private String firstName;
    private String lastName;
    private String sex; //allows the different obejcts to be linked right in tree
    private String workLocation;
    protected double deductions;
//Constructors~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~`
    public EmployeeInfo (){ //Neutral Constructor
    }


    public EmployeeInfo (int sNumber,String fName, String lName,String wL, double d, String s){ 
	empNumber = sNumber;
	firstName = fName;
	lastName = lName;
	workLocation = wL;
	deductions = d;
	sex = s;
    }

//Getters~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public int getEmpNumber (){
	return (empNumber);
    }


    public String getFirstName (){
	return (firstName);
    }


    public String getLastName (){
	return (lastName);
    }
    public String getSex (){
	return (sex);
    }
    public String getWorklocation (){
	return (workLocation);
    }
    public double getDeductions (){
	return (deductions);
    }

//Setters~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
void setEmpNumber (int sN){
    	if (sN < 99999 || sN > 1000000){//evaluates integer values, only enables 6 digit numbers to be used
    		empNumber = -1;//arbitrary value assigned to student number, when evaluated will be used as an error code
    	}
	
		else {
			empNumber = sN;
		}
    }
    
    //Overload ; if String is entered sets the studentnumber to error code'-1'
    void setStudentNumber (String sN){
    	empNumber = -1;//  
    }
    
    //Overload ; if double is entered sets the studentnumber to error code '-1' 
    void setEmpNumber (Double sN){
    	empNumber = -1;   
    }

    void setFirstName (String fN){
    	firstName = fN;
    }

    void setLastName (String lN){
    	lastName = lN;
    }
      void setSex (String s){
    	sex = s;
    }
      void setWorkLocation (String wL){
    	workLocation = wL;
    }
      void setDeductions (double d){
    	deductions = d;
    }
    
}
