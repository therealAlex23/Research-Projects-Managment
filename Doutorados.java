import java.util.ArrayList;
/**
 * Subclasse que cria Doutorado a partir da classe Bolseiros
 */
public class Doutorados extends Bolseiros{
    /**
     * Construtor que inicializa o objeto Doutorado
     * @param nome nome do Doutorado
     * @param mail mail do Doutorado
     * @param dataInicio data de inicio de Doutorado
     * @param dataFim data Final do Doutorado
     */
    public Doutorados(String nome, String mail, Data dataInicio, Data dataFim) {
        super(nome, mail, dataInicio, dataFim);
    }
    /**
     * Devolve o custo do Doutorado
     * @return 1200
     */
    public int custo() {
        return 1200;
    }

}
