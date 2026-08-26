package com.example.Articfact;

import java.time.LocalDate;

public class Dates {
    private LocalDate returnDate;

    public Dates() {
    }

    public Dates(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}
