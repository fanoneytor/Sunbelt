package com.microservicio.sunbelt.exceptions;

import com.microservicio.sunbelt.exceptions.responses.BadRequestException;
import com.microservicio.sunbelt.exceptions.responses.InternalServerErrorException;
import com.microservicio.sunbelt.exceptions.responses.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
@Slf4j
public class ExceptionResponseHandler extends ResponseEntityExceptionHandler {

    /**
     * Maneja BadRequestException y devuelve una respuesta con estado HTTP 400 (Bad Request).
     *
     * @param ex      La excepción BadRequestException.
     * @param request El objeto WebRequest.
     * @return La respuesta de excepción con estado HTTP 400.
     */
    @ExceptionHandler(BadRequestException.class)
    public final ResponseEntity<ExceptionResponse> handleBadRequestException(BadRequestException ex, WebRequest request) {
        String message = ex.getMessage();
        ExceptionResponse exceptionResponse = new ExceptionResponse(message);
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    /**
     * Maneja NotFoundException y devuelve una respuesta con estado HTTP 404 (Not Found).
     *
     * @param ex      La excepción NotFoundException.
     * @param request El objeto WebRequest.
     * @return La respuesta de excepción con estado HTTP 404.
     */
    @ExceptionHandler(NotFoundException.class)
    public final ResponseEntity<ExceptionResponse> handleNotFoundException(NotFoundException ex, WebRequest request) {
        String message = ex.getMessage();
        ExceptionResponse exceptionResponse = new ExceptionResponse(message);
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    /**
     * Maneja InternalServerErrorException y devuelve una respuesta con estado HTTP 500 (Internal Server Error).
     *
     * @param ex      La excepción InternalServerErrorException.
     * @param request El objeto WebRequest.
     * @return La respuesta de excepción con estado HTTP 500.
     */
    @ExceptionHandler(InternalServerErrorException.class)
    public final ResponseEntity<ExceptionResponse> handleInternalServerErrorException(InternalServerErrorException ex, WebRequest request) {
        String message = ex.getMessage();
        ExceptionResponse exceptionResponse = new ExceptionResponse(message);
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
