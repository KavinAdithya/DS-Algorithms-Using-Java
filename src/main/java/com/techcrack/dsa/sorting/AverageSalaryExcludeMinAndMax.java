package com.techcrack.dsa.sorting;

class AverageSalaryExcludeMinAndMax {
    public double average(int[] salary) {
        if (salary == null || salary.length < 3) 
            return 0.0;
        
        int n = salary.length;
        int maxIndex = 0;
        int minIndex = 0;

        for (int i = 0; i < n; i++) {
            if (salary[i] > salary[maxIndex])
                maxIndex = i;
            if (salary[i] < salary[minIndex])
                minIndex = i;
        }

        int totSal = 0;

        for (int i = 0; i < n; i++) {
            if (i != minIndex && i != maxIndex)
                totSal += salary[i];
        }

        return totSal / (n - 2.0);
    }
}