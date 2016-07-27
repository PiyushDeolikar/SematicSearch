
package com.project.classifier4J;

/**
 * @author Nick Lothian
 * @author Peter Leschev
 */
public interface ITrainable {
	public void teachMatch(String input) throws ClassifierException;

	public void teachMatch(String category, String input)
			throws ClassifierException;

	public void teachNonMatch(String input) throws ClassifierException;

	public void teachNonMatch(String category, String input)
			throws ClassifierException;
}