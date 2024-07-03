package com.leaomulti.leaocentermultimarcas.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ErrorMessage {

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd:mm:ss")
		private LocalDateTime timestamp;
		private int status;
		private String error;
		private String message;
		private String path;
		
		public ErrorMessage(HttpStatus status, String message, String path) {
			this.timestamp = LocalDateTime.now();
			this.status = status.value();
			this.error = status.getReasonPhrase();
			this.message = message;
			this.path = path;
		}

		public LocalDateTime getTimestamp() {
			return timestamp;
		}

		public void setTimestamp(LocalDateTime timestamp) {
			this.timestamp = timestamp;
		}

		public int getStatus() {
			return status;
		}

		public void setStatus(int status) {
			this.status = status;
		}

		public String getError() {
			return error;
		}

		public void setError(String error) {
			this.error = error;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public String getPath() {
			return path;
		}

		public void setPath(String path) {
			this.path = path;
		}
	
}
