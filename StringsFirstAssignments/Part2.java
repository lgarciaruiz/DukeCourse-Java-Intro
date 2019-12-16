
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
public String findSimpleGene(String dna, String startCodon, String stopCodon){
    String gene = "";
    String newStartCodon = startCodon;
    String newStopCodon = stopCodon;
    if (dna.equals(dna.toUpperCase())){
    newStartCodon = startCodon.toUpperCase();
    newStopCodon = stopCodon.toUpperCase();
    }
    else{
    newStartCodon = startCodon.toLowerCase();
    newStopCodon = stopCodon.toLowerCase();
    }
    int startIndex = dna.indexOf(newStartCodon);
        if (startIndex == -1){
        return "";
        }
    int stopIndex = dna.indexOf(newStopCodon, startIndex+3);
        if (stopIndex == -1){
        return "";
        }
    gene = dna.substring(startIndex,stopIndex+3);
        if (gene.length() % 3 == 0){
        return gene;
        }
        return "";
}

public void testSimpleGene(){
    String dna1 = "AAATGCCCTAACTAGATTAAGAAACC";
    System.out.println("Testing " + dna1);
    String gene = findSimpleGene(dna1,"ATG","TAA");
    System.out.println("Gene 1 is " + gene);
    String dna2 = "CATGCGATGTACTGTGTTAA";
    System.out.println("Testing " + dna2);
    gene = findSimpleGene(dna2,"ATG","TAA");
    System.out.println("Gene 2 is " + gene);
    String dna3 = "CATGCGATTGGTACTGTGTTA";
    System.out.println("Testing " + dna3);
    gene = findSimpleGene(dna3,"ATG","TAA");
    System.out.println("Gene 3 is " + gene);
    String dna4 = "CATCGATTGGTACTGTGTTAA";
    System.out.println("Testing " + dna4);
    gene = findSimpleGene(dna4,"ATG","TAA");
    System.out.println("Gene 4 is " + gene);
    String dna5 = "CAGCGATTGGTACTGTGTTA";
    System.out.println("Testing " + dna5);
    gene = findSimpleGene(dna5,"ATG","TAA");
    System.out.println("Gene 5 is " + gene);
    String dna6 = "atgtaa";
    System.out.println("Testing " + dna6);
    gene = findSimpleGene(dna6,"ATG","TAA");
    System.out.println("Gene 6 is " + gene);
    }
}
