import java.util.ArrayList;
/**
 * Sublasse abstrata que cria formandos a partir da classe Bolseiros com um atributo a mais
 */
public abstract class Formandos extends Bolseiros {
    private ArrayList<Docente> docentes;
    /**
     * Construtor que inicializa o objeto Formandos
     * @param nome nome do formando
     * @param mail mail do formando
     * @param dataInicio data de inicio do contrato do Formando
     * @param dataFim data de Fim do contrato do Formando
     */
    public Formandos(String nome, String mail,Data dataInicio, Data dataFim) {
        super(nome, mail, dataInicio, dataFim);
    }

    public ArrayList<Docente> getDocentes() {
        return docentes;
    }
    /**
     * Define a lista de docentes do projeto em que este bolseiro esta associado
     * @param ds lista de docentes do projeto em que este bolseiro esta associado
     */
    public void setDocentes(ArrayList<Docente> ds){
        this.docentes=ds;
    }
    /**
     * Devolve o custo dependendo do tipo de Formando
     * @return custo do Formando
     */
    @Override
    public abstract int custo();

}
