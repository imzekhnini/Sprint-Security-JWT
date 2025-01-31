package ds.dms.ss_jwt.services;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ds.dms.ss_jwt.entities.AppRole;
import ds.dms.ss_jwt.entities.AppUser;
import ds.dms.ss_jwt.repos.AppRoleRepository;
import ds.dms.ss_jwt.repos.AppUserRepository;
import lombok.RequiredArgsConstructor;

/**
 * AccountServiceImpl
 *
 */
@Service
@Transactional
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
  public final AppUserRepository appUserRepository;
  public final AppRoleRepository appRoleRepository;
  public final PasswordEncoder passwordEncoder;

  @Override
  public AppRole addNewAppRole(AppRole appRole) {
    return appRoleRepository.save(appRole);
  }

  @Override
  public AppUser addNewAppUser(AppUser appUser) {
    String pw = appUser.getPassword();
    appUser.setPassword(passwordEncoder.encode(pw));
    return appUserRepository.save(appUser);
  }

  @Override
  public void addRoleToUser(String username, String roleName) {
    AppUser user = appUserRepository.findByUsername(username);
    AppRole role = appRoleRepository.findByRoleName(roleName);

    user.getAppRoles().add(role);
  }

  @Override
  public List<AppUser> listUsers() {
    return appUserRepository.findAll();
  }

  @Override
  public AppUser loadUserByUsername(String username) {
    return appUserRepository.findByUsername(username);
  }

}
