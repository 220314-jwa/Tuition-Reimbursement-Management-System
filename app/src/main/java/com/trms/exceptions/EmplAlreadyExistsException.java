package com.trms.exceptions;

public class EmplAlreadyExistsException extends Exception {
	
		public EmplAlreadyExistsException() {
			super("Employee already exists!");
		}
}
