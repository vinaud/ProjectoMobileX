package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.joovinaud.projmobile.R;

import java.util.List;

import domain.Academia;
import domain.Exercicio;

/**
 * Created by João Vinaud on 06/12/2016.
 */

public class ExercicioAdapter extends ArrayAdapter<Exercicio> {

    public ExercicioAdapter(Context context, int textViewResourceId, List<Exercicio> objects) {
        super(context, textViewResourceId, objects);
    }

    public View getView(int position, View convertView,
                        ViewGroup parent) {
        View view = convertView;
       // if (view == null) {
            LayoutInflater inflater = (LayoutInflater)
                    getContext().getSystemService
                            (Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_exercicios,
                    null);
       // }
        Exercicio item = getItem(position);
        if (item!= null) {
           /* ImageView imagem = (ImageView) view.findViewById(R.id.photoView);
            imagem.setImageResource(R.drawable.caminhada);*/

            TextView titulo = (TextView)
                    view.findViewById(R.id.texer);
            titulo.setText(item.getName());
        }
        return view;
    }


}
