package com.greg.cinema.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.greg.cinema.dto.ErrorDetails;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDetails> handleAllExceptions(Exception ex, WebRequest request) {
		ErrorDetails details = new ErrorDetails(LocalDateTime.now(), 
				ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<>(details, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(InvalidDataException.class)
	public final ResponseEntity<ErrorDetails> handleInvalidDataException(Exception ex, WebRequest request) {
		ErrorDetails details = new ErrorDetails(LocalDateTime.now(), 
				ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(RecordNotFoundException.class)
	public final ResponseEntity<ErrorDetails> handleResourceNotFoundEception(Exception ex, WebRequest request) {
		ErrorDetails details = new ErrorDetails(LocalDateTime.now(), 
				ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ReservationTooLateException.class)
	public final ResponseEntity<ErrorDetails> handleReservedTooLateEception(Exception ex, WebRequest request) {
		ErrorDetails details = new ErrorDetails(LocalDateTime.now(), 
				ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<>(details, HttpStatus.CONFLICT);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		
		Map<String, String> errors = new HashMap<>();
		
		errors.put("timestamp", LocalDateTime.now().toString());
		ex.getBindingResult().getAllErrors().forEach((error) ->{
			
			String fieldName = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			errors.put(fieldName, message);
		});
		
		errors.put("description", request.getDescription(false));
		
		return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
	}
}