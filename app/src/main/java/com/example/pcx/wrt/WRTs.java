package com.example.pcx.wrt;

import java.util.Random;

public class WRTs {

    public static final Random RANDOMWRT = new Random();
    public static final String[] WORDS = {"ant","snake","spider","king","boat","bee","alligator","bear","fish","monkey","cat","dog","octopus"};

    public static String randomWords(){
        return WORDS[RANDOMWRT.nextInt(WORDS.length)];
    }

    public static String shuffleword(String words){
        if (words != null && !"".equals(words)){
            char a[] = words.toCharArray();

            for (int i=0; i<a.length; i++){
                int q = RANDOMWRT.nextInt(a.length);
                char tmp = a[i];
                a[i] = a[q];
                a[q] = tmp;
            }

            return new String(a);

        }

        return words;

    }

}
