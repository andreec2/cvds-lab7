package co.edu.escuelaing.cvds.lab7.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("/mynewapp")
    public String accessAppOne() {
        return "forward:/mynewapp/index.html";
    }

}
