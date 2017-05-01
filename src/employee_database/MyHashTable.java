
package employee_database;

import java.util.*;




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
            
           /* if (buckets[calcBucket(employeeNum)].iterator().getEmpNumber() == employeeNum){
                
            }
            */
            
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

	
	} // end class MyHashTable 
}