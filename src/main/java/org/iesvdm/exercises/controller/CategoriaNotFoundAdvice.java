package org.iesvdm.exercises.controller;

import org.iesvdm.exercises.exception.CategoriaNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CategoriaNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(CategoriaNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String categoriaNotFoundHandler(CategoriaNotFoundException categoriaNotFoundException) {
        return categoriaNotFoundException.getMessage();
    }

}
