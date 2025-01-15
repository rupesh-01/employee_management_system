package repositories;

import models.Department;

import java.util.*;

public class MapDepartmentRepositoryImpl implements DepartmentRepository {
    private Map<Integer, Department> departmentMap;

    public MapDepartmentRepositoryImpl() {
        this.departmentMap = new HashMap<>();
        this.departmentMap.put(1, new Department(1, "HR", "BLR", "200"));
        this.departmentMap.put(2, new Department(2, "Finance", "BLR", "400"));
        this.departmentMap.put(3, new Department(3, "IT", "Pune", "100"));
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
        return new ArrayList<>(departmentMap.values());
    }

    @Override
    public boolean deleteDepartment(int id) {
        return false;
    }

    @Override
    public Department getDepartmentById(int id) {
        return departmentMap.get(id);
    }

    @Override
    public Department getDepartmentByName(String name) {
        return null;
    }
}
