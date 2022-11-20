package com.example.storeapp.utils;

/**
 * Because java's Supplier is not supported in 22 API version, I have to create my own one.
 */
@FunctionalInterface
public interface CustomSupplier<T> {
    T get ();
}
