import java.sql.SQLSyntaxErrorException;
/**
 * Subclasse que cria a tarefa do tipo Desenvolvimento a pratir da classe tarefa
 */

public class Desenvolvimento extends Tarefa {
    /**
     * Construtor para inicializar o objeto Desenvolvimento
     * @param dataInicio data de inico da tarefa do tipo desenvolvimento
     * @param dataFim data final da tarefa do tipo desenvolvimento
     * @param perc  percentagem da tarefa do tipo desenvolvimento
     * @param duracaoEst duracao estimada da tarefa do tipo desenvolvimento
     * @param nome nome da tarefa do tipo desenvolvimento
     */
    public Desenvolvimento(Data dataInicio, Data dataFim, float perc, int duracaoEst, String nome) {
        super(dataInicio, dataFim, perc, duracaoEst, nome);
    }
    /**
     * Define a pessoa responsavel, verificando certas condicoes, e devolve um booelan se houver sucesso ou nao na definicao
     * @param p uma pessoa
     * @return um boolean
     */
    @Override
    public boolean setResp(Pessoa p) {
        if(p.getDisp()==1){ return false;
        }else if(p.getDisp()+txEsf()>1) return false;
        super.putResp(p);
        return true;
    }
    /**
     * Devolve a taxa de esforco deste tipo de tarefa
     * @return 1
     */
    @Override
    public double txEsf() {
        return 1;
    }

}
