
/**
 * 
 * NEED TO FIX THIS CODE
 * Write a description of Part1 here.
 * 
 * @author (Leonardo Garcia) 
 * @version (v1)
 */
public class Part1 {
    public String findSimpleGene(String dna){
    String gene = "";
    int startIndex = dna.indexOf("ATG");
        if (startIndex == -1){
        return "";
        }
    int stopIndex = dna.indexOf("TAA", startIndex+3);
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
    String dna1 = "CATGCGATTGGTACTGTGTTAA";
    System.out.println("Testing " + dna1);
    String gene = findSimpleGene(dna1);
    System.out.println("Gene 1 is " + gene);
    String dna2 = "CATGCGATGTACTGTGTTAA";
    System.out.println("Testing " + dna2);
    gene = findSimpleGene(dna2);
    System.out.println("Gene 2 is " + gene);
    String dna3 = "CATGCGATTGGTACTGTGTTA";
    System.out.println("Testing " + dna3);
    gene = findSimpleGene(dna3);
    System.out.println("Gene 3 is " + gene);
    String dna4 = "CATCGATTGGTACTGTGTTAA";
    System.out.println("Testing " + dna4);
    gene = findSimpleGene(dna4);
    System.out.println("Gene 4 is " + gene);
    String dna5 = "CAGCGATTGGTACTGTGTTA";
    System.out.println("Testing " + dna5);
    gene = findSimpleGene(dna5);
    System.out.println("Gene 5 is " + gene);
    }
}
