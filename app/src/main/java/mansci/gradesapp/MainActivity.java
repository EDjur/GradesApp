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

    public void chooseYear(View view){
        Button button = (Button) view;

        switch (button.getId()){
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
    public void bestModule(View view){
        TextView textView = (TextView) view;
        Calculations calculations = new Calculations(this);

        textView.setText(calculations.summary());
    }
}
