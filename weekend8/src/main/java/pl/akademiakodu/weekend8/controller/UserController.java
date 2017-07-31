package pl.akademiakodu.weekend8.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.akademiakodu.weekend8.entity.User;
import pl.akademiakodu.weekend8.service.SecurityService;
import pl.akademiakodu.weekend8.service.UserService;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

/**
 * Created by itml on 11.06.2017.
 */
@Controller
@RequestMapping
public class UserController {

    @Autowired
    private UserService userServiceImpl;

    @Autowired
    private SecurityService securityService;

    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);


    @GetMapping("/register")
    public ModelAndView registration() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("user", new User());
        return mav;
    }

    @PostMapping("/register")
    public ModelAndView registration(@ModelAttribute("user") @Valid User userForm,
                               BindingResult bindingResult) {

        ModelAndView mav = new ModelAndView();

        if (bindingResult.hasErrors()) {
            LOG.info("Errors {}", bindingResult);
            mav.setViewName("register");
            mav.addObject("user", userForm);
        } else {
            LOG.info("No errors");
            userServiceImpl.save(userForm);
            securityService.autoLogin(userForm.getLogin(), userForm.getPasswordConfirm());
            mav.setViewName("redirect:/student");
        }
        return mav;
    }

    @GetMapping("/login")
    public String login(Model model, @PathParam("error") String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }
}
