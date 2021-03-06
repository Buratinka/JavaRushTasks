package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args){

    }
    
    static {
        try {
            reset();
        } catch (IOException e) {

        }
    }

    public static Flyable result;

    public static void reset() throws IOException  {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
try {
    if (s.equals("helicopter")) {
        result = new Helicopter();
    }
    if (s.equals("plane")) {
        int i = Integer.parseInt(reader.readLine());
        result = new Plane(i);
    }
}catch(NumberFormatException e){
    System.out.println("Wrong");
}
        reader.close();

    }
}
