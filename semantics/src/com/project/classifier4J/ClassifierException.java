
package com.project.classifier4J;

/**
 * A classifier exception

 */
public class ClassifierException extends Exception {

	public ClassifierException(String message) {
		super(message);
	}

	public ClassifierException(String message, Throwable throwable) {
		super(message, throwable);
	}
}