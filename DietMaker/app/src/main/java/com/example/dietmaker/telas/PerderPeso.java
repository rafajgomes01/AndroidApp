package com.example.dietmaker.telas;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;

import com.example.dietmaker.R;
import com.example.dietmaker.adapter.AdapterPerder;
import com.example.dietmaker.classes.DietaPerderPeso;

import java.util.ArrayList;
import java.util.List;

import static android.view.View.generateViewId;
import static android.widget.LinearLayout.VERTICAL;
import android.os.Bundle;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PerderPeso.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PerderPeso#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PerderPeso extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView recyclerView;
    private List<DietaPerderPeso> listaDietaPerderPeso = new ArrayList<>();

    private OnFragmentInteractionListener mListener;
    public PerderPeso() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PerderPeso.
     */
    // TODO: Rename and change types and number of parameters
    public static PerderPeso newInstance(String param1, String param2) {
        PerderPeso fragment = new PerderPeso();
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
        AdapterPerder adapterPerder = new AdapterPerder(listaDietaPerderPeso);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), VERTICAL));
        recyclerView.setAdapter(adapterPerder);
        ((AppCompatActivity)getContext()).getSupportActionBar().setTitle("Dieta para perder de Peso");


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

    public void DietaPerder() {

        DietaPerderPeso dietaPerderPeso = new DietaPerderPeso("Café da manhã","Suco de laranja (1 Copo Pequeno)\t " +
                "\nPão integral (Fatia: 1)\t " +
                "\nRequeijão light (2 Ponta De Faca)\t" +
                " \nFruta (não especificada) (Porcao: 1)\t","07:00");
        this.listaDietaPerderPeso.add(dietaPerderPeso);
        dietaPerderPeso = new DietaPerderPeso("Lanche da manhã","Castanha do Pará sem sal (Unidade (4g): 1)\t \nUva passa (Colher de sopa cheia (18g): 1)\t","10:00");
        this.listaDietaPerderPeso.add(dietaPerderPeso);
        dietaPerderPeso = new DietaPerderPeso("Almoço", "Salada, de legumes, cozida no vapor (Colher de Sopa: 3)\t " +
                "\nPeito de galinha ou frango Cozido(a) (File: 1)\t" +
                " \nEspaguete, cozido, enriquecido, com sal (2 Pegador)\t " +
                "\nMolho de tomate (3 Colher de sopa (20g))\t" +
                " \nChocolate, meio amargo (Pedaço: 1)\t","12:00");
        this.listaDietaPerderPeso.add(dietaPerderPeso);
        dietaPerderPeso = new DietaPerderPeso("Lanche da tarde","Suco de abacaxi (Copo Americano: 1)\t \nPão de queijo (Unidade Pequena: 2)\t","16:00");
        this.listaDietaPerderPeso.add(dietaPerderPeso);
        dietaPerderPeso = new DietaPerderPeso("Jantar","Blanquet de peru (Fatia: 1)\t \nQueijo prato (Fatia: 1)\t \nRequeijão light (Ponta De Faca: 3)\t \nTomate (3 Fatia média (15g))\t \nAlface, americana, crua (Folha De Hortaliça: 3)\t \nPão integral (2 Fatia)\t \nSuco de uva integral (1 Copo pequeno (165ml))\t \nObs: Alface e tomate à vontade\n" +
                "\n", "20:00");
        this.listaDietaPerderPeso.add(dietaPerderPeso);
        dietaPerderPeso = new DietaPerderPeso("Pós-treino","Banana, nanica, crua (Unidade: 1)\t \nObs: 1 banana\n" +
                "\n", "21:30");
        this.listaDietaPerderPeso.add(dietaPerderPeso);
        dietaPerderPeso = new DietaPerderPeso("Ceia","Iogurte desnatado (1 Pote)\t \nAveia em flocos (1 Colher De Sopa)\t", "23:00");
        this.listaDietaPerderPeso.add(dietaPerderPeso);
    }

}
