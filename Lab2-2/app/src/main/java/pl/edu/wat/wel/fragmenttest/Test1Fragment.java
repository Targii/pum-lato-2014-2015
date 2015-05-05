package pl.edu.wat.wel.fragmenttest;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Przykładowy fragment zawierający element dynamicznej listy RecyclerView
 */
public class Test1Fragment extends Fragment {

    RecyclerView mRecyclerView;

    /**
     * Przy renderowaniu fragmentu wykorzystaj opis z pliku XML
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.test_1_fragment, container, false);
    }

    /**
     * Po utworzeniu widoku ustaw layout RecyclerView oraz dodaj adapter
     * Adapter - klasa uzupełniająca widok danymi
     * @param view
     * @param savedInstanceState
     */
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mRecyclerView.setAdapter(new ListAdapter());

    }
}
