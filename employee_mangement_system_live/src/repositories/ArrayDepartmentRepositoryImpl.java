package repositories;

import models.Department;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayDepartmentRepositoryImpl implements  DepartmentRepository{
    Department[] departments;


    public ArrayDepartmentRepositoryImpl() {
        this.departments = new Department[3];
        departments[0] = new Department(1, "HR", "BLR", "200");
        departments[1] = new Department(2, "FINANCE", "BLR", "200");
        departments[2] = new Department(3, "ENGINEERING", "BLR", "200");
    }

    @Override
    public Department addDepartment(Department department) {
        return null;
    }

    @Override
    public Department updateDepartment(Department department) {
        return null;
    }

    @Override
    public List<Department> getAllDepartment() {
        return new ArrayList<>(Arrays.asList(departments));
    }

    @Override
    public boolean deleteDepartment(int id) {
        return false;
    }

    @Override
    public Department getDepartmentById(int id) {
        Department foundDepartment = null;
        for(int i = 0; i < departments.length; i++){
            if(departments[i].getId() == id){
                foundDepartment = departments[i];
            }
        }
        return foundDepartment;
    }

    @Override
    public Department getDepartmentByName(String name) {
        Department department = null;
        for(int i = 0; i < departments.length; i++){
            if(departments[i].getName().equalsIgnoreCase(name));
            department = departments[i];
        }
        return department;
    }
}
