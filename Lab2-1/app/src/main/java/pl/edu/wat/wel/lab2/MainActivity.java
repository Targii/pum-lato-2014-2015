package pl.edu.wat.wel.lab2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * PUM Laboratorium 2.1
 * Przykład porusza:
 *  - cykl życia activity
 *  - zapis danych przy ponownym renderowaniu elementow widoku (przy obrocie ekranu)
 *  - zapis danych do pamięci urządzenia (pliki)
 *  - przechodzenie między aplikacjami - Intent
 *  @author Marcin Głowacki
 *  @version 1.0
 */

public class MainActivity extends ActionBarActivity {

    /**
     * Aby móc filtrować komunikaty (logi) możemy nadać im wspólny tag
     */
    final public static String LOG_TAG = "lab2";

    /**
     * Aby nie pogubić się przy zapisie / odczycie pola warto nadać mu stałą nazwę
     */
    final public static String SAVED_NAME = "saved_name";

    /**
     * Nazwa naszych preferencji powinna być określona w jednym miejscu (również jako stała)
     */
    final public static String MY_PREFERENCES = "pl.edu.wat.pum.preferences";

    /**
     * Metoda wywoływana podczas zapisywania stanu, np. w momencie rozpoczęcia obrotu ekranu
     * Specjalnie metoda super.onSaveInstanceState jest zakomentowana ponieważ stan pól typu
     * EditText jest domyślnie zachowywany przez system
     * @param savedInstanceState - zapisany stan
     */
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {

        // pobierz element widoku - pole typu EditText
        EditText editText = (EditText) findViewById(R.id.editText);

        // odczytaj wprowadzony tekst
        String name = editText.getText().toString();

        // zapisz tekst w stanie
        savedInstanceState.putString(SAVED_NAME, name);

        Log.d(LOG_TAG, "Zapisuje stan: " + name);

        // zakomentowane w celach dydaktycznych
        // super.onSaveInstanceState(savedInstanceState);
    }

    /**
     * Metoda wywoływana przy tworzeniu widoku danego activity
     * Przywraca wartość pola EditText z zapisanego stanu
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // wywołaj metodę rodzica
        super.onCreate(savedInstanceState);

        // ustaw layout jaki zostanie wyrenderowany
        setContentView(R.layout.activity_main);

        Log.d(LOG_TAG, "W onCreate");

        // ręczne przywracanie stanu
        if(savedInstanceState != null) {
            // pobierz wartość zapisanego pola
            String name = savedInstanceState.getString(SAVED_NAME);

            // pobierz element widoku - pole typu EditText
            EditText editText = (EditText) findViewById(R.id.editText);

            // ustaw tekst w polu typu EditText
            editText.setText(name);
        }

        /**
         * Przykład zapisu danych do pliku, w pierwszej kolejności należy uzyskać informacje
         * w jakim folderze możemy zapisać nasze dane (getFilesDir()). Następnie można skorzystać
         * ze standardowych klas Writer / OutputStream do zapisu danych.
         *
         * Należy pamiętać aby w AndroidManifest.xml dodać:
         *  <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>
         *  <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
         */
        File file = new File(getFilesDir(), "dane.txt");
        FileWriter fw = null;
        try {
            fw = new FileWriter(file);
            fw.write("Siemanko!");
            fw.close();
        } catch(IOException ex) {
            Log.wtf(LOG_TAG, ex);
        }

    }

    /**
     * Przykład odczytu sharedPreferences przy przywracaniu stanu activity
     */
    @Override
    protected void onResume() {
        super.onResume();

        Log.d(LOG_TAG, "W onResume");

        // dostęp do ustawień
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        Log.d(LOG_TAG,
                "Odczytano zapisane pole: "
                        + preferences.getString(SAVED_NAME, "BRAK"));
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "W onPause");
    }

    /**
     * Zapis ustawień przy zatrzymywaniu activity
     */
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "W onStop");

        // dostęp do SharedPreferences w trybie prywatnym
        SharedPreferences preferences = getSharedPreferences(MY_PREFERENCES, MODE_PRIVATE);

        EditText editText = (EditText) findViewById(R.id.editText);

        // do edycji ustawień wymagana jest instancja klasy SharedPreferences.Editor
        SharedPreferences.Editor editor = preferences.edit();

        // dodanie wartości
        editor.putString(SAVED_NAME, editText.getText().toString());

        // zapis ustawień
        editor.commit();

        Log.d(LOG_TAG, "Zapisano pole: " + editText.getText().toString());
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

    /**
     * Przykład wywołania menu wyboru aplikacji, która obsłuży dany intent
     * W tym przypadku chcemy wysłać dane do przeglądarki WWW
     * @param view
     */
    public void onButtonClick(View view) {

        // utworzenie intentu przejścia do strony google.pl
        Intent intent = new Intent(Intent.ACTION_SEND, Uri.parse("http://google.pl"));

        // utworzenie intentu "owijającego" nasz docelowy intent, który umożliwi wybranie aplikacji
        Intent chooser = Intent.createChooser(intent, "Wybierz program");

        // sprawdzenie czy w ogóle istnieje aplikacja, która jest w stanie obsłużyć intent
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(chooser);
        }
    }

    /**
     * Przykład wywołania intentu, który otworzy aplikację telefonu
     * @param view
     */
    public void onDialButtonClick(View view) {

        EditText phoneEditText = (EditText) findViewById(R.id.phoneEditText);

        // URI specjalnie sformatowane dla numeru telefonu
        Uri phoneNumber = Uri.parse("tel:" + phoneEditText.getText().toString());

        Intent intent = new Intent(Intent.ACTION_DIAL, phoneNumber);
        startActivity(intent);

    }
}
