package tahub.sdapitahub.dto;

public class RoleDTO {
    private Long roleId;
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