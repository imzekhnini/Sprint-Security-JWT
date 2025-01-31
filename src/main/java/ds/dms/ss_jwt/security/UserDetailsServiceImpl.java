package ds.dms.ss_jwt.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ds.dms.ss_jwt.entities.AppUser;
import ds.dms.ss_jwt.services.AccountService;
import lombok.RequiredArgsConstructor;

/**
 * UserDetailsServiceImpl
 */
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
  public final AccountService accountService;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    AppUser appUser = accountService.loadUserByUsername(username);
    if (appUser == null)
      throw new UsernameNotFoundException("User invalid");
    Collection<GrantedAuthority> authorities = new ArrayList<>();
    appUser.getAppRoles().forEach(role -> {
      authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
    });
    return new User(appUser.getUsername(), appUser.getPassword(), authorities);
  }

}
