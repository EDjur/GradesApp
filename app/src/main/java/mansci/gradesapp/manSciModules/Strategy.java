package mansci.gradesapp.manSciModules;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import mansci.gradesapp.R;
import mansci.gradesapp.calculations.Calculations;

public class Strategy extends AppCompatActivity {

    Calculations calculations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modules_activity_strategy);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        calculations = new Calculations(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void addAssignment(View view) {
        RelativeLayout parentLayout = (RelativeLayout) findViewById(R.id.manSci_secondYear_strategy_relative_layout);
        calculations.addAssignment(parentLayout);
    }

    public void calculateGrades(View view) {
        /**
         * Calculates grades needed on final exam depending on assignment grades and weights
         * If button is pressed without any assignments filled in all grades and weights are defaulted to 0
         */
        RelativeLayout parentLayout = (RelativeLayout) findViewById(R.id.manSci_secondYear_strategy_relative_layout);
        TextView[] gradesList = new TextView[4];
        gradesList[0] = (TextView) findViewById(R.id.manSci_secondYear_modules_strategy_First_grade);
        gradesList[1] = (TextView) findViewById(R.id.manSci_secondYear_modules_strategy_twoOne_grade);
        gradesList[2] = (TextView) findViewById(R.id.manSci_secondYear_modules_strategy_twoTwo_grade);
        gradesList[3] = (TextView) findViewById(R.id.manSci_secondYear_modules_strategy_pass_grade);
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
