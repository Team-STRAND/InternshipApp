package endriu.projects.libra.controllers;

import endriu.projects.libra.model.Requests.AuthenticationRequest;
import endriu.projects.libra.model.Requests.RegistrationRequest;
import endriu.projects.libra.model.Requests.UpdateUserInfoRequest;
import endriu.projects.libra.model.Responses.AuthenticationResponse;
import endriu.projects.libra.model.Responses.SimpleMessageResponse;
import endriu.projects.libra.model.exceptions.InvalidInputException;
import endriu.projects.libra.services.MyUserDetailsService;
import endriu.projects.libra.util.JwtUtil;
import endriu.projects.libra.util.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        Validator.validateUser(authenticationRequest.getEmail(), authenticationRequest.getPassword());

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword())
            );
        }
        catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        return ResponseEntity.ok(
                new AuthenticationResponse(
                        userDetailsService.getUserByEmail(
                                authenticationRequest.getEmail()
                        )
                )
        );
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> registerUser(@RequestBody RegistrationRequest registrationRequest) throws Exception {
        Validator.validateUserDetails(registrationRequest.getName(), registrationRequest.getSurname(),  registrationRequest.getPassword());

        boolean exists = userDetailsService.exists(registrationRequest.getEmail());
        if (exists){
            throw new InvalidInputException("Username is already in use");
        }

        userDetailsService.addUser(registrationRequest);
        return ResponseEntity.ok(new SimpleMessageResponse("User added"));
    }

    @PostMapping("/{userid}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> updateUserInformation(@PathVariable int userid, @RequestBody UpdateUserInfoRequest updateUserInfoRequest) {
        return ResponseEntity.ok(
                this.userDetailsService.updateUserInfo(userid, updateUserInfoRequest)
        );
    }

    @PostMapping("/{userid}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> deleteUser(@PathVariable int userid) {
        this.userDetailsService.deleteUser(userid);
        return ResponseEntity.ok(
                new SimpleMessageResponse("User was successfully deleted.")
        );
    }

    @PostMapping("/resume/{userid}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> uploadResume(@PathVariable int userid, @RequestParam("resume")MultipartFile resume) throws Exception {
        this.userDetailsService.uploadResume(userid, resume);
        return ResponseEntity.ok(
                new SimpleMessageResponse("Resume was successfully uploaded for user with id " + userid + ".")
        );
    }
}
