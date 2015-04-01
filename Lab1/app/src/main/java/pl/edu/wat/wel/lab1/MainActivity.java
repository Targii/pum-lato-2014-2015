package pl.edu.wat.wel.lab1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    // NAZWA NASZEGO ATRYBUTU W INTENT
    public static final String EXTRA_NAME = "NAME";

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

    /**
     * Przywitanie imienne użytkownika z wykorzystaniem Toast
     * @param view
     */
    public void buttonOnClickListener(View view) {

        EditText nameEditText = (EditText) findViewById(R.id.nameEditText);
        String name = nameEditText.getText().toString();

        Context context = getApplicationContext();

        Toast.makeText(context, "Witaj " + name + "!", Toast.LENGTH_SHORT).show();

    }

    /**
     * Przekierowanie użytkownika na ekran logowania
     * @param view
     */
    public void loginButtonOnClickListener(View view) {

        Intent intent = new Intent(this, LoginActivity.class);
        EditText nameEditText = (EditText) findViewById(R.id.nameEditText);

        intent.putExtra(EXTRA_NAME, nameEditText.getText().toString());

        startActivity(intent);
    }

}
