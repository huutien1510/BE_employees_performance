package com.example.BE_employees_performance.repository;

import com.example.BE_employees_performance.dto.response.AssessmentPageParameters;
import com.example.BE_employees_performance.dto.response.AssessmentReponse;
import com.example.BE_employees_performance.entity.Assessment;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface AssessmentRepository extends JpaRepository<Assessment,Integer> {
    @Query(value = "call get_all_assessment_by_employee(:accountId,:pages,:size)", nativeQuery = true)
    public List<AssessmentReponse> getAllAssessmentByEmployee(@Param("accountId") Integer accountId,@Param("pages") Integer page, @Param("size") Integer size);

    @Query(value = "call get_assessment_by_employee_page_parameters(:accountId)", nativeQuery = true)
    public AssessmentPageParameters getAssessmentByEmployeePageParameters(@Param("accountId") Integer accountId);

    @Query(value = "call get_all_assessment(:pages,:size)", nativeQuery = true)
    public List<AssessmentReponse> getAllAssessment(@Param("pages") Integer page, @Param("size") Integer size);

    @Query(value = "call get_assessment_page_parameters", nativeQuery = true)
    public AssessmentPageParameters getAssessmentPageParameters();

    @Query(value = "call update_assessment(:accountId,:assessmentId,:kpiId,:kpaId,:evaluate,:comments,:link)", nativeQuery = true)
    public Object updateAssessment(@RequestParam("accountId") Integer accountId,
                                   @RequestParam("assessmentId") Integer assessmentId,
                                   @RequestParam("kpiId") Integer kpiId,
                                   @RequestParam("kpaId") Integer kpaId,
                                   @RequestParam("evaluate") Integer evaluate,
                                   @RequestParam("comments") String comments,
                                   @RequestParam("link") String link);

    @Query(value = "SELECT \n" +
            "  a.assessment_id,\n" +
            "  a.employee_id,\n" +
            "  e.name,\n" +
            "  e.job_title,\n" +
            "  l.line_manager_id,\n" +
            "  l.line_manager_name,\n" +
            "  l.line_manager_job_title,\n" +
            "  a.kpa_id,\n" +
            "  c.kpa_name,\n" +
            "  a.kpi_id,\n" +
            "  b.kpi_name,\n" +
            "  a.evaluate,\n" +
            "  a.comments,\n" +
            "  a.link,\n" +
            "  a.status,\n" +
            "  a.updated_at\n" +
            "\tFROM assessment a\n" +
            "\tJOIN (\n" +
            "\tSELECT employee_id, name, job_title FROM employees\n" +
            "\t) e ON e.employee_id = a.employee_id\n" +
            "    JOIN (\n" +
            "\tSELECT employee_id as line_manager_id, name as line_manager_name, job_title as line_manager_job_title FROM employees\n" +
            "\t) l ON l.line_manager_id = a.line_manager_id\n" +
            "\tJOIN (\n" +
            "\tSELECT kpa_id, kpa_name FROM kpa\n" +
            "\t) c ON c.kpa_id = a.kpa_id\n" +
            "\tJOIN (\n" +
            "\tSELECT kpi_id, kpi_name FROM kpi\n" +
            "\t) b ON b.kpi_id = a.kpi_id\n" +
            "\tWHERE a.assessment_id = :assessmentId ", nativeQuery = true)
    public AssessmentReponse getAssessmentById(@Param("assessmentId") Integer assessmentId);
}
