package javaclasses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LevenshteinDistance {

    public int computeLevenshtein(String a, String b) {
        int sizestringa = a.length();
        int sizestringb = b.length();
        int[][] mat = new int[200][200];
        ArrayList<Integer> cost = new ArrayList<Integer>();

        String[] lev = new String[100];
        a = a.toLowerCase();
        b = b.toLowerCase();
        for (int k = 0; k < (sizestringa); k++) {
            mat[k][0] = k;
        }
        for (int l = 0; l < (sizestringb); l++) {
            mat[0][l] = l;
        }
        for (int i = 1; i <= (sizestringa); i++) {
            for (int j = 1; j <= (sizestringb); j++) {
                char ac = a.charAt(i - 1);
                char bc = b.charAt(j - 1);
                //System.out.println(" " + ac + " " + bc);
                if (ac == bc) {
                    cost.add(0);
                } else {
                    cost.add(1);
                }
                mat[i][j] = getminimum(mat[i - 1][j], mat[i][j - 1], mat[i - 1][j - 1], cost.get(cost.size() - 1));
            }
        }
        for (int k = 0; k <= sizestringa; k++) {
            for (int j = 0; j <= sizestringb; j++) {
                //System.out.println(mat[k][j]);
            }
        }
        return mat[sizestringa][sizestringb];
    }

    public int getminimum(int elementabove, int elementleft, int elementdiagonal, int elementcost) {
        int minimumcost = 0;
        Map<String, Integer> costs = new HashMap<String, Integer>();
        costs.put("elementabove", elementabove + 1);
        costs.put("elementleft", elementleft + 1);
        costs.put("elementdiagonal", elementdiagonal + elementcost);
        minimumcost = mapiterate(costs);
        return minimumcost;
    }

    public int mapiterate(Map<String, Integer> mp) {
        int lowestcost = 0;
        /*
        Iterator it=map.entrySet().iterator();
        while(it.hasNext())
        {
            Map.Entry pair=(Map.Entry)it.next();
            if(pair.getValue()<lowestcost)
        }
        */
        Map.Entry<String, Integer> entry = mp.entrySet().iterator().next();
        lowestcost = entry.getValue();
        for (int value : mp.values()) {
            if (value < lowestcost) {
                lowestcost = value;
            }
        }
        return lowestcost;
    }
}


