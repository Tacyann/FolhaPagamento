/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Cargo;
import model.Funcionario;
import model.Telefone;
import model.FolhaDePagamento;

/**
 *
 * @author Tacyrose
 */
public class Principal extends javax.swing.JFrame {

    ArrayList<Cargo> ListaCargo;
    ArrayList<Funcionario> ListaFunc;
    String modoCargo;
    String modoFunc;

    public void LoadTableCarg() {

        DefaultTableModel modelo = new DefaultTableModel(new Object[]{"Código", "Nome"}, 0);

        //Pecorrer a minha lista de Cargos
        for (int i = 0; i < ListaCargo.size(); i++) {
            //modelo.addRow(new Object[] {ListaCargo.get(i).getCodigo(), ListaCargo.get(i).getNome()});
            Object linha[] = new Object[]{ListaCargo.get(i).getCodigo(),
                ListaCargo.get(i).getNome()};
            modelo.addRow(linha);
        }

        tbl_cargos.setModel(modelo);// estrutura da tabela as linhas.
        tbl_cargos.getColumnModel().getColumn(0).setPreferredWidth(50);
        tbl_cargos.getColumnModel().getColumn(1).setPreferredWidth(200);

        LoadCBCarg();
    }

    public void LoadTableFunc() {

        DefaultTableModel modelo = new DefaultTableModel(new Object[]{"CPF", "Nome", "Cargo"}, 0);

        //Pecorrer a minha lista de Cargos
        for (int i = 0; i < ListaFunc.size(); i++) {
            //modelo.addRow(new Object[] {ListaCargo.get(i).getCodigo(), ListaCargo.get(i).getNome()});
            Object linha[] = new Object[]{ListaFunc.get(i).getCpf(),
                ListaFunc.get(i).getNome(),
                ListaFunc.get(i).getCargo().getNome()};
            modelo.addRow(linha);
        }

        tbl_funcionarios.setModel(modelo);// estrutura da tabela as linhas.
        tbl_funcionarios.getColumnModel().getColumn(0).setPreferredWidth(50);
        tbl_funcionarios.getColumnModel().getColumn(1).setPreferredWidth(200);
        tbl_funcionarios.getColumnModel().getColumn(2).setPreferredWidth(100);

        LoadCBCarg();
    }

    view.FolhaDePagamento folhaDePagamento;

    public void LoadTableFolha() {

//        int index = tbl_funcionarios.getSelectedRow();
        model.FolhaDePagamento ff = ListaFunc.get(indexFuncionario).getFolha();
            
        folhaDePagamento = new view.FolhaDePagamento();
        folhaDePagamento.setVisible(true);
        folhaDePagamento.LoadTableFolha(ff);

    }

    public void LoadCBCarg() {

        cb_func_cargos.removeAllItems();
        cb_func_cargos.addItem("Selecione");
        for (int i = 0; i < ListaCargo.size(); i++) {
            cb_func_cargos.addItem(ListaCargo.get(i).getNome());
        }
    }

    /**
     * Creates new form Principal
     */
    public Principal() {

        initComponents();
        setLocationRelativeTo(null);
        ListaCargo = new ArrayList();
        ListaFunc = new ArrayList();
        modoCargo = "Navegar";
        modoFunc = "Navegar";
        ManipulaInterfaceCargo();
        ManipulaInterfaceFunc();
    }

