import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Classe encarregue da Graphic User Interface
 */
public class Cisuc extends JFrame {
    private CentroDeInv cisuc;
    private DefaultListModel<Projeto> listProjs = new DefaultListModel();
    private DefaultListModel<Pessoa> listPess = new DefaultListModel();
    private DefaultListModel<Projeto> listConc = new DefaultListModel();
    private DefaultListModel<Projeto> listNotConc = new DefaultListModel();
    private DefaultListModel<Pessoa> listDoc = new DefaultListModel();
    private DefaultListModel<Pessoa> listMest = new DefaultListModel();
    private DefaultListModel<Pessoa> listLic = new DefaultListModel();
    private DefaultListModel<Pessoa> listDout = new DefaultListModel();
    private DefaultListModel<Pessoa> listPessProj = new DefaultListModel();
    private DefaultListModel<Tarefa> listTar = new DefaultListModel();
    private DefaultListModel<Tarefa> listTarNC = new DefaultListModel();
    private DefaultListModel<Tarefa> listTarC = new DefaultListModel();
    private DefaultListModel<Tarefa> listTarNIni = new DefaultListModel();
    //Paineis
    private JPanel panel, panelProjetos, panelPessoas, panelCreateProj, panelAssocPess, panelConfigProjeto, panelTodosProjetos, panelProjetosConcluidos, panelProjetosNaoConcluidos,panelListaTarefas,panelAtribuiTarefa;
    private JPanel panelCriaTarefas,panelEliminaTarefas,panelAtualizaTaxaEx,panelListaPessProj;
    //Botões
    private JButton buttonListPess, buttonCreateProj, buttonListProj, buttonAssocPess, buttonVoltar, buttonCriar, buttonSelecionar,buttonAtualizar,buttonElimina,buttonTerminar,buttonListaPessoasProjeto;
    private JButton buttonSelectProjeto, buttonListaTarefas, buttonCriaTarefas, buttonEliminaTarefas, buttonAtribuirTarefa, buttonAtualizaTaxaEx, buttonListaTarefaNaoInicializadas;
    private JButton buttonListaTarefaConcluida, buttonCustoProjeto, buttonVoltarListaProjeto,buttonCriarTar,buttonAtribuir;
    private JButton buttonListarTodosProjetos, buttonListarProjetosConcluidos, buttonListarProjetosNaoConcluidos, buttonVoltarListProj, buttonSelecionaPessoa,buttonAssociar,buttonVoltarConfigProjeto;
    //JList
    private JList<Projeto> listaProj = new JList<>(listProjs);
    private JList<Projeto> listaConc = new JList<>(listConc);
    private JList<Projeto> listaNotConc = new JList<>(listNotConc);
    private JList<Pessoa> listaPess = new JList<>(listPess);
    private JList<Pessoa> listaDocentes = new JList<>(listDoc);
    private JList<Pessoa> listaMestres = new JList<>(listMest);
    private JList<Pessoa> listaLicenciados = new JList<>(listLic);
    private JList<Pessoa> listaDoutorados = new JList<>(listDout);
    private JList<Pessoa> listaPessProj = new JList<>(listPessProj);
    private JList<Tarefa> listaTar = new JList<>(listTar);
    private JList<Tarefa> listaTarNC = new JList<>(listTarNC);
    private JList<Tarefa> listaTarC = new JList<>(listTarC);
    private JList<Tarefa> listaTarNIni = new JList<>(listTarNIni);
    //Combo Box
    private JComboBox comboPessoas,comboTarefas;
    //Scroll panels
    private JScrollPane pessoasProjScroll,projScroll, pessScroll, projConcScroll, projNotConcScroll, docentesScroll, licenciadosScroll, mestresScroll, doutoradosScroll,tarefasScroll,tarefasNCScroll,tarefasCScroll,tarefasNIniScroll;
    //Labels
    private JLabel nomeProj,acrProj,iniDate,durEst,ip,numMec,disponibilidade,inicioBolsa,fimBolsa,mail,numMec1,disponibilidade1,inicioBolsa1,fimBolsa1,mail1,nomePessoaAssoc,nomeProjetoAssoc;
    private JLabel labelDE,labelCriaTarefa,labelTipoTarefa,labelDesign,labelOutras,labelPessoaAtribuir,labelTarefaAtribuir,labelTarefaAtualizar,labelNovaPercentagem,labelNomeEliminar;
    //TextField
    private JTextField nomeProj1,acrProj1,iniDate1,durEst1,ip1,nomeProjetoAssoc1,nomePessoaAssoc1,textCriaTarefa,textTipoTarefa,textPessoaAtribuir,textTarefaAtribuir,textTarefaAtualizar,textNovaPercentagem;
    private JTextField textNomeEliminar,textNomeTerminar,textDE;
    //Listas
    private Projeto pList;
    private Docente dList;
    private Mestres mList;
    private Licenciados lList;
    private Doutorados doList;

