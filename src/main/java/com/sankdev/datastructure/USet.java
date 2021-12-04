package com.sankdev.datastructure;

/**
 * ADT that represents an unordered set of unique elements, which mimics a mathematical set.
 * <br> Supports the following operations:
 * <br> int size(): return the number, n, of elements in the set;
 * <br> boolean add(x): add the element x to the set if not already present;
 * <br> T remove(x): remove element y that is equal to x from the set;
 * <br> T find(x): find element y that is equal to x in the set if it exists;
 * <br> Note: x and y might actually be distinct objects that are nevertheless treated as equal.
 * Such a distinction is useful because it allows for the creation of dictionaries or maps that map
 * keys onto values. To create a dictionary/map, one forms compound objects called Pairs, each of
 * which contains a key and a value. Two Pairs are treated as equal if their keys are equal. If we
 * store some pair (k,v) in a USet and then later call the find(x) method using the pair x =
 * (k,null) the result will be y = (k,v). In other words, it is possible to recover the value, v,
 * given only the key, k.
 */
public interface USet {

}
