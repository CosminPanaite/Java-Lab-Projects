package com.company;

public class Main {

    public static void main(String[] args) {
        int nr1 = Integer.parseInt(args[0]);
        int nr2 = Integer.parseInt(args[1]);
        if (nr1 == 0 || nr2 == 0 || (nr1 == 0 && nr2 == 0)) {
            System.out.println("Values must be non-zero! ");
        } else {
            while (nr1 != nr2) {
                if (nr1 > nr2)
                    nr1 = nr1 - nr2;
                else
                    nr2 = nr2 - nr1;
            }

            System.out.println("the gcd of the numbers is: " +nr1);
        }

    }
}
