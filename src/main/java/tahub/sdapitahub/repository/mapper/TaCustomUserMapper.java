package tahub.sdapitahub.repository.mapper;

import org.springframework.jdbc.core.RowMapper;
import tahub.sdapitahub.entity.TaUser;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class TaCustomUserMapper implements RowMapper<TaUser> {
    @Override
    public TaUser mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new TaUser.Builder()
                .userId(rs.getLong("user_id"))
                .roleId(rs.getLong("role_id"))
                .firstName(rs.getString("first_name"))
                .lastName(rs.getString("last_name"))
                .username(rs.getString("username"))
                .email(rs.getString("email"))
                .phone(rs.getString("phone"))
                .build();
    }
}
