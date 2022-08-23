package com.pensionerDetail.Advice;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.pensionerDetail.customException.BusinessException;

@RestControllerAdvice
public class PensionerDetailControllerAdvice {

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException iae) {

		return new ResponseEntity<>("Invalid Aadhaar number", HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(FileNotFoundException.class)
	public ResponseEntity<String> handleFileNotFoundException(FileNotFoundException fileNotFoundException) {

		return new ResponseEntity<>("file not found", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(IOException.class)
	public ResponseEntity<String> handleIOException(IOException iOException) {

		return new ResponseEntity<>("Invalid input", HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NumberFormatException.class)
	public ResponseEntity<String> handleNumberFormatException(NumberFormatException numberFormatException) {

		return new ResponseEntity<>("not string", HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<String> handleNullPointerException(NullPointerException nullPointerException) {

		return new ResponseEntity<>("can't be null", HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException noSuchElementException) {

		return new ResponseEntity<>("Invalid", HttpStatus.OK);
	}

	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<String> handleBusinessException(BusinessException businessException) {

		return new ResponseEntity<>(businessException.getErrorMessage(), HttpStatus.BAD_REQUEST);
	}

}
