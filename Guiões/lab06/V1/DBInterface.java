package V1;
import java.util.List;

public interface DBInterface {
    
    void insere(Empregado emp);
    void remove (int codigo);
    boolean isEmpregado(int codigo);
    List<Empregado>listaDeEmpregados();
}
