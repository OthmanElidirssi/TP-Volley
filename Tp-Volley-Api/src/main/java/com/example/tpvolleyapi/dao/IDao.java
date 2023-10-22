package com.example.tpvolleyapi.dao;

import java.util.List;

public interface IDao<T>{

    T create(T o) throws Exception;
    List<T> findAll();

    void delete(Integer id) throws Exception;
}
