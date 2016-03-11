package mansci.gradesapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import mansci.gradesapp.manSciModules.CT;
import mansci.gradesapp.manSciModules.DA2;
import mansci.gradesapp.manSciModules.Design;
import mansci.gradesapp.manSciModules.Finance;
import mansci.gradesapp.manSciModules.MFOM3;
import mansci.gradesapp.manSciModules.Minor;
import mansci.gradesapp.manSciModules.PTOM;
import mansci.gradesapp.manSciModules.Strategy;

public class ManSciSecondYear extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_sci_second_year);
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

    public void chooseModule(View view){
        Button button = (Button) view;

        switch (button.getId()){
            case R.id.manSci_secondYear_button_MFOM:
                Intent MFOMIntent = new Intent(this, MFOM3.class);
                startActivity(MFOMIntent);
                break;
            case R.id.manSci_secondYear_button_CT:
                Intent ctIntent = new Intent(this, CT.class);
                startActivity(ctIntent);
                break;
            case R.id.manSci_secondYear_button_finance:
                Intent financeIntent = new Intent(this, Finance.class);
                startActivity(financeIntent);
                break;
            case R.id.manSci_secondYear_button_strategy:
                Intent strategyIntent = new Intent(this, Strategy.class);
                startActivity(strategyIntent);
                break;
            case R.id.manSci_secondYear_button_DA:
                Intent DAIntent = new Intent(this, DA2.class);
                startActivity(DAIntent);
                break;
            case R.id.manSci_secondYear_button_design:
                Intent designIntent = new Intent(this, Design.class);
                startActivity(designIntent);
                break;
            case R.id.manSci_secondYear_button_PTOM:
                Intent PTOMIntent = new Intent(this, PTOM.class);
                startActivity(PTOMIntent);
                break;
            case R.id.manSci_secondYear_button_minor:
                Intent minorIntent = new Intent(this, Minor.class);
                startActivity(minorIntent);
                break;
        }
    }

}
