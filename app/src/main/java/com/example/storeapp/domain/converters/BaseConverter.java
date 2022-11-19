package com.example.storeapp.domain.converters;

public interface BaseConverter<In, Out> {
    Out convert(In in);
}
