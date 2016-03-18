package mansci.gradesapp;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import mansci.gradesapp.calculations.Calculations;

public class MainActivity extends Activity {
    String[] modules = new String[16];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void chooseYear(View view) {
        Button button = (Button) view;

        switch (button.getId()) {
            case R.id.main_button_2ndyear:
                Intent intent = new Intent(this, ManSciSecondYear.class);
                startActivity(intent);
                break;
            case R.id.main_button_1styear:
                Intent intent2 = new Intent(this, ManSciFirstYear.class);
                startActivity(intent2);
                break;


        }
    }

    public void bestModule(View view) {
        TextView textView = (TextView) view;

        modules[0] = getResources().getString(R.string.manSci_firstYear_MFOM1);
        modules[1] = getResources().getString(R.string.manSci_firstYear_MFOM2);
        modules[2] = getResources().getString(R.string.manSci_firstYear_cat);
        modules[3] = getResources().getString(R.string.manSci_firstYear_be1);
        modules[4] = getResources().getString(R.string.manSci_firstYear_asm);
        modules[5] = getResources().getString(R.string.manSci_firstYear_bs);
        modules[6] = getResources().getString(R.string.manSci_firstYear_da1);
        modules[7] = getResources().getString(R.string.manSci_firstYear_be2);

        modules[8] = getResources().getString(R.string.manSci_secondYear_MFOM3);
        modules[9] = getResources().getString(R.string.manSci_secondYear_strategy);
        modules[10] = getResources().getString(R.string.manSci_secondYear_CT);
        modules[11] = getResources().getString(R.string.manSci_secondYear_finance);
        modules[12] = getResources().getString(R.string.manSci_secondYear_design);
        modules[13] = getResources().getString(R.string.manSci_secondYear_PTOM);
        modules[14] = getResources().getString(R.string.title_activity_da2);
        modules[15] = getResources().getString(R.string.manSci_secondYear_minor);

        // SORT ALPHA LOL xD
        String text = "";
        for (int i = 0; i < modules.length - 1; i++) {
            text += "\n" + modules[i];
        }
        textView.setText(text);
        sortModules(modules);
        String text2 = "";
        for (int i = 0; i < modules.length - 1; i++) {
            text2 += "\n" + modules[i];
            System.out.print(modules[i]);
        }
        textView.setText(text2);
    }

    public void sortModules(String[] modules) {
        String t;
        for (int i = 0; i < modules.length; i++) {
            for (int j = 0; j < modules.length - 1 - i; j++) {
                if (modules[j].compareTo(modules[j + 1]) > 0) {
                    t = modules[j];
                    modules[j] = modules[j + 1];
                    modules[j + 1] = t;
                }
            }
        }
    }
}

