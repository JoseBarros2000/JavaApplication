package FrontEnd;

import BackEnd.Enfermaria;
import BackEnd.Enfermeiro;
import BackEnd.Medico;
import BackEnd.Sistema;
import BackEnd.Utilizador;
import Ordenacao.OrdenarNomeUtilizador;
import Serializacao.Serializacao;
import java.util.Collections;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class CriarUtilizadores extends javax.swing.JInternalFrame {
    private Sistema sistema;
    private Serializacao serializacao;
    private DefaultTableModel modelo;
    private DefaultComboBoxModel modelEnf;
    private DefaultComboBoxModel modelHosp;
    private String hospitalSelecionado;
    private String cargoSelecionado;
    private Utilizador utilizador;
    public static Integer linha;
    public boolean verificarSeExiste;
    
    public CriarUtilizadores(Sistema sistema, Serializacao serializacao) {
        initComponents();
        this.sistema = sistema;
        this.serializacao = serializacao;
        this.verificarSeExiste = true;
        
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        
        //criação de modelos de tabelas e combobox´s
        modelo = (DefaultTableModel) tabelaUtilizadores.getModel();
        modelEnf = (DefaultComboBoxModel) boxEnfermaria.getModel();
        modelHosp = (DefaultComboBoxModel) boxHospitais.getModel();
        
        setResizable(false);
        
        painelDadosUtilizador.setVisible(false);
        butCriar.setVisible(false);
        butGravarDados.setVisible(false);
        
        tabelaUtilizadores.setModel(modelo);
        modelo.setNumRows(0);
        
        sistema.getListaUtilizador().ordenacaoUtilizadores();//ordenação dos utilizadores
        
        //Gerar a lista de Utilizadores Ordenada
        for (int i=0; i<sistema.getListaUtilizador().sizeUtilizador(); i++) {
            Utilizador utilizador = sistema.getListaUtilizador().getUtilizadorByIndex(i);
            if (utilizador instanceof Utilizador){
                if(utilizador.getNomeUtilizador().equals("admin"))
                    modelo.addRow(new Object[]{utilizador.getNomeUtilizador(), utilizador.getPassword(), null, "Administrador", null});
                else
                    modelo.addRow(new Object[]{utilizador.getNomeUtilizador(), utilizador.getPassword(), null, "Utilizador", null});
            }
        }
        for (int i=0; i<sistema.getListaHospital().sizeListaHospital(); i++) {
            for (int o=0; o< sistema.getListaHospital().getHospitalByIndex(i).getListaProfDeSaude().sizeMed(); o++){
                sistema.getListaHospital().getHospitalByIndex(i).getListaProfDeSaude().ordenacaoMedicos();
                Medico medico = sistema.getListaHospital().getHospitalByIndex(i).getListaProfDeSaude().getMedicosByIndex(o);
                if (medico instanceof Medico){
                    modelo.addRow(new Object[]{medico.getNomeUtilizador(), medico.getPassword(), medico.getNomeProf(), "Médico", sistema.getListaHospital().getHospitalByIndex(i).getNome()});
                }
            }
        }
        for (int i=0; i<sistema.getListaHospital().sizeListaHospital(); i++) {
            for (int o=0; o< sistema.getListaHospital().getHospitalByIndex(i).getListaProfDeSaude().sizeEnf(); o++){
                sistema.getListaHospital().getHospitalByIndex(i).getListaProfDeSaude().ordenacaoEnfermeiros();
                Enfermeiro enfermeiro = sistema.getListaHospital().getHospitalByIndex(i).getListaProfDeSaude().getEnfermeirosByIndex(o);
                if (enfermeiro instanceof Enfermeiro){
                    modelo.addRow(new Object[]{enfermeiro.getNomeUtilizador(), enfermeiro.getPassword(), enfermeiro.getNomeProf(), "Enfermeiro", sistema.getListaHospital().getHospitalByIndex(i).getNome()});
                }
            }
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaUtilizadores = new javax.swing.JTable();
        butAdicionar = new javax.swing.JButton();
        butRemover = new javax.swing.JButton();
        painelDadosUtilizador = new javax.swing.JPanel();
        boxCargos = new javax.swing.JComboBox<>();
        labelCargo = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        labelUserName = new javax.swing.JLabel();
        labelPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        labelNomeProf = new javax.swing.JLabel();
        txtNomeProfissional = new javax.swing.JTextField();
        labelCodigoProf = new javax.swing.JLabel();
        txtCodigoProfissional = new javax.swing.JTextField();
        labelHospital = new javax.swing.JLabel();
        boxHospitais = new javax.swing.JComboBox<>();
        labelEnfermaria = new javax.swing.JLabel();
        boxEnfermaria = new javax.swing.JComboBox<>();
        labelEspecialidade = new javax.swing.JLabel();
        txtEspecialidade = new javax.swing.JTextField();
        butCriar = new javax.swing.JButton();
        butEditar = new javax.swing.JButton();
        butGravarDados = new javax.swing.JButton();

        tabelaUtilizadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Username", "Password", "Nome de Profissional", "Cargo", "Hospital"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaUtilizadores.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabelaUtilizadores.getTableHeader().setReorderingAllowed(false);
        tabelaUtilizadores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaUtilizadoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaUtilizadores);

        butAdicionar.setText("Adicionar Utilizador");
        butAdicionar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butAdicionarMouseClicked(evt);
            }
        });

        butRemover.setText("Remover Utilizador");
        butRemover.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butRemoverMouseClicked(evt);
            }
        });

        boxCargos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione uma opção", "Utilizador", "Médico", "Enfermeiro" }));
        boxCargos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boxCargosMouseClicked(evt);
            }
        });
        boxCargos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxCargosActionPerformed(evt);
            }
        });

        labelCargo.setText("             Cargo:");

        labelUserName.setText("Username:");

        labelPassword.setText("Password:");

        labelNomeProf.setText("  Nome de Profissional:");

        txtNomeProfissional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeProfissionalActionPerformed(evt);
            }
        });

        labelCodigoProf.setText("Codigo de Profissional:");

        labelHospital.setText("         Hospital:");

        boxHospitais.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione uma opção" }));
        boxHospitais.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boxHospitaisMouseClicked(evt);
            }
        });
        boxHospitais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxHospitaisActionPerformed(evt);
            }
        });

        labelEnfermaria.setText("     Enfermaria:");

        boxEnfermaria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione uma opção" }));
        boxEnfermaria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boxEnfermariaMouseClicked(evt);
            }
        });
        boxEnfermaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxEnfermariaActionPerformed(evt);
            }
        });

        labelEspecialidade.setText("Especialidade:");

        txtEspecialidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEspecialidadeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelDadosUtilizadorLayout = new javax.swing.GroupLayout(painelDadosUtilizador);
        painelDadosUtilizador.setLayout(painelDadosUtilizadorLayout);
        painelDadosUtilizadorLayout.setHorizontalGroup(
            painelDadosUtilizadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosUtilizadorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDadosUtilizadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelDadosUtilizadorLayout.createSequentialGroup()
                        .addGroup(painelDadosUtilizadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(labelPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelUserName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelDadosUtilizadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPassword)
                            .addComponent(txtUsername)))
                    .addGroup(painelDadosUtilizadorLayout.createSequentialGroup()
                        .addGroup(painelDadosUtilizadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelNomeProf, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelCodigoProf, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelDadosUtilizadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNomeProfissional, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .addComponent(txtCodigoProfissional))))
                .addGap(8, 8, 8)
                .addGroup(painelDadosUtilizadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(labelEspecialidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelHospital, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelEnfermaria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelCargo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelDadosUtilizadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(boxHospitais, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(boxEnfermaria, javax.swing.GroupLayout.Alignment.TRAILING, 0, 151, Short.MAX_VALUE)
                    .addComponent(boxCargos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtEspecialidade))
                .addContainerGap())
        );
        painelDadosUtilizadorLayout.setVerticalGroup(
            painelDadosUtilizadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosUtilizadorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDadosUtilizadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(labelUserName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(painelDadosUtilizadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(boxCargos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelCargo)
                        .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelDadosUtilizadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelHospital)
                    .addComponent(boxHospitais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelDadosUtilizadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelEnfermaria, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(painelDadosUtilizadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelCodigoProf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCodigoProfissional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(boxEnfermaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelDadosUtilizadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNomeProf, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomeProfissional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelEspecialidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtEspecialidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        butCriar.setText("Criar");
        butCriar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butCriarMouseClicked(evt);
            }
        });

        butEditar.setText("Editar");
        butEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butEditarMouseClicked(evt);
            }
        });

        butGravarDados.setText("Gravar dados");
        butGravarDados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butGravarDadosMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelDadosUtilizador, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(butAdicionar)
                        .addGap(18, 18, 18)
                        .addComponent(butEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(butRemover))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(butCriar, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(butGravarDados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(butRemover)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(butAdicionar)
                        .addComponent(butEditar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelDadosUtilizador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butCriar)
                    .addComponent(butGravarDados))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void butAdicionarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butAdicionarMouseClicked
        painelDadosUtilizador.setVisible(true);
        labelCodigoProf.setVisible(false);
        labelEnfermaria.setVisible(false);
        labelEspecialidade.setVisible(false);
        labelNomeProf.setVisible(false);
        labelHospital.setVisible(false);
        txtCodigoProfissional.setVisible(false);
        txtEspecialidade.setVisible(false);
        txtNomeProfissional.setVisible(false);
        boxHospitais.setVisible(false);
        boxEnfermaria.setVisible(false);
        butCriar.setVisible(true);
    }//GEN-LAST:event_butAdicionarMouseClicked

    private void butCriarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butCriarMouseClicked
        try{
            String nomeUtilizador = (String) txtUsername.getText();
            String password = (String) txtPassword.getText();
            String cargo = (String) boxCargos.getSelectedItem();
            String hospital = (String) boxHospitais.getSelectedItem();
            String enfermaria = (String) boxEnfermaria.getSelectedItem();
               
            //Criar Utilizador
            if(!nomeUtilizador.trim().equals("") && !password.trim().equals("") && !cargo.trim().equals("") && !cargo.trim().equals("Selecione uma opção")){
                if(!sistema.getListaUtilizador().existe(txtUsername.getText())){
                    if(boxCargos.getSelectedItem().equals("Utilizador") && sistema.getListaHospital().sizeListaHospital()!=0){
                        for (int i=0; i<sistema.getListaHospital().sizeListaHospital(); i++) {
                            if(sistema.getListaHospital().getHospitalByIndex(i).getListaProfDeSaude().sizeProf()!=0){
                                for (int o=0; o< sistema.getListaHospital().getHospitalByIndex(i).getListaProfDeSaude().sizeProf(); o++){
                                    if(!sistema.getListaHospital().getHospitalByIndex(i).getListaProfDeSaude().existeMed(txtUsername.getText()) && !sistema.getListaHospital().getHospitalByIndex(i).getListaProfDeSaude().existeEnf(txtUsername.getText())){
                                        sistema.getListaUtilizador().criarNovoUti(new Utilizador(txtUsername.getText(), txtPassword.getText()));
                                        sistema.getListaUtilizador().ordenacaoUtilizadores();
                                        modelo.addRow(new Object[]{txtUsername.getText(), txtPassword.getText(), null, "Utilizador", null});
                                        break;
                                    }else{
                                        JOptionPane.showMessageDialog(null, "Utilizador já existe!", "ERRO", JOptionPane.ERROR_MESSAGE);
                                        break;
                                    }
                                }
                            }else{
                                sistema.getListaUtilizador().criarNovoUti(new Utilizador(txtUsername.getText(), txtPassword.getText()));
                                sistema.getListaUtilizador().ordenacaoUtilizadores();
                                modelo.addRow(new Object[]{txtUsername.getText(), txtPassword.getText()});
                                break;
                            }
                        }
                    }else{
                        if(boxCargos.getSelectedItem().equals("Utilizador") && sistema.getListaHospital().sizeListaHospital()==0){
                            sistema.getListaUtilizador().criarNovoUti(new Utilizador(txtUsername.getText(), txtPassword.getText()));
                                    sistema.getListaUtilizador().ordenacaoUtilizadores();
                                    modelo.addRow(new Object[]{txtUsername.getText(), txtPassword.getText()});
                        }
                    }
                    if(boxCargos.getSelectedItem().equals("Médico")){
                        if(!txtEspecialidade.getText().trim().equals("")){
                            for(int i=0; i<sistema.getListaHospital().sizeListaHospital(); i++){
                                if(!sistema.getListaHospital().getHospitalByIndex(i).getListaProfDeSaude().existeMed(txtUsername.getText()) && !sistema.getListaHospital().getHospitalByIndex(i).getListaProfDeSaude().existeEnf(txtUsername.getText()) && !sistema.getListaHospital().getHospitalByIndex(i).getListaProfDeSaude().existeCodProf(txtCodigoProfissional.getText())){
                                    verificarSeExiste=true;
                                }else{
                                    verificarSeExiste=false;
                                    break;
                                }
                            }
                            if(verificarSeExiste){
                                sistema.getListaHospital().getNomeHospital(hospital).getListaProfDeSaude().criarProfDeSaudeMed(new Medico(txtUsername.getText(), txtPassword.getText(), txtCodigoProfissional.getText(), txtNomeProfissional.getText(), sistema.getListaHospital().getNomeHospital(hospital), sistema.getListaHospital().getNomeHospital(hospital).getListaEnfermaria().getEnfermaria(enfermaria), txtEspecialidade.getText()));
                                for(int i=0; i<sistema.getListaHospital().sizeListaHospital(); i++)
                                    sistema.getListaHospital().getHospitalByIndex(i).getListaProfDeSaude().ordenacaoMedicos();
                                modelo.addRow(new Object[]{txtUsername.getText(), txtPassword.getText(), txtNomeProfissional.getText(), "Médico", (String)boxHospitais.getSelectedItem()});
                            }else{
                                JOptionPane.showMessageDialog(null, "Utilizador ou codigo de profissional já existe!", "ERRO", JOptionPane.ERROR_MESSAGE);
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "Não escreveu a especialidade do médico!", "ERRO", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    if(boxCargos.getSelectedItem().equals("Enfermeiro")){
                        for(int i=0; i<sistema.getListaHospital().sizeListaHospital(); i++){
                            if(!sistema.getListaHospital().getHospitalByIndex(i).getListaProfDeSaude().existeMed(txtUsername.getText()) && !sistema.getListaHospital().getHospitalByIndex(i).getListaProfDeSaude().existeEnf(txtUsername.getText()) && !sistema.getListaHospital().getHospitalByIndex(i).getListaProfDeSaude().existeCodProf(txtCodigoProfissional.getText())){
                                verificarSeExiste=true;
                            }else{
                                verificarSeExiste=false;
                                break;
                            }
                        }
                        if(verificarSeExiste){
                            sistema.getListaHospital().getNomeHospital(hospital).getListaProfDeSaude().criarProfDeSaudeEnf(new Enfermeiro(txtUsername.getText(), txtPassword.getText(), txtCodigoProfissional.getText(), txtNomeProfissional.getText(), sistema.getListaHospital().getNomeHospital(hospital), sistema.getListaHospital().getNomeHospital(hospital).getListaEnfermaria().getEnfermaria(enfermaria)));
                            for(int i=0; i<sistema.getListaHospital().sizeListaHospital(); i++)
                                sistema.getListaHospital().getHospitalByIndex(i).getListaProfDeSaude().ordenacaoEnfermeiros();
                            modelo.addRow(new Object[]{txtUsername.getText(), txtPassword.getText(), txtNomeProfissional.getText(), "Enfermeiro", (String)boxHospitais.getSelectedItem()}); 
                        }else{
                            JOptionPane.showMessageDialog(null, "Utilizador ou codigo de profissional já existe!", "ERRO", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Utilizador já existe!", "ERRO", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Campos não preenchidos!", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
            serializacao.guardar(sistema);
        }catch(RuntimeException exc){
            JOptionPane.showMessageDialog(null, "Utilizador já existe ou campos não preenchidos!", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_butCriarMouseClicked

    private void butRemoverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butRemoverMouseClicked
        String userName = (String) tabelaUtilizadores.getValueAt(linha, 0);
        
        //Remover Utilizador
        if (userName.equals("admin")){
            JOptionPane.showMessageDialog(null, "Não pode remover o admininstrador", "ERRO", JOptionPane.ERROR_MESSAGE);
        }else {
            for(int i=0; i<sistema.getListaUtilizador().sizeUtilizador();i++){
                if(userName.equals(sistema.getListaUtilizador().getUtilizadorByIndex(i).getNomeUtilizador())){
                    modelo.removeRow(linha);
                    sistema.getListaUtilizador().removerUtilizador(sistema.getListaUtilizador().getUtilizadorByIndex(i));
                }
            }
            for(int i=0; i<sistema.getListaHospital().sizeListaHospital();i++){
                for(int o=0; o<sistema.getListaHospital().getHospitalByIndex(i).getListaProfDeSaude().sizeMed();o++){
                    if(userName.equals(sistema.getListaHospital().getHospitalByIndex(i).getListaProfDeSaude().getMedicosByIndex(o).getNomeUtilizador())){
                        modelo.removeRow(linha);
                        sistema.getListaHospital().getHospitalByIndex(i).getListaProfDeSaude().setApagarProfDeSaude(sistema.getListaHospital().getHospitalByIndex(i).getListaProfDeSaude().getMedicosByIndex(o).getNomeUtilizador());
                    }
                }
            }
        }
        serializacao.guardar(sistema);  
    }//GEN-LAST:event_butRemoverMouseClicked

    private void tabelaUtilizadoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaUtilizadoresMouseClicked
        linha = tabelaUtilizadores.getSelectedRow();
    }//GEN-LAST:event_tabelaUtilizadoresMouseClicked

    private void txtNomeProfissionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeProfissionalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeProfissionalActionPerformed

    private void boxEnfermariaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boxEnfermariaMouseClicked
        String hospital = (String) boxHospitais.getSelectedItem();
        
        //Adicionar as enfermarias do sistema na combobox
        modelEnf.removeAllElements();
        for (int o=0; o<sistema.getListaHospital().getNomeHospital(hospital).getListaEnfermaria().sizeEnfermaria(); o++) {
            Enfermaria enfermaria = sistema.getListaHospital().getNomeHospital(hospital).getListaEnfermaria().getEnfermariaByIndex(o);
            modelEnf.addElement(enfermaria.getCodigoEnf());
        }
    }//GEN-LAST:event_boxEnfermariaMouseClicked

    private void boxHospitaisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boxHospitaisMouseClicked
        
        //Adicionar os hospitais do sistema na combobox
        try{
            String hospital = (String) boxHospitais.getSelectedItem();
            if(!hospital.equals(hospitalSelecionado)){
                modelEnf.removeAllElements();
                for (int o=0; o<sistema.getListaHospital().getNomeHospital(hospital).getListaEnfermaria().sizeEnfermaria(); o++) {
                    Enfermaria enfermaria = sistema.getListaHospital().getNomeHospital(hospital).getListaEnfermaria().getEnfermariaByIndex(o);
                    modelEnf.addElement(enfermaria.getCodigoEnf());
                }
            }
            hospitalSelecionado=(String) boxHospitais.getSelectedItem();
        }catch(NullPointerException exc){
            JOptionPane.showMessageDialog(null, "Não existem hospitais!", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_boxHospitaisMouseClicked

    private void boxHospitaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxHospitaisActionPerformed
        
    }//GEN-LAST:event_boxHospitaisActionPerformed

    private void boxCargosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boxCargosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_boxCargosMouseClicked

    private void boxCargosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxCargosActionPerformed
        
        //Selecionar um dos cargos
        cargoSelecionado = (String)boxCargos.getSelectedItem();
        if(!cargoSelecionado.equals("Médico") && !cargoSelecionado.equals("Enfermeiro")){
            labelCodigoProf.setVisible(false);
            labelEnfermaria.setVisible(false);
            labelEspecialidade.setVisible(false);
            labelNomeProf.setVisible(false);
            labelHospital.setVisible(false);
            txtCodigoProfissional.setVisible(false);
            txtEspecialidade.setVisible(false);
            txtNomeProfissional.setVisible(false);
            boxHospitais.setVisible(false);
            boxEnfermaria.setVisible(false);
        }else{
            labelCodigoProf.setVisible(true);
            labelEnfermaria.setVisible(true);
            labelEspecialidade.setVisible(true);
            labelNomeProf.setVisible(true);
            labelHospital.setVisible(true);
            txtCodigoProfissional.setVisible(true);
            if(!cargoSelecionado.equals("Médico")){
                txtEspecialidade.setVisible(false);
                labelEspecialidade.setVisible(false);
            }
            else{
                txtEspecialidade.setVisible(true);
                labelEspecialidade.setVisible(true);
            }
            txtNomeProfissional.setVisible(true);
            boxHospitais.setVisible(true);
            boxEnfermaria.setVisible(true);
            modelHosp.removeAllElements();
            for (int i=0; i<sistema.getListaHospital().sizeListaHospital(); i++) {
                modelHosp.addElement(sistema.getListaHospital().getHospitalByIndex(i).getNome());
            }
            modelEnf.removeAllElements();
        }
    }//GEN-LAST:event_boxCargosActionPerformed

    private void boxEnfermariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxEnfermariaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxEnfermariaActionPerformed

    private void butEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butEditarMouseClicked
        butGravarDados.setVisible(true);
        
        //Adicionar os Valores nas combobox´s
        if(linha!=null){
            String user = (String) tabelaUtilizadores.getValueAt(linha, 0); 
            if(user.equals("admin")){
                JOptionPane.showMessageDialog(null, "Não pode editar o administrador!", "ERRO", JOptionPane.ERROR_MESSAGE);
            }else{
            painelDadosUtilizador.setVisible(true);
            if(sistema.getListaUtilizador().existe((String) tabelaUtilizadores.getValueAt(linha, 0))){
                txtUsername.setText((String) tabelaUtilizadores.getValueAt(linha, 0));
                txtPassword.setText((String) tabelaUtilizadores.getValueAt(linha, 1));
                txtUsername.setVisible(true);
                txtPassword.setVisible(true);
                txtNomeProfissional.setVisible(false);
                txtEspecialidade.setVisible(false);
                txtCodigoProfissional.setVisible(false);
                boxEnfermaria.setVisible(false);
                boxHospitais.setVisible(false);
                boxCargos.setVisible(true);
                labelCodigoProf.setVisible(false);
                labelCargo.setVisible(true);
                labelEnfermaria.setVisible(false);
                labelEspecialidade.setVisible(false);
                labelHospital.setVisible(false);
                labelNomeProf.setVisible(false);
                labelPassword.setVisible(true);
                labelUserName.setVisible(true);
                boxCargos.setSelectedItem("Utilizador");
                boxCargos.setEnabled(false);
            }else
                if(tabelaUtilizadores.getValueAt(linha, 3).equals("Médico")){
                    txtUsername.setText((String) tabelaUtilizadores.getValueAt(linha, 0));
                    txtPassword.setText((String) tabelaUtilizadores.getValueAt(linha, 1));
                    txtNomeProfissional.setText((String) tabelaUtilizadores.getValueAt(linha, 2));
                    boxCargos.setSelectedItem((String) tabelaUtilizadores.getValueAt(linha, 3));
                    boxHospitais.setSelectedItem((String) tabelaUtilizadores.getValueAt(linha, 4));
                    txtCodigoProfissional.setText((String)sistema.getListaHospital().getNomeHospital((String) tabelaUtilizadores.getValueAt(linha, 4)).getListaProfDeSaude().getMedico((String) tabelaUtilizadores.getValueAt(linha, 0)).getCodigoProf());
                    txtEspecialidade.setText((String)sistema.getListaHospital().getNomeHospital((String) tabelaUtilizadores.getValueAt(linha, 4)).getListaProfDeSaude().getMedico((String) tabelaUtilizadores.getValueAt(linha, 0)).getEspecialidade());
                    boxCargos.setSelectedItem("Médico");
                    boxCargos.setEnabled(false);
                }else
                    if(tabelaUtilizadores.getValueAt(linha, 3).equals("Enfermeiro")){
                        txtUsername.setText((String) tabelaUtilizadores.getValueAt(linha, 0));
                        txtPassword.setText((String) tabelaUtilizadores.getValueAt(linha, 1));
                        txtNomeProfissional.setText((String) tabelaUtilizadores.getValueAt(linha, 2));
                        boxCargos.setSelectedItem((String) tabelaUtilizadores.getValueAt(linha, 3));
                        boxHospitais.setSelectedItem((String) tabelaUtilizadores.getValueAt(linha, 4));
                        txtCodigoProfissional.setText((String)sistema.getListaHospital().getNomeHospital((String) tabelaUtilizadores.getValueAt(linha, 4)).getListaProfDeSaude().getEnfermeiro((String) tabelaUtilizadores.getValueAt(linha, 0)).getCodigoProf());
                        boxCargos.setSelectedItem("Enfermeiro");
                        boxCargos.setEnabled(false);
                    }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Não selecionou uma linha!", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_butEditarMouseClicked

    private void butGravarDadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butGravarDadosMouseClicked
        
        //Gravar e Editar os valores do Utilizador
        try{
            verificarSeExiste=true;
            String nomeUtilizadorSelecionado = (String) tabelaUtilizadores.getValueAt(linha, 0);
            String nomeUtilizador = (String) txtUsername.getText();
            String password = (String) txtPassword.getText();
            String cargo = (String) boxCargos.getSelectedItem();
            String hospital = (String) boxHospitais.getSelectedItem();
            String enfermaria = (String) boxEnfermaria.getSelectedItem();
            if(!nomeUtilizador.trim().equals("") && !password.trim().equals("") && !cargo.trim().equals("") && !cargo.trim().equals("Selecione uma opção")){
                if((!nomeUtilizador.equals(nomeUtilizadorSelecionado) && !sistema.getListaUtilizador().existe(nomeUtilizador) )|| (nomeUtilizador.equals(nomeUtilizadorSelecionado))){
                    if(boxCargos.getSelectedItem().equals("Utilizador") && sistema.getListaHospital().sizeListaHospital()!=0){
                        for (int i=0; i<sistema.getListaHospital().sizeListaHospital(); i++) {
                            if(sistema.getListaHospital().getHospitalByIndex(i).getListaProfDeSaude().sizeProf()!=0){
                                for (int o=0; o< sistema.getListaHospital().getHospitalByIndex(i).getListaProfDeSaude().sizeProf(); o++){
                                    if(!sistema.getListaHospital().getHospitalByIndex(i).getListaProfDeSaude().existeMed(txtUsername.getText()) && !sistema.getListaHospital().getHospitalByIndex(i).getListaProfDeSaude().existeEnf(txtUsername.getText())){
                                        verificarSeExiste=true;
                                    }else{
                                        verificarSeExiste=false;
                                        break;
                                    }
                                }
                                if(verificarSeExiste){
                                    sistema.getListaUtilizador().getUtilizador(nomeUtilizadorSelecionado).setPassword(password);
                                    sistema.getListaUtilizador().getUtilizador(nomeUtilizadorSelecionado).setNomeUtilizador(nomeUtilizador);
                                    for(int o=0; o<sistema.getListaHospital().sizeListaHospital(); o++)
                                        sistema.getListaUtilizador().ordenacaoUtilizadores();
                                    modelo.removeRow(linha);
                                    modelo.addRow(new Object[]{txtUsername.getText(), txtPassword.getText(), null, "Utilizador", null});
                                }else{
                                    JOptionPane.showMessageDialog(null, "Utilizador já existe!", "ERRO", JOptionPane.ERROR_MESSAGE);
                                }
                            }else{
                                sistema.getListaUtilizador().getUtilizador(nomeUtilizadorSelecionado).setPassword(password);
                                sistema.getListaUtilizador().getUtilizador(nomeUtilizadorSelecionado).setNomeUtilizador(nomeUtilizador);
                                for(int o=0; o<sistema.getListaHospital().sizeListaHospital(); o++)
                                    sistema.getListaUtilizador().ordenacaoUtilizadores();
                                modelo.removeRow(linha);
                                modelo.addRow(new Object[]{txtUsername.getText(), txtPassword.getText()});
                            }
                        }
                    }else{
                        if(boxCargos.getSelectedItem().equals("Utilizador") && sistema.getListaHospital().sizeListaHospital()==0){
                            sistema.getListaUtilizador().getUtilizador(nomeUtilizadorSelecionado).setPassword(password);
                            sistema.getListaUtilizador().getUtilizador(nomeUtilizadorSelecionado).setNomeUtilizador(nomeUtilizador);
                            sistema.getListaUtilizador().ordenacaoUtilizadores();
                            modelo.removeRow(linha);
                            modelo.addRow(new Object[]{txtUsername.getText(), txtPassword.getText()}); 
                        }
                    }
                    if(boxCargos.getSelectedItem().equals("Médico")){
                        for(int i=0; i<sistema.getListaHospital().sizeListaHospital(); i++){
                            if(!nomeUtilizador.equals(nomeUtilizadorSelecionado) && !sistema.getListaHospital().getHospitalByIndex(i).getListaProfDeSaude().existeMed(txtUsername.getText()) && !sistema.getListaHospital().getHospitalByIndex(i).getListaProfDeSaude().existeEnf(txtUsername.getText()) && !sistema.getListaHospital().getHospitalByIndex(i).getListaProfDeSaude().existeCodProf(txtCodigoProfissional.getText())){
                                verificarSeExiste=true;
                            }else{
                                verificarSeExiste=false;
                                break;
                            }
                        }if(verificarSeExiste){
                            sistema.getListaHospital().getNomeHospital(hospital).getListaProfDeSaude().getMedico(nomeUtilizadorSelecionado).setNomeProf(txtNomeProfissional.getText());
                                sistema.getListaHospital().getNomeHospital(hospital).getListaProfDeSaude().getMedico(nomeUtilizadorSelecionado).setEnfTrab(sistema.getListaHospital().getNomeHospital(hospital).getListaEnfermaria().getEnfermaria(enfermaria));
                                sistema.getListaHospital().getNomeHospital(hospital).getListaProfDeSaude().getMedico(nomeUtilizadorSelecionado).setCodigoProf(txtCodigoProfissional.getText());
                                sistema.getListaHospital().getNomeHospital(hospital).getListaProfDeSaude().getMedico(nomeUtilizadorSelecionado).setPassword(password);
                                sistema.getListaHospital().getNomeHospital(hospital).getListaProfDeSaude().getMedico(nomeUtilizadorSelecionado).setEspecialidade(txtEspecialidade.getText());
                                sistema.getListaHospital().getNomeHospital(hospital).getListaProfDeSaude().getMedico(nomeUtilizadorSelecionado).setNomeUtilizador(nomeUtilizador);
                                for(int o=0; o<sistema.getListaHospital().sizeListaHospital(); o++)    
                                    sistema.getListaHospital().getHospitalByIndex(o).getListaProfDeSaude().ordenacaoMedicos();
                                modelo.removeRow(linha);
                                modelo.addRow(new Object[]{txtUsername.getText(), txtPassword.getText(), txtNomeProfissional.getText(), "Médico", (String)boxHospitais.getSelectedItem()}); 
                            }else{
                                JOptionPane.showMessageDialog(null, "Utilizador ou codigo de profissional já exite!", "ERRO", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    if(boxCargos.getSelectedItem().equals("Enfermeiro")){
                        for(int i=0; i<sistema.getListaHospital().sizeListaHospital(); i++){
                            if(!nomeUtilizador.equals(nomeUtilizadorSelecionado) && !sistema.getListaHospital().getHospitalByIndex(i).getListaProfDeSaude().existeMed(txtUsername.getText()) && !sistema.getListaHospital().getHospitalByIndex(i).getListaProfDeSaude().existeEnf(txtUsername.getText()) && !sistema.getListaHospital().getHospitalByIndex(i).getListaProfDeSaude().existeCodProf(txtCodigoProfissional.getText())){
                                verificarSeExiste=true;
                            }else{
                                verificarSeExiste=false;
                                break;
                            }
                        }if(verificarSeExiste){
                                sistema.getListaHospital().getNomeHospital(hospital).getListaProfDeSaude().getEnfermeiro(nomeUtilizadorSelecionado).setNomeProf(txtNomeProfissional.getText());
                                sistema.getListaHospital().getNomeHospital(hospital).getListaProfDeSaude().getEnfermeiro(nomeUtilizadorSelecionado).setEnfTrab(sistema.getListaHospital().getNomeHospital(hospital).getListaEnfermaria().getEnfermaria(enfermaria));
                                sistema.getListaHospital().getNomeHospital(hospital).getListaProfDeSaude().getEnfermeiro(nomeUtilizadorSelecionado).setCodigoProf(txtCodigoProfissional.getText());
                                sistema.getListaHospital().getNomeHospital(hospital).getListaProfDeSaude().getEnfermeiro(nomeUtilizadorSelecionado).setPassword(password);
                                sistema.getListaHospital().getNomeHospital(hospital).getListaProfDeSaude().getEnfermeiro(nomeUtilizadorSelecionado).setNomeUtilizador(nomeUtilizador);
                                for(int o=0; o<sistema.getListaHospital().sizeListaHospital(); o++)
                                    sistema.getListaHospital().getHospitalByIndex(o).getListaProfDeSaude().ordenacaoEnfermeiros();
                                modelo.removeRow(linha);
                                modelo.addRow(new Object[]{txtUsername.getText(), txtPassword.getText(), txtNomeProfissional.getText(), "Enfermeiro", (String)boxHospitais.getSelectedItem()}); 
                            }else{
                                JOptionPane.showMessageDialog(null, "Utilizador ou codigo de profissional já existe (Introduza um diferente)!", "ERRO", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                }else{
                    JOptionPane.showMessageDialog(null, "Utilizador já existe!", "ERRO", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Campos vazios!", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
            serializacao.guardar(sistema);
        }catch(RuntimeException exc){
            JOptionPane.showMessageDialog(null, "Utilizador já existe ou não selecionou uma enfermaria!", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_butGravarDadosMouseClicked

    private void txtEspecialidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEspecialidadeActionPerformed
        
    }//GEN-LAST:event_txtEspecialidadeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxCargos;
    private javax.swing.JComboBox<String> boxEnfermaria;
    private javax.swing.JComboBox<String> boxHospitais;
    private javax.swing.JButton butAdicionar;
    private javax.swing.JButton butCriar;
    private javax.swing.JButton butEditar;
    private javax.swing.JButton butGravarDados;
    private javax.swing.JButton butRemover;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCargo;
    private javax.swing.JLabel labelCodigoProf;
    private javax.swing.JLabel labelEnfermaria;
    private javax.swing.JLabel labelEspecialidade;
    private javax.swing.JLabel labelHospital;
    private javax.swing.JLabel labelNomeProf;
    private javax.swing.JLabel labelPassword;
    private javax.swing.JLabel labelUserName;
    private javax.swing.JPanel painelDadosUtilizador;
    private javax.swing.JTable tabelaUtilizadores;
    private javax.swing.JTextField txtCodigoProfissional;
    private javax.swing.JTextField txtEspecialidade;
    private javax.swing.JTextField txtNomeProfissional;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
