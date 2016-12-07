package dataprovider;

import java.util.List;

import domain.Exercicio;

/**
 * Created by João Vinaud on 06/12/2016.
 */

public interface IExercicioDAO {

    public List<Exercicio> getExercicios();
    public void addExercicio(Exercicio exercicio);
    public Exercicio getExercicio(String title);
}
