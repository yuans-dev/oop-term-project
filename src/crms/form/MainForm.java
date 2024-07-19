/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package crms.form;

import crms.lib.Car;
import crms.lib.CarInventory;
import crms.lib.RentalService;
import crms.lib.ReportViewModel;
import crms.lib.gui.RentDateVerifier;
import crms.lib.gui.ReportTableModel;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;

/**
 *
 * @author u1ben
 */
public class MainForm extends javax.swing.JFrame {

    private CarInventory carInventory;
    private RentalService rentalService;
    private ReportViewModel currentlySelectedReport;

    /**
     * Creates new form MainForm
     */
    public MainForm() {

        initComponents();
        modifyComponents();
        initializeDatabase();

        //save to disk before shutdown
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            carInventory.saveToDisk();
            rentalService.saveToDisk();
        }));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pnlRoot = new javax.swing.JPanel();
        pnlSide = new javax.swing.JPanel();
        space1 = new javax.swing.JPanel();
        title1 = new javax.swing.JLabel();
        title2 = new javax.swing.JLabel();
        space2 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        space3 = new javax.swing.JPanel();
        btnReg = new javax.swing.JButton();
        space4 = new javax.swing.JPanel();
        btnReg1 = new javax.swing.JButton();
        space5 = new javax.swing.JPanel();
        btnReg2 = new javax.swing.JButton();
        pnlCar = new javax.swing.JPanel();
        sideTab = new javax.swing.JTabbedPane();
        carInventoryControls = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        brandTextField_add = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        modelTextField_add = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        descriptionTextField_add = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        priceTextField_add = new javax.swing.JTextField();
        registerCarButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        idTextField_remove = new javax.swing.JTextField();
        registerCarButton1 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        rentalServiceControls = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        idTextField_rent = new javax.swing.JTextField();
        rentCarButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        brandLabel_rent = new javax.swing.JLabel();
        modelLabel_rent = new javax.swing.JLabel();
        descriptionLabel_rent = new javax.swing.JLabel();
        priceLabel_rent = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        rentFromDate_rent = new javax.swing.JFormattedTextField();
        rentUntilDate_rent = new javax.swing.JFormattedTextField();
        reportControls = new javax.swing.JPanel();
        pnlCenter = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        reportsTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlRoot.setPreferredSize(new java.awt.Dimension(700, 507));
        pnlRoot.setLayout(new java.awt.BorderLayout());

        pnlSide.setBackground(new java.awt.Color(21, 25, 28));
        pnlSide.setPreferredSize(new java.awt.Dimension(150, 0));
        pnlSide.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 6, 8));

        space1.setBackground(new java.awt.Color(21, 25, 28));
        space1.setPreferredSize(new java.awt.Dimension(170, 50));

        javax.swing.GroupLayout space1Layout = new javax.swing.GroupLayout(space1);
        space1.setLayout(space1Layout);
        space1Layout.setHorizontalGroup(
            space1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );
        space1Layout.setVerticalGroup(
            space1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        pnlSide.add(space1);

        title1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        title1.setForeground(new java.awt.Color(252, 252, 252));
        title1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title1.setText("Car");
        title1.setPreferredSize(new java.awt.Dimension(150, 29));
        pnlSide.add(title1);

        title2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        title2.setForeground(new java.awt.Color(252, 252, 252));
        title2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title2.setText("Rental");
        title2.setPreferredSize(new java.awt.Dimension(150, 29));
        pnlSide.add(title2);

        space2.setBackground(new java.awt.Color(21, 25, 28));
        space2.setPreferredSize(new java.awt.Dimension(170, 10));

        javax.swing.GroupLayout space2Layout = new javax.swing.GroupLayout(space2);
        space2.setLayout(space2Layout);
        space2Layout.setHorizontalGroup(
            space2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );
        space2Layout.setVerticalGroup(
            space2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        pnlSide.add(space2);

        jSeparator1.setPreferredSize(new java.awt.Dimension(120, 10));
        pnlSide.add(jSeparator1);

        space3.setBackground(new java.awt.Color(21, 25, 28));
        space3.setPreferredSize(new java.awt.Dimension(170, 10));

        javax.swing.GroupLayout space3Layout = new javax.swing.GroupLayout(space3);
        space3.setLayout(space3Layout);
        space3Layout.setHorizontalGroup(
            space3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );
        space3Layout.setVerticalGroup(
            space3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        pnlSide.add(space3);

        btnReg.setBackground(new java.awt.Color(21, 25, 28));
        btnReg.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnReg.setForeground(new java.awt.Color(204, 204, 204));
        btnReg.setText("Registration");
        btnReg.setBorder(null);
        btnReg.setPreferredSize(new java.awt.Dimension(150, 22));
        btnReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegActionPerformed(evt);
            }
        });
        pnlSide.add(btnReg);

        space4.setBackground(new java.awt.Color(21, 25, 28));
        space4.setPreferredSize(new java.awt.Dimension(170, 10));

        javax.swing.GroupLayout space4Layout = new javax.swing.GroupLayout(space4);
        space4.setLayout(space4Layout);
        space4Layout.setHorizontalGroup(
            space4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );
        space4Layout.setVerticalGroup(
            space4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        pnlSide.add(space4);

        btnReg1.setBackground(new java.awt.Color(21, 25, 28));
        btnReg1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnReg1.setForeground(new java.awt.Color(204, 204, 204));
        btnReg1.setText("Inventory");
        btnReg1.setBorder(null);
        btnReg1.setPreferredSize(new java.awt.Dimension(150, 22));
        btnReg1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReg1ActionPerformed(evt);
            }
        });
        pnlSide.add(btnReg1);

        space5.setBackground(new java.awt.Color(21, 25, 28));
        space5.setPreferredSize(new java.awt.Dimension(170, 10));

        javax.swing.GroupLayout space5Layout = new javax.swing.GroupLayout(space5);
        space5.setLayout(space5Layout);
        space5Layout.setHorizontalGroup(
            space5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );
        space5Layout.setVerticalGroup(
            space5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        pnlSide.add(space5);

        btnReg2.setBackground(new java.awt.Color(21, 25, 28));
        btnReg2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnReg2.setForeground(new java.awt.Color(204, 204, 204));
        btnReg2.setText("Rent");
        btnReg2.setBorder(null);
        btnReg2.setPreferredSize(new java.awt.Dimension(150, 22));
        btnReg2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReg2ActionPerformed(evt);
            }
        });
        pnlSide.add(btnReg2);

        pnlRoot.add(pnlSide, java.awt.BorderLayout.WEST);

        pnlCar.setBackground(new java.awt.Color(34, 40, 44));
        pnlCar.setPreferredSize(new java.awt.Dimension(400, 50));

        carInventoryControls.setPreferredSize(new java.awt.Dimension(10, 10));
        carInventoryControls.setLayout(new java.awt.GridBagLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setLabelFor(brandTextField_add);
        jLabel1.setText("Brand");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        carInventoryControls.add(jLabel1, gridBagConstraints);

        brandTextField_add.setPreferredSize(new java.awt.Dimension(100, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(8, 15, 8, 15);
        carInventoryControls.add(brandTextField_add, gridBagConstraints);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Model");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        carInventoryControls.add(jLabel2, gridBagConstraints);

        modelTextField_add.setPreferredSize(new java.awt.Dimension(100, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(8, 15, 8, 15);
        carInventoryControls.add(modelTextField_add, gridBagConstraints);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Description");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        carInventoryControls.add(jLabel3, gridBagConstraints);

        descriptionTextField_add.setText("New");
        descriptionTextField_add.setPreferredSize(new java.awt.Dimension(100, 22));
        descriptionTextField_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descriptionTextField_addActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(8, 15, 8, 15);
        carInventoryControls.add(descriptionTextField_add, gridBagConstraints);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Price");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        carInventoryControls.add(jLabel4, gridBagConstraints);

        priceTextField_add.setPreferredSize(new java.awt.Dimension(100, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(8, 15, 8, 15);
        carInventoryControls.add(priceTextField_add, gridBagConstraints);

        registerCarButton.setText("Remove");
        registerCarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerCarButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        carInventoryControls.add(registerCarButton, gridBagConstraints);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setLabelFor(brandTextField_add);
        jLabel5.setText("ID");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        carInventoryControls.add(jLabel5, gridBagConstraints);

        idTextField_remove.setPreferredSize(new java.awt.Dimension(100, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(8, 15, 8, 15);
        carInventoryControls.add(idTextField_remove, gridBagConstraints);

        registerCarButton1.setText("Register");
        registerCarButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerCarButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(8, 0, 8, 0);
        carInventoryControls.add(registerCarButton1, gridBagConstraints);

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparator2.setPreferredSize(new java.awt.Dimension(1, 3));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 21);
        carInventoryControls.add(jSeparator2, gridBagConstraints);

        sideTab.addTab("Inventory", carInventoryControls);

        rentalServiceControls.setLayout(new java.awt.GridBagLayout());

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setLabelFor(brandTextField_add);
        jLabel6.setText("ID:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        rentalServiceControls.add(jLabel6, gridBagConstraints);

        idTextField_rent.setPreferredSize(new java.awt.Dimension(100, 22));
        idTextField_rent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idTextField_rentActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(8, 15, 8, 15);
        rentalServiceControls.add(idTextField_rent, gridBagConstraints);

        rentCarButton.setText("Rent");
        rentCarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rentCarButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(8, 0, 8, 0);
        rentalServiceControls.add(rentCarButton, gridBagConstraints);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setLabelFor(brandTextField_add);
        jLabel7.setText("Brand:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        rentalServiceControls.add(jLabel7, gridBagConstraints);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setLabelFor(brandTextField_add);
        jLabel8.setText("Model:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        rentalServiceControls.add(jLabel8, gridBagConstraints);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setLabelFor(brandTextField_add);
        jLabel9.setText("Description:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        rentalServiceControls.add(jLabel9, gridBagConstraints);

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setLabelFor(brandTextField_add);
        jLabel10.setText("Price:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        rentalServiceControls.add(jLabel10, gridBagConstraints);

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setLabelFor(brandTextField_add);
        jLabel11.setText("Rent from:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        rentalServiceControls.add(jLabel11, gridBagConstraints);

        brandLabel_rent.setText("None");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        rentalServiceControls.add(brandLabel_rent, gridBagConstraints);

        modelLabel_rent.setText("None");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        rentalServiceControls.add(modelLabel_rent, gridBagConstraints);

        descriptionLabel_rent.setText("None");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        rentalServiceControls.add(descriptionLabel_rent, gridBagConstraints);

        priceLabel_rent.setText("None");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        rentalServiceControls.add(priceLabel_rent, gridBagConstraints);

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setLabelFor(brandTextField_add);
        jLabel12.setText("Rent until:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        rentalServiceControls.add(jLabel12, gridBagConstraints);

        rentFromDate_rent.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        rentFromDate_rent.setInputVerifier(new RentDateVerifier());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(8, 15, 8, 15);
        rentalServiceControls.add(rentFromDate_rent, gridBagConstraints);

        rentUntilDate_rent.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        rentUntilDate_rent.setInputVerifier(new RentDateVerifier());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(8, 15, 8, 15);
        rentalServiceControls.add(rentUntilDate_rent, gridBagConstraints);

        sideTab.addTab("Rental", rentalServiceControls);

        javax.swing.GroupLayout reportControlsLayout = new javax.swing.GroupLayout(reportControls);
        reportControls.setLayout(reportControlsLayout);
        reportControlsLayout.setHorizontalGroup(
            reportControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 382, Short.MAX_VALUE)
        );
        reportControlsLayout.setVerticalGroup(
            reportControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 221, Short.MAX_VALUE)
        );

        sideTab.addTab("Reports", reportControls);

        pnlCar.add(sideTab);

        pnlRoot.add(pnlCar, java.awt.BorderLayout.EAST);

        pnlCenter.setBackground(new java.awt.Color(34, 40, 44));
        pnlCenter.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setForeground(new java.awt.Color(250, 250, 250));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(600, 600));

        reportsTable.setBackground(new java.awt.Color(34, 40, 44));
        reportsTable.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        reportsTable.setForeground(new java.awt.Color(250, 250, 250));
        reportsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        reportsTable.setGridColor(new java.awt.Color(34, 40, 44));
        reportsTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        reportsTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(reportsTable);

        pnlCenter.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pnlRoot.add(pnlCenter, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnlRoot, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegActionPerformed

    private void btnReg1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReg1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReg1ActionPerformed

    private void btnReg2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReg2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReg2ActionPerformed

    private void registerCarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerCarButtonActionPerformed
        //validate input
        if (idTextField_remove.getText().isBlank()) {
            return;
        }
        try {
            var car = carInventory.getCarById(Integer.parseInt(idTextField_remove.getText()));
            carInventory.tryRemoveCar(car);
            updateTable();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_registerCarButtonActionPerformed

    private void registerCarButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerCarButton1ActionPerformed
        //validate input
        if (brandTextField_add.getText().isBlank() || modelTextField_add.getText().isBlank() || descriptionTextField_add.getText().isBlank() || priceTextField_add.getText().isBlank()) {
            return;
        }
        try {
            var car = new Car(brandTextField_add.getText(),
                    modelTextField_add.getText(),
                    descriptionTextField_add.getText(),
                    Double.parseDouble(priceTextField_add.getText())
            );
            while (!carInventory.tryAddCar(car)) {
                car.incrementId();
            }
            updateTable();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_registerCarButton1ActionPerformed

    private void descriptionTextField_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descriptionTextField_addActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_descriptionTextField_addActionPerformed

    private void rentCarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rentCarButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rentCarButtonActionPerformed

    private void idTextField_rentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idTextField_rentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idTextField_rentActionPerformed

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
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    private void modifyComponents() {
        //initialize textfields
        var formatter = DateTimeFormatter.ofPattern("M/d/yy");
        rentFromDate_rent.setText(LocalDate.now().format(formatter));
        rentUntilDate_rent.setText(LocalDate.now().plusDays(1).format(formatter));

        //add listener for id textfield
        idTextField_rent.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {

            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                warn();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                warn();
            }

            public void warn() {
                if (idTextField_rent.getText().isBlank()) {
                    return;
                }
                var value = Integer.parseInt(idTextField_rent.getText().trim());
                new Thread(() -> {
                    var car = carInventory.getCarById(value);
                    brandLabel_rent.setText(car.getBrand());
                    modelLabel_rent.setText(car.getModel());
                    descriptionLabel_rent.setText(car.getDescription());
                    priceLabel_rent.setText(Double.toString(car.getPrice()));
                }).start();

            }
        });

        //update rental tab when selecting from table
        reportsTable.getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
            if (!event.getValueIsAdjusting()) {
                int selectedRow = reportsTable.getSelectedRow();
                int selectedColumn = reportsTable.getSelectedColumn();

                if (selectedRow != -1 && selectedColumn != -1) {
                    ReportTableModel reportsModel = (ReportTableModel) reportsTable.getModel();
                    currentlySelectedReport = reportsModel.getReportAt(selectedRow);
                    idTextField_rent.setText(Integer.toString(currentlySelectedReport.getCar().getId()));
                    idTextField_remove.setText(Integer.toString(currentlySelectedReport.getCar().getId()));
                }
            }
        });

    }

    private void initializeDatabase() {
        carInventory = CarInventory.getInstance();
        rentalService = RentalService.getInstance(carInventory);
        updateTable();
    }

    private void updateTable() {
        ReportTableModel reportsModel = new ReportTableModel(carInventory.generateReport(rentalService));
        this.reportsTable.setModel(reportsModel);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel brandLabel_rent;
    private javax.swing.JTextField brandTextField_add;
    private javax.swing.JButton btnReg;
    private javax.swing.JButton btnReg1;
    private javax.swing.JButton btnReg2;
    private javax.swing.JPanel carInventoryControls;
    private javax.swing.JLabel descriptionLabel_rent;
    private javax.swing.JTextField descriptionTextField_add;
    private javax.swing.JTextField idTextField_remove;
    private javax.swing.JTextField idTextField_rent;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel modelLabel_rent;
    private javax.swing.JTextField modelTextField_add;
    private javax.swing.JPanel pnlCar;
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JPanel pnlRoot;
    private javax.swing.JPanel pnlSide;
    private javax.swing.JLabel priceLabel_rent;
    private javax.swing.JTextField priceTextField_add;
    private javax.swing.JButton registerCarButton;
    private javax.swing.JButton registerCarButton1;
    private javax.swing.JButton rentCarButton;
    private javax.swing.JFormattedTextField rentFromDate_rent;
    private javax.swing.JFormattedTextField rentUntilDate_rent;
    private javax.swing.JPanel rentalServiceControls;
    private javax.swing.JPanel reportControls;
    private javax.swing.JTable reportsTable;
    private javax.swing.JTabbedPane sideTab;
    private javax.swing.JPanel space1;
    private javax.swing.JPanel space2;
    private javax.swing.JPanel space3;
    private javax.swing.JPanel space4;
    private javax.swing.JPanel space5;
    private javax.swing.JLabel title1;
    private javax.swing.JLabel title2;
    // End of variables declaration//GEN-END:variables
}
