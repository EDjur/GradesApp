package mansci.gradesapp.manSciModules;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.util.TypedValue;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import mansci.gradesapp.R;
import mansci.gradesapp.calculations.Calculations;

public class MFOM3 extends AppCompatActivity {
    private int number_of_assignments = 0;
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

    Calculations calculations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modules_activity_mfom3);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        calculations = new Calculations(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    // Deprecated. Don't use.
    public void old_addAssignment(View view) {
        /**
         * Adds a new Assignment to the activity
         * number_of_assignments keeps track of how many assignments have been added
         */

        // Sets up the parentLayout used
        // Sets up different LayoutParams for the three different columns (Assignment, Weight, Grade)
        RelativeLayout parentLayout = (RelativeLayout) findViewById(R.id.mfom_relative_layout);
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
                assignment1 = new TextView(this);
                assignment1.setText(getResources().getString(R.string.assignment_1));
                assignment1.setId(R.id.mfom3_assignment_1);
                assignment1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                lp.setMargins(0, (int) getResources().getDimension(R.dimen.fifteen_dp), 0, (int) getResources().getDimension(R.dimen.fifteen_dp));
                parentLayout.addView(assignment1, lp);

                assignment1Weight = new EditText(this);
                // Remove keyboard when tapping main view
                assignment1Weight.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        if (!hasFocus) {
                            hideKeyboard(v);
                        }
                    }
                });
                assignment1Weight.setId(R.id.mfom3_assignment_1_weight);
                assignment1Weight.setHint(getResources().getString(R.string.weight));
                assignment1Weight.setRawInputType(InputType.TYPE_CLASS_NUMBER);
                lpWeight.setMargins(0, 0, 0, (int) getResources().getDimension(R.dimen.fifteen_dp));
                lpWeight.addRule(RelativeLayout.RIGHT_OF, R.id.mfom3_assignment_1);
                lpWeight.addRule(RelativeLayout.ALIGN_BASELINE, R.id.mfom3_assignment_1);
                parentLayout.addView(assignment1Weight, lpWeight);

                assignment1Grade = new EditText(this);
                // Remove keyboard when tapping main view
                assignment1Grade.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        if (!hasFocus) {
                            hideKeyboard(v);
                        }
                    }
                });
                assignment1Grade.setId(R.id.mfom3_assignment_1_grade);
                assignment1Grade.setHint(getResources().getString(R.string.grade));
                assignment1Grade.setRawInputType(InputType.TYPE_CLASS_NUMBER);
                lpGrade.setMargins(0, 0, 0, (int) getResources().getDimension(R.dimen.fifteen_dp));
                lpGrade.addRule(RelativeLayout.RIGHT_OF, R.id.mfom3_assignment_1_weight);
                lpGrade.addRule(RelativeLayout.ALIGN_BASELINE, R.id.mfom3_assignment_1_weight);
                parentLayout.addView(assignment1Grade, lpGrade);
                break;
            case 1:
                assignment2 = new TextView(this);
                assignment2.setText(getResources().getString(R.string.assignment_2));
                assignment2.setId(R.id.mfom3_assignment_2);
                assignment2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                lp.addRule(RelativeLayout.BELOW, R.id.mfom3_assignment_1);
                lp.setMargins(0, 0, 0, (int) getResources().getDimension(R.dimen.fifteen_dp));
                parentLayout.addView(assignment2, lp);

                assignment2Weight = new EditText(this);
                // Remove keyboard when tapping main view
                assignment2Weight.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        if (!hasFocus) {
                            hideKeyboard(v);
                        }
                    }
                });
                assignment2Weight.setId(R.id.mfom3_assignment_2_weight);
                assignment2Weight.setRawInputType(InputType.TYPE_CLASS_NUMBER);
                assignment2Weight.setHint(getResources().getString(R.string.weight));
                lpWeight.addRule(RelativeLayout.RIGHT_OF, R.id.mfom3_assignment_2);
                lpWeight.addRule(RelativeLayout.ALIGN_BASELINE, R.id.mfom3_assignment_2);
                lpWeight.setMargins(0, 0, 0, (int) getResources().getDimension(R.dimen.fifteen_dp));
                parentLayout.addView(assignment2Weight, lpWeight);

                assignment2Grade = new EditText(this);
                // Remove keyboard when tapping main view
                assignment2Grade.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        if (!hasFocus) {
                            hideKeyboard(v);
                        }
                    }
                });
                assignment2Grade.setId(R.id.mfom3_assignment_2_grade);
                assignment2Grade.setHint(getResources().getString(R.string.grade));
                assignment2Grade.setRawInputType(InputType.TYPE_CLASS_NUMBER);
                lpGrade.addRule(RelativeLayout.RIGHT_OF, R.id.mfom3_assignment_2_weight);
                lpGrade.addRule(RelativeLayout.ALIGN_BASELINE, R.id.mfom3_assignment_2_weight);
                lpGrade.setMargins(0, 0, 0, (int) getResources().getDimension(R.dimen.fifteen_dp));
                parentLayout.addView(assignment2Grade, lpGrade);
                break;
            case 2:
                assignment3 = new TextView(this);
                assignment3.setText(getResources().getString(R.string.assignment_3));
                assignment3.setId(R.id.mfom3_assignment_3);
                assignment3.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                lp.addRule(RelativeLayout.BELOW, R.id.mfom3_assignment_2);
                lp.setMargins(0, 0, 0, (int) getResources().getDimension(R.dimen.fifteen_dp));
                parentLayout.addView(assignment3, lp);

                assignment3Weight = new EditText(this);
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
                assignment3Weight.setId(R.id.mfom3_assignment_3_weight);
                assignment3Weight.setHint(getResources().getString(R.string.weight));
                lpWeight.addRule(RelativeLayout.RIGHT_OF, R.id.mfom3_assignment_3);
                lpWeight.addRule(RelativeLayout.ALIGN_BASELINE, R.id.mfom3_assignment_3);
                lpWeight.setMargins(0, 0, 0, (int) getResources().getDimension(R.dimen.fifteen_dp));
                parentLayout.addView(assignment3Weight, lpWeight);

                assignment3Grade = new EditText(this);
                // Remove keyboard when tapping main view
                assignment3Grade.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        if (!hasFocus) {
                            hideKeyboard(v);
                        }
                    }
                });
                assignment3Grade.setId(R.id.mfom3_assignment_3_grade);
                assignment3Grade.setHint(getResources().getString(R.string.grade));
                assignment3Grade.setRawInputType(InputType.TYPE_CLASS_NUMBER);
                lpGrade.addRule(RelativeLayout.RIGHT_OF, R.id.mfom3_assignment_3_weight);
                lpGrade.addRule(RelativeLayout.ALIGN_BASELINE, R.id.mfom3_assignment_3_weight);
                lpGrade.setMargins(0, 0, 0, (int) getResources().getDimension(R.dimen.fifteen_dp));
                parentLayout.addView(assignment3Grade, lpGrade);
                break;
            case 3:
                assignment4 = new TextView(this);
                assignment4.setText(getResources().getString(R.string.assignment_4));
                assignment4.setId(R.id.mfom3_assignment_4);
                assignment4.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                lp.addRule(RelativeLayout.BELOW, R.id.mfom3_assignment_3);
                lp.setMargins(0, 0, 0, (int) getResources().getDimension(R.dimen.fifteen_dp));
                parentLayout.addView(assignment4, lp);

                assignment4Weight = new EditText(this);
                // Remove keyboard when tapping main view
                assignment4Weight.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        if (!hasFocus) {
                            hideKeyboard(v);
                        }
                    }
                });
                assignment4Weight.setId(R.id.mfom3_assignment_4_weight);
                assignment4Weight.setRawInputType(InputType.TYPE_CLASS_NUMBER);
                assignment4Weight.setHint(getResources().getString(R.string.weight));
                lpWeight.addRule(RelativeLayout.RIGHT_OF, R.id.mfom3_assignment_4);
                lpWeight.addRule(RelativeLayout.ALIGN_BASELINE, R.id.mfom3_assignment_4);
                lpWeight.setMargins(0, 0, 0, (int) getResources().getDimension(R.dimen.fifteen_dp));
                parentLayout.addView(assignment4Weight, lpWeight);

                assignment4Grade = new EditText(this);
                // Remove keyboard when tapping main view
                assignment4Grade.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        if (!hasFocus) {
                            hideKeyboard(v);
                        }
                    }
                });
                assignment4Grade.setId(R.id.mfom3_assignment_4_grade);
                assignment4Grade.setHint(getResources().getString(R.string.grade));
                assignment4Grade.setRawInputType(InputType.TYPE_CLASS_NUMBER);
                lpGrade.addRule(RelativeLayout.RIGHT_OF, R.id.mfom3_assignment_4_weight);
                lpGrade.addRule(RelativeLayout.ALIGN_BASELINE, R.id.mfom3_assignment_4_weight);
                lpGrade.setMargins(0, 0, 0, (int) getResources().getDimension(R.dimen.fifteen_dp));
                parentLayout.addView(assignment4Grade, lpGrade);
                break;
        }
        // Increases the assignment count
        number_of_assignments++;


    }

    // Deprecated. Don't use.
    public void old_calculateGrades(View view) {
        /**
         * Calculates grades needed on final exam depending on assignment grades and weights
         * If button is pressed without any assignments filled in all grades and weights are defaulted to 0
         */

        int[] grades = new int[number_of_assignments];
        int[] weights = new int[number_of_assignments];
        List<Integer> gradesNeeded;
        Calculations calculations = new Calculations(this);

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
        //gradesNeeded = calculations.calculateGrades(weights, grades, number_of_assignments);


        TextView first = (TextView) findViewById(R.id.manSci_secondYear_modules_mfom_First_grade);
        TextView twoOne = (TextView) findViewById(R.id.manSci_secondYear_modules_mfom_twoOne_grade);
        TextView twoTwo = (TextView) findViewById(R.id.manSci_secondYear_modules_mfom_twoTwo_grade);
        TextView pass = (TextView) findViewById(R.id.manSci_secondYear_modules_mfom_pass_grade);

        //first.setText((gradesNeeded.get(3) > 100 ? "Unobtainable" : gradesNeeded.get(3).toString()));
        //twoOne.setText((gradesNeeded.get(2) > 100 ? "Unobtainable" : gradesNeeded.get(2).toString()));
        //twoTwo.setText((gradesNeeded.get(1) > 100 ? "Unobtainable" : gradesNeeded.get(1).toString()));
        //pass.setText((gradesNeeded.get(0) > 100 ? "Unobtainable" : gradesNeeded.get(0).toString()));
    }

    public void addAssignment(View view){
        RelativeLayout parentLayout = (RelativeLayout) findViewById(R.id.mfom_relative_layout);
        calculations.addAssignment(parentLayout);
    }

    public void calculateGrades(View view)
    {
        /**
         * Calculates grades needed on final exam depending on assignment grades and weights
         * If button is pressed without any assignments filled in all grades and weights are defaulted to 0
         */
        RelativeLayout parentLayout = (RelativeLayout) findViewById(R.id.mfom_relative_layout);
        TextView[] gradesList = new TextView[4];
        gradesList[0] = (TextView) findViewById(R.id.manSci_secondYear_modules_mfom_First_grade);
        gradesList[1] = (TextView) findViewById(R.id.manSci_secondYear_modules_mfom_twoOne_grade);
        gradesList[2] = (TextView) findViewById(R.id.manSci_secondYear_modules_mfom_twoTwo_grade);
        gradesList[3] = (TextView) findViewById(R.id.manSci_secondYear_modules_mfom_pass_grade);
        calculations.calculateGrades(parentLayout, gradesList, this);

    }
    public void hideKeyboard(View view) {
        /**
         * Method to manage hiding of keyboard when tapping the main view
         */
        //InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        //inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}