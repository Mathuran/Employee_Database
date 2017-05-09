
package employee_database;

import java.util.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;


public class MyHashTable {
	
	// buckets is an array of ArrayList.  Each item in an ArrayList is an EmployeeInfo object.
	private ArrayList<EmployeeInfo>[] buckets;

	
	
	// CONSTRUCTOR
	public MyHashTable(int howManyBuckets) {
		// Construct the hash table (open hashing/closed addressing) as an array of howManyBuckets ArrayLists.

		// Instantiate an array to have an ArrayList as each element of the array.
		buckets = new ArrayList[howManyBuckets];

		// For each element in the array, instantiate its ArrayList.
		for (int i = 0; i < howManyBuckets; i++) {
			buckets[i] = new ArrayList();  // Instantiate the ArrayList for bucket i.
                } 
	}

	
	
	public int calcBucket(int keyValue) {
		// Returns the bucket number as the integer keyValue modulo the number of buckets for the hash table.
		return(keyValue % buckets.length);
	}
	

	
	public boolean addEmployee(EmployeeInfo theEmployee) {
		buckets[calcBucket(theEmployee.getEmpNumber())].add(theEmployee);
		return (true);
	}

	
	
	public EmployeeInfo searchEmployee(int employeeNum) {
            
		for (int i = 0;i <= buckets[calcBucket(employeeNum)].size();i++){
				if (buckets[calcBucket(employeeNum)].get(i).getEmpNumber()== employeeNum){
					return (buckets[calcBucket(employeeNum)].get(i));
				}
		}
	return(null);
	}
			
		
	
	
	
public EmployeeInfo removeEmployee(int employeeNum) {
	if (buckets[calcBucket(employeeNum)].isEmpty()== false){
		EmployeeInfo temp = searchEmployee(employeeNum);
		buckets[calcBucket(employeeNum)].remove(searchEmployee(employeeNum));
		return (temp);
	}
	return (null);
}
	
	
	public void displayContents() {
            for (ArrayList<EmployeeInfo> bucket : buckets) {
                for (int i = 0; i < bucket.size(); i++) {
                    System.out.println(bucket.get(i).getEmpNumber());
                    // Print the employee numbers for the employees stored in each bucket's ArrayList,
                    // starting with bucket 0, then bucket 1, and so on.
                }
            }
        }

            
public void importArchive(){
        
        String csvFile = "/Users/mathu/desktop/EmployeeDatabase.csv";
        BufferedReader bReader = null;
        String line = "";
        String cvsSplitBy = ",";
        
        try{
            bReader = new BufferedReader(new FileReader(csvFile));
            
            while((line = bReader.readLine()) != null) {
                
//uses Comma as separator
String[] employee = line.split(cvsSplitBy);

switch (employee[0]){
    case("F"):
        
        this.addEmployee(new FullTimeEmployee(Integer.parseInt(employee[1]),employee[2],employee[3],employee[4],Double.parseDouble(employee[5]),employee[6],Double.parseDouble(employee[7])));
        break;
        
    case("P"):
        this.addEmployee(new PartTimeEmployee(Integer.parseInt(employee[1]),employee[2],employee[3],employee[4],Double.parseDouble(employee[5]),employee[6],Integer.parseInt(employee[7]),Integer.parseInt(employee[8]),Double.parseDouble(employee[9])));
        break;
        
    default:
        break;
}
            }
        }
        
        
        catch (IOException e){
            e.printStackTrace();
            System.out.println("Failed to Save");
        }
        
    }
    public void exportContents()throws Exception {
        String csvFile;
       csvFile = "/Users/mathu/desktop/EmployeeDatabase.csv";
        //csvFile = "EmployeeDatabase.csv";
        FileWriter writer = new FileWriter(csvFile);
        
        
        for (ArrayList<EmployeeInfo> bucket : buckets) {
            for (int i = 0; i < bucket.size(); i++) {
                
                if (bucket.get(i)instanceof FullTimeEmployee){
                    FileProtocolUtil.writeLine(writer,Arrays.asList("F",Integer.toString(bucket.get(i).getEmpNumber()),bucket.get(i).getFirstName(),
                            bucket.get(i).getLastName(),bucket.get(i).getWorklocation(),Double.toString(bucket.get(i).getDeductions()),bucket.get(i).getSex(),
                            Double.toString(((FullTimeEmployee) bucket.get(i)).getAnnualSalary()),Double.toString(((FullTimeEmployee) bucket.get(i)).calcNetAnnualIncome())));
                }
                
                else {
                    FileProtocolUtil.writeLine(writer,Arrays.asList("P",Integer.toString(bucket.get(i).getEmpNumber()),bucket.get(i).getFirstName(),
                            bucket.get(i).getLastName(),bucket.get(i).getWorklocation(),Double.toString(bucket.get(i).getDeductions()),
                            bucket.get(i).getSex(),Integer.toString(((PartTimeEmployee)bucket.get(i)).getHoursPerWeek()),
                            Integer.toString(((PartTimeEmployee)bucket.get(i)).getWeeksPerYear()),Double.toString(((PartTimeEmployee) bucket.get(i)).getHourlyWage()),
                            Double.toString(((PartTimeEmployee)bucket.get(i)).calcNetAnnualIncome())));
                }
                
                //FileProtocolUtil.writeLine(writer, Arrays.asList(Integer.toString(bucket.get(i).getEmpNumber()),bucket.get(i).getFirstName(), bucket.get(i).getLastName(), bucket.get(i).getSex()));
                
                //bucket.get(i).getEmpNumber();
                // Print the employee numbers for the employees stored in each bucket's ArrayList,
                // starting with bucket 0, then bucket 1, and so on.
            }
        }
        writer.flush();
        writer.close();
    }

	
} // end class MyHashTable 
