package sample;//package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//--module-path "D:\GitHub\Scene Buider JavaFX\openjfx-16_windows-x64_bin-sdk\javafx-sdk-16\lib" --add-modules javafx.controls,javafx.fxml


public class Main extends Application {

    Stage window;
    TableView<JadwalKuliah> table; // Deklarasi tabel
    TableView<JadwalKuliah> srcTable;
    TextField inputHari, inputMataKuliah, inputGKB, inputJam,inputRuangan, inputDosen;
    TextField keywordTextField;

    public ObservableList<JadwalKuliah> JadwalPerkuliahan = FXCollections.observableArrayList(
            new JadwalKuliah("Senin",  "5", "Matematika", "2", "25", "bambang"),
            new JadwalKuliah("Selasa",  "2", "Manajemen", "5", "2", "Tono")
    );



    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;

        //kolom hari
        TableColumn<JadwalKuliah, String> kolomhari = new TableColumn<>("Hari");
        kolomhari.setMinWidth(150);
        kolomhari.setCellValueFactory(new PropertyValueFactory<>("hari"));
        kolomhari.setCellFactory(TextFieldTableCell.forTableColumn());

        //kolom jam
        TableColumn<JadwalKuliah, String> kolomjam = new TableColumn<>("Jam");
        kolomjam.setMinWidth(100);
        kolomjam.setCellValueFactory(new PropertyValueFactory<>("jam"));
        kolomjam.setCellFactory(TextFieldTableCell.forTableColumn());

        //kolom kuliah
        TableColumn<JadwalKuliah, String> kolomkuliah = new TableColumn<>("Mata Kuliah");
        kolomkuliah.setMinWidth(200);
        kolomkuliah.setCellValueFactory(new PropertyValueFactory<>("mataKuliah"));
        kolomkuliah.setCellFactory(TextFieldTableCell.forTableColumn());

        //kolom GKB
        TableColumn<JadwalKuliah, String> kolomGKB = new TableColumn<>("GKB");
        kolomGKB.setMinWidth(100);
        kolomGKB.setCellValueFactory(new PropertyValueFactory<>("GKB"));
        kolomGKB.setCellFactory(TextFieldTableCell.forTableColumn());

        //kolom ruangan
        TableColumn<JadwalKuliah, String> kolomruangan = new TableColumn<>("Ruangan");
        kolomruangan.setMinWidth(100);
        kolomruangan.setCellValueFactory(new PropertyValueFactory<>("ruangan"));
        kolomruangan.setCellFactory(TextFieldTableCell.forTableColumn());

        //kolom Dosen
        TableColumn<JadwalKuliah, String> kolomdosen = new TableColumn<>("Nama Dosen");
        kolomdosen.setMinWidth(200);
        kolomdosen.setCellValueFactory(new PropertyValueFactory<>("dosen"));
        kolomdosen.setCellFactory(TextFieldTableCell.forTableColumn());

        //Tambah Hari
        inputHari = new TextField();
        inputHari.setPromptText(" Hari");
        inputHari.setMaxWidth(130);

        //Tambah Jam
        inputJam = new TextField();
        inputJam.setPromptText(" Jam");
        inputJam.setMaxWidth(100);

        //Tambah Mata Kuliah
        inputMataKuliah = new TextField();
        inputMataKuliah.setPromptText("Mata Kuliah");
        inputJam.setMaxWidth(200);

        //Tambah GKB
        inputGKB = new TextField();
        inputGKB.setPromptText(" GKB");
        inputJam.setMaxWidth(100);

        //Tambah Ruangan
        inputRuangan = new TextField();
        inputRuangan.setPromptText(" Ruangan");
        inputRuangan.setMaxWidth(100);

        //Tambah Dosen
        inputDosen = new TextField();
        inputDosen.setPromptText(" Nama Dosen");

        // Button
        Button buttonTambah= new Button("Tambah");
        buttonTambah.setOnAction(e -> addButtonClicked());
        Button buttonHapus = new Button("Hapus");
        buttonHapus.setOnAction(e -> deleteButtonClicked());

//        //filtered
        FilteredList<JadwalKuliah> flJadwal = new FilteredList(JadwalPerkuliahan, p -> true);//Pass the data to a filtered list
        table.setItems(flJadwal);//Set the table's items using the filtered list
        table.getColumns().addAll(kolomhari, kolomjam, kolomkuliah, kolomGKB, kolomruangan, kolomdosen);

        //Adding ChoiceBox and TextField here!
        ChoiceBox<String> choiceBox = new ChoiceBox();
        choiceBox.getItems().addAll("First Name", "Last Name", "Email");
        choiceBox.setValue("First Name");

        TextField textField = new TextField();
        textField.setPromptText("Search here!");
        textField.textProperty().addListener((obs, oldValue, newValue) -> {
            switch (choiceBox.getValue())//Switch on choiceBox value
            {
                case "First Name":
                    flJadwal.setPredicate(p -> p.getHari().toLowerCase().contains(newValue.toLowerCase().trim()));//filter table by first name
                    break;
                case "Last Name":
                    flJadwal.setPredicate(p -> p.getJam().toLowerCase().contains(newValue.toLowerCase().trim()));//filter table by last name
                    break;
                case "Email":
                    flJadwal.setPredicate(p -> p.getMataKuliah().toLowerCase().contains(newValue.toLowerCase().trim()));//filter table by email
                    break;
            }
        });

