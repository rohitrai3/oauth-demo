package com.example.oauth.util;

public interface IMapper<F, T> {

    T map(F from);

}
