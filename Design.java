/**
 * Subclasse que cria a tarefa do tipo Design a pratir da classe tarefa
 */
public class Design extends Tarefa {

    /**
     * Construtor para inicializar o objeto Design
     * @param dataInicio data de inico da tarefa do tipo design
     * @param dataFim data final da tarefa do tipo design
     * @param perc  percentagem da tarefa do tipo design
     * @param duracaoEst duracao estimada da tarefa do tipo design
     * @param nome nome da tarefa do tipo design
     */
    public Design(Data dataInicio, Data dataFim, float perc, int duracaoEst, String nome) {
        super(dataInicio, dataFim, perc, duracaoEst, nome);
    }
    /**
     * Define a pessoa responsavel, verificando certas condicoes, e devolve um booelan se houver sucesso ou nao na definicao
     * @param p uma pessoa
     * @return um boolean
     */
    @Override
    public boolean setResp(Pessoa p) {
        if(p.getDisp()==1){
            return false;
        }else if(p.getDisp()+txEsf()>1) {
            return false;
        }
        super.putResp(p);
        return true;
    }
    /**
     * Devolve a taxa de esforco deste tipo de tarefa
     * @return 0.5
     */
    @Override
    public double txEsf() {
        return 0.5;
    }
}
