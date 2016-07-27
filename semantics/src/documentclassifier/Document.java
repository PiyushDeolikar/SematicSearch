package documentclassifier;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import org.tartarus.snowball.SnowballProgram;

class Document
{
  private String title;
  private String text;
  private String path;
  private Set<String> categories;
  private Map<String, Double> histogram;

  public Document(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      this.title = paramString1;
      this.text = paramString2;
      this.categories = new HashSet();
      this.categories.add(paramString3);
      this.path = paramString4;
      this.histogram = createHistogram();
    }
    catch (Exception localException)
    {
      DocumentClassifierView.showErrorMessage(localException.toString());
    }
  }

  public Document(String paramString1, String paramString2, String paramString3)
  {
    this(paramString1, paramString2, null, paramString3);
  }

  public Document(String paramString)
  {
    this(paramString, "", null);
  }

  private Map<String, Double> createHistogram()
    throws Exception
  {
    DocumentClassifierApp localDocumentClassifierApp = DocumentClassifierApp.getApplication();
    boolean bool1 = localDocumentClassifierApp.isStemming(false);
    boolean bool2 = localDocumentClassifierApp.isRemovalStopWords(false);
    Class localClass = Class.forName(localDocumentClassifierApp.getStemmer(false));
    SnowballProgram localSnowballProgram = (SnowballProgram)localClass.newInstance();
    Method localMethod = localClass.getMethod("stem", new Class[0]);
    Object[] arrayOfObject = new Object[0];
    String str1 = " \t\n\r\f,;.:!'\"()?[]=-@";
    HashMap localHashMap = new HashMap();
    HashSet localHashSet = new HashSet();
    File localFile = new File(DocumentClassifierApp.getApplication().getStopWordsList(false));
    if (bool2)
    {
      BufferedReader localBufferedReader = new BufferedReader(new FileReader(localFile));
      String str3;
      while ((str3 = localBufferedReader.readLine()) != null)
        if (!str3.isEmpty())
        {
          String[] arrayOfString1 = str3.split("|");
          if (!arrayOfString1[0].startsWith(" "))
            localHashSet.add(arrayOfString1[0].trim());
        }
      localBufferedReader.close();
    }
    String[] arrayOfString2 = new String[2];
    arrayOfString2[0] = this.title;
    arrayOfString2[1] = this.text;
    for (int j = 0; j <= 1; j++)
    {
      int i;
      if (j == 0)
        i = 2;
      else
        i = 1;
      arrayOfString2[j] = arrayOfString2[j].toLowerCase();
      StringTokenizer localStringTokenizer = new StringTokenizer(arrayOfString2[j], str1);
      while (localStringTokenizer.hasMoreTokens())
      {
        String str2 = localStringTokenizer.nextToken();
        if ((!localHashSet.contains(str2)) && (!str2.matches("\\d+")))
        {
          if (bool1)
          {
            localSnowballProgram.setCurrent(str2);
            localMethod.invoke(localSnowballProgram, arrayOfObject);
            str2 = localSnowballProgram.getCurrent();
          }
          Double localDouble = (Double)localHashMap.get(str2);
          if (localDouble == null)
            localDouble = Double.valueOf(0.0D);
          localHashMap.put(str2, Double.valueOf(localDouble.doubleValue() + i));
        }
      }
    }
    double d1 = 0.0D;
    Iterator localIterator = localHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      double d2 = ((Double)localIterator.next()).doubleValue();
      d1 += d2;
    }
    localIterator = localHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str4 = (String)localIterator.next();
      localHashMap.put(str4, Double.valueOf(((Double)localHashMap.get(str4)).doubleValue() / d1));
    }
    return Collections.unmodifiableMap(localHashMap);
  }

  public Map<String, Double> getHistogram()
  {
    return this.histogram;
  }

  public Set<String> getCategories()
  {
    return this.categories;
  }

  public void addCategory(String paramString)
  {
    this.categories.add(paramString);
  }

  public String getPath()
  {
    return this.path;
  }

  public String getText()
  {
    return this.text;
  }

  public String getTitle()
  {
    return this.title;
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == null)
      return false;
    if (getClass() != paramObject.getClass())
      return false;
    Document localDocument = (Document)paramObject;
    if ((this.title != localDocument.title) && ((this.title == null) || (!this.title.equals(localDocument.title))))
      return false;
    return (this.text == localDocument.text) || ((this.text != null) && (this.text.equals(localDocument.text)));
  }

  public int hashCode()
  {
    int i = 3;
    i = 71 * i + (this.title != null ? this.title.hashCode() : 0);
    i = 71 * i + (this.text != null ? this.text.hashCode() : 0);
    return i;
  }
}

/* Location:           D:\piyush code\semantic search\DocumentClassifier\DocumentClassifier\DocumentClassifier - Copy.jar
 * Qualified Name:     documentclassifier.Document
 * JD-Core Version:    0.6.2
 */