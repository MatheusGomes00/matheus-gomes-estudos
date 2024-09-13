package com.pbCompass.parkApi.web.exception;


import com.pbCompass.parkApi.exception.EntityNotFoundException2;
import com.pbCompass.parkApi.exception.UsernameUniqueViolationException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.hibernate.query.sqm.tree.SqmNode.log;

@RestControllerAdvice  // uma espécie de ouvinte, que captura as exceções em tempo de execução
public class ApiExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage> methodArgumentNotValidException(MethodArgumentNotValidException ex,
                                                                        HttpServletRequest request,
                                                                        BindingResult result){
        log.error("Api Error - ", ex);  // mostrar no log onde a aplicação estourou
        return ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_ENTITY)  // aplicação não consegue processar o objeto lançado pelo cliente
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorMessage(request, HttpStatus.UNPROCESSABLE_ENTITY, "Campo(s) invalido(s)", result));

    }


    @ExceptionHandler(UsernameUniqueViolationException.class)
    public ResponseEntity<ErrorMessage> usernameUniqueViolationException(RuntimeException ex,
                                                                        HttpServletRequest request){
        log.error("Api Error - ", ex);  // mostrar no log onde a aplicação estourou
        return ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_ENTITY)  // aplicação não consegue processar o objeto lançado pelo cliente
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorMessage(request, HttpStatus.CONFLICT, ex.getMessage()));

    }

    @ExceptionHandler(EntityNotFoundException2.class)
    public ResponseEntity<ErrorMessage> entityNotFoundException2(RuntimeException ex,
                                                                         HttpServletRequest request){
        log.error("Api Error - ", ex);  // mostrar no log onde a aplicação estourou
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorMessage(request, HttpStatus.NOT_FOUND, ex.getMessage()));

    }
}
