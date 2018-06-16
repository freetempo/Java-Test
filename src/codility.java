import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class codility {
    
    public static void main (String[] args) {
        
        System.out.println("Hello World~!");
        //System.out.println(""+repeatedSubstringPattern("ababab"));
        Integer[] arr = new Integer[]{1,2,3,4,null,null,5,6};
        //isSymmetric(constructBT(arr));
        String s = "(()))(()()())))";
        int[][] intArr = new int[][]{{1,2}, {4,2}, {1,2}, {1,2}, {1,3}, {1,2}};
        int[] intArr2 = new int[]{1,1,1,1,0};
        System.out.println("Hello World~! " + find_interesting_numbers("11:11:11", "11:12:00"));
    }
    
    // main <---
    
    // Trend Codility Test Problem 1 about digital clock
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
    
    


//
//
//def find_interesting_numbers(start_time, end_time)
//    count = 0
//
//    while (less_equal_than(start_time, end_time)) do
//
//        if(interesting? start_time)
//            count+=1
//            puts "interesting!"
//        end
//
//        start_time = increase(start_time)
//    end
//    return count
//end
//
//S = "15:15:00"
//T = "15:15:12"
//
//answer = find_interesting_numbers(S, T)
//
//puts answer

    
    
    
    //
//    public static int solution22(String S) {
//        int length = S.length();
//        int leftCount = 0;
//        int rightCount = length - 1;
//        
//        for (int i = 0; i < length; i++) {
//            if (S.charAt(i) == '(') {
//                leftCount++;
//                while () {
//                    
//                }
//            }
//        }
//    }
    
    // Trend Codility Test problem 2 about "(())"
    public static int solution2(String S) {
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
    }
    
    
    // Clocks (13%) trainingPNVGQC-2E5/
    public static int Clocks(int[][] A, int P) {
        // brute force
        int N = A.length;       // clocks        
        int M = A[0].length;    // hands
        int res = 0;
        System.out.println("N: " + N);
        
        // special cases
        if (N <= 1) {
            return 0;
        }
        
        // sort hands first
        for (int i = 0; i < N; i++) {
            Arrays.sort(A[i]);
        }
        
        // clock 1
        for (int i = 0; i < N - 1; i++) {
            // clock 2
            for (int j = i + 1; j < N; j++) {
                // rotate
                for (int k = 0; k < P; k++) {
                    // for each hands, checking
                    for (int l = 0; l < M; l++) {
                        if (A[i][l] != ((A[j][l] + k) % P + 1)) {
                            break;
                        }
                        // match
                        if (l == M - 1) {
                            res++;
                            System.out.println("i: " + i + " j: " + j);
                        }
                    }
                }
            }
        }
        
        return res;
    }
    
    // Lesson 9.  MaxDoubleSliceSum (69%) training2DWWAK-TCD
    public static int solution(int[] A) {
        int length = A.length;
        int[] leftMax = new int[length];
        int[] rightMax = new int[length];
        int leftMaxElement = A[1];
        int rightMaxElement = A[length - 2];
        int ending = 0;
        
        if (length <= 3) {
            return 0;
        } else if (length == 4) {
            return Math.max(A[1], A[2]);
        }
        
        leftMax[0] = 0;
        rightMax[length - 1] = 0;
        
        // left max
        for (int i = 1; i < length; i++) {
            ending = Math.max(0, ending + A[i]);
            // !!! 要改這裡 因為A[i]一定要算進去
            //leftMax[i] = Math.max(leftMax[i-1], ending);
            leftMax[i] = ending;
            leftMaxElement = Math.max(leftMaxElement, A[i]);
            if (leftMaxElement <= 0) {
                leftMax[i] = leftMaxElement;
            }
            System.out.print(leftMax[i] + " ");
        }
        System.out.println(" ");
        
        ending = 0;
        
        //right max
        for (int i = length -2; i >= 0; i--) {
            ending = Math.max(0, ending + A[i]);
            rightMax[i] = Math.max(rightMax[i+1], ending);
            // !!! 要改這裡 因為A[i]一定要算進去
            // rightMaxElement = Math.max(rightMaxElement, A[i]);
            rightMaxElement = ending;
            if (rightMaxElement <= 0) {
                rightMax[i] = rightMaxElement;
            }
            System.out.print(rightMax[i] + " ");
        }
        System.out.println(" ");
        
        int res = leftMax[0] + rightMax[2];
        for (int i = 1; i < length - 2; i++) {
            res = Math.max(res, leftMax[i - 1] + rightMax[i + 1] );
        }
        return res;
    }
    
    
    // Lesson 9. MaxSliceSum
    public static int MaxSliceSum(int[] A) {
        int length = A.length;
        int end = 0;
        int max = 0;
        int maxElement = A[0];
        if (length == 1) {
            return A[0];
        }

        for (int i = 0; i < length; i++) {
            end = Math.max(0, end + A[i]);
            max = Math.max(max, end);
            maxElement = Math.max(maxElement, A[i]);
        }
        
        if (maxElement <= 0) {
            return maxElement;
        } else {
            return max;
        }
    }
    
    
    // Lesson 9. MaxProfit
    public static int MaxProfit(int[] A) {
        int length = A.length;
        if (length <= 1) {
            return 0;
        } else if (length == 2) {
            return Math.max(0, A[1] - A[0]);
        }
        int ending = 0;
        int max = 0;
        int[] values = new int[length - 1];
        
        for (int i = 0; i < length - 1; i++) {
            values[i] = A[i + 1] - A[i];
        }
        
        for (int i = 0; i < length - 1; i++) {
            ending = Math.max(0, ending + values[i]);
            max = Math.max(max, ending);
        }
        
        return max;
    }
    
    // Lesson 8.  Dominator
    public static int Dominator(int[] A) {
        // find the leader
        int length = A.length;
        int count = 0;
        int leader = 0;
        Stack<Integer> stack = new Stack<Integer>();
        
        for (int i = 0; i < length; i++) {
            if (stack.isEmpty() || stack.peek() == A[i]) {
                stack.push(A[i]);
            } else {
                stack.pop();
            }
        }
        
        if (stack.empty()) {
            return -1;
        } else {
            leader = stack.pop();
        }
        
        int res = 0;
        
        for (int i = 0; i < length; i++) {
            if (A[i] == leader) {
                count++;
                res = i;
            }
        }
        
        if (count <= length / 2) {
            return -1;
        }
        
        return res;
    }
    
    
    // Lesson 8. EquiLeader
    public static int EquiLeader(int[] A) {
        // find leader
        int length = A.length;
        int leader = 0;
        int count = 0;
        int res = 0;
        Stack<Integer> stack = new Stack<Integer>();
        
        for (int i = 0; i < length; i++) {
            if (stack.isEmpty() || stack.peek() == A[i]) {
                stack.push(A[i]);
            } else {
                stack.pop();
            }
        }
        if (!stack.isEmpty()) {
            leader = stack.pop();
        }
        for (int i = 0; i < length; i++) {
            if (A[i] == leader) {
                count++;
            }
        }
        
        int tempCount = 0;
        for (int i = 0 ; i < length; i++) {
            if (A[i] == leader) {
                tempCount++;
            }
            if (tempCount > (i + 1) / 2 && (count - tempCount) > (length - i - 1) / 2) {
                res++;
            }
        }
        return res;
    }
    
    
    // Lesson 7. StoneWall
    public static int StoneWall(int[] H) {
        int length = H.length;
        int res = 0;
        Stack<Integer> stack = new Stack<Integer>();
        
        if (length == 0) {
            return 0;
        }
        
        for (int i = 0; i < length; i++) {
            if (stack.isEmpty() || stack.peek() < H[i]) {
                stack.push(H[i]);
            } else if (stack.peek() > H[i]){
               while (!stack.isEmpty() && stack.peek() > H[i]) {
                   stack.pop();
                   res++;
               }
               if (stack.isEmpty() || stack.peek() != H[i]) {
                   stack.push(H[i]);
               }
            }
        }
        
        while (!stack.isEmpty()) {
            stack.pop();
            res++;
        }
        return res;
    }
    
    // Lesson 7. Nesting (跟Brackets跟brackets騎士是一模一樣的題目)
    public static int Nesting(String S) {
        int length = S.length();
        Stack<Character> stack = new Stack<Character>();
        
        for (int i = 0; i < length; i++) {
            if (S.charAt(i) == '(') {
                stack.push(S.charAt(i));
            } else if (S.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    return 0;
                } else {
                    stack.pop();
                }
            }
        }

        return stack.isEmpty() ? 1 : 0; 
    }
    
    
    // Lesson 7. Fish
    public static int solution(int[] A, int[] B) {
        int length = A.length;
        int res = 0;
        Stack<Integer> stack = new Stack<Integer>();
        
        for (int i = 0; i < length; i++) {
            if (B[i] == 0) {
                if (stack.isEmpty()) {
                    res++;
                } else {
                    while (!stack.isEmpty()) {
                        if (A[i] > stack.peek()) {
                            stack.pop();
                            if (stack.isEmpty()) {
                                res++;
                            }
                        } else {
                            break;
                        }
                    }
                }
            } else if (B[i] == 1) {
                stack.push(A[i]);
            }
        }
        
        while (!stack.isEmpty()) {
            stack.pop();
            res++;
        }
        return res;
        
    }
    
    
    // Lesson 7. Brackets
    public static int Brackets(String S) {
        int length = S.length();
        Stack<Character> stack = new Stack<Character>();
        
        for (int i = 0; i < length; i++) {
            if (S.charAt(i) == '{' || S.charAt(i) == '[' || S.charAt(i) == '(') {
                stack.push(S.charAt(i));
            } else if (S.charAt(i) == '}') {
                // 記得要先判斷empty 不然會stack empty exception!
                if (stack.isEmpty() || stack.pop() != '{') {
                    return 0;
                }
            } else if (S.charAt(i) == ']') {
                if (stack.isEmpty() || stack.pop() != '[') {
                    return 0;
                }
            } else if (S.charAt(i) == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return 0;
                }
            }
        }

        return stack.isEmpty() ? 1 : 0; 
    }
    
    
    
    // Lesson 6. MaxProductOfThree
    public static int MaxProductOfThree(int[] A) {
        int length = A.length;
        if (length < 3) {
            return 0;
        } else if (length == 3) {
            return A[0] * A[1] * A[2];
        }
        Arrays.sort(A);
        
//        if (A[length - 1] <= 0) {
//            return A[length - 1] * A[length - 2] * A[length -3];
//        } else if (A[length - 2] == 0 || A[length - 3] == 0) {
//            return A[length - 1] * A[0] * A[1];
//        }
        
        return Math.max(A[length - 1] * A[length - 2] * A[length - 3], A[length - 1] * A[0] * A[1]);
    }
    
    
    // Lesson 6. Triangle (93%) overflow test, 3 MAXINTs, got 0 expected 1, WRONG ANSWER 
    public static int Triangle(int[] A) {
        int length = A.length;
        
        if (length < 3) {
            return 0;
        }
        Arrays.sort(A);
        
        for (int i = 0; i < length - 2; i++) {
            if (A[i] + A[i + 1] > A[i + 2]) {
                return 1;
            }
        }
        
        return 0;
        
    }
    
    
    // Lesson 6. Distinct
    public static int Distinct(int[] A) {
        int length = A.length;
        int res = 1;
        Arrays.sort(A);
        if (length == 1) {
            return 1;
        } else if (length == 0) {
            return 0;
        }
        
        for (int i = 1; i < length; i++) {
            if (A[i] != A[i - 1]) {
                res++;
            }
        }
        return res;
    }
    
    //  Lesson 5. GenomicRangeQuery (75%) training3PKSGS-THM 
    public static int[] GenomicRangeQuery(String S, int[] P, int[] Q) {
        int length = S.length();
        int[] SValue = new int[length];
        int[][] count = new int[length][4];
        
        for (int i = 0; i < length; i++) {
            if (S.charAt(i) == 'A') {
                SValue[i] = 0;
                count[i][0] = i > 0 ? count[i-1][0] + 1 : 1;
                count[i][1] = i > 0 ? count[i-1][1] : 0;
                count[i][2] = i > 0 ? count[i-1][2] : 0;
                count[i][3] = i > 0 ? count[i-1][3] : 0;
            } else if (S.charAt(i) == 'C'){
                SValue[i] = 1;
                count[i][1] = i > 0 ? count[i-1][1] + 1 : 1;
                count[i][0] = i > 0 ? count[i-1][0] : 0;
                count[i][2] = i > 0 ? count[i-1][2] : 0;
                count[i][3] = i > 0 ? count[i-1][3] : 0;
            } else if (S.charAt(i) == 'G'){
                SValue[i] = 2;
                count[i][2] = i > 0 ? count[i-1][2] + 1 : 1;
                count[i][1] = i > 0 ? count[i-1][1] : 0;
                count[i][0] = i > 0 ? count[i-1][0] : 0;
                count[i][3] = i > 0 ? count[i-1][3] : 0;
            } else if (S.charAt(i) == 'T'){
                SValue[i] = 3;
                // 這個62% 而且四個if裡面都有
                //count[i][3] = i > 0 ? count[i-1][3] + 1 : count[i][3]++;
                count[i][3] = i > 0 ? count[i-1][3] + 1 : 1;
                count[i][1] = i > 0 ? count[i-1][1] : 0;
                count[i][2] = i > 0 ? count[i-1][2] : 0;
                count[i][0] = i > 0 ? count[i-1][0] : 0;
            }
            System.out.println(count[i][0] + " " + count[i][1] + " " + count[i][2] + " " + count[i][3] + " " );
        }
        
        int lengthM = P.length;
        int[] res = new int[lengthM];
        
        for (int i = 0; i < lengthM; i++) {
            if (P[i] == Q[i]) {
                res[i] = SValue[P[i]] + 1;
            } else if (P[i] == 0) {
                if (count[Q[i]][0] > 0) {
                    res[i] = 1;
                } else if (count[Q[i]][1] > 0) {
                    res[i] = 2;
                } else if (count[Q[i]][2] > 0) {
                    res[i] = 3;
                } else if (count[Q[i]][3] > 0) {
                    res[i] = 4;
                } 
            } else {
                if (count[Q[i]][0] - count[P[i]-1][0]> 0) {
                    res[i] = 1;
                } else if (count[Q[i]][1] - count[P[i]-1][1] > 0) {
                    res[i] = 2;
                } else if (count[Q[i]][2] - count[P[i-1]][2] > 0) {
                    res[i] = 3;
                } else if (count[Q[i]][3] - count[P[i-1]][3] > 0) {
                    res[i] = 4;
                } 
            }
            System.out.print(res[i] + " ");
        }
        
        return res;
    }
    
    
    // Lesson 5. PassingCars
    public static int PassingCars(int[] A) {
        int length = A.length;
        int eastCars = 0;
        long res = 0;
        
        for (int i = 0; i < length; i ++) {
            if (A[i] == 0) {
                eastCars++;
            } else if (A[i] == 1) {
                res += eastCars;
            }
            if (res > 1000000000) {
                return -1;
            }
        }
        
        return (int)res;
    }
    
    // Lesson 5. CountDiv
    public static int CountDiv(int A, int B, int K) {
       //加了這段62% 因為10 10 5要return 1 instead 0 
//        if (A == B) {
//            return 0;
//        }
        int num1 = A / K;
        int num2 = B / K;
        return A % K == 0? num2 - num1 + 1 : num2 - num1;
    }
    
    // Lesson 4. MaxCounters (88%)
    public static int[] MaxCounters(int N, int[] A) {
        int length = A.length;
        int tempMax = 0;
        int addValue = 0;
        int[] counters = new int[N];
        
        for (int i = 0; i < length; i++) {
            if (A[i] == N + 1) {
                // 加這個if之後100% 否則88% 錯在A裡面全都是max operation然後A超大
                if (tempMax != 0) {
                    addValue += tempMax;
                    tempMax = 0;
                    counters = new int[N];
                }
            } else {
                counters[A[i] - 1] ++;
                tempMax = Math.max(tempMax, counters[A[i] - 1]);
            }
        }
        
        for (int i = 0; i < N; i++) {
            counters[i] += addValue;
            System.out.print(counters[i] + " ");
        }
        
        return counters;
    }
    
    
    // Lesson 4. MissingInteger
    public static int MissingInteger(int[] A) {
        int length = A.length;
        int[] arr = new int[length + 1];
        
        for (int i = 0; i < length; i++) {
            if (A[i] > 0 && A[i] <= length + 1 ) {
                arr[A[i] - 1]++;
            }
        }
        
        for (int i = 0; i < length + 1; i++) {
            if (arr[i] == 0) {
                return i + 1;
            }
        }
        return length + 1;
    }
    
    // Lesson 4. FrogRiverOne (90%) 錯在(5, [3])
    public static int FrogRiverOne(int X, int[] A) {
        int length = A.length;
        int[] arr = new int[length];
        int leafNum = 0;
        for (int i = 0; i < length; i++) {
            // fix
            if (A[i] - 1 >= length ) {
                continue;
            }
            //
            arr[A[i] - 1]++;
            if (arr[A[i] - 1] == 1) {
                leafNum++;
            }
            if (leafNum == X) {
                return i;
            }
        }
        return -1;
    }
    
    
    // Lesson 4. PermCheck
    public static int PermCheck(int[] A) {
       int length = A.length;
       int[] arr = new int[length];
       
       for (int i = 0; i < length; i++) {
           if (A[i] - 1 < length && A[i] - 1 >= 0) {
               arr[A[i]-1]++;
           }
       }
       
       for (int i = 0; i < length; i++) {
           if (arr[i] != 1) {
               return 0;
           }
       }
       return 1;
    }
    
    
    // Lesson 3. TapeEquilibrium (75%) (-10, 10)會錯 答案應該要是20
    public static int TapeEquilibrium(int[] A) {
        if (A.length == 0) {
            return 0;
        } else if (A.length == 1) {
            return A[0];
        }
        
        int sum = 0;
        int min = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        min = Math.abs(sum - A[0]);
        int tempSum = 0;
        for (int i = 0; i < A.length - 1; i++) {
            tempSum += A[i];
            min = Math.min(min, Math.abs(tempSum - (sum - tempSum)));
        }
        return min;
    }
    
    
    
    // Lesson 3. FrogJmp 
    public static int FrogJmp(int X, int Y, int D) {
        int totalDistance = Y - X;
        
        if (totalDistance <= 0) {
            return 0;
        }
        
        return totalDistance % D == 0? totalDistance / D : (totalDistance / D) + 1;   
    }
    
    
    // Lesson 3. PermMissingElem (70%)
    public static int PermMissingElem(int[] A) {
        int length = A.length;
        if (length == 0) {
            //return 0;
            return 1;
        }
        
        //int sum = ((length * length) + (3 * length) + 2 ) / 2;
        long sum = ((length * length) + (3 * length) + 2 ) / 2;
        
        for (int i = 0; i < length; i++) {
            sum -= A[i];
        }
        
        return (int)sum;
    }
    
    // Lesson 2. CyclicRotation (62%)
    public static int[] CyclicRotation(int[] A, int K) {
        int length = A.length;
        int prevIndex = 0;
        int prev = A[prevIndex];
        
        for (int i = 0; i < length; i++) {
            int index = (prevIndex + K) % length;
            int tempValue = A[index];
            A[index] = prev;
            prev = tempValue;
            prevIndex = index;
        }
        
        // print
        for (int i = 0; i < length; i++) {
            System.out.print(" " + A[i]);
        }
        
        return A;
    }
    
    
    // Lesson 2. OddOccurrencesInArray
    public static int OddOccurrencesInArray(int[] A) {
        int res = 0;
        for (int value : A) {
            res ^= value;
        }
        return res;
    }
    
    
    // Lesson 1. BinaryGap
    public static int BinaryGap (int N) {
        int max = 0;
        int zeros = 0;
        boolean start = false;
        
        while (N != 0) {
            if ((N & 1) == 1) {
                start = true;
                max = Math.max(max, zeros);
                zeros = 0;
            } else if (start) {
                zeros++;
            }
            N >>>= 1;
        }
        return max;
    }
    
}
