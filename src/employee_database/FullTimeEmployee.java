package employee_database;

public class FullTimeEmployee extends EmployeeInfo {
	
//Attributes~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
double annualSalary; 
//Constructors~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public FullTimeEmployee (int eN,String fN, String lN,String wL,double D,String s, double aS){
            super (eN,fN,lN,wL,D,s);
            annualSalary = aS;
	}
//Methods~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
public double calcNetAnnualIncome(){
    double salary = annualSalary * (1-this.getDeductions());
	return(salary);
}
}
