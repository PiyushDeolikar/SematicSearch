package documentclassifier.Scrapers;

import ansascraper.Yylex;
import ansascraper.parser;
import documentclassifier.DocumentClassifierView;
import java.io.InputStream;
import java_cup.runtime.Symbol;

public class ANSAScraper
  implements Scraper
{
  public String[] getDocument(InputStream paramInputStream)
  {
    try
    {
      parser localparser = new parser(new Yylex(paramInputStream));
      String[] arrayOfString = ((String)localparser.parse().value).split(System.getProperty("line.separator"), 2);
      return arrayOfString;
    }
    catch (Exception localException)
    {
      DocumentClassifierView.showErrorMessage(localException.toString());
    }
    return null;
  }

  public String toString()
  {
    return "ANSA.it";
  }
}

/* Location:           D:\piyush code\semantic search\DocumentClassifier\DocumentClassifier\DocumentClassifier - Copy.jar
 * Qualified Name:     documentclassifier.Scrapers.ANSAScraper
 * JD-Core Version:    0.6.2
 */