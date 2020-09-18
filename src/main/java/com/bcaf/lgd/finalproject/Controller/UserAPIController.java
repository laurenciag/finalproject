package com.bcaf.lgd.finalproject.Controller;

import com.bcaf.lgd.finalproject.Entity.Agency;
import com.bcaf.lgd.finalproject.Entity.User;
import com.bcaf.lgd.finalproject.command.SignUp;
import com.bcaf.lgd.finalproject.dao.AgencyDAO;
import com.bcaf.lgd.finalproject.dao.CreateJWT;
import com.bcaf.lgd.finalproject.dao.RoleDAO;
import com.bcaf.lgd.finalproject.dao.UserDAO;
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
    public String login(String email, String password) throws JsonProcessingException{
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
}


