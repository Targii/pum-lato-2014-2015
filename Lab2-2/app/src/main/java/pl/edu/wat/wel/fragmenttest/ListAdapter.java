package pl.edu.wat.wel.fragmenttest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marcin on 29.04.15.
 */
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {

    private List<String> items;

    public ListAdapter() {
        this.items = new ArrayList<>(3);
        items.add("Pierwszy wiersz");
        items.add("Drugi wiersz");
        items.add("Trzeci wiersz");
        items.add("Pierwszy wiersz");
        items.add("Pierwszy wiersz");
        items.add("Pierwszy wiersz");
        items.add("Pierwszy wiersz");
        items.add("Pierwszy wiersz");

    }

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_row, viewGroup, false);

        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListViewHolder listViewHolder, int i) {
        listViewHolder.textView.setText(items.get(i));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ListViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;

        public ListViewHolder(View itemView) {
            super(itemView);

            textView = (TextView) itemView.findViewById(R.id.text);
        }
    }
}
