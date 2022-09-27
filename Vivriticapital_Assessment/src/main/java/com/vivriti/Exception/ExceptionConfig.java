package com.vivriti.Exception;

import com.vivriti.pojo.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionConfig {
    @ExceptionHandler({CustomException.class})
    public ResponseEntity<Object> handleCustomError(CustomException customException){
        String custom = customException.getMessage();
        System.out.println(custom);
        return new ResponseEntity<>(
                Error.builder().status("failed").reason(custom).build()
                , HttpStatus.BAD_REQUEST);
    }
}
