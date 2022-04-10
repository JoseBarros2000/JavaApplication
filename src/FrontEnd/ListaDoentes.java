
package FrontEnd;

import BackEnd.Doente;
import BackEnd.Sistema;
import Exceptions.CamasIndisponiveis;
import static FrontEnd.Doentes.linha;
import Serializacao.Serializacao;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


public class ListaDoentes extends javax.swing.JInternalFrame {

     private Sistema sistema;
     public static Integer linha;
     private Serializacao serializacao;
     private String codigoHospital;
     private DefaultTableModel modelo;
     private DefaultComboBoxModel modelCamas;
     private String codigoDoen;
    private String nomeDoen;
    private String localidadeDoen;
    private String enferColocado;
    private String dataEntrada;
     
     
     
    public ListaDoentes(Sistema sistema, Serializacao serializacao) {
        initComponents();
        this.sistema=sistema;
        this.serializacao=serializacao;
        
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        
        
        modelo = (DefaultTableModel) tableDoentes.getModel();
        modelCamas = (DefaultComboBoxModel) boxCama.getModel();
        
         panelAdd.setVisible(false);
         panelDarAlta.setVisible(false);
         
         panelEditarDoente.setVisible(true);
         panelEditarDados.setVisible(false);
         
         //introduzir dados na tabela
         modelo.setNumRows(0);
         System.out.println(sistema.getMedicoLigado().getHospitalOndeTrabalha().getCodigo());
        for (int i=0; i<sistema.getListaHospital().getCodHospital(sistema.getMedicoLigado().getHospitalOndeTrabalha().getCodigo()).getListaDoentes().sizeDoentes(); i++) {
            Doente doente = sistema.getListaHospital().getCodHospital(sistema.getMedicoLigado().getHospitalOndeTrabalha().getCodigo()).getListaDoentes().getDoentesByIndex(i);
            modelo.addRow(new Object[]{doente.getCodigoDoen(), doente.getNome(), doente.getLocalidade(), doente.getEnfermariaOndeEstaODoente(),doente.getEstado(),doente.getDataEntrada()});
        }

         
    }
    //filtrar
     public void filterDoen(String searchdoen){
        TableRowSorter<DefaultTableModel> tdoen = new TableRowSorter<>(modelo);
        tableDoentes.setRowSorter(tdoen);
        tdoen.setRowFilter(RowFilter.regexFilter(searchdoen));
    }
   
        

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDoentes = new javax.swing.JTable();
        btnDarAlta = new javax.swing.JButton();
        btnAddDoente = new javax.swing.JButton();
        panelEditarDoente = new javax.swing.JPanel();
        btnEditarDoente = new javax.swing.JButton();
        panelEditarDados = new javax.swing.JPanel();
        lblEstado1 = new javax.swing.JLabel();
        boxAlterarEstado = new javax.swing.JComboBox<>();
        btnEditar = new javax.swing.JButton();
        panelDarAlta = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        btnConfirmar = new javax.swing.JButton();
        calendarioSaida = new com.toedter.calendar.JDateChooser();
        panelAdd = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCodDoente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtLocalidade = new javax.swing.JTextField();
        lblEstado = new javax.swing.JLabel();
        boxEstado = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        btnGuardarAdd = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblCama = new javax.swing.JLabel();
        boxCama = new javax.swing.JComboBox<>();
        calendario = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        txtPesquisar = new javax.swing.JTextField();

        jButton1.setText("jButton1");

        getContentPane().setLayout(null);

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
        jScrollPane1.setBounds(10, 30, 478, 113);

