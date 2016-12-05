package dataprovider;

import java.util.List;

import domain.Academia;
import domain.User;

/**
 * Created by João Vinaud on 04/12/2016.
 */

public interface IAcademiaDAO {

    public List<Academia> getAcademias();
    public void addAcademia(Academia academia);
    public Academia getAcademia(String title);
}
