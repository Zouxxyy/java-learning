package com.zouxxyy.corejava.chap9.treeSet;

import java.util.*;

/**
 * 程序9-4
 * Item类，包括一个描述加数字
 * @version 1.00 2019-03-06
 * @author zouxxyy
 */
public class Item implements Comparable<Item>{
    private String description;
    private int partNumner;

    public Item(String description, int partNumner) {
        this.description = description;
        this.partNumner = partNumner;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "[description=" + description + ",partNumber=" + partNumner + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null)  return false;
        if (getClass() != obj.getClass()) return false;
        Item other = (Item) obj;
        return Objects.equals(description, other.description) && partNumner == other.partNumner;
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, partNumner);
    }

    @Override
    public int compareTo(Item o) {
        int diff = Integer.compare(partNumner, o.partNumner);
        return diff != 0 ? diff : description.compareTo(o.description);
    }
}
