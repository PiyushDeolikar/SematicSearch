   
package com.project.classifier4J.bayesian;   
   
import com.project.classifier4J.ClassifierException;
   
public class WordsDataSourceException extends ClassifierException {   
   
    public WordsDataSourceException(String message) {   
        super(message);   
    }   
   
    public WordsDataSourceException(String message, Throwable throwable) {   
        super(message, throwable);   
    }   
}