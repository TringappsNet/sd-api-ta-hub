package tahub.sdapitahub.repository.mapper.Task;

import org.springframework.jdbc.core.RowMapper;
import tahub.sdapitahub.entity.Task;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class TaskMapper implements RowMapper<Task> {
    @Override
    public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Task.Builder()
                .taskId(rs.getLong("task_id"))
                .jobId(rs.getLong("job_id"))
                .jobTitle(rs.getString("job_title"))
                .roleType(rs.getString("role_type"))
                .modeOfWork(rs.getString("mode_of_work"))
                .workLocation(rs.getString("work_location"))
                .yearsOfExperienceRequired(rs.getInt("years_of_experience_required"))
                .primarySkillSet(rs.getString("primary_skill_set"))
                .secondarySkillSet(rs.getString("secondary_skill_set"))
                .clientBudget(rs.getString("client_budget"))
                .assignedBudget(rs.getString("assigned_budget"))
                .primaryAssignee(rs.getString("primary_assignee"))
                .secondaryAssignee(rs.getString("secondary_assignee"))
                .taskStatus(rs.getString("task_status"))
                .backlogs(rs.getBoolean("backlogs"))
                .approvalStatus(rs.getBoolean("approval_status"))
                .description(rs.getString("description"))
                .createdAt(rs.getObject("created_at", LocalDateTime.class))
                .lastUpdated(rs.getObject("last_updated", LocalDateTime.class))
                .columnId(rs.getString("column_id"))
                .build();
    }

}
