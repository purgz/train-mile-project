package com.hbrooks.login;

import com.hbrooks.user.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private AuthenticationManager authenticationManager;

    @Autowired
    public LoginController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticateUser(@RequestBody LoginDto loginDto){


        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsername(), loginDto.getPassword()
        ));

        System.out.println(authentication.getName());
        System.out.println(authentication.getAuthorities());
        System.out.println(authentication.getPrincipal());

        LoginResponse loginResponse = new LoginResponse(
                authentication.getName(),
                loginDto.getPassword(),
                authentication.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return new ResponseEntity<>(loginResponse, HttpStatus.OK);
    }
}
