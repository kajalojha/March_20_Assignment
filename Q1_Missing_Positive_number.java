package March_20_Assignments;

import java.util.Scanner;

public class Q1_Missing_Positive_number {

        // Method to find the first missing positive integer in linear time and constant space
        public static int firstMissingPositive(int[] nums) {
            int n = nums.length;

            // Step 1: Mark non-positive numbers with a value greater than N
            for (int i = 0; i < n; i++) {
                if (nums[i] <= 0) {
                    nums[i] = n + 1;
                }
            }

            // Step 2: Mark elements that exist in the array
            for (int i = 0; i < n; i++) {
                int num = Math.abs(nums[i]);
                if (num <= n) {
                    nums[num - 1] = -Math.abs(nums[num - 1]);
                }
            }

            // Step 3: Find the first missing positive integer
            for (int i = 0; i < n; i++) {
                if (nums[i] > 0) {
                    return i + 1;
                }
            }

            // If all positive integers from 1 to N exist in the array, return N+1
            return n + 1;
        }

        // Main method
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Prompt the user to input the number of elements in the array
            System.out.println("Enter the number of elements in the array:");
            int n = scanner.nextInt();

            // Create an array of size 'n' to store the elements
            int[] arr = new int[n];

            // Prompt the user to input the elements of the array
            System.out.println("Enter the elements of the array:");
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            // Call the method to find the first missing positive integer and print the result
            System.out.println("Output: " + firstMissingPositive(arr));

            scanner.close(); // Close the scanner to avoid resource leak
        }
    }
