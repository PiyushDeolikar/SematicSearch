
package com.project.classifier4J;

/**
 * @author Nick Lothian
 * @author Peter Leschev
 */
public interface ICategorisedClassifier extends IClassifier {

	public static final String DEFAULT_CATEGORY = "DEFAULT";

	/**
	 * 
	 * Function to determine the probability string matches a criteria for a
	 * given category.
	 * 
	 * @param category
	 *            the category to check against
	 * @param input
	 *            the string to classify
	 * @return the likelyhood that this string is a match for this
	 *         net.sf.classifier4J. 1 means 100% likely.
	 * 
	 * @throws ClassifierException
	 *             If a fatal problem occurs. For example, the database is
	 *             unavailable.
	 */
	public double classify(String category, String input)
			throws ClassifierException;

	/**
	 * 
	 * Function to determine if a string matches a criteria for a given category
	 * 
	 * @param category
	 *            the category to check against
	 * @param input
	 *            the string to classify
	 * @return true if the input string has a probability >= the cutoff
	 *         probability of matching
	 * 
	 * @throws ClassifierException
	 *             If a fatal problem occurs. For example, the database is
	 *             unavailable.
	 */
	public boolean isMatch(String category, String input)
			throws ClassifierException;

}