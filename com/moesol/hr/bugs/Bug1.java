package com.moesol.hr.bugs;

public class Bug1 {
    private Integer rating;

    public int rating() {
        return rating;
    }

    public static void main(String[] args) {
        System.out.println("rating:"
            + new Bug1().rating());
    }
}
