package pl.michalgubanski.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import pl.michalgubanski.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by U6041021 on 10/01/2017.
 */
@Repository
public class AuthUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository users;
    private org.springframework.security.core.userdetails.User userdetails;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        pl.michalgubanski.model.User user = getUserDetail(username);

        userdetails = new User(
                user.getLogin(),
                user.getPassword(),
                enabled,
                accountNonExpired,
                credentialsNonExpired,
                accountNonLocked,
                getAuthorities(user.getRole())
        );
        return userdetails;
    }

    public List<GrantedAuthority> getAuthorities(Integer role) {

        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
        if ( role == 1 ) {
            authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        } else if ( role == 2 ) {
            authList.add(new SimpleGrantedAuthority("ROLE_USER"));
        }
        return authList;
    }

    private pl.michalgubanski.model.User getUserDetail(String username) {

        pl.michalgubanski.model.User user = users.findByLogin(username);
        return user;
    }
}
