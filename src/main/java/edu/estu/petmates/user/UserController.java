package edu.estu.petmates.user;

import edu.estu.petmates.shared.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/api/users")
    public GenericResponse createUser(@Valid @RequestBody User user){
        userService.save(user);
        return new GenericResponse("user created");
    }



        /*@ExceptionHandler(MethodArgumentNotValidException.class)
        @ResponseStatus(HttpStatus.BAD_REQUEST)
        public ApiError handleValidationException(MethodArgumentNotValidException exception){
            ApiError error = new ApiError(400,"Validation error", "/api/users");
            Map<String, String> validationErrors = new HashMap<>();

            for (FieldError fieldError : exception.getBindingResult().getFieldErrors()){
                validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
            error.setValidationErrors(validationErrors);
            return error;
    }*/
}
