package documentclassifier.Metriche;

import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TFIDFComparator
  implements Comparator<Map.Entry<Map<String, Object>, Map<String, Double>>>
{
  public int compare(Map.Entry<Map<String, Object>, Map<String, Double>> paramEntry1, Map.Entry<Map<String, Object>, Map<String, Double>> paramEntry2)
  {
    double d1 = ((Double)((Map)paramEntry1.getKey()).get("Distance")).doubleValue();
    double d2 = ((Double)((Map)paramEntry2.getKey()).get("Distance")).doubleValue();
    if (d1 > d2)
      return -1;
    if (d1 == d2)
      return 0;
    return 1;
  }

  public static void calculateCosine(LinkedList<Map.Entry<Map<String, Object>, Map<String, Double>>> paramLinkedList, Map<String, Double> paramMap)
  {
    AbstractMap.SimpleEntry localSimpleEntry = new AbstractMap.SimpleEntry(null, paramMap);
    paramLinkedList.add(localSimpleEntry);
    LinkedList localLinkedList = new LinkedList();
    HashMap localHashMap = new HashMap();
    int i = paramLinkedList.size();
    Iterator localIterator1 = paramLinkedList.iterator();
    Object localObject;
    while (localIterator1.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator1.next();
      localObject = new HashMap();
      ((Map)localObject).putAll((Map)localEntry.getValue());
      Iterator localIterator2 = ((Map)localObject).keySet().iterator();
      while (localIterator2.hasNext())
      {
        String str = (String)localIterator2.next();
        if (localHashMap.get(str) == null)
        {
          Integer localInteger1 = Integer.valueOf(0);
          Integer localInteger2;
          for (int k = 0; k < i; k++)
            if (((Map)((Map.Entry)paramLinkedList.get(k)).getValue()).get(str) != null)
            {
              localInteger2 = localInteger1;
              Integer localInteger3 = localInteger1 = Integer.valueOf(localInteger1.intValue() + 1);
            }
          localHashMap.put(str, Integer.valueOf(i / localInteger1.intValue()));
        }
        double d1 = ((Double)((Map)localObject).get(str)).doubleValue() * Math.log10(((Integer)localHashMap.get(str)).intValue());
        ((Map)localObject).put(str, Double.valueOf(d1));
      }
      localLinkedList.add(new AbstractMap.SimpleEntry(localEntry.getKey(), localObject));
      if (localEntry == localSimpleEntry)
        localSimpleEntry.setValue(localObject);
    }
    paramLinkedList.remove(localSimpleEntry);
    i--;
    double d2 = twoNorm((Map)localSimpleEntry.getValue());
    for (int j = 0; j < i; j++)
    {
      localObject = (Map)((Map.Entry)localLinkedList.get(j)).getValue();
      double d3 = scalarProduct((Map)localSimpleEntry.getValue(), (Map)localObject) / (twoNorm((Map)localObject) * d2);
      ((Map)((Map.Entry)paramLinkedList.get(j)).getKey()).put("Distance", Double.valueOf(d3));
      ((Map)((Map.Entry)paramLinkedList.get(j)).getKey()).put("Angle", Double.valueOf(Math.toDegrees(Math.acos(d3))));
    }
  }

  private static double scalarProduct(Map<String, Double> paramMap1, Map<String, Double> paramMap2)
  {
    double d = 0.0D;
    HashSet localHashSet = new HashSet();
    localHashSet.addAll(paramMap1.keySet());
    if (paramMap1 != paramMap2)
      localHashSet.retainAll(paramMap2.keySet());
    Iterator localIterator = localHashSet.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      d += ((Double)paramMap1.get(str)).doubleValue() * ((Double)paramMap2.get(str)).doubleValue();
    }
    return d;
  }

  private static double twoNorm(Map<String, Double> paramMap)
  {
    return Math.sqrt(scalarProduct(paramMap, paramMap));
  }
}

/* Location:           D:\piyush code\semantic search\DocumentClassifier\DocumentClassifier\DocumentClassifier - Copy.jar
 * Qualified Name:     documentclassifier.Metriche.TFIDFComparator
 * JD-Core Version:    0.6.2
 */