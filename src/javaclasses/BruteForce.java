package javaclasses;

import java.util.*;

public class BruteForce {
    public Set<ArrayList<Integer>> computeBruteForce(String a, String b) {
        int M = a.length();
        int N = b.length();
        int count = 0;
        Map<String, Collection<String>> map = new HashMap<String, Collection<String>>();
        map.put("FirstString", this.seperatestrings(a));
        map.put("SecondString", this.seperatestrings(b));
        int charactererrors=0;
        Map<Integer,Set<String>> chermap=new HashMap<Integer, Set<String>>();
        ArrayList<Integer> cherset=new ArrayList<Integer>();
        for (String fs : map.get("FirstString")) {
            for (String ss : map.get("SecondString")) {
                if (this.match(fs, ss)) {
                    count += 1;
                }
                System.out.println(fs);
                System.out.println(ss);
                Map<Integer, Map<Integer, Map<Character, Character>>> newmap=this.charactermatch(fs,ss);
                charactererrors=(Integer) (newmap.keySet().toArray()[0]);
                System.out.println(charactererrors);
                cherset.add(charactererrors);
                Set<String > stringset=new HashSet<String>();
                stringset.add(fs);
                stringset.add(ss);
                chermap.put(charactererrors,stringset);
            }
        }
        for(Object i:chermap.keySet().toArray()){
            System.out.println(i);
        }
        ArrayList<Integer> aset=new ArrayList<Integer>();
        aset.add(count);
        //set.add(charactererrors);
        Set<ArrayList<Integer>> retset=new HashSet<ArrayList<Integer>>();
        retset.add(aset);
        retset.add(cherset);
        return retset;
    }

    public boolean match(String pattern, String textshort) {
        if (pattern.equals(textshort)) {
            return true;
        } else {
            return false;
        }
    }

    public Map<Integer, Map<Integer, Map<Character, Character>>> charactermatch(String s1, String s2) {
        int count = 0;
        //This map contains the characters of  the substring and their position
        Map<Integer, Map<Character, Character>> stringmap = new HashMap<Integer, Map<Character, Character>>();
        //loop through the characters in the first,second string
        int length,largelength;
        if(s1.length()<=s2.length()){
            length=s1.length();
            largelength=s2.length();
        }
        else{
            length=s2.length();
            largelength=s1.length();
        }
        for (int i = 0; i < length; i++) {
            //If a character in the first string is not equal to the character at the same position in the second string
            //count is incremented
            if (s1.charAt(i) != s2.charAt(i)) {
                count += 1;
                //this map consists of mapping between the characters
                Map<Character, Character> mv = new HashMap<Character, Character>();
                //Add the character mapping to the position of these characters
                mv.put(s1.charAt(i), s2.charAt(i));
                stringmap.put(i, mv);
            }
        }
        for (int j=length;j<largelength;j++){
            Map<Character, Character> mv = new HashMap<Character, Character>();
            //Add the character mapping to the position of these characters
            count += 1;
            if(length==s1.length()) {
                mv.put('0', s2.charAt(j));
                stringmap.put(j, mv);
            }
            else{
                mv.put(s1.charAt(j),'0');
                stringmap.put(j, mv);
            }
        }
        //This map is used for returning a set of values in the form of the count variable and the character mapping
        Map<Integer, Map<Integer, Map<Character, Character>>> remap = new HashMap<Integer, Map<Integer, Map<Character, Character>>>();
        remap.put(count, stringmap);
        return remap;
    }

    public ArrayList<String> seperatestrings(String toseperate) {
        String[] parts = toseperate.split(" ");
        //split the string into substrings and store the substrings in an arraylist
        ArrayList<String> listofstrings = new ArrayList<String>(Arrays.asList(parts));
        return listofstrings;
    }
}




