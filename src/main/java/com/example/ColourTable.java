package com.example;

import java.util.ArrayList;

public class ColourTable {
    int capacity = 0;
    int max;
    ArrayList colours;
    public ColourTable() {
        throw new IllegalArgumentException("Must specify size of Colour Table");
    }
    public ColourTable(int size) {
        if (size <= 1 || size >= 1025 || (size & (size - 1)) != 0) {
            throw new IllegalArgumentException("Palette size must be a power of two and between 2 and 1024.");
        }
        this.max = size;
        this.colours = new ArrayList<>(size);
    }
    public void add(int rgb) {
        if (colours.size() >= max) {
            throw new IllegalArgumentException("Exceeded the capacity of the ColourTable.");
        }
        if ((rgb & 0xFF000000) != 0) {
            throw new IllegalArgumentException("Invalid 24-bit RGB value.");
        }
        if (!colours.contains(rgb)) {
            // only adds unique colours to palette
            colours.add(rgb);
            this.capacity += 1;
        }
    }
    public int length(){
        return this.capacity;
    }
}
