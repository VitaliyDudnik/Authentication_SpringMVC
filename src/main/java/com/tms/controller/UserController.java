package com.tms.controller;

import com.tms.Constants;
import com.tms.entity.User;
import com.tms.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Slf4j
@Transactional
@Controller
@SessionAttributes("user")
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/reg")
    public String registrationGet() {
        return "Registration";
    }

    @PostMapping("/reg")
    public String registrationPost(@Valid User user, BindingResult bindingResult, Model model, SessionStatus session) {

        if (bindingResult.hasErrors()) {
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                model.addAttribute("errorRegistration", fieldError.getDefaultMessage());
            }
            session.setComplete();
            return "Registration";
        }

        boolean existsUser = userService.existsUser(user.getUsername(), user.getPassword());
        try {
            if (existsUser) {
                userService.save(user);
                model.addAttribute("user", userService.getByUsername(user.getUsername()));
                model.addAttribute("welcome", "Welcome " + user.getUsername());
                return "RegUserContent";
            } else {
                model.addAttribute("ExistsUsernamePassword", Constants.ATTRIBUTE_EXISTS_USERNAME_PASS);
                session.setComplete();
                return "Registration";
            }
        } catch (Exception e) {
            log.error("Something going wrong");
        }
        return "Registration";
    }

    @GetMapping("/authorization")
    public String authorizationGet() {
        return "Authorization";
    }

    @PostMapping("/authorization")
    public String authorizationPost(@Valid User user, BindingResult bindingResult, Model model, SessionStatus session) {
        if (bindingResult.hasErrors()) {
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                model.addAttribute("errorAuthorization", fieldError.getDefaultMessage());
            }
            session.setComplete();
            return "Authorization";
        }
        boolean existsUser = userService.existsUser(user.getUsername(), user.getPassword());
        if (existsUser) {
            model.addAttribute("user", userService.getByUsername(user.getUsername()));
            model.addAttribute("welcome", "Welcome " + user.getUsername());
            return "RegUserContent";
        } else {
            model.addAttribute("ExistsUsernamePassword", Constants.ATTRIBUTE_EXISTS_USERNAME_PASS);
            session.setComplete();
            return "Authorization";
        }
    }

    @GetMapping("/updateUsername")
    public String updateUsernameGet() {
        return "updateUsername";
    }

    @PostMapping("/updateUsername")
    public String updateUsernamePost(String newUsername, @Valid User user, BindingResult bindingResult, Model model, SessionStatus session) {
        if (bindingResult.hasErrors()) {
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                model.addAttribute("errorUsernameUpdate", fieldError.getDefaultMessage());
            }
            session.setComplete();
            return "updateUsername";
        }

        boolean existsNewUsername = userService.existsUsername(newUsername);
        boolean existsUser = userService.existsUser(user.getUsername(), user.getPassword());
        try {
            if (!existsNewUsername & existsUser) {
                user = userService.getByUsername(user.getUsername());
                assert user != null;
                userService.updateUsername(newUsername, user.getId());
                session.setComplete();
                model.addAttribute("reLoginUsername", "Please sign in with new username");
                return "Authorization";
            } else {
                model.addAttribute("ExistsUsernamePassword", Constants.ATTRIBUTE_EXISTS_USERNAME_PASS);
                return "updateUsername";
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return "RegUserContent";
    }

    @GetMapping("/updatePassword")
    public String updatePasswordGet() {
        return "updatePassword";
    }

    @PostMapping("/updatePassword")
    public String updatePasswordPost(@Valid User user, BindingResult bindingResult, String newPassword, Model model, SessionStatus session) {
        if (bindingResult.hasErrors()) {
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                model.addAttribute("errorPassword", fieldError.getDefaultMessage());
            }
            session.setComplete();
            return "updateUsername";
        }

        boolean existsUser = userService.existsUser(user.getUsername(), user.getPassword());
        try {
            if (existsUser) {
                user = (User) model.getAttribute("user");
                assert user != null;
                userService.updatePassword(newPassword, user.getId());
                session.setComplete();
                model.addAttribute("reLoginPass", "Please sign in with new password");
                return "Authorization";
            } else {
                model.addAttribute("ExistsUsernamePassword", Constants.ATTRIBUTE_EXISTS_USERNAME_PASS);
                return "updatePassword";
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return "RegUserContent";
    }

    @GetMapping("/removeAccount")
    public String removeAccountGet() {
        return "removeAccount";
    }

    @PostMapping("/removeAccount")
    public String removeAccountPost(Model model, SessionStatus session) {
        User user = (User) model.getAttribute("user");
        assert user != null;
        userService.removeAccount(user.getId());
        session.setComplete();
        return "DefaultPage";
    }

    @PostMapping("/logout")
    public String logoutPost(SessionStatus sessionStatus) {
        try {
            sessionStatus.setComplete();
            return "DefaultPage";
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return "DefaultPage";
    }

    @GetMapping("/account")
    public String accountGet() {
        return "Account";
    }

    @GetMapping("/regContent")
    public String regContentGet() {
        return "RegUserContent";
    }

    @GetMapping("/home")
    public String homePageGet() {
        return "DefaultPage";
    }

    @GetMapping("/notRegistered")
    public String noRegistrationGet() {
        return "notRegistered";
    }
}

