package com.Prakhar.Auth_Service.Controller;


import com.Prakhar.Auth_Service.DTO.UserRequest;
import com.Prakhar.Auth_Service.service.Auth_service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private  Auth_service authService;

    public AuthController(Auth_service authService) {
        this.authService = authService;
    }

    @PostMapping("/users")
    public ResponseEntity<String> createUser(@RequestBody UserRequest userRequest) {
        // 🎯 सर्विस अब हमें "auth0|..." वाली ID रिटर्न करेगी
        String auth0UserId = authService.createUserInAuth0(userRequest);

        // सीधा ID वापस भेजो ताकि Feign Client इसे पढ़ सके
        return ResponseEntity.ok(auth0UserId);
    }
}
