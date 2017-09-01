package javaclasses;

public class deterministicmatchingalgorithms {
    public enum algorithms{
        levenshtein,hashing,BoyerMoore,BruteForce,NeedlemanWunsch;

    }
    deterministicmatchingalgorithms(algorithms name){

        //alg=algorithms.valueof(name);
        switch(name){
            case levenshtein:
                System.out.println("Calculating the levenshtein algorithm");
                break;
            case NeedlemanWunsch:
                System.out.println("Calculating the needleman wun");
            case hashing:
                System.out.println("Calculating the hashing algorithm");
                break;
            case BoyerMoore:
                System.out.println("Calculating the Boyer Moore algorithm");
                break;
            case BruteForce:
                System.out.println("Calculating the Brute Force algorithm");
                break;
            default:
                System.out.println("Try again");
                break;
        }
    }
}
