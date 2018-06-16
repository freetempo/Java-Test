import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;


public class leetCodeTest {
    
	public static void main (String[] args) {
		
		System.out.println("Hello World~!");
		//System.out.println(""+repeatedSubstringPattern("ababab"));
		Integer[] arr = new Integer[]{1};
		// 4,5,6,4,null,1,6,5
		//isSymmetric(constructBT(arr));
		int[] intArr = new int[]{1,4,3,2};
		System.out.println("Hello World~! " + wordPattern("abba","cat dog dog cat") );
		//printList(constructList(intArr));

	}
	
	// <-------------  main
	
	// 14. Longest Common Prefix
    public String longestCommonPrefix(String[] strs) {
        int length = strs.length;
        if (length == 0) {
            return "";
        }
        String res = strs[0];
        for (int i = 0; i < length; i++) {
            if (strs[i].length() == 0) {
                return "";
            }
            for (int j = 0; j < Math.min(res.length(), strs[i].length()); j++) {
                if (res.charAt(j) != strs[i].charAt(j)) {
                    if (j == 0) {
                        return "";
                    } else {
                        res = res.substring(0, j);
                        break;
                    }
//                    if (j == strs[i].length() - 1) {
//                        if (j != res.length() - 1) {
//                            res = res.substring(0, j);
//                        } else {
//                            res = res = res.substring(0, j);
//                        }
//                        break;
//                    }
                }
                if (j == strs[i].length() - 1 && j != res.length() - 1) {
                    res = res.substring(0, j + 1);
                }
            }
        }
        return res;
    }
	
	
	// 58. Length of Last Word
    public int lengthOfLastWord(String s) {
        String[] array = s.split(" ");
        if (array.length == 0) {
            return 0;
        } else {
            return array[array.length - 1].length();
        }
    }
	
	
	// 598. Range Addition II
    public int maxCount(int m, int n, int[][] ops) {
        int min1 = m;
        int min2 = n;
        for (int i = 0; i < ops.length; i++) {
            min1 = Math.min(min1, ops[i][0]);
            min2 = Math.min(min2, ops[i][1]);
        }
        return min1 * min2;
    }
	
	
	// 599. Minimum Index Sum of Two Lists
    public String[] findRestaurant(String[] list1, String[] list2) {
        int length1 = list1.length;
        int length2 = list2.length;
        int minIndexSum = 20000;
        
        Map<String, Integer> map = new HashMap<String, Integer>();
        List<String> list = new ArrayList<String>();
        
        for (int i = 0; i < length1; i++) {
            map.put(list1[i], i);
        }
        
        for (int i = 0; i < length2; i++) {
            if (map.containsKey(list2[i])) {
                if (i + map.get(list2[i]) < minIndexSum ) {
                    minIndexSum = i + map.get(list2[i]);
                    list.clear();
                    list.add(list2[i]);
                } else if (i + map.get(list2[i]) == minIndexSum ) {
                    list.add(list2[i]);
                }
            }
        }
        
        String[] res = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
	
	// 67. Add Binary
    public static String addBinary(String a, String b) {
        int length1 = a.length();
        int length2 = b.length();
        
        if (length1 == 0) {
            return b;
        } else if (length2 == 0) {
            return a;
        }
        
        // reverse original strings
        String string1 = "";
        String string2 = "";
        for (int i = length1 - 1; i >= 0; i--) {
            string1 += a.charAt(i);
        }
        for (int i = length2 - 1; i >= 0; i--) {
            string2 += b.charAt(i);
        }
        
        String res = "";
        int x = 0;
        int y = 0;
        int c = 0;
        
        for (int i = 0; i < Math.max(length1, length2); i++) {
            if (i >= length1) {
                x = 0;
            } else {
                x = Integer.parseInt(""+string1.charAt(i));
            }
            if (i >= length2) {
                y = 0;
            } else {
                y = Integer.parseInt(""+string2.charAt(i));
            }
            
            int temp = x + y + c;
            res += (temp % 2);
            c = temp / 2;
        }
        if (c == 1) {
            res += "1";
        }
        
        String s = "";
        for (int i = res.length() - 1; i >= 0; i--) {
            s += res.charAt(i);
        }
        return s;
    }
	
	
	// 88. Merge Sorted Array
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2.length == 0) {
            return;
        }
        // move back
        for (int i = m - 1; i >= 0; i--) {
            nums1[i + n] = nums1[i];
        }
        int index1 = n;
        int index2 = 0;
        
