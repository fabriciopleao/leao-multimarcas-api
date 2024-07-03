package com.leaomulti.leaocentermultimarcas.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.leaomulti.leaocentermultimarcas.exception.CadastroVeicularException.BlankFieldException;
import com.leaomulti.leaocentermultimarcas.exception.CadastroVeicularException.InvalidBrandModelException;
import com.leaomulti.leaocentermultimarcas.exception.CadastroVeicularException.InvalidFuelException;
import com.leaomulti.leaocentermultimarcas.exception.CadastroVeicularException.InvalidYearModelException;

@ControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(BlankFieldException.class)
		public ResponseEntity<Object> handleBlankFieldException(BlankFieldException ex, WebRequest request) {
			ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST, ex.getMessage(), request.getDescription(false));
			return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InvalidBrandModelException.class)
		public ResponseEntity<Object> handleInvalidBrandModelException(InvalidBrandModelException ex, WebRequest request) {
		ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST, ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InvalidYearModelException.class)
		public ResponseEntity<Object> handleInvalidYearModelException(InvalidYearModelException ex, WebRequest request) {
		ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST, ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InvalidFuelException.class)
		public ResponseEntity<Object> handleInvalidFuelException(InvalidFuelException ex, WebRequest request) {
		ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST, ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
	
}
