import java.io.*;
import java.time.LocalDate;
import java.util.*;

/**
 * Classe CentroDeInv com o proposito de simular um Centro de Informática e Sistemas da Universidade de Coimbra (CISUC)
 * @author Alexandre Santos e Guilherme Gaspar
 */
public class CentroDeInv {
    private String nome;
    private ArrayList<Projeto> projs;
    private  ArrayList<Pessoa> pes;
    private ArrayList<Docente> doc;
    private ArrayList<Licenciados> lic;
    private ArrayList<Mestres> mest;
    private ArrayList<Doutorados> dout;

    public CentroDeInv(String nome){
        this.nome = nome;
        this.projs =new ArrayList<>();
        this.pes=new ArrayList<>();
        this.doc=new ArrayList<>();
        this.lic = new ArrayList<>();
        this.mest = new ArrayList<>();
        this.dout = new ArrayList<>();

    }


    /**
     * vai buscar Lista de pessoas dentro do Centro de Investigacao
     * @return Lista de pessoas dentro do Centro de Investigacao
     */
    public  ArrayList<Pessoa> getPes() {
        return pes;
    }
    /**
     * vai buscar Lista de projetos existentes do Centro de Investigacao
     * @return Lista de projetos existentes dentro do Centro de Investigacao
     */
    public  ArrayList<Projeto> getProjs() {
        return projs;
    }

    /**
     * Funcao para definir quais sao os projetos
     * @param projs nova lista de projetos
     */
    public void setProjs(ArrayList<Projeto> projs) {
        this.projs = projs;
    }

    /**
     * Devolve a lista de projetos concluidos
     * @return lista de projetos concluidos
     */
    public ArrayList<Projeto> listarProjsConc(){
        int i;
        ArrayList<Projeto> projsConc=new ArrayList<Projeto>();
        for(i=0;i<projs.size();i++){
            Projeto n=projs.get(i);
            if(n.isEstado()) projsConc.add(n);
        }
        return projsConc;
    }

    /**
     * Devolve a lista de projetos nao concluidos
     * @return lista de projetos nao concluidos
     */
    public ArrayList<Projeto> listarProjsNaoConc(){
        int i;
        LocalDate ld=LocalDate.now();
        ArrayList<Projeto> projsNaoConc=new ArrayList<Projeto>();
        for(i=0;i<projs.size();i++){
            Projeto n=projs.get(i);
            if(!n.isEstado()) {
                LocalDate ld1=LocalDate.of(n.getDataInicial().getAno(),n.getDataInicial().getMes(),n.getDataInicial().getDia());
                LocalDate lde=ld1.plusMonths(n.getDEstimada());
                if (LocalDate.now().isBefore(lde)) projsNaoConc.add(n);
            }
        }
        return projsNaoConc;
    }


    public void writeFichObjPes() {
        try{
            File pes = new File("pessoas.obj");
            ObjectOutputStream os=new ObjectOutputStream(new FileOutputStream(pes));
            os.writeObject(this.pes);
            os.close();
        } catch (IOException e) {
            System.out.println("Erro a escrever ficheiro.");
        }
    }

    public void writeFichObjProj(){
        try{
            File projs = new File("projetos.obj");
            ObjectOutputStream os=new ObjectOutputStream(new FileOutputStream(projs));
            os.writeObject(this.projs);
            os.close();
        } catch (IOException e) {
            System.out.println("Erro a escrever ficheiro.");

        }
    }

