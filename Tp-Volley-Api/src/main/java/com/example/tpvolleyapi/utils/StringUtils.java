package com.example.tpvolleyapi.utils;

import com.example.tpvolleyapi.student.Student;

public class StringUtils {

    public static  void cleanFullName(Student o){
        o.setNom(o.getNom().trim().replaceAll("\\s+"," "));
        o.setPrenom(o.getPrenom().trim().replaceAll("\\s+"," "));
    }
}
