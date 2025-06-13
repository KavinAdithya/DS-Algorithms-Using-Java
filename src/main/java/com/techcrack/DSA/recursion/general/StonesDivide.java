package com.techcrack.dsa.recursion.general;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StonesDivide {
    public static long stoneDivision(long n, List<Long> s) {
        s.sort(Comparator.reverseOrder());

        return countMoves(n, s, 0);
    }

    public static long countMoves(long stones, List<Long> s, int index) {
        if (index == s.size()) {
            return 0;
        }

        boolean isGoneInside = false;
        long count = 0;

        for (int i = index; i < s.size(); ++i) {
            long val = s.get(i);

            if (val != stones && stones % val == 0) {
                isGoneInside = true;

                long parts = stones / val;

                for (long j = 0; j < parts; ++j) {
                    count += countMoves(val, s, i + 1);
                }

                break;
            }
        }

        return isGoneInside ? count + 1 : 0;
    }

    public static void main(String[] args) {
        System.out.println(stoneDivision(12, Arrays.asList(4L, 2L, 3L)));
    }

    /**
     * Input
     * 5
     * 377083280820 10
     * 1 377083280820 2 188541640410 3 125694426940 4 94270820205 5 75416656164
     * 377083280820 9
     * 1 377083280820 2 188541640410 3 125694426940 94270820205 5 75416656164
     * 798652236637 2
     * 1 798652236637
     * 733493187656 6
     * 1 733493187656 2 366746593828 4 183373296914
     * 597670549095 5
     * 1 597670549095 3 199223516365 5
     */

    /**
     * Expected
     *282812460621
     * 188541640416
     * 1
     * 550119890745
     * 199223516366
     */
}
