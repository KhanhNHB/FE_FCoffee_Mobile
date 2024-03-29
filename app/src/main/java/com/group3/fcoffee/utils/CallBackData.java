package com.group3.fcoffee.utils;

public interface CallBackData<T> {
    void onSuccess(T t);
    void onFail(String message);
}