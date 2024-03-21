package March_20_Assignments;
import java.util.*;

public class Q3_sumFourExists {
    public static String fourSumExists(int[] arr, int N, int TARGET) {
        Map<Integer, List<int[]>> pairSumIndices = new HashMap<>();

        // Step 1: Populate the hash map with pair sums and their indices
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                int pairSum = arr[i] + arr[j];
                if (!pairSumIndices.containsKey(pairSum)) {
                    pairSumIndices.put(pairSum, new ArrayList<>());
                }
                pairSumIndices.get(pairSum).add(new int[]{i, j});
            }
        }

        // Step 2: Check for four elements summing up to the target
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                int currentSum = arr[i] + arr[j];
                int complement = TARGET - currentSum;

                if (pairSumIndices.containsKey(complement)) {
                    for (int[] pairIndices : pairSumIndices.get(complement)) {
                        // Check if the four indices are different
                        if (pairIndices[0] != i && pairIndices[1] != i &&
                                pairIndices[0] != j && pairIndices[1] != j) {
                            return "Yes";
                        }
                    }
                }
            }
        }

        // Step 3: If no such four elements found, return "No"
        return "No";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("enter the size of the array :");
            int N = scanner.nextInt(); // Size of the array
        System.out.println("enter the target sum :");
            int TARGET = scanner.nextInt(); // Target sum
            int[] arr = new int[N]; // Array elements
        System.out.println("ente the element of array :");
            for (int i = 0; i < N; i++) {
                arr[i] = scanner.nextInt();
            }

            System.out.println(fourSumExists(arr, N, TARGET));
        }

    }

