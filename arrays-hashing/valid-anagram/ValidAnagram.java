import java.util.Arrays;
import java.util.HashMap;

// First approach: Sort both strings and compare the results
class SortingApproach {
    public boolean isAnagram(String s, String t) {
        // If lengths differ, they cannot be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        // Convert strings to character arrays
        char[] sSort = s.toCharArray();
        char[] tSort = t.toCharArray();

        // Sort both character arrays
        Arrays.sort(sSort);
        Arrays.sort(tSort);

        // Check if the sorted arrays are equal
        return Arrays.equals(sSort, tSort);
    }
}

// Second approach: Use HashMaps to count the frequency of characters
class HashMapApproach {
    public boolean isAnagram(String s, String t) {
        // If lengths differ, they cannot be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        // HashMaps to store character frequencies for both strings
        HashMap<Character, Integer> countS = new HashMap<>();
        HashMap<Character, Integer> countT = new HashMap<>();

        // Count each character in both strings
        for (int i = 0; i < s.length(); i++) {
            countS.put(s.charAt(i), countS.getOrDefault(s.charAt(i), 0) + 1);
            countT.put(t.charAt(i), countT.getOrDefault(t.charAt(i), 0) + 1);
        }

        // Compare the frequency maps
        return countS.equals(countT);
    }
}

// Main class to test both approaches
public class ValidAnagram {
    public static void main(String[] args) {
        // Test case 1: Should return true
        String s1 = "racecar";
        String t1 = "carrace";

        // Test case 2: Should return false
        String s2 = "jar";
        String t2 = "jam";

        // Instantiate both approach classes
        SortingApproach sorter = new SortingApproach();
        HashMapApproach mapper = new HashMapApproach();

        // Run tests with the sorting approach
        System.out.println("Sorting approach:");
        System.out.println(s1 + " vs " + t1 + " → " + sorter.isAnagram(s1, t1));
        System.out.println(s2 + " vs " + t2 + " → " + sorter.isAnagram(s2, t2));

        // Run tests with the hashmap approach
        System.out.println("\nHashMap approach:");
        System.out.println(s1 + " vs " + t1 + " → " + mapper.isAnagram(s1, t1));
        System.out.println(s2 + " vs " + t2 + " → " + mapper.isAnagram(s2, t2));
    }
}
