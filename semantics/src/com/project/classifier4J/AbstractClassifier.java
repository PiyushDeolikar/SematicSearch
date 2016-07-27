
package com.project.classifier4J;


public abstract class AbstractClassifier implements IClassifier {

	protected double cutoff = IClassifier.DEFAULT_CUTOFF;

	/**
	 * 
	 * <p>
	 * This implementation throws an IllegalArgumentException if cutoff is
	 * greater than 1 or less than 0.
	 * </p>
	 * 
	 * 
	 * @param cutoff
	 *            Used to determine the mimimum probability that should be
	 *            classified as a match
	 * @throws IllegalArgumentException
	 *             if if cutoff is greater than 1 or less than 0
	 * 
	 */
	public void setMatchCutoff(double cutoff) {
		if (cutoff > 1 || cutoff < 0) {
			throw new IllegalArgumentException(
					"Cutoff must be equal or less than 1 and greater than or equal to 0");
		}

		this.cutoff = cutoff;
	}

	public double getMatchCutoff() {
		return this.cutoff;
	}

	/**
	 * <p>
	 * Implementation of
	 * {@link com.project.classifier4J.IClassifier#isMatch(java.lang.String)}
	 * method.
	 * </p>
	 * 
	 * @see com.project.classifier4J.IClassifier#isMatch(java.lang.String)
	 */
	public boolean isMatch(String input) throws ClassifierException {
		double matchProbability = classify(input);

		return isMatch(matchProbability);
	}

	/**
	 * @see com.project.classifier4J.IClassifier#isMatch(double)
	 */
	public boolean isMatch(double matchProbability) {
		return (matchProbability >= cutoff);
	}

}