        for (int i = 0; i < m + n; i++) {
            if (index1 == n + m) {
                nums1[i] = nums2[index2];
                index2++;
            } else if (index2 == n) {
                nums1[i] = nums1[index1];
                index1++;
            } else {
                if (nums1[index1] <= nums2[index2]) {
                    nums1[i] = nums1[index1];
                    index1++;
                } else {
                    nums1[i] = nums2[index2];
                    index2++;
                }
            }
        }
        
    }
	
	// 203. Remove Linked List Elements
    public ListNode removeElements(ListNode head, int val) {
        ListNode newHead = head;
        if (head == null) {
            return head;
        }
        
        while (head != null && head.next != null) {
            if (head.next.val == val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        if (newHead.val == val ) {
            return newHead.next;
        }
        return newHead;
    }
	
	// 219. Contains Duplicate II
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        if (nums.length <= 1) {
            return false;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            } else {
                map.put(nums[i], i);
            }
        }
        
        return false;
    }
	
	
	// 234. Palindrome Linked List
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<Integer>();
        ListNode node = head;
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }
        Integer[] array = list.toArray(new Integer[list.size()]);
        int start = 0;
        int end = array.length -1;
        while (start <= end) {
            if (!array[start].equals(array[end])) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
	
	
	// 290. Word Pattern
    public static boolean wordPattern(String pattern, String str) {
        if (str == "" || str == null) {
            return false;
        }
        String[] strArray = str.split(" ");
        if (strArray.length != pattern.length()) {
            System.out.println("1");
            return false;
        }
        System.out.println(strArray.length);
        HashMap<Character, String> map = new HashMap<Character, String>();
        
        for (int i = 0; i < pattern.length(); i++) {
            if (map.containsKey(pattern.charAt(i))) {
                if (!map.get(pattern.charAt(i)).equals(strArray[i])) {
                    System.out.println("2 " + i + " " + map.get(pattern.charAt(i)) + " " + strArray[i]);
                    return false;
                }
            } else if (map.containsValue(strArray[i])) {
                System.out.println("3");
                return false;
            } else {
                map.put(pattern.charAt(i), strArray[i]);
            }
        }
        
        return true;
    }
	
	
	// 111. Minimum Depth of Binary Tree
	public int minDepth = -1;
	//public int pathSum;
    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
        int min = 0;
        int levelCount = 1;
        int nodeCount = 0;
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.left == null && node.right == null) {
                return min + 1;
            }            
            
            if (node.left != null) {
                queue.offer(node.left);
                nodeCount++;
            }
            if (node.right != null) {
                queue.offer(node.right);
                nodeCount++;
            }
            if (--levelCount == 0) {
                min++;
                levelCount = nodeCount;
                nodeCount = 0;
            }
        }
        return min;
    }
    
	
	
	// 1. Two Sum
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            } else {
                map.put(target - nums[i], i);
            }
        }
        return new int[]{0, 0};
    }
	
	
	// 20. Valid Parentheses
    public boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<Character>();
        for (char c: s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char c2 = stack.pop();
                    if ( (c == ')' && c2 != '(') || (c == ']' && c2 != '[') || (c == '}' && c2 != '{')) {
                        return false;
                    }
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
	
	
	// 507. Perfect Number
    public static boolean checkPerfectNumber(int num) {
        if (num <= 1) {
            return false;
        }
        
        int sum = 0;
        
        for (int i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                sum += i;
                sum += (num / i);
            }
            if (i == Math.sqrt(num) && i * i == num) {
                sum -= i;
            }
        }
        
        if (sum == num * 2) {
            return true;
        } else {
            return false;
        }
    }
	
	
	// 205. Isomorphic Strings
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        } else if (s.length() == 0) {
            return true;
        }
        
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                if (map.containsValue(t.charAt(i))) {
                    return false;
                }
                map.put(s.charAt(i), t.charAt(i));
            } else {
                if (map.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            }
        }
        
        return true;
    }
	
	
	
	
	// 438. Find All Anagrams in a String
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<Integer>();
        if (s.length() < p.length()) {
            return list;
        }
        int[] count = new int[26];
        for (int i = 0; i < p.length(); i++) {
            count[p.charAt(i) - 'a']++;
        }
        
        for (int i = 0; i < s.length(); i++) {
            int[] tempCount = Arrays.copyOf(count, count.length);
            
            for (int j = 0; j < p.length() && i + j < s.length(); j++) {
                tempCount[s.charAt(i+j) - 'a']--;
                if (tempCount[s.charAt(i+j) - 'a'] < 0) {
                    break;
                }
                if (j == p.length() - 1) {
                    list.add(i);
                }
            }
        }        
        return list;
    }
	
	// 112. Path Sum
    public boolean hasPathSum(TreeNode root, int sum) {
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        stack1.push(root);
        
        if (root == null) {
            return false;
        }
        
        int pathSum = 0;
        
        while (!stack1.isEmpty()) {
            TreeNode node = stack1.peek();
            if (!stack2.isEmpty() && node == stack2.peek()) {
                stack1.pop();
                stack2.pop();
                pathSum -= node.val;
                continue;
            }
            pathSum += node.val;
            
            if (node.left == null && node.right == null) {
                if (pathSum == sum) {
                    return true;
                }
                stack1.pop();
                pathSum -= node.val;
                continue;
            }
            
            if (node.right != null) {
                stack1.push(node.right);
            }
            if (node.left != null) {
                stack1.push(node.left);
            }
            stack2.push(node);
        }
        return false;
    }
	
	// 38. Count and Say
    public static String countAndSay(int n) {
        if (n < 1) {
            return "";
        }
        String res = "1";
        char target = res.charAt(0);
        int count = 0;
        
        while (n > 1) {
            String temp = "";
            for (int i = 0; i < res.length(); i++) {
                if (res.charAt(i) != target) {
                    temp += count;
                    temp += target;
                    target = res.charAt(i);
                    count = 1;
                } else {
                    count++;
                }
            }
            System.out.println(count);
            System.out.println(target);
            temp += count;
            temp += target;
            res = temp;
            System.out.println(res);
            target = res.charAt(0);
            count = 0;
            n--;
        }
        return res;
    }
	
	// 594. Longest Harmonious Subsequence
    public int findLHS(int[] nums) {
        int length = nums.length;
        if (length == 0 || length == 1) {
            return 0;
        }
        
        Arrays.sort(nums);
        int max = 0;
        int count1 = 0;
        int count2 = 0;
        int target = nums[0];
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                count1++;
            } else if (nums[i] == target + 1) {
                count2++;
            } else {
                if (count2 > 0) {
                    max = Math.max(max, count1 + count2);
                }
                if (nums[i] == target + 2 && count2 > 0) {
                    count1 = count2;
                    count2 = 1;
                    target += 1;
                } else {
                    count1 = 1;
                    count2 = 0;
                    target = nums[i];
                }
            }
        }
        if (count2 > 0) {
            max = Math.max(max, count1 + count2);
        }
        return max;
    }
	
	// 374. Guess Number Higher or Lower
	/* The guess API is defined in the parent class GuessGame.
	   @param num, your guess
	   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
	      int guess(int num); */
    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        int target = (low + high) / 2;
        int judge;
        
        while (low < high) {
            target = (low + high) / 2;
            judge = guess(target);
            if (judge == 0) {
                return target;
            } else if (judge == 1) {
                low = target + 1;
            } else {
                high = target - 1;
            }
        }
        
