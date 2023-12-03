package com.example;

import java.util.ArrayList;

public class ColourTable {

    int capacity;
    ArrayList colours;

    public ColourTable(int size) {
        if (size <= 1 || size >= 1025 || (size & (size - 1)) != 0) {
            throw new IllegalArgumentException("Palette size must be a power of two and between 2 and 1024.");
        }
        this.capacity = size;
        this.colours = new ArrayList<>(size);
    }
    public void add(int rgb) {
        // add method functionality
    }
}
