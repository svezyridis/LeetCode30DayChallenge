import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Given an array of strings, group anagrams together.
 * <p>
 * Example:
 * <p>
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * Note:
 * <p>
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 */
public class Day6_GroupAnagrams {
    //beats 59.97%
    class Solution {

        public int xor(String a) {
            int[] result = new int[256];
            for (int i = 0; i < a.length(); i++) {
                result[a.charAt(i)]++;
            }
            return Arrays.hashCode(result);
        }

        public List<List<String>> groupAnagrams(String[] strs) {

            HashMap<Integer, List<String>> map = new HashMap();
            for (int i = 0; i < strs.length; i++) {
                int xor = xor(strs[i]);

                if (map.containsKey(xor)) {
                    map.get(xor).add(strs[i]);
                } else {
                    List<String> temp = new ArrayList();
                    temp.add(strs[i]);
                    map.put(xor, temp);
                }
            }
            List<List<String>> result = new ArrayList<List<String>>(map.values());
            return result;
        }
    }
}
