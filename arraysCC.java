package Arrays;

//import java.util.*;

public class arraysCC {
    public static int getLargest(int arr[]) {
        int largest = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            if(largest < arr[i]) {
                largest = arr[i];
            }
        }
        return largest;
    }

    public static int binSearch(int arr[], int key) {
        int start = 0;
        int end = arr.length-1;

        while(start <= end) {
            int mid = (start + end)/2;

            //comparison
            if(arr[mid] == key){
                return mid;
            }
            else if(arr[mid] < key) {
                start = mid + 1;
            } else {
                end = mid -1;
            }
        }
        return -1;

    }
    public static void reverse(int arr[]) {
        int first = 0, last = arr.length-1;
        while(first < last) {
            int temp = arr[last];
            arr[last] = arr[first];
            arr[first] = temp;

            first++;
            last--;
        }
    }
    public static void pairs(int arr[]) {
        int tp = 0;
        for(int i = 0 ; i < arr.length; i++){
            int curr = arr[i];
            for(int j = i+1 ; j < arr.length; j++){
                System.out.print("(" + curr + "," + arr[j] + ") ");
                tp++;
            }
            System.out.println();
        }
        System.out.println(tp);
    }
    public static void printSub(int arr[]) {
        int ts = 0;
        int max_sum = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            int start = i;
            for(int j = i; j < arr.length; j++) {
                int end = j;
                for(int k = start ; k <= end; k++) {
                    System.out.print(arr[k] + " ");
                    sum = sum + arr[k];
                    
                }
                if (sum > max_sum) {
                    max_sum = sum;
                }
                sum = 0;
                ts++;
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("Total Subarrays : " + ts);
        System.out.println("Max subarray sum is : " + max_sum);
    }
    public static void max_sum(int arr[]) {
        //int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++) {
            int start = i;
            for(int j = i; j < arr.length; j++) {
                int end = j;
                int currSum = 0;
                for(int k = start; k <= end; k++) {
                    currSum += arr[k];
                }
                if(currSum > maxSum) {
                    maxSum = currSum;
                }
                System.out.println(currSum);
            }
        }
        System.out.println("The max subArray sum is " + maxSum);
    }
    public static void prefixSum(int arr[]) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        int prefix[] = new int[arr.length];
        prefix[0] = arr[0];
        //Caculating prefix array
        for(int i = 1; i <= prefix.length; i++) {
            prefix[i] = prefix[i-1] + arr[i];
        }
        for(int i = 0; i < arr.length; i++) {
            int start = i;
            for(int j = i; j < arr.length; j++) {
                int end = j;

                currSum = (start == 0) ? prefix[end] : prefix[end] - prefix[start-1];
                if(currSum > maxSum) {
                    maxSum = currSum;
                }
            }
        }
    }
    public static void kadane(int arr[]) {
        int cs = 0; 
        int ms = Integer.MIN_VALUE;

        
        
        
    for(int i = 0; i < arr.length; i++) {
            
        cs += arr[i];
        if(cs < 0) {
            cs = 0;
        }
        ms = Math.max(cs, ms);
            
        
    }
       
        System.out.println("Our max subarray sum is " + ms);
    }
    public static int trappedRainwater(int arr[]) {
        int n = arr.length;

        //calculate for leftMax boundary - array
        int leftMax[] = new int[n];
        leftMax[0] = arr[0];
        for(int i = 1; i < n; i++) {
            leftMax[i] = Math.max(arr[i], leftMax[i-1]);
        }

        //calculate for rightMax boundary - array
        int rightMax[] = new int[n];
        rightMax[n-1] = arr[n-1];
        for(int i = n-2; i >= 0; i--) {
            rightMax[i] = Math.max(arr[i], rightMax[i+1]);
        }

        int trappedWater = 0;
        //loop

        for(int i = 0; i < n; i++) {
            //calculate waterlevel = min(leftmax bound, rightmax bound
            int waterLevel = Math.min(leftMax[i], rightMax[i]);

            trappedWater += waterLevel - arr[i];
        }
        return trappedWater;
    }
    
    public static int buyAndSellStock(int arr[]) {
        int buyP = Integer.MAX_VALUE;
        int maxP = 0;
        for(int i = 0; i < arr.length; i++) {
            if(buyP < arr[i]) { //profit
                int profit = arr[i] - buyP; //today's profit
                maxP = Math.max(maxP, profit);
            } else {
                buyP = arr[i];
            }
        }
        return maxP;
    }
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // int marks[] = new int[100];

        // System.out.println("length of array = " + marks.length);

        // marks[0] = sc.nextInt(); //phy
        // marks[1] = sc.nextInt(); //chem
        // marks[2] = sc.nextInt(); //math

        // System.out.println("Physics marks " + marks[0]);
        // System.out.println("Chemistry marks " + marks[1]);
        // System.out.println("Maths marks " + marks[2]);

        // int percentage = (marks[0] + marks[1] + marks[2])/3;
        // System.out.println("percentage : " + percentage + "%");
        // int arr[] = {3,6,2,12,9};

        // System.out.println("The largest value is : " + getLargest(arr));
        //sc.close();
        // int arr[] = {2,4,6,8,10,12};
        // int key = 21;

        // System.out.println("The key is present at " + binSearch(arr, key));
        int arr[] = {7, 1, 5, 3, 6, 4};
        //  reverse(arr);
        //  for(int i = 0; i < arr.length; i++){
        //     System.out.print(arr[i] + " ");
        // }
        // System.out.println();
        //pairs(arr);
        //printSub(arr);
        //max_sum(arr);

        System.out.println(buyAndSellStock(arr));

    }
}
