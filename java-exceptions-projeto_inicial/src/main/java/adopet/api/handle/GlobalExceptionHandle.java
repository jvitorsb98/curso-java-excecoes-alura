package adopet.api.handle;


import adopet.api.exceptions.AdocaoException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandle {

    @ExceptionHandler(AdocaoException.class)
    public ResponseEntity<ResponseError> adocaoException(AdocaoException e){
        ResponseError response = new ResponseError(e.getMessage(),HttpStatus.BAD_REQUEST, LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ResponseError> entityNotFoundException(EntityNotFoundException e){
        ResponseError response = new ResponseError(e.getMessage(),HttpStatus.BAD_REQUEST, LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseError> trataException(Exception e){
        ResponseError response = new ResponseError(e.getMessage(),HttpStatus.BAD_REQUEST, LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }


}
