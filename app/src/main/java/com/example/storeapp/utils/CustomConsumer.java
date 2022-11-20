package com.example.storeapp.utils;

/**
 * Because java's Consumer is not supported in 22 API version, I have to create my own one.
 */
@FunctionalInterface
public interface CustomConsumer<T> {
    void accept (T in);
}
