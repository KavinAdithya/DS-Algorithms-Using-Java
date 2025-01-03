package com.techcrack.DSA.arrayBinarySearch;

public class RichestCustomerWealth {

    /*
     *Given an a 2D array
     * Each index represent a single customer
     * The index sum value is represent the how much amount they have in their account
     * Find the customer maximum amount
     */
    public int maximumWealth(int[][] accounts) {
        int maxAmount=0;
        int counter=0;
        int customer=0;
        int singleCustomer=0;

        //iterating the customer
        while(customer<accounts.length){
            singleCustomer+=accounts[customer][counter];
            counter++;

            if(counter==accounts[customer].length){
                counter=0;
                customer++;
                if(maxAmount<singleCustomer){
                    maxAmount=singleCustomer;
                }
                singleCustomer=0;
            }


        }

        return maxAmount;
    }

    //Another way of iterating
    public int customer(int[][] accounts){
        int maxAmount=0;
        for(int[] customer:accounts){
            int count=0;
            for(int amount:customer){
                count+=amount;
            }
            if(count>maxAmount)
                maxAmount=count;
        }
        return maxAmount;
    }

}
