package com.stefanyEngenheiraDev.cardapioFullstack.controller;

import com.stefanyEngenheiraDev.cardapioFullstack.domain.user.User;
import com.stefanyEngenheiraDev.cardapioFullstack.domain.user.dtos.AuthenticationDTO;
import com.stefanyEngenheiraDev.cardapioFullstack.domain.user.dtos.LoginResponseDTO;
import com.stefanyEngenheiraDev.cardapioFullstack.domain.user.dtos.RegisterDTO;
import com.stefanyEngenheiraDev.cardapioFullstack.infra.security.TokenService;
import com.stefanyEngenheiraDev.cardapioFullstack.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO authenticationDTO ){
        var usernamePassword = new UsernamePasswordAuthenticationToken(authenticationDTO.login(), authenticationDTO.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register (@RequestBody @Valid RegisterDTO registerDTO){
        if(this.userRepository.findByLogin(registerDTO.login()) != null) return  ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(registerDTO.password());
        User newUser = new User(registerDTO.login(), encryptedPassword, registerDTO.role());

        this.userRepository.save(newUser);

        return ResponseEntity.ok().build();
    }
}
