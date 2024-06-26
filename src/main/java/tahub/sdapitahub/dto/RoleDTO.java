package tahub.sdapitahub.dto;

import javax.validation.constraints.NotNull;

public class RoleDTO {
    @NotNull
    private Long roleId;
    @NotNull
    private String role;

    // Constructor
    public RoleDTO(Long roleId, String role) {
        this.roleId = roleId;
        this.role = role;
    }

    // Getters and setters
    public Long getRoleId() {
        return roleId;
    }

    public String getRole() {
        return role;
    }

}
