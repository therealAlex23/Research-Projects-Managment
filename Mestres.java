import java.util.ArrayList;
/**
 * Subclasse que cria Mestre a partir da classe Formandos
 */
public class Mestres extends Formandos {
    /**
     * Construtor que inicializa o objeto Mestres
     * @param nome nome do Mestre
     * @param mail mail do Mestre
     * @param dataInicio data de inicio de Mestres
     * @param dataFim data Final do Mestres
     */
    public Mestres(String nome, String mail, Data dataInicio, Data dataFim) {
        super(nome, mail, dataInicio, dataFim);
    }
    /**
     * Devolve o custo do Mestre
     * @return 1000
     */
    @Override
    public int custo() {
        return 1000;
    }


}
