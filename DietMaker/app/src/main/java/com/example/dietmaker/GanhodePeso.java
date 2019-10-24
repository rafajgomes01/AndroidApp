package com.example.dietmaker;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import static android.widget.LinearLayout.*;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link GanhodePeso.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link GanhodePeso#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GanhodePeso extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView recyclerView;
    private List<DietaGanho> listaDietaGanhos = new ArrayList<>();

    private OnFragmentInteractionListener mListener;

    public GanhodePeso() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GanhodePeso.
     */
    // TODO: Rename and change types and number of parameters
    public static GanhodePeso newInstance(String param1, String param2) {
        GanhodePeso fragment = new GanhodePeso();
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
        View meuLayout = inflater.inflate(R.layout.fragment_ganho__peso, container, false);
        this.recyclerView = meuLayout.findViewById(R.id.recyGanho);
        AdapterGanho adapterGanho = new AdapterGanho(listaDietaGanhos);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), VERTICAL));
        recyclerView.setAdapter(adapterGanho);
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

    public void CriarDietas() {

        DietaGanho dietaGanho = new DietaGanho(R.drawable.cup,"Ovo Frito", "Café da manhã", "09:00");
        this.listaDietaGanhos.add(dietaGanho);
        dietaGanho = new DietaGanho(R.drawable.almoco,"Carne Refogada", "Almoço", "12:00");
        this.listaDietaGanhos.add(dietaGanho);
        dietaGanho = new DietaGanho(R.drawable.queijo,"Pão com queijo Branco", "Lanche", "15:00");
        this.listaDietaGanhos.add(dietaGanho);
        dietaGanho = new DietaGanho(R.drawable.ovo,"Whey protein", "Pré treino", "18:00");
        this.listaDietaGanhos.add(dietaGanho);
        dietaGanho = new DietaGanho(R.drawable.shake,"Ovo frito com Queijo branco", "Pós treino", "20:00");
        this.listaDietaGanhos.add(dietaGanho);
        dietaGanho = new DietaGanho(R.drawable.janta,"Arroz integral", "Janta", "22:00");
        this.listaDietaGanhos.add(dietaGanho);
    }
}