        btnDarAlta.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 18)); // NOI18N
        btnDarAlta.setText("Dar alta");
        btnDarAlta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDarAltaMouseClicked(evt);
            }
        });
        getContentPane().add(btnDarAlta);
        btnDarAlta.setBounds(270, 150, 220, 30);

        btnAddDoente.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 18)); // NOI18N
        btnAddDoente.setText("Adicionar Doente");
        btnAddDoente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddDoenteMouseClicked(evt);
            }
        });
        getContentPane().add(btnAddDoente);
        btnAddDoente.setBounds(10, 150, 220, 30);

        panelEditarDoente.setLayout(null);

        btnEditarDoente.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 18)); // NOI18N
        btnEditarDoente.setText("Editar Doente");
        btnEditarDoente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditarDoenteMouseClicked(evt);
            }
        });
        panelEditarDoente.add(btnEditarDoente);
        btnEditarDoente.setBounds(110, 10, 240, 30);

        panelEditarDados.setLayout(null);

        lblEstado1.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 18)); // NOI18N
        lblEstado1.setText("Estado :");
        panelEditarDados.add(lblEstado1);
        lblEstado1.setBounds(10, 60, 110, 22);

        boxAlterarEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Leve", "Médio", "Grave", "Muito Grave" }));
        boxAlterarEstado.setSelectedIndex(-1);
        boxAlterarEstado.setToolTipText("");
        panelEditarDados.add(boxAlterarEstado);
        boxAlterarEstado.setBounds(110, 60, 130, 30);

        btnEditar.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 18)); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditarMouseClicked(evt);
            }
        });
        panelEditarDados.add(btnEditar);
        btnEditar.setBounds(340, 170, 130, 30);

        panelEditarDoente.add(panelEditarDados);
        panelEditarDados.setBounds(0, 0, 480, 210);

        getContentPane().add(panelEditarDoente);
        panelEditarDoente.setBounds(10, 180, 480, 210);

        panelDarAlta.setLayout(null);

        jLabel7.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 18)); // NOI18N
        jLabel7.setText("Data de Saída :");
        panelDarAlta.add(jLabel7);
        jLabel7.setBounds(10, 20, 200, 40);

        btnConfirmar.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 18)); // NOI18N
        btnConfirmar.setText("Confirmar");
        btnConfirmar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConfirmarMouseClicked(evt);
            }
        });
        panelDarAlta.add(btnConfirmar);
        btnConfirmar.setBounds(330, 140, 150, 30);
        panelDarAlta.add(calendarioSaida);
        calendarioSaida.setBounds(190, 30, 130, 30);

        getContentPane().add(panelDarAlta);
        panelDarAlta.setBounds(10, 230, 490, 170);

        panelAdd.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 14)); // NOI18N
        jLabel1.setText("Nome :");
        panelAdd.add(jLabel1);
        jLabel1.setBounds(100, 50, 90, 17);

        txtNome.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 10)); // NOI18N
        panelAdd.add(txtNome);
        txtNome.setBounds(160, 50, 130, 22);

        jLabel2.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 14)); // NOI18N
        jLabel2.setText("Código de Doente : ");
        panelAdd.add(jLabel2);
        jLabel2.setBounds(0, 20, 220, 17);

        txtCodDoente.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 10)); // NOI18N
        panelAdd.add(txtCodDoente);
        txtCodDoente.setBounds(160, 20, 130, 22);

        jLabel3.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 14)); // NOI18N
        jLabel3.setText("Localidade :");
        panelAdd.add(jLabel3);
        jLabel3.setBounds(50, 80, 150, 17);

        txtLocalidade.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 10)); // NOI18N
        panelAdd.add(txtLocalidade);
        txtLocalidade.setBounds(160, 80, 130, 22);

        lblEstado.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 14)); // NOI18N
        lblEstado.setText("Estado :");
        panelAdd.add(lblEstado);
        lblEstado.setBounds(300, 50, 110, 17);

        boxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Leve", "Médio", "Grave", "Muito Grave" }));
        boxEstado.setToolTipText("");
        panelAdd.add(boxEstado);
        boxEstado.setBounds(380, 50, 90, 22);

        jLabel6.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 14)); // NOI18N
        jLabel6.setText("Data de Entrada :");
        panelAdd.add(jLabel6);
        jLabel6.setBounds(0, 140, 160, 30);

        btnGuardarAdd.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 18)); // NOI18N
        btnGuardarAdd.setText("Guardar");
        btnGuardarAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarAddMouseClicked(evt);
            }
        });
        panelAdd.add(btnGuardarAdd);
        btnGuardarAdd.setBounds(340, 150, 130, 30);

        btnCancelar.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 18)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarMouseClicked(evt);
            }
        });
        panelAdd.add(btnCancelar);
        btnCancelar.setBounds(340, 110, 130, 30);

        lblCama.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 14)); // NOI18N
        lblCama.setText("Cama :");
        panelAdd.add(lblCama);
        lblCama.setBounds(100, 110, 80, 20);

        boxCama.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleciona uma opção" }));
        boxCama.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boxCamaMouseClicked(evt);
            }
        });
        panelAdd.add(boxCama);
        boxCama.setBounds(160, 110, 130, 21);
        panelAdd.add(calendario);
        calendario.setBounds(160, 140, 130, 30);

        getContentPane().add(panelAdd);
        panelAdd.setBounds(10, 190, 480, 190);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_search_16px.png"))); // NOI18N
        getContentPane().add(jLabel8);
        jLabel8.setBounds(170, 0, 23, 25);

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
        txtPesquisar.setBounds(190, 0, 152, 25);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarDoenteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarDoenteMouseClicked
       //obter dados da tbela
        codigoDoen = (String) tableDoentes.getValueAt(linha, 0);
        nomeDoen = (String) tableDoentes.getValueAt(linha, 1);
        localidadeDoen = (String) tableDoentes.getValueAt(linha, 2);
        enferColocado = (String) tableDoentes.getValueAt(linha, 3);
        dataEntrada = (String) tableDoentes.getValueAt(linha, 5);
        
        if (linha == null) {
            JOptionPane.showMessageDialog(null, "Linha nao selecionada", "ERRO", JOptionPane.ERROR_MESSAGE);
        } else {
            panelEditarDados.setVisible(true);
       
       }
         
    }//GEN-LAST:event_btnEditarDoenteMouseClicked

    private void btnDarAltaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDarAltaMouseClicked
       panelAdd.setVisible(false);
       panelDarAlta.setVisible(true);
       panelEditarDoente.setVisible(false);

    }//GEN-LAST:event_btnDarAltaMouseClicked

    private void btnGuardarAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarAddMouseClicked
        //adicionar doentes na tabela
        try{
            String codigoDoente = txtCodDoente.getText();
            String nomeDoente = txtNome.getText();
            String localidade = txtLocalidade.getText();
            String estado = (String) boxEstado.getSelectedItem();
            String camasEnfermaria = (String) boxCama.getSelectedItem();
            String enfer = sistema.getListaHospital().getCodHospital(sistema.getMedicoLigado().getHospitalOndeTrabalha().getCodigo()).getListaEnfermaria().getEnfermaria(sistema.getMedicoLigado().getEnfTrab().getCodigoEnf()).getCodigoEnf();
            int camasEnfermariaInt = Integer.parseInt((String) boxCama.getSelectedItem());
                    
            SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
            String data = dFormat.format(calendario.getDate());
            
            if(!sistema.getListaHospital().getCodHospital(sistema.getMedicoLigado().getHospitalOndeTrabalha().getCodigo()).getListaDoentes().existe(codigoDoente))
            {
                sistema.getListaHospital().getCodHospital(sistema.getMedicoLigado().getHospitalOndeTrabalha().getCodigo()).getListaDoentes().setCriarNovoDoen(new Doente (codigoDoente, nomeDoente, localidade,enfer,camasEnfermariaInt, estado, data, sistema.getMedicoLigado().getNomeUtilizador()));
                sistema.getListaHospital().getCodHospital(sistema.getMedicoLigado().getHospitalOndeTrabalha().getCodigo()).getListaProfDeSaude().getMedico(sistema.getMedicoLigado().getNomeUtilizador()).setDoenteDoMedico(codigoDoente);
                sistema.getListaHospital().getCodHospital(sistema.getMedicoLigado().getHospitalOndeTrabalha().getCodigo()).getListaProfDeSaude().getMedico(sistema.getMedicoLigado().getNomeUtilizador()).setNumDoentesAtribuidos();
                sistema.getListaHospital().getCodHospital(sistema.getMedicoLigado().getHospitalOndeTrabalha().getCodigo()).getListaEnfermaria().getEnfermaria(enfer).ocuparCama(camasEnfermaria);
                Doente doente = sistema.getListaHospital().getCodHospital(sistema.getMedicoLigado().getHospitalOndeTrabalha().getCodigo()).getListaDoentes().getDoente(codigoDoente);
                modelo.addRow(new Object[]{doente.getCodigoDoen(), doente.getNome(), doente.getLocalidade(), enfer, estado, data});
                
                serializacao.guardar(sistema);
                
                panelAdd.setVisible(false);
                panelEditarDoente.setVisible(true);
                
                txtCodDoente.setText("");
                txtNome.setText("");
                txtLocalidade.setText("");
                boxCama.setSelectedItem("Selecione uma opção");
           
                
            }else {
                JOptionPane.showMessageDialog(null, "Já existe um doente com este código!", "ERRO", JOptionPane.ERROR_MESSAGE);

            }
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Não preencheu todos os campos!", "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (CamasIndisponiveis ex) {
             Logger.getLogger(ListaDoentes.class.getName()).log(Level.SEVERE, null, ex);
         }
        serializacao.guardar(sistema);
    }//GEN-LAST:event_btnGuardarAddMouseClicked

    private void btnConfirmarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfirmarMouseClicked
        //remover estado dos doentes
        panelDarAlta.setVisible(false);
        
        DefaultTableModel modelo = (DefaultTableModel)tableDoentes.getModel();
        
        String camasEnfermaria = (String) boxCama.getSelectedItem();
        
         String codigoDoente = (String) tableDoentes.getValueAt(tableDoentes.getSelectedRow(), 0);
         
         Doente doente = sistema.getListaHospital().getCodHospital(sistema.getMedicoLigado().getHospitalOndeTrabalha().getCodigo()).getListaDoentes().getDoente(codigoDoente);
        
         SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
            String data = dFormat.format(calendarioSaida.getDate());

            
        
        for(int i=0;i<sistema.getListaHospital().getCodHospital(sistema.getMedicoLigado().getHospitalOndeTrabalha().getCodigo()).getListaDoentes().sizeDoentes();i++){
            if(codigoDoente.equals(sistema.getListaHospital().getCodHospital(sistema.getMedicoLigado().getHospitalOndeTrabalha().getCodigo()).getListaDoentes().getDoentesByIndex(i).getCodigoDoen())){
                try {
                    sistema.getListaHospital().getCodHospital(sistema.getMedicoLigado().getHospitalOndeTrabalha().getCodigo()).getListaEnfermaria().getEnfermaria(sistema.getMedicoLigado().getEnfTrab().getCodigoEnf()).desocuparCama(camasEnfermaria);
                } catch (CamasIndisponiveis ex) {
                    Logger.getLogger(ListaDoentes.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                modelo.removeRow(tableDoentes.getSelectedRow());
                sistema.getListaHospital().getCodHospital(sistema.getMedicoLigado().getHospitalOndeTrabalha().getCodigo()).getListaDoentes().removerDoente(sistema.getListaHospital().getCodHospital(sistema.getMedicoLigado().getHospitalOndeTrabalha().getCodigo()).getListaDoentes().getDoentesByIndex(i));
            
                }
        }
        serializacao.guardar(sistema); 
        
        panelEditarDoente.setVisible(true);
        
    }//GEN-LAST:event_btnConfirmarMouseClicked

    private void btnAddDoenteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddDoenteMouseClicked
        panelAdd.setVisible(true);
        panelDarAlta.setVisible(false);
        panelEditarDoente.setVisible(false);
        
    }//GEN-LAST:event_btnAddDoenteMouseClicked

    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
        panelAdd.setVisible(false);
        panelEditarDoente.setVisible(true);
        
        txtNome.setText("");
        txtCodDoente.setText("");
        txtLocalidade.setText("");
    }//GEN-LAST:event_btnCancelarMouseClicked

    private void btnEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarMouseClicked
       //editar estado dos doentes
        panelEditarDados.setVisible(false);
        
        String estado = (String) boxAlterarEstado.getSelectedItem();

            System.out.println(estado);
        
            Doente doente = sistema.getListaHospital().getCodHospital(sistema.getMedicoLigado().getHospitalOndeTrabalha().getCodigo()).getListaDoentes().getDoente(codigoDoen);
            doente.setEstado(estado);
         
                        
            modelo.removeRow(linha);
            modelo.addRow(new Object[]{codigoDoen, nomeDoen, localidadeDoen,enferColocado, estado, dataEntrada});
  
            
            btnAddDoente.setVisible(true);
            btnEditar.setVisible(true);
            btnDarAlta.setVisible(true);
                
        serializacao.guardar(sistema);
       
    }//GEN-LAST:event_btnEditarMouseClicked

    private void boxCamaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boxCamaMouseClicked
        //adicionar elementos na combobox da cama
        modelCamas.removeAllElements();

        for (int o=0; o<sistema.getListaHospital().getCodHospital(sistema.getMedicoLigado().getHospitalOndeTrabalha().getCodigo()).getListaEnfermaria().getEnfermaria(sistema.getMedicoLigado().getEnfTrab().getCodigoEnf()).sizeCamasDesocupadas(); o++) {
            modelCamas.addElement(sistema.getListaHospital().getCodHospital(sistema.getMedicoLigado().getHospitalOndeTrabalha().getCodigo()).getListaEnfermaria().getEnfermaria(sistema.getMedicoLigado().getEnfTrab().getCodigoEnf()).getCamasDesocupadasByIndex(o));
        }
    }//GEN-LAST:event_boxCamaMouseClicked

    private void tableDoentesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDoentesMouseClicked
       //selecionar linha na tabela
        linha = tableDoentes.getSelectedRow();
    }//GEN-LAST:event_tableDoentesMouseClicked

    private void txtPesquisarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPesquisarMouseClicked
        txtPesquisar.setText("");
    }//GEN-LAST:event_txtPesquisarMouseClicked

    private void txtPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisarKeyReleased
        //pesquisar na tabela
        String searchdoen = txtPesquisar.getText();
        filterDoen(searchdoen);
    }//GEN-LAST:event_txtPesquisarKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxAlterarEstado;
    private javax.swing.JComboBox<String> boxCama;
    private javax.swing.JComboBox<String> boxEstado;
    private javax.swing.JButton btnAddDoente;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnDarAlta;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEditarDoente;
    private javax.swing.JButton btnGuardarAdd;
    private com.toedter.calendar.JDateChooser calendario;
    private com.toedter.calendar.JDateChooser calendarioSaida;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCama;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblEstado1;
    private javax.swing.JPanel panelAdd;
    private javax.swing.JPanel panelDarAlta;
    private javax.swing.JPanel panelEditarDados;
    private javax.swing.JPanel panelEditarDoente;
    private javax.swing.JTable tableDoentes;
    private javax.swing.JTextField txtCodDoente;
    private javax.swing.JTextField txtLocalidade;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPesquisar;
    // End of variables declaration//GEN-END:variables
}
