/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.repuestostorres.invmanager.view;

import com.repuestostorres.invmanager.daoimpl.productDao;
import com.repuestostorres.invmanager.model.Product;
import com.repuestostorres.invmanager.model.ProductRecord;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Diego
 */
public class FrmInventory extends javax.swing.JFrame {

    /**
     * Creates new form FrmInventory
     */
    public FrmInventory() {
        initComponents();
        allDemo.addColumn("ID");
        allDemo.addColumn("Nombre");
        allDemo.addColumn("Marca");
        allDemo.addColumn("Tipe");
        allDemo.addColumn("Precio");
        allDemo.addColumn("Existencia");
        totalDemo.addColumn("Nombre");
        totalDemo.addColumn("Marca");
        totalDemo.addColumn("Subtotal");
        statsDemo.addColumn("Nombre");
        statsDemo.addColumn("Marca");
        statsDemo.addColumn("Tipo registro");
        statsDemo.addColumn("cantidad");
        statsDemo.addColumn("Precio");
        statsDemo.addColumn("Subtotal");
        this.allProductsTable.setModel(allDemo);
        this.editStock.setEnabled(false);
    }

    //Data structures
    HashMap<String, Product> allProducts = new HashMap<>();
    DefaultTableModel allDemo = new DefaultTableModel(); 
    DefaultTableModel totalDemo = new DefaultTableModel();
    DefaultTableModel statsDemo = new DefaultTableModel();
    ArrayList<ProductRecord> productRecords = new ArrayList<>();
    Product currentProduct = null;
    boolean saveFlowRecord = false;
    productDao productDao = new productDao();
    
    //Functions
    
    public String generateId() {
        boolean flag = true;
        String id = "";
        String[] letters = {"D", "B", "C", "D", "E", "F", "G", "H", "I"};
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for(int i = 0; i < 5; i++) {
            int rand = (int)(Math.random() * 9);
            if(flag) {
                flag = false;
                id += letters[rand];
            } else {
                flag = true;
                id += numbers[rand];
            }
        }
        return id;
    }
    
    public Product getProduct(boolean isNew) {
        String id;
        if(isNew){
            id = generateId();
        } else id = currentProduct.getId();
        String name = this.nameTextField.getText();
        String cat = this.catTextField.getText();
        String brand = this.brandTextField.getText();
        float price = Float.parseFloat(this.priceTextField.getText());
        int stock = Integer.parseInt(this.stockTextField.getText());
        Product product = new Product(id, name, brand, cat, price, stock);
        return product;
    }
    
    public int getAmountOfProducts() {
        return allProducts.size();
    }
    
    public float getAmountInDollars() {
        float total = 0;
        for(Product product : allProducts.values()) {
            total += product.calculateSubtotal();
        }
        return total;
    }
    
    public void refreshTable() {
        allDemo.setRowCount(0);
        for(Product product : allProducts.values()) {
            allDemo.addRow(new Object[] {
                product.getId(),
                product.getName(),
                product.getBrand(),
                product.getType(),
                Float.toString(product.getPrice()),
                Integer.toString(product.getStock())
            });
        }
        this.allProductsTable.setModel(allDemo);
    }
    
    public void refreshSubtotalTable() {
        totalDemo.setRowCount(0);
        for(Product product : allProducts.values()) {
            totalDemo.addRow(new Object[] {
                product.getName(),
                product.getBrand(),
                product.calculateSubtotal()
            });
        }
        this.subtotalTable.setModel(totalDemo);
        this.amountPane.setText(Integer.toString(getAmountOfProducts()));
        this.amountInDollarsPane.setText(Float.toString(getAmountInDollars()));
    }
    
    public void refreshRecordTable() {
        statsDemo.setRowCount(0);
        for(ProductRecord productRecord : productRecords) {
            statsDemo.addRow(new Object[] {
                productRecord.getName(),
                productRecord.getBrand(),
                productRecord.getRecordType(),
                productRecord.getNumberOfProducts(),
                productRecord.getPrice(),
                productRecord.calculateTotal()
            });
        }
        this.productRecordsTable.setModel(statsDemo);
    }
    
