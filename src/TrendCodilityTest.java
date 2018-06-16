import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class TrendCodilityTest {
    
    public static void main (String[] args) {
        
        //System.out.println("Hello World~!");
        //System.out.println(""+repeatedSubstringPattern("ababab"));
        Integer[] arr = new Integer[]{1,2,3,4,null,null,5,6};
        //isSymmetric(constructBT(arr));
        String s = "15:15:00";
        String s2 = "15:15:12";
        int[][] intArr = new int[][]{{1,2}, {4,2}, {1,2}, {1,2}, {1,3}, {1,2}};
        int[] intArr2 = new int[]{1,1,1,1,0};
        System.out.println(s + " ~ " + s2);
        System.out.println("Flora: " + find_interesting_numbers(s, s2));
        System.out.println("Larry: " + solution1(s, s2));
    }
    
    // Trend Codility Test Problem 1 about digital clock
    public static int solution1 (String S, String T) {
        String[] start = S.split(":");
        String[] end = T.split(":");
        int startH = Integer.parseInt(start[0]);
        int startM = Integer.parseInt(start[1]);
        int startS = Integer.parseInt(start[2]);
        int endH = Integer.parseInt(end[0]);
        int endM = Integer.parseInt(end[1]);
        int endS = Integer.parseInt(end[2]);
        
        HashSet<Integer> set = new HashSet<Integer>();
        int res = 0;
        
        for (int i = startH; i <= endH; i++) {
            if (i == endH && i > startH) {
                startM = 0;
                endM = Integer.parseInt(end[1]);
            } else if (i > startH) {
                startM = 0;
                endM = 59;
            } else if (i == startH && startH < endH) {
                endM = 59;  
            }
            for (int j = startM; j <= endM; j++) {
                if (i == endH && j == endM && j > startM) {
                    startS = 0;
                    endS = Integer.parseInt(end[2]);
                } else if (j > startM) {
                    startS = 0;
                    endS = 59;
                } else if (i == startH && j == startM && startM < endM) {
                    endS = 59;
                }
                for (int k = startS; k <= endS; k++) {
                    set.add(i / 10);
                    set.add(i % 10);
                    set.add(j / 10);
                    set.add(j % 10);
                    set.add(k / 10);
                    set.add(k % 10);
                    if (set.size() <= 2) {
                        res++;
                        System.out.println("ans: "+ i + ":" + j + ":" + k);
                    }
                    set.clear();
                }
            } 
        }
        return res;
    }
    
    // Trend Codility Test Problem 1 about digital clock
    // test data by our selves "11:11:11", "11:12:00" 16
    public static int find_interesting_numbers(String start_time, String end_time) {
    int count = 0;

    while (less_equal_than(start_time, end_time)) {

        if(interesting(start_time)){
            count+=1;
        }

            start_time = increase(start_time);
        }
        return count;
    }

    
    public static boolean less_equal_than(String time_1, String time_2) {
        String[] time_array_1 = time_1.split(":");
        int h1 = Integer.parseInt(time_array_1[0]);
        int m1 = Integer.parseInt(time_array_1[1]);
        int s1 = Integer.parseInt(time_array_1[2]);
        
        String[] time_array_2 = time_2.split(":");
        int h2 = Integer.parseInt(time_array_2[0]);
        int m2 = Integer.parseInt(time_array_2[1]);
        int s2 = Integer.parseInt(time_array_2[2]);
        
        int h3 = 0;
        int m3 = 0;
        int s3 = 0;
        
        s3 = s2 - s1;
        if (s3 < 0) {
            m2-=1;
            s3+=60;
        }
        
        m3 = m2 - m1;
        if (m3 < 0) {
            h2-=1;
            m3+=60;
        }
        
        h3 = h2 - h1;
        if (h3 < 0) {
            return false;
        } else {
            return true;
        }
        
    }
    
    public static String increase(String time) {
        String[] time_array = time.split(":");
        int hours = Integer.parseInt(time_array[0]);
        int mins  = Integer.parseInt(time_array[1]);
        int secs  = Integer.parseInt(time_array[2]);

        int c = 0;

        if(secs < 59){
            secs+=1;
        } else {
            secs = 0;
            c =1;
        }
        
        String increment = hours +":" + mins + ":" + secs;
        if (c == 0) {
            return increment;
        }
        
        c = 0;
        
        if (mins < 59) {
            mins+=1;
        } else {
            mins = 0;
            c = 1;
        }
        
        increment = hours+":"+mins+":"+secs;
        if (c == 0) {
            return increment;
        }
        
        if (hours < 23) {
            hours += 1;
        } else {
            hours = 0;
            c = 1;
        }
        
        increment = hours+":"+mins+":"+secs;
        return increment;
    }
    
    public static boolean interesting (String target) {
        HashMap<Character, Boolean> map = new HashMap<Character, Boolean>();
        String time = target.replace(":", "");
        for (int i = 0; i < time.length(); i++) {
            map.put(time.charAt(i), true);
        }
        if (map.size() > 2) {
            return false;
        } else if (map.size() == 2) {
            return true;
        } else {
            return false;
        }
    }
    
    
    // Trend Codility Test problem 2 about "(())"
    // (())))(
    public static int solution2(String S) {
        
        int length = S.length();
        int leftIndex = -1;
        int rightIndex = length;
        int leftCount = 0;
        int rightCount = 0;
        
        while (rightIndex - leftIndex > 1) {
            if (leftCount <= rightCount) {
                leftIndex++;
                if (S.charAt(leftIndex) == '(') {
                    leftCount++;
                }
            } else {
                rightIndex--;
                if (S.charAt(rightIndex) == ')') {
                    rightCount++;
                }
            }
        }
        // because we move leftIndex first when leftCount <= rightCount
        // if leftCount > rightCount, it is because the last char at leftIndex is (
        // so we can do leftIndex-- to get the right answer
        if (leftCount > rightCount) {
            leftIndex--;
        } 
        
        //System.out.println("left: " + leftCount + "  right: " + rightCount);
        // array index to number
        return leftIndex + 1;
        
        // submitted answer
        /*
        int length = S.length();
        int[] left = new int[length];
        int[] right = new int[length];
        int leftCount = 0;
        int rightCount = 0;
        
        for (int i = 0; i < length; i++) {
            if (S.charAt(i) == '(') {
                left[i] = ++leftCount;
            } else {
               left[i] = leftCount;
            }
            if (S.charAt(length - 1 - i) == ')') {
                right[length - 1 - i] = ++rightCount;
            } else {
                right[length - 1 - i] = rightCount;
            }
        }
        
        if (left[length - 1] == 0) {
            return length;
        } else if (right[0] == 0) {
            return 0;
        }
        
        for (int i = 0; i < length - 2; i++) {
            if (left[i] == right[i + 1]) {
                return i + 1;
            }
        }
        return length;
        
//        while (start < length) {
////            while (S.charAt(start) != '(') {
////                start++;
////            }
////            while (S.charAt(end) != ')') {
////                end--;
////            }
////            start++;
////            end--;
//        }
//        return start;
        */
    }
    
    
    
    // Trend Codility Test Problem 3 about max distinct value on tree paths 
    public static int solution3(Tree T) {
        int max = 0;
        
        Stack<Tree> stack = new Stack<Tree>();
        Stack<Tree> stack2 = new Stack<Tree>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        stack.push(T);

        map.put(T.x, map.getOrDefault(T.x, 0) + 1);
        
        while (!stack.isEmpty()) {
            Tree node = stack.peek();
            
            if (!stack2.isEmpty() && stack.peek() == stack2.peek()) {
                stack.pop();
                stack2.pop();
                
                if (map.get(node.x) == 1) {
                    map.remove(node.x);
                    System.out.println("remove: " + node.x);
                } else {
                    map.put(node.x, map.get(node.x) - 1);
                    System.out.println("put--: " + node.x);
                }
                continue;
            }
            
            stack2.push(node);
            map.put(node.x, map.getOrDefault(node.x, 0) + 1);
            System.out.println("put: " + node.x);
            
            if (node.r != null) {
                stack.push(node.r);
            }
            if (node.l != null) {
                stack.push(node.l);
            }
            if (node.l == null && node.r == null) {
                max = Math.max(max, map.size());
            }
        }
        
        return max;
    }
    
    //Definition for a binary tree node.
    public static class Tree {
        int x;
        Tree l;
        Tree r;
        Tree(int i) { x = i; }
    }
    
    
}
