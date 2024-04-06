package com.sayak.ErrorHandling;
//   PaymentFailedException.class
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler
    public ResponseEntity<QuantityErrorResponse> handleException(InvalidQuantityException exc) {

        // create a StudentErrorResponse

        QuantityErrorResponse error = new QuantityErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMsg(exc.getMessage());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<CouponErrorResponse>handleException(InvalidCouponException exc){
        CouponErrorResponse error=new CouponErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMsg(exc.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

}