    public void clean() {
        this.nameTextField.setText("");
        this.catTextField.setText("");
        this.brandTextField.setText("");
        this.priceTextField.setText("");
        this.stockTextField.setText("");
        this.nameTextField.requestFocus();
    }
    
    public void loadDataToForm(String id) {
        currentProduct = allProducts.get(id);
        this.nameTextField.setText(currentProduct.getName());
        this.brandTextField.setText(currentProduct.getBrand());
        this.catTextField.setText(currentProduct.getType());
        this.priceTextField.setText(Float.toString(
                currentProduct.getPrice()
        ));
        this.stockTextField.setText(Integer.toString(currentProduct.getStock()));
        productsTabbedPane.setSelectedIndex(0);
    }
    
    public ProductRecord getDataforRecord() {
        String name = this.nameTextField.getText();
        String brand = this.brandTextField.getText();
        String recordType;
        while(true) {
            recordType = JOptionPane.showInputDialog("In or Out");
            if(recordType.toUpperCase().equals("IN") || recordType.toUpperCase()
                    .equals("OUT")) break;
        }
        int amount;
        int currentAmount;
        if(recordType.equals("out")) {
            while(true) {
                amount = Integer.parseInt(JOptionPane.showInputDialog("Amount of "
                    + "products + or -"));
                currentAmount = Integer.parseInt(this.stockTextField.getText());
                currentAmount -= amount;
                if(currentAmount > 0) {
                    this.stockTextField.setText(Integer.toString(currentAmount));
                    break;
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid amount of products");
                }
            }
        } else {
            amount = Integer.parseInt(JOptionPane.showInputDialog("Amount of "
                    + "products + or -"));
            currentAmount = Integer.parseInt(this.stockTextField.getText()) +
                    amount;
            this.stockTextField.setText(Integer.toString(currentAmount));
        }
        float price = Float.parseFloat(this.priceTextField.getText());
        ProductRecord pr = new ProductRecord(name, brand, recordType, 
                        amount, price);
        return pr;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        productsTabbedPane = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        newProduct = new javax.swing.JButton();
        saveLocally = new javax.swing.JButton();
        updateLocally = new javax.swing.JButton();
        deleteProduct = new javax.swing.JButton();
        saveToDatabase = new javax.swing.JButton();
        FlowRecords = new javax.swing.JButton();
        editStock = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        catTextField = new javax.swing.JTextField();
        brandTextField = new javax.swing.JTextField();
        stockTextField = new javax.swing.JTextField();
        priceTextField = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        allProductsTable = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        subtotalTable = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        amountPane = new javax.swing.JTextPane();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        amountInDollarsPane = new javax.swing.JTextPane();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        productRecordsTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 2, 36)); // NOI18N
        jLabel1.setText("Repuestos Torres");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/repuestostorres/invmanager/resources/icons/logo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        productsTabbedPane.setToolTipText("");

        jToolBar1.setRollover(true);

        newProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/repuestostorres/invmanager/resources/icons/new.png"))); // NOI18N
        newProduct.setToolTipText("Crear nuevo");
        newProduct.setFocusable(false);
        newProduct.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        newProduct.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        newProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newProductActionPerformed(evt);
            }
        });
        jToolBar1.add(newProduct);

        saveLocally.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/repuestostorres/invmanager/resources/icons/save.png"))); // NOI18N
        saveLocally.setToolTipText("Guardar");
        saveLocally.setFocusable(false);
        saveLocally.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        saveLocally.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        saveLocally.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveLocallyActionPerformed(evt);
            }
        });
        jToolBar1.add(saveLocally);

        updateLocally.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/repuestostorres/invmanager/resources/icons/update.png"))); // NOI18N
        updateLocally.setToolTipText("Actualizar");
        updateLocally.setFocusable(false);
        updateLocally.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        updateLocally.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        updateLocally.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateLocallyActionPerformed(evt);
            }
        });
        jToolBar1.add(updateLocally);

        deleteProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/repuestostorres/invmanager/resources/icons/delete.png"))); // NOI18N
        deleteProduct.setToolTipText("Eliminar");
        deleteProduct.setFocusable(false);
        deleteProduct.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        deleteProduct.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        deleteProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteProductActionPerformed(evt);
            }
        });
        jToolBar1.add(deleteProduct);

        saveToDatabase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/repuestostorres/invmanager/resources/icons/save_database.png"))); // NOI18N
        saveToDatabase.setToolTipText("Guardar en BD");
        saveToDatabase.setFocusable(false);
        saveToDatabase.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        saveToDatabase.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        saveToDatabase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveToDatabaseActionPerformed(evt);
            }
        });
        jToolBar1.add(saveToDatabase);

        FlowRecords.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/repuestostorres/invmanager/resources/icons/stat2.png"))); // NOI18N
        FlowRecords.setToolTipText("Crear registros");
        FlowRecords.setFocusable(false);
        FlowRecords.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        FlowRecords.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        FlowRecords.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FlowRecordsActionPerformed(evt);
            }
        });
        jToolBar1.add(FlowRecords);

        editStock.setText("Editar existencia");
        editStock.setFocusable(false);
        editStock.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        editStock.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        editStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editStockActionPerformed(evt);
            }
        });
        jToolBar1.add(editStock);

        jLabel3.setText("Nombre:");

        jLabel4.setText("Categoria:");

        jLabel5.setText("Marca:");

        jLabel6.setText("Existencia:");

        jLabel7.setText("Precio:");

        brandTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brandTextFieldActionPerformed(evt);
            }
        });

        stockTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(stockTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                            .addComponent(priceTextField)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                                        .addGap(40, 40, 40))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(32, 32, 32)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(catTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(brandTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(192, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(catTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(brandTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(stockTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(priceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        productsTabbedPane.addTab("Datos", new javax.swing.ImageIcon(getClass().getResource("/com/repuestostorres/invmanager/resources/icons/data.png")), jPanel2); // NOI18N

        allProductsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Marca", "Tipo", "Precio", "Existencia"
            }
        ));
        allProductsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                allProductsTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(allProductsTable);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 734, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        productsTabbedPane.addTab("Respuestos", new javax.swing.ImageIcon(getClass().getResource("/com/repuestostorres/invmanager/resources/icons/product.png")), jPanel3); // NOI18N

        subtotalTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Marca", "Subtotal"
            }
        ));
        subtotalTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                subtotalTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(subtotalTable);

        jLabel8.setText("Total amount of spare parts: ");

        jScrollPane3.setViewportView(amountPane);

        jLabel9.setText("Total amount in $: ");

        jScrollPane4.setViewportView(amountInDollarsPane);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(91, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(23, 23, 23)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(82, Short.MAX_VALUE))
        );

        productsTabbedPane.addTab("Total", new javax.swing.ImageIcon(getClass().getResource("/com/repuestostorres/invmanager/resources/icons/total.png")), jPanel4); // NOI18N

        productRecordsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Marca", "Tipo registro", "Cantidad", "Precio", "Subtotal"
            }
        ));
        jScrollPane5.setViewportView(productRecordsTable);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 734, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        productsTabbedPane.addTab("Entradas y salidas", new javax.swing.ImageIcon(getClass().getResource("/com/repuestostorres/invmanager/resources/icons/stats.png")), jPanel5); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(productsTabbedPane)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(productsTabbedPane)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void stockTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stockTextFieldActionPerformed

    private void brandTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brandTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_brandTextFieldActionPerformed

    private void newProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newProductActionPerformed
        clean();
        this.stockTextField.setEditable(true);
        this.editStock.setEnabled(false);
    }//GEN-LAST:event_newProductActionPerformed

    private void saveLocallyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveLocallyActionPerformed
        Product product = getProduct(true);
        allProducts.put(product.getId(), product);
        refreshTable();
        refreshSubtotalTable();
        JOptionPane.showMessageDialog(this, "Product succesfully saved", 
                "Product saved", JOptionPane.INFORMATION_MESSAGE);
        clean();
        this.stockTextField.setEditable(true); 
        this.editStock.setEnabled(false);
        this.saveLocally.setEnabled(true);
    }//GEN-LAST:event_saveLocallyActionPerformed

    private void deleteProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteProductActionPerformed
        int dialogResult = JOptionPane.showConfirmDialog(this, "Do you want to delete the product?", 
                "WARNING", JOptionPane.YES_NO_OPTION);
        if(dialogResult == JOptionPane.YES_OPTION) {
            allProducts.remove(currentProduct.getId());
            currentProduct = null;
            refreshTable();
            refreshSubtotalTable();
            JOptionPane.showMessageDialog(this, "Product successfully deleted", 
                    "Product deleted", JOptionPane.INFORMATION_MESSAGE);
            clean();
            this.stockTextField.setEditable(true);
            this.editStock.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(this, "Product not removed", 
                    "aborted", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }//GEN-LAST:event_deleteProductActionPerformed

    private void subtotalTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_subtotalTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_subtotalTableMouseClicked

    private void allProductsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_allProductsTableMouseClicked
        this.stockTextField.setEditable(false);
        this.saveLocally.setEnabled(false);
        this.editStock.setEnabled(true);
        DefaultTableModel model = (DefaultTableModel) allProductsTable.getModel();
        String id = (String) model.getValueAt(allProductsTable.getSelectedRow(), 0);
        loadDataToForm(id);
    }//GEN-LAST:event_allProductsTableMouseClicked

    private void updateLocallyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateLocallyActionPerformed
        if(saveFlowRecord) {
            ProductRecord pr = getDataforRecord();
            productRecords.add(pr);
            refreshRecordTable();
            saveFlowRecord = false;
        }
        Product product = getProduct(false);
        allProducts.put(currentProduct.getId(), product);
        refreshTable();
        refreshSubtotalTable();
        this.editStock.setEnabled(false);
        clean();
        JOptionPane.showMessageDialog(this, "Saved", "Updated successfully", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_updateLocallyActionPerformed

    private void FlowRecordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FlowRecordsActionPerformed
        saveFlowRecord = true;
        this.editStock.setEnabled(false);
        JOptionPane.showMessageDialog(this, "A record is about to be saved"
                + " Please update locally");
    }//GEN-LAST:event_FlowRecordsActionPerformed

    private void editStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editStockActionPerformed
        this.stockTextField.setEditable(true);
    }//GEN-LAST:event_editStockActionPerformed

    private void saveToDatabaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveToDatabaseActionPerformed
        for(Product product : allProducts.values()) {
            try {
                productDao.insertProduct(product);
            } catch (SQLException ex) {
                Logger.getLogger(FrmInventory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_saveToDatabaseActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmInventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmInventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmInventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmInventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmInventory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton FlowRecords;
    private javax.swing.JTable allProductsTable;
    private javax.swing.JTextPane amountInDollarsPane;
    private javax.swing.JTextPane amountPane;
    private javax.swing.JTextField brandTextField;
    private javax.swing.JTextField catTextField;
    private javax.swing.JButton deleteProduct;
    private javax.swing.JButton editStock;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JButton newProduct;
    private javax.swing.JTextField priceTextField;
    private javax.swing.JTable productRecordsTable;
    private javax.swing.JTabbedPane productsTabbedPane;
    private javax.swing.JButton saveLocally;
    private javax.swing.JButton saveToDatabase;
    private javax.swing.JTextField stockTextField;
    private javax.swing.JTable subtotalTable;
    private javax.swing.JButton updateLocally;
    // End of variables declaration//GEN-END:variables
}