    /**
     *Le o ficheiro de texto "Tarefas.txt" disponivel na pasta do projeto e transfere a informacao para usarmos no codigo
     */
    public void lerFichTar(){
        File f= new File("Tarefas.txt");
        try{
            BufferedReader br=new BufferedReader(new FileReader(f));
            String line;
            while ((line=br.readLine())!=null){
                int i;
                String[] div=line.split(",");
                for(i=0;i<projs.size();i++){
                    if(projs.get(i).getAcronimo().equals(div[0])) {
                        int k;
                        for (k = 1; k < div.length; k++) {
                            String[] ts = div[k].split("#");
                            String nome = ts[1];
                            int est=Integer.parseInt(ts[2]);
                            String[] di=ts[3].split("/");
                            Data dataI,dataF;
                            dataI=new Data(Integer.parseInt(di[0]),Integer.parseInt(di[1]),Integer.parseInt(di[2]));
                            String[] df=ts[4].split("/");
                            dataF=new Data(Integer.parseInt(df[0]),Integer.parseInt(df[1]),Integer.parseInt(df[2]));
                            float perc=Float.parseFloat(ts[5]);
                            int g;
                            Pessoa p = null;
                            int nada=0;
                            if (!ts[6].equals("0")){
                                nada=1;
                                for (g = 0; g < pes.size(); g++) {
                                    p = pes.get(g);
                                    if (p.getNome().equals(ts[6])) break;
                                }
                            }
                            if (ts[0].equals("D1")) {
                                Design d=new Design(dataI,dataF,perc,est,nome);
                                if(nada!=0){
                                    d.setResp(p);
                                    p.atualDisp(d.txEsf());
                                }
                                projs.get(i).assocTar(d);
                            }
                            if(ts[0].equals("D2")){
                                Desenvolvimento d=new Desenvolvimento(dataI,dataF,perc,est,nome);
                                if(nada!=0) {
                                    d.setResp(p);
                                    p.atualDisp(d.txEsf());
                                }
                                projs.get(i).assocTar(d);
                            }
                            if(ts[0].equals("D3")){
                                Documentacao d=new Documentacao(dataI,dataF,perc,est,nome);
                                if(nada!=0) {
                                    d.setResp(p);
                                    p.atualDisp(d.txEsf());
                                }
                                projs.get(i).assocTar(d);
                            }
                        }
                        break;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Ficheiro de tarefas nao encontrado");
        } catch (IOException e) {
            System.out.println("Erro no ficheiro de tarefas");
        }
    }

    /**
     *Le o ficheiro de texto "Projetos.txt" disponivel na pasta do projeto e transfere a informacao para usarmos no codigo
     */
    public void lerFichProj() {
        File f = new File("Projetos.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    Projeto novo;
                    String[] projsD = line.split(",");
                    String nome, acronimo;
                    Data dataIni = new Data(), dataFim = new Data();
                    int dEstimada, custo;
                    boolean estado;
                    nome = projsD[0];
                    acronimo = projsD[1];
                    custo = Integer.parseInt(projsD[2]);
                    String[] dataI = projsD[3].split("/", 3);
                    dataIni.setDia(Integer.parseInt(dataI[0]));
                    dataIni.setMes(Integer.parseInt(dataI[1]));
                    dataIni.setAno(Integer.parseInt(dataI[2]));
                    dEstimada = Integer.parseInt(projsD[4]);
                    String[] dataF = projsD[5].split("/", 3);
                    dataFim.setDia(Integer.parseInt(dataF[0]));
                    dataFim.setMes(Integer.parseInt(dataF[1]));
                    dataFim.setAno(Integer.parseInt(dataF[2]));
                    estado = Boolean.parseBoolean(projsD[6]);
                    novo = new Projeto(nome, acronimo, dEstimada, dataIni, dataFim, custo, estado);
                    int numIp=Integer.parseInt(projsD[7]);
                    String[] numM=projsD[8].split("#");
                    int k;
                    for(k=0;k<numM.length;k++){
                        int a;
                        for(a=0;a<pes.size();a++){
                            if(pes.get(a).getClass()==Docente.class){
                                Docente d= (Docente) pes.get(a);
                                if(d.getNumMecanografico()==Integer.parseInt(numM[k])) novo.assocDocente(d);
                                if(d.getNumMecanografico()==numIp) novo.setIP(d);
                            }
                        }
                    }
                    String[] mailBol = projsD[9].split("#");
                    for (k = 0; k < mailBol.length; k++) {
                        int a;
                        for (a = 0; a < pes.size(); a++) {
                            if (pes.get(a).getClass() == Licenciados.class) {
                                Licenciados d = (Licenciados) pes.get(a);
                                if (d.getMail().equals(mailBol[k])) {
                                    novo.atualCusto(d.custo());
                                    d.setDocentes(novo.getDocentes());
                                    novo.assocBolseiro(d);
                                }
                            }
                            if (pes.get(a).getClass() == Mestres.class) {
                                Mestres m = (Mestres) pes.get(a);
                                if (m.getMail().equals(mailBol[k])) {
                                    novo.atualCusto(m.custo());
                                    m.setDocentes(novo.getDocentes());
                                    novo.assocBolseiro(m);
                                }
                            }
                            if (pes.get(a).getClass() == Doutorados.class) {
                                Doutorados d = (Doutorados) pes.get(a);
                                if (d.getMail().equals(mailBol[k])) {
                                    novo.atualCusto(d.custo());
                                    novo.assocBolseiro(d);
                                }
                            }
                        }
                    }
                    projs.add(novo);
                }catch (Exception e){
                    e.printStackTrace();
                    System.out.println("Erro a por projeto na estrutura");
                }
            }
            br.close();
        }
        catch (FileNotFoundException ex) {
            System.out.println("Erro a abrir ficheiro de texto.");
        }
        catch (IOException ex) {
            System.out.println("Erro a ler ficheiro de texto.");
        }
    }

    /**
     *Le o ficheiro de texto "Pessoas.txt" disponivel na pasta do projeto e transfere a informacao para usarmos no codigo
     */
    public void lerFichPes(){
        File f=new File("Pessoas.txt");
        try{
            BufferedReader br=new BufferedReader(new FileReader(f));
            String line;
            while((line=br.readLine())!=null){
                String[] pesD = line.split(",");
                if (!pesD[0].equals("D")){
                    String nome, mail;
                    Data dataI = new Data(), dataF = new Data();
                    nome = pesD[1];
                    mail = pesD[2];
                    String[] dataIni = pesD[3].split("/");
                    dataI.setDia(Integer.parseInt(dataIni[0]));
                    dataI.setMes(Integer.parseInt(dataIni[1]));
                    dataI.setAno(Integer.parseInt(dataIni[2]));
                    String[] dataFin = pesD[4].split("/");
                    dataF.setDia(Integer.parseInt(dataFin[0]));
                    dataF.setMes(Integer.parseInt(dataFin[1]));
                    dataF.setAno(Integer.parseInt(dataFin[2]));
                    if (pesD[0].equals("L")) {
                        Licenciados l = new Licenciados(nome, mail, dataI, dataF);
                        pes.add(l);
                        lic.add(l);
                    }
                    if (pesD[0].equals("M")) {
                        Mestres m = new Mestres(nome, mail, dataI, dataF);
                        pes.add(m);
                        mest.add(m);
                    }
                    if (pesD[0].equals("BD")) {
                        Doutorados d = new Doutorados(nome, mail, dataI, dataF);
                        pes.add(d);
                        dout.add(d);
                    }
                } else if(pesD[0].equals("D")){
                    String nome,mail,area;
                    int num;
                    nome=pesD[1];
                    mail=pesD[2];
                    area=pesD[3];
                    num=Integer.parseInt(pesD[4]);
                    Docente d=new Docente(nome,mail,area,num);
                    pes.add(d);
                    doc.add(d);
                }
            }
            br.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Erro a abrir ficheiro de texto.");
        }
        catch (IOException e) {
            System.out.println("Erro a ler ficheiro de texto.");
        }
    }

    public void setPes(ArrayList<Pessoa> pes) {
        this.pes = pes;
    }

    /**
     *  Funcao pelo qual o programa executa
     * @param args os argumentos
     */
    public static void main(String[] args) {

        CentroDeInv centroDeInv = new CentroDeInv("Cisuc");


        System.out.println("Application on!");
        System.out.println("Loading existing information...");
        // carregar as estruturas a partir dos ficheiros de texto
        File projs = new File("projetos.obj");
        File pes = new File("pessoas.obj");

        if(pes.exists() && projs.exists()){
            System.out.println("Ficheiro de objetos ja existem");
            try{
                FileInputStream fisProj = new FileInputStream(projs);
                ObjectInputStream oisProj = new ObjectInputStream(fisProj);
                centroDeInv.setProjs((ArrayList<Projeto>) oisProj.readObject());
                oisProj.close();
                FileInputStream fisMembros = new FileInputStream(pes);
                ObjectInputStream oisMembros = new ObjectInputStream(fisMembros);
                centroDeInv.setPes((ArrayList<Pessoa>)oisMembros.readObject());
                oisMembros.close();
            } catch (FileNotFoundException e) {
                System.out.println("Ficherio nao encontrado");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Erro no ficheiro");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                System.out.println("Classe nao encontrada");
            }
        }
        else {
            System.out.println("Ficheiro de objetos nao existem");
            centroDeInv.lerFichPes();
            centroDeInv.lerFichProj();
            centroDeInv.lerFichTar();
            try {
                projs.createNewFile();
            } catch (IOException e) {
                System.out.println("Erro a criar ficheiro de projetos.");
            }
            try {
                pes.createNewFile();
            } catch (IOException e) {
                System.out.println("Erro a criar ficheiro de pessoas.");
            }
            centroDeInv.writeFichObjPes();
            centroDeInv.writeFichObjProj();
        }

        Cisuc c = new Cisuc(centroDeInv);


    }
}
