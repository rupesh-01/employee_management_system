package repositories;

import models.Department;

public class ArrayDepartmentRepositoryImpl implements  DepartmentRepository{
    Department[] departments;
    int departmentCount;

    public ArrayDepartmentRepositoryImpl(int departmentCount) {
        this.departments = new Department[departmentCount];
        this.departmentCount = 0;
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
    public Department[] getAllDepartment() {
        return new Department[0];
    }

    @Override
    public boolean deleteDepartment(int id) {
        return false;
    }
}
