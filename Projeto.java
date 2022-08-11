
import javax.print.Doc;
import javax.swing.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe Projeto que serve para guardar a informação a cerca de um projeto que exista no Centro de Investigacao(CentroDeInv)
 */
public class Projeto implements Serializable {
    private String nome,acronimo;
    private int dEstimada;
    private Data dataInicial,dataFinal;
    private int custo;
    private boolean estado;
    private ArrayList<Docente> docentes;
    private ArrayList<Bolseiros> bolseiros;
    private ArrayList<Tarefa> tarefas;
    private Docente IP;

    /**
     * E um construtor que inicializa o objeto Projeto,
     * @param nome nome do projeto
     * @param acronimo cronimo do projeto
     * @param dEstimada duracao estimada do projeto
     * @param dataInicial data inicial do projeto
     * @param dataFinal data final do projeto
     * @param custo custo do projeto
     * @param estado estado do projeto
     * Dentro do construtor inicializa ainda as ArrayLists docentes, bolseiros e tarefas
     */
    public Projeto(String nome,String acronimo,int dEstimada,Data dataInicial,Data dataFinal,int custo, boolean estado) {
        this.nome = nome;
        this.acronimo=acronimo;
        this.dEstimada=dEstimada;
        this.dataFinal=dataFinal;
        this.dataInicial=dataInicial;
        this.custo=custo;
        this.estado=estado;
        this.docentes=new ArrayList<Docente>();
        this.bolseiros=new ArrayList<Bolseiros>();
        this.tarefas=new ArrayList<Tarefa>();
    }

    /**
     * Define a data final do projeto
     * @param dataFinal data final do projeto
     */

    public void setDataFinal(Data dataFinal) {
        this.dataFinal = dataFinal;
    }

    /**
     * termina projeto e devolve true or false caso a operacao foi com sucesso ou nao
     * @return true or false
     */
    public boolean termProj(){
        int i;
        for(i=0;i<this.tarefas.size();i++) if(this.tarefas.get(i).getPerc()!=100) return false;
        this.setEstado(true);
        return true;
    }

    /**
     * Atualiza o custo do projeto
     * @param num custo adicional ao projeto
     */
    public void atualCusto(int num){
        this.custo+=num;
    }

    /**
     * atribui a tarefa a uma pessoa e devolve true or false, consoante se a operacao teve sucesso ou nao
     * @param p pessoa que vai ficar responsavel pela tarefa
     * @param t tarefa a atribuir
     * @return true or false
     */
    public boolean atribuirTar(Pessoa p,Tarefa t) {
        boolean ver = false;
        if(t.getClass()==Design.class){
            Design d=(Design)t;
            ver=d.setResp(p);
            if(!LocalDate.now().isBefore(LocalDate.of(d.getDataInicio().getAno(),d.getDataInicio().getMes(),d.getDataInicio().getDia()))) p.atualDisp(d.txEsf());
        }
        if(t.getClass()==Desenvolvimento.class){
            Desenvolvimento d=(Desenvolvimento) t;
            ver=d.setResp(p);
            if(ver)p.atualDisp(d.txEsf());
        }
        if(t.getClass()== Documentacao.class){
            Documentacao d=(Documentacao) t;
            ver=d.setResp(p);
            if(ver) p.atualDisp(d.txEsf());
        }
        return ver;
    }

    public void eliminaTar(Tarefa t){
        if(t.getClass()==Design.class){
            Design d=(Design) t;
            if(d.getResp()!=null)d.getResp().atualDisp(-d.txEsf());
        }
        if(t.getClass()==Desenvolvimento.class){
            Desenvolvimento d=(Desenvolvimento) t;
            if(d.getResp()!=null)d.getResp().atualDisp(-d.txEsf());
        }
        if(t.getClass()==Documentacao.class){
            Documentacao d=(Documentacao) t;
            if(d.getResp()!=null)d.getResp().atualDisp(-d.txEsf());
        }
        this.tarefas.remove(t);
    }

    /**
     * devolve uma lista de tarefas nao iniciadas
     * @return lista de tarefas nao iniciadas
     */
    public ArrayList<Tarefa> listarTarNaoIni(){
        ArrayList<Tarefa> tar=new ArrayList<Tarefa>();
        int i;
        for(i=0;i<tarefas.size();i++){
            if(tarefas.get(i).getPerc()==0)  tar.add(tarefas.get(i));
        }
        return tar;
    }

    public ArrayList<Tarefa> listarTarNaoConc(){
        ArrayList<Tarefa> tar=new ArrayList<Tarefa>();
        int i;
        for(i=0;i<tarefas.size();i++){
            if(tarefas.get(i).getPerc()!=100) {
                LocalDate ld = LocalDate.of(tarefas.get(i).getDataInicio().getAno(), tarefas.get(i).getDataInicio().getMes(), tarefas.get(i).getDataInicio().getDia());
                LocalDate lest= ld.plusMonths(tarefas.get(i).getDuracaoEst());
                if (LocalDate.now().isBefore(ld)) tar.add(tarefas.get(i));
            }
        }
        return tar;
    }

    public ArrayList<Tarefa> listarTarConc(){
        ArrayList<Tarefa> tar=new ArrayList<Tarefa>();
        int i;
        for(i=0;i<tarefas.size();i++){
            if(tarefas.get(i).getPerc()==100) tar.add(tarefas.get(i));
        }
        return tar;
    }

    /**
     * Define qual e o Investigador principal
     * @param p novo Investigador Principal
     */
    public void setIP(Docente p){
        this.IP=p;
    }
    /**
     * Devolve o Investigador Principal que e um objeto do tipo Docente
     * @return o Investigador Principal
     */
    public Docente getIP() {
        return IP;
    }
    /**
     * Associa tarefa a lista de tarefas deste projeto
     * @param t nova tarefa
     */
    public void assocTar(Tarefa t){
        this.tarefas.add(t);
    }
    /**
     * Associa docente a lista de docentes do projeto
     * @param d novo docente
     */
    public void assocDocente(Docente d){
        this.docentes.add(d);
    }
    /**
     * Associa bolseiro a lista de bolseiros do projeto
     * @param b novo bolseiro
     */
    public void assocBolseiro(Bolseiros b){
        this.bolseiros.add(b);
    }
    /**
     * Devolve lista de docentes do projeto
     * @return lista de docentes do
     */
    public ArrayList<Docente> getDocentes() {
        return docentes;
    }
    /**
     * Devolve lista de bolseiros do projeto
     * @return lista de bolseiros do projeto
     */
    public ArrayList<Bolseiros> getBolseiros() {
        return bolseiros;
    }

    public ArrayList<Tarefa> getTarefas() {
        return tarefas;
    }
    /**
     * Devolve nome do projeto
     * @return nome do projeto
     */
    public String getNome() {
        return nome;
    }
    /**
     * Devolve duracao estimada do projeto
     * @return duracao estimada do projeto
     */
    public int getDEstimada() {
        return dEstimada;
    }
    /**
     * Devolve data final do projeto
     * @return data final do projeto
     */
    public Data getDataFinal() {
        return dataFinal;
    }
    /**
     * Devolve data inicial do projeto
     * @return data inicial do projeto
     */
    public Data getDataInicial() {
        return dataInicial;
    }
    /**
     * Devolve acronimo do projeto
     * @return acronimo do projeto
     */
    public String getAcronimo() {
        return acronimo;
    }
    /**
     * Devolve custo do projeto
     * @return custo do projeto
     */
    public int getCusto() {
        return custo;
    }
    /**
     * Devolve estado do projeto
     * @return estado do projeto
     */
    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return nome;
    }
}

