package com.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ColourTableTest {

    @Test
    void testValidConstructor() {
        assertDoesNotThrow(() -> new ColourTable(8));
    }

    @Test
    void testConstructorInvalidSize() {
        assertThrows(IllegalArgumentException.class, () -> new ColourTable(3));
        assertThrows(IllegalArgumentException.class, () -> new ColourTable(1025));
    }

    @Test
    void testConstructorValidSizePowerOfTwo() {
        assertDoesNotThrow(() -> new ColourTable(2));
        assertDoesNotThrow(() -> new ColourTable(4));
        assertDoesNotThrow(() -> new ColourTable(16));
    }

    @Test
    void testAddValidColor() {
        ColourTable table = new ColourTable(4);
        assertDoesNotThrow(() -> table.add(0xFFFFFF)); // White color in RGB
    }

    @Test
    void testExceedingCapacityThrowsException() {
        ColourTable table = new ColourTable(2);
        table.add(0xFFFFFF); // White color
        table.add(0x000000); // Black color
        assertThrows(IllegalArgumentException.class, () -> table.add(0xFF0000)); // Red color
    }

}