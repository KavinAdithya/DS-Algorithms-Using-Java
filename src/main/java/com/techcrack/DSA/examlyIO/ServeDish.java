package com.techcrack.dsa.examlyIO;

public class ServeDish {
    private static int[][] gradients;
    private static int[] grams;

    private static int serveDish(int index, int times) {
        if (index == gradients.length)
            return 1;

        int count = 0;

        for (int i = 0; i < gradients[0].length; i++) {
            if (times == -1) {
                int c = gradients[index][i] / grams[index];

                int ceilVal = (c + 1) * grams[index] / 10;
                int val = c * grams[index] / 10;

                if (val * 9 <= gradients[index][i] && val * 11 >= gradients[index][i])
                    count += serveDish(index + 1, c);
                else if (gradients[index][i] % grams[index] == grams[index] / 10 || (ceilVal * 9 <= gradients[index][i] && ceilVal * 11 >= gradients[index][i]))
                    count += serveDish(index + 1, c + 1);

            }
            else {
                int curVal = times * grams[index] / 10;

                if (curVal  * 9 <= gradients[index][i]  && curVal * 11 >= gradients[index][i])
                    count += serveDish(index + 1, times);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int n = 2;
        int m = 1;

        grams = new int[]{10};

//        gradients = new int[][]{
//                {1260, 1500, 700},
//                {800, 1440, 1600},
//                {1700, 1620, 900}
//        };

        gradients = new int[][]{
                {10, 11, 18, 13, 4, 15}
        };

        System.out.println(serveDish(0, -1));
    }
}
