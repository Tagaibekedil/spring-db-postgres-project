package kg.megalab.springbootjpa.exception;

import kg.megalab.springbootjpa.service.serv.MessageByLocaleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@ControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    private final MessageByLocaleService messageSource;

    @ExceptionHandler
    public ResponseEntity<String> exceptionHandler(EmptyListException exception) {
        log.error(messageSource.getMessage(exception.getMessage(),204));
        return new ResponseEntity<>(messageSource.getMessage(exception.getMessage(),204), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    public ResponseEntity<String> exceptionHandler(RuntimeException e) {
        log.error(e.getMessage());
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler
    public ResponseEntity<String>handlerException(MethodArgumentNotValidException e){
        List<FieldError> errors=e.getFieldErrors().stream().limit(1).toList();
        String message=errors.stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining()) ;
        return new ResponseEntity<>(messageSource.getMessage(message),HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
