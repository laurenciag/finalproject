package com.bcaf.lgd.finalproject.Controller;

import com.bcaf.lgd.finalproject.Entity.Agency;
import com.bcaf.lgd.finalproject.Entity.User;
import com.bcaf.lgd.finalproject.Request.JWToken;
import com.bcaf.lgd.finalproject.command.SignUp;
import com.bcaf.lgd.finalproject.dao.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.management.ObjectName;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api")
public class UserAPIController {
    @Autowired
    private UserDAO userDAO;

    @Autowired
    private AgencyDAO agencyDAO;

    @Autowired
    private RoleDAO roleDAO;

    @Bean
    public BCryptPasswordEncoder pass() {
        return new BCryptPasswordEncoder();
    }

    @Autowired BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/createAccount")
    public HttpStatus createAccount(@RequestBody SignUp signUp) {
        User user = new User();
        user.setFirstName(signUp.getFirstName());
        user.setLastName(signUp.getLastName());
        user.setEmail(signUp.getEmail());
        user.setMobileNumber(signUp.getMobileNumber());
        user.setRoles(roleDAO.getIdByRole("admin").getId());
//        user.setPassword(signUp.getPassword());
        user.setPassword(pass().encode(signUp.getPassword()));
        userDAO.save(user);

        Agency agency = new Agency();
        agency.setAgencyName(signUp.getAgencyName());
        agency.setAgencyDetails(signUp.getAgencyDetails());
        agency.setOwner(user.getId());
//        agency.setCode(agency.getCode());
        agencyDAO.save(agency);
        return HttpStatus.OK;
    }

    @PostMapping("/checkEmail")
    public String checkEmailUser(@RequestBody SignUp signUp) throws JsonProcessingException {
        User user = userDAO.getEmail(signUp.getEmail());
        if (user == null)
            user = new User();
        ObjectMapper Obj = new ObjectMapper();
        String rs = Obj.writeValueAsString(user);
        return rs;
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, String password) throws JsonProcessingException{
        User user = userDAO.getEmail(email);
        Agency agency = agencyDAO.getAgencyByUserId(user.getId());

        String encoded = pass().encode(password);
        System.out.println(encoded);

        if (pass().matches(password, user.getPassword())) {
            String JWT = new CreateJWT()
//                    .buildJWT(user.getId(), user.getEmail(), "login", 1000000);
            .buildJWT(user, agency.getId());
            ObjectMapper Obj = new ObjectMapper(); // as scanner
            ObjectNode userResponse = Obj.createObjectNode(); // as new node/object from scanner before
//            String rs = Obj.writeValueAsString(JWT);
            userResponse.put("data",JWT);
            String rs = Obj.writerWithDefaultPrettyPrinter().writeValueAsString(userResponse);
            return rs;
        }
        else{
            return "error";
        }
    }

    @PostMapping("/updateUser")
    public String agencyUser(@RequestBody User us, HttpServletRequest request) throws JsonProcessingException {
        HttpSession session = request.getSession(true);
        String userId = (String) session.getAttribute("connectedUser");

        User user = userDAO.findById(userId).get();
        user.setFirstName(us.getFirstName());
        user.setLastName(us.getLastName());
        user.setEmail(us.getEmail());
        user.setMobileNumber(us.getMobileNumber());
        userDAO.save(user);

        ObjectMapper Obj = new ObjectMapper();
        String rs = Obj.writeValueAsString(user);
        return rs;
    }

    @PutMapping("/updatePassword")
    public String updatePassword(@RequestBody User us, HttpServletRequest request) throws JsonProcessingException{
        HttpSession session = request.getSession(true);
        String userId = (String) session.getAttribute("connectedUser");

        User user = userDAO.findById(userId).get();
        user.setPassword(pass().encode(us.getPassword()));
        userDAO.save(user);

        ObjectMapper Obj = new ObjectMapper();
        String rs = Obj.writeValueAsString(user);
        return rs;
    }

