
/**
 * Write a description of Part1 here.
 * @author Leonardo Garcia
 * @version v1
 */
public class Part1 {

    public void printAllGenes(String dna){
    int startIndex = 0;
    while (true){
        String gene = findGene(dna,startIndex);
        if(gene.isEmpty()){
            break;
        }
        System.out.println(gene);
        startIndex = dna.indexOf(gene,startIndex) + gene.length();
    }
    }
    
    public String findGene(String dna, int Where){
        String gene = "";    
        int startIndex = dna.indexOf("ATG",Where);
        if(startIndex == -1){
        return "";
        }
        int taaCodon = findStopCodon(dna,startIndex,"TAA");
        int tagCodon = findStopCodon(dna,startIndex,"TAG");
        int tgaCodon = findStopCodon(dna,startIndex,"TGA");
        int minIndex = 0;
        if (taaCodon == -1 || (tgaCodon != -1 && tgaCodon < taaCodon)){
           minIndex = tgaCodon;
        }
        else {
        minIndex = taaCodon;
        }
        
        if (minIndex == -1 || (tagCodon != -1 && tagCodon < minIndex))
        {
            minIndex = tagCodon;
        }
        
        if (minIndex == -1){
        return "";
        }
        gene = dna.substring(startIndex,minIndex+3);
        return gene;
    }
    
    public int findStopCodon(String dna, int startIndex, String stopCodon){
    int currIndex = dna.indexOf(stopCodon,startIndex+3);
    while (currIndex != -1){
    int diff = currIndex - startIndex;
    if (diff % 3 == 0){
    return currIndex;
    }
    else{
    currIndex = dna.indexOf(stopCodon, currIndex+1);
    }
    }   
    return -1;
    }
    
    
    public void testFindStopCodon(){
             //   012345678901234567
    String dna = "zzzATGzzzzzzTAAzzz";
    int startIndex = 3;
    String stopCodon = "TAA";
    int Index = findStopCodon(dna, startIndex, stopCodon);
    if (Index != 12){
    System.out.println("error on first test");
    }
      //   012345678901234567
    dna = "zzATGzzzzzzTAGzzzz";
    startIndex = 2;
    stopCodon = "TAG";
     Index = findStopCodon(dna, startIndex, stopCodon);
    if (Index != 11){
    System.out.println("error on second test");
    }
      //   0123456789012345678
    dna = "zzATGzzzzzzzTAGzzzzz";
    startIndex = 2;
    stopCodon = "TAG";
    Index = findStopCodon(dna, startIndex, stopCodon);
    if (Index != dna.length()){
     System.out.println("error on third test");
    }
      //   012345678901234567890
    dna = "zzATGzzzzzTAGzzzzzzzz";
    startIndex = 2;
    stopCodon = "TAG";
    Index = findStopCodon(dna, startIndex, stopCodon);
    if (Index != dna.length()){
    System.out.println("error on Last test");
    }
    System.out.println("test passed");
    }
    
    public void testFindGene(){
                  // V                   V  v                v       v             v
    String dna = "AATGCTAACTAGCTGACTAAT";
    printAllGenes(dna);
    }
}
