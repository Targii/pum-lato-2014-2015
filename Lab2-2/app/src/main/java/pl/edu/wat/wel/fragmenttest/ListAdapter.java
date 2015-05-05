package pl.edu.wat.wel.fragmenttest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Klasa Adaptera RecyclerView - dostarcza danych do wyświetlenia w sposob dynamiczny
 * Rozszerza adapter generyczny (uniwersalny), należy jednak wskazać, która klasa reprezentuje
 * renderowany element layoutu (ViewHolder)
 */
public class ListAdapter extends RecyclerView.Adapter<ListViewHolder> {

    /**
     * Lista w której przechwoujemy nasze dane (dowolne obiekty)
     */
    private List<String> items;

    /**
     * Uzupełnienie listy przykładowymi danymi
     */
    public ListAdapter() {
        this.items = new ArrayList<>(3);
        items.add("Pierwszy wiersz");
        items.add("Drugi wiersz");
        items.add("Trzeci wiersz");
        items.add("Czwarty wiersz");
        items.add("Piąty wiersz");
        items.add("Szósty wiersz");
        items.add("Siódmy wiersz");
        items.add("Ósmy wiersz");
    }

    /**
     * Dynamiczne renderowanie wiersza listy w danym viewGroup
     * @param viewGroup
     * @param i
     * @return
     */
    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        /**
         * LayoutInflater - z opisu w postaci XML tworzy elementy layoutu
         * Dodaje utworzony element do klasy odpowiedzialnej za wyświetlanie elementów listy
         */
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_row, viewGroup, false);
        return new ListViewHolder(view);
    }

    /**
     * Metoda odpowiedzialna za ustawienie wartości danego elementu listy
     * W przykładzie źródłem danych jest lista elementów typu String
     * @param listViewHolder
     * @param i
     */
    @Override
    public void onBindViewHolder(ListViewHolder listViewHolder, int i) {
        // ustawienie wartości pola textView na i-tą wartość z listy
        listViewHolder.textView.setText(items.get(i));
    }

    /**
     * Metoda informująca o ilości elementów dostępnych do wyświetlenia
     * @return
     */
    @Override
    public int getItemCount() {
        return items.size();
    }

}
