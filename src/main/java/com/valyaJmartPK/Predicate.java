package com.valyaJmartPK;

/**
 * Predicate Interface
 *
 * @author Valya Sandria Akiela
 * @version 1.0
 */

@FunctionalInterface
public interface Predicate <T> {
    public boolean predicate (T arg);
}
