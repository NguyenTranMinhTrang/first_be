package com.book.books.exception;


import com.book.books.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = RuntimeException.class)
    ResponseEntity<ResponseDto<?>> runtimeExceptionHandler(RuntimeException e) {
        ResponseDto<?> responseDto = new ResponseDto<>();
        responseDto.setMessage(e.getMessage());
        responseDto.setSuccess(false);
        responseDto.setStatusCode(HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.badRequest().body(responseDto);
    }

    @ExceptionHandler(value = AppException.class)
    ResponseEntity<ResponseDto<?>> appExceptionHandler(AppException e) {
        ResponseDto<?> responseDto = new ResponseDto<>();
        ErrorCode errorCode = e.getErrorCode();
        responseDto.setMessage(errorCode.getMessage());
        responseDto.setSuccess(false);
        responseDto.setStatusCode(errorCode.getStatusCode());
        return ResponseEntity.badRequest().body(responseDto);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    ResponseEntity<ResponseDto<?>> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        ResponseDto<?> responseDto = new ResponseDto<>();
        responseDto.setMessage(e.getFieldError().getDefaultMessage());
        responseDto.setSuccess(false);
        responseDto.setStatusCode(HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.badRequest().body(responseDto);
    }
}
