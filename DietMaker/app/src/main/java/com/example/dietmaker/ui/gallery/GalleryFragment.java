package com.example.dietmaker.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.dietmaker.R;

import java.util.ArrayList;

public class GalleryFragment extends Fragment {
    ListView listView;
    private GalleryViewModel galleryViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        galleryViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });

        listView=(ListView)root.findViewById(R.id.listview);
        ArrayList<String> arrayList=new ArrayList<>();


        arrayList.add("oi");
        arrayList.add("oi");
        arrayList.add("oi");
        arrayList.add("oi");
        arrayList.add("oi");
        arrayList.add("oi");
        arrayList.add("oi");
        arrayList.add("oi");


        ArrayAdapter arrayAdapter=new ArrayAdapter(getContext(), android.R.layout.simple_expandable_list_item_1,arrayList);

        listView.setAdapter((arrayAdapter));

        return root;
    }
}