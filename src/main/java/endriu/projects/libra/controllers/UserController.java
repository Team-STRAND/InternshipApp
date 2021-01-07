package endriu.projects.libra.controllers;

import endriu.projects.libra.model.Requests.AuthenticationRequest;
import endriu.projects.libra.model.Requests.RegistrationRequest;
import endriu.projects.libra.model.Responses.AuthenticationResponse;
import endriu.projects.libra.model.Responses.RegistrationResponse;
import endriu.projects.libra.model.exceptions.InvalidInputException;
import endriu.projects.libra.services.MyUserDetailsService;
import endriu.projects.libra.util.JwtUtil;
import endriu.projects.libra.util.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins="*")
@RequestMapping(value = "/user")
public class UserController {


    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        System.out.println("received");
        Validator.validateUser(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        }
        catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }
        catch (Exception exc){
            //System.out.println("no good");
        }

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<?> registerUser(@RequestBody RegistrationRequest registrationRequest) throws Exception{
        System.out.println("entered register");

        Validator.validateUser(registrationRequest.getUsername(), registrationRequest.getPassword());

        boolean exists = userDetailsService.exists(registrationRequest.getUsername());
        System.out.println(exists);
        if (exists){
            throw new InvalidInputException("Username is already in use");
        }

        userDetailsService.addUser(registrationRequest.getUsername(), registrationRequest.getPassword());
        return ResponseEntity.ok(new RegistrationResponse("User added"));
    }

}
