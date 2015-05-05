package pl.edu.wat.wel.fragmenttest;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Aplikacja ma na celu pokazanie pracy z fragmentami oraz z RecyclerView (dawniej ListView)
 * @author Michał Ciołek
 * @version 1.0
 */
public class MainActivity extends ActionBarActivity {

    /**
     * Utworzenie domyślnego widoku bieżącego activity
     * Wygenerowane przez kreator nowej activity
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Uzupełnienie menu opcjami określonymi w main_menu.xml
     * Wygenerowane przez kreator nowej activity
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * Obsługa pozycji menu
     * Wygenerowane przez kreator nowej activity
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
