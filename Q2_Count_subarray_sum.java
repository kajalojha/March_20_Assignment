package March_20_Assignments;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q2_Count_subarray_sum {
    public static int countSubarrayWithSum(int[] arr, int n, int k) {
        int count = 0; //count of sub array with sum equal to k
        int sum = 0;// initiallize the current sum of element
        Map<Integer, Integer> sumFreq = new HashMap<>();// map to store frequency
        sumFreq.put(0, 1);
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            // If sum - K exists in the map, add its frequency to the count
            if (sumFreq.containsKey(sum - k)) {
                count += sumFreq.get(sum - k);
            }
            //update frequency of the current sum in map
            sumFreq.put(sum, sumFreq.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       
        System.out.println("enter the size of array :");
            int N = scanner.nextInt(); // Size of the array
        System.out.println("enter target sum :");
            int K = scanner.nextInt(); // Target sum
            int[] arr = new int[N]; // Array elements

            // Read the array elements
        System.out.println("enter the element : ");
            for (int i = 0; i < N; i++) {
                arr[i] = scanner.nextInt();
            }
            System.out.println(countSubarrayWithSum(arr, N, K));
        }
    }
