package com.example.aaronhoskins.w5d5_misc_programs;

import android.util.Log;

import com.example.aaronhoskins.w5d5_misc_programs.Constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static android.content.ContentValues.TAG;
import static com.example.aaronhoskins.w5d5_misc_programs.Constants.CLOSE_BRACKET;
import static com.example.aaronhoskins.w5d5_misc_programs.Constants.CLOSE_CURLY_BRACE;
import static com.example.aaronhoskins.w5d5_misc_programs.Constants.CLOSE_PARENTHESIS;
import static com.example.aaronhoskins.w5d5_misc_programs.Constants.OPEN_BRACKET;
import static com.example.aaronhoskins.w5d5_misc_programs.Constants.OPEN_CURLY_BRACE;
import static com.example.aaronhoskins.w5d5_misc_programs.Constants.OPEN_PARENTHESIS;

/**
 * Created by cathye.johnson on 9/3/2017.
 */

public class CheckGroupingTokens {

    public static Map<String, Integer> mapSymbols(String passedString) {
        Map<String, Integer> symbolMap = new HashMap<String, Integer>();

        for (int i = 0; i < passedString.length(); i++) {
            switch (String.valueOf(passedString.charAt(i))) {
                case OPEN_CURLY_BRACE:
                    symbolMap.put(OPEN_CURLY_BRACE,
                            symbolMap.get(OPEN_CURLY_BRACE) == null ? 1 : symbolMap.get(OPEN_CURLY_BRACE) + 1);
                    break;
                case CLOSE_CURLY_BRACE:
                    symbolMap.put(CLOSE_CURLY_BRACE,
                            symbolMap.get(CLOSE_CURLY_BRACE) == null ? 1 : symbolMap.get(CLOSE_CURLY_BRACE) + 1);
                    break;
                case OPEN_PARENTHESIS:
                    symbolMap.put(OPEN_PARENTHESIS,
                            symbolMap.get(OPEN_PARENTHESIS) == null ? 1 : symbolMap.get(OPEN_PARENTHESIS) + 1);
                    break;
                case CLOSE_PARENTHESIS:
                    symbolMap.put(CLOSE_PARENTHESIS,
                            symbolMap.get(CLOSE_PARENTHESIS) == null ? 1 : symbolMap.get(CLOSE_PARENTHESIS) + 1);
                    break;
                case OPEN_BRACKET:
                    symbolMap.put(OPEN_BRACKET,
                            symbolMap.get(OPEN_BRACKET) == null ? 1 : symbolMap.get(OPEN_BRACKET) + 1);
                    break;
                case CLOSE_BRACKET:
                    symbolMap.put(CLOSE_BRACKET,
                            symbolMap.get(CLOSE_BRACKET) == null ? 1 : symbolMap.get(CLOSE_BRACKET) + 1);
                    break;

            }
        }
        return symbolMap;
    }

    public static ArrayList<String> getMisgroupingList(Map<String, Integer> symbolMap){
        ArrayList<String> messegeList = new ArrayList<>();
        if (symbolMap.get(OPEN_BRACKET) != symbolMap.get(CLOSE_BRACKET)) {
            if (symbolMap.get(OPEN_BRACKET) > symbolMap.get(CLOSE_BRACKET)) {
                messegeList.add("mapSymbols: Missing Close BRACKET Symbol: " + CLOSE_BRACKET);
            } else {
                messegeList.add( "mapSymbols: Missing Open BRACKET Symbol: " + OPEN_BRACKET);
            }
        }
        if (symbolMap.get(OPEN_PARENTHESIS) != symbolMap.get(CLOSE_PARENTHESIS)) {
            if (symbolMap.get(OPEN_PARENTHESIS) > symbolMap.get(CLOSE_PARENTHESIS)) {
                messegeList.add("mapSymbols: Missing Close PARENTHESIS Symbol: " + CLOSE_PARENTHESIS);
            } else {
                messegeList.add("mapSymbols: Missing Open PARENTHESIS Symbol: " + OPEN_PARENTHESIS);
            }
        }
        if (symbolMap.get(OPEN_CURLY_BRACE) != symbolMap.get(CLOSE_CURLY_BRACE)) {
            if (symbolMap.get(OPEN_CURLY_BRACE) > symbolMap.get(CLOSE_CURLY_BRACE)) {
                messegeList.add("mapSymbols: Missing Close CURLY_BRACE Symbol: " + CLOSE_CURLY_BRACE);
            } else {
                messegeList.add("mapSymbols: Missing Open CURLY_BRACE Symbol: " + OPEN_CURLY_BRACE);
            }
        }

        return messegeList;
    }




}
