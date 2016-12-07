package dataprovider;

import java.util.ArrayList;
import java.util.List;
import domain.Exercicio;

/**
 * Created by João Vinaud on 06/12/2016.
 */

public class ExercicioDAOMock implements IExercicioDAO {

    private ArrayList<Exercicio> lista = new ArrayList<Exercicio>();

    public ExercicioDAOMock() {
        lista.add(new Exercicio("Simulador de caminhada","lorem ipsum","1"));
        lista.add(new Exercicio("Girador","lorem ipsum","2"));
        lista.add(new Exercicio("Peitoral","lorem ipsum","3"));
        lista.add(new Exercicio("Remada","lorem ipsum","4"));
    }


    @Override
    public List<Exercicio> getExercicios() {
        return lista;
    }

    @Override
    public void addExercicio(Exercicio exercicio) {
    lista.add(exercicio);
    }

    @Override
    public Exercicio getExercicio(String id) {
        for (int i = 0;i<lista.size();i++)
        {
            if ( lista.get(i).getId().toString().equals(id))
            {
                return lista.get(i);
            }
        }
        return null;
    }
}
