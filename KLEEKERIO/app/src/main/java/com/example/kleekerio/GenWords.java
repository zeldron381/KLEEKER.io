package com.example.kleekerio;

import java.util.Random;

class GenWords {
    static char[] symbols = {'а', 'б', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ь', 'ъ', 'э', 'ю', 'я'};

    public static String generate(){
        String word = "";
        int n = new Random().nextInt(10);
        for(int i = 0; i <= n; i++){
            word += symbols[new Random().nextInt(30)];
        }
        return word;
    }
}
