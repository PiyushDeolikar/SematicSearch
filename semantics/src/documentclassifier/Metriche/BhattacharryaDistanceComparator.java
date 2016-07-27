package documentclassifier.Metriche;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class BhattacharryaDistanceComparator
  implements Comparator<Map.Entry<Map<String, Object>, Map<String, Double>>>
{
  public int compare(Map.Entry<Map<String, Object>, Map<String, Double>> paramEntry1, Map.Entry<Map<String, Object>, Map<String, Double>> paramEntry2)
  {
    double d1 = ((Double)((Map)paramEntry1.getKey()).get("Distance")).doubleValue();
    double d2 = ((Double)((Map)paramEntry2.getKey()).get("Distance")).doubleValue();
    if (d1 > d2)
      return 1;
    if (d1 == d2)
      return 0;
    return -1;
  }

  public static void calculateDistance(LinkedList<Map.Entry<Map<String, Object>, Map<String, Double>>> paramLinkedList, Map<String, Double> paramMap)
  {
    Iterator localIterator1 = paramLinkedList.iterator();
    while (localIterator1.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator1.next();
      double d = 0.0D;
      Map localMap = (Map)localEntry.getValue();
      HashSet localHashSet = new HashSet();
      localHashSet.addAll(localMap.keySet());
      localHashSet.retainAll(paramMap.keySet());
      Iterator localIterator2 = localHashSet.iterator();
      while (localIterator2.hasNext())
      {
        String str = (String)localIterator2.next();
        d += Math.sqrt(((Double)paramMap.get(str)).doubleValue() * ((Double)localMap.get(str)).doubleValue());
      }
      ((Map)localEntry.getKey()).put("Distance", new Double(Math.sqrt(1.0D - d)));
    }
  }
}

/* Location:           D:\piyush code\semantic search\DocumentClassifier\DocumentClassifier\DocumentClassifier - Copy.jar
 * Qualified Name:     documentclassifier.Metriche.BhattacharryaDistanceComparator
 * JD-Core Version:    0.6.2
 */