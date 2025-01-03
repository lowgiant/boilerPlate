package org.example.hexagonal.libs.common;

import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class ErrorResponse {
	private final List<StackTraceElement> stackTraces;
	private final String message;
	private final HttpStatus status;

	public ErrorResponse(List<StackTraceElement> stackTraces, String message, HttpStatus status) {
		this.stackTraces = stackTraces;
		this.message = message;
		this.status = status;
	}
}
