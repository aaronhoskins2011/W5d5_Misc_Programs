package com.example.aaronhoskins.w5d5_misc_programs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.aaronhoskins.w5d5_misc_programs.CheckGroupingTokens;
import com.example.aaronhoskins.w5d5_misc_programs.CustomStringUtilities;
import java.util.ArrayList;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Map<String,Integer> symbolMap = CheckGroupingTokens.mapSymbols("}{)(");
        ArrayList<String> errorList = CheckGroupingTokens.getMisgroupingList(symbolMap);
        if(errorList.size() > 0){
            for(String curError : errorList){
                Log.d("__GROUPING_ERROR__", curError);
            }
        } else {
            Log.d("__GROUPING_ERROR__", "NO ERRORS FOUND");
        }
        String fullString = "catcowcatahh";
        String subString = "cat";
        int expectedMatches = 2;

        boolean properNumberOfMatchesfound = CustomStringUtilities.evaluateNumOfSubStringToStrings(fullString,subString,expectedMatches,0,0);

        if(properNumberOfMatchesfound){
            Log.d("MAIN", "******************** Proper Number FOUND   ******* **** ***** ***** ******** **** *** ******* ");
        } else {
            Log.d("MAIN", "******************** Proper Number NOT FOUND   ******* **** ***** ***** ********  *** ******* ");
        }
    }
}
