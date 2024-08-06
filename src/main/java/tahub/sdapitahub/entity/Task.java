package tahub.sdapitahub.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.time.LocalDateTime;

@JsonDeserialize(builder = Task.Builder.class)
public class Task {
    private Long taskId;
    private long jobId;
    private String jobTitle;
    private String roleType;
    private String modeOfWork;
    private String workLocation;
    private int yearsOfExperienceRequired;
    private String primarySkillSet;
    private String secondarySkillSet;
    private String clientBudget;
    private String assignedBudget;
    private String primaryAssignee;
    private String taskStatus;
    private String secondaryAssignee;
    private Boolean approvalStatus;
    private boolean backlogs;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime lastUpdated;

    private String clientName;
    private String columnId;

    // Private constructor to enforce builder usage
    private Task(Builder builder) {
        this.taskId = builder.taskId;
        this.jobId = builder.jobId;
        this.jobTitle = builder.jobTitle;
        this.roleType = builder.roleType;
        this.modeOfWork = builder.modeOfWork;
        this.workLocation = builder.workLocation;
        this.yearsOfExperienceRequired = builder.yearsOfExperienceRequired;
        this.primarySkillSet = builder.primarySkillSet;
        this.secondarySkillSet = builder.secondarySkillSet;
        this.clientBudget = builder.clientBudget;
        this.assignedBudget = builder.assignedBudget;
        this.primaryAssignee = builder.primaryAssignee;
        this.secondaryAssignee = builder.secondaryAssignee;
        this.taskStatus = builder.taskStatus;
        this.backlogs = builder.backlogs;
        this.approvalStatus = builder.approvalStatus;
        this.description = builder.description;
        this.createdAt = builder.createdAt;
        this.lastUpdated = builder.lastUpdated;

        this.clientName = builder.clientName;
        this.columnId = builder.columnId;
    }

    // Getters and Setters


    public String getColumnId() {
        return columnId;
    }

    public void setColumnId(String columnId) {
        this.columnId = columnId;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public long getJobId() {
        return jobId;
    }

    public void setJobId(long jobId) {
        this.jobId = jobId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public String getModeOfWork() {
        return modeOfWork;
    }

    public void setModeOfWork(String modeOfWork) {
        this.modeOfWork = modeOfWork;
    }

    public String getWorkLocation() {
        return workLocation;
    }

    public void setWorkLocation(String workLocation) {
        this.workLocation = workLocation;
    }

    public int getYearsOfExperienceRequired() {
        return yearsOfExperienceRequired;
    }

    public void setYearsOfExperienceRequired(int yearsOfExperienceRequired) {
        this.yearsOfExperienceRequired = yearsOfExperienceRequired;
    }

    public String getPrimarySkillSet() {
        return primarySkillSet;
    }

    public void setPrimarySkillSet(String primarySkillSet) {
        this.primarySkillSet = primarySkillSet;
    }

    public String getSecondarySkillSet() {
        return secondarySkillSet;
    }

    public void setSecondarySkillSet(String secondarySkillSet) {
        this.secondarySkillSet = secondarySkillSet;
    }

    public String getAssignedBudget() {
        return assignedBudget;
    }

    public void setAssignedBudget(String assignedBudget) {
        this.assignedBudget = assignedBudget;
    }

    public String getClientBudget() {
        return clientBudget;
    }

    public void setClientBudget(String clientBudget) {
        this.clientBudget = clientBudget;
    }

    public String getPrimaryAssignee() {
        return primaryAssignee;
    }

    public void setPrimaryAssignee(String primaryAssignee) {
        this.primaryAssignee = primaryAssignee;
    }

    public String getSecondaryAssignee() {
        return secondaryAssignee;
    }

    public void setSecondaryAssignee(String secondaryAssignee) {
        this.secondaryAssignee = secondaryAssignee;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public boolean isBacklogs() {
        return backlogs;
    }

    public void setBacklogs(boolean backlogs) {
        this.backlogs = backlogs;
    }
    public Boolean getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(Boolean approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }


    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }


    // Builder class
    @JsonPOJOBuilder(withPrefix = "")
    public static class Builder {
        private Long taskId;
        private long jobId;
        private String jobTitle;
        private String roleType;
        private String modeOfWork;
        private String workLocation;
        private int yearsOfExperienceRequired;
        private String primarySkillSet;
        private String secondarySkillSet;
        private String clientBudget;
        private String assignedBudget;
        private String primaryAssignee;
        private String secondaryAssignee;
        private String taskStatus;
        private boolean backlogs;
        private Boolean approvalStatus;
        private String description;
        private LocalDateTime createdAt;
        private LocalDateTime lastUpdated;

        private String clientName;
        private String columnId;

        public Builder taskId(Long taskId) {
            this.taskId = taskId;
            return this;
        }

        public Builder jobId(long jobId) {
            this.jobId = jobId;
            return this;
        }

        public Builder jobTitle(String jobTitle) {
            this.jobTitle = jobTitle;
            return this;
        }

        public Builder roleType(String roleType) {
            this.roleType = roleType;
            return this;
        }

        public Builder modeOfWork(String modeOfWork) {
            this.modeOfWork = modeOfWork;
            return this;
        }

        public Builder workLocation(String workLocation) {
            this.workLocation = workLocation;
            return this;
        }

        public Builder yearsOfExperienceRequired(int yearsOfExperienceRequired) {
            this.yearsOfExperienceRequired = yearsOfExperienceRequired;
            return this;
        }

        public Builder primarySkillSet(String primarySkillSet) {
            this.primarySkillSet = primarySkillSet;
            return this;
        }

        public Builder secondarySkillSet(String secondarySkillSet) {
            this.secondarySkillSet = secondarySkillSet;
            return this;
        }

        public Builder clientBudget(String clientBudget) {
            this.clientBudget = clientBudget;
            return this;

        }public Builder assignedBudget(String assignedBudget) {
            this.assignedBudget = assignedBudget;
            return this;
        }


        public Builder primaryAssignee(String primaryAssignee) {
            this.primaryAssignee = primaryAssignee;
            return this;
        }

        public Builder secondaryAssignee(String secondaryAssignee) {
            this.secondaryAssignee = secondaryAssignee;
            return this;
        }


        public Builder taskStatus(String taskStatus) {
            this.taskStatus = taskStatus;
            return this;
        }

        public Builder backlogs(boolean backlogs) {
            this.backlogs = backlogs;
            return this;
        }

        public Builder approvalStatus(Boolean approvalStatus) {
            this.approvalStatus = approvalStatus;
            return this;
        }
        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder lastUpdated(LocalDateTime lastUpdated) {
            this.lastUpdated = lastUpdated;
            return this;
        }

        public Builder clientName(String clientName) {
            this.clientName = clientName;
            return this;
        }

        public Builder columnId(String columnId) {
            this.columnId = columnId;
            return this;
        }

        public Task build() {
            return new Task(this);
        }
    }
}
