package dataprovider;

import java.util.ArrayList;
import java.util.List;

import domain.Academia;

/**
 * Created by João Vinaud on 04/12/2016.
 */

public class AcademiaDAOMock implements IAcademiaDAO {

    private ArrayList<Academia> lista = new ArrayList<Academia>();

    public AcademiaDAOMock() {
        lista.add( new Academia("Praça do cruzeiro",-5.8840589,-35.1720139,"R. Vereador Manoel Coringa",1));
        lista.add( new Academia("Praça Presidente Tancredo Neves",-5.8750673,-35.1852688,"Av. Praia de Tibau, s/n - Ponta Negra, Natal - RN, 59094-500",2));
        lista.add( new Academia("Praça da Árvore",-5.8448481,-35.2079709,"Av. Sen. Salgado Filho - Capim Macio",3));
        lista.add( new Academia("Praça das Mangueiras",-5.8167062,-35.2144224,"Rua Umarizal - Lagoa Nova",4));
    }

    @Override
    public List<Academia> getAcademias() {
        return lista;
    }

    @Override
    public void addAcademia(Academia academia) {
        lista.add(academia);
    }

    @Override
    public Academia getAcademia(String title)
    {
        for (Academia temp : lista)
        {
            if ( temp.getTitle().equals(title))
            {
                return temp;
            }
        }
        return null;
    }
}
