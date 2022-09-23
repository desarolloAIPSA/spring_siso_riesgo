package com.paramonga.ssff.utils;


import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Service
public class Formatos {
    public LocalDateTime fechaParaConsulta(String input){
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withLocale(new Locale("pe"));
        input = input.replace("T"," ");
        LocalDateTime ldt = LocalDateTime.parse(input, dateFormat);
        return ldt;
    }
}