//        while (judge != 0) {
//            if (judge == 1) {
//                low = target + 1;
//            } else if (judge == -1) {
//                high = target - 1;
//            }
//            target = (low + high) / 2;
//            judge = guess(target);
//        }
        
        return target;
    }
    // for compile
    public int guess(int n) {
        return 0;
    }
	
	// 9. Palindrome Number
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else if (x < 10) {
            return true;
        }
        int num = x;
        int digits = 0;
        
        while (num > 0) {
            num /= 10;
            digits++;
        }
        
        int digit1 = 0;
        int digit2 = digits - 1;
        while (digit1 < digit2) {
            if (getDigit(x, digit1) != getDigit(x, digit2)) {
                return false;
            }
            digit1++;
            digit2--;
        }
        return true;
    }
    
    public int getDigit(int num, int digit) {
        while (digit != 0) {
            num /= 10;
            digit--;
        }
        return num % 10;
    }
	
	// 572. Subtree of Another Tree
    public boolean isSubtree(TreeNode s, TreeNode t) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(t);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            //compare
            if (compareSubTree(node, s)) {
                return true;
            }
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return false;
    }
    public boolean compareSubTree (TreeNode tree1, TreeNode tree2) {
        if (tree1.val != tree2.val) {
            return false;
        }
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        stack1.push(tree1);
        stack2.push(tree2);
        
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            TreeNode node1 = stack1.pop();
            TreeNode node2 = stack2.pop();
            
            if ((node1.left == null && node2.left != null) || (node1.left != null && node2.left == null)
                    || (node1.right == null && node2.right != null) || (node1.right != null && node2.right == null)
                    || node1.val != node2.val) {
                return false;
            }
            
            if (node1.right != null) {
                stack1.push(node1.right);
                stack2.push(node2.right);
            }
            
            if (node1.left != null) {
                stack1.push(node1.left);
                stack2.push(node2.left);
            }
        }
        return true;
    }
	
	
	// 563. Binary Tree Tilt
	public int res = 0;
    public int findTilt(TreeNode root) {
        //int res = 0;
        treeSum(root);       
        return res;
    }
	
    public int treeSum(TreeNode root) {
        if (root == null) {
            // tilt is zero
            return 0;
        }
        
        int leftSum = treeSum(root.left);
        int rightSum = treeSum(root.right);
        
        res += Math.abs(leftSum - rightSum);
        return leftSum + rightSum + root.val;    
    }
    
	
	// 575. Distribute Candies
    public int distributeCandies(int[] candies) {
        Arrays.sort(candies);
        int kinds = 1;
        int n = candies.length;
        
        for (int i = 1; i < n; i++) {
            if (candies[i] != candies[i - 1]) {
                kinds++;
            }
        }
        
        return kinds > (n / 2) ? (n / 2) : kinds;
    }
	
	
	// 566. Reshape the Matrix
    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        int rOri = nums.length;
        int cOri = nums[0].length;
        
        if (rOri * cOri != r * c) {
            return nums;
        }
        
        int [][] res = new int[r][c];
        
        int iNew = 0;
        int jNew = 0;
        
        for (int i = 0; i < rOri; i++) {
            for (int j = 0; j < cOri; j++) {
                res[jNew][iNew] = nums[i][j];
                iNew = (iNew + 1) % c;
                if (iNew == 0) {
                    jNew = (jNew + 1) % r;
                }
            }
        } 
        
        return res;
    }
	
	
	// 561. Array Partition I
    public static int arrayPairSum(int[] nums) {
        int sum = 0;
        
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                sum += nums[i];
            }
        }
        return sum;
    }
	
	// 141. Linked List Cycle
    public boolean hasCycle(ListNode head) {
        // HashSet
        HashSet<ListNode> set = new HashSet<ListNode>();
        if (head == null || head.next == null) {
            return false;
        }
        set.add(head);
        
        while (head.next != null) {
            head = head.next;
            if (!set.add(head)) {
                return true;
            }
        }
        return false;
    }
	
	
	
	// Trend Codility Test Problem 3 about max distinct value on tree paths 
    public static int solution3(TreeNode T) {
        int max = 0;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        stack.push(T);

        map.put(T.val, map.getOrDefault(T.val, 0) + 1);
        
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            
            if (!stack2.isEmpty() && stack.peek() == stack2.peek()) {
                stack.pop();
                stack2.pop();
                
                if (map.get(node.val) == 1) {
                    map.remove(node.val);
                    System.out.println("remove: " + node.val);
                } else {
                    map.put(node.val, map.get(node.val) - 1);
                    System.out.println("put--: " + node.val);
                }
                continue;
            }
            
            stack2.push(node);
            map.put(node.val, map.getOrDefault(node.val, 0) + 1);
            System.out.println("put: " + node.val);
            
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.left == null && node.right == null) {
                max = Math.max(max, map.size());
            }
        }
        
        return max;
    }
	
	
	
	// 141. Linked List Cycle
