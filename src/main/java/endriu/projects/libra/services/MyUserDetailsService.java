package endriu.projects.libra.services;

import endriu.projects.libra.dao.UserRepository;
import endriu.projects.libra.model.MyUserDetails;
import endriu.projects.libra.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

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

    public void addUser(String username, String name, String surname, String password){
        userRepository.save(new User(username, password, name, surname, true, "ROLE_USER"));
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
}
