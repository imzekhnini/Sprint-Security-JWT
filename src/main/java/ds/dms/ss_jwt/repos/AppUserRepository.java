package ds.dms.ss_jwt.repos;

/**
 * AppUserRepository
 */
import org.springframework.data.jpa.repository.JpaRepository;

import ds.dms.ss_jwt.entities.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
  AppUser findByUsername(String username);
}
