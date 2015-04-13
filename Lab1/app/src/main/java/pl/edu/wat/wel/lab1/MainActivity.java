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

        Intent intent;

        // Przejście do ustawień po wybraniu pozycji z menu
        switch (item.getItemId()) {

            case R.id.action_settings:
                intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                break;

            case R.id.action_search:
                intent = new Intent(this, SearchActivity.class);
                startActivity(intent);
                break;

            default:
                return super.onOptionsItemSelected(item);
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
