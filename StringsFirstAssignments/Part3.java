
/**
 * Write a description of Part3 here.
 * 
 * @author (Leonardo Garcia) 
 * @version (v1)
 */
public class Part3 {

    public boolean twoOccurrences(String stringA, String stringB){
      boolean answer = true;
      int lengthStringA = stringA.length();
      int firstIndex = stringB.indexOf(stringA);
      int secondIndex = stringB.indexOf(stringA,firstIndex+lengthStringA);
      if(secondIndex == -1){
        answer = false;
        return answer;
        }
      return answer;  
    }
    
    public void testing(){
    if(twoOccurrences("by","I went to buy the banana by the lake."))
    {
    System.out.println("this is true");
    }
    else{
    System.out.println("this is false");
    }
    if(twoOccurrences("by","I went to buy the banana by the lake for the by."))
    {
    System.out.println("this is true");
    }
    else{
    System.out.println("this is false");
    }
    System.out.println(lasPart("an","banana"));
    System.out.println(lasPart("before","last call before closing time!"));
    System.out.println(lasPart("today","tomorrow will be awesome!"));
    
}

public String lasPart(String stringA, String stringB){
    String lastPart = "";
    int lenghtStringA = stringA.length();
    int stringAIndex = stringB.indexOf(stringA);
    if(stringAIndex == -1){
        lastPart = stringB;
        return lastPart;
    }
    lastPart = stringB.substring(stringAIndex+lenghtStringA);
    return lastPart;
}
}
