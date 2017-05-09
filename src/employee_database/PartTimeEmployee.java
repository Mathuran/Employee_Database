package employee_database;


        
public class PartTimeEmployee extends EmployeeInfo {
//Attributes~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
int hoursPerWeek;
int weeksPerYear;
double hourlyWage; 
//Constructors~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public PartTimeEmployee (int eN,String fN, String lN,String wL,double D,String s,int hPw, int wPy, double hW){
		super (eN,fN,lN,wL,D,s);
		hoursPerWeek = hPw;
		weeksPerYear = wPy;
		hourlyWage = hW;
		
		 
	}
//Methods~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
public double calcNetAnnualIncome(){
	return (hourlyWage*weeksPerYear*hoursPerWeek*(1-this.getDeductions()));
	
}
public int getHoursPerWeek(){
    return hoursPerWeek;
}
public int getWeeksPerYear(){
    return weeksPerYear;
}
public double getHourlyWage(){
    return hourlyWage;
}
}
