package mansci.gradesapp.manSciModules;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;


import org.w3c.dom.Text;

import mansci.gradesapp.R;

public class MFOM3 extends AppCompatActivity {
    private int number_of_assignments = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modules_activity_mfom3);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void addAssignment(View view) {
        RelativeLayout parentLayout = (RelativeLayout) findViewById(R.id.mfom_relative_layout);
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams lpWeight = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams lpGrade = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

        switch (number_of_assignments) {
            case 0:
                TextView assignment1 = new TextView(this);
                assignment1.setText(getResources().getString(R.string.assignment_1));
                assignment1.setId(R.id.mfom3_assignment_1);
                assignment1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                lp.setMargins(0, (int) getResources().getDimension(R.dimen.fifteen_dp), 0, (int) getResources().getDimension(R.dimen.six_dp));
                parentLayout.addView(assignment1, lp);

                EditText assignment1Weight = new EditText(this);
                assignment1Weight.setId(R.id.mfom3_assignment_1_weight);
                assignment1Weight.setHint(getResources().getString(R.string.weight));
                lpWeight.setMargins(0, 0, 0, (int) getResources().getDimension(R.dimen.six_dp));
                lpWeight.addRule(RelativeLayout.RIGHT_OF, R.id.mfom3_assignment_1);
                lpWeight.addRule(RelativeLayout.ALIGN_BASELINE, R.id.mfom3_assignment_1);
                parentLayout.addView(assignment1Weight, lpWeight);

                EditText assignment1Grade = new EditText(this);
                assignment1Grade.setId(R.id.mfom3_assignment_1_grade);
                assignment1Grade.setHint(getResources().getString(R.string.grade));
                lpGrade.setMargins(0, 0, 0, (int) getResources().getDimension(R.dimen.six_dp));
                lpGrade.addRule(RelativeLayout.RIGHT_OF, R.id.mfom3_assignment_1_weight);
                lpGrade.addRule(RelativeLayout.ALIGN_BASELINE, R.id.mfom3_assignment_1_weight);
                parentLayout.addView(assignment1Grade, lpGrade);
                break;
            case 1:
                TextView assignment2 = new TextView(this);
                assignment2.setText(getResources().getString(R.string.assignment_2));
                assignment2.setId(R.id.mfom3_assignment_2);
                assignment2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                lp.addRule(RelativeLayout.BELOW, R.id.mfom3_assignment_1);
                lp.setMargins(0, 0, 0, (int) getResources().getDimension(R.dimen.six_dp));
                parentLayout.addView(assignment2, lp);

                EditText assignment2Weight = new EditText(this);
                assignment2Weight.setId(R.id.mfom3_assignment_2_weight);
                assignment2Weight.setHint(getResources().getString(R.string.weight));
                lpWeight.addRule(RelativeLayout.RIGHT_OF, R.id.mfom3_assignment_2);
                lpWeight.addRule(RelativeLayout.ALIGN_BASELINE, R.id.mfom3_assignment_2);
                lpWeight.setMargins(0, 0, 0, (int) getResources().getDimension(R.dimen.six_dp));
                parentLayout.addView(assignment2Weight, lpWeight);

                EditText assignment2Grade = new EditText(this);
                assignment2Grade.setId(R.id.mfom3_assignment_2_grade);
                assignment2Grade.setHint(getResources().getString(R.string.grade));
                lpGrade.addRule(RelativeLayout.RIGHT_OF, R.id.mfom3_assignment_2_weight);
                lpGrade.addRule(RelativeLayout.ALIGN_BASELINE, R.id.mfom3_assignment_2_weight);
                lpGrade.setMargins(0, 0, 0, (int) getResources().getDimension(R.dimen.six_dp));
                parentLayout.addView(assignment2Grade, lpGrade);
                break;
            case 2:
                TextView assignment3 = new TextView(this);
                assignment3.setText(getResources().getString(R.string.assignment_3));
                assignment3.setId(R.id.mfom3_assignment_3);
                assignment3.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                lp.addRule(RelativeLayout.BELOW, R.id.mfom3_assignment_2);
                lp.setMargins(0, 0, 0, (int) getResources().getDimension(R.dimen.six_dp));
                parentLayout.addView(assignment3, lp);

                EditText assignment3Weight = new EditText(this);
                assignment3Weight.setId(R.id.mfom3_assignment_3_weight);
                assignment3Weight.setHint(getResources().getString(R.string.weight));
                lpWeight.addRule(RelativeLayout.RIGHT_OF, R.id.mfom3_assignment_3);
                lpWeight.addRule(RelativeLayout.ALIGN_BASELINE, R.id.mfom3_assignment_3);
                lpWeight.setMargins(0, 0, 0, (int) getResources().getDimension(R.dimen.six_dp));
                parentLayout.addView(assignment3Weight, lpWeight);

                EditText assignment3Grade = new EditText(this);
                assignment3Grade.setId(R.id.mfom3_assignment_3_grade);
                assignment3Grade.setHint(getResources().getString(R.string.grade));
                lpGrade.addRule(RelativeLayout.RIGHT_OF, R.id.mfom3_assignment_3_weight);
                lpGrade.addRule(RelativeLayout.ALIGN_BASELINE, R.id.mfom3_assignment_3_weight);
                lpGrade.setMargins(0, 0, 0, (int) getResources().getDimension(R.dimen.six_dp));
                parentLayout.addView(assignment3Grade, lpGrade);
                break;
            case 3:
                TextView assignment4 = new TextView(this);
                assignment4.setText(getResources().getString(R.string.assignment_4));
                assignment4.setId(R.id.mfom3_assignment_4);
                assignment4.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                lp.addRule(RelativeLayout.BELOW, R.id.mfom3_assignment_3);
                lp.setMargins(0, 0, 0, (int) getResources().getDimension(R.dimen.six_dp));
                parentLayout.addView(assignment4, lp);

                EditText assignment4Weight = new EditText(this);
                assignment4Weight.setId(R.id.mfom3_assignment_4_weight);
                assignment4Weight.setHint(getResources().getString(R.string.weight));
                lpWeight.addRule(RelativeLayout.RIGHT_OF, R.id.mfom3_assignment_4);
                lpWeight.addRule(RelativeLayout.ALIGN_BASELINE, R.id.mfom3_assignment_4);
                lpWeight.setMargins(0, 0, 0, (int) getResources().getDimension(R.dimen.six_dp));
                parentLayout.addView(assignment4Weight, lpWeight);

                EditText assignment4Grade = new EditText(this);
                assignment4Grade.setId(R.id.mfom3_assignment_4_grade);
                assignment4Grade.setHint(getResources().getString(R.string.grade));
                lpGrade.addRule(RelativeLayout.RIGHT_OF, R.id.mfom3_assignment_4_weight);
                lpGrade.addRule(RelativeLayout.ALIGN_BASELINE, R.id.mfom3_assignment_4_weight);
                lpGrade.setMargins(0, 0, 0, (int) getResources().getDimension(R.dimen.six_dp));
                parentLayout.addView(assignment4Grade, lpGrade);
                break;
        }
        number_of_assignments++;


    }
}


