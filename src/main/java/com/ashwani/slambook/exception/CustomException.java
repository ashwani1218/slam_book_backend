/**
 * 
 */
package com.ashwani.slambook.exception;

import org.springframework.http.HttpStatus;

/**
 *
 * @author Ashwani Pandey
 *
 * createdAt 16-May-2020
 *
*/

public class CustomException extends RuntimeException {
	
	@Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }

    private static final long serialVersionUID = 1L;

    private final String message;
    private final HttpStatus httpStatus;

    public CustomException(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

}