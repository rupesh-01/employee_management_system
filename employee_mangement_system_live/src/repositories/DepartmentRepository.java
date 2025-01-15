package repositories;

import models.Department;

import java.util.List;

public interface DepartmentRepository {
    Department addDepartment(Department department);
    Department updateDepartment(Department department);
    List<Department> getAllDepartment();
    boolean deleteDepartment(int id);
    Department getDepartmentById(int id);
    Department getDepartmentByName(String name);
}
