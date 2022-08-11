import java.time.LocalDate;
import java.util.ArrayList;
/**
 * Subclasse abstrata que cria Bolseiros a partir da class Pessoa com 2 atributos a mais
 */
public abstract class Bolseiros extends Pessoa {
    Data dataInicio,dataFim;
    /**
     * Construtor que inicializa o objeto Bolseiros
     * @param nome nome do Bolseiro
     * @param mail mail do Bolseiro
     * @param dataInicio data de inicio do contrato do Bolseiro
     * @param dataFim data Final do contrato do Bolseiro
     */
    public Bolseiros(String nome, String mail, Data dataInicio, Data dataFim) {
        super(nome, mail);
        this.dataFim=dataFim;
        this.dataInicio=dataInicio;
    }
    /**
     * Devolve a data de inicio do contrato do Bolseiro
     * @return data de inicio do contrato do Bolseiro
     */
    public Data getDataInicio() {
        return dataInicio;
    }
    /**
     * Devolve a data Final do contrato do Bolseiro
     * @return data Final do contrato do Bolseiro
     */
    public Data getDataFim() {
        return dataFim;
    }

    /**
     * verifica contrato do bolseiro e devolve true or false consoante a validacao do contrato
     * @return true or false
     */
    public boolean verContrato(){
        LocalDate ld=LocalDate.now();
        LocalDate ld1=LocalDate.of(dataFim.getAno(),dataFim.getMes(),dataFim.getDia());
        if(ld.isAfter(ld1)) return false;
        return true;
    }
    /**
     * verifica se o contrato do bolseiro ja esta ativo e devolve true or false consoante se esta ativo ou nao
     * @return true or false
     */
    public boolean valBol(){
        LocalDate ld=LocalDate.of(this.dataInicio.getAno(),this.getDataInicio().getMes(),this.dataInicio.getDia());
        if(LocalDate.now().isBefore(ld)) return false;
        return true;
    }
    /**
     * Devolve o custo, que depende do tipo de bolseiro
     * @return custo do bolseiro
     */
    @Override
    public abstract int custo();

}
