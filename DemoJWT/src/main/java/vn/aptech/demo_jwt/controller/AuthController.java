/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.demo_jwt.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.aptech.demo_jwt.common.JwtUtils;
import vn.aptech.demo_jwt.dto.JwtResponse;
import vn.aptech.demo_jwt.dto.LoginRequest;
import vn.aptech.demo_jwt.dto.MessageResponse;
import vn.aptech.demo_jwt.dto.SignupRequest;
import vn.aptech.demo_jwt.entity.Role;
import vn.aptech.demo_jwt.entity.User;
import vn.aptech.demo_jwt.service.Impl.UserDetailsImpl;
import vn.aptech.demo_jwt.service.RoleService;
import vn.aptech.demo_jwt.service.UserService;

/**
 *
 * @author Thanh Sang
 */
@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping(value = "/api/auth")
public class AuthController {
    
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserService serviceUser;
    @Autowired
    private RoleService serviceRole;
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private PasswordEncoder encoder;
            
    public ResponseEntity<?> authenticateUser(@Validated @RequestBody LoginRequest request){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));
        System.out.println("user: "+request);
        System.out.println("authenticationL "+authentication);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt= jwtUtils.generateJwtToken(authentication);
        System.out.println("jwt: "+jwt);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities()
                .stream()
                .map((item->item.getAuthority()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), roles));
    }
    
    
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Validated @RequestBody SignupRequest request) {
        if (serviceUser.existsByUsername(request.getUsername())) {
            return ResponseEntity.badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (serviceUser.existsByEmail(request.getEmail())) {
            return ResponseEntity.badRequest()
                    .body(new MessageResponse("Error: Email is already taken!"));
        }

        // không trùng username or email
        User user = new User(request.getUsername(),
                encoder.encode(request.getPassword()), // password được mã hóa
                request.getEmail());

        Set<String> strRoles = request.getRoles();
        Set<Role> roles = new HashSet<>();

        // trường hợp không có role => assign role = "ROLE_USER"
        if (strRoles == null) {
            Role userRole = serviceRole.findByName("ROLE_USER")
                    .orElseThrow(() -> new RuntimeException("Error: Role not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin": {
                        Role adminRole = serviceRole.findByName("ROLE_ADMIN")
                                .orElseThrow(() -> new RuntimeException("Error: Role not found."));
                        roles.add(adminRole);
                        break;
                    }
                    case "mod": {
                        Role modRole = serviceRole.findByName("ROLE_MODERATOR")
                                .orElseThrow(() -> new RuntimeException("Error: Role not found."));
                        roles.add(modRole);
                        break;
                    }
                    default: {
                        Role userRole = serviceRole.findByName("ROLE_USER")
                                .orElseThrow(() -> new RuntimeException("Error: Role not found."));
                        roles.add(userRole);
                    }
                }
            });
        }
        
        user.setRoles((List<Role>)roles);   // gán role
        serviceUser.save(user); // lưu user
        
        return ResponseEntity.ok(new MessageResponse("User registered successfully."));
    }
            
}
