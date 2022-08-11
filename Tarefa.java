import java.io.Serializable;
import java.time.LocalDate;
import java.util.Scanner;
/**
 * Classe tarefa para guardar informacoes sobre uma tarefa
 */
public abstract class Tarefa implements Serializable {
    private Data dataInicio,dataFim;
    private float perc;
    private String nome;
    private int duracaoEst;
    private Pessoa resp;

    public Tarefa(Data dataInicio, Data dataFim, float perc,int duracaoEst,String nome) {
        this.dataInicio = dataInicio;
        this.dataFim=dataFim;
        this.duracaoEst=duracaoEst;
        this.perc=perc;
        this.nome=nome;
    }
    /**
     * Devolve a pessoa responsavel da tarefa
     * @return a pessoa responsavel da tarefa
     */
    public Pessoa getResp() {
        return resp;
    }

    /**
     * atualiza a percentagem da conclusao da tarefa, consoante certas condicoes expostas dentro do codigo
     * @param num percentagem da conclusao da tarefa
     * @return true or false
     */
    public boolean atualPerc(float num){
        if(num<=this.perc) return false;
        else{
            if(num==100){
                Data dataF=new Data(LocalDate.now().getDayOfMonth(),LocalDate.now().getMonthValue(),LocalDate.now().getYear());
                this.setDataFim(dataF);
            }
        }
        this.perc=num;
        return true;
    }
    /**
     * Devolve a data inicial da tarefa
     * @return a data inicial da tarefa
     */
    public Data getDataInicio() {
        return dataInicio;
    }
    /**
     * Define a pessoa a responsavel da tarefa e devolve um boolean caso tenha sido possivel efetuar a definicao
     * @param p pessoa
     * @return um boolean
     */
    public abstract boolean setResp(Pessoa p);
    /**
     * Define a pessoa responsavel
     * @param p pessoa
     */
    public void putResp(Pessoa p){
        this.resp=p;
    }
    /**
     * Devolve a percentagem de conclusao de tarefa
     * @return percentagem de conclusao de tarefa
     */
    public float getPerc() {
        return perc;
    }
    /**
     * Devolve o nome da tarefa
     * @return nome da tarefa
     */
    public String getNome() {
        return nome;
    }
    /**
     * Devolve a taxa de esforco, que depende do tipo de tarefa que é
     * @return taxa de esforco
     */
    public abstract double txEsf();
    /**
     * Devolve a data final da tarefa
     * @return data final da tarefa
     */
    public Data getDataFim() {
        return dataFim;
    }

    /**
     * Devolve a duracao estimada da tarefa
     * @return duracao estimada da tarefa
     */
    public int getDuracaoEst() {
        return duracaoEst;
    }

    /**
     * Define a data final da tarefa
     * @param dataFim data final da tarefa
     */

    public void setDataFim(Data dataFim) {
        this.dataFim = dataFim;
    }

    @Override
    public String toString() {
        return nome;
    }
}