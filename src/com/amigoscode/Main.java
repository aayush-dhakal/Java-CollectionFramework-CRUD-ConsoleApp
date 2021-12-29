package com.amigoscode;

import java.util.*;

class Employee{
    private int empno;
    private String ename;
    private int salary;

    Employee(int empno, String ename, int salary){
        this.empno=empno;
        this.ename=ename;
        this.salary=salary;
    }

    public int getEmpno(){
        return empno;
    }
    public int getSalary(){
        return salary;
    }
    public String getEname(){
        return ename;
    }

    // with this whenever you try to print the object then that object will be printed in this string format instead of their regular address
    public String toString(){
        return empno+""+ename+""+salary;
    }
}

public class Main {

    public static void main(String[] args) {
        // for update we have to use List
        List<Employee> c =  new ArrayList<Employee>();
        Scanner s = new Scanner(System.in);
        // new scanner instance for string data
        Scanner s1 = new Scanner(System.in);
        int choice;

        do{
            System.out.println("1.INSERT");
            System.out.println("2.DISPLAY");
            System.out.println("3.SEARCH");
            System.out.println("4.DELETE");
            System.out.println("5.UPDATE");
            System.out.println("0.EXIT");
            System.out.print("Enter Your Choice : ");

            choice = s.nextInt();

            switch(choice){
                case 1:
                    System.out.print("Enter Empno: ");
                    int eno = s.nextInt();
                    System.out.print("Enter EmpName: ");
                    String ename = s1.nextLine();
                    System.out.print("Enter Salary: ");
                    int salary = s.nextInt();

                    c.add(new Employee(eno,ename,salary));
                break;

                case 2:
                    System.out.println("----------------------------");
                    Iterator<Employee> i = c.iterator();
                    while(i.hasNext()){
                        Employee e = i.next();
                        System.out.println(e);
                    }
                    System.out.println("----------------------------");
                break;

                case 3:
                    boolean found = false;
                    System.out.print("Enter Empno to search: ");
                    int empno = s.nextInt();
                    System.out.println("----------------------------");
                    i = c.iterator();
                    while(i.hasNext()){
                        Employee e = i.next();
                        if(e.getEmpno() == empno){
                            System.out.println(e);
                            found = true;
                        }
                    }

                    if(!found){
                        System.out.println("Record not found");
                    }
                    System.out.println("----------------------------");
                break;

                case 4:
                    found = false;
                    System.out.print("Enter Empno to delete: ");
                    empno = s.nextInt();
                    System.out.println("----------------------------");
                    i = c.iterator();
                    while(i.hasNext()){
                        Employee e = i.next();
                        if(e.getEmpno() == empno){
                            i.remove();
                            found = true;
                        }
                    }

                    if(!found){
                        System.out.println("Record not found");
                    } else{
                        System.out.println("Record is deleted successfully");
                    }
                    System.out.println("----------------------------");
                break;

                case 5:
                    found = false;
                    System.out.print("Enter Empno to update: ");
                    empno = s.nextInt();

                    ListIterator<Employee> li = c.listIterator();
                    while(li.hasNext()){
                        Employee e = li.next();
                        if(e.getEmpno() == empno){
                            System.out.print("Enter new name: ");
                            ename = s1.nextLine();

                            System.out.print("Enter new Salary : ");
                            salary = s.nextInt();
                            li.set(new Employee(empno,ename,salary));
                            found = true;
                        }
                    }

                    if(!found){
                        System.out.println("Record not found");
                    } else{
                        System.out.println("Record is updated successfully");
                    }
                break;

            }
        }while(choice!=0);
    }
}
