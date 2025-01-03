package com.techcrack.DSA.strings;

public class IP {
    public String defangIPaddr(String address) {
        // Second Optimized Solution
        // return address.replace(".", "[.]");

        // Optimized Solution
        StringBuilder newAddress = new StringBuilder();
        //newAddress.trimToSize();

        for (char ip : address.toCharArray()) {
            if (ip == '.') {
                newAddress.append("[.]");
                continue;
            }

            newAddress.append(ip);
        }

        return newAddress.toString();

        // Slow performance
        // return address.replaceAll("\\.", "[.]");
    }
}