    @PostMapping("/v1/createAccount")
    public HttpStatus createApiAccount(@RequestBody SignUp signUp) throws JsonProcessingException{
        User user = new User();
        user.setFirstName(signUp.getFirstName());
        user.setLastName(signUp.getLastName());
        user.setEmail(signUp.getEmail());
        user.setMobileNumber(signUp.getMobileNumber());
        user.setRoles(roleDAO.getIdByRole("admin").getId());
//        user.setPassword(signUp.getPassword());
        user.setPassword(pass().encode(signUp.getPassword()));
        userDAO.save(user);

        Agency agency = new Agency();
        agency.setAgencyName(signUp.getAgencyName());
        agency.setAgencyDetails(signUp.getAgencyDetails());
        agency.setOwner(user.getId());
//        agency.setCode(agency.getCode());
        agencyDAO.save(agency);
        return HttpStatus.OK;
    }

    @GetMapping("/v1/getUser")
    public String getApiUser(@RequestParam(name="id") String id) throws JsonProcessingException{
        String userId = id;
        User user = userDAO.findById(userId).get();

        ObjectMapper Obj = new ObjectMapper();
        String rs = Obj.writeValueAsString(user);
        return rs;
    }

    @PutMapping("/v1/updateUser")
    public String updateApiUser(@RequestBody User us, @RequestParam String id) throws JsonProcessingException{
//        String userId = id;
//        System.out.println("test");

        User user = userDAO.findById(id).get();
        user.setFirstName(us.getFirstName());
        user.setLastName(us.getLastName());
        user.setEmail(us.getEmail());
        user.setMobileNumber(us.getMobileNumber());
        userDAO.save(user);

        ObjectMapper Obj = new ObjectMapper();
        String rs = Obj.writeValueAsString(user);
        return rs;
    }

    @PutMapping("/v1/updatePassword")
    public String updateApiPassword(@RequestBody User us) throws JsonProcessingException{
        User user = userDAO.findById(us.getId()).get();

        user.setPassword(bCryptPasswordEncoder.encode(us.getPassword()));
        userDAO.save(user);

        ObjectMapper Obj = new ObjectMapper();
        String rs = Obj.writeValueAsString(user);
        return rs;
    }
    
    @GetMapping("/v1/checkEmailByUserId")
    public String checkEmailByUserId(@RequestBody User us) throws JsonProcessingException{
        User user = userDAO.findById(us.getEmail()).get();

        ObjectMapper Obj = new ObjectMapper();
        String rs = Obj.writeValueAsString(user);
        return rs;
    }

    @PostMapping("user/login")
    public String loginAndroid(@RequestParam String email,String password) throws JsonProcessingException{
        User user = userDAO.getEmail(email);
        String encoded = pass().encode(password);
        System.out.println(encoded);
        if(pass().matches(password,user.getPassword())){
            ObjectMapper obj= new ObjectMapper();
            Agency agency=agencyDAO.getAgencyByUserId(user.getId());
            JWToken jwtoken = new JWToken();
            jwtoken.setAgencyId(agency.getId());
            jwtoken.setUserEmail(user.getEmail());
            jwtoken.setUserId(user.getId());
            jwtoken.setUserName(user.getFirstName()+" "+user.getLastName());
            String iss = obj.writeValueAsString(jwtoken);
            String JWT = new BuildJWT()
                    .buildJWTAndro(user.getId(),iss,"login",1000000);
            String rs = obj.writeValueAsString(JWT);
            return rs;
        }
        else{
            return "error";
        }
    }

    @PostMapping("user/createUser")
    public HttpStatus createAccountAndroid(@RequestBody SignUp signUp) throws JsonProcessingException{
        User user = new User();
        user.setFirstName(signUp.getFirstName());
        user.setLastName(signUp.getLastName());
        user.setEmail(signUp.getEmail());
        user.setMobileNumber(signUp.getMobileNumber());
        user.setRoles(roleDAO.getIdByRole("admin").getId());
        user.setPassword(pass().encode(signUp.getPassword()));
        userDAO.save(user);

        return HttpStatus.OK;
    }

    @PostMapping("user/getUserById")
    public String checkEmailFromUserId(@RequestParam String userId) throws JsonProcessingException{
        User us = userDAO.findById(userId).get();

        ObjectMapper Obj = new ObjectMapper();
        String rs = Obj.writeValueAsString(us);
        return rs;
    }

    @PostMapping("user/checkEmailUserByUser")
    public String checkEmailByUserEmail(@RequestBody User user) throws JsonProcessingException{
        User us = userDAO.getEmail(user.getEmail());

        if(us == null)
            us = new User();

        ObjectMapper Obj = new ObjectMapper();
        String rs = Obj.writeValueAsString(us);
        return rs;
    }
}


