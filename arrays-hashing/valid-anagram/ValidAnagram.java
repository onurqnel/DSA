import java.util.Arrays;
import java.util.HashMap;

// First approach: Sort both strings and compare the results
class SortingApproach {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] sSort = s.toCharArray();
        char[] tSort = t.toCharArray();

        Arrays.sort(sSort);
        Arrays.sort(tSort);

        return Arrays.equals(sSort, tSort);
    }
}

// Second approach: Use two HashMaps to count character frequencies
class HashMapApproach {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> countS = new HashMap<>();
        HashMap<Character, Integer> countT = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            countS.put(s.charAt(i), countS.getOrDefault(s.charAt(i), 0) + 1);
            countT.put(t.charAt(i), countT.getOrDefault(t.charAt(i), 0) + 1);
        }

        return countS.equals(countT);
    }
}

// Third and optimal approach: Use a single HashMap
class OptimalApproach {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> count = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char chS = s.charAt(i);
            char chT = t.charAt(i);

            count.put(chS, count.getOrDefault(chS, 0) + 1);
            count.put(chT, count.getOrDefault(chT, 0) - 1);
        }

        for (int val : count.values()) {
            if (val != 0) {
                return false;
            }
        }

        return true;
    }
}

// Main class to test all three approaches
public class ValidAnagram {
    public static void main(String[] args) {
        String s1 = "racecar";
        String t1 = "carrace";

        String s2 = "jar";
        String t2 = "jam";

        SortingApproach sorter = new SortingApproach();
        HashMapApproach mapper = new HashMapApproach();
        OptimalApproach optimal = new OptimalApproach();

        System.out.println("Sorting approach:");
        System.out.println(s1 + " vs " + t1 + " → " + sorter.isAnagram(s1, t1));
        System.out.println(s2 + " vs " + t2 + " → " + sorter.isAnagram(s2, t2));

        System.out.println("\nHashMap approach:");
        System.out.println(s1 + " vs " + t1 + " → " + mapper.isAnagram(s1, t1));
        System.out.println(s2 + " vs " + t2 + " → " + mapper.isAnagram(s2, t2));

        System.out.println("\nOptimal approach (single HashMap):");
        System.out.println(s1 + " vs " + t1 + " → " + optimal.isAnagram(s1, t1));
        System.out.println(s2 + " vs " + t2 + " → " + optimal.isAnagram(s2, t2));
    }
}
