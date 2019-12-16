import edu.duke.*;
/**
 * Write a description of Part4 here.
 * 
 * @author (Leonard Garcia) 
 * @version (v1)
 */
public class Part4 {
    public String urlSearch(String url){
    String urlFound = "";
    // set url from string to look at
    URLResource urlLink = new URLResource(url);
    //itirate over all words in page
    for (String s : urlLink.words()){
        // convert to lowercase to find all versions of casing
        String newS = s.toLowerCase();
        int ytIndex = newS.indexOf("youtube.com");
        if (ytIndex > -1){
        // look for start and end index using original s string not lowercase one to return original casing
        // last index of searches backwards from a given postion
        int urlStartIndex = s.lastIndexOf("\"",ytIndex);
        int urlStopIndex = s.indexOf("\"",ytIndex);
        // adding the +1 on the start index and removing it from the stop index removes the quotes
        urlFound = s.substring(urlStartIndex+1,urlStopIndex);
        System.out.println(urlFound);
        }
    }
    return "New URLs found above";    
    }
    
    public void testingUrl(){
    String url = ("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
    System.out.println(urlSearch(url));
    }
}