//    public boolean hasCycle(ListNode head) {
//        
//    }
	
	
	// 26. Remove Duplicates from Sorted Array
    public static int removeDuplicates(int[] nums) {
        int res = 0;
        int length = nums.length;
        if (length == 0 || length == 1) {
            return length;
        }
        
        for (int i = 1; i < length; i++) {
            if (nums[res] == nums[i]) {
                continue;
            } else {
                res++;
                nums[res] = nums[i];
            }
        }
        return res + 1;
    }
	
	
	// 172. Factorial Trailing Zeroes
    public int trailingZeroes(int n) {
        int res = 0;
        while (n != 0) {
            n /= 5;
            res += n;
        }
        return res;
    }
	
	
	// 119. Pascal's Triangle II
    public static List<Integer> getRow(int rowIndex) {
        // math
        List<Integer> list = new ArrayList<Integer>();
        for (int i = rowIndex; i >= 0; i--) {
            list.add(combination(rowIndex, i));
            //System.out.print(combination(rowIndex, i) + " ");
        }
        return list;
    }
    public static int combination (int a, int b) {
        double res = 1;
        if (b == 0) {
            return 1;
        }
        if (b > a / 2) {
            b = a - b;
        }
        for (int i = 1; i <= b; i++) {
            res *= a;
            res /= i;
            a--;
        }
        return (int)res;
    }
	
	
	// 441. Arranging Coins
    public static int arrangeCoins(int n) {
        //long temp = (long)2 * n;
        //temp *= 2;
        long candidate = (long)Math.sqrt((long)2 * n);
        System.out.println("" + candidate);
//        System.out.println("" + Math.sqrt(2 * n));
        //System.out.println("" + (2 * n));
        for (long i = candidate; i > 0 ; i--) {
            System.out.println("i: " + i);
            if (i * (i + 1) / 2 <= n) {
                return (int)i;
            }
        }
        return n;
        //////////////// up AC
        
//        int sum = 0;
//        for (int i = 1; i <= n; i++) {
//            sum += i;
//            if (sum > n) {
//                return i - 1;
//            }
//        }
//        return n;
//        int low = 0;
//        int high = n;
//        int temp = n / 2;
//        int res = 1;
//        if (n <= 0) {
//            return 0;
//        }
//        while (res <= n) {
//            if ((res + 1) * res / 2 > n) {
//                return res - 1;
//            }
//            res++;
//        }
//        return res;
//        while (!(n >= (temp + 1) * temp / 2 && n < (temp + 2) * (temp + 1) / 2)) {
//            if (n < (temp + 1) * temp / 2) {
//                high = temp;
//                temp = (low + high) / 2;
//            } else if (n > (temp + 2) * (temp + 1) / 2) {
//                low = temp;
//                temp = (low + high) / 2;
//            } else if (n == (temp + 2) * (temp + 1) / 2) {
//                return temp + 1;
//            }
//        }
        //return temp;
        
    }
	
	
	// 110. Balanced Binary Tree
    public static boolean isBalanced(TreeNode root) {
        System.out.println("" + balanceCal(root));
        if (balanceCal(root) == -1) {
            return false;
        } else {
            return true;
        }
    }
    
    public static int balanceCal (TreeNode node) {
        if (node == null) {
            return 0;
        }
//        } else if (node.right == null && node.left == null) {
//            return 1;
//        } else if (node.right == null) {
//            return balanceCal(node.left) + 1;
//        } else if (node.left == null) {
//            return balanceCal(node.right) + 1;
//        }
        
        int rightVal = balanceCal(node.right);
        int leftVal = balanceCal(node.left);
        if (rightVal == -1 || leftVal == -1) {
            return -1;
        } else if (Math.abs(rightVal - leftVal) <= 1) {
            return Math.max(rightVal, leftVal) + 1;
        }
        return -1;
    }
	
	//257. Binary Tree Paths
    public static List<String> binaryTreePaths(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<TreeNode> list = new ArrayList<TreeNode>();
        List<String> res = new ArrayList<String>();
        stack.push(root);
        
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node == null) {
                stack.pop();
                continue;
            }
            // list.add(node);
            if (list.size() > 0 && node == list.get(list.size()-1)) {
                stack.pop();
                list.remove(list.size()-1);
                continue;
            }
            
            if (node.left == null && node.right == null) {
                // print path
                String resString = "";
                list.add(node);
                for (int i = 0; i < list.size(); i++) {
                    resString += list.get(i).val;
                    if (i != list.size() - 1) {
                        resString += "->";
                    }
                }
                res.add(resString);
                stack.pop();
                list.remove(list.size() - 1);
                continue;
            }
            
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
            
            list.add(node);
        }
        
        return res;
    }

	// 434. Number of Segments in a String
    public static int countSegments(String s) {
        
        // pre-process
        while (s.indexOf(" ") == 0) {
            s = s.substring(1);
        }
        //System.out.println("length: " + s.length());
        if (s.length() == 0) {
            return 0;
        }
        while (s.lastIndexOf(" ") == s.length() - 1) {
            System.out.println(s);
            if (s.length() == 1) {
                return 0;
            }
            s = s.substring(0, s.length() - 1);
            System.out.println("hihihi");
        }
        
        if (s == "") {
            return 0;
        }
        //System.out.println(s);
        int count = 1;
        int index = s.indexOf(" ");
        //int last = 0;
        // String sub;
        while ( index >= 0) {
            if (index == 0) {
                s = s.substring(index + 1);
                index = s.indexOf(" ");
                continue;
            }
            count ++;
            s = s.substring(index + 1);
            index = s.indexOf(" ");
        }
        return count;
    }
	
	// 118. Pascal's Triangle
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (numRows == 0) {
            return list;
        } 
        
        for (int i = 1; i <= numRows; i++) {
            List<Integer> tempList = new ArrayList<Integer>();
            for (int j = 1; j <= i; j++) {
                if (j == 1 || j == i) {
                    tempList.add(1);
                } else {
                    tempList.add(list.get(i-2).get(j-2) + list.get(i-2).get(j-1));
                }
            }
            list.add(tempList);
        }
        return list;
    }
	
	// 66. Plus One
    public static int[] plusOne(int[] digits) {
        int carry = 1;
        boolean allDigitsIsOne = true;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (carry == 0) {
                break;
            } else if (digits[i] <= 8) {
                digits[i]++;
                carry = 0;
                break;
            } else {
                digits[i] = 0;
                carry = 1;
            }
        }
        
        if (carry == 1) {
            int [] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                newDigits[i+1] = digits[i];
            }
            return newDigits;
        } else {
            return digits;
        }
        
    }
	
	// 101. Symmetric Tree
    public static boolean isSymmetric(TreeNode root) {
        
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        
        Stack<TreeNode> stackLeft = new Stack<TreeNode>();
        Stack<TreeNode> stackRight = new Stack<TreeNode>();
        
        stackLeft.push(root);
        stackRight.push(root);
        
        while (!stackLeft.isEmpty()) {
            TreeNode nodeLeft = stackLeft.pop();
            TreeNode nodeRight = stackRight.pop();
            if (nodeLeft == root.right && nodeRight == root.left) {
                break;
            }
            
            if (nodeLeft.val != nodeRight.val) {
                return false;
            }

            if ((nodeLeft.right == null ^ nodeRight.left == null) 
                    || (nodeLeft.left == null ^ nodeRight.right == null)) {
                return false;
            }
            
            if (nodeLeft.right != null) {
                stackLeft.push(nodeLeft.right);
                stackRight.push(nodeRight.left);
            }
            
            if (nodeLeft.left != null) {
                stackLeft.push(nodeLeft.left);
                stackRight.push(nodeRight.right);
            }
        }
        
        return true;   
    }
	
	// 345. Reverse Vowels of a String
    public static String reverseVowels(String s) {
//        List<Character> vowels = new ArrayList<Character>();
//        vowels.add('a');
//        vowels.add('e');
//        vowels.add('i');
//        vowels.add('o');
//        vowels.add('u');
//        vowels.add('A');
//        vowels.add('E');
//        vowels.add('I');
//        vowels.add('O');
//        vowels.add('U');
        
        //Stack<Character> stack = new Stack<Character>();
        List<Integer> list = new ArrayList<Integer>();
        
        for (int i = 0; i < s.length(); i++) {
            if (isVowels(s.charAt(i))) {
                list.add(i);
            }
        }
        char[] charArray = s.toCharArray();
        
        for (int i = 0; i < list.size(); i++) {
            int j = list.size() - 1 - i;
            
            if (i >= j) {
                break;
            }
            char temp = charArray[list.get(i)];
            charArray[list.get(i)] = charArray[list.get(j)];
            charArray[list.get(j)] = temp;
            
        }
        
        return new String(charArray);
        //Character[] res = new Character[s.length()];
//        String res = "";
//        for (int i = 0; i < s.length(); i++) {
//            if (isVowels(s.charAt(i))) {
//                res += Character.toString(stack.pop());
//            } else {
//                res += s.charAt(i);
//            }
//        }
//        
//        return new String(res);
        
    }
    
    public static boolean isVowels (Character c) {
        if (c == 'a') {
            return true;
        }  else if (c == 'e') {
            return true;
        }  else if (c == 'i') {
            return true;
        }  else if (c == 'o') {
            return true;
        }  else if (c == 'u') {
            return true;
        }  else if (c == 'A') {
            return true;
        }  else if (c == 'E') {
            return true;
        }  else if (c == 'I') {
            return true;
        }  else if (c == 'O') {
            return true;
        }  else if (c == 'U') {
            return true;
        }
        return false;
    }
    
	
	// 342. Power of Four
    public static boolean isPowerOfFour(int num) {
        int mask = 0b01010101010101010101010101010101;
        return Integer.bitCount(num & mask) == 1 && (num >= 0) && Integer.bitCount(num) == 1;
    }
	
	// 27. Remove Element
    public int removeElement(int[] nums, int val) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                count++;
                continue;
            }
            nums[i - count] = nums[i];
        }
        return nums.length - count;
    }
	
	// 198. House Robber
    public static int rob(int[] nums) {
        
        // 用DP
        int[][] sumArray = new int[nums.length][2];
        
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                sumArray[i][0] = nums[i];
                sumArray[i][1] = 0;
            } else if (i == 1) {
                sumArray[i][0] = nums[i];
                sumArray[i][1] = sumArray[i-1][0];
            } else {
                sumArray[i][0] = nums[i] + Math.max(sumArray[i-1][1], sumArray[i-2][1]);
                sumArray[i][1] = Math.max(sumArray[i-1][0], sumArray[i-2][0]);
            }
        }
        return Math.max(sumArray[nums.length-1][0], sumArray[nums.length-1][1]);
    
          // 用 recursive 結果 TLE 
