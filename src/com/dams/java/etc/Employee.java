package com.dams.java.etc;

import java.math.BigInteger;

public class Employee implements Comparable<Employee>{
    private int id;
    private String name;
    private String department;
    private String position;
    private BigInteger sales;


    public Employee(int id, String department, String name, String position, BigInteger sales) {
        this.id = id;
        this.department = department;
        this.name = name;
        this.position = position;
        this.sales = sales;
    }

    @Override
    public int compareTo(Employee o) {
        return this.getName().compareTo(o.name);
        /*if(this.getId() > o.id){
            return 1;
        }else if(this.getId() < o.id){
            return -1;
        }else{
            return 0;
        }*/
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public BigInteger getSales() {
        return sales;
    }

    public void setSales(BigInteger sales) {
        this.sales = sales;
    }
}
