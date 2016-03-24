package mansci.gradesapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import mansci.gradesapp.manSciModules.MFOM1;
import mansci.gradesapp.manSciModules.asm;
import mansci.gradesapp.manSciModules.be1;
import mansci.gradesapp.manSciModules.cat;
import mansci.gradesapp.manSciModules.da1;
import mansci.gradesapp.manSciModules.bs;
import mansci.gradesapp.manSciModules.MFOM2;
import mansci.gradesapp.manSciModules.be2;

public class ManSciFirstYear extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_sci_first_year);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    /**
     * Determines what button has been pressed
     *
     * @param view the button that has been pressed
     */
    public void chooseModule(View view) {
        Button button = (Button) view;

        switch (button.getId()) {
            case R.id.manSci_firstYear_button_MFOM1:
                Intent MFOMIntent = new Intent(this, MFOM1.class);
                startActivity(MFOMIntent);
                break;
            case R.id.manSci_firstYear_button_cat:
                Intent ctIntent = new Intent(this, cat.class);
                startActivity(ctIntent);
                break;
            case R.id.manSci_firstYear_button_be1:
                Intent financeIntent = new Intent(this, be1.class);
                startActivity(financeIntent);
                break;
            case R.id.manSci_firstYear_button_asm:
                Intent strategyIntent = new Intent(this, asm.class);
                startActivity(strategyIntent);
                break;
            case R.id.manSci_firstYear_button_bs:
                Intent DAIntent = new Intent(this, bs.class);
                startActivity(DAIntent);
                break;
            case R.id.manSci_firstYear_button_da1:
                Intent designIntent = new Intent(this, da1.class);
                startActivity(designIntent);
                break;
            case R.id.manSci_firstYear_button_be2:
                Intent PTOMIntent = new Intent(this, be2.class);
                startActivity(PTOMIntent);
                break;
            case R.id.manSci_firstYear_button_MFOM2:
                Intent minorIntent = new Intent(this, MFOM2.class);
                startActivity(minorIntent);
                break;
        }
    }
}
