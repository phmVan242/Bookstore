package com.example.Bookstore.exception;

import com.example.Bookstore.dto.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    //403
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ErrorResponse> handleAccessDenied(
            AccessDeniedException ex,
            HttpServletRequest request
    ) {
        return buildError(
                HttpStatus.FORBIDDEN,
                "You do not have permission",
                request.getRequestURI()
        );
    }

    // ===== 404 - Resource Not Found =====
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFound(
            ResourceNotFoundException ex,
            HttpServletRequest request
    ) {
        return buildError(
                HttpStatus.NOT_FOUND,
                ex.getMessage(),
                request.getRequestURI()
        );
    }

    // ===== 400 - JSON sai format =====
//    @ExceptionHandler(HttpMessageNotReadableException.class)
//    public ResponseEntity<ErrorResponse> handleBadJson(
//            HttpMessageNotReadableException ex,
//            HttpServletRequest request
//    ) {
//        return buildError(
//                HttpStatus.BAD_REQUEST,
//                "Invalid JSON format",
//                request.getRequestURI()
//        );
//    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleBadJson(
            HttpMessageNotReadableException ex,
            HttpServletRequest request
    ) {
        return buildError(
                HttpStatus.BAD_REQUEST,
                ex.getMostSpecificCause().getMessage(),
                request.getRequestURI()
        );
    }
    // ===== 400 - Validation lỗi @Valid =====
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidation(
            MethodArgumentNotValidException ex,
            HttpServletRequest request
    ) {
        String message = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(err -> err.getField() + ": " + err.getDefaultMessage())
                .collect(Collectors.joining(", "));

        return buildError(
                HttpStatus.BAD_REQUEST,
                message,
                request.getRequestURI()
        );
    }

    // ===== 500 - Lỗi hệ thống =====
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ErrorResponse> handleAll(
//            Exception ex,
//            HttpServletRequest request
//    ) {
//        return buildError(
//                HttpStatus.INTERNAL_SERVER_ERROR,
//                "Internal server error",
//                request.getRequestURI()
//        );
//    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleAll(
            Exception ex,
            HttpServletRequest request
    ) {
        ex.printStackTrace(); // 👈 in log

        return buildError(
                HttpStatus.INTERNAL_SERVER_ERROR,
                ex.getMessage(),   // 👈 trả message thật
                request.getRequestURI()
        );
    }

    // ===== Helper build ErrorResponse =====
    private ResponseEntity<ErrorResponse> buildError(
            HttpStatus status,
            String message,
            String path
    ) {
        ErrorResponse error = ErrorResponse.builder()
                .status(status.value())
                .message(message)
                .path(path)
                .timestamp(LocalDateTime.now().toString())
                .build();

        return ResponseEntity.status(status).body(error);
    }
}
