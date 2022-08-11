import java.io.Serializable;
import java.util.ArrayList;
/**
 * Classe abstrata pessoa, com o intuito de guardar informacao de cada pessoa pertencente ao Centro de Investigacao(CentroDeInv)
 */
public abstract class Pessoa implements Serializable {
    private String nome,mail;
    private double disp;
    /**
     * Contrutor para inicializar o objeto Pessoa
     * @param nome nome da Pessoa
     * @param mail mail da Pessoa
     */
    public Pessoa(String nome,String mail) {
        this.nome = nome;
        this.mail=mail;
    }
    /**
     * Adiciona a dispobilidade da pessoa
     * @param disp o numero que vai incremnetar o valor de disponibilidade da peesoa
     */
    public void atualDisp(double disp){
        this.disp+=disp;
    }
    /**
     * Devolve o nome da pessoa
     * @return nome da pessoa
     */
    public String getNome() {
        return nome;
    }
    /**
     * Devolve o mail da pessoa
     * @return mail da pessoa
     */
    public String getMail() {
        return mail;
    }
    /**
     * Devolve a disponibilidade da pessoa
     * @return a disponibilidade pessoa
     */
    public double getDisp() {
        return disp;
    }
    /**
     * Metodo abstrato que devolve o custo da pessoa dependendo do tipo de pessoa que é
     * @return devolve o custo da pessoa
     */
    public abstract int custo();

    @Override
    public String toString() {
        return nome;
    }
}
