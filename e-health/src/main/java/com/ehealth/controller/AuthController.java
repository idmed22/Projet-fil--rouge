package com.ehealth.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.ehealth.entity.ERole;
import com.ehealth.entity.Patient;
import com.ehealth.entity.Role;
import com.ehealth.entity.User;
import com.ehealth.payload.request.LoginRequest;
import com.ehealth.payload.request.SignupRequest;
import com.ehealth.payload.response.JwtResponse;
import com.ehealth.payload.response.MessageResponse;
import com.ehealth.repository.PatientRepository;
import com.ehealth.repository.RoleRepository;
import com.ehealth.repository.UserRepository;
import com.ehealth.security.jwt.JwtUtils;
import com.ehealth.security.service.UserDetailsImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
		  @Autowired
		  AuthenticationManager authenticationManager;
	
		  @Autowired
		  UserRepository userRepository;
	
		  @Autowired
		  RoleRepository roleRepository;
	
		  @Autowired
		  PasswordEncoder encoder;
	
		  @Autowired
		  JwtUtils jwtUtils;
		  
		  @PostMapping("/signin")
		  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		    Authentication authentication = authenticationManager.authenticate(
		        new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		    SecurityContextHolder.getContext().setAuthentication(authentication);
		    String jwt = jwtUtils.generateJwtToken(authentication);
		    
		    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();    
		    List<String> roles = userDetails.getAuthorities().stream()
		        .map(item -> item.getAuthority())
		        .collect(Collectors.toList());

		    return ResponseEntity.ok(new JwtResponse(jwt, 
		                         userDetails.getId(), 
		                         userDetails.getUsername(), 
		                         userDetails.getEmail(), 
		                         roles));
		  }
		  
		  
		  @PostMapping("/signup")
		  public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		    if (userRepository.existsByUsername(signUpRequest.getUsername())) {
		      return ResponseEntity
		          .badRequest()
		          .body(new MessageResponse("Error: Username is already taken!"));
		    }

		    if (userRepository.existsByEmail(signUpRequest.getEmail())) {
		      return ResponseEntity
		          .badRequest()
		          .body(new MessageResponse("Error: Email is already in use!"));
		    }
		    
		    
		    
		    User user = new User(signUpRequest.getNom(),
		    		    signUpRequest.getPrenom(),
		               signUpRequest.getUsername(), 
		               signUpRequest.getEmail(),
		              
                 encoder.encode(signUpRequest.getPassword()));
		    
		    


		    // Create new user's account
		    Patient patient =  new  Patient(signUpRequest.getNom(),
		                           signUpRequest.getPrenom(),
		    		               signUpRequest.getUsername(), 
					               signUpRequest.getEmail(),
					               signUpRequest.getAdresse(),
					               signUpRequest.getDateNaissance(),
		                           signUpRequest.getGender(),
		                           signUpRequest.getTel(),
		                           signUpRequest.getVille(),
		               encoder.encode(signUpRequest.getPassword()));

		    Set<String> strRoles = signUpRequest.getRole();
		    Set<Role> roles = new HashSet<>();

		    if (strRoles == null) {
		      Role patientRole = roleRepository.findByName(ERole.ROLE_PATIENT)
		          .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		      roles.add(patientRole);
		      patient.setRole(roles);
		      userRepository.save(patient);
			   
		    } else {
		      strRoles.forEach(role -> {
		        switch (role) {
		        case "admin":
		          Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
		              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		          roles.add(adminRole);
		          user.setRole(roles);
			      userRepository.save(user);
		          
		          break;
		        default:
		          Role patientRole = roleRepository.findByName(ERole.ROLE_PATIENT)
		              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		          roles.add(patientRole);
		          patient.setRole(roles);
		          userRepository.save(patient);
		          
		          
		          // add other roles here !!!!!!!!
		        }
		      });
		    }

		   

		    return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
		  }
		  
		  
	  

}
