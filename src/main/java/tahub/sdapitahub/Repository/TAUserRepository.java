package tahub.sdapitahub.Repository;

import org.springframework.data.jpa.repository.Query;
import tahub.sdapitahub.Entity.TAUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository public interface TAUserRepository extends JpaRepository<TAUser, Long> {
    @Query("SELECT u FROM TAUser u WHERE u.email = :email")
    TAUser findByEmail(String email);

    TAUser findByResetToken(String resetPasswordToken);
}