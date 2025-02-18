package com.techcrack.dsa.weeklyContest.Week1;

class CountNotSpecial {
    public int nonSpecialCount1(int l, int r) {
        int notSpecial = 0;

        for (int i = l; i < r + 1; i++) {
            if ((i != 2 && i != 4 && i % 2 == 0) || (i != 5 && i % 5 == 0)) {
                notSpecial++;
                continue;
            }

            if(findCount(i))
                notSpecial++;    
        }

        return notSpecial;
    }

    public boolean findCount(int target) {
        int divisors = 0;

        for (int i = 1; i < target; i++) {
            if (target % i == 0)
                divisors++;
            if (divisors > 2)
                return true;
        }

        return divisors < 2;
    }


    // Sieve of Eratosthenes
    public int nonSpecialCount(int l, int r) {
        int limit = (int) Math.sqrt(r);

        boolean[] isPrime = new boolean[limit + 1];

        isPrime[0] = isPrime[1] = true;

        for (int i = 2; i * i < limit + 1; i++) {
            if (! isPrime[i]) {
                for (int j = i * i; j < limit + 1; j += i) {
                    isPrime[j] = true;
                }
            }
        }

        int specialElements = 0;

        for (int i = 2; i < limit + 1; i++) {
            if (!isPrime[i]) {
                int range = i * i;

                if (range >= l && range <= r)
                    specialElements++;
            }
        }

        int totalElements = r - l + 1;

        return totalElements - specialElements;

    }
}