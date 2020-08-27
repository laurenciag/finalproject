package com.bcaf.lgd.finalproject.Controller;

import com.bcaf.lgd.finalproject.Entity.Agency;
import com.bcaf.lgd.finalproject.Entity.User;
import com.bcaf.lgd.finalproject.command.SignUp;
import com.bcaf.lgd.finalproject.dao.AgencyDAO;
import com.bcaf.lgd.finalproject.dao.RoleDAO;
import com.bcaf.lgd.finalproject.dao.UserDAO;
import org.apache.catalina.security.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    @Autowired
    private UserDAO userDAO;

    @Autowired
    private AgencyDAO agencyDAO;

    @Autowired
    private RoleDAO roleDAO;

    @GetMapping("/register")
    public String registerUser(SignUp signUp, Model model) {
//        UserController user = new UserController();
        model.addAttribute("signUp", signUp);
        return "register";
    }

    @GetMapping("/login")
    public String loginUser(User user, Model model) {
        UserController userController = new UserController();
        model.addAttribute("user", user);
        return "login";
    }


    @PostMapping("/addNewUser")
    public String addNewUser(SignUp signUp, Model model) {
        User user = new User();
        user.setFirstName(signUp.getFirstName());
        user.setLastName(signUp.getLastName());
        user.setEmail(signUp.getEmail());
        user.setPassword((signUp.getPassword()));
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
        return "redirect:/";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPage(@RequestParam(value = "error", required = false) String error,
                            @RequestParam(value = "logout", required = false) String logout,
                            Model model) {
        String errorMessge = null;
        if (error != null) {
            errorMessge = "Username or Password is incorrect !!";
        }
        if (logout != null) {
            errorMessge = "You have been successfully logged out !!";
        }
        model.addAttribute("errorMessge", errorMessge);
        return "login";
    }
}



