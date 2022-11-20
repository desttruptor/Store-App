package com.example.storeapp.domain.mappers;

public interface BaseMapper<In, Out> {
    Out convert (In in);
}
