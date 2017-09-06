package com.example.aaronhoskins.w5d5_misc_programs;

import android.util.Log;

import static android.content.ContentValues.TAG;

/**
 * Created by cathye.johnson on 9/3/2017.
 */

public final class CustomStringUtilities {
    public static boolean evaluateNumOfSubStringToStrings(String fullString, String subString, int numOfExpectedMatches, int numberFound, int offset){
        boolean isCorrect = false;
        if(numberFound >= numOfExpectedMatches){
            isCorrect =  true;
        } else {
            int endCharReached = offset + subString.length();
            if (endCharReached >= fullString.length()) {
                if (numberFound == numOfExpectedMatches) {
                    isCorrect = true;
                }
                if (fullString.substring(offset, offset + subString.length()).equals(subString)) {
                    isCorrect = true;
                }
                Log.d(TAG, "evaluateNumOfSubStringToStrings: endCharReached");
                isCorrect = false;
            } else {
                Log.d("TAG", "evaluateNumOfSubStringToStrings: "
                        + fullString.substring(offset, offset + subString.length()) + "  ::  "
                        + offset + "  ::  "
                        + numberFound);
                if (fullString.substring(offset, offset + subString.length()).equals(subString)) {
                    numberFound = numberFound + 1;
                }
                return evaluateNumOfSubStringToStrings(fullString, subString, numOfExpectedMatches, numberFound, ++offset);
            }
        }
        Log.d(TAG, "evaluateNumOfSubStringToStrings: end method");
        return isCorrect;
    }
}
