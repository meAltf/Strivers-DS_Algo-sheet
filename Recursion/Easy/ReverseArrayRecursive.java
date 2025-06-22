package Recursion;


public class ReverseArrayRecursive {

    private static void swapNum(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private static int[] reverseArray1(int[] arr, int l, int r) {
        if (l >= r) return arr;
        swapNum(arr, l, r);
        reverseArray1(arr, l + 1, r - 1);
        return arr;
    }

    private static int[] reverseArray2(int[] arr, int i) {
        int n = arr.length;
        if (i >= n / 2) return arr;
        reverseArray2(arr, i + 1);
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 99};

        int[] result = reverseArray1(arr, 0, arr.length - 1);
        for (int num : result) System.out.print(num + " ");
        System.out.println();

        int[] result2 = reverseArray2(arr, 0);
        for (int num : result2) System.out.print(num + " ");
    }
}
