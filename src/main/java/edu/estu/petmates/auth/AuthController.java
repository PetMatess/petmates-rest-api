package edu.estu.petmates.auth;

import com.fasterxml.jackson.annotation.JsonView;
import edu.estu.petmates.shared.CurrentUser;
import edu.estu.petmates.shared.Views;
import edu.estu.petmates.user.User;
import edu.estu.petmates.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/api/auth")
    @JsonView(Views.Base.class)
    ResponseEntity<?> handleAuthentication(@CurrentUser User user){
        return ResponseEntity.ok(user);
    }
}
