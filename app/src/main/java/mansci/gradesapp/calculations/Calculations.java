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
    /**
     * Main calculation class used by all modules
     */

    public class Assignment {
        /**
         * Helper class to keep track of weights and their corresponding grades
         */
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
        /**
         * Calculates the grades needed at the final exam given 1-4 assignments and their corresponding weights and grades
         *
         * @param weights A int array of the weights given
         * @param grades A int array of the grades given
         * @param number_of_assignments A int of how many assignments have been filled out
         */

        double needForThird = 0;
        double needForTwoTwo = 0;
        double needForTwoOne = 0;
        double needForFirst = 0;

        int weightSum = 0;
        double haveSoFar = 0;
        Assignment[] assignments = new Assignment[number_of_assignments];
        // Create Assignment class objects that contain the weights and grades of an assignment
        for (int i = 0; i < number_of_assignments; i++) {
            assignments[i] = new Assignment(weights[i], grades[i]);
        }
        for (Assignment assignment : assignments) {
            weightSum += assignment.getWeight();
            haveSoFar += assignment.getWeight() * assignment.getGrade();
        }
        // Conversion needed because of weights being input as percentages
        haveSoFar *= 0.01;
        int finalExamWeight = 100 - weightSum;

        double needFor40 = 40 - haveSoFar;
        double needFor50 = 50 - haveSoFar;
        double needFor60 = 60 - haveSoFar;
        double needFor70 = 70 - haveSoFar;

        // Avoid division by 0
        if (finalExamWeight != 0) {
            needForThird = (needFor40 / finalExamWeight) * 100;
            needForTwoTwo = (needFor50 / finalExamWeight) * 100;
            needForTwoOne = (needFor60 / finalExamWeight) * 100;
            needForFirst = (needFor70 / finalExamWeight) * 100;
        }

        // CONSIDER ELSE SEND DIVISION BY ZERO MESSAGE

        // Create the list to return and add the integer values needed rounded up to the nearest integer
        List<Integer> gradesNeeded = new ArrayList<>();
        gradesNeeded.add((int) Math.ceil(needForThird));
        gradesNeeded.add((int) Math.ceil(needForTwoTwo));
        gradesNeeded.add((int) Math.ceil(needForTwoOne));
        gradesNeeded.add((int) Math.ceil(needForFirst));

        return gradesNeeded;
    }


}

