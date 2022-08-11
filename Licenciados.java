import java.util.ArrayList;
/**
 * Subclasse que cria Licenciados a partir da classe Formandos
 */
public class Licenciados extends Formandos {
    /**
     * Construtor que inicializa o objeto Licenciado
     * @param nome nome do Licenciado
     * @param mail mail do Licenciado
     * @param dataInicio data de inicio de Licenciado
     * @param dataFim data Final do Licenciado
     */
    public Licenciados(String nome, String mail, Data dataInicio, Data dataFim) {
        super(nome, mail, dataInicio, dataFim);
    }
    /**
     * Devolve o custo do Licenciado, que é 800
     * @return 800
     */
    public int custo() {
        return 800;
    }

}
