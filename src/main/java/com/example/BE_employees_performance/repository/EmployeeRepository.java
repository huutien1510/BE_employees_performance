package com.example.BE_employees_performance.repository;

import com.example.BE_employees_performance.dto.response.AssessmentReponse;
import com.example.BE_employees_performance.dto.response.EmployeeResponse;
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

    @Query(value = "select \n" +
            "    e.employee_id,\n" +
            "    e.name,\n" +
            "    e.email,\n" +
            "    e.phone,\n" +
            "    e.job_title,\n" +
            "    e.birth_date,\n" +
            "    e.avatar,\n" +
            "    l.employee_id as line_manager_id,\n" +
            "    l.name as line_manager_name,\n" +
            "    l.job_title as line_manager_job_title,\n" +
            "    l.email as line_manager_mail,\n" +
            "    l.avatar as line_manager_avatar,\n" +
            "    d.department_id,\n" +
            "    d.department_name\n" +
            "    from \n" +
            "    (select employee_id, name, email, phone, job_title, birth_date, avatar, department_id, account_id from employees) e\n" +
            "    left join\n" +
            "    (select employee_id, line_manager_id from manage_info where (now()>start_date and ((end_date is null) or (now()<end_date)))) m on e.employee_id = m.employee_id\n" +
            "    left join\n" +
            "    (select employee_id, name, job_title, email, avatar from employees) l on m.line_manager_id = l.employee_id\n" +
            "    join\n" +
            "    (select department_id, department_name from departments) d on e.department_id = d.department_id\n" +
            "   where e.account_id = :accountId", nativeQuery = true)
    public EmployeeResponse getEmployeeById(@Param("accountId") Integer accountId);

    @Query(value = "select count(employee_id) from employees", nativeQuery = true)
    public Integer getTotalElements();

}
