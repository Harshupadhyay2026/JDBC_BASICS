package com.example.demo.model;

import jakarta.persistence.AttributeConverter;

import javax.print.attribute.Attribute;

public class BooleanToStringConverter
        implements AttributeConverter<Boolean,String> {

    @Override
    public String convertToDatabaseColumn(Boolean aBoolean) {

       if(aBoolean== null)return  null;

        if (aBoolean == true) {
            return "YES";
        }
        return "NO";
    }

    @Override
    public Boolean convertToEntityAttribute(String s) {

        if(s==null) return  null;

        if(s.equals("YES")) {
            return true;
        }
        return false;
    }
}