        choiceBox.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal)
                -> {//reset table and textfield when new choice is selected
            if (newVal != null) {
                textField.setText("");
            }
        });


        //Hbox untuk bagian bawah
        HBox hbox1 = new HBox();
        hbox1.setPadding(new Insets(10,10,10,10));
        hbox1.setSpacing(10);
        hbox1.getChildren().addAll(inputHari,inputJam,inputMataKuliah,inputGKB,inputRuangan,inputDosen,buttonTambah,buttonHapus);

        HBox hbox2 = new HBox();
        hbox2.setPadding(new Insets(10,20,20,20));
        hbox2.setSpacing(20);
        hbox2.getChildren().addAll(table);

        table = new TableView<>();
        table.setEditable(true);
        //setting untuk kolom tabel
        table.setItems(JadwalPerkuliahan);
        table.getColumns().addAll(kolomhari,kolomjam, kolomkuliah,kolomGKB, kolomruangan, kolomdosen);

        //deploy tabel
        VBox vbox1= new VBox();
        vbox1.getChildren().addAll(table, hbox1,hbox2); // isi dari vbox 1 yaitu tabel dan Hbox button add
        vbox1.setStyle("-fx-background-color: linear-gradient(from 25% 25% to 100% 100%, #55d284, #f2cf07)");
        Scene scene1 = new Scene(vbox1);

        //Scene Untuk Login
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,25,25,25));
        grid.setStyle("-fx-background-color: linear-gradient(from 10% 25% to 100% 100%, #55d284, #f2cf07)");

        Scene scene2 = new Scene(grid,720, 480);
        Text tittle = new Text("Selamat Datang");
        tittle.setFont(Font.font("sitka small",FontWeight.BOLD, 15));
        grid.add(tittle,0,0);

        Label username = new Label("Username");
        username.setFont(Font.font("arial" ,FontWeight.MEDIUM, 15) );
        grid.add(username,0,1);

        TextField usernameField = new TextField();
        grid.add(usernameField,1,1);

        Button login = new Button("login");
        login.setOnAction(e -> window.setScene(scene1));
        grid.add(login,1,5);

        window.setTitle("Jadwal Kuliah");
        window.setScene(scene2);
        window.show();
    }

    // Button untuk menambah data
    public void addButtonClicked(){
        JadwalKuliah JadwalKuliah = new JadwalKuliah();
        JadwalKuliah.setHari(inputHari.getText());
        JadwalKuliah.setJam(inputJam.getText());
        JadwalKuliah.setMataKuliah(inputMataKuliah.getText());
        JadwalKuliah.setGKB(inputGKB.getText());
        JadwalKuliah.setRuangan(inputRuangan.getText());
        JadwalKuliah.setDosen(inputDosen.getText());

        table.getItems().addAll(JadwalKuliah);

        //mengosongkan textField supaya tidak stack
        inputHari.clear();
        inputJam.clear();
        inputMataKuliah.clear();
        inputGKB.clear();
        inputGKB.clear();
        inputRuangan.clear();
        inputDosen.clear();

    }

    //Button untuk Menghapus data
    public void deleteButtonClicked(){
        ObservableList<JadwalKuliah> JadwalSelected, allJadwal;
        allJadwal = table.getItems();
        JadwalSelected = table.getSelectionModel().getSelectedItems();

        JadwalSelected.forEach(allJadwal::remove);
    }

    // fungsi object Jadwal Kuliah
//    public ObservableList<JadwalKuliah> getJadwalkuliah(){
//        ObservableList<JadwalKuliah> JadwalPerkuliahan =  FXCollections.observableArrayList();
//        JadwalPerkuliahan.add(new JadwalKuliah("Senin",  "5", "Matematika", "2", "25", "bambang"));
//        JadwalPerkuliahan.add(new JadwalKuliah("Selasa",  "2", "Manajemen", "5", "2", "Tono"));
//
//        return JadwalPerkuliahan;
//
//    }


}


