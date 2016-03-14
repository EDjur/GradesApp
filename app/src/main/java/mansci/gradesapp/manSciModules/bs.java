package mansci.gradesapp.manSciModules;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import mansci.gradesapp.R;
import mansci.gradesapp.calculations.Calculations;

public class bs extends AppCompatActivity implements Module {
    Calculations calculations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modules_activity_bs);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        calculations = new Calculations(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void addAssignment(View view) {
        RelativeLayout parentLayout = (RelativeLayout) findViewById(R.id.manSci_firstYear_bs_relative_layout);
        calculations.addAssignment(parentLayout);
    }

    public void calculateGrades(View view) {
        /**
         * Calculates grades needed on final exam depending on assignment grades and weights
         * If button is pressed without any assignments filled in all grades and weights are defaulted to 0
         */
        TextView[] gradesList = new TextView[4];
        gradesList[0] = (TextView) findViewById(R.id.manSci_firstYear_modules_bs_First_grade);
        gradesList[1] = (TextView) findViewById(R.id.manSci_firstYear_modules_bs_twoOne_grade);
        gradesList[2] = (TextView) findViewById(R.id.manSci_firstYear_modules_bs_twoTwo_grade);
        gradesList[3] = (TextView) findViewById(R.id.manSci_firstYear_modules_bs_pass_grade);
        calculations.calculateGrades(gradesList);

    }

    // Helper get-methods for generalisation of Calculations class
    public int getAssignmentId(int index) {
        switch (index) {
            case 0:
                return R.id.bs_assignment_1;
            case 1:
                return R.id.bs_assignment_2;
            case 2:
                return R.id.bs_assignment_3;
            case 3:
                return R.id.bs_assignment_4;
        }
        return 0;
    }

    public int getWeightId(int index) {
        switch (index) {
            case 0:
                return R.id.bs_assignment_1_weight;
            case 1:
                return R.id.bs_assignment_2_weight;
            case 2:
                return R.id.bs_assignment_3_weight;
            case 3:
                return R.id.bs_assignment_4_weight;
        }
        return 0;
    }

    public int getGradeId(int index) {
        switch (index) {
            case 0:
                return R.id.bs_assignment_1_grade;
            case 1:
                return R.id.bs_assignment_2_grade;
            case 2:
                return R.id.bs_assignment_3_grade;
            case 3:
                return R.id.bs_assignment_4_grade;
        }
        return 0;
    }

}
