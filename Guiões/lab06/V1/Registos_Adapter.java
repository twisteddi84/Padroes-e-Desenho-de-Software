package V1;
import java.util.List;
import java.util.ArrayList;
public class Registos_Adapter implements DBInterface{
    private Registos r1 = new Registos();
    
    public void insere(Empregado emp) {
        r1.insere(emp);
    }
    public void remove (int codigo) {
        r1.remove(codigo);
    }
    public boolean isEmpregado(int codigo) {
        return r1.isEmpregado(codigo);
    }
    public List<Empregado>listaDeEmpregados() {
        return r1.listaDeEmpregados();
    }  
}
