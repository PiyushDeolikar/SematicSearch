package com.project.classifier4J;

import com.project.classifier4J.bayesian.WordsDataSourceException;

public abstract class AbstractCategorizedTrainableClassifier extends
		AbstractClassifier implements ITrainableClassifier {

	
	public double classify(String input) throws WordsDataSourceException,
			ClassifierException {
		return classify(ICategorisedClassifier.DEFAULT_CATEGORY, input);
	}

	public void teachMatch(String input) throws WordsDataSourceException,
			ClassifierException {
		teachMatch(ICategorisedClassifier.DEFAULT_CATEGORY, input);
	}

	public void teachNonMatch(String input) throws WordsDataSourceException,
			ClassifierException {
		teachNonMatch(ICategorisedClassifier.DEFAULT_CATEGORY, input);
	}

}