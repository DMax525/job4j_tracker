package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

class ItemSortByNameTest {

    @Test
    public void whenAsc() {
        List<Item> items = new ArrayList<>();
        items.add(new Item(1, "Stas"));
        items.add(new Item(2, "Alex"));
        items.add(new Item(3, "Peter"));

        items.sort(new ItemAscByName());

        List<Item> expected = new ArrayList<>();
        expected.add(new Item(2, "Alex"));
        expected.add(new Item(3, "Peter"));
        expected.add(new Item(1, "Stas"));
        assertEquals(items, expected);
    }

    @Test
    public void whenDesc() {
        List<Item> items = new ArrayList<>();
        items.add(new Item(1, "Stas"));
        items.add(new Item(2, "Alex"));
        items.add(new Item(3, "Peter"));

        items.sort(new ItemDescByName());

        List<Item> expected = new ArrayList<>();
        expected.add(new Item(1, "Stas"));
        expected.add(new Item(3, "Peter"));
        expected.add(new Item(2, "Alex"));
        assertEquals(items, expected);
    }
}