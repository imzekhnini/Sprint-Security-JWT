package ds.dms.ss_jwt.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import ds.dms.ss_jwt.entities.AppUser;
import ds.dms.ss_jwt.services.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

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
}
