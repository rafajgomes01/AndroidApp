package com.example.dietmaker.telas;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.example.dietmaker.R;
import com.example.dietmaker.adapter.AdapterNovaDieta;
import com.example.dietmaker.classes.DietaPerderPeso;
import com.example.dietmaker.classes.Usuario;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static android.widget.LinearLayout.VERTICAL;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link NovaDieta.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link NovaDieta#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NovaDieta extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private RecyclerView recyclerView;
    private List<DietaPerderPeso> listaNovaDieta = new ArrayList<>();

    private DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();
    DatabaseReference user = referencia.child("user");

    private OnFragmentInteractionListener mListener;


    public NovaDieta() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NovaDieta.
     */
    // TODO: Rename and change types and number of parameters
    public static NovaDieta newInstance(String param1, String param2) {
        NovaDieta fragment = new NovaDieta();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View meuLayout = inflater.inflate(R.layout.fragment_nova_dieta, container, false);
        this.recyclerView = meuLayout.findViewById(R.id.recyNovaDieta);
        final AdapterNovaDieta novaDieta = new AdapterNovaDieta(listaNovaDieta);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), VERTICAL));
        recyclerView.setAdapter(novaDieta);
        ((AppCompatActivity)getContext()).getSupportActionBar().setTitle("Crie Sua Dieta");


        final DietaPerderPeso dietaPerderPeso = new DietaPerderPeso();

        Usuario usuario = new Usuario();
        usuario.setUid(FirebaseAuth.getInstance().getUid());

        DatabaseReference usuarioPesquisa = user.child(usuario.getUid());

        usuarioPesquisa.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listaNovaDieta.clear();

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    DietaPerderPeso a = postSnapshot.getValue(DietaPerderPeso.class);
                    listaNovaDieta.add(a);
                }

                AdapterNovaDieta adapterNovaDieta = new AdapterNovaDieta(listaNovaDieta);
                recyclerView.setAdapter(adapterNovaDieta);

            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        return meuLayout;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

}
