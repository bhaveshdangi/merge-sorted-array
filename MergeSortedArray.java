import java.util.Arrays;
import java.util.stream.Collectors;

public class MergeSortedArray {

    private static int[] mergeSortedArray(int[] arr1, int[] arr2) {

        if (arr1 == null && arr2 == null) {
            return null;
        } else if (arr1 == null) {
            return arr2;
        } else if (arr2 == null) {
            return arr1;
        }
        int totalSize = arr1.length + arr2.length;
        int[] result = new int[totalSize];
        int index = 0, index1 = 0, index2 = 0;
        for (; index < totalSize && index1 < arr1.length && index2 < arr2.length; index++) {
            if (arr1[index1] <= arr2[index2]) {
                result[index] = arr1[index1++];
            } else {
                result[index] = arr2[index2++];
            }
        }
        while (index1 < arr1.length) {
            result[index++] = arr1[index1++];
        }
        while (index2 < arr2.length) {
            result[index++] = arr2[index2++];
        }
        return result;
    }

    public static void main(String[] args) {

        int[] result = mergeSortedArray(new int[]{1, 3, 5, 7, 8}, new int[]{2, 4, 6, 9, 10});

        System.out.println(Arrays.stream(result).boxed().collect(Collectors.toList()));
    }
}
