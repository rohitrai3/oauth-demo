package com.example.oauth.util;

public interface Mapper<F, T> {

    T map(F from);

}
