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
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.dietmaker.classes.DietaGanharPeso;
import com.example.dietmaker.classes.DietaPerderPeso;
import com.example.dietmaker.R;
import com.example.dietmaker.classes.RecyclerItemClickListener;
import com.example.dietmaker.adapter.AdapterGanho;

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
    private List<DietaGanharPeso> listaDietaGanharPeso = new ArrayList<>();

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
        AdapterGanho adapterGanho = new AdapterGanho(listaDietaGanharPeso);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), VERTICAL));
        recyclerView.setAdapter(adapterGanho);
        ((AppCompatActivity)getContext()).getSupportActionBar().setTitle("Dieta para ganhar Peso");


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

    public void DietaGanho() {

        DietaGanharPeso dietaGanharPeso = new DietaGanharPeso("Café da manhã","Tapioca de goma (Unidade: 1)\t " +
                "\nAtum light ralado - Gomes da Costa® (Colher de sopa (20g): 2)\t" +
                " \nQueijo tipo mussarela (Fatia (13,5g): 1)\t" +
                " \nFruta (não especificada) (Unidade: 1)\t " +
                "\nPasta de amendoim (Grama: 15)\t " +
                "\nLeite de vaca integral (Copo Americano: 1)\t" +
                "\nOBS: -Preparar a tapioca com 5 colheres de sopa + 2 colheres de sopa de atum light + 1 fatia de queijo mussarela;" +
                "\n-2 opção - 2 torradas + 2 fatias de queijo mussarela + 2 fatias de peito de peru ou de frango defumado + 1 ponta de faca de requeijão light;" +
                "\n- O leite integral pode ser mantido + 2 colheres do Nutren ( EVITE O USO DO ACHOCOLATADO,INTRODUZA O CACAU EM PÓ OU ALGUM OUTRO ACHOCOLATADO SEM ADIÇÃO DE AÇÚCAR);" +
                "\n-Consuma com moderação a farinha láctea,consuma em dias alternados duas colheres apenas." +
                "\n-Mastigue bem os alimentos!" +
                "\n","06:00");
        this.listaDietaGanharPeso.add(dietaGanharPeso);
        dietaGanharPeso = new DietaGanharPeso("Lanche da manhã","Pão de forma light - Wickbold® (Fatia (20g): 2)\t " +
                "\nPeito de peru light (Fatia: 1)\t " +
                "\nQueijo de minas light (Fatia: 2)\t " +
                "\nObs: -Tente introduzir aos poucos o pão integral e também o queijo branco,o integral irá melhorar o suporte de vitaminas e minerais e o queijo branco é uma alternativa mais leve á mussarela;" +
                "\n- Em dias mais corridos, consuma uma barra de castanhas + 1 fruta (banana, maçã,pera, 1/2 mamão ,1 fatia de melão ou fatia de abacaxi),ou pode ser também um suco da fruta.\n"
                ,"10:00");
        this.listaDietaGanharPeso.add(dietaGanharPeso);
        dietaGanharPeso = new DietaGanharPeso("Almoço", "Arroz branco (cozido) (Colher de sopa rasa (15g): 5)\t" +
                " \nFeijão cozido (só grãos) (Colher de servir (48g): 1)\t" +
                " \nFilé de frango grelhado (Filé pequeno (100g): 1)\t" +
                " \nObs: -adicione a sua refeição vegetais cozidos ( 3 colheres de sopa );" +
                "\n-salada de folhas verdes a vontade!\n-dê sempre a preferencia aos temperos naturais;" +
                "\n-evite o consumo excessivo de sal!\n-Beba líquidos 20 minutos antes ou após as refeições!\n"
                ,"14:00");
        this.listaDietaGanharPeso.add(dietaGanharPeso);
        dietaGanharPeso = new DietaGanharPeso("Pré treino","BCAA 3000 - Max Titanium (Grama: 3)\t " +
                "\nBanana (Unidade pequena (42g): 1)\t " +
                "\nObs: -Tomar 3 gramas de bcaa´s ( Max Titanium,Black Skull,Optimum Nutrition , Arnold );" +
                "\n-Junto ao Bcaa´s,consuma uma fruta (banana,maçã,pera,laranja(suco),porção de morangos ( 8 unidades );" +
                "\n","18:00");
        /*this.listaDietaGanharPeso.add(dietaGanharPeso);
        dietaGanharPeso = new DietaGanharPeso("Pós treino","sdfsd","asdfsadfsdfsdaf", "20:00");*/
        this.listaDietaGanharPeso.add(dietaGanharPeso);
        dietaGanharPeso = new DietaGanharPeso("Janta", "Batata doce, cozida, sem pele, sem sal (Unidade Pequena: 1)\t " +
                "\nCarne, bovina, patinho, sem gordura, grelhado (Grama: 60)\t " +
                "\nObs: -Como alternativa ao patinho moído ( 3 colheres de sopa cheia),você pode preparar 1 filé de frango grelhado pequeno ou fazer uma omelete com 3 ovos(utilizando apenas uma clara );" +
                "\n-Utilize uma xícara de chá de macarrão (tente introduzir o integral aos poucos ) no lugar da batata ou consuma 5 colheres de arroz (tente introduzir o integral aos poucos também);" +
                "\n-Salada de folhas verdes a vontade!" +
                "\n-Sempre usar temperos naturais e evitar o consumo excessivo de sal;" +
                "\n-Beber líquidos 20 minutos antes ou após as refeições!\n", "21:00");
        this.listaDietaGanharPeso.add(dietaGanharPeso);
    }
}
