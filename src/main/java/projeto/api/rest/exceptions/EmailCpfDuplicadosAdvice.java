package projeto.api.rest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class EmailCpfDuplicadosAdvice {

    @ResponseBody
    @ExceptionHandler(EmailCpfDuplicadosException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    String handler(EmailCpfDuplicadosException ex) {
        return ex.getMessage();
    }
}
