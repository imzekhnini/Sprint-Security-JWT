package ds.dms.ss_jwt.services;

import java.util.List;

import ds.dms.ss_jwt.entities.AppRole;
import ds.dms.ss_jwt.entities.AppUser;

/**
 * AccountService
 */
public interface AccountService {

  AppRole addNewAppRole(AppRole appRole);

  AppUser addNewAppUser(AppUser appUser);

  void addRoleToUser(String username, String roleName);

  AppUser loadUserByUsername(String username);

  List<AppUser> listUsers();

}
