package mansci.gradesapp.calculations;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.util.TypedValue;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import mansci.gradesapp.R;
import mansci.gradesapp.manSciModules.MFOM3;
import mansci.gradesapp.manSciModules.Module;

/**
 * Created by Elias on 12/03/2016.
 */
public class Calculations {
    /**
     * Main calculation class used by all modules
     */
    private int number_of_assignments = 0;
    private AppCompatActivity context;
    // Set up TextView's
    TextView assignment1;
    EditText assignment1Weight;
    EditText assignment1Grade;

    TextView assignment2;
    EditText assignment2Weight;
    EditText assignment2Grade;

    TextView assignment3;
    EditText assignment3Weight;
    EditText assignment3Grade;

    TextView assignment4;
    EditText assignment4Weight;
    EditText assignment4Grade;

    public Calculations(AppCompatActivity context){
        this.context = context;
    }

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

    public void calculateGrades(RelativeLayout parentLayout, TextView[] gradesList, AppCompatActivity context) {
        /**
         * Calculates the grades needed at the final exam given 1-4 assignments and their corresponding weights and grades
         *
         * @param weights A int array of the weights given
         * @param grades A int array of the grades given
         * @param number_of_assignments A int of how many assignments have been filled out
         */

        int[] grades = new int[number_of_assignments];
        int[] weights = new int[number_of_assignments];
        List<Integer> gradesNeeded;

        for (int i = 0; i < number_of_assignments; i++) {
            switch (i) {
                case 0:
                    try {
                        grades[0] = Integer.parseInt(assignment1Grade.getText().toString());
                        weights[0] = Integer.parseInt(assignment1Weight.getText().toString());
                    }
                    // Sets values to 0 if they don't exist
                    catch (Exception e) {
                        grades[0] = 0;
                        weights[0] = 0;
                    }
                    break;
                case 1:
                    try {
                        grades[1] = Integer.parseInt(assignment2Grade.getText().toString());
                        weights[1] = Integer.parseInt(assignment2Weight.getText().toString());
                    }
                    // Sets values to 0 if they don't exist
                    catch (Exception e) {
                        grades[1] = 0;
                        weights[1] = 0;
                    }
                    break;
                case 2:
                    try {
                        grades[2] = Integer.parseInt(assignment3Grade.getText().toString());
                        weights[2] = Integer.parseInt(assignment3Weight.getText().toString());
                    }
                    // Sets values to 0 if they don't exist
                    catch (Exception e) {
                        grades[2] = 0;
                        weights[2] = 0;
                    }
                    break;
                case 3:
                    try {
                        grades[3] = Integer.parseInt(assignment4Grade.getText().toString());
                        weights[3] = Integer.parseInt(assignment4Weight.getText().toString());
                    }
                    // Sets values to 0 if they don't exist
                    catch (Exception e) {
                        grades[3] = 0;
                        weights[3] = 0;
                    }
                    break;
            }
        }

        // Calculates grade needed
        // Returns a List<Integer> of the grades needed where index 0 is for a pass, index 1 for a 2.2 etc.
        gradesNeeded = calculateGrades(weights, grades);

        TextView first = gradesList[0];
        TextView twoOne = gradesList[1];
        TextView twoTwo = gradesList[2];
        TextView pass = gradesList[3];

        first.setText((gradesNeeded.get(3) > 100 ? "Unobtainable" : gradesNeeded.get(3).toString()));
        twoOne.setText((gradesNeeded.get(2) > 100 ? "Unobtainable" : gradesNeeded.get(2).toString()));
        twoTwo.setText((gradesNeeded.get(1) > 100 ? "Unobtainable" : gradesNeeded.get(1).toString()));
        pass.setText((gradesNeeded.get(0) > 100 ? "Unobtainable" : gradesNeeded.get(0).toString()));

    }
    public List<Integer> calculateGrades(int[] weights, int[] grades){
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
        int finalExamWeight = (weightSum <= 100 ? 100 - weightSum : 0);

        // Avoid negative values
        double needFor40 = (haveSoFar >= 40 ? 0 : 40 - haveSoFar);
        double needFor50 = (haveSoFar >= 50 ? 0 : 50 - haveSoFar);
        double needFor60 = (haveSoFar >= 60 ? 0 : 60 - haveSoFar);
        double needFor70 = (haveSoFar >= 70 ? 0 : 70 - haveSoFar);

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

    public void addAssignment(RelativeLayout parentLayout) {
        /**
         * Adds a new Assignment to the activity
         * number_of_assignments keeps track of how many assignments have been added
         */

        // Test for null

        // Sets up the parentLayout used
        // Sets up different LayoutParams for the three different columns (Assignment, Weight, Grade)
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams lpWeight = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams lpGrade = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

        // Adds assignment depending on if previous assignments have been added
        // Only has 4 assignments as max at the moment to keep view uncluttered
        // Every case is split up into three parts: Assignment TextView, Weight EditText, Grade EditText
        switch (number_of_assignments) {
            case 0:
                assignment1 = new TextView(context);
                assignment1.setText(context.getResources().getString(R.string.assignment_1));
                assignment1.setId(((Module)context).getAssignmentId(0));
                assignment1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                lp.setMargins(0, (int) context.getResources().getDimension(R.dimen.fifteen_dp), 0, (int) context.getResources().getDimension(R.dimen.fifteen_dp));
                parentLayout.addView(assignment1, lp);

                assignment1Weight = new EditText(context);
                // Remove keyboard when tapping main view
                assignment1Weight.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        if (!hasFocus) {
                            hideKeyboard(v);
                        }
                    }
                });
                assignment1Weight.setId(((Module)context).getWeightId(0));
                assignment1Weight.setHint(context.getResources().getString(R.string.weight));
                assignment1Weight.setRawInputType(InputType.TYPE_CLASS_NUMBER);
                lpWeight.setMargins(0, 0, 0, (int) context.getResources().getDimension(R.dimen.fifteen_dp));
                lpWeight.addRule(RelativeLayout.RIGHT_OF, assignment1.getId());
                lpWeight.addRule(RelativeLayout.ALIGN_BASELINE, assignment1.getId());
                parentLayout.addView(assignment1Weight, lpWeight);

