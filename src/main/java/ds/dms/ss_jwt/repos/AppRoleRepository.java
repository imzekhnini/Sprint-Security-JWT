package ds.dms.ss_jwt.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import ds.dms.ss_jwt.entities.AppRole;

/**
 * AppRoleRepository
 */
public interface AppRoleRepository extends JpaRepository<AppRole, Long> {
  AppRole findByRoleName(String rolename);

}
