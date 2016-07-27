
package com.project.classifier4J;

import java.util.Stack;

/**
 * <p>
 * Simple HTML Tokenizer. Its goal is to tokenize words that would be displayed
 * in a normal web browser.
 * </p>
 * 
 * <p>
 * It does not handle meta tags, alt or text attributes, but it does remove CSS
 * style definitions and javascript code.
 * </p>
 * 
 * <p>
 * It handles entity references by replacing them with a space(!!). This can be
 * overridden.
 * </p>
 * 
 * 
 * @since 18 Nov 2003
 * @author Nick Lothian
 */
public class SimpleHTMLTokenizer extends DefaultTokenizer {

	/**
	 * Constructor that using the BREAK_ON_WORD_BREAKS tokenizer config by
	 * default
	 */
	public SimpleHTMLTokenizer() {
		super();
	}

	public SimpleHTMLTokenizer(int tokenizerConfig) {
		super(tokenizerConfig);
	}

	public SimpleHTMLTokenizer(String regularExpression) {
		super(regularExpression);
	}

	/**
	 * Replaces entity references with spaces
	 * 
	 * @param contentsWithUnresolvedEntityReferences
	 *            the contents with the entity references
	 * @return the contents with the entities replaces with spaces
	 */
	protected String resolveEntities(
			String contentsWithUnresolvedEntityReferences) {
		if (contentsWithUnresolvedEntityReferences == null) {
			throw new IllegalArgumentException("Cannot pass null");
		}

		return contentsWithUnresolvedEntityReferences.replaceAll("&.{2,8};",
				" ");
	}

	/**
	 * @see com.project.classifier4J.ITokenizer#tokenize(java.lang.String)
	 */
	public String[] tokenize(String input) {
		Stack stack = new Stack();
		Stack tagStack = new Stack();

		// iterate over the input string and parse find text that would be
		// displayed
		char[] chars = input.toCharArray();

		StringBuffer result = new StringBuffer();

		StringBuffer currentTagName = new StringBuffer();
		for (int i = 0; i < chars.length; i++) {

			switch (chars[i]) {
			case '<':
				stack.push(Boolean.TRUE);
				currentTagName = new StringBuffer();
				break;
			case '>':
				stack.pop();
				if (currentTagName != null) {
					String currentTag = currentTagName.toString();

					if (currentTag.startsWith("/")) {
						tagStack.pop();
					} else {

						tagStack.push(currentTag.toLowerCase());
					}
				}
				break;
			default:
				if (stack.size() == 0) {
					String currentTag = (String) tagStack.peek();
					// ignore everything inside <script></script> or
					// <style></style> tags
					if (currentTag != null) {
						if (!(currentTag.startsWith("script") || currentTag
								.startsWith("style"))) {
							result.append(chars[i]);
						}
					} else {
						result.append(chars[i]);
					}

				} else {
					currentTagName.append(chars[i]);
				}
				break;
			}
		}

		return super.tokenize(resolveEntities(result.toString()).trim());
	}

}