    /**
     * Construtor da Graphic User Interface
     * @param centro
     */
    public Cisuc(CentroDeInv centro) {
        super();
        this.cisuc = centro;
        panelListaPessProj = new JPanel();
        panelCriaTarefas = new JPanel();
        panelEliminaTarefas = new JPanel();
        panelAtualizaTaxaEx = new JPanel();
        panelAtribuiTarefa = new JPanel();
        panelListaTarefas = new JPanel();
        panelProjetosNaoConcluidos = new JPanel();
        panelProjetosConcluidos = new JPanel();
        panelTodosProjetos = new JPanel();
        panelConfigProjeto = new JPanel();
        panelAssocPess = new JPanel();
        panelCreateProj = new JPanel();
        panelPessoas = new JPanel();
        panelProjetos = new JPanel();
        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));

        buttonListPess = new JButton("Listar Pessoas");
        buttonListPess.addActionListener(new ButtonListener());
        buttonCreateProj = new JButton("Criar Projeto");
        buttonCreateProj.addActionListener(new ButtonListener());
        buttonListProj = new JButton("Listar Projetos");
        buttonListProj.addActionListener(new ButtonListener());
        buttonAssocPess = new JButton("Associar pessoa a um projeto");
        buttonAssocPess.addActionListener(new ButtonListener());
        buttonVoltar = new JButton("Voltar para menu");
        buttonVoltar.setBounds(225,310,150,25);
        buttonVoltar.addActionListener(new ButtonListener());

        buttonCriar = new JButton("Criar");
        buttonCriar.addActionListener(new ButtonListener());
        buttonSelecionar = new JButton("Selecionar");
        buttonSelecionar.addActionListener(new ButtonListener());
        buttonSelecionaPessoa = new JButton("Obter informação");
        buttonSelecionaPessoa.addActionListener(new ButtonListener());
        buttonSelecionaPessoa.setBounds(400,310,150,25);

        buttonListaTarefas = new JButton("Listar Tarefas");
        buttonListaTarefas.addActionListener(new ButtonListener());
        buttonCriaTarefas = new JButton("Criar Tarefas");
        buttonCriaTarefas.addActionListener(new ButtonListener());
        buttonEliminaTarefas = new JButton("Eliminar Tarefas");
        buttonEliminaTarefas.addActionListener(new ButtonListener());
        buttonAtribuirTarefa = new JButton("Atribuir Tarefas");
        buttonAtribuirTarefa.addActionListener(new ButtonListener());
        buttonAtualizaTaxaEx = new JButton("Atualizar Taxa de Execucao de uma tarefa");
        buttonAtualizaTaxaEx.addActionListener(new ButtonListener());
        buttonListaTarefaNaoInicializadas = new JButton("Listar Tarefas nao inicializadas");
        buttonListaTarefaNaoInicializadas.addActionListener(new ButtonListener());
        buttonListaTarefaConcluida = new JButton("Listar Tarefas concluidas");
        buttonListaTarefaConcluida.addActionListener(new ButtonListener());
        buttonCustoProjeto = new JButton("Custo do projeto");
        buttonCustoProjeto.addActionListener(new ButtonListener());
        buttonVoltarListaProjeto = new JButton("Voltar para a lista de projetos");
        buttonVoltarListaProjeto.addActionListener(new ButtonListener());
        buttonVoltarConfigProjeto = new JButton("Voltar");
        buttonVoltarConfigProjeto.addActionListener(new ButtonListener());
        buttonVoltarConfigProjeto.setBounds(150,310,150,25);
        buttonCriarTar = new JButton("Criar");
        buttonCriarTar.addActionListener(new ButtonListener());


        buttonListarTodosProjetos = new JButton("Listar todos os projetos");
        buttonListarTodosProjetos.addActionListener(new ButtonListener());
        buttonListarProjetosConcluidos = new JButton(("Listar projetos concluidos"));
        buttonListarProjetosConcluidos.addActionListener(new ButtonListener());
        buttonListarProjetosNaoConcluidos = new JButton("Listar projetos nao concluidos");
        buttonListarProjetosNaoConcluidos.addActionListener(new ButtonListener());
        buttonVoltarListProj = new JButton("Voltar");
        buttonVoltarListProj.addActionListener(new ButtonListener());
        buttonVoltarListProj.setBounds(105,310,150,25);
        buttonSelectProjeto = new JButton("Selecionar projeto");
        buttonSelectProjeto.addActionListener(new ButtonListener());
        buttonSelectProjeto.setBounds(305,310,150,25);
        buttonAssociar = new JButton("Associar");
        buttonAssociar.addActionListener(new ButtonListener());
        buttonAtualizar = new JButton("Atualizar");
        buttonAtualizar.addActionListener(new ButtonListener());
        buttonElimina = new JButton("Eliminar");
        buttonElimina.addActionListener(new ButtonListener());
        buttonTerminar = new JButton("Terminar");
        buttonTerminar.addActionListener(new ButtonListener());
        buttonAtribuir = new JButton("Atribuir");
        buttonAtribuir.addActionListener(new ButtonListener());
        buttonListaPessoasProjeto = new JButton("Lista de pessoas do projeto");
        buttonListaPessoasProjeto.addActionListener(new ButtonListener());



        String[] types = {"Pessoas","Docentes","Licenciados","Mestres","Doutorados"};
        comboPessoas = new JComboBox(types);
        comboPessoas.addActionListener(new ButtonListener());
        comboPessoas.setBounds(50,310,150,25);
        String[] types1 = {"Todas","Nao iniciadas","Nao concluidas","Concluidas"};
        comboTarefas = new JComboBox(types1);
        comboTarefas.addActionListener(new ButtonListener());
        comboTarefas.setBounds(50,310,150,25);


        projScroll = new JScrollPane(listaProj);
        projScroll.setBounds(225, 40, 150, 250);
        projConcScroll = new JScrollPane(listaConc);
        projConcScroll.setBounds(225, 40, 150, 250);
        projNotConcScroll = new JScrollPane(listaNotConc);
        projNotConcScroll.setBounds(225, 40, 150, 250);
        pessScroll = new JScrollPane(listaPess);
        pessScroll.setBounds(50, 40, 150, 250);
        docentesScroll = new JScrollPane(listaDocentes);
        docentesScroll.setBounds(50, 40, 150, 250);
        licenciadosScroll = new JScrollPane(listaLicenciados);
        licenciadosScroll.setBounds(50, 40, 150, 250);
        doutoradosScroll = new JScrollPane(listaDoutorados);
        doutoradosScroll.setBounds(50, 40, 150, 250);
        mestresScroll = new JScrollPane(listaMestres);
        mestresScroll.setBounds(50, 40, 150, 250);
        tarefasScroll = new JScrollPane(listaTar);
        tarefasScroll.setBounds(150,40,150,250);
        tarefasNCScroll = new JScrollPane(listaTarNC);
        tarefasNCScroll.setBounds(150,40,150,250);
        tarefasCScroll = new JScrollPane(listaTarC);
        tarefasCScroll.setBounds(150,40,150,250);
        tarefasNIniScroll = new JScrollPane(listaTarNIni);
        tarefasNIniScroll.setBounds(150,40,150,250);
        pessoasProjScroll = new JScrollPane(listaPessProj);
        pessoasProjScroll.setBounds(225,40,150,250);

        nomeProj = new JLabel("Nome do Projeto: ");
        nomeProj1 = new JTextField(20);
        acrProj = new JLabel("Acronimo do Projeto: ");
        acrProj1 = new JTextField(20);
        iniDate = new JLabel("Data inicio do Projeto (dd/mm/aaaa)");
        iniDate1 = new JTextField(20);
        durEst = new JLabel("Duracao estimada: ");
        durEst1 = new JTextField(20);
        ip = new JLabel("Investigador Principal (nº): ");
        ip1 = new JTextField(20);

        numMec = new JLabel("Numero mecanográfico: ");
        numMec.setBounds(230, 70, 150, 15);
        numMec1 = new JLabel("");
        numMec1.setBounds(375, 70, 150, 15);
        inicioBolsa = new JLabel("Inicio da bolsa: ");
        inicioBolsa.setBounds(230, 110,150,15);
        inicioBolsa1 = new JLabel("");
        inicioBolsa1.setBounds(320, 110,150,15);
        fimBolsa = new JLabel("Fim da bolsa: ");
        fimBolsa.setBounds(230, 150,150,15);
        fimBolsa1 = new JLabel("");
        fimBolsa1.setBounds(320, 150,150,15);
        mail = new JLabel("Endereço de e-mail: ");
        mail.setBounds(230, 190,150,15);
        mail1 = new JLabel("");
        mail1.setBounds(355, 190,250,15);
        disponibilidade = new JLabel("Disponibilidade: ");
        disponibilidade.setBounds(230, 230,150,15);
        disponibilidade1 = new JLabel("");
        disponibilidade1.setBounds(340, 230,150,15);

        nomeProjetoAssoc = new JLabel("Nome do projeto que pretende associar: ");
        nomeProjetoAssoc1 = new JTextField(20);
        nomePessoaAssoc = new JLabel("Nome da pessoa que pretende associar: ");
        nomePessoaAssoc1 = new JTextField(20);

        labelCriaTarefa = new JLabel("Nome da nova tarefa");
        textCriaTarefa = new JTextField(20);
        labelDesign = new JLabel("Tarefas: D1 - Design;      D2 - Desenvolvimento;");
        labelOutras = new JLabel("D3 - Documentacao");
        labelTipoTarefa = new JLabel("Tipo da tarefa:");
        textTipoTarefa = new JTextField(2);

        labelPessoaAtribuir = new JLabel("Nome da pessoa");
        textPessoaAtribuir = new JTextField(20);
        labelTarefaAtribuir = new JLabel("Tarefa a atribuir");
        textTarefaAtribuir = new JTextField(20);

        labelTarefaAtualizar = new JLabel("Tarefa a atualizar: ");
        textTarefaAtualizar = new JTextField(20);
        labelNovaPercentagem = new JLabel("Nova percentagem: ");
        textNovaPercentagem = new JTextField(3);

        labelNomeEliminar = new JLabel("Nome da tarefa a eliminar:");
        textNomeEliminar = new JTextField(20);

        textNomeTerminar = new JTextField(20);
        labelDE = new JLabel("Duracao estimada");
        textDE = new JTextField(10);

        panel.add(buttonListPess);
        panel.add(buttonCreateProj);
        panel.add(buttonListProj);
        panel.add(buttonAssocPess);
        this.add(panel);
        this.setTitle("CISUC");
        this.setSize(600, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    /**
     * Funcao responsavel pela substituicao de paineis, sendo 'a' o painel atual e 'b' o painel que queremos que passe a ser o atual
     * @param a
     * @param b
     */
    public void subsPaneis(JPanel a,JPanel b){
        a.setVisible(false);
        this.remove(a);
        this.add(b);
        b.setVisible(true);
    }

    /**
     * Classe que utiliza a implementação ActionListener de forma a criar metodos, que utilizem as suas funções
     */
    private class ButtonListener implements ActionListener {
        /**
         * Método que controla todas as ações dos botões
         * @param e
         */
        @Override
        public void actionPerformed(ActionEvent e) {

            //Menu -> Listar Pessoas
            if (e.getSource() == buttonListPess) {
                ArrayList<Pessoa> pessoas = cisuc.getPes();
                int i;
                for (i = 0; i < pessoas.size(); i++) listPess.addElement(pessoas.get(i));
                panelPessoas.setLayout(null);
                buttonVoltar.setBounds(225,310,150,25);
                panelPessoas.add(buttonVoltar);
                panelPessoas.add(buttonSelecionaPessoa);
                buttonSelecionaPessoa.setVisible(false);
                panelPessoas.add(pessScroll);
                panelPessoas.add(comboPessoas);
                panelPessoas.add(disponibilidade1);
                disponibilidade1.setVisible(false);
                panelPessoas.add(inicioBolsa1);
                inicioBolsa1.setVisible(false);
                panelPessoas.add(fimBolsa1);
                fimBolsa1.setVisible(false);
                panelPessoas.add(mail1);
                mail1.setVisible(false);
                panelPessoas.add(numMec1);
                numMec1.setVisible(false);
                panelPessoas.add(disponibilidade);
                disponibilidade.setVisible(false);
                panelPessoas.add(inicioBolsa);
                inicioBolsa.setVisible(false);
                panelPessoas.add(fimBolsa);
                fimBolsa.setVisible(false);
                panelPessoas.add(mail);
                mail.setVisible(false);
                panelPessoas.add(numMec);
                numMec.setVisible(false);
                subsPaneis(panel,panelPessoas);
            }

            //Combo pessoas docentes doutorados mestres licenciados
            else if(e.getSource() == comboPessoas){
                ArrayList<Pessoa> pessoas = cisuc.getPes();
                if("Pessoas".equals(comboPessoas.getSelectedItem())){
                    panelPessoas.add(pessScroll);
                    inicioBolsa1.setText("");
                    fimBolsa1.setText("");
                    mail1.setText("");
                    numMec1.setText("");
                    disponibilidade1.setText("");
                    int i;
                    for (i = 0; i < pessoas.size(); i++) listPess.addElement(pessoas.get(i));
                    buttonSelecionaPessoa.setVisible(false);
                    licenciadosScroll.setVisible(false);
                    doutoradosScroll.setVisible(false);
                    mestresScroll.setVisible(false);
                    docentesScroll.setVisible(false);
                    numMec.setVisible(false);
                    numMec1.setVisible(false);
                    inicioBolsa.setVisible(false);
                    inicioBolsa1.setVisible(false);
                    fimBolsa.setVisible(false);
                    fimBolsa1.setVisible(false);
                    mail.setVisible(false);
                    mail1.setVisible(false);
                    disponibilidade.setVisible(false);
                    disponibilidade1.setVisible(false);
                    pessScroll.setVisible(true);
                }
                else if("Docentes".equals(comboPessoas.getSelectedItem())){
                    panelPessoas.add(docentesScroll);
                    inicioBolsa1.setText("");
                    fimBolsa1.setText("");
                    mail1.setText("");
                    numMec1.setText("");
                    disponibilidade1.setText("");
                    int i;
                    for (i = 0; i < pessoas.size(); i++) if(pessoas.get(i).custo()==0) listDoc.addElement(pessoas.get(i));
                    buttonSelecionaPessoa.setVisible(true);
                    pessScroll.setVisible(false);
                    licenciadosScroll.setVisible(false);
                    doutoradosScroll.setVisible(false);
                    mestresScroll.setVisible(false);
                    docentesScroll.setVisible(true);
                    numMec.setVisible(true);
                    numMec1.setVisible(true);
                    inicioBolsa.setVisible(false);
                    inicioBolsa1.setVisible(false);
                    fimBolsa.setVisible(false);
                    fimBolsa1.setVisible(false);
                    mail.setVisible(true);
                    mail1.setVisible(true);
                    disponibilidade.setVisible(true);
                    disponibilidade1.setVisible(true);

                }
                else if("Licenciados".equals(comboPessoas.getSelectedItem())){
                    inicioBolsa1.setText("");
                    fimBolsa1.setText("");
                    mail1.setText("");
                    numMec1.setText("");
                    disponibilidade1.setText("");
                    panelPessoas.add(licenciadosScroll);
                    int i;
                    for (i = 0; i < pessoas.size(); i++) if(pessoas.get(i).custo()==800) listLic.addElement(pessoas.get(i));
                    buttonSelecionaPessoa.setVisible(true);
                    pessScroll.setVisible(false);
                    docentesScroll.setVisible(false);
                    doutoradosScroll.setVisible(false);
                    mestresScroll.setVisible(false);
                    licenciadosScroll.setVisible(true);
                    numMec.setVisible(false);
                    numMec1.setVisible(false);
                    inicioBolsa.setVisible(true);
                    inicioBolsa1.setVisible(true);
                    fimBolsa.setVisible(true);
                    fimBolsa1.setVisible(true);
                    mail.setVisible(true);
                    mail1.setVisible(true);
                    disponibilidade.setVisible(true);
                    disponibilidade1.setVisible(true);

                }
                else if("Mestres".equals(comboPessoas.getSelectedItem())){
                    inicioBolsa1.setText("");
                    fimBolsa1.setText("");
                    mail1.setText("");
                    numMec1.setText("");
                    disponibilidade1.setText("");
                    panelPessoas.add(mestresScroll);
                    int i;
                    for (i = 0; i < pessoas.size(); i++) if(pessoas.get(i).custo()==1000) listMest.addElement(pessoas.get(i));
                    buttonSelecionaPessoa.setVisible(true);
                    pessScroll.setVisible(false);
                    docentesScroll.setVisible(false);
                    licenciadosScroll.setVisible(false);
                    doutoradosScroll.setVisible(false);
                    mestresScroll.setVisible(true);
                    numMec.setVisible(false);
                    numMec1.setVisible(false);
                    inicioBolsa.setVisible(true);
                    inicioBolsa1.setVisible(true);
                    fimBolsa.setVisible(true);
                    fimBolsa1.setVisible(true);
                    mail.setVisible(true);
                    mail1.setVisible(true);
                    disponibilidade.setVisible(true);
                    disponibilidade1.setVisible(true);

                }

                else if("Doutorados".equals(comboPessoas.getSelectedItem())){
                    panelPessoas.add(doutoradosScroll);
                    inicioBolsa1.setText("");
                    fimBolsa1.setText("");
                    mail1.setText("");
                    numMec1.setText("");
                    disponibilidade1.setText("");
                    int i;
                    for (i = 0; i < pessoas.size(); i++) if(pessoas.get(i).custo()==1200) listDout.addElement(pessoas.get(i));
                    buttonSelecionaPessoa.setVisible(true);
                    pessScroll.setVisible(false);
                    docentesScroll.setVisible(false);
                    licenciadosScroll.setVisible(false);
                    mestresScroll.setVisible(false);
                    doutoradosScroll.setVisible(true);
                    numMec.setVisible(false);
                    numMec1.setVisible(false);
                    inicioBolsa.setVisible(true);
                    inicioBolsa1.setVisible(true);
                    fimBolsa.setVisible(true);
                    fimBolsa1.setVisible(true);
                    mail.setVisible(true);
                    mail1.setVisible(true);
                    disponibilidade.setVisible(true);
                    disponibilidade1.setVisible(true);

                }

            }

            //Obtem informaçao da pessoa selecionada
            else if(e.getSource() == buttonSelecionaPessoa){

                if(listaDocentes.getSelectedValue() != null || listaLicenciados.getSelectedValue() != null || listaDoutorados.getSelectedValue() != null || listaMestres.getSelectedValue() != null){
                    inicioBolsa1.setText("");
                    fimBolsa1.setText("");
                    mail1.setText("");
                    numMec1.setText("");
                    disponibilidade1.setText("");

                    if("Docentes".equals(comboPessoas.getSelectedItem()) && listaDocentes.getSelectedValue() != null){
                        dList=(Docente)listaDocentes.getSelectedValue();
                        numMec1.setText(String.valueOf(dList.getNumMecanografico()));
                        mail1.setText(dList.getMail());
                        disponibilidade1.setText(String.valueOf(dList.getDisp()));
                    }

                    else if("Licenciados".equals(comboPessoas.getSelectedItem()) && listaLicenciados.getSelectedValue() != null){
                        lList=(Licenciados)listaLicenciados.getSelectedValue();
                        mail1.setText(lList.getMail());
                        inicioBolsa1.setText(lList.dataInicio.getDia()+"/"+lList.dataInicio.getMes()+"/"+lList.dataInicio.getAno());
                        fimBolsa1.setText(lList.dataFim.getDia()+"/"+lList.dataFim.getMes()+"/"+lList.dataFim.getAno());
                        disponibilidade1.setText(String.valueOf(lList.getDisp()));
                    }

                    else if("Mestres".equals(comboPessoas.getSelectedItem()) && listaMestres.getSelectedValue() != null){
                        mList=(Mestres)listaMestres.getSelectedValue();
                        mail1.setText(mList.getMail());
                        inicioBolsa1.setText(mList.dataInicio.getDia()+"/"+mList.dataInicio.getMes()+"/"+mList.dataInicio.getAno());
                        fimBolsa1.setText(mList.dataFim.getDia()+"/"+mList.dataFim.getMes()+"/"+mList.dataFim.getAno());
                        disponibilidade1.setText(String.valueOf(mList.getDisp()));
                    }

                    else if("Doutorados".equals(comboPessoas.getSelectedItem()) && listaDoutorados.getSelectedValue() != null){
                        doList=(Doutorados)listaDoutorados.getSelectedValue();
                        mail1.setText(doList.getMail());
                        inicioBolsa1.setText(doList.dataInicio.getDia() +"/"+ doList.dataInicio.getMes() +"/"+doList.dataInicio.getAno());
                        fimBolsa1.setText(doList.dataFim.getDia()+"/"+ doList.dataFim.getMes() +"/"+doList.dataFim.getAno());
                        disponibilidade1.setText(String.valueOf(doList.getDisp()));
                    }

                }
            }

            //Listar Projetos
            else if (e.getSource() == buttonListProj) {

                panelProjetos.setLayout(new GridLayout(4,1));
                panelProjetos.add(buttonListarTodosProjetos);
                panelProjetos.add(buttonListarProjetosConcluidos);
                panelProjetos.add(buttonListarProjetosNaoConcluidos);
                panelProjetos.add(buttonVoltar);
                subsPaneis(panel,panelProjetos);

            }

            //Lita todos os projetos
            else if(e.getSource() == buttonListarTodosProjetos){
                ArrayList<Projeto> projetos = cisuc.getProjs();
                int i;
                for (i = 0; i < projetos.size(); i++) listProjs.addElement(projetos.get(i));
                panelTodosProjetos.setLayout(null);
                panelTodosProjetos.add(projScroll);
                panelTodosProjetos.add(buttonVoltarListProj);
                panelTodosProjetos.add(buttonSelectProjeto);
                subsPaneis(panelProjetos,panelTodosProjetos);
            }

            //Lista projetos concluidos
            else if(e.getSource() == buttonListarProjetosConcluidos){
                int i;
                ArrayList<Projeto> projsConc= cisuc.listarProjsConc();
                for(i=0; i<projsConc.size();i++) listConc.addElement(projsConc.get(i));
                panelProjetosConcluidos.setLayout(null);
                panelProjetosConcluidos.add(projConcScroll);
                panelProjetosConcluidos.add(buttonVoltarListProj);
                panelProjetosConcluidos.add(buttonSelectProjeto);
                subsPaneis(panelProjetos,panelProjetosConcluidos);

            }

            //Lista projetos não concluidos
            else if(e.getSource() == buttonListarProjetosNaoConcluidos){
                int i;
                ArrayList<Projeto> projsNaoConc= cisuc.listarProjsNaoConc();
                for(i=0; i<projsNaoConc.size();i++) {
                    listNotConc.addElement(projsNaoConc.get(i));
                }
                panelProjetosNaoConcluidos.setLayout(null);
                panelProjetosNaoConcluidos.add(projNotConcScroll);
                panelProjetosNaoConcluidos.add(buttonVoltarListProj);
                panelProjetosNaoConcluidos.add(buttonSelectProjeto);
                subsPaneis(panelProjetos,panelProjetosNaoConcluidos);
            }

            //Lista dos projetos -> Menu Listar Projetos
            else if(e.getSource() == buttonVoltarListProj){
                subsPaneis(panelTodosProjetos,panelProjetos);
                subsPaneis(panelProjetosConcluidos,panelProjetos);
                subsPaneis(panelProjetosNaoConcluidos,panelProjetos);
                listProjs.clear();
                listConc.clear();
                listNotConc.clear();
            }

            //Voltar para o menu
            else if(e.getSource() == buttonVoltar){
                subsPaneis(panelProjetos,panel);
                subsPaneis(panelPessoas,panel);
                subsPaneis(panelCreateProj,panel);
                subsPaneis(panelAssocPess,panel);
                listPess.clear();
                listDout.clear();
                listLic.clear();
                listMest.clear();
                listDoc.clear();
                durEst1.setText("");
                nomeProj1.setText("");
                acrProj1.setText("");
                iniDate1.setText("");
                ip1.setText("");
                nomePessoaAssoc1.setText("");
                nomeProjetoAssoc1.setText("");
            }

            //Menu Criar projeto
            else if(e.getSource() == buttonCreateProj){

                panelCreateProj.setLayout(new GridLayout(6,2));
                panelCreateProj.add(nomeProj);
                panelCreateProj.add(nomeProj1);
                panelCreateProj.add(acrProj);
                panelCreateProj.add(acrProj1);
                panelCreateProj.add(iniDate);
                panelCreateProj.add(iniDate1);
                panelCreateProj.add(durEst);
                panelCreateProj.add(durEst1);
                panelCreateProj.add(ip);
                panelCreateProj.add(ip1);
                panelCreateProj.add(buttonVoltar);
                panelCreateProj.add(buttonCriar);
                subsPaneis(panel,panelCreateProj);


            }

            //criar projeto
            else if(e.getSource() == buttonCriar){
                ArrayList<Projeto> projetos = cisuc.getProjs();
                ArrayList<Pessoa> pessoas = cisuc.getPes();
                String nomeProjeto =nomeProj1.getText();
                int check=0;
                int durEst = 0;
                if(nomeProjeto.equals("")){
                    JOptionPane.showMessageDialog(null, "O campo 'Nome do Projeto' esta vazio","Erro",JOptionPane.ERROR_MESSAGE);
                    check = 1;
                }
                String acronimo =acrProj1.getText();
                if(acronimo.equals("")){
                    JOptionPane.showMessageDialog(null, "O campo 'Acronimo' esta vazio","Erro",JOptionPane.ERROR_MESSAGE);
                    check = 1;
                }
                String pattern="([0-9]{2})/([0-9]{2})/([0-9]{4})";
                Pattern r= Pattern.compile(pattern);
                String dataInicial = iniDate1.getText();
                Matcher m=r.matcher(dataInicial);
                Data dataI=new Data();
                if(dataInicial.equals("")){
                    JOptionPane.showMessageDialog(null, "O campo 'Data inicial' esta vazio","Erro",JOptionPane.ERROR_MESSAGE);
                    check = 1;
                }
                else if(m.find()){
                    String[] divDI=dataInicial.split("/");
                    dataI.setDia(Integer.parseInt(divDI[0]));
                    dataI.setMes(Integer.parseInt(divDI[1]));
                    dataI.setAno(Integer.parseInt(divDI[2]));
                    if (dataI.getAno()< LocalDate.now().getYear()) {
                        check=1;
                        JOptionPane.showMessageDialog(null, "Ano invalido,tem que ser maior que o ano atual","Erro",JOptionPane.ERROR_MESSAGE);
                        iniDate1.setText("");
                    }
                    if (dataI.getMes() < 1 || dataI.getMes() > 12) {
                        JOptionPane.showMessageDialog(null, "Mes invalido, nao existe esse numero de mes","Erro",JOptionPane.ERROR_MESSAGE);
                        iniDate1.setText("");
                        check=1;
                    }
                    if(dataI.getAno()==LocalDate.now().getYear()) {
                        if (dataI.getMes()< LocalDate.now().getMonthValue()) {
                            check=1;
                            JOptionPane.showMessageDialog(null, "Mes tem que ser maior que o atual,caso seja estejamos no ultimo mes deste ano, tem que ser igual","Erro",JOptionPane.ERROR_MESSAGE);
                            iniDate1.setText("");
                        }
                    }
                    switch (dataI.getMes()) {
                        case 1:
                        case 3:
                        case 5:
                        case 7:
                        case 8:
                        case 10:
                        case 12:
                            if (dataI.getMes() < 1|| dataI.getMes() > 31) {
                                JOptionPane.showMessageDialog(null, "Dia invalido","Erro",JOptionPane.ERROR_MESSAGE);
                                iniDate1.setText("");
                                check =1;
                            }
                            if (dataI.getMes()==LocalDate.now().getYear() && dataI.getMes()==LocalDate.now().getMonthValue()) {
                                if (dataI.getMes() < LocalDate.now().getDayOfMonth() || dataI.getMes() > 31) {
                                    check=1;
                                    JOptionPane.showMessageDialog(null, "Dia invalido, tem que ser maior que o atual","Erro",JOptionPane.ERROR_MESSAGE);
                                    iniDate1.setText("");
                                }
                            }
                        case 2:
                            if (dataI.getMes() < 1|| dataI.getMes() > 28) {
                                JOptionPane.showMessageDialog(null, "Dia invalido","Erro",JOptionPane.ERROR_MESSAGE);iniDate1.setText("");
                                check =1;
                            }
                            if(dataI.getAno()==LocalDate.now().getYear() && dataI.getMes()==LocalDate.now().getMonthValue()) {
                                if (dataI.getDia() < LocalDate.now().getDayOfMonth() || dataI.getDia() > 28) {
                                    check=1;
                                    JOptionPane.showMessageDialog(null, "Dia invalido, tem que ser maior que o atual","Erro",JOptionPane.ERROR_MESSAGE);
                                    iniDate1.setText("");
                                }
                            }
                        case 4:
                        case 6:
                        case 9:
                        case 11:
                            if (dataI.getDia() < 1|| dataI.getDia() > 30) {
                                JOptionPane.showMessageDialog(null, "Dia invalido","Erro",JOptionPane.ERROR_MESSAGE);
                                iniDate1.setText("");
                                check =1;
                            }
                            if(dataI.getAno()==LocalDate.now().getYear() && dataI.getMes()==LocalDate.now().getMonthValue()) {
                                if (dataI.getDia() < LocalDate.now().getDayOfMonth() || dataI.getDia() > 28) {
                                    check=1;
                                    JOptionPane.showMessageDialog(null, "Dia invalido, tem que ser maior que o atual","Erro",JOptionPane.ERROR_MESSAGE);
                                    iniDate1.setText("");
                                }
                            }

                    }
                }else {
                    JOptionPane.showMessageDialog(null, "O campo data de inicio tem de ser do tipo dd/mm/aaaa", "Erro", JOptionPane.ERROR_MESSAGE);
                    iniDate1.setText("");
                    check = 1;
                }

                if(durEst1.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "O campo 'Duracao estimada' esta vazio","Erro",JOptionPane.ERROR_MESSAGE);
                    check = 1;
                }
                try {
                    durEst = Integer.parseInt(durEst1.getText());
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "O campo duracao estimada tem que ser números","Erro",JOptionPane.ERROR_MESSAGE);
                    durEst1.setText("");
                    check = 1;
                }
                int investigadorPrincipal=0;
                if(ip1.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "O campo inevstigador principal esta vazio","Erro",JOptionPane.ERROR_MESSAGE);
                    ip1.setText("");
                    check = 1;
                }
                try{
                    investigadorPrincipal = Integer.parseInt(ip1.getText());
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "O campo Investigador Principal tem que ser um número","Erro",JOptionPane.ERROR_MESSAGE);
                    ip1.setText("");
                    check = 1;
                }
                int i;
                Docente d = null;
                int ipcheck=0;
                for(i=0;i<pessoas.size();i++){
                    ipcheck=1;
                    if(pessoas.get(i).getClass()==Docente.class){
                        d=(Docente)pessoas.get(i);
                        if(investigadorPrincipal==d.getNumMecanografico()) {
                            ipcheck=0;
                            break;
                        }
                    }
                }
                if(ipcheck==1) {
                    JOptionPane.showMessageDialog(null, "Investigador principal nao existe","Erro",JOptionPane.ERROR_MESSAGE);
                    ip1.setText("");
                }
                if(check != 1 && ipcheck != 1) {
                    Data dataF=new Data();
                    Projeto p=new Projeto(nomeProjeto,acronimo,durEst,dataI,dataF,0,false);
                    p.setIP(d);
                    projetos.add(p);
                    cisuc.setProjs(projetos);
                    cisuc.writeFichObjProj();
                    JOptionPane.showMessageDialog(null, "Projeto criado com sucesso!", "Projeto", JOptionPane.PLAIN_MESSAGE);
                    nomeProj1.setText("");
                    acrProj1.setText("");
                    iniDate1.setText("");
                    durEst1.setText("");
                    ip1.setText("");
                }
            }

            //Menu Associar pessoa a um projeto
            else if(e.getSource() == buttonAssocPess){
                panelAssocPess.setLayout(new GridLayout(3,2));
                panelAssocPess.add(nomeProjetoAssoc);
                panelAssocPess.add(nomeProjetoAssoc1);
                panelAssocPess.add(nomePessoaAssoc);
                panelAssocPess.add(nomePessoaAssoc1);
                panelAssocPess.add(buttonVoltar);
                panelAssocPess.add(buttonAssociar);
                subsPaneis(panel, panelAssocPess);
            }

            //Associar pessoa a um projeto
            else if(e.getSource() == buttonAssociar){
                String nomeProjeto = nomeProjetoAssoc1.getText();
                int check=0;
                if(nomeProjeto.equals("")){
                    JOptionPane.showMessageDialog(null, "O campo 'Nome do projeto que pretende associar' esta vazio","Erro",JOptionPane.ERROR_MESSAGE);
                    check = 1;
                }
                String nomePessoa = nomePessoaAssoc1.getText();
                if(nomePessoa.equals("")){
                    JOptionPane.showMessageDialog(null, "O campo 'Nome da pessoa que pretende associar' esta vazio","Erro",JOptionPane.ERROR_MESSAGE);
                    check = 1;
                }
                int i;
                Projeto p=null;
                for(i=0;i<cisuc.getProjs().size();i++){
                    if(cisuc.getProjs().get(i).getNome().equals(nomeProjeto)) {
                        p=cisuc.getProjs().get(i);
                        break;
                    }
                }
                if(p==null){
                    JOptionPane.showMessageDialog(null, "Nome de projeto nao existe","Erro",JOptionPane.ERROR_MESSAGE);
                    nomeProjetoAssoc1.setText("");
                    check = 1;
                }
                Pessoa pes=null;
                for(i=0;i<cisuc.getPes().size();i++){
                    if(cisuc.getPes().get(i).getNome().equals(nomePessoa)) {
                        pes=cisuc.getPes().get(i);
                        break;
                    }
                }
                if(pes==null){
                    JOptionPane.showMessageDialog(null, "Nome de pessoa nao existe","Erro",JOptionPane.ERROR_MESSAGE);
                    nomePessoaAssoc1.setText("");
                    check = 1;
                }
                else {
                    if (pes.getClass() == Bolseiros.class) {
                        Bolseiros b = (Bolseiros) pes;
                        if (!b.verContrato()) {
                            check = 1;
                            JOptionPane.showMessageDialog(null, "O nome da pessoa corresponde a um bolseiro com o contrato expirado", "Erro", JOptionPane.ERROR_MESSAGE);
                        } else if (!b.valBol()) {
                            check = 1;
                            JOptionPane.showMessageDialog(null, "O nome da pessoa corresponde a um bolseiro que ainda nao tem o contrato efetivo", "Erro", JOptionPane.ERROR_MESSAGE);
                        } else {
                            for (i = 0; i < cisuc.getProjs().size(); i++) {
                                int k;
                                for (k = 0; k < cisuc.getProjs().get(i).getBolseiros().size(); k++) {
                                    if (cisuc.getProjs().get(i).getBolseiros().get(k).getNome().equals(nomePessoa)) {
                                        check = 1;
                                        JOptionPane.showMessageDialog(null, "O nome da pessoa corresponde a um bolseiro que ja esta associado a um projeto, e sendo bolseiro so e possivel ser associado a um projeto", "Erro", JOptionPane.ERROR_MESSAGE);
                                        break;
                                    }
                                    if (check == 1) break;
                                }
                            }
                        }
                    }
                }
                if(check != 1) {
                    if (pes.getClass() == Bolseiros.class) {
                        Bolseiros b=(Bolseiros) pes;
                        p.getBolseiros().add(b);
                        p.atualCusto(b.custo());
                    }
                    else p.getDocentes().add((Docente) pes);
                    JOptionPane.showMessageDialog(null, "Pessoa associada com sucesso!", "Projeto", JOptionPane.PLAIN_MESSAGE);
                    nomePessoaAssoc1.setText("");
                    nomeProjetoAssoc1.setText("");
                    cisuc.writeFichObjProj();
                }
            }

            //Config projeto
            else if(e.getSource() == buttonSelectProjeto){
                if(listaProj.getSelectedValue() != null || listaConc.getSelectedValue() != null || listaNotConc.getSelectedValue() != null && !listaProj.getSelectedValue().isEstado()) {
                    pList=listaProj.getSelectedValue();
                    panelConfigProjeto.setLayout(new GridLayout(9, 1));
                    panelConfigProjeto.add(buttonListaPessoasProjeto);
                    panelConfigProjeto.add(buttonListaTarefas);
                    panelConfigProjeto.add(buttonCriaTarefas);
                    panelConfigProjeto.add(buttonEliminaTarefas);
                    panelConfigProjeto.add(buttonAtribuirTarefa);
                    panelConfigProjeto.add(buttonAtualizaTaxaEx);
                    panelConfigProjeto.add(buttonCustoProjeto);
                    panelConfigProjeto.add(buttonTerminar);
                    panelConfigProjeto.add(buttonVoltarListaProjeto);
                    subsPaneis(panelTodosProjetos, panelConfigProjeto);
                    subsPaneis(panelProjetosConcluidos, panelConfigProjeto);
                    subsPaneis(panelProjetosNaoConcluidos, panelConfigProjeto);
                }else if(listaProj.getSelectedValue() != null || listaConc.getSelectedValue() != null || listaNotConc.getSelectedValue() != null){
                    JOptionPane.showMessageDialog(null, "Nenhum projeto selecionado","Erro",JOptionPane.ERROR_MESSAGE);
                }else if(!listaProj.getSelectedValue().isEstado()){
                    JOptionPane.showMessageDialog(null, "Projeto ja esta concluido","Erro",JOptionPane.ERROR_MESSAGE);
                }
            }

            //Configuração do projeto -> menu dos projetos
            else if(e.getSource() == buttonVoltarListaProjeto){
                subsPaneis(panelConfigProjeto,panelProjetos);
                listProjs.clear();
                listConc.clear();
                listNotConc.clear();
            }

            //Lista as tarefas do projeto
            else if(e.getSource() == buttonListaTarefas){
                ArrayList<Tarefa> tarefas = pList.getTarefas();
                int i;
                for (i = 0; i < tarefas.size(); i++) listTar.addElement(tarefas.get(i));
                panelListaTarefas.setLayout(null);
                panelListaTarefas.add(tarefasScroll);
                buttonVoltarConfigProjeto.setBounds(225,310,150,25);
                panelListaTarefas.add(buttonVoltarConfigProjeto);
                panelListaTarefas.add(comboTarefas);
                subsPaneis(panelConfigProjeto, panelListaTarefas);
            }

            //Combo tarefas concluidas nao concluidas todas nao iniciadas
            else if(e.getSource() == comboTarefas){
                listTar.clear();
                if("Todas".equals(comboTarefas.getSelectedItem())){
                    ArrayList<Tarefa> tarefas = pList.getTarefas();
                    int i;
                    for (i = 0; i < tarefas.size(); i++) listTar.addElement(tarefas.get(i));
                    panelListaTarefas.add(tarefasScroll);
                    tarefasNCScroll.setVisible(false);
                    tarefasCScroll.setVisible(false);
                    tarefasNIniScroll.setVisible(false);
                    tarefasScroll.setVisible(true);
                }
                else if("Nao concluidas".equals(comboTarefas.getSelectedItem())){
                    ArrayList<Tarefa> tarefas = pList.listarTarNaoConc();
                    listTar.clear();
                    int i;
                    for (i = 0; i < tarefas.size(); i++) listTar.addElement(tarefas.get(i));
                    panelListaTarefas.add(tarefasNCScroll);
                    tarefasCScroll.setVisible(false);
                    tarefasNIniScroll.setVisible(false);
                    tarefasScroll.setVisible(false);
                    tarefasNCScroll.setVisible(true);

                }
                else if("Concluidas".equals(comboTarefas.getSelectedItem())){
                    ArrayList<Tarefa> tarefas = pList.listarTarConc();
                    listTar.clear();
                    int i;
                    for (i = 0; i < tarefas.size(); i++) listTar.addElement(tarefas.get(i));
                    panelListaTarefas.add(tarefasCScroll);
                    tarefasNCScroll.setVisible(false);
                    tarefasNIniScroll.setVisible(false);
                    tarefasScroll.setVisible(false);
                    tarefasCScroll.setVisible(true);

                }
                else if("Nao iniciadas".equals(comboTarefas.getSelectedItem())){
                    ArrayList<Tarefa> tarefas = pList.listarTarNaoIni();
                    listTar.clear();
                    int i;
                    for (i = 0; i < tarefas.size(); i++) listTar.addElement(tarefas.get(i));
                    panelListaTarefas.add(tarefasNIniScroll);
                    tarefasNCScroll.setVisible(false);
                    tarefasCScroll.setVisible(false);
                    tarefasScroll.setVisible(false);
                    tarefasNIniScroll.setVisible(true);

                }

            }

            //Menu Criar Tarefas
            else if(e.getSource() == buttonCriaTarefas){
                panelCriaTarefas.setLayout(new GridLayout(5,2));
                panelCriaTarefas.add(labelCriaTarefa);
                panelCriaTarefas.add(textCriaTarefa);
                panelCriaTarefas.add(labelDesign);
                panelCriaTarefas.add(labelOutras);
                panelCriaTarefas.add(labelTipoTarefa);
                panelCriaTarefas.add(textTipoTarefa);
                panelCriaTarefas.add(labelDE);
                panelCriaTarefas.add(textDE);
                panelCriaTarefas.add(buttonVoltarConfigProjeto);
                panelCriaTarefas.add(buttonCriarTar);
                subsPaneis(panelConfigProjeto, panelCriaTarefas);
            }

            //Criar Tarefas
            else if(e.getSource() == buttonCriarTar){
                String nomeTarefa = textCriaTarefa.getText();
                int check=0;
                if(nomeTarefa.equals("")){
                    JOptionPane.showMessageDialog(null, "O campo 'Nome do projeto que pretende associar' esta vazio","Erro",JOptionPane.ERROR_MESSAGE);
                    check = 1;
                }
                String tipoTarefa = textTipoTarefa.getText();
                if(tipoTarefa.equals("")){
                    JOptionPane.showMessageDialog(null, "O campo 'Nome da pessoa que pretende associar' esta vazio","Erro",JOptionPane.ERROR_MESSAGE);
                    check = 1;
                }
                int dEst=0;
                try{
                    dEst=Integer.parseInt(textDE.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "A duracao estimada tem que ser em numeros","Erro",JOptionPane.ERROR_MESSAGE);
                    durEst1.setText("");
                    check = 1;
                }
                if(!tipoTarefa.equals("D1") && !tipoTarefa.equals("D2") && !tipoTarefa.equals("D3")){
                    JOptionPane.showMessageDialog(null, "O tipo de tarefa nao foi encontrada","Erro",JOptionPane.ERROR_MESSAGE);
                    textTipoTarefa.setText("");
                    check = 1;
                }
                if(check!=1) {
                    Data datai=new Data(LocalDate.now().getDayOfMonth(),LocalDate.now().getMonthValue(),LocalDate.now().getYear());
                    Data dataF=new Data();
                    if(tipoTarefa.equals("D1")){
                        Design d=new Design(datai,dataF,0,dEst,nomeTarefa);
                        pList.assocTar(d);
                    }
                    if(tipoTarefa.equals("D2")){
                        Desenvolvimento d=new Desenvolvimento(datai,dataF,0,dEst,nomeTarefa);
                        pList.assocTar(d);
                    }
                    if(tipoTarefa.equals("D3")){
                        Documentacao d=new Documentacao(datai,dataF,0,dEst,nomeTarefa);
                        pList.assocTar(d);
                    }
                    JOptionPane.showMessageDialog(null, "Tarefa criada com sucesso!", "Projeto", JOptionPane.PLAIN_MESSAGE);
                    textTipoTarefa.setText("");
                    durEst1.setText("");
                    textCriaTarefa.setText("");
                    textDE.setText("");
                    cisuc.writeFichObjProj();
                }
            }

            //Voltar para -> Config Projeto
            else if(e.getSource() == buttonVoltarConfigProjeto){
                panelConfigProjeto.add(buttonListaTarefas);
                panelConfigProjeto.add(buttonCriaTarefas);
                panelConfigProjeto.add(buttonEliminaTarefas);
                panelConfigProjeto.add(buttonAtribuirTarefa);
                panelConfigProjeto.add(buttonAtualizaTaxaEx);
                panelConfigProjeto.add(buttonCustoProjeto);
                panelConfigProjeto.add(buttonTerminar);
                panelConfigProjeto.add(buttonVoltarListaProjeto);
                listTar.clear();
                listTarC.clear();
                listTarNC.clear();
                listTarNIni.clear();
                listPessProj.clear();
                subsPaneis(panelTodosProjetos, panelConfigProjeto);
                subsPaneis(panelProjetosConcluidos, panelConfigProjeto);
                subsPaneis(panelProjetosNaoConcluidos, panelConfigProjeto);
                subsPaneis(panelCriaTarefas,panelConfigProjeto);
                subsPaneis(panelListaTarefas,panelConfigProjeto);
                subsPaneis(panelAtribuiTarefa,panelConfigProjeto);
                subsPaneis(panelAtualizaTaxaEx,panelConfigProjeto);
                subsPaneis(panelEliminaTarefas,panelConfigProjeto);
                subsPaneis(panelListaPessProj,panelConfigProjeto);
            }

            //Menu Eliminar Tarefas
            else if (e.getSource() == buttonEliminaTarefas){
                panelEliminaTarefas.setLayout(new GridLayout(2,2));
                panelEliminaTarefas.add(labelNomeEliminar);
                panelEliminaTarefas.add(textNomeEliminar);
                panelEliminaTarefas.add(buttonVoltarConfigProjeto);
                panelEliminaTarefas.add(buttonElimina);
                subsPaneis(panelConfigProjeto, panelEliminaTarefas);

            }

            //Eliminar Tarefas
            else if(e.getSource() == buttonElimina){
                String nomeEliminar = textNomeEliminar.getText();
                int check=0;
                ArrayList<Tarefa> tarefas=pList.getTarefas();
                if(textNomeEliminar.equals("")){
                    JOptionPane.showMessageDialog(null, "O campo 'Nome do projeto que pretende associar' esta vazio","Erro",JOptionPane.ERROR_MESSAGE);
                    check = 1;
                }
                int i;
                Tarefa t=null;
                for(i=0;i<tarefas.size();i++){
                    check=1;
                    t=tarefas.get(i);
                    if(tarefas.get(i).getNome().equals(nomeEliminar)){
                        check=0;
                        break;
                    }
                }
                if(check==1){
                    JOptionPane.showMessageDialog(null, "O nome da tarefa nao corresponde a nenhuma tarefa pertencente ao projeto que selecionou","Erro",JOptionPane.ERROR_MESSAGE);
                    textNomeEliminar.setText("");
                }else{
                    pList.eliminaTar(t);
                    cisuc.writeFichObjProj();
                    JOptionPane.showMessageDialog(null, "Tarefa eliminada com sucesso!", "Projeto", JOptionPane.PLAIN_MESSAGE);
                    textNomeEliminar.setText("");
                }
            }

            //Menu Atribui Tarefas
            else if(e.getSource() == buttonAtribuirTarefa){
                panelAtribuiTarefa.setLayout(new GridLayout(3,2));
                panelAtribuiTarefa.add(labelPessoaAtribuir);
                panelAtribuiTarefa.add(textPessoaAtribuir);
                panelAtribuiTarefa.add(labelTarefaAtribuir);
                panelAtribuiTarefa.add(textTarefaAtribuir);
                panelAtribuiTarefa.add(buttonVoltarConfigProjeto);
                panelAtribuiTarefa.add(buttonAtribuir);
                subsPaneis(panelConfigProjeto, panelAtribuiTarefa);

            }

            //Atribui Tarefas
            else if(e.getSource() == buttonAtribuir){
                String nomePessoa = textPessoaAtribuir.getText();
                int check=0;
                if(nomePessoa.equals("")){
                    JOptionPane.showMessageDialog(null, "O campo 'Nome do projeto que pretende associar' esta vazio","Erro",JOptionPane.ERROR_MESSAGE);
                    check = 1;
                }
                String nomeTarefa = textTarefaAtribuir.getText();
                if(nomeTarefa.equals("")){
                    JOptionPane.showMessageDialog(null, "O campo 'Nome da pessoa que pretende associar' esta vazio","Erro",JOptionPane.ERROR_MESSAGE);
                    check = 1;
                }
                int i;
                Docente d=null;
                for(i=0;i<pList.getDocentes().size();i++){
                    if(pList.getDocentes().get(i).getNome().equals(nomePessoa)) {
                        d=pList.getDocentes().get(i);
                        break;
                    }
                }
                Bolseiros b=null;
                for(i=0;i<pList.getBolseiros().size();i++){
                    if(pList.getBolseiros().get(i).getNome().equals(nomePessoa)) {
                        b=pList.getBolseiros().get(i);
                        break;
                    }
                }
                Pessoa pes=null;
                if(d==null && b==null){
                    JOptionPane.showMessageDialog(null, "Nome de pessoa nao existe","Erro",JOptionPane.ERROR_MESSAGE);
                    textPessoaAtribuir.setText("");
                    check = 1;
                }
                if(d!=null) pes=d;
                if(b!=null) pes=b;
                Tarefa t=null;
                for(i=0;i<pList.getTarefas().size();i++){
                    if(pList.getTarefas().get(i).getNome().equals(nomeTarefa)) {
                        t=pList.getTarefas().get(i);
                        break;
                    }
                }
                if(t==null){
                    JOptionPane.showMessageDialog(null, "Nome de tarefa nao existe","Erro",JOptionPane.ERROR_MESSAGE);
                    textTarefaAtribuir.setText("");
                    check = 1;
                }
                if(check!=1){
                    if(pList.atribuirTar(pes,t)){
                        JOptionPane.showMessageDialog(null, "Tarefa atribuida com sucesso!", "Projeto", JOptionPane.PLAIN_MESSAGE);
                        cisuc.writeFichObjProj();
                    }else JOptionPane.showMessageDialog(null, "Nao foi possivel atribuir a tarefa a pessoa. A pessoa pode esstar sem disponiblidade ou o tipo de tarefa a sobrecarrega ","Erro",JOptionPane.ERROR_MESSAGE);
                    textTarefaAtribuir.setText("");
                    textPessoaAtribuir.setText("");
                }
            }

            //Menu Atualiza Taxa de Execução
            else if(e.getSource() == buttonAtualizaTaxaEx){
                panelAtualizaTaxaEx.setLayout(new GridLayout(3,2));
                panelAtualizaTaxaEx.add(labelTarefaAtualizar);
                panelAtualizaTaxaEx.add(textTarefaAtualizar);
                panelAtualizaTaxaEx.add(labelNovaPercentagem);
                panelAtualizaTaxaEx.add(textNovaPercentagem);
                panelAtualizaTaxaEx.add(buttonVoltarConfigProjeto);
                panelAtualizaTaxaEx.add(buttonAtualizar);
                subsPaneis(panelConfigProjeto, panelAtualizaTaxaEx);

            }

            //Atualiza Taxa de Execução
            else if(e.getSource() == buttonAtualizar){
                String nomeTarefa = textTarefaAtualizar.getText();
                int check=0;
                if(nomeTarefa.equals("")){
                    JOptionPane.showMessageDialog(null, "O campo 'Nome do projeto que pretende associar' esta vazio","Erro",JOptionPane.ERROR_MESSAGE);
                    check = 1;
                }
                String percentagem = textNovaPercentagem.getText();
                if(textNovaPercentagem.equals("")){
                    JOptionPane.showMessageDialog(null, "O campo 'Nome da pessoa que pretende associar' esta vazio","Erro",JOptionPane.ERROR_MESSAGE);
                    check = 1;
                }
                int i;
                Tarefa t=null;
                for(i=0;i<pList.getTarefas().size();i++){
                    if(pList.getTarefas().get(i).getNome().equals(nomeTarefa)) {
                        t=pList.getTarefas().get(i);
                        break;
                    }
                }
                if(t==null){
                    JOptionPane.showMessageDialog(null, "Nome de tarefa nao existe","Erro",JOptionPane.ERROR_MESSAGE);
                    textTarefaAtualizar.setText("");
                    check = 1;
                }
                float perc=0;
                try{
                    perc=Float.parseFloat(percentagem);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Tem que um numero","Erro",JOptionPane.ERROR_MESSAGE);
                    textNovaPercentagem.setText("");
                    check = 1;
                }
                if(perc<0 || perc>100){
                    JOptionPane.showMessageDialog(null, "Percentagem tem que estar entre 100 e 0 inclusive","Erro",JOptionPane.ERROR_MESSAGE);
                    textNovaPercentagem.setText("");
                    check = 1;
                }
                if(check!=1){
                    if(t.atualPerc(perc)){
                        JOptionPane.showMessageDialog(null, "Taxa de execucao da tarefa atualizada com sucesso!", "Projeto", JOptionPane.PLAIN_MESSAGE);
                        cisuc.writeFichObjProj();
                    }else{
                        if(t.getPerc()==100) JOptionPane.showMessageDialog(null, "Taxa de execucao ja esta a 100","Erro",JOptionPane.ERROR_MESSAGE);
                        else JOptionPane.showMessageDialog(null, "Nao da para dimnuir a taxa de execucao nem por uma igual","Erro",JOptionPane.ERROR_MESSAGE);
                    }
                    textTarefaAtualizar.setText("");
                    textNovaPercentagem.setText("");
                }
            }

            //Apresenta o custo do projeto
            else if(e.getSource() == buttonCustoProjeto){
                String messsage="O custo do projeto e " + String.valueOf(pList.getCusto());
                JOptionPane.showMessageDialog(null,messsage,"Custo",JOptionPane.PLAIN_MESSAGE);
            }

            //Menu Lista Pessoas Projeto
            else if(e.getSource() == buttonListaPessoasProjeto){
                ArrayList<Docente> docentes = pList.getDocentes();
                ArrayList<Bolseiros> bolseiros =pList.getBolseiros();
                int i;
                for (i = 0; i < docentes.size(); i++) listPessProj.addElement(docentes.get(i));
                for (i = 0; i < bolseiros.size(); i++) listPessProj.addElement(bolseiros.get(i));
                panelListaPessProj.setLayout(null);
                panelListaPessProj.add(pessoasProjScroll);
                panelListaPessProj.add(buttonVoltarConfigProjeto);
                buttonVoltarConfigProjeto.setBounds(225,310,150,25);
                subsPaneis(panelConfigProjeto,panelListaPessProj);
            }

            //Termina o projeto sendo que fica apenas disponivel para consulta
            else if(e.getSource() == buttonTerminar){
                int check=0;
                LocalDate ld=LocalDate.of(pList.getDataInicial().getAno(),pList.getDataInicial().getMes(),pList.getDataInicial().getDia());
                if(LocalDate.now().isBefore(ld)){
                    JOptionPane.showMessageDialog(null, "Projeto nao pode ser acabado, uma vez que nem sequer comecou","Erro",JOptionPane.ERROR_MESSAGE);
                    check=1;
                }
                if(check!=1){
                    if(pList.termProj()){
                        Data dataF=new Data(LocalDate.now().getDayOfMonth(),LocalDate.now().getMonthValue(),LocalDate.now().getYear());
                        pList.setDataFinal(dataF);
                        JOptionPane.showMessageDialog(null, "Projeto concluido com sucesso!", "Projeto", JOptionPane.PLAIN_MESSAGE);
                        cisuc.writeFichObjProj();
                        subsPaneis(panelConfigProjeto,panel);
                    }else JOptionPane.showMessageDialog(null, "Projeto nao pode ser acabado, uma vez que nao tem as tarefas todas concluidas","Erro",JOptionPane.ERROR_MESSAGE);
                    textNomeTerminar.setText("");
                }
            }

        }
    }
}

