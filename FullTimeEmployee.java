
public class FullTimeEmployee extends EmployeeInfo {
	
//Attributes~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
double annualSalary; 
//Constructors~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public FullTimeEmployee (int eN,String fN, String lN,int wL,double D,int s, double aS){
				super (eN,fN,lN,wL,D,s);
				annualSalary = aS;
	}
//Methods~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
public double calcNetAnnualIncome(){
	return(annualSalary*(1-deductions));
}
}