//        if (nums.length == 1) {
//            return nums[0];
//        } else if (nums.length == 2) {
//            return Math.max(nums[0], nums[1]);
//        } else if (nums.length == 0) {
//            return 0;
//        } else {
//            return Math.max(nums[0] + rob(Arrays.copyOfRange(nums, 2, nums.length)), 
//                            rob(Arrays.copyOfRange(nums, 1, nums.length)));
//        }
    }
	


	// 501. Find Mode in Binary Search Tree
    public int[] findMode(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> res = new ArrayList<Integer>();
        int[] resArray = new int[0];
        
        if (root == null) {
            return resArray;
        }
        
        stack.push(root);
        
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            map.put(node.val, map.getOrDefault(node.val, 0) + 1);
           
           if (node.right != null) {
               stack.push(node.right);
           }
           if (node.left != null) {
               stack.push(node.left);
           }
        }
        
        int maxValue = 0;
        for (Map.Entry<Integer, Integer> entry: map.entrySet() ) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                res = new ArrayList<Integer>();
                res.add(entry.getKey());
            } else if (entry.getValue() == maxValue) {
                res.add(entry.getKey());
            }
        }
        
        resArray = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resArray[i] = res.get(i);
        }

        return resArray;
    }
	
	
	
	
	// 459. Repeated Substring Pattern
    public static boolean repeatedSubstringPattern(String s) {
        
    	List<Character> list = new ArrayList<Character>();
        
        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i));
            // check
            int k = 0;
            for (int j = i + 1; j < s.length(); j++) {
                
                // j%i
                if (list.get(k % list.size()) != s.charAt(j)) {
                	//System.out.println("i: " + i + " k: " + k + " j: " + j + " listSize: " + list.size());
                    break;
                }
                
                // check successful
                if (j == s.length() - 1 && k % list.size() == list.size() - 1) {
                    return true;
                }
                k++;
            }
        }
        
        return false;
    }
    
    // Definition for singly-linked list node.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    
    // construct singly-linked list
    public static ListNode constructList (int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        ListNode head = new ListNode(nums[0]);
        ListNode node = head;
        
        for (int i = 1; i < nums.length; i++) {
            ListNode tempNode = new ListNode(nums[i]);
            node.next = tempNode;
            node = tempNode;
        }
        return head;
    }
    
    // print binary tree
    public static void printList (ListNode head) {
        System.out.print("[");
        
        ListNode node = head;
        while (node != null) {
            System.out.print(node.val);
            node = node.next;
            if (node != null) {
                System.out.print(", ");
            }
        }
        
        System.out.print("]");
    }
    
    
    //Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    
    // construct binary tree
    public static TreeNode constructBT (Integer[] nums) {
        if (nums.length == 0) {
            return null;
        } else if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode root = new TreeNode(nums[0]);
        queue.offer(root);
        //System.out.println("" + nums[0]);
        
        int i = 1;
        //for (int i = 1; i < nums.length; i++) {
        while (i < nums.length) {
            TreeNode node = queue.poll();
            if (nums[i] == null) {
                node.left = null;
            } else {
                node.left = new TreeNode(nums[i]);
                ///////System.out.println("" + nums[i]);
                queue.offer(node.left);
            }
            i++;
            if (i == nums.length) {
                break;
            }
            if (nums[i] == null) {
                node.right = null;
            } else {
                node.right = new TreeNode(nums[i]);
                ///////System.out.println("" + nums[i]);
                queue.offer(node.right);
            }
            i++;
        }
        return root;
    }
    
    // print binary tree
    public static void printBT (TreeNode root) {
        System.out.print("[");
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                System.out.print("null");
                
            } else {
                System.out.print("" + node.val);
                if (node.left != null || node.right != null) {
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
            if (!queue.isEmpty()) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
	
}
