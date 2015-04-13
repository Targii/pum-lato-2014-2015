package pl.edu.wat.wel.lab2;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    final public static String LOG_TAG = "lab2";
    final public static String SAVED_NAME = "saved_name";

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        EditText editText = (EditText) findViewById(R.id.editText);
        String name = editText.getText().toString();
        savedInstanceState.putString(SAVED_NAME, name);
        Log.d(LOG_TAG, "Zapisuje stan: " + name);
        // domyslnie Android zapisuje stan EditText-ow
//        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(LOG_TAG, "W onCreate");

        // reczne przywracanie stanu
        if(savedInstanceState != null) {
            String name = savedInstanceState.getString(SAVED_NAME);
            EditText editText = (EditText) findViewById(R.id.editText);
            editText.setText(name);
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "W onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "W onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "W onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, "W onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "W onStart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "W onDestroy");
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
}
