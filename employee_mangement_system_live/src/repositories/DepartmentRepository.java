package repositories;

import models.Department;

public interface DepartmentRepository {
    Department addDepartment(Department department);
    Department updateDepartment(Department department);
    Department[] getAllDepartment();
    boolean deleteDepartment(int id);
    Department getDepartmentById(int id);
    Department getDepartmentByName(String name);
}
