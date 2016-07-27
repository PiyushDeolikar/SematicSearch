package documentclassifier;

import java.net.URL;
import java.security.CodeSource;
import java.security.ProtectionDomain;
import java.util.HashMap;

public class MapDefaultPreferences extends HashMap<String, String>
{
  private static final DocumentClassifierApp application = DocumentClassifierApp.getApplication();
  private static final long serialVersionUID = 0L;
  private static final char pathSeparator = '/';
  public static final String SCRAPER = "Scraper";
  public static final String isREMOVALSTOPWORDS = "isStopWords";
  public static final String STOPWORDSLIST = "StopWords";
  public static final String isSTEMMING = "isStemming";
  public static final String STEMMER = "Stemmer";
  public static final String METRIC = "Metric";
  public static final String KNN = "KNN";
  public static final String MAXKNNVALIDATION = "MaxKNN";
  public static final String KFOLD = "KFOLD";
  public static final String isSTRATIFIED = "isStratified";
  public static final String isLOGGING = "isLogging";
  public static final String LOGFILE = "LogFile";
  public static final String isOVERWRITELOGFILE = "isOverwriteLogFile";
  public static final String isVISUALIZECURRENTDOCUMENT = "isVisualizeCurrentDocument";
  public static final String isVISUALIZELISTRANKEDDOCUMENTS = "isVisualizeListRankedDocuments";
  public static final String TRAININGSETDIRECTORY = "Training set directory";

  public MapDefaultPreferences()
  {
    String str = getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
    str = str.substring(0, str.lastIndexOf('/') + 1);
    put("Training set directory", str + "TrainingSet");
    put("Scraper", application.getScrapersPackageName() + ".ANSAScraper");
    put("StopWords", str + "StopWords" + '/' + "Italian.txt");
    put("isStopWords", "true");
    put("isStemming", "true");
    put("Stemmer", application.getStemmersPackageName() + ".italianStemmer");
    put("Metric", "TF-IDF");
    put("KNN", "1");
    put("MaxKNN", get("KNN"));
    put("KFOLD", "10");
    put("isStratified", "false");
    put("isLogging", "false");
    put("LogFile", str + "LogFile.log");
    put("isOverwriteLogFile", "false");
    put("isVisualizeCurrentDocument", "false");
    put("isVisualizeListRankedDocuments", "false");
  }
}

/* Location:           D:\piyush code\semantic search\DocumentClassifier\DocumentClassifier\DocumentClassifier - Copy.jar
 * Qualified Name:     documentclassifier.MapDefaultPreferences
 * JD-Core Version:    0.6.2
 */