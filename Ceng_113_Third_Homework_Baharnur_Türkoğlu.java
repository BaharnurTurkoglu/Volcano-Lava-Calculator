package ceng_113_third_homework;

import java.util.Scanner;

public class Ceng_113_Third_Homework {

    static int[] rockFormation = new int[10];

    public static int puddle() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 10 numbers representing the rock formations in the valley: ");
        int value = 0;
        for (int i = 0; i < rockFormation.length; i++) {
            value = sc.nextInt();
            rockFormation[i] = value;
        }
        return value;
    }

    public static void main(String[] args) {
        puddle();
        boolean[] ignoreList = new boolean[rockFormation.length];

        int filledCellCount = 0;
        int maxIndex = findMaxValueIndex(rockFormation);
        int minIndex = -1;

        do {
            minIndex = findNotIgnoredMinValueIndex(rockFormation, ignoreList);
            int maxLeftIndex = findLeftMaxValueIndex(rockFormation, minIndex);
            int maxRightIndex = findRightMaxValueIndex(rockFormation, minIndex);
            int fillingFactor = fillFactor(rockFormation, minIndex, maxLeftIndex, maxRightIndex);
            if (fillingFactor == 0) {
                ignoreList[minIndex] = true;
                continue;
            }
            rockFormation[minIndex] += fillingFactor;
            filledCellCount += fillingFactor;
        } while (maxIndex != minIndex);
        System.out.println("There can be maximum observable amount of hot lava is (in cells): " + filledCellCount);
    }

    private static int findMaxValueIndex(int[] input) {
        int maxVal = 0;
        int maxIndex = 0;

        for (int i = 0; i < input.length; i++) {
            if (input[i] > maxVal) {
                maxIndex = i;
                maxVal = input[i];
            }
        }
        return maxIndex;
    }

    private static int findNotIgnoredMinValueIndex(int[] input, boolean[] ignoreList) {
        int minVal = Integer.MAX_VALUE;
        int minIndex = 0;

        for (int i = 0; i < input.length; i++) {
            if (!ignoreList[i] && input[i] < minVal) {
                minIndex = i;
                minVal = input[i];
            }
        }
        return minIndex;
    }
    
    // After finding not ignored minimum value, I should find the maximum value of minimum value's left.
    private static int findLeftMaxValueIndex(int[] input, int index) {
        for (int i = index; i >= 0; i--) {
            if (input[i] > input[index]) {
                return i;
            }
        }
        return -1;
    }
    
    // After finding not ignored minimum value, I should find the maximum value of minimum value's right.
    private static int findRightMaxValueIndex(int[] input, int index) {
        for (int i = index; i < input.length; i++) {
            if (input[i] > input[index]) {
                return i;
            }
        }
        return -1;
    }

    private static int fillFactor(int[] input, int minIndex, int maxLeftIndex, int maxRightIndex) {
        if (maxLeftIndex == -1 || maxRightIndex == -1) {
            return 0;
        }
        return Math.min(input[maxLeftIndex], input[maxRightIndex]) - input[minIndex];
    }
}
