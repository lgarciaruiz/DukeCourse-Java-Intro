
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    public int howMany(String stringa, String stringb){
    int num = 0;
    int currIndex = stringb.indexOf(stringa);
    int stringLength = stringa.length();
    while (currIndex != -1){
    num = num += 1;
    currIndex = stringb.indexOf(stringa,currIndex+stringLength);   
    }
    return num;
    }
    
    public void testHowMany(){
    String stringa = "AA";
    //                01234567890 
    String stringb = "ATAAPAAAAA";
    int num = howMany(stringa,stringb);
    System.out.println("string a appears " + num + " times");
    }

}
