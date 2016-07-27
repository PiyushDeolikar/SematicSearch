
package com.project.classifier4J;

/**
 * 
 * <p>
 * Very basic implemntation of the {@link com.project.classifier4J.IClassifier}
 * interface.
 * </p>
 * 
 * <p>
 * This implementation just looks for string (set by
 * {@link #setSearchWord(java.lang.String)}) in the input passed to
 * {@link #classify(java.lang.String)}
 * </p>
 * 
 * 
 * @author Nick Lothian
 */
public class SimpleClassifier extends AbstractClassifier implements IClassifier {

	private String searchWord;

	/**
	 * @return the word this classifier is searching for
	 */
	public String getSearchWord() {
		return searchWord;
	}

	/**
	 * @param string
	 *            The string to look for when matching
	 */
	public void setSearchWord(String string) {
		searchWord = string;
	}

	/**
	 * @see com.project.classifier4J.IClassifier#classify(java.lang.String)
	 */
	public double classify(String input) {
		if ((input != null) && (input.indexOf(searchWord) > 0)) {
			return 1;
		} else {
			return 0;
		}
	}

}