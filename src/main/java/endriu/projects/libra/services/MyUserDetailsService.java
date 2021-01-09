package endriu.projects.libra.services;

import endriu.projects.libra.dao.UserRepository;
import endriu.projects.libra.model.MyUserDetails;
import endriu.projects.libra.model.Requests.RegistrationRequest;
import endriu.projects.libra.model.User;
import endriu.projects.libra.model.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Optional;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.ignoreCase;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserName(userName);

        if (user.isEmpty()){
            throw new UsernameNotFoundException("Username " + userName + " not found");
        }

        return user.map(MyUserDetails::new).get();
    }

    public void addUser(RegistrationRequest data){
        userRepository.save(
                new User(
                        data.getEmail(),
                        data.getPassword(),
                        data.getName(),
                        data.getSurname(),
                        data.getPhoneNumber(),
                        data.getAddress(),
                        data.getCompanyName(),
                        UserType.valueOf(data.getUserType().toUpperCase(Locale.ENGLISH)),
                        true,
                        "ROLE_USER"
                )
        );
    }

    public boolean exists(String username){
        return userRepository.existsByUserName(username);
    }

    public int getID(String username){
        User a = userRepository.getByUserName(username);
        return a.getId();
    }

    public String getUserById(int id){
        return this.userRepository.getById(id).getUserName();
    }

    public User getUserByEmail(String email) { return this.userRepository.getByUserName(email); }
}
