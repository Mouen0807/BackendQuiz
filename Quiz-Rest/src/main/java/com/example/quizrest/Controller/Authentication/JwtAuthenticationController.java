package com.example.quizrest.Controller.Authentication;

import DTO.PlayerDTO;
import com.example.quizrest.Configuration.Authentication.JwtRequest;
import com.example.quizrest.Configuration.Authentication.JwtResponse;
import com.example.quizrest.Configuration.Authentication.JwtTokenUtil;
import com.example.quizrest.Controller.CategoryController;
import com.example.quizrest.ServiceImpl.Authentication.JwtUserDetailsService;
import com.example.quizrest.ServiceImpl.PlayerServicesImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;


@RestController
@CrossOrigin
public class JwtAuthenticationController {

    @Autowired
    PlayerServicesImpl playerServicesImpl;
    
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @RequestMapping(value = "/api/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        logger.info("authentication request");

        //authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        PlayerDTO responsePlayerDTO=playerServicesImpl.findByNameAndPassword(authenticationRequest.getUsername(),
                authenticationRequest.getPassword());

        if(responsePlayerDTO==null){
            logger.info("player don't exist in database");
            return ResponseEntity.noContent().build();
        }
        final UserDetails userDetails = new User(authenticationRequest.getUsername(),
                authenticationRequest.getPassword(),
                new ArrayList<>());
        /*userDetailsService.loadUserByUsername(authenticationRequest.getUsername())*/;

        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    @RequestMapping({ "/hello" })
    public String firstPage() {
        return "Hello World";
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}