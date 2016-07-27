
package com.project.classifier4J;

import com.project.classifier4J.util.ToStringBuilder;

/**
 * @author Peter Leschev
 */
public class DefaultTokenizer implements ITokenizer {

	/**
	 * Use a the "\W" (non-word characters) regexp to split the string passed to
	 * classify
	 */
	public static int BREAK_ON_WORD_BREAKS = 1;

	/**
	 * Use a the "\s" (whitespace) regexp to split the string passed to classify
	 */
	public static int BREAK_ON_WHITESPACE = 2;

	private int tokenizerConfig = -1;
	private String customTokenizerRegExp = null;

	/**
	 * Constructor that using the BREAK_ON_WORD_BREAKS tokenizer config by
	 * default
	 */
	public DefaultTokenizer() {
		this(BREAK_ON_WORD_BREAKS);
	}

	public DefaultTokenizer(int tokenizerConfig) {
		setTokenizerConfig(tokenizerConfig);
	}

	public DefaultTokenizer(String regularExpression) {
		setCustomTokenizerRegExp(regularExpression);
	}

	/**
	 * @return the custom regular expression to use for
	 *         {@link #tokenize(String)}
	 */
	public String getCustomTokenizerRegExp() {
		return customTokenizerRegExp;
	}

	/**
	 * @return The configuration setting used by {@link #tokenize(String)}.
	 */
	public int getTokenizerConfig() {
		return tokenizerConfig;
	}

	/**
	 * <p>
	 * Allows the use of custom regular expressions to split up the input to
	 * {@link com.project.classifier4J.IClassifier#classify(java.lang.String)}.
	 * Note that this regular expression will only be used if tokenizerConfig is
	 * set to {@link #BREAK_ON_CUSTOM_REGEXP }
	 * </p>
	 * 
	 * @param string
	 *            set the custom regular expression to use for
	 *            {@link #tokenize(String)}. Must not be null.
	 */
	public void setCustomTokenizerRegExp(String string) {

		if (string == null) {
			throw new IllegalArgumentException(
					"Regular Expression string must not be null");
		}

		customTokenizerRegExp = string;
	}

	/**
	 * @param tokConfig
	 *            The configuration setting for use by {@link #tokenize(String)}
	 *            . Valid values are {@link #BREAK_ON_CUSTOM_REGEXP},
	 *            {@link #BREAK_ON_WORD_BREAKS} and {@link #BREAK_ON_WHITESPACE}
	 */
	public void setTokenizerConfig(int tokConfig) {

		if (tokConfig != BREAK_ON_WORD_BREAKS
				&& tokConfig != BREAK_ON_WHITESPACE) {
			throw new IllegalArgumentException(
					"tokenConfiguration must be either BREAK_ON_WORD_BREAKS or BREAK_ON_WHITESPACE");
		}

		tokenizerConfig = tokConfig;
	}

	public String[] tokenize(String input) {

		String regexp = "";

		if (customTokenizerRegExp != null) {
			regexp = customTokenizerRegExp;
		} else if (tokenizerConfig == BREAK_ON_WORD_BREAKS) {
			regexp = "\\W";
		} else if (tokenizerConfig == BREAK_ON_WHITESPACE) {
			regexp = "\\s";
		} else {
			throw new IllegalStateException(
					"Illegal tokenizer configuration. customTokenizerRegExp = null & tokenizerConfig = "
							+ tokenizerConfig);
		}

		if (input != null) {
			String[] words = input.split(regexp);
			return words;

		} else {
			return new String[0];
		}
	}

	public String toString() {

		ToStringBuilder toStringBuilder = new ToStringBuilder(this);

		if (customTokenizerRegExp != null) {
			toStringBuilder = toStringBuilder.append("customTokenizerRegExp",
					customTokenizerRegExp);
		} else if (tokenizerConfig == BREAK_ON_WORD_BREAKS) {
			toStringBuilder = toStringBuilder.append("tokenizerConfig",
					"BREAK_ON_WORD_BREAKS");
		} else if (tokenizerConfig == BREAK_ON_WHITESPACE) {
			toStringBuilder = toStringBuilder.append("tokenizerConfig",
					"BREAK_ON_WHITESPACE");
		}

		return toStringBuilder.toString();
	}
}