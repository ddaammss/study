package com.dams.java.etc;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorClass implements Comparator<ComparatorClass> {

    public static void main(String[] args) {
        Employee employee1 = new Employee(1, "ㄹ솔루션개발1", "jdk", "연구원", new BigInteger("2800"));
        Employee employee2 = new Employee(2, "ㄷ솔루션개발1", "amateur", "선임연구원", new BigInteger("3200"));
        Employee employee3 = new Employee(3, "ㄴ솔루션개발2", "jeong", "연구원", new BigInteger("2800"));
        Employee employee4 = new Employee(4, "ㄱ솔루션개발2", "pro", "수석연구원", new BigInteger("7000"));

        List<Employee> list = new ArrayList<>();
        list.add(employee1);
        list.add(employee2);
        list.add(employee3);
        list.add(employee4);

        Collections.sort(list);
        System.out.println("### sort 이후 ###");
        for(Employee var : list){
            System.out.print("Id = " + var.getId()+ ", ");
            System.out.print("Department = " + var.getDepartment()+ ", ");
            System.out.print("Name = " + var.getName()+ ", ");
            System.out.print("Position = " + var.getPosition()+ ", ");
            System.out.print("Sales = " + var.getSales());
            System.out.println();
        }
        //System.out.println("list = " + list);
        /*System.out.println("### comparator 이후 ###");
        Comparator<Employee> salesComparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o2.getSales().intValue() - o1.getSales().intValue();
            }
        };
        Collections.sort(list,salesComparator);
        for(Employee var : list){
            System.out.print("Id = " + var.getId()+ ", ");
            System.out.print("Name = " + var.getName()+ ", ");
            System.out.print("Department = " + var.getDepartment()+ ", ");
            System.out.print("Position = " + var.getPosition()+ ", ");
            System.out.print("Sales = " + var.getSales());
            System.out.println();
        }*/


    }
    @Override
    public int compare(ComparatorClass o1, ComparatorClass o2) {
        return 0;
    }
}
