package edu.gaed.vo;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Data {   
    public Date formata(String data)throws Exception{  
        String dataString = data;  
        DateFormat df =  new SimpleDateFormat("dd/MM/yyyy");  
          
        java.sql.Date dataFormatada = new java.sql.Date(df.parse(dataString).getTime());  
        return dataFormatada;  
          
        }  
}  