    public void ManipulaInterfaceCargo() {
        switch (modoCargo) {
            case "Navegar":
                btn_cargo_salvar.setEnabled(false);
                btn_cargo_cancelar.setEnabled(false);
                c_cargo_codigo.setEnabled(false);
                c_cargo_nome.setEnabled(false);
                btn_cargo_novo.setEnabled(true);
                btn_cargo_editar.setEnabled(false);
                btn_cargo_excluir.setEnabled(false);
                break;

            case "Novo":
                btn_cargo_salvar.setEnabled(true);
                btn_cargo_cancelar.setEnabled(true);
                c_cargo_codigo.setEnabled(true);
                c_cargo_nome.setEnabled(true);
                btn_cargo_novo.setEnabled(false);
                btn_cargo_editar.setEnabled(false);
                btn_cargo_excluir.setEnabled(false);
                break;

            case "Editar":
                btn_cargo_salvar.setEnabled(true);
                btn_cargo_cancelar.setEnabled(true);
                c_cargo_codigo.setEnabled(true);
                c_cargo_nome.setEnabled(true);
                btn_cargo_novo.setEnabled(false);
                btn_cargo_editar.setEnabled(false);
                btn_cargo_excluir.setEnabled(false);
                break;

            case "Excluir":
                btn_cargo_salvar.setEnabled(false);
                btn_cargo_cancelar.setEnabled(false);
                c_cargo_codigo.setEnabled(false);
                c_cargo_nome.setEnabled(false);
                btn_cargo_novo.setEnabled(true);
                btn_cargo_editar.setEnabled(false);
                btn_cargo_excluir.setEnabled(false);
                break;

            case "Selecao":
                btn_cargo_salvar.setEnabled(false);
                btn_cargo_cancelar.setEnabled(false);
                c_cargo_codigo.setEnabled(false);
                c_cargo_nome.setEnabled(false);
                btn_cargo_novo.setEnabled(true);
                btn_cargo_editar.setEnabled(true);
                btn_cargo_excluir.setEnabled(true);
                break;

            default:
                System.out.println("Modo Invalido");
        }

    }

