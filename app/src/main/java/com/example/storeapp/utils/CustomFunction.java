package com.example.storeapp.utils;

@FunctionalInterface
public interface CustomFunction<In, Out> {
    Out invoke(In in);
}
