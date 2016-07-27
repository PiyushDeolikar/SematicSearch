package documentclassifier.Scrapers;

import java.io.InputStream;

public abstract interface Scraper
{
  public abstract String[] getDocument(InputStream paramInputStream);

  public abstract String toString();
}

/* Location:           D:\piyush code\semantic search\DocumentClassifier\DocumentClassifier\DocumentClassifier - Copy.jar
 * Qualified Name:     documentclassifier.Scrapers.Scraper
 * JD-Core Version:    0.6.2
 */