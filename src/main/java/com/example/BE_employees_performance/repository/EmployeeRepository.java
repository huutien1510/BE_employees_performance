package com.example.BE_employees_performance.repository;

import com.example.BE_employees_performance.dto.response.AssessmentReponse;
import com.example.BE_employees_performance.dto.response.EmployeeManagerResponse;
import com.example.BE_employees_performance.dto.response.EmployeeResponse;
import com.example.BE_employees_performance.dto.response.EmployeeSidebarResponse;
import com.example.BE_employees_performance.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employees,Integer> {
    @Query(value = "call get_all_employees(:pages,:size)", nativeQuery = true)
    public List<EmployeeResponse> getAllEmployees(@Param("pages") Integer page, @Param("size") Integer size);

    @Query(value = "call get_all_employees_sidebar", nativeQuery = true)
    public List<EmployeeSidebarResponse> getAllEmployeesSideBar();

    @Query(value = "call get_all_manager_sidebar", nativeQuery = true)
    public List<EmployeeSidebarResponse> getAllManagerSideBar();

    @Query(value = "select \n" +
            "    e.employee_id,\n" +
            "    e.name,\n" +
            "    e.email,\n" +
            "    e.phone,\n" +
            "    e.job_title,\n" +
            "    e.birth_date,\n" +
            "    e.start_date,\n" +
            "    e.end_date,\n" +
            "    e.avatar,\n" +
            "    l.employee_id as line_manager_id,\n" +
            "    l.name as line_manager_name,\n" +
            "    l.job_title as line_manager_job_title,\n" +
            "    l.email as line_manager_mail,\n" +
            "    l.avatar as line_manager_avatar,\n" +
            "    d.department_id,\n" +
            "    d.department_name\n" +
            "    from \n" +
            "    (select employee_id, name, email, phone, job_title, birth_date, start_date, end_date, avatar, department_id from employees) e\n" +
            "    left join\n" +
            "    (select employee_id, line_manager_id from manage_info where (now()>start_date and ((end_date is null) or (now()<end_date)))) m on e.employee_id = m.employee_id\n" +
            "    left join\n" +
            "    (select employee_id, name, job_title, email, avatar from employees) l on m.line_manager_id = l.employee_id\n" +
            "    join\n" +
            "    (select department_id, department_name from departments) d on e.department_id = d.department_id\n" +
            "   where e.employee_id = :employeeId", nativeQuery = true)
    public EmployeeResponse getEmployeeById(@Param("employeeId") Integer employeeId);

    @Query(value = "call get_employee_manager(:employeeId)", nativeQuery = true)
    public EmployeeManagerResponse getEmployeeManager(@Param("employeeId") Integer employeeId);


    @Query(value = "select count(employee_id) from employees", nativeQuery = true)
    public Integer getTotalElements();

    @Query(value = "call get_all_employees_by_name(:keyword)", nativeQuery = true)
    public List<EmployeeResponse> searchByName(@Param("keyword") String keyword);

}
