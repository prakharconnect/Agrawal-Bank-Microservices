package com.Prakhar.Coustomer_Service.Client;


import com.Prakhar.Coustomer_Service.DTOs.CustomerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "auth-service",url = "http://localhost:8082/api/v1/auth")
public interface AuthUserClient {


    @PostMapping("/users")
    String createUser(@RequestBody CustomerResponse customerResponse);
}
