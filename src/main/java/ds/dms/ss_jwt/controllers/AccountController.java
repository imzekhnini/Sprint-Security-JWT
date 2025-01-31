package ds.dms.ss_jwt.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import ds.dms.ss_jwt.entities.AppRole;
import ds.dms.ss_jwt.entities.AppUser;
import ds.dms.ss_jwt.services.AccountService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * AccountController
 */
@RestController
@RequiredArgsConstructor
public class AccountController {
  public final AccountService accountService;

  @GetMapping("/users")
  public List<AppUser> appUsers() {
    return accountService.listUsers();
  }

  @PostMapping("/users")
  public AppUser saveUser(@RequestBody AppUser appUser) {
    return accountService.addNewAppUser(appUser);
  }

  @PostMapping("/roles")
  public AppRole saveRole(@RequestBody AppRole appRole) {
    return accountService.addNewAppRole(appRole);
  }

  @PostMapping("/addRoleToUser")
  public void addRoleToUser(@RequestBody RoleUserForm roleUserForm) {
    accountService.addRoleToUser(roleUserForm.getUsername(), roleUserForm.getRoleName());
  }
}

@Data
class RoleUserForm {
  private String username;
  private String roleName;
}
