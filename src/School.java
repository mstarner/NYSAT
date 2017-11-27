/**
 * Created by ms078 on 11/27/17.
 */
package com.company;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jroberts3136 on 11/10/17.
 */
public class School /*implements Comparable<School>*/{
    public String [] schoolData;
    //    public String schoolID;
    public String schoolName;
    //    public int studentEnroll;
//    public int zipCode;
    public int mathScore;
    public int readingScore;
    public int writingScore;
    public int compositeScore = 0;
    public int comparison;
    public boolean hasSat;

    public School(String a){
        /*
        Scanner schoolData = new Scanner(a).useDelimiter("\\t");
        schoolID = schoolData.next();
        schoolName = schoolData.next();
        studentEnroll = schoolData.nextInt();   //input mismatch
        zipCode = schoolData.nextInt();
        for (int i=0;i<15;i++){
            schoolData.next();
        }
        mathScore = schoolData.nextInt();
        readingScore = schoolData.nextInt();
        writingScore = schoolData.nextInt();
        compositeScore = mathScore + readingScore + writingScore;
        */

        schoolData = a.split("\\t");

        schoolName = schoolData[1];

        if (this.hasSatScore()){
            mathScore = Integer.valueOf(schoolData[18]);
            readingScore = Integer.valueOf(schoolData[19]);
            writingScore = Integer.valueOf(schoolData[20]);
            compositeScore = mathScore + readingScore + writingScore;
        }
    }

    public boolean hasSatScore(){
        if (schoolData.length>18){
            if (schoolData[18].equals("")|| schoolData[19].equals("")|| schoolData[20].equals("")){
                hasSat = false;
            }
            else {
                hasSat = true;
            }
        }
        else{
            hasSat = false;
        }
        return hasSat;
    }

    /*
    @Override       //Sets .sort to work on composite score
    public int compareTo(School o) {
        comparison = o.compositeScore - this.compositeScore;        //Descending order
        return comparison;
    }
    */
}