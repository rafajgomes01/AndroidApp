package com.example.dietmaker.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.dietmaker.PerderPeso;
import com.example.dietmaker.R;
import com.example.dietmaker.GanhodePeso;

public class HomeFragment extends Fragment {
    ImageButton ganho;
    ImageButton perderpeso;
    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        this.ganho = root.findViewById(R.id.ganho);
        this.perderpeso = root.findViewById(R.id.perderpeso);
        this.ganho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GanhodePeso ganhodePeso = new GanhodePeso();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.nav_host_fragment, ganhodePeso);
                transaction.commit();
            }
            });
        this.perderpeso.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                PerderPeso perderPeso = new PerderPeso();
                FragmentTransaction mudartela = getActivity().getSupportFragmentManager().beginTransaction();
                mudartela.replace(R.id.nav_host_fragment, perderPeso);
                mudartela.commit();
            }

        });

        homeViewModel.getText().observe(this, new Observer<String>() {

            @Override
            public void onChanged(String s) {

            }

        });
        return root;
    }



}