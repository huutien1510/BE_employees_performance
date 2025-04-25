package com.example.BE_employees_performance.repository;

import com.example.BE_employees_performance.dto.request.AssessmentCreateRequest;
import com.example.BE_employees_performance.dto.response.AssessmentPageParameters;
import com.example.BE_employees_performance.dto.response.AssessmentReponse;
import com.example.BE_employees_performance.dto.response.EmployeeResponse;
import com.example.BE_employees_performance.entity.Assessment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Repository
public interface AssessmentRepository extends JpaRepository<Assessment,Integer> {
    @Query(value = "call get_all_assessment_by_employee(:employeeId,:pages,:size)", nativeQuery = true)
    public List<AssessmentReponse> getAllAssessmentByEmployee(@Param("employeeId") Integer employeeId,@Param("pages") Integer page, @Param("size") Integer size);

    @Query(value = "call get_assessment_by_employee_page_parameters(:employeeId)", nativeQuery = true)
    public AssessmentPageParameters getAssessmentByEmployeePageParameters(@Param("employeeId") Integer employeeId);

    @Query(value = "call get_all_assessment(:pages,:size)", nativeQuery = true)
    public List<AssessmentReponse> getAllAssessment(@Param("pages") Integer page, @Param("size") Integer size);

    @Query(value = "call get_assessment_page_parameters", nativeQuery = true)
    public AssessmentPageParameters getAssessmentPageParameters();

    @Query(value = "call update_assessment(:employeeId,:assessmentId,:kpiId,:kpaId,:evaluate,:comments,:link)", nativeQuery = true)
    public Object updateAssessment(@Param("employeeId") Integer employeeId,
                                   @Param("assessmentId") Integer assessmentId,
                                   @Param("kpiId") Integer kpiId,
                                   @Param("kpaId") Integer kpaId,
                                   @Param("evaluate") Integer evaluate,
                                   @Param("comments") String comments,
                                   @Param("link") String link);

    @Query(value = "SELECT \n" +
            "  a.assessment_id,\n" +
            "  a.employee_id,\n" +
            "  e.name,\n" +
            "  e.job_title,\n" +
            "  e.avatar as employee_avatar,\n" +
            "  l.line_manager_id,\n" +
            "  l.line_manager_name,\n" +
            "  l.line_manager_job_title,\n" +
            "  l.line_manager_avatar,\n" +
            "  a.kpa_id,\n" +
            "  c.kpa_name,\n" +
            "  a.kpi_id,\n" +
            "  b.kpi_name,\n" +
            "  a.evaluate,\n" +
            "  a.comments,\n" +
            "  a.link,\n" +
            "  a.status,\n" +
            "  a.created_at,\n" +
            "  a.updated_at\n" +
            "\tFROM assessment a\n" +
            "\tJOIN (\n" +
            "\tSELECT employee_id, name, job_title,avatar FROM employees\n" +
            "\t) e ON e.employee_id = a.employee_id\n" +
            "    JOIN (\n" +
            "\tSELECT employee_id as line_manager_id, name as line_manager_name, job_title as line_manager_job_title, avatar as line_manager_avatar FROM employees\n" +
            "\t) l ON l.line_manager_id = a.line_manager_id\n" +
            "\tJOIN (\n" +
            "\tSELECT kpa_id, kpa_name FROM kpa\n" +
            "\t) c ON c.kpa_id = a.kpa_id\n" +
            "\tJOIN (\n" +
            "\tSELECT kpi_id, kpi_name FROM kpi\n" +
            "\t) b ON b.kpi_id = a.kpi_id\n" +
            "\tWHERE a.assessment_id = :assessmentId ", nativeQuery = true)
    public AssessmentReponse getAssessmentById(@Param("assessmentId") Integer assessmentId);

    @Query(value = "call create_assessment(:token,:employeeId,:lineManagerId,:kpiId,:kpaId,:evaluate,:comments,:link,:createdAt,:updatedAt)", nativeQuery = true)
    public AssessmentCreateRequest createAssessment(@Param("token") Integer token,
                                                    @Param("employeeId") Integer employeeId,
                                                    @Param("lineManagerId") Integer lineManagerId,
                                                    @Param("kpiId") Integer kpiId,
                                                    @Param("kpaId") Integer kpaId,
                                                    @Param("evaluate") Integer evaluate,
                                                    @Param("comments") String comments,
                                                    @Param("link") String link,
                                                    @Param("createdAt") Date createdAt,
                                                    @Param("updatedAt") Date updatedAt);

    @Query(value = "call delete_assessment_by_id(:assessmentId)", nativeQuery = true)
    public Integer deleteAssessmentById(@Param("assessmentId") Integer assessmentId);

    @Query(value = "call get_all_assessment_by_name(:keyword)", nativeQuery = true)
    public List<AssessmentReponse> searchByName(@Param("keyword") String keyword);
}
