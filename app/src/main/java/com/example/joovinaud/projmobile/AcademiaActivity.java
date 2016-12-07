package com.example.joovinaud.projmobile;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import adapters.ExercicioAdapter;
import dataprovider.AcademiaDAOMock;
import dataprovider.ExercicioDAOMock;
import dataprovider.IAcademiaDAO;
import dataprovider.IExercicioDAO;
import domain.Academia;
import domain.Exercicio;

public class AcademiaActivity extends AppCompatActivity {

    private TextView titulo;
    private TextView end;
    private IAcademiaDAO dao;
    Academia acad;
    private ImageView mImageView;

    private ExercicioAdapter adapter;
    private IExercicioDAO dao2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academia);

        titulo = (TextView) findViewById(R.id.tituloView);
        end = (TextView) findViewById(R.id.enderecoView);

        Intent intent = getIntent();

        titulo.setText(intent.getStringExtra("Nome"));

        dao = new AcademiaDAOMock();

        acad = dao.getAcademia(intent.getStringExtra("Nome"));

        end.setText(acad.getDesc());

        mImageView = (ImageView) findViewById(R.id.imageView3);


            switch (acad.getId()) {
                case 1:
                    mImageView.setImageResource(R.drawable.cruzeiro);
                    break;
                case 3:
                    mImageView.setImageResource(R.drawable.arvore);
                    break;
                default:
                    mImageView.setImageResource(R.drawable.download);
                    break;
            }



        dao2 = new ExercicioDAOMock();
        List<Exercicio> exercicios = dao2.getExercicios();

        ListView  listView = (ListView) findViewById(R.id.lv1);

        adapter = new ExercicioAdapter(this, R.layout.list_exercicios, exercicios);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Exercicio entry= (Exercicio) parent.getAdapter().getItem(position);
                Intent intent = new Intent(AcademiaActivity.this,AtividadeActivity.class);
                intent.putExtra("id", entry.getId());
                startActivity(intent);
            }
        });

    }
}
