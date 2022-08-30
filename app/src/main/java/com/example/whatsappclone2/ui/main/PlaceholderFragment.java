package com.example.whatsappclone2.ui.main;

import android.annotation.SuppressLint;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.whatsappclone2.R;
import com.example.whatsappclone2.databinding.FragmentMainBinding;
import java.util.ArrayList;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {

    private FragmentMainBinding binding;
    private int currentTab=0;
    private ArrayList<People> peoples,newp;
    RecyclerView recyclerView;
    private PeopleAdapter peopleAdapter;
    private SearchView searchView = null;
    private SearchView.OnQueryTextListener queryTextListener;

    public PlaceholderFragment(int position, ArrayList<People> peoples) {
        this.currentTab = position;
        this.peoples = peoples;
        this.newp = peoples;
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        binding = FragmentMainBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        recyclerView = binding.recyeclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext(),RecyclerView.VERTICAL,false));
        newp = peoples;
        peopleAdapter = new PeopleAdapter(getContext(),peoples);
        recyclerView.setAdapter(peopleAdapter);
        setHasOptionsMenu(true);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.optionmenu, menu);


        MenuItem searchItem = menu.findItem(R.id.app_bar_search);
        SearchManager searchManager = (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);

        if(searchItem != null){
            searchView = (SearchView) searchItem.getActionView();
        }
        if(searchView != null) {


            queryTextListener = new SearchView.OnQueryTextListener()
             {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    searchView.clearFocus();
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    Log.d("###PEOPLE2",newText);
                    newp = (ArrayList<People>) peoples.stream().filter(x -> (x.getName().toLowerCase().contains(newText.toLowerCase())) || x.getMessage().toLowerCase().contains(newText.toLowerCase())).collect(Collectors.toList());
                    peopleAdapter = new PeopleAdapter(getContext(),newp);
                    recyclerView.setAdapter(peopleAdapter);
                    return false;
                }
            };
            searchView.setOnQueryTextListener(queryTextListener);
        }

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.app_bar_search:
                Log.d("###PEOPLE2","app_bar_search");
                return false;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}