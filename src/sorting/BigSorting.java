package sorting;

import java.util.Comparator;
import java.util.Scanner;

class StringNumberComparator implements Comparator<String> {
    public int compare(String x, String y) {
        if (x.length() == y.length())
            return x.compareTo(y);
        return x.length() - y.length();
    }
}

public class BigSorting {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] arrToSort = new String[n];
        for (int i = 0; i < n; i++)
            arrToSort[i] = scanner.next();
        bigSorting(arrToSort);
        for (int i = 0; i < n; i++)
            System.out.println(arrToSort[i]);
    }

    public static void bigSorting(String[] unsorted) {
        mergeSort(unsorted, 0, unsorted.length-1);
    }

    public static void mergeSort(String[] arr, int left, int right) {
        if (arr.length == 1)
            return;
        int mid = (right+left)/2;
        int leftSize = mid-left+1;
        int rightSize = right-mid;
        String[] leftSide = new String[leftSize];
        String[] rightSide = new String[rightSize];
        for (int i = 0; i < leftSize; i++)
            leftSide[i] = arr[i];
        for (int i = 0; i < rightSize; i++)
            rightSide[i] = arr[i+(mid+1)];
        mergeSort(leftSide, 0, leftSide.length-1);
        mergeSort(rightSide, 0, rightSide.length-1);
        mergeArray(arr, leftSide, rightSide, leftSize, rightSize);
    }

    public static void mergeArray(String[] arr, String[] leftside, String[] rightSide,
                                  int leftSize, int rightSize) {
        int iArr = 0;
        int iLeft = 0;
        int iRight = 0;
        StringNumberComparator comparator = new StringNumberComparator();
        while (iLeft<leftSize && iRight<rightSize) {
            if (comparator.compare(leftside[iLeft], rightSide[iRight]) < 0) {
                arr[iArr] = leftside[iLeft];
                iLeft++;
            } else {
                arr[iArr] = rightSide[iRight];
                iRight++;
            }
            iArr++;
        }
        while (iLeft < leftSize) {
            arr[iArr] = leftside[iLeft];
            iArr++;
            iLeft++;
        }
        while (iRight < rightSize) {
            arr[iArr] = rightSide[iRight];
            iArr++;
            iRight++;
        }
    }
}
