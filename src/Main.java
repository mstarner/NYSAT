/**
 * Created by ms078 on 11/27/17.
 */
package com.company;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Copied the code from my partner John Roberts but mine isn't working
 */
public class Main {

    public static void main(String[] args) throws IOException{
        Scanner fileSearch =new Scanner(new File("scores.txt"));

        School [] lineData = new School[435];
        int indx = -1;
        fileSearch.nextLine();          //Skips header line
        while (fileSearch.hasNext()){
            indx++;
            lineData[indx] = new School(fileSearch.nextLine());
        }
        //System.out.println(lineData[0].compositeScore);           Used for testing
        int totalScore = 0;
        int schoolsWithComposite = 0;
        for (int i = 0; i <= 434;i++){
            System.out.println(lineData[i].schoolName+":\t"+lineData[i].compositeScore);            //Lists schools and composite scores

            totalScore += lineData[i].compositeScore;
            if (lineData[i].hasSat){
                schoolsWithComposite++;
            }
        }

        int newYorkAvg = totalScore/schoolsWithComposite;           //State Average
        System.out.println("\n\nThe average SAT score for New York is:\t"+newYorkAvg);

        //Top Three Schools
        Arrays.sort(lineData, new Comparator<School>() {            //https://stackoverflow.com/questions/18895915/how-to-sort-an-array-of-objects-in-java
            @Override
            public int compare(School o1, School o2) {
                return o2.compositeScore-o1.compositeScore;
            }
        });  //Sorts array by composite score
        System.out.println("\n\nThe school with the highest average is "+lineData[0].schoolName+" with a score of "+lineData[0].compositeScore+".");
        System.out.println("The school with the second highest average is "+lineData[1].schoolName+" with a score of "+lineData[1].compositeScore+".");
        System.out.println("The school with the third highest average is "+lineData[2].schoolName+" with a score of "+lineData[2].compositeScore+".");
    }
}