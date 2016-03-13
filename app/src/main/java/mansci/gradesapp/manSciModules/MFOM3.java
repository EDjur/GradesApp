package mansci.gradesapp.manSciModules;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.util.TypedValue;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import mansci.gradesapp.R;
import mansci.gradesapp.calculations.Calculations;

public class MFOM3 extends AppCompatActivity {


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


    public void addAssignment(View view) {
        RelativeLayout parentLayout = (RelativeLayout) findViewById(R.id.mfom_relative_layout);
        calculations.addAssignment(parentLayout);
    }

    public void calculateGrades(View view) {
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