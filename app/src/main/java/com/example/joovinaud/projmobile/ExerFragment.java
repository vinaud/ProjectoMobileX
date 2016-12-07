package com.example.joovinaud.projmobile;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

import adapters.ExercicioAdapter;
import dataprovider.ExercicioDAOMock;
import dataprovider.IExercicioDAO;
import domain.Exercicio;


public class ExerFragment extends Fragment {

    private ListView ListView;
    private ExercicioAdapter adapter;
    public ExerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_exer, container,
                false);

      /*  IExercicioDAO dao2 = new ExercicioDAOMock();
        List<Exercicio> exercicios = dao2.getExercicios();

        /*ListView = (ListView) v.findViewById(R.id.list);
        adapter = new ExercicioAdapter(this.getContext(), R.layout.list_exercicios, exercicios);

        ListView.setAdapter(adapter);*/
        // Inflate the layout for this fragment
        return v;
    }


    public void ver(View view) {
        Intent i = new Intent(this.getActivity(),AtividadeActivity.class);
        this.getActivity().startActivity(i);
    }

    public void ver2(View view) {
        Intent i = new Intent(this.getActivity(),AtividadeActivity.class);
        this.getActivity().startActivity(i);
    }

    public void ver3(View view) {
        Intent i = new Intent(this.getActivity(),AtividadeActivity.class);
        this.getActivity().startActivity(i);
    }

    public void ver4(View view) {
      //  Intent i = new Intent(this.getActivity(),AtividadeActivity.class);
      //  this.getActivity().startActivity(i);

        PlanosFragment fragment2 = new PlanosFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction =        fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content_frame, fragment2);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
