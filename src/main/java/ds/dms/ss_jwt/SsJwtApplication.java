package ds.dms.ss_jwt;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ds.dms.ss_jwt.entities.AppRole;
import ds.dms.ss_jwt.entities.AppUser;
import ds.dms.ss_jwt.services.AccountService;

@SpringBootApplication
public class SsJwtApplication {

  public static void main(String[] args) {
    SpringApplication.run(SsJwtApplication.class, args);
  }

  @Bean
  CommandLineRunner start(AccountService accountService) {
    return args -> {
      accountService.addNewAppRole(new AppRole(null, "USER"));
      accountService.addNewAppRole(new AppRole(null, "ADMIN"));
      accountService.addNewAppRole(new AppRole(null, "STUDENT"));
      accountService.addNewAppRole(new AppRole(null, "TEACHER"));

      accountService.addNewAppUser(new AppUser(null, "teacher1", "1234", new ArrayList<>()));
      accountService.addNewAppUser(new AppUser(null, "teacher2", "1234", new ArrayList<>()));
      accountService.addNewAppUser(new AppUser(null, "student1", "1234", new ArrayList<>()));
      accountService.addNewAppUser(new AppUser(null, "student2", "1234", new ArrayList<>()));
      accountService.addNewAppUser(new AppUser(null, "admin", "1234", new ArrayList<>()));

      accountService.addRoleToUser("teacher1", "USER");
      accountService.addRoleToUser("teacher1", "TEACHER");
      accountService.addRoleToUser("teacher2", "USER");
      accountService.addRoleToUser("teacher2", "TEACHER");
      accountService.addRoleToUser("student1", "USER");
      accountService.addRoleToUser("student1", "STUDENT");
      accountService.addRoleToUser("student2", "USER");
      accountService.addRoleToUser("student2", "STUDENT");
      accountService.addRoleToUser("admin", "USER");
      accountService.addRoleToUser("admin", "ADMIN");
    };
  }
}
