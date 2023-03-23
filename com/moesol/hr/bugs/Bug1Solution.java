package com.moesol.hr.bugs;

public class Bug1Solution {
    private Integer rating;

    public Integer rating() {
        return rating;
    }

    public static void main(String[] args) {
        System.out.println("rating:"
            + new Bug1().rating());
    }
}
