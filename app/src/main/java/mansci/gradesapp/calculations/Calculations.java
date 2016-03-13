package mansci.gradesapp.calculations;

import android.view.View;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Elias on 12/03/2016.
 */
public class Calculations {

    public class Assignment {
        int weight;
        int grade;

        public Assignment(int weight, int grade) {
            this.weight = weight;
            this.grade = grade;
        }

        public int getWeight() {
            return weight;
        }

        public int getGrade() {
            return grade;
        }
    }

    public List<Integer> calculateGrades(int[] weights, int[] grades, int number_of_assignments) {


        double needForThird = 0;
        double needForTwoTwo = 0;
        double needForTwoOne = 0;
        double needForFirst = 0;


        int weightSum = 0;
        double haveSoFar = 0;
        Assignment[] assignments = new Assignment[number_of_assignments];
        for (int i = 0; i < number_of_assignments; i++) {
            assignments[i] = new Assignment(weights[i], grades[i]);
        }
        for (Assignment assignment : assignments) {
            weightSum += assignment.getWeight();
            haveSoFar += assignment.getWeight() * assignment.getGrade();
        }
        haveSoFar *= 0.01;
        int finalExamWeight = 100 - weightSum;
        double needFor40 = 40 - haveSoFar;
        double needFor50 = 50 - haveSoFar;
        double needFor60 = 60 - haveSoFar;
        double needFor70 = 70 - haveSoFar;

        if (finalExamWeight != 0) {

            needForThird = (needFor40 / finalExamWeight) * 100;
            needForTwoTwo = (needFor50 / finalExamWeight) * 100;
            needForTwoOne = (needFor60 / finalExamWeight) * 100;
            needForFirst = (needFor70 / finalExamWeight) * 100;
        }

        // ELSE SEND DIVISION BY ZERO MESSAGE

        List<Integer> gradesNeeded = new ArrayList<Integer>();
        gradesNeeded.add((int) Math.ceil(needForThird));
        gradesNeeded.add((int) Math.ceil(needForTwoTwo));
        gradesNeeded.add((int) Math.ceil(needForTwoOne));
        gradesNeeded.add((int) Math.ceil(needForFirst));

        return gradesNeeded;
    }


}

