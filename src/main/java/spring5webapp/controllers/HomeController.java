package spring5webapp.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Value("${messages.home:default-value}")
    private final String message = "Hello World";

    @RequestMapping("/")
    public String welcome(Model model) {
        log.info("Spring Boot Thymeleaf Configuration Example");
        model.addAttribute("message", message);
        return "home";
    }
}