    public void ManipulaInterfaceFunc() {

        switch (modoFunc) {
            case "Navegar":
                btn_func_salvar.setEnabled(false);
                btn_func_cancelar.setEnabled(false);
                c_func_cpf.setEnabled(false);
                c_func_nome.setEnabled(false);
                c_func_bairro.setEnabled(false);
                c_func_num.setEnabled(false);
                c_func_cep1.setEnabled(false);
                c_func_data.setEnabled(false);
                c_func_rg.setEnabled(false);
                c_func_tel.setEnabled(false);
                c_func_end.setEnabled(false);
                c_func_salbruto.setEnabled(false);
                c_func_salplus.setEditable(false);
                cb_func_cargos.setEnabled(false);
                btn_func_novo.setEnabled(true);
                btn_func_folhapagamento.setEnabled(false);
                btn_func_edit.setEnabled(false);
                btn_func_excluir.setEnabled(false);

                break;

            case "Novo":
                btn_func_salvar.setEnabled(true);
                btn_func_cancelar.setEnabled(true);
                c_func_cpf.setEnabled(true);
                c_func_nome.setEnabled(true);
                c_func_bairro.setEnabled(true);
                c_func_num.setEnabled(true);
                c_func_cep1.setEnabled(true);
                c_func_data.setEnabled(true);
                c_func_rg.setEnabled(true);
                c_func_tel.setEnabled(true);
                c_func_end.setEnabled(true);
                c_func_salbruto.setEnabled(true);
                c_func_salplus.setEditable(true);
                cb_func_cargos.setEnabled(true);
                btn_func_novo.setEnabled(false);
                btn_func_folhapagamento.setEnabled(false);
                btn_func_edit.setEnabled(false);
                btn_func_excluir.setEnabled(false);
                break;

            case "Editar":
                btn_func_salvar.setEnabled(true);
                btn_func_cancelar.setEnabled(true);
                c_func_cpf.setEnabled(true);
                c_func_nome.setEnabled(true);
                c_func_bairro.setEnabled(true);
                c_func_num.setEnabled(true);
                c_func_cep1.setEnabled(true);
                c_func_data.setEnabled(true);
                c_func_rg.setEnabled(true);
                c_func_tel.setEnabled(true);
                c_func_end.setEnabled(true);
                c_func_salbruto.setEnabled(true);
                c_func_salplus.setEditable(true);
                cb_func_cargos.setEnabled(true);
                btn_func_novo.setEnabled(false);
                btn_func_folhapagamento.setEnabled(false);
                btn_func_edit.setEnabled(false);
                btn_func_excluir.setEnabled(false);
                break;

            case "Excluir":
                btn_func_salvar.setEnabled(false);
                btn_func_cancelar.setEnabled(false);
                c_func_cpf.setEnabled(false);
                c_func_nome.setEnabled(false);
                c_func_bairro.setEnabled(false);
                c_func_num.setEnabled(false);
                c_func_cep1.setEnabled(false);
                c_func_data.setEnabled(false);
                c_func_rg.setEnabled(false);
                c_func_tel.setEnabled(false);
                c_func_end.setEnabled(false);
                c_func_salbruto.setEnabled(false);
                c_func_salplus.setEditable(false);
                cb_func_cargos.setEnabled(false);
                btn_func_novo.setEnabled(true);
                btn_func_folhapagamento.setEnabled(false);
                btn_func_edit.setEnabled(false);
                btn_func_excluir.setEnabled(false);
                break;

            case "Selecao":
                btn_func_salvar.setEnabled(false);
                btn_func_cancelar.setEnabled(false);
                c_func_cpf.setEnabled(false);
                c_func_nome.setEnabled(false);
                c_func_bairro.setEnabled(false);
                c_func_num.setEnabled(false);
                c_func_cep1.setEnabled(false);
                c_func_data.setEnabled(false);
                c_func_rg.setEnabled(false);
                c_func_tel.setEnabled(false);
                c_func_end.setEnabled(false);
                c_func_salbruto.setEnabled(false);
                c_func_salplus.setEditable(false);
                cb_func_cargos.setEnabled(false);
                btn_func_novo.setEnabled(true);
                btn_func_edit.setEnabled(true);
                btn_func_folhapagamento.setEnabled(true);
                btn_func_excluir.setEnabled(true);
                break;

            default:
                System.out.println("Modo Invalido");
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_cargos = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        c_cargo_codigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        c_cargo_nome = new javax.swing.JTextField();
        btn_cargo_salvar = new javax.swing.JButton();
        btn_cargo_cancelar = new javax.swing.JButton();
        btn_cargo_novo = new javax.swing.JButton();
        btn_cargo_editar = new javax.swing.JButton();
        btn_cargo_excluir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        c_func_nome = new javax.swing.JTextField();
        btn_func_salvar = new javax.swing.JButton();
        btn_func_cancelar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        c_func_rg = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        c_func_end = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        c_func_num = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        c_func_bairro = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        c_func_data = new javax.swing.JFormattedTextField();
        c_func_cpf = new javax.swing.JFormattedTextField();
        c_func_tel = new javax.swing.JFormattedTextField();
        c_func_salbruto = new javax.swing.JFormattedTextField();
        jLabel12 = new javax.swing.JLabel();
        cb_func_cargos = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        c_func_salplus = new javax.swing.JTextField();
        btn_func_folhapagamento = new javax.swing.JButton();
        c_func_cep1 = new javax.swing.JFormattedTextField();
        btn_func_novo = new javax.swing.JButton();
        btn_func_edit = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_funcionarios = new javax.swing.JTable();
        btn_func_excluir = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbl_cargos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_cargos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_cargosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_cargos);
        if (tbl_cargos.getColumnModel().getColumnCount() > 0) {
            tbl_cargos.getColumnModel().getColumn(0).setPreferredWidth(50);
            tbl_cargos.getColumnModel().getColumn(1).setPreferredWidth(200);
        }

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Cargos"));

        jLabel1.setText("Código :");

        c_cargo_codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_cargo_codigoActionPerformed(evt);
            }
        });

        jLabel2.setText("Nome :");

        c_cargo_nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_cargo_nomeActionPerformed(evt);
            }
        });

        btn_cargo_salvar.setText("Salvar");
        btn_cargo_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cargo_salvarActionPerformed(evt);
            }
        });

        btn_cargo_cancelar.setText("Cancelar");
        btn_cargo_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cargo_cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(c_cargo_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addGap(6, 6, 6)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btn_cargo_salvar)
                                .addGap(90, 90, 90)
                                .addComponent(btn_cargo_cancelar))
                            .addComponent(c_cargo_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(c_cargo_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(c_cargo_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cargo_salvar)
                    .addComponent(btn_cargo_cancelar)))
        );

        btn_cargo_novo.setText("Novo");
        btn_cargo_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cargo_novoActionPerformed(evt);
            }
        });

        btn_cargo_editar.setText("Editar");
        btn_cargo_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cargo_editarActionPerformed(evt);
            }
        });

        btn_cargo_excluir.setText("Excluir");
        btn_cargo_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cargo_excluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_cargo_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 414, Short.MAX_VALUE)
                        .addComponent(btn_cargo_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(302, 302, 302)
                        .addComponent(btn_cargo_excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cargo_novo)
                    .addComponent(btn_cargo_editar)
                    .addComponent(btn_cargo_excluir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Cargos", jPanel1);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Funcionarios"));

        jLabel3.setText("CPF:");

        jLabel4.setText("Nome :");

        c_func_nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_func_nomeActionPerformed(evt);
            }
        });

        btn_func_salvar.setText("Salvar");
        btn_func_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_func_salvarActionPerformed(evt);
            }
        });

        btn_func_cancelar.setText("Cancelar");
        btn_func_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_func_cancelarActionPerformed(evt);
            }
        });

        jLabel5.setText("RG :");

        jLabel6.setText("Endereço :");

        jLabel7.setText("Telefone :");

        jLabel8.setText("Data de Nascimento :");

        jLabel9.setText("Número :");

        jLabel10.setText("Bairro : ");

        c_func_bairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_func_bairroActionPerformed(evt);
            }
        });

        jLabel11.setText("CEP :");

        try {
            c_func_data.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            c_func_cpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            c_func_tel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        c_func_salbruto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        jLabel12.setText("Cargo :");

        cb_func_cargos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_func_cargosActionPerformed(evt);
            }
        });

        jLabel13.setText("Salario Bruto:");

        jLabel14.setText("Salario Plus :");

        btn_func_folhapagamento.setText("Exibir Folha Pagamento");
        btn_func_folhapagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_func_folhapagamentoActionPerformed(evt);
            }
        });

        try {
            c_func_cep1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(115, 115, 115)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(c_func_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel5))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(c_func_end, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(c_func_num, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel10)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(c_func_rg, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                                    .addComponent(c_func_bairro))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(c_func_data, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel11)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(c_func_salbruto, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(199, 199, 199)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(c_func_tel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cb_func_cargos, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel13)
                        .addGap(147, 147, 147)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(c_func_salplus)))
                .addGap(10, 10, 10))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_func_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(btn_func_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(btn_func_folhapagamento))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(c_func_cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(546, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(731, 731, 731)
                    .addComponent(c_func_cep1)
                    .addContainerGap()))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(c_func_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(c_func_rg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel3)
                    .addComponent(c_func_data, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c_func_cpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(c_func_end, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(c_func_num, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(c_func_bairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(c_func_tel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(cb_func_cargos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(c_func_salplus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c_func_salbruto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_func_cancelar)
                    .addComponent(btn_func_salvar)
                    .addComponent(btn_func_folhapagamento))
                .addContainerGap(29, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(83, 83, 83)
                    .addComponent(c_func_cep1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(113, Short.MAX_VALUE)))
        );

        btn_func_novo.setText("Novo");
        btn_func_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_func_novoActionPerformed(evt);
            }
        });

        btn_func_edit.setText("Editar");
        btn_func_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_func_editActionPerformed(evt);
            }
        });

        tbl_funcionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CPF", "Nome", "Cargo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_funcionarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_funcionariosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_funcionarios);
        if (tbl_funcionarios.getColumnModel().getColumnCount() > 0) {
            tbl_funcionarios.getColumnModel().getColumn(0).setPreferredWidth(50);
            tbl_funcionarios.getColumnModel().getColumn(1).setPreferredWidth(200);
            tbl_funcionarios.getColumnModel().getColumn(2).setPreferredWidth(100);
        }

        btn_func_excluir.setText("Excluir");
        btn_func_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_func_excluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btn_func_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(262, 262, 262)
                                .addComponent(btn_func_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_func_excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_func_edit)
                    .addComponent(btn_func_novo)
                    .addComponent(btn_func_excluir))
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Funcionarios", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void c_cargo_codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_cargo_codigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_cargo_codigoActionPerformed

    private void btn_cargo_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cargo_novoActionPerformed

        c_cargo_codigo.setText("");
        c_cargo_nome.setText("");

        modoCargo = "Novo";
        ManipulaInterfaceCargo();


    }//GEN-LAST:event_btn_cargo_novoActionPerformed

    private void c_cargo_nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_cargo_nomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_cargo_nomeActionPerformed

    private void btn_cargo_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cargo_cancelarActionPerformed
        c_cargo_codigo.setText("");
        c_cargo_nome.setText("");

        modoCargo = "Navegar";
        ManipulaInterfaceCargo();
    }//GEN-LAST:event_btn_cargo_cancelarActionPerformed

    private void btn_cargo_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cargo_salvarActionPerformed
        int cod = Integer.parseInt(c_cargo_codigo.getText());
        if (modoCargo.equals("Novo")) {
            Cargo C = new Cargo(cod, c_cargo_nome.getText());
            ListaCargo.add(C);
        } else if (modoCargo.equals("Editar")) {
            int index = tbl_cargos.getSelectedRow();
            ListaCargo.get(index).setCodigo(cod);
            ListaCargo.get(index).setNome(c_cargo_nome.getText());
        }
        LoadTableCarg();
        modoCargo = "Navegar";
        ManipulaInterfaceCargo();;
        c_cargo_codigo.setText("");
        c_cargo_nome.setText("");
    }//GEN-LAST:event_btn_cargo_salvarActionPerformed

    private void tbl_cargosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_cargosMouseClicked
        int index = tbl_cargos.getSelectedRow();
        if (index >= 0 && index < ListaCargo.size()) {
            Cargo C = ListaCargo.get(index);
            c_cargo_codigo.setText(String.valueOf(C.getCodigo()));
            c_cargo_nome.setText(C.getNome());
            modoCargo = "Selecao";
            ManipulaInterfaceCargo();
        }
    }//GEN-LAST:event_tbl_cargosMouseClicked

    private void btn_cargo_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cargo_editarActionPerformed
        modoCargo = "Editar";
        ManipulaInterfaceCargo();
    }//GEN-LAST:event_btn_cargo_editarActionPerformed

    private void btn_cargo_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cargo_excluirActionPerformed
        int index = tbl_cargos.getSelectedRow();
        if (index >= 0 && index < ListaCargo.size()) {
            Cargo C = ListaCargo.get(index);
            ListaCargo.remove(index);
        }
        LoadTableCarg();
        modoCargo = "Navegar";
        ManipulaInterfaceCargo();
    }//GEN-LAST:event_btn_cargo_excluirActionPerformed

    private void c_func_nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_func_nomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_func_nomeActionPerformed

    private void btn_func_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_func_salvarActionPerformed

        int index = cb_func_cargos.getSelectedIndex();
        if (index == -1 || cb_func_cargos.getSelectedItem().equals("Selecione")) {
            JOptionPane.showMessageDialog(this, "Você deve selecionar um cargo");
        } else {
            Funcionario F = new Funcionario();
            //F.setCpf(Integer.parseInt(c_func_cpf.getText()));  
            F.setCpf(c_func_cpf.getText());
            F.setNome((c_func_nome.getText()));
            F.setRg((c_func_rg.getText()));
            F.setEndereco(c_func_end.getText(), c_func_num.getText(), c_func_bairro.getText(), c_func_cep1.getText());
            Telefone telefone = new Telefone();
            telefone.setTelefone(c_func_tel.getText());
            F.setTelefone(telefone);
            F.setData_nasc((c_func_data.getText()));
            F.setCargo(ListaCargo.get(index - 1));
            FolhaDePagamento ff = new FolhaDePagamento();
            if (c_func_salbruto.getText() != null && !c_func_salbruto.getText().isEmpty()) {
                ff.setSalariobruto(Double.parseDouble(c_func_salbruto.getText().replace(".", "").replace(",", ".")));
            }
            if (c_func_salplus.getText() != null && !c_func_salplus.getText().isEmpty()) {
                ff.setPlussalario(Double.parseDouble(c_func_salplus.getText().replace(".", "").replace(",", ".")));
            }
            F.setFolha(ff);

            ListaFunc.add(F);
            ListaCargo.get(index - 1).AddFunc(F);
        }

        LoadTableFunc();

        ManipulaInterfaceFunc();
        modoFunc = "Navegar";

        c_func_cpf.setText(
                "");
        c_func_nome.setText(
                "");
        c_func_bairro.setText(
                "");
        c_func_num.setText(
                "");
        c_func_salbruto.setText(
                "");
        c_func_data.setText(
                "");
        c_func_rg.setText(
                "");
        c_func_tel.setText(
                "");
        c_func_end.setText(
                "");
        c_func_salplus.setText(
                "");

    }//GEN-LAST:event_btn_func_salvarActionPerformed

    private void btn_func_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_func_cancelarActionPerformed
        c_func_cpf.setText("");
        c_func_nome.setText("");
        c_func_bairro.setText("");
        c_func_num.setText("");
        c_func_salbruto.setText("");
        c_func_data.setText("");
        c_func_rg.setText("");
        c_func_tel.setText("");
        c_func_end.setText("");
        c_func_salbruto.setText("");
        c_func_salplus.setText("");

        modoFunc = "Navegar";
        ManipulaInterfaceFunc();
    }//GEN-LAST:event_btn_func_cancelarActionPerformed

    private void c_func_bairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_func_bairroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_func_bairroActionPerformed

    Integer indexFuncionario;
    private void tbl_funcionariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_funcionariosMouseClicked

        int index = tbl_funcionarios.getSelectedRow();
        indexFuncionario = index;
        if (index >= 0 && index < ListaFunc.size()) {
            Funcionario F = ListaFunc.get(index);
        }
        LoadTableFunc();
        modoFunc = "Selecao";
        ManipulaInterfaceFunc();

    }//GEN-LAST:event_tbl_funcionariosMouseClicked

    private void btn_func_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_func_novoActionPerformed
        c_func_cpf.setText("");
        c_func_nome.setText("");
        c_func_bairro.setText("");
        c_func_num.setText("");
        c_func_salbruto.setText("");
        c_func_data.setText("");
        c_func_rg.setText("");
        c_func_tel.setText("");
        c_func_end.setText("");
        c_func_salbruto.setText("");
        c_func_salplus.setText("");

        modoFunc = "Novo";
        ManipulaInterfaceFunc();
    }//GEN-LAST:event_btn_func_novoActionPerformed

    private void btn_func_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_func_editActionPerformed
        modoFunc = "Editar";
        
        Funcionario fun = ListaFunc.get(indexFuncionario);
        c_func_cpf.setText(fun.getCpf());
        c_func_nome.setText(fun.getNome());
        c_func_bairro.setText(fun.getEndereco().getBairro());
        c_func_num.setText(fun.getEndereco().getNumero());
        c_func_data.setText(fun.getData_nasc());
        c_func_rg.setText(fun.getRg());
        c_func_tel.setText(fun.getTelefone().getTelefone());
        c_func_end.setText(fun.getEndereco().getEndereco());
        c_func_salbruto.setText(String.valueOf(fun.getFolha().getSalariobruto()));
        c_func_salplus.setText(String.valueOf(fun.getFolha().getPlussalario()));
        ManipulaInterfaceFunc();
    }//GEN-LAST:event_btn_func_editActionPerformed

    private void cb_func_cargosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_func_cargosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_func_cargosActionPerformed

    private void btn_func_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_func_excluirActionPerformed

        int index = tbl_funcionarios.getSelectedRow();
        if (index >= 0 && index < ListaFunc.size()) {
            Funcionario f = ListaFunc.get(index);
            ListaFunc.remove(index);
        }
        LoadTableCarg();
        modoFunc = "Navegar";
        ManipulaInterfaceFunc();
    }//GEN-LAST:event_btn_func_excluirActionPerformed

    FolhaDePagamento folha;

    private void btn_func_folhapagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_func_folhapagamentoActionPerformed
        LoadTableFolha();
        modoFunc = "Navegar";
        ManipulaInterfaceFunc();
    }//GEN-LAST:event_btn_func_folhapagamentoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cargo_cancelar;
    private javax.swing.JButton btn_cargo_editar;
    private javax.swing.JButton btn_cargo_excluir;
    private javax.swing.JButton btn_cargo_novo;
    private javax.swing.JButton btn_cargo_salvar;
    private javax.swing.JButton btn_func_cancelar;
    private javax.swing.JButton btn_func_edit;
    private javax.swing.JButton btn_func_excluir;
    private javax.swing.JButton btn_func_folhapagamento;
    private javax.swing.JButton btn_func_novo;
    private javax.swing.JButton btn_func_salvar;
    private javax.swing.JTextField c_cargo_codigo;
    private javax.swing.JTextField c_cargo_nome;
    private javax.swing.JTextField c_func_bairro;
    private javax.swing.JFormattedTextField c_func_cep1;
    private javax.swing.JFormattedTextField c_func_cpf;
    private javax.swing.JFormattedTextField c_func_data;
    private javax.swing.JTextField c_func_end;
    private javax.swing.JTextField c_func_nome;
    private javax.swing.JTextField c_func_num;
    private javax.swing.JTextField c_func_rg;
    private javax.swing.JFormattedTextField c_func_salbruto;
    private javax.swing.JTextField c_func_salplus;
    private javax.swing.JFormattedTextField c_func_tel;
    private javax.swing.JComboBox<String> cb_func_cargos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable tbl_cargos;
    private javax.swing.JTable tbl_funcionarios;
    // End of variables declaration//GEN-END:variables
}
