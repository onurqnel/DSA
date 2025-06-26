import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// Approach 1: Brute Force
// Compares every pair of elements to check for duplicates.
// Time Complexity: O(n^2)
// Space Complexity: O(1)
class BruteForceApproach {
    public boolean hasDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true; // duplicate found
                }
            }
        }
        return false; // no duplicates
    }
}

// Approach 2: Sorting
// Sorts the array and checks adjacent elements for duplicates.
// Time Complexity: O(n log n) due to sorting
// Space Complexity: O(1) if in-place sort is allowed, otherwise O(n)
class SortingApproach {
    public boolean hasDuplicate(int[] nums) {
        Arrays.sort(nums); // sort the array in ascending order
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true; // duplicate found
            }
        }
        return false; // no duplicates
    }
}

// Approach 3: HashSet
// Uses a HashSet to track seen elements.
// If an element is already in the set, it's a duplicate.
// Time Complexity: O(n)
// Space Complexity: O(n)
class HashSetApproach {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return true; // duplicate found
            }
            seen.add(num); // mark as seen
        }
        return false; // no duplicates
    }
}

// Test class with example usage
public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 1 }; // Example input with a duplicate (1)

        System.out.println("Brute Force: " + new BruteForceApproach().hasDuplicate(nums));
        System.out.println("Sorting: " + new SortingApproach().hasDuplicate(nums));
        System.out.println("HashSet: " + new HashSetApproach().hasDuplicate(nums));
    }
}
