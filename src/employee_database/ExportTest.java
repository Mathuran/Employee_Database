package employee_database;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Martin
 */

public class ExportTest {
  public static final int k = 2 ; 
  public static void main (String[] args) throws Exception {
 
MyHashTable theHash = new MyHashTable(k);
	
FullTimeEmployee someEmployee = new FullTimeEmployee(600921, "Eri", "Burry","Toronto",0.2,"Math",5);
theHash.addEmployee(someEmployee);

someEmployee = new FullTimeEmployee(600921, "James", "Maggio","Toronto",0.2,"Darts",5);
theHash.addEmployee(someEmployee);

someEmployee = new FullTimeEmployee (600921, "Ashi", "Farquad","Toronto",0.2,"Yes",5);
theHash.addEmployee(someEmployee);

someEmployee = new FullTimeEmployee(600921, "Vriska", "Swaget","Toronto",0.2,"Yes",5);
theHash.addEmployee(someEmployee);

PartTimeEmployee partEmployee = new PartTimeEmployee(333111, "Gamzee", "Makara","Toronto",0.2,"no",5,52,11.5);
theHash.addEmployee(partEmployee);

partEmployee = new PartTimeEmployee(933332, "Michael", "Jackson","Toronto",0.2,"Hehee",5,52,11.5);
theHash.addEmployee(partEmployee);

theHash.exportContents();
  }
}