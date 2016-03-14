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

public class ManSciFirstYear extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_sci_first_year);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public void chooseModule(View view){
        Button button = (Button) view;

        switch (button.getId()){
            case R.id.manSci_firstYear_button_MFOM1:
                Intent MFOMIntent = new Intent(this, MFOM3.class);
                startActivity(MFOMIntent);
                break;
            case R.id.manSci_firstYear_button_cat:
                Intent ctIntent = new Intent(this, CT.class);
                startActivity(ctIntent);
                break;
            case R.id.manSci_firstYear_button_be1:
                Intent financeIntent = new Intent(this, Finance.class);
                startActivity(financeIntent);
                break;
            case R.id.manSci_firstYear_button_asm:
                Intent strategyIntent = new Intent(this, Strategy.class);
                startActivity(strategyIntent);
                break;
            case R.id.manSci_firstYear_button_bs:
                Intent DAIntent = new Intent(this, DA2.class);
                startActivity(DAIntent);
                break;
            case R.id.manSci_firstYear_button_da1:
                Intent designIntent = new Intent(this, Design.class);
                startActivity(designIntent);
                break;
            case R.id.manSci_firstYear_button_be2:
                Intent PTOMIntent = new Intent(this, PTOM.class);
                startActivity(PTOMIntent);
                break;
            case R.id.manSci_firstYear_button_MFOM2:
                Intent minorIntent = new Intent(this, Minor.class);
                startActivity(minorIntent);
                break;
        }
    }
}
