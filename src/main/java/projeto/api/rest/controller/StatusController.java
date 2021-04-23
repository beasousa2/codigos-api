package projeto.api.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {

    @GetMapping(path = "/api/status")// informa que é um metodo que vai ser executado quando houver requisição
    public String check(){
        return "Online";
    }
}