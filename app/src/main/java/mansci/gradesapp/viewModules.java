package mansci.gradesapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class viewModules extends AppCompatActivity {
    String[] modules = new String[16];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_modules);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        bestModule(findViewById(R.id.modules_textview));
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

        String text = "";
        for (int i = 0; i < modules.length - 1; i++) {
            text += "\n" + modules[i];
        }
        textView.setText(text);

    }

    public void alphaSort(View view) {
        String t;
        TextView textView = (TextView) findViewById(R.id.modules_textview);
        for (int i = 0; i < modules.length; i++) {
            for (int j = 0; j < modules.length - 1 - i; j++) {
                if (modules[j].compareTo(modules[j + 1]) > 0) {
                    t = modules[j];
                    modules[j] = modules[j + 1];
                    modules[j + 1] = t;
                }
            }
        }
        String text2 = "";
        for (int i = 0; i < modules.length - 1; i++) {
            text2 += "\n" + modules[i];
            System.out.print(modules[i]);
        }
        textView.setText(text2);
    }

}
