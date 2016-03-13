package mansci.gradesapp.manSciModules;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import mansci.gradesapp.R;

public class MFOM1 extends AppCompatActivity {
    private int number_of_assignments = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modules_activity_mfom1);
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
    }
    public void addAssignment(View view) {
        RelativeLayout parentLayout = (RelativeLayout) findViewById(R.id.mfom_relative_layout);
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        lp.addRule(RelativeLayout.ALIGN_PARENT_LEFT);

        switch (number_of_assignments) {
            case 0:
                TextView assignment1 = new TextView(this);
                assignment1.setText(getResources().getString(R.string.assignment_1));
                assignment1.setId(R.id.mfom3_assignment_1);
                assignment1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
                lp.setMargins(0, 0, 0, (int) getResources().getDimension(R.dimen.six_dp));
                parentLayout.addView(assignment1, lp);
                break;
            case 1:
                TextView assignment2 = new TextView(this);
                assignment2.setText(getResources().getString(R.string.assignment_2));
                assignment2.setId(R.id.mfom3_assignment_2);
                assignment2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
                lp.addRule(RelativeLayout.BELOW, R.id.mfom3_assignment_1);
                lp.setMargins(0, 0, 0, (int) getResources().getDimension(R.dimen.six_dp));
                parentLayout.addView(assignment2, lp);
                break;
            case 2:
                TextView assignment3 = new TextView(this);
                assignment3.setText(getResources().getString(R.string.assignment_3));
                assignment3.setId(R.id.mfom3_assignment_3);
                assignment3.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
                lp.addRule(RelativeLayout.BELOW, R.id.mfom3_assignment_2);
                lp.setMargins(0, 0, 0, (int) getResources().getDimension(R.dimen.six_dp));
                parentLayout.addView(assignment3, lp);
                break;
            case 3:
                TextView assignment4 = new TextView(this);
                assignment4.setText(getResources().getString(R.string.assignment_4));
                assignment4.setId(R.id.mfom3_assignment_4);
                assignment4.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
                lp.addRule(RelativeLayout.BELOW, R.id.mfom3_assignment_3);
                lp.setMargins(0, 0, 0, (int) getResources().getDimension(R.dimen.six_dp));
                parentLayout.addView(assignment4, lp);
                break;
        }
        number_of_assignments++;

    }
}