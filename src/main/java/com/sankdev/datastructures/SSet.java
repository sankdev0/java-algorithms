package com.sankdev.datastructures;

/**
 * ADT that represents a sorted list of elements so that any two elements x and y can be compared.
 * It is rarely used.
 * <br> See USet interface info. The difference to an unordered set is:
 * <br> T find(x): locate x in the sorted set. Find and return the smallest element y in the set
 * such that y ≥ x. It is called successor search. It differs in a fundamental way from USet.find(x)
 * since it returns a meaningful result even when there is no element equal to x in the set.
 */
public interface SSet {

}
