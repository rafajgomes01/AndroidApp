package com.example.dietmaker.telas;

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

import com.example.dietmaker.R;
import com.example.dietmaker.adapter.AdapterPerder;
import com.example.dietmaker.classes.DietaPerderPeso;

import java.util.ArrayList;
import java.util.List;

import static android.widget.LinearLayout.VERTICAL;


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
        View meuLayout = inflater.inflate(R.layout.fragment_ganho__peso, container, false);        this.recyclerView = meuLayout.findViewById(R.id.recyGanho);
        AdapterPerder adapterPerder = new AdapterPerder(listaDietaPerderPeso);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), VERTICAL));
        recyclerView.setAdapter(adapterPerder);

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

        DietaPerderPeso dietaPerderPeso = new DietaPerderPeso("Perder Peso","Arroz integral","asadasdasdasdas","20:10");
        this.listaDietaPerderPeso.add(dietaPerderPeso);
        dietaPerderPeso = new DietaPerderPeso("Almoço","alguma coisa" ,"asdsdfsdfsdaf","12:00");
        this.listaDietaPerderPeso.add(dietaPerderPeso);
        dietaPerderPeso = new DietaPerderPeso("Lanche", "Lorem","asnmdosdfnondfsndfisdnfiosndfnsdafo","17:00");
        this.listaDietaPerderPeso.add(dietaPerderPeso);
        dietaPerderPeso = new DietaPerderPeso("Pré treino","sla","sadfsdfsdafsdaf","18:00");
        this.listaDietaPerderPeso.add(dietaPerderPeso);
        dietaPerderPeso = new DietaPerderPeso("Pós treino","sdfsd","asdfsadfsdfsdaf", "20:00");
        this.listaDietaPerderPeso.add(dietaPerderPeso);
        dietaPerderPeso = new DietaPerderPeso("Janta","sdfsadfa","sdfsadfsadfsadfasdf", "22:00");
        this.listaDietaPerderPeso.add(dietaPerderPeso);
    }

}
