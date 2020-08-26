package com.bcaf.lgd.finalproject.Controller;

import com.bcaf.lgd.finalproject.Entity.Agency;
import com.bcaf.lgd.finalproject.Entity.User;
import com.bcaf.lgd.finalproject.command.SignUp;
import com.bcaf.lgd.finalproject.dao.AgencyDAO;
import com.bcaf.lgd.finalproject.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    @Autowired
    public UserDAO userDAO;

    @Autowired
    public AgencyDAO agencyDAO;

    @GetMapping("/register")
    public String registerUser(SignUp signUp, Model model){
//        UserController user = new UserController();
        model.addAttribute("signUp",signUp);
        return "register";
    }

    @GetMapping("/login")
    public String loginUser(User user, Model model){
        UserController userController = new UserController();
        model.addAttribute("user", user);
        return "login";
    }


    @PostMapping("/addNewUser")
    public String addNewUser( SignUp signUp, Model model){
        User user = new User();
        user.setFirstName(signUp.getFirstName());
        user.setLastName(signUp.getLastName());
        user.setEmail(signUp.getEmail());
        user.setPassword(signUp.getPassword());
        user.setMobileNumber(signUp.getMobileNumber());

        Agency agency = new Agency();
        agency.setAgencyName(signUp.getAgencyName());
        agency.setAgencyDetails(signUp.getAgencyDetails());

        userDAO.save(user);
        agencyDAO.save(agency);
        return "redirect:/";
    }

    @PostMapping("/login/{email}")
    public String loginUser(@PathVariable("email") String email, User user){
        userDAO.save(user);
        return "index";
    }

}
