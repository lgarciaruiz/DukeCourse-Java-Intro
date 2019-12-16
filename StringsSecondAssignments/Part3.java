
/**
 * Write a description of Part3 here.
 * @author Leonardo Garcia
 * @version v1
 */
public class Part3 {

    public int countGenes(String dna){
    int geneAmount = 0;
    int startIndex = 0;
    while(true){
        String gene = findGene(dna,startIndex);
        if (gene.isEmpty()){ // if your checking if its empty length of gene goes outside of index of method. look below
        break;
        }
        else{
            int geneLeng = gene.length();
            geneAmount = geneAmount + 1;
            startIndex = dna.indexOf(gene,startIndex) + geneLeng; //above note is about this here
         }
    }
    
    return geneAmount;
    }

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
    
    
    public void testCountGenes(){
    String gene = "ATGTAAGATGCCCTAGT";
    System.out.println(countGenes(gene));
    }
}
