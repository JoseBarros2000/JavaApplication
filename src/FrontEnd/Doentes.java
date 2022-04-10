
package FrontEnd;

import BackEnd.Doente;
import BackEnd.Enfermaria;
import BackEnd.Sistema;
import Exceptions.CamasIndisponiveis;
import Serializacao.Serializacao;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class Doentes extends javax.swing.JFrame {

    private Sistema sistema;
    private Serializacao serializacao;
    private String codigoHospital;
    private DefaultTableModel modelo;
    public static Integer linha;
    private DefaultComboBoxModel model;
    private DefaultComboBoxModel modelCamas;
    private DefaultComboBoxModel modelMedicos;
    private String codigoDoen;
    private String nomeDoen;
    private String localidadeDoen;
    private String enferColocado;
    private String dataEntrada;

    public Doentes(Sistema sistema, Serializacao serializacao,String nomeHospital, String codigoHospital) {
        initComponents();
        
        this.sistema = sistema;
        this.serializacao = serializacao;
        this.codigoHospital = codigoHospital;
        
        setSize(750,625);
        setLocationRelativeTo(null);
        setResizable(false);
        
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        
        //criação de modelos de tabelas e combobox´s
        modelo = (DefaultTableModel) tableDoentes.getModel();
        model = (DefaultComboBoxModel) boxEnfermariaColocado.getModel();
        modelCamas = (DefaultComboBoxModel) boxCama.getModel();
        modelMedicos = (DefaultComboBoxModel) boxMedicoDoDoente.getModel();
        
        //definir valores da tabela
        
        tableDoentes.setModel(modelo);
        modelo.setNumRows(0);
        for (int i=0; i<sistema.getListaHospital().getCodHospital(codigoHospital).getListaDoentes().sizeDoentes(); i++) {
            Doente doente = sistema.getListaHospital().getCodHospital(codigoHospital).getListaDoentes().getDoentesByIndex(i);
            modelo.addRow(new Object[]{doente.getCodigoDoen(), doente.getNome(), doente.getLocalidade(), doente.getEnfermariaOndeEstaODoente(),doente.getEstado(),doente.getDataEntrada()});
        }
        
        painelNomeHospital.setText(codigoHospital);
        
        panelCriarDoente.setVisible(false);

        txtPesquisar.setText("Pesquisar");
        
        //ordenação dos doentes
        sistema.getListaHospital().getCodHospital(codigoHospital).getListaDoentes().ordenacaoDoentes();
       
    }
     
    //filtrar a tabela
    public void filterDoen(String searchdoen){
        TableRowSorter<DefaultTableModel> tdoen = new TableRowSorter<>(modelo);
        tableDoentes.setRowSorter(tdoen);
        tdoen.setRowFilter(RowFilter.regexFilter(searchdoen));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        butVoltar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDoentes = new javax.swing.JTable();
        btnAdicionarDoente = new javax.swing.JButton();
        btnDarAlta = new javax.swing.JButton();
        butEditar = new javax.swing.JButton();
        panelCriarDoente = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        txtNomeDoente = new javax.swing.JTextField();
        lblCodigo = new javax.swing.JLabel();
        lblLocalidade = new javax.swing.JLabel();
        txtCodDoente = new javax.swing.JTextField();
        txtLocalidade = new javax.swing.JTextField();
        butCancelar = new javax.swing.JButton();
        butGravarDados = new javax.swing.JButton();
        butCriar = new javax.swing.JButton();
        lblEnfermaria = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        boxEstado = new javax.swing.JComboBox<>();
        boxEnfermariaColocado = new javax.swing.JComboBox<>();
        lblCama = new javax.swing.JLabel();
        boxCama = new javax.swing.JComboBox<>();
        calendario = new com.toedter.calendar.JDateChooser();
        boxMedicoDoDoente = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        painelNomeHospital = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtPesquisar = new javax.swing.JTextField();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        butVoltar.setText("Voltar");
        butVoltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butVoltarMouseClicked(evt);
            }
        });
        getContentPane().add(butVoltar);
        butVoltar.setBounds(578, 12, 77, 21);

        tableDoentes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod. Doente", "Nome", "Localidade", "Enfermaria", "Estado", "Data de Entrada"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableDoentes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDoentesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableDoentes);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 41, 645, 210);

        btnAdicionarDoente.setText("Adicionar Doente");
        btnAdicionarDoente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAdicionarDoenteMouseClicked(evt);
            }
        });
        getContentPane().add(btnAdicionarDoente);
        btnAdicionarDoente.setBounds(10, 257, 204, 30);

        btnDarAlta.setText("Dar Alta");
        btnDarAlta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDarAltaMouseClicked(evt);
            }
        });
        getContentPane().add(btnDarAlta);
        btnDarAlta.setBounds(240, 257, 204, 30);

        butEditar.setText("Editar Dados");
        butEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butEditarMouseClicked(evt);
            }
        });
        getContentPane().add(butEditar);
        butEditar.setBounds(462, 257, 195, 30);

        panelCriarDoente.setLayout(null);

        lblNome.setText("        Nome do Doente :");
        panelCriarDoente.add(lblNome);
        lblNome.setBounds(0, 40, 131, 13);
        panelCriarDoente.add(txtNomeDoente);
        txtNomeDoente.setBounds(150, 40, 189, 19);

        lblCodigo.setText("       Código do Doente :");
        panelCriarDoente.add(lblCodigo);
        lblCodigo.setBounds(0, 10, 140, 13);

        lblLocalidade.setText("             Localidade :");
        panelCriarDoente.add(lblLocalidade);
        lblLocalidade.setBounds(20, 70, 116, 30);

        txtCodDoente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodDoenteActionPerformed(evt);
            }
        });
        panelCriarDoente.add(txtCodDoente);
        txtCodDoente.setBounds(150, 10, 190, 20);

        txtLocalidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLocalidadeActionPerformed(evt);
            }
        });
        txtLocalidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLocalidadeKeyTyped(evt);
            }
        });
        panelCriarDoente.add(txtLocalidade);
        txtLocalidade.setBounds(150, 70, 190, 19);

        butCancelar.setText("Cancelar");
        butCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butCancelarMouseClicked(evt);
            }
        });
        panelCriarDoente.add(butCancelar);
        butCancelar.setBounds(360, 230, 128, 21);

        butGravarDados.setText("Gravar Dados");
        butGravarDados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butGravarDadosMouseClicked(evt);
            }
        });
        panelCriarDoente.add(butGravarDados);
        butGravarDados.setBounds(360, 150, 129, 21);

        butCriar.setText("Criar");
        butCriar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butCriarMouseClicked(evt);
            }
        });
        panelCriarDoente.add(butCriar);
        butCriar.setBounds(360, 190, 128, 21);

        lblEnfermaria.setText("   Enfermaria Colocado :");
        panelCriarDoente.add(lblEnfermaria);
        lblEnfermaria.setBounds(0, 100, 150, 13);

        lblEstado.setText("                  Estado : ");
        panelCriarDoente.add(lblEstado);
        lblEstado.setBounds(20, 130, 112, 13);

        lblData.setText("     Data de Entrada : ");
        panelCriarDoente.add(lblData);
        lblData.setBounds(10, 190, 130, 29);

        boxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Leve","Médio","Grave","Muito Grave" }));
        panelCriarDoente.add(boxEstado);
        boxEstado.setBounds(150, 130, 165, 21);

        boxEnfermariaColocado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione uma opção" }));
        boxEnfermariaColocado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boxEnfermariaColocadoMouseClicked(evt);
            }
        });
        panelCriarDoente.add(boxEnfermariaColocado);
        boxEnfermariaColocado.setBounds(150, 100, 165, 21);

        lblCama.setText("Cama :");
        panelCriarDoente.add(lblCama);
        lblCama.setBounds(80, 160, 48, 13);

        boxCama.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleciona uma opção" }));
        boxCama.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boxCamaMouseClicked(evt);
            }
        });
        panelCriarDoente.add(boxCama);
        boxCama.setBounds(150, 160, 165, 21);
        panelCriarDoente.add(calendario);
        calendario.setBounds(150, 190, 166, 19);

        boxMedicoDoDoente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um médico" }));
        boxMedicoDoDoente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boxMedicoDoDoenteMouseClicked(evt);
            }
        });
        panelCriarDoente.add(boxMedicoDoDoente);
        boxMedicoDoDoente.setBounds(150, 230, 170, 21);

        jLabel1.setText("Medico do doente:");
        panelCriarDoente.add(jLabel1);
        jLabel1.setBounds(30, 230, 110, 30);

        getContentPane().add(panelCriarDoente);
        panelCriarDoente.setBounds(20, 300, 560, 310);
        getContentPane().add(painelNomeHospital);
        painelNomeHospital.setBounds(10, 10, 131, 22);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_search_16px.png"))); // NOI18N
        getContentPane().add(jLabel8);
        jLabel8.setBounds(196, 10, 23, 25);

        txtPesquisar.setText("Pesquisar");
        txtPesquisar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPesquisarMouseClicked(evt);
            }
        });
        txtPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisarKeyReleased(evt);
            }
        });
        getContentPane().add(txtPesquisar);
        txtPesquisar.setBounds(223, 10, 152, 25);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void butVoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butVoltarMouseClicked
        dispose();
    }//GEN-LAST:event_butVoltarMouseClicked

    private void btnAdicionarDoenteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdicionarDoenteMouseClicked
        //paineis visiveis
        panelCriarDoente.setVisible(true);
        panelCriarDoente.revalidate();
        btnAdicionarDoente.setVisible(false);
        btnDarAlta.setVisible(false);
        butEditar.setVisible(false);
        butGravarDados.setVisible(false);
        butCriar.setVisible(true);

        
        lblCodigo.setVisible(true);
        txtCodDoente.setVisible(true);

        lblNome.setVisible(true);
        txtNomeDoente.setVisible(true);
        
        lblLocalidade.setVisible(true);
        txtLocalidade.setVisible(true);
        
        lblEnfermaria.setVisible(true);
        boxEnfermariaColocado.setVisible(true);
        
        lblCama.setVisible(true);
        boxCama.setVisible(true);
        
        lblData.setVisible(true);
        calendario.setVisible(true);
        
        
        
    }//GEN-LAST:event_btnAdicionarDoenteMouseClicked

    private void btnDarAltaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDarAltaMouseClicked

       //dar alta ao doente e remove-lo da lista
        String codigoDoente = (String) tableDoentes.getValueAt(tableDoentes.getSelectedRow(), 0);
        for(int i=0;i<sistema.getListaHospital().getCodHospital(codigoHospital).getListaDoentes().sizeDoentes();i++){
            if(codigoDoente.equals(sistema.getListaHospital().getCodHospital(codigoHospital).getListaDoentes().getDoentesByIndex(i).getCodigoDoen())){
                modelo.removeRow(tableDoentes.getSelectedRow());
                sistema.getListaHospital().getCodHospital(codigoHospital).getListaDoentes().removerDoente(sistema.getListaHospital().getCodHospital(codigoHospital).getListaDoentes().getDoentesByIndex(i));
                for(int o=0;o<sistema.getListaHospital().getCodHospital(codigoHospital).getListaProfDeSaude().sizeProf();o++)
                    sistema.getListaHospital().getCodHospital(codigoHospital).getListaProfDeSaude().getMedicosByIndex(o).setNumDoentesAtribuidos();
            }
        }
        serializacao.guardar(sistema);
    }//GEN-LAST:event_btnDarAltaMouseClicked

    private void butEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butEditarMouseClicked
        //pegar nos valores da tabela e paineis visiveis
        codigoDoen = (String) tableDoentes.getValueAt(linha, 0);
        nomeDoen = (String) tableDoentes.getValueAt(linha, 1);
        localidadeDoen = (String) tableDoentes.getValueAt(linha, 2);
        enferColocado = (String) tableDoentes.getValueAt(linha, 3);
        dataEntrada = (String) tableDoentes.getValueAt(linha, 5);
        
        panelCriarDoente.setVisible(true);
        butGravarDados.setVisible(true);
        butCancelar.setVisible(true);
        btnAdicionarDoente.setVisible(false);
        butEditar.setVisible(false);
        btnDarAlta.setVisible(false);
         
        butCriar.setVisible(false);

        
        lblCodigo.setVisible(false);
        txtCodDoente.setVisible(false);

        lblNome.setVisible(false);
        txtNomeDoente.setVisible(false);
        
        lblLocalidade.setVisible(false);
        txtLocalidade.setVisible(false);
        
        lblEnfermaria.setVisible(false);
        boxEnfermariaColocado.setVisible(false);
        
        lblCama.setVisible(false);
        boxCama.setVisible(false);
        
        lblData.setVisible(false);
        calendario.setVisible(false);
        
        
        
    }//GEN-LAST:event_butEditarMouseClicked

    private void txtCodDoenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodDoenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodDoenteActionPerformed

    private void txtLocalidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLocalidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLocalidadeActionPerformed

    private void txtLocalidadeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLocalidadeKeyTyped

    }//GEN-LAST:event_txtLocalidadeKeyTyped

    private void butGravarDadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butGravarDadosMouseClicked
            //gravar dados editados
            String estado = (String) boxEstado.getSelectedItem();


            Doente doente = sistema.getListaHospital().getCodHospital(codigoHospital).getListaDoentes().getDoente(codigoDoen);
            doente.setEstado(estado);
         
                        
            modelo.removeRow(linha);
            modelo.addRow(new Object[]{codigoDoen, nomeDoen, localidadeDoen,enferColocado, estado, dataEntrada});
  
            panelCriarDoente.setVisible(false);
            
            btnAdicionarDoente.setVisible(true);
            butEditar.setVisible(true);
            btnDarAlta.setVisible(true);
                
        serializacao.guardar(sistema);
    }//GEN-LAST:event_butGravarDadosMouseClicked

    private void butCriarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butCriarMouseClicked
        
        //criar um doente
        try{
            String codigoDoente = txtCodDoente.getText();
            String nomeDoente = txtNomeDoente.getText();
            String localidade = txtLocalidade.getText();
            String enfermaria = (String) boxEnfermariaColocado.getSelectedItem();
            String medico = (String) boxMedicoDoDoente.getSelectedItem();
            String estado = (String) boxEstado.getSelectedItem();
            String camasEnfermaria = (String) boxCama.getSelectedItem();
            String enfer = sistema.getListaHospital().getCodHospital(codigoHospital).getListaEnfermaria().getEnfermaria(enfermaria).getCodigoEnf();
            String medicoAtribuido = sistema.getListaHospital().getCodHospital(codigoHospital).getListaProfDeSaude().getMedico(medico).getCodigoProf();
            int camasEnfermariaInt = Integer.parseInt((String) boxCama.getSelectedItem());
                    
            SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
            String data = dFormat.format(calendario.getDate());
            
            if(boxEnfermariaColocado.getSelectedItem().equals("Seleciona uma opção") || boxEnfermariaColocado.getSelectedItem().equals("")){
                JOptionPane.showMessageDialog(null, "Não selecionou nenhum item!", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
            else if(!sistema.getListaHospital().getCodHospital(codigoHospital).getListaDoentes().existe(codigoDoente))
            {
                
                sistema.getListaHospital().getCodHospital(codigoHospital).getListaDoentes().setCriarNovoDoen(new Doente (codigoDoente, nomeDoente, localidade,enfer,camasEnfermariaInt, estado, data, medicoAtribuido));
                sistema.getListaHospital().getCodHospital(codigoHospital).getListaProfDeSaude().getMedico(medico).setDoenteDoMedico(codigoDoente);
                sistema.getListaHospital().getCodHospital(codigoHospital).getListaProfDeSaude().getMedico(medico).setNumDoentesAtribuidos();
                sistema.getListaHospital().getCodHospital(codigoHospital).getListaEnfermaria().getEnfermaria(enfermaria).ocuparCama(camasEnfermaria);
                Doente doente = sistema.getListaHospital().getCodHospital(codigoHospital).getListaDoentes().getDoente(codigoDoente);
                modelo.addRow(new Object[]{doente.getCodigoDoen(), doente.getNome(), doente.getLocalidade(), enfer, estado, data});
                
                serializacao.guardar(sistema);
                
                panelCriarDoente.setVisible(false);
                btnAdicionarDoente.setVisible(true);
                btnDarAlta.setVisible(true);
                butEditar.setVisible(true);
                
                txtCodDoente.setText("");
                txtNomeDoente.setText("");
                txtLocalidade.setText("");
                boxEnfermariaColocado.setSelectedItem("Selecione uma opção");
                boxCama.setSelectedItem("Selecione uma opção");
           
                
            }else {
                JOptionPane.showMessageDialog(null, "Já existe um doente com este código!", "ERRO", JOptionPane.ERROR_MESSAGE);

            }
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Não introduziu um número", "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (CamasIndisponiveis ex) {
            Logger.getLogger(Doentes.class.getName()).log(Level.SEVERE, null, ex);
        }
        serializacao.guardar(sistema);
        
    }//GEN-LAST:event_butCriarMouseClicked

    private void boxEnfermariaColocadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boxEnfermariaColocadoMouseClicked
        //adicionar elementos na combobox
        model.removeAllElements();
        
        for (int o=0; o<sistema.getListaHospital().getCodHospital(codigoHospital).getListaEnfermaria().sizeEnfermaria(); o++) {
            model.addElement(sistema.getListaHospital().getCodHospital(codigoHospital).getListaEnfermaria().getEnfermariaByIndex(o).getCodigoEnf());
        }
        
    }//GEN-LAST:event_boxEnfermariaColocadoMouseClicked

    private void butCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butCancelarMouseClicked
       //paineis visiveis
        panelCriarDoente.setVisible(false);
        butEditar.setVisible(true);
        btnAdicionarDoente.setVisible(true);
        btnDarAlta.setVisible(true);
        
        txtCodDoente.setText("");
        txtNomeDoente.setText("");
        txtLocalidade.setText("");
        boxEnfermariaColocado.setSelectedItem("Selecione uma opção");
        boxCama.setSelectedItem("Selecione uma opção");
    }//GEN-LAST:event_butCancelarMouseClicked

    private void calendarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_calendarioMouseClicked
        
        
    }//GEN-LAST:event_calendarioMouseClicked

    private void boxCamaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boxCamaMouseClicked
       //adicionar elementos a combobox da cama
        String enfermaria = (String) boxEnfermariaColocado.getSelectedItem();
        
        modelCamas.removeAllElements();
        
        for (int o=0; o<sistema.getListaHospital().getCodHospital(codigoHospital).getListaEnfermaria().getEnfermaria(enfermaria).sizeCamasDesocupadas(); o++) {
            modelCamas.addElement(sistema.getListaHospital().getCodHospital(codigoHospital).getListaEnfermaria().getEnfermaria(enfermaria).getCamasDesocupadasByIndex(o));
        }
    }//GEN-LAST:event_boxCamaMouseClicked

    private void txtPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisarKeyReleased
        
        //pesquisar na tabela
        String searchdoen = txtPesquisar.getText();
        filterDoen(searchdoen);
    }//GEN-LAST:event_txtPesquisarKeyReleased

    private void txtPesquisarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPesquisarMouseClicked
        txtPesquisar.setText("");
    }//GEN-LAST:event_txtPesquisarMouseClicked

    private void tableDoentesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDoentesMouseClicked
        //selecionar linha da tabela
        linha = tableDoentes.getSelectedRow();
    }//GEN-LAST:event_tableDoentesMouseClicked

    private void boxMedicoDoDoenteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boxMedicoDoDoenteMouseClicked
        //adicionar elementos a combobox do medico
        modelMedicos.removeAllElements();
        for (int o=0; o<sistema.getListaHospital().getCodHospital(codigoHospital).getListaProfDeSaude().sizeMed(); o++) {
            modelMedicos.addElement(sistema.getListaHospital().getCodHospital(codigoHospital).getListaProfDeSaude().getMedicosByIndex(o).getNomeUtilizador());
            sistema.getListaHospital().getCodHospital(codigoHospital).getListaProfDeSaude().getMedicosByIndex(o).setNumDoentesAtribuidos();
        }
    }//GEN-LAST:event_boxMedicoDoDoenteMouseClicked



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxCama;
    private javax.swing.JComboBox<String> boxEnfermariaColocado;
    private javax.swing.JComboBox<String> boxEstado;
    private javax.swing.JComboBox<String> boxMedicoDoDoente;
    private javax.swing.JButton btnAdicionarDoente;
    private javax.swing.JButton btnDarAlta;
    private javax.swing.JButton butCancelar;
    private javax.swing.JButton butCriar;
    private javax.swing.JButton butEditar;
    private javax.swing.JButton butGravarDados;
    private javax.swing.JButton butVoltar;
    private com.toedter.calendar.JDateChooser calendario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCama;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblEnfermaria;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblLocalidade;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel painelNomeHospital;
    private javax.swing.JPanel panelCriarDoente;
    private javax.swing.JTable tableDoentes;
    private javax.swing.JTextField txtCodDoente;
    private javax.swing.JTextField txtLocalidade;
    private javax.swing.JTextField txtNomeDoente;
    private javax.swing.JTextField txtPesquisar;
    // End of variables declaration//GEN-END:variables
}
