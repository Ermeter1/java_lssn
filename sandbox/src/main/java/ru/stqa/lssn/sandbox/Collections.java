package ru.stqa.lssn.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {

    public static void main(String[] args) {
        String[] langs = {"Java", "C#", "Pyton", "PHP"};

        List<String> languages = Arrays.asList("Java", "C#", "Pyton", "PHP");
//        List<String> languages = new ArrayList<String>();

  //      languages.add("Java");
//        languages.add("C#");
//        languages.add("Pyton");


        for (String l: languages){
            System.out.println("Я хочу выучить " + l);
        }
//        for (int i = 0; i < langs.length; i++ ){
  //          System.out.println("Я хочу выучить " + langs[i]);
    //    }
    }

}