                assignment1Grade = new EditText(context);
                // Remove keyboard when tapping main view
                assignment1Grade.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        if (!hasFocus) {
                            hideKeyboard(v);
                        }
                    }
                });
                assignment1Grade.setId(((Module)context).getGradeId(0));
                assignment1Grade.setHint(context.getResources().getString(R.string.grade));
                assignment1Grade.setRawInputType(InputType.TYPE_CLASS_NUMBER);
                lpGrade.setMargins(0, 0, 0, (int) context.getResources().getDimension(R.dimen.fifteen_dp));
                lpGrade.addRule(RelativeLayout.RIGHT_OF, assignment1Weight.getId());
                lpGrade.addRule(RelativeLayout.ALIGN_BASELINE, assignment1Weight.getId());
                parentLayout.addView(assignment1Grade, lpGrade);
                break;
            case 1:
                assignment2 = new TextView(context);
                assignment2.setText(context.getResources().getString(R.string.assignment_2));
                assignment2.setId(((Module)context).getAssignmentId(1));
                assignment2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                lp.addRule(RelativeLayout.BELOW, assignment1.getId());
                lp.setMargins(0, 0, 0, (int) context.getResources().getDimension(R.dimen.fifteen_dp));
                parentLayout.addView(assignment2, lp);

                assignment2Weight = new EditText(context);
                // Remove keyboard when tapping main view
                assignment2Weight.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        if (!hasFocus) {
                            hideKeyboard(v);
                        }
                    }
                });
                assignment2Weight.setId(((Module)context).getWeightId(1));
                assignment2Weight.setRawInputType(InputType.TYPE_CLASS_NUMBER);
                assignment2Weight.setHint(context.getResources().getString(R.string.weight));
                lpWeight.addRule(RelativeLayout.RIGHT_OF, assignment2.getId());
                lpWeight.addRule(RelativeLayout.ALIGN_BASELINE, assignment2.getId());
                lpWeight.setMargins(0, 0, 0, (int) context.getResources().getDimension(R.dimen.fifteen_dp));
                parentLayout.addView(assignment2Weight, lpWeight);

                assignment2Grade = new EditText(context);
                // Remove keyboard when tapping main view
                assignment2Grade.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        if (!hasFocus) {
                            hideKeyboard(v);
                        }
                    }
                });
                assignment2Grade.setId(((Module)context).getGradeId(1));
                assignment2Grade.setHint(context.getResources().getString(R.string.grade));
                assignment2Grade.setRawInputType(InputType.TYPE_CLASS_NUMBER);
                lpGrade.addRule(RelativeLayout.RIGHT_OF, assignment2Weight.getId());
                lpGrade.addRule(RelativeLayout.ALIGN_BASELINE, assignment2Weight.getId());
                lpGrade.setMargins(0, 0, 0, (int) context.getResources().getDimension(R.dimen.fifteen_dp));
                parentLayout.addView(assignment2Grade, lpGrade);
                break;
            case 2:
                assignment3 = new TextView(context);
                assignment3.setText(context.getResources().getString(R.string.assignment_3));
                assignment3.setId(((Module)context).getAssignmentId(2));
                assignment3.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                lp.addRule(RelativeLayout.BELOW, assignment2.getId());
                lp.setMargins(0, 0, 0, (int) context.getResources().getDimension(R.dimen.fifteen_dp));
                parentLayout.addView(assignment3, lp);

                assignment3Weight = new EditText(context);
                // Remove keyboard when tapping main view
                assignment3Weight.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        if (!hasFocus) {
                            hideKeyboard(v);
                        }
                    }
                });
                assignment3Weight.setRawInputType(InputType.TYPE_CLASS_NUMBER);
                assignment3Weight.setId(((Module)context).getWeightId(2));
                assignment3Weight.setHint(context.getResources().getString(R.string.weight));
                lpWeight.addRule(RelativeLayout.RIGHT_OF, assignment3.getId());
                lpWeight.addRule(RelativeLayout.ALIGN_BASELINE, assignment3.getId());
                lpWeight.setMargins(0, 0, 0, (int) context.getResources().getDimension(R.dimen.fifteen_dp));
                parentLayout.addView(assignment3Weight, lpWeight);

                assignment3Grade = new EditText(context);
                // Remove keyboard when tapping main view
                assignment3Grade.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        if (!hasFocus) {
                            hideKeyboard(v);
                        }
                    }
                });
                assignment3Grade.setId(((Module)context).getGradeId(2));
                assignment3Grade.setHint(context.getResources().getString(R.string.grade));
                assignment3Grade.setRawInputType(InputType.TYPE_CLASS_NUMBER);
                lpGrade.addRule(RelativeLayout.RIGHT_OF, assignment3Weight.getId());
                lpGrade.addRule(RelativeLayout.ALIGN_BASELINE, assignment3Weight.getId());
                lpGrade.setMargins(0, 0, 0, (int) context.getResources().getDimension(R.dimen.fifteen_dp));
                parentLayout.addView(assignment3Grade, lpGrade);
                break;
            case 3:
                assignment4 = new TextView(context);
                assignment4.setText(context.getResources().getString(R.string.assignment_4));
                assignment4.setId(((Module) context).getAssignmentId(3));
                assignment4.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                lp.addRule(RelativeLayout.BELOW, assignment3.getId());
                lp.setMargins(0, 0, 0, (int) context.getResources().getDimension(R.dimen.fifteen_dp));
                parentLayout.addView(assignment4, lp);

                assignment4Weight = new EditText(context);
                assignment4Weight.setId(((Module) context).getWeightId(3));
                assignment4Weight.setRawInputType(InputType.TYPE_CLASS_NUMBER);
                assignment4Weight.setHint(context.getResources().getString(R.string.weight));
                // Remove keyboard when tapping main view
                assignment4Weight.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        if (!hasFocus) {
                            hideKeyboard(v);
                        }
                    }
                });
                lpWeight.addRule(RelativeLayout.RIGHT_OF, assignment4.getId());
                lpWeight.addRule(RelativeLayout.ALIGN_BASELINE, assignment4.getId());
                lpWeight.setMargins(0, 0, 0, (int) context.getResources().getDimension(R.dimen.fifteen_dp));
                parentLayout.addView(assignment4Weight, lpWeight);

                assignment4Grade = new EditText(context);
                assignment4Grade.setId(((Module)context).getGradeId(3));
                assignment4Grade.setHint(context.getResources().getString(R.string.grade));
                assignment4Grade.setRawInputType(InputType.TYPE_CLASS_NUMBER);
                // Remove keyboard when tapping main view
                assignment4Grade.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        if (!hasFocus) {
                            hideKeyboard(v);
                        }
                    }
                });
                lpGrade.addRule(RelativeLayout.RIGHT_OF, assignment4Weight.getId());
                lpGrade.addRule(RelativeLayout.ALIGN_BASELINE, assignment4Weight.getId());
                lpGrade.setMargins(0, 0, 0, (int) context.getResources().getDimension(R.dimen.fifteen_dp));
                parentLayout.addView(assignment4Grade, lpGrade);
                break;
        }
        // Increases the assignment count
        number_of_assignments++;
    }
    public void hideKeyboard(View view) {
        /**
         * Method to manage hiding of keyboard when tapping the main view
         */
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}

