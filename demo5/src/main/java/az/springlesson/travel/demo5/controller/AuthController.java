package az.springlesson.travel.demo5.controller;

import az.springlesson.travel.demo5.dto.AuthRequestDTO;
import az.springlesson.travel.demo5.dto.UserRequest;
import az.springlesson.travel.demo5.dto.response.JwtResponse;
import az.springlesson.travel.demo5.entities.UserEntity;
import az.springlesson.travel.demo5.services.inter.UserService;
import az.springlesson.travel.demo5.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    private UserService userService;


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserRequest user) {
        UserEntity existingUser =  userService.findUserByEmail(user.getEmail());
        if (existingUser != null) {
            return ResponseEntity.ok("User is already exist");
        } else {
            UserEntity userEntity = UserEntity.builder().role(user.getRole()).username(user.getUsername())
                    .email(user.getEmail()).password(user.getPassword()).age(user.getAge()).id(user.getId()).build();
            return ResponseEntity.ok(userService.registerUser(userEntity));
        }


    }

    @PostMapping("/login")
    public JwtResponse AuthenticateAndGetToken(@RequestBody AuthRequestDTO authRequestDTO) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequestDTO.getUsername(), authRequestDTO.getPassword()));
        if (authentication.isAuthenticated()) {
            return JwtResponse.builder()
                    .accessToken(jwtUtil.generateToken(authRequestDTO.getUsername())).build();
        } else {
            throw new UsernameNotFoundException("invalid user request..!!");
        }
    }
}

