
/**
 * Cria a classe Docente a partir da Classe Pessoa com uns atributos a mais
 */
public class Docente extends Pessoa {
    private String area;
    private int numMecanografico;
    /**
     * Construtor que inicializa o objeto Docente
     * @param nome nome do docente
     * @param mail mail do docente
     * @param area area do docente
     * @param numMecanografico numero mecanografico do docente
     */
    public Docente(String nome, String mail, String area,int numMecanografico) {
        super(nome, mail);
        this.area=area;
        this.numMecanografico=numMecanografico;
    }
    /**
     * Devolve area do docente
     * @return area do docente
     */
    public String getArea() {
        return area;
    }
    /**
     * Devolve numero mecanografico do docente
     * @return numero mecanografico do docente
     */
    public int getNumMecanografico() {
        return numMecanografico;
    }
    /**
     * Devolve custo do docente
     * @return 0
     */
    public int custo(){
        return 0;
    }

}

