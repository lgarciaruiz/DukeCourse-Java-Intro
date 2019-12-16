import edu.duke.*;
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    public void processGenes (StorageResource sr){
    StorageResource geneList = new StorageResource(sr);
    int geneCount = 0;
    int count = 0;
    int cgCount = 0;
    String longestGene = "";
    for (String gene : geneList.data()){
     geneCount = geneCount + 1;
     if (gene.length() > 60){
        count = count +1 ;
        System.out.println(gene + " is longer than 60 charachters");
        }
     float cgRatio = cgRatio(gene);
     if (cgRatio > 0.35){
        cgCount = cgCount + 1;
        System.out.println(gene + " has a cg ratio > .35");
        }
     longestGene = gene;  
     if (gene.length() > longestGene.length()){
        longestGene = gene;
        }
    }
    System.out.println("Amount of genes over 60 charachters = " + count);
    System.out.println("Amount of genes with cg ratio over .35 = " + cgCount);
    System.out.println("Longest gene = " + longestGene);
    System.out.println("Length of longest gene = " + longestGene.length());
    System.out.println("Count of genes = " + geneCount);
    }
    
    public void testProcessGenes(){
    FileResource fr = new FileResource("GRch38dnapart.fa");
    String dna = fr.asString();
    dna = dna.toUpperCase();
    StorageResource genes = getAllGenes(dna);
    processGenes(genes);
    
    }
        
    public void testCharProcessGenes(){
    String dna = "ATGCRTTRTTAABATGGTATAACATGTRTGRWWERTGA";
    StorageResource genes = getAllGenes(dna);
    processGenes(genes);
    }
    
    public void testCGRatioProcessGenes(){
    String dna = "ATGCRCGCGTAABATGGTATAACATGTRTGCCFTCTGA";
    StorageResource genes = getAllGenes(dna);
    processGenes(genes);
    }
    
    public void testLongGeneProcessGenes(){
    String dna = "ATGCRTTRTTAABATGGTATAACATGTRTGRWWERTGA";
    StorageResource genes = getAllGenes(dna);
    processGenes(genes);
    }
    
    public StorageResource getAllGenes(String dna){
    StorageResource geneList = new StorageResource();
    int startIndex = 0;
    while (true){
        String gene = findGene(dna,startIndex);
        if(gene.isEmpty()){
            break;
        }
        geneList.add(gene);
        startIndex = dna.indexOf(gene,startIndex) + gene.length();
    }
    return geneList;
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
    
    public String findGene(String dna, int startingIndex){
        String gene = "";    
        int atgStartIndex = dna.indexOf("ATG",startingIndex);
        if(atgStartIndex == -1){
        return "";
        }
        int taaCodon = findStopCodon(dna,atgStartIndex,"TAA");
        int tagCodon = findStopCodon(dna,atgStartIndex,"TAG");
        int tgaCodon = findStopCodon(dna,atgStartIndex,"TGA");
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
        gene = dna.substring(atgStartIndex,minIndex+3);
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
    
    public float cgRatio(String dna){
    float cgAmount = 0;
    int startIndexC = dna.indexOf("C");
    int startIndexG = dna.indexOf("G");
    int countC = 0;
    int countG = 0;
    while(startIndexC != -1){
    countC = countC+1;
    startIndexC = dna.indexOf("C",startIndexC+1);
    }
    while(startIndexG != -1){
    countG = countG+1;
    startIndexG = dna.indexOf("G",startIndexG+1);
    }
    int count = countC + countG;
    cgAmount = (float)count/dna.length();
    return cgAmount;
    }
    
    public int countCTG(String dna){
    int ctgAmount = 0;
    int index = dna.indexOf("CTG");
    while(index != -1){
    ctgAmount = ctgAmount+1;
    index = dna.indexOf("CTG",index+3);
    }
    return ctgAmount;
    }
    
    public void testCG(){
    String dna = "ATGCCATAGGCC";
    System.out.println(cgRatio(dna));
    }
    
    public void testCTG(){
    String dna = "CATGCTGCTGCATAGCTG";
    System.out.println(countCTG(dna));
    }
    
    public void testStorageResource(){
    String dna = "ATGCCATAGATGCATAGACGCCAGTAATAA";
    StorageResource genes = getAllGenes(dna);
    for (String gene : genes.data()){
    System.out.println(gene);
    }
    }
    
    public void testprintGenes(){
    String dna = "ATGCCATAGATGCATAGACGCCAGTAATAA";
    printAllGenes(dna);
    }
    
}