//
///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
//
///**
// *
// * @author
// */
// class KalkulatorIlmiah extends javax.swing.JFrame {
//
//    /**
//     * Creates new form KalkulatorIlmiah
//     */
//    public KalkulatorIlmiah() {
//        initComponents();
//        jRadioButton1.setEnabled(true);
//
//    }
//
//    double num1,num2,result;
//    String opr;
//
//    public void enable()
//    {
//        jTextField1.setEnabled(true);
//
//        jRadioButton1.setEnabled(true);
//        jRadioButton2.setEnabled(false);
//
//
//        jButton1.setEnabled(true);
//        jButton2.setEnabled(true);
//        jButton3.setEnabled(true);
//        jButton4.setEnabled(true);
//        jButton5.setEnabled(true);
//        jButton6.setEnabled(true);
//        jButton7.setEnabled(true);
//        jButton8.setEnabled(true);
//        jButton9.setEnabled(true);
//        jButton10.setEnabled(true);
//        jButton11.setEnabled(true);
//        jButton12.setEnabled(true);
//        jButton13.setEnabled(true);
//        jButton14.setEnabled(true);
//        jButton15.setEnabled(true);
//        jButton16.setEnabled(true);
//        jButton17.setEnabled(true);
//        jButton18.setEnabled(true);
//        jButton19.setEnabled(true);
//        jButton20.setEnabled(true);
//        jButton21.setEnabled(true);
//        jButton22.setEnabled(true);
//        jButton23.setEnabled(true);
//        jButton24.setEnabled(true);
//        jButton25.setEnabled(true);
//        jButton26.setEnabled(true);
//        jButton27.setEnabled(true);
//        jButton28.setEnabled(true);
//        jButton29.setEnabled(true);
//        jButton30.setEnabled(true);
//        jButton31.setEnabled(true);
//        jButton32.setEnabled(true);
//        jButton33.setEnabled(true);
//        jButton34.setEnabled(true);
//    }
//
//    public void disable()
//    {
//        jTextField1.setEnabled(false);
//
//        jRadioButton1.setEnabled(false);
//        jRadioButton2.setEnabled(true);
//
//        jButton1.setEnabled(false);
//        jButton2.setEnabled(false);
//        jButton3.setEnabled(false);
//        jButton4.setEnabled(false);
//        jButton5.setEnabled(false);
//        jButton6.setEnabled(false);
//        jButton7.setEnabled(false);
//        jButton8.setEnabled(false);
//        jButton9.setEnabled(false);
//        jButton10.setEnabled(false);
//        jButton11.setEnabled(false);
//        jButton12.setEnabled(false);
//        jButton13.setEnabled(false);
//        jButton14.setEnabled(false);
//        jButton15.setEnabled(false);
//        jButton16.setEnabled(false);
//        jButton17.setEnabled(false);
//        jButton18.setEnabled(false);
//        jButton19.setEnabled(false);
//        jButton20.setEnabled(false);
//        jButton21.setEnabled(false);
//        jButton22.setEnabled(false);
//        jButton23.setEnabled(false);
//        jButton24.setEnabled(false);
//        jButton25.setEnabled(false);
//        jButton26.setEnabled(false);
//        jButton27.setEnabled(false);
//        jButton28.setEnabled(false);
//        jButton29.setEnabled(false);
//        jButton30.setEnabled(false);
//        jButton31.setEnabled(false);
//        jButton32.setEnabled(false);
//        jButton33.setEnabled(false);
//        jButton34.setEnabled(false);
//    }
//
//    /**
//     * This method is called from within the constructor to initialize the form.
//     * WARNING: Do NOT modify this code. The content of this method is always
//     * regenerated by the Form Editor.
//     */
//    @SuppressWarnings("unchecked")
//    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
//    private void initComponents() {
//
//        jTextField1 = new javax.swing.JTextField();
//        jRadioButton1 = new javax.swing.JRadioButton();
//        jRadioButton2 = new javax.swing.JRadioButton();
//        jButton1 = new javax.swing.JButton();
//        jButton2 = new javax.swing.JButton();
//        jButton3 = new javax.swing.JButton();
//        jButton4 = new javax.swing.JButton();
//        jButton5 = new javax.swing.JButton();
//        jButton6 = new javax.swing.JButton();
//        jButton7 = new javax.swing.JButton();
//        jButton8 = new javax.swing.JButton();
//        jButton9 = new javax.swing.JButton();
//        jButton10 = new javax.swing.JButton();
//        jButton11 = new javax.swing.JButton();
//        jButton12 = new javax.swing.JButton();
//        jButton13 = new javax.swing.JButton();
//        jButton14 = new javax.swing.JButton();
//        jButton15 = new javax.swing.JButton();
//        jButton16 = new javax.swing.JButton();
//        jButton17 = new javax.swing.JButton();
//        jButton18 = new javax.swing.JButton();
//        jButton19 = new javax.swing.JButton();
//        jButton20 = new javax.swing.JButton();
//        jButton21 = new javax.swing.JButton();
//        jButton22 = new javax.swing.JButton();
//        jButton23 = new javax.swing.JButton();
//        jButton24 = new javax.swing.JButton();
//        jButton25 = new javax.swing.JButton();
//        jButton26 = new javax.swing.JButton();
//        jButton27 = new javax.swing.JButton();
//        jButton29 = new javax.swing.JButton();
//        jButton30 = new javax.swing.JButton();
//        jButton28 = new javax.swing.JButton();
//        jButton31 = new javax.swing.JButton();
//        jButton32 = new javax.swing.JButton();
//        jButton33 = new javax.swing.JButton();
//        jButton34 = new javax.swing.JButton();
//
//        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
//        setTitle("Kalkulator Ilmiah");
//        setResizable(false);
//        setType(java.awt.Window.Type.UTILITY);
//
//        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
//        jTextField1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
//
//        jRadioButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
//        jRadioButton1.setText("OFF");
//        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jRadioButton1ActionPerformed(evt);
//            }
//        });
//
//        jRadioButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
//        jRadioButton2.setText("ON");
//        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jRadioButton2ActionPerformed(evt);
//            }
//        });
//
//        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
//        jButton1.setText("1/x");
//        jButton1.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButton1ActionPerformed(evt);
//            }
//        });
//
//        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
//        jButton2.setText("x^y");
//        jButton2.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButton2ActionPerformed(evt);
//            }
//        });
//
//        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
//        jButton3.setText("R");
//        jButton3.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButton3ActionPerformed(evt);
//            }
//        });
//
//        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
//        jButton4.setText("exp");
//        jButton4.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButton4ActionPerformed(evt);
//            }
//        });
//
//        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
//        jButton5.setText("sin");
//        jButton5.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButton5ActionPerformed(evt);
//            }
//        });
//
//        jButton6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
//        jButton6.setText("x^3");
//        jButton6.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButton6ActionPerformed(evt);
//            }
//        });
//
//        jButton7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
//        jButton7.setText("x^2");
//        jButton7.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButton7ActionPerformed(evt);
//            }
//        });
//
//        jButton8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
//        jButton8.setText("+/-");
//        jButton8.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButton8ActionPerformed(evt);
//            }
//        });
//
//        jButton9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
//        jButton9.setText("cos");
//        jButton9.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButton9ActionPerformed(evt);
//            }
//        });
//
//        jButton10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
//        jButton10.setText("tan");
//        jButton10.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButton10ActionPerformed(evt);
//            }
//        });
//
//        jButton11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
//        jButton11.setText("cosh");
//        jButton11.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButton11ActionPerformed(evt);
//            }
//        });
//
//        jButton12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
//        jButton12.setText("tanh");
//        jButton12.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButton12ActionPerformed(evt);
//            }
//        });
//
//        jButton13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
//        jButton13.setText("log");
//        jButton13.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButton13ActionPerformed(evt);
//            }
//        });
//
//        jButton14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
//        jButton14.setText("sinh");
//        jButton14.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButton14ActionPerformed(evt);
//            }
//        });
//
//        jButton15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
//        jButton15.setText("B");
//        jButton15.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButton15ActionPerformed(evt);
//            }
//        });
//
//        jButton16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
//        jButton16.setText("+");
//        jButton16.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButton16ActionPerformed(evt);
//            }
//        });
//
//        jButton17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
//        jButton17.setText("%");
//        jButton17.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButton17ActionPerformed(evt);
//            }
//        });
//
//        jButton18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
//        jButton18.setText("Clr");
//        jButton18.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButton18ActionPerformed(evt);
//            }
//        });
//
//        jButton19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
//        jButton19.setText("9");
//        jButton19.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButton19ActionPerformed(evt);
//            }
//        });
//
//        jButton20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
//        jButton20.setText("-");
//        jButton20.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButton20ActionPerformed(evt);
//            }
//        });
//
//        jButton21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
//        jButton21.setText("7");
//        jButton21.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButton21ActionPerformed(evt);
//            }
//        });
//
//        jButton22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
//        jButton22.setText("8");
//        jButton22.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButton22ActionPerformed(evt);
//            }
//        });
//
//        jButton23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
//        jButton23.setText("6");
//        jButton23.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButton23ActionPerformed(evt);
//            }
//        });
//
//        jButton24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
//        jButton24.setText("*");
//        jButton24.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButton24ActionPerformed(evt);
//            }
//        });
//
//        jButton25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
//        jButton25.setText("4");
//        jButton25.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButton25ActionPerformed(evt);
//            }
//        });
//
//        jButton26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
//        jButton26.setText("5");
//        jButton26.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButton26ActionPerformed(evt);
//            }
//        });
//
//        jButton27.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
//        jButton27.setText("=");
//        jButton27.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButton27ActionPerformed(evt);
//            }
//        });
//
//        jButton29.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
//        jButton29.setText("0");
//        jButton29.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButton29ActionPerformed(evt);
//            }
//        });
//
//        jButton30.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
//        jButton30.setText(".");
//        jButton30.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButton30ActionPerformed(evt);
//            }
//        });
//
//        jButton28.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
//        jButton28.setText("3");
//        jButton28.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButton28ActionPerformed(evt);
//            }
//        });
//
//        jButton31.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
//        jButton31.setText("/");
//        jButton31.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButton31ActionPerformed(evt);
//            }
//        });
//
//        jButton32.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
//        jButton32.setText("1");
//        jButton32.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButton32ActionPerformed(evt);
//            }
//        });
//
//        jButton33.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
//        jButton33.setText("n!");
//        jButton33.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButton33ActionPerformed(evt);
//            }
//        });
//
//        jButton34.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
//        jButton34.setText("2");
//        jButton34.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButton34ActionPerformed(evt);
//            }
//        });
//
//        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
//        getContentPane().setLayout(layout);
//        layout.setHorizontalGroup(
//                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                        .addGroup(layout.createSequentialGroup()
//                                .addContainerGap()
//                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                                        .addComponent(jTextField1)
//                                        .addGroup(layout.createSequentialGroup()
//                                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                                                .addComponent(jButton29, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                                                .addComponent(jButton30, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                                                .addComponent(jButton27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
//                                        .addGroup(layout.createSequentialGroup()
//                                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
//                                                .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
//                                                .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                                                .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                                                .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
//                                        .addGroup(layout.createSequentialGroup()
//                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                                                        .addGroup(layout.createSequentialGroup()
//                                                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
//                                                                .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
//                                                                .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                                                                .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                                                                .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
//                                                        .addGroup(layout.createSequentialGroup()
//                                                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
//                                                                .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
//                                                                .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                                                                .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                                                                .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
//                                                        .addGroup(layout.createSequentialGroup()
//                                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
//                                                                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
//                                                                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                                                                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                                                                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
//                                                        .addGroup(layout.createSequentialGroup()
//                                                                .addGap(2, 2, 2)
//                                                                .addComponent(jRadioButton2)
//                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                                                                .addComponent(jRadioButton1))
//                                                        .addGroup(layout.createSequentialGroup()
//                                                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
//                                                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
//                                                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                                                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                                                                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
//                                                .addGap(0, 0, Short.MAX_VALUE))
//                                        .addGroup(layout.createSequentialGroup()
//                                                .addComponent(jButton33, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
//                                                .addComponent(jButton32, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
//                                                .addComponent(jButton34, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                                                .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                                                .addComponent(jButton31, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
//                                .addContainerGap())
//        );
//        layout.setVerticalGroup(
//                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                        .addGroup(layout.createSequentialGroup()
//                                .addGap(23, 23, 23)
//                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                                        .addComponent(jRadioButton2)
//                                        .addComponent(jRadioButton1))
//                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
//                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
//                                .addGap(13, 13, 13)
//                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                        .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
//                                .addGap(18, 18, 18)
//                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                        .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                        .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                        .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                        .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
//                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
//                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                        .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                        .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                        .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                        .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
//                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
//                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                        .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                        .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                        .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                        .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
//                                .addGap(11, 11, 11)
//                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                                        .addComponent(jButton33, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                        .addComponent(jButton34, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                        .addComponent(jButton32, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                        .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                        .addComponent(jButton31, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
//                                .addGap(18, 18, 18)
//                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                        .addComponent(jButton29, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                        .addComponent(jButton30, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                        .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
//                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
//        );
//
//        pack();
//    }// </editor-fold>//GEN-END:initComponents
//
//    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
//        jTextField1.setText(jTextField1.getText() + "0");
//    }//GEN-LAST:event_jButton29ActionPerformed
//
//    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32ActionPerformed
//        jTextField1.setText(jTextField1.getText() + "1");
//    }//GEN-LAST:event_jButton32ActionPerformed
//
//    private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton34ActionPerformed
//        jTextField1.setText(jTextField1.getText() + "2");
//    }//GEN-LAST:event_jButton34ActionPerformed
//
//    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
//        jTextField1.setText(jTextField1.getText() + "3");
//    }//GEN-LAST:event_jButton28ActionPerformed
//
//    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
//        jTextField1.setText(jTextField1.getText() + "4");
//    }//GEN-LAST:event_jButton25ActionPerformed
//
//    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
//        jTextField1.setText(jTextField1.getText() + "5");
//    }//GEN-LAST:event_jButton26ActionPerformed
//
//    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
//        jTextField1.setText(jTextField1.getText() + "6");
//    }//GEN-LAST:event_jButton23ActionPerformed
//
//    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
//        jTextField1.setText(jTextField1.getText() + "7");
//    }//GEN-LAST:event_jButton21ActionPerformed
//
//    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
//        jTextField1.setText(jTextField1.getText() + "8");
//    }//GEN-LAST:event_jButton22ActionPerformed
//
//    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
//        jTextField1.setText(jTextField1.getText() + "9");
//    }//GEN-LAST:event_jButton19ActionPerformed
//
//    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
//        jTextField1.setText(jTextField1.getText() + ".");
//    }//GEN-LAST:event_jButton30ActionPerformed
//
//    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
//        jTextField1.setText("");
//    }//GEN-LAST:event_jButton18ActionPerformed
//
//    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
//        String backSpace = null;
//
//        if(jTextField1.getText().length() > 0)
//        {
//            StringBuilder s= new StringBuilder(jTextField1.getText());
//
//            s.deleteCharAt (jTextField1.getText().length() - 1);
//            backSpace = s.toString();
//            jTextField1.setText(backSpace);
//        }
//    }//GEN-LAST:event_jButton15ActionPerformed
//
//    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
//        num1 = Double.parseDouble(jTextField1.getText());
//
//        jTextField1.setText("");
//
//        opr = "+";
//    }//GEN-LAST:event_jButton16ActionPerformed
//
//    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
//        num1 = Double.parseDouble(jTextField1.getText());
//
//        jTextField1.setText("");
//
//        opr = "-";
//    }//GEN-LAST:event_jButton20ActionPerformed
//
//    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
//        num1 = Double.parseDouble(jTextField1.getText());
//
//        jTextField1.setText("");
//
//        opr = "*";
//    }//GEN-LAST:event_jButton24ActionPerformed
//
//    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed
//        num1 = Double.parseDouble(jTextField1.getText());
//
//        jTextField1.setText("");
//
//        opr = "/";
//    }//GEN-LAST:event_jButton31ActionPerformed
//
//    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
//        num1 = Double.parseDouble(jTextField1.getText());
//
//        jTextField1.setText("");
//
//        opr = "%";
//    }//GEN-LAST:event_jButton17ActionPerformed
//
//    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
//        num2 = Double.parseDouble(jTextField1.getText());
//
//        if(opr == "+")
//        {
//            result = num1 + num2;
//            jTextField1.setText(Double.toString(result));
//        }
//        else if (opr == "-") {
//
//            result = num1 - num2;
//            jTextField1.setText(Double.toString(result));
//        }
//        else if (opr == "*") {
//
//            result = num1 * num2;
//            jTextField1.setText(Double.toString(result));
//        }
//        else if (opr == "/") {
//
//            result = num1 / num2;
//            jTextField1.setText(Double.toString(result));
//        }
//        else if (opr == "%") {
//
//            result = num1 % num2;
//            jTextField1.setText(Double.toString(result));
//        }
//
//        else if (opr == "x^y")
//        {
//            for(int i=0; i<num2; i++){
//
//                result = num1*num2;
//            }
//            jTextField1.setText(Double.toString(result));
//        }
//    }//GEN-LAST:event_jButton27ActionPerformed
//
//    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
//        double t=Math.sqrt(Double.parseDouble(jTextField1.getText()));
//
//        jTextField1.setText("");
//        jTextField1.setText(jTextField1.getText() + t);
//    }//GEN-LAST:event_jButton3ActionPerformed
//
//    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
//        double t=Math.sin(Double.parseDouble(jTextField1.getText()));
//
//        jTextField1.setText("");
//        jTextField1.setText(jTextField1.getText() + t);
//    }//GEN-LAST:event_jButton5ActionPerformed
//
//    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
//        double t=Math.cos(Double.parseDouble(jTextField1.getText()));
//
//        jTextField1.setText("");
//        jTextField1.setText(jTextField1.getText() + t);
//    }//GEN-LAST:event_jButton9ActionPerformed
//
//    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
//        double t=Math.tan(Double.parseDouble(jTextField1.getText()));
//
//        jTextField1.setText("");
//        jTextField1.setText(jTextField1.getText() + t);
//    }//GEN-LAST:event_jButton10ActionPerformed
//
//    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
//        double t=Math.sinh(Double.parseDouble(jTextField1.getText()));
//
//        jTextField1.setText("");
//        jTextField1.setText(jTextField1.getText() + t);
//    }//GEN-LAST:event_jButton14ActionPerformed
//
//    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
//        double t=Math.cosh(Double.parseDouble(jTextField1.getText()));
//
//        jTextField1.setText("");
//        jTextField1.setText(jTextField1.getText() + t);
//    }//GEN-LAST:event_jButton11ActionPerformed
//
//    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
//        double t=Math.tanh(Double.parseDouble(jTextField1.getText()));
//
//        jTextField1.setText("");
//        jTextField1.setText(jTextField1.getText() + t);
//    }//GEN-LAST:event_jButton12ActionPerformed
//
//    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
//        double t=Math.log(Double.parseDouble(jTextField1.getText()));
//
//        jTextField1.setText("");
//        jTextField1.setText(jTextField1.getText() + t);
//    }//GEN-LAST:event_jButton13ActionPerformed
//
//    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
//        double t=Math.exp(Double.parseDouble(jTextField1.getText()));
//
//        jTextField1.setText("");
//        jTextField1.setText(jTextField1.getText() + t);
//    }//GEN-LAST:event_jButton4ActionPerformed
//
//    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//        double t=1/(Double.parseDouble(jTextField1.getText()));
//
//        jTextField1.setText("");
//        jTextField1.setText(jTextField1.getText() + t);
//    }//GEN-LAST:event_jButton1ActionPerformed
//
//    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
//        double t= Double.parseDouble(jTextField1.getText());
//
//        t=t*t;
//        jTextField1.setText("");
//        jTextField1.setText(jTextField1.getText() + t);
//    }//GEN-LAST:event_jButton7ActionPerformed
//
//    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
//        double t= Double.parseDouble(jTextField1.getText());
//
//        t=t*t*t;
//        jTextField1.setText("");
//        jTextField1.setText(jTextField1.getText() + t);
//    }//GEN-LAST:event_jButton6ActionPerformed
//
//    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
//        num1 = Double.parseDouble(jTextField1.getText());
//
//        jTextField1.setText("");
//
//        opr = "x^y";
//    }//GEN-LAST:event_jButton2ActionPerformed
//
//    private void jButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton33ActionPerformed
//        double t=Double.parseDouble(jTextField1.getText());
//
//        double fact=1 ;
//        while(t!=0){
//
//            fact = fact*t;
//            t--;
//
//        }
//        jTextField1.setText("");
//        jTextField1.setText(jTextField1.getText() + fact);
//    }//GEN-LAST:event_jButton33ActionPerformed
//
//    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
//        enable();
//    }//GEN-LAST:event_jRadioButton2ActionPerformed
//
//    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
//        disable();
//    }//GEN-LAST:event_jRadioButton1ActionPerformed
//
//    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
//        double t= Double.parseDouble(String.valueOf(jTextField1.getText()));
//
//        t=t*(-1);
//        jTextField1.setText(String.valueOf(t));
//    }//GEN-LAST:event_jButton8ActionPerformed
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(KalkulatorIlmiah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(KalkulatorIlmiah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(KalkulatorIlmiah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(KalkulatorIlmiah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new KalkulatorIlmiah().setVisible(true);
//            }
//        });
//    }
//
//    // Variables declaration - do not modify//GEN-BEGIN:variables
//    private javax.swing.JButton jButton1;
//    private javax.swing.JButton jButton10;
//    private javax.swing.JButton jButton11;
//    private javax.swing.JButton jButton12;
//    private javax.swing.JButton jButton13;
//    private javax.swing.JButton jButton14;
//    private javax.swing.JButton jButton15;
//    private javax.swing.JButton jButton16;
//    private javax.swing.JButton jButton17;
//    private javax.swing.JButton jButton18;
//    private javax.swing.JButton jButton19;
//    private javax.swing.JButton jButton2;
//    private javax.swing.JButton jButton20;
//    private javax.swing.JButton jButton21;
//    private javax.swing.JButton jButton22;
//    private javax.swing.JButton jButton23;
//    private javax.swing.JButton jButton24;
//    private javax.swing.JButton jButton25;
//    private javax.swing.JButton jButton26;
//    private javax.swing.JButton jButton27;
//    private javax.swing.JButton jButton28;
//    private javax.swing.JButton jButton29;
//    private javax.swing.JButton jButton3;
//    private javax.swing.JButton jButton30;
//    private javax.swing.JButton jButton31;
//    private javax.swing.JButton jButton32;
//    private javax.swing.JButton jButton33;
//    private javax.swing.JButton jButton34;
//    private javax.swing.JButton jButton4;
//    private javax.swing.JButton jButton5;
//    private javax.swing.JButton jButton6;
//    private javax.swing.JButton jButton7;
//    private javax.swing.JButton jButton8;
//    private javax.swing.JButton jButton9;
//    private javax.swing.JRadioButton jRadioButton1;
//    private javax.swing.JRadioButton jRadioButton2;
//    private javax.swing.JTextField jTextField1;
//    // End of variables declaration//GEN-END:variables
//}
//


/*
package sample;//package sample;

        import javafx.application.Application;
        import javafx.collections.FXCollections;
        import javafx.collections.ObservableList;
        import javafx.collections.transformation.FilteredList;
        import javafx.geometry.Insets;
        import javafx.geometry.Pos;
        import javafx.scene.Scene;
        import javafx.scene.control.*;
        import javafx.scene.control.cell.PropertyValueFactory;
        import javafx.scene.control.cell.TextFieldTableCell;
        import javafx.scene.layout.GridPane;
        import javafx.scene.layout.HBox;
        import javafx.scene.layout.VBox;
        import javafx.scene.text.Font;
        import javafx.scene.text.FontWeight;
        import javafx.scene.text.Text;
        import javafx.stage.Stage;

//--module-path "D:\GitHub\Scene Buider JavaFX\openjfx-16_windows-x64_bin-sdk\javafx-sdk-16\lib" --add-modules javafx.controls,javafx.fxml


public class Main extends Application {

    Stage window;
    TableView<JadwalKuliah> table; // Deklarasi tabel
    TextField inputHari, inputMataKuliah, inputGKB, inputJam,inputRuangan, inputDosen;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;

        //kolom hari
        TableColumn<JadwalKuliah, String> kolomhari = new TableColumn<>("Hari");
        kolomhari.setMinWidth(150);
        kolomhari.setCellValueFactory(new PropertyValueFactory<>("hari"));
        kolomhari.setCellFactory(TextFieldTableCell.forTableColumn());

        //kolom jam
        TableColumn<JadwalKuliah, String> kolomjam = new TableColumn<>("Jam");
        kolomjam.setMinWidth(100);
        kolomjam.setCellValueFactory(new PropertyValueFactory<>("jam"));
        kolomjam.setCellFactory(TextFieldTableCell.forTableColumn());

        //kolom kuliah
        TableColumn<JadwalKuliah, String> kolomkuliah = new TableColumn<>("Mata Kuliah");
        kolomkuliah.setMinWidth(200);
        kolomkuliah.setCellValueFactory(new PropertyValueFactory<>("mataKuliah"));
        kolomkuliah.setCellFactory(TextFieldTableCell.forTableColumn());

        //kolom GKB
        TableColumn<JadwalKuliah, String> kolomGKB = new TableColumn<>("GKB");
        kolomGKB.setMinWidth(100);
        kolomGKB.setCellValueFactory(new PropertyValueFactory<>("GKB"));
        kolomGKB.setCellFactory(TextFieldTableCell.forTableColumn());

        //kolom ruangan
        TableColumn<JadwalKuliah, String> kolomruangan = new TableColumn<>("Ruangan");
        kolomruangan.setMinWidth(100);
        kolomruangan.setCellValueFactory(new PropertyValueFactory<>("ruangan"));
        kolomruangan.setCellFactory(TextFieldTableCell.forTableColumn());

        //kolom Dosen
        TableColumn<JadwalKuliah, String> kolomdosen = new TableColumn<>("Nama Dosen");
        kolomdosen.setMinWidth(200);
        kolomdosen.setCellValueFactory(new PropertyValueFactory<>("dosen"));
        kolomdosen.setCellFactory(TextFieldTableCell.forTableColumn());

        //Tambah Hari
        inputHari = new TextField();
        inputHari.setPromptText(" Hari");
        inputHari.setMaxWidth(130);

        //Tambah Jam
        inputJam = new TextField();
        inputJam.setPromptText(" Jam");
        inputJam.setMaxWidth(100);

        //Tambah Mata Kuliah
        inputMataKuliah = new TextField();
        inputMataKuliah.setPromptText("Mata Kuliah");
        inputJam.setMaxWidth(200);

        //Tambah GKB
        inputGKB = new TextField();
        inputGKB.setPromptText(" GKB");
        inputJam.setMaxWidth(100);

        //Tambah Ruangan
        inputRuangan = new TextField();
        inputRuangan.setPromptText(" Ruangan");
        inputRuangan.setMaxWidth(100);

        //Tambah Dosen
        inputDosen = new TextField();
        inputDosen.setPromptText(" Nama Dosen");

        // Button
        Button buttonTambah= new Button("Tambah");
        buttonTambah.setOnAction(e -> addButtonClicked());
        Button buttonHapus = new Button("Hapus");
        buttonHapus.setOnAction(e -> deleteButtonClicked());

        //filtered
        FilteredList<JadwalKuliah> flJadwal = new FilteredList(JadwalPerkuliahan, p -> true);//Pass the data to a filtered list
//        table.setItems(flJadwal);//Set the table's items using the filtered list
//        table.getColumns().addAll(kolomdosen, kolomGKB, kolomruangan,kolomhari,kolomjam,kolomkuliah);

        //Adding ChoiceBox and TextField here!
        ChoiceBox<String> choiceBox = new ChoiceBox();
        choiceBox.getItems().addAll("Hari", "Jam", "Mata Kuliah", "GKB", "Ruangan", "Nama Dosen");
        choiceBox.setValue("Hari");

        TextField textSearch = new TextField();
        textSearch.setPromptText("Search here!");
        textSearch.textProperty().addListener((obs, oldValue, newValue) -> {
            switch (choiceBox.getValue())//Switch on choiceBox value
            {
                case "Hari":
                    flJadwal.setPredicate(p -> p.getHari().toLowerCase().contains(newValue.toLowerCase().trim()));//filter table by first name
                    break;
                case "Jam":
                    flJadwal.setPredicate(p -> p.getJam().toLowerCase().contains(newValue.toLowerCase().trim()));//filter table by last name
                    break;
                case "Mata Kuliah":
                    flJadwal.setPredicate(p -> p.getMataKuliah().toLowerCase().contains(newValue.toLowerCase().trim()));//filter table by email
                    break;
                case "GKB ":
                    flJadwal.setPredicate(p -> p.getGKB().toLowerCase().contains(newValue.toLowerCase().trim()));//filter table by email
                    break;
                case "Ruangan ":
                    flJadwal.setPredicate(p -> p.getRuangan().toLowerCase().contains(newValue.toLowerCase().trim()));//filter table by email
                    break;
                case "Nama Dosen ":
                    flJadwal.setPredicate(p -> p.getDosen().toLowerCase().contains(newValue.toLowerCase().trim()));//filter table by email
                    break;
            }
        });

        choiceBox.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal)
                -> {//reset table and textfield when new choice is selected
            if (newVal != null) {
                textSearch.setText("");
            }
        });



        //Hbox untuk bagian bawah
        HBox hbox1 = new HBox();
        hbox1.setPadding(new Insets(10,10,10,10));
        hbox1.setSpacing(10);
        hbox1.getChildren().addAll(inputHari,inputJam,inputMataKuliah,inputGKB,inputRuangan,inputDosen,buttonTambah,buttonHapus);

        HBox hbox2 = new HBox();
        hbox2.setPadding(new Insets(10,20,20,20));
        hbox2.setSpacing(20);
        hbox2.getChildren().addAll(choiceBox, textSearch);

        table = new TableView<>();
        table.setEditable(true);
        //setting untuk kolom tabel
        table.setItems(JadwalPerkuliahan);
        table.getColumns().addAll(kolomhari,kolomjam, kolomkuliah,kolomGKB, kolomruangan, kolomdosen);

        //deploy tabel
        VBox vbox1= new VBox();
        vbox1.getChildren().addAll(table, hbox1,hbox2); // isi dari vbox 1 yaitu tabel dan Hbox button add
        vbox1.setStyle("-fx-background-color: linear-gradient(from 25% 25% to 100% 100%, #55d284, #f2cf07)");
        Scene scene1 = new Scene(vbox1);

        //Scene Untuk Login
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,25,25,25));
        grid.setStyle("-fx-background-color: linear-gradient(from 10% 25% to 100% 100%, #55d284, #f2cf07)");

        Scene scene2 = new Scene(grid,720, 480);
        Text tittle = new Text("Selamat Datang");
        tittle.setFont(Font.font("sitka small",FontWeight.BOLD, 15));
        grid.add(tittle,0,0);

        Label username = new Label("Username");
        username.setFont(Font.font("arial" ,FontWeight.MEDIUM, 15) );
        grid.add(username,0,1);

        TextField usernameField = new TextField();
        grid.add(usernameField,1,1);

        Button login = new Button("login");
        login.setOnAction(e -> window.setScene(scene1));
        grid.add(login,1,5);

        window.setTitle("Jadwal Kuliah");
        window.setScene(scene2);
        window.show();
    }

    // Button untuk menambah data
    public void addButtonClicked(){
        JadwalKuliah JadwalKuliah = new JadwalKuliah();
        JadwalKuliah.setHari(inputHari.getText());
        JadwalKuliah.setJam(inputJam.getText());
        JadwalKuliah.setMataKuliah(inputMataKuliah.getText());
        JadwalKuliah.setGKB(inputGKB.getText());
        JadwalKuliah.setRuangan(inputRuangan.getText());
        JadwalKuliah.setDosen(inputDosen.getText());

        table.getItems().addAll(JadwalKuliah);

        //mengosongkan textField supaya tidak stack
        inputHari.clear();
        inputJam.clear();
        inputMataKuliah.clear();
        inputGKB.clear();
        inputGKB.clear();
        inputRuangan.clear();
        inputDosen.clear();

    }

    //Button untuk Menghapus data
    public void deleteButtonClicked(){
        ObservableList<JadwalKuliah> JadwalSelected, allJadwal;
        allJadwal = table.getItems();
        JadwalSelected = table.getSelectionModel().getSelectedItems();

        JadwalSelected.forEach(allJadwal::remove);
    }

 */