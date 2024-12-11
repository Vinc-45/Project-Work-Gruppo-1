
package it.unisa.diem.softeng.gruppo1;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * @brief Classe di gestione delle interazioni dell'utente con la rubrica e di gestione della parte grafica dell'applicazione.
 */
public class InterfacciaUtente {
    
    private Scene primaryScene;
    private Scene addScene;
    private Scene modifyScene;
    private TextField ricercaTf;
    private TextField[] addTf;
    private TextField[] modifyTf;
    private Button primaryAddButton;
    private Button primaryRemoveButton;
    private Button primaryModifyButton;
    private Button searchButton;
    private Button addViewConfButton;
    private Button addViewCancelButton;
    private Button modifyViewConfButton;
    private Button modifyViewCancelButton;
    private Button deleteConfirm;
    private Button deleteCancel;
    private Button searchCancelButton;
    private MenuItem saveOption;
    private MenuItem loadOption;
    private Stage stage;
    private Stage fileChooserStage;
    private Stage deleteStage;
    private TableView<Contatto> contactTable;
    private TableColumn<Contatto, String> nomeCol;
    private TableColumn<Contatto, String> cognomeCol;
    private TableColumn<Contatto, String> telefonoCol;
    private TableColumn<Contatto, String> mailCol;
    private Label notifyLabel;
    private Label notifyFileLabel;
    
    private GestioneRubrica rubrica;
    
    private ObservableList<Contatto> contatti;
    
    /**
     * @brief Costruttore di default
     */
    public InterfacciaUtente(){
        this.contatti = FXCollections.observableArrayList();
        this.rubrica = rubrica;
        this.initNotify();
        this.setPrimaryView();
        this.setAddView();
        this.setModifyView();
        this.setDeleteView();
        this.initButtons();
        this.initBindings();
    }
    
    /**
     * @brief Aggiunta del contatto alla tabella.
     */
    public void addContact(){
        
    }
    
    /**
     * @brief Rimuove un contatto selezionato nella tabella.
     */
    public void deleteContact(){
        
    }
    
    /**
     * @brief Modifica un contatto selezionato nella tabella.
     */
    public void editContact(){
        
    }
    
    /**
     * @brief Copia la lista della gestione rubrica in una lista locale.
     * 
     * @post La lista in input non viene modificata, la lista locale viene aggiornata.
     */
    public void showRubrica(){
        
    }
    
    /**
     * @brief Ricerca un contatto nella tabella.
     * 
     */
    public void searchContact(){
        
    }
    
    /**
     * @brief Salva la rubrica su un file selezionato.
     */
    public void saveRubrica(){
        
    }
    
    /**
     * @brief Carica una rubrica da un file selezionato.
     */
    public void loadRubrica(){
        
    }
    
    // Creazione di un nuovo contatto a partire dai campi compilati dall'utente
    
    private Contatto askAdd() {
        String nome = this.addTf[0].getText();
        String cognome = this.addTf[1].getText();
        String[] telefono = new String[3];
        String[] mail = new String[3];
        for(int i = 2, j = 0; i < 5; i++, j++){
            telefono[j] = this.addTf[i].getText();
        }
        for(int i = 5, j = 0; i < 8; i++, j++){
            mail[j] = this.addTf[i].getText();
        }
        
        return new Contatto(nome, cognome, telefono, mail);
    }
    
    // Modifica di un contatto tramite creazione di un nuovo contatto a partire dai campi compilati dall'utente

    private Contatto askEdit() {
        String nome = this.modifyTf[0].getText();
        String cognome = this.modifyTf[1].getText();
        String[] telefono = new String[3];
        String[] mail = new String[3];
        for(int i = 2, j = 0; i < 5; i++, j++){
            telefono[j] = this.modifyTf[i].getText();
        }
        for(int i = 5, j = 0; i < 8; i++, j++){
            mail[j] = this.modifyTf[i].getText();
        }
        
        return new Contatto(nome, cognome, telefono, mail);
    }

    // Richiesta di conferma di eliminazione di un contatto
    
    private void askDelete() {
        this.deleteStage.show();
    }
    
    // Restituisce il contatto selezionato dalla TableView
    
    private Contatto getContact() {
        return this.contactTable.getSelectionModel().getSelectedItem();
    }
    
    // Impostazione dei textfield nella scena di modifica contatto in seguito a selezione di un contatto esistente nella lista
    
    private void setModifyFields(){
        Contatto c = this.getContact();
        this.modifyTf[0].setText(c.getNome());
        this.modifyTf[1].setText(c.getCognome());
        for(int i = 2, j = 0; i < 5; i++, j++){
            this.modifyTf[i].setText(c.getNumeroDiTelefono()[j]);
        }
        for(int i = 5, j = 0; i < 8; i++, j++){
            this.modifyTf[i].setText(c.getIndirizzoEmail()[j]);
        }
        
    }
    
    // Inizializzazione vista principale
    
    private void setPrimaryView(){
        VBox root = new VBox(); //Nodo root
        root.setSpacing(10);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(10));
        
        //Barra dei menu
        MenuBar mb = new MenuBar();
        Menu m = new Menu("File");
        this.saveOption = new MenuItem("Salva rubrica");
        this.loadOption = new MenuItem("Carica rubrica");
        mb.getMenus().addAll(m);
        m.getItems().addAll(this.saveOption, this.loadOption);
        
        //Barra e pulsanti di ricerca
        HBox hbox = new HBox();
        hbox.setSpacing(10);
        this.ricercaTf = new TextField();
        HBox.setHgrow(this.ricercaTf, Priority.ALWAYS);
        this.ricercaTf.setPromptText("Inserisci testo");
        this.searchButton = new Button("Ricerca");
        this.searchCancelButton = new Button("Annulla");
        hbox.getChildren().addAll(this.ricercaTf, this.searchButton);
        
        //Tabella lista contatti
        this.contactTable = new TableView<>();
        this.nomeCol = new TableColumn<>("Nome");
        this.cognomeCol = new TableColumn<>("Cognome");
        this.telefonoCol = new TableColumn<>("Telefono");
        this.mailCol = new TableColumn<>("E-mail");
        this.contactTable.getColumns().addAll(nomeCol, cognomeCol, telefonoCol, mailCol);
        this.contactTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
        // Impostazione dei valori visualizzati all'interno delle celle della tabella
        this.contactTable.setItems(this.contatti);
        this.nomeCol.setCellValueFactory(s -> { return new SimpleStringProperty(s.getValue().getNome()); });
        this.cognomeCol.setCellValueFactory(s -> { return new SimpleStringProperty(s.getValue().getCognome()); });
        this.telefonoCol.setCellValueFactory(s -> { return new SimpleStringProperty(s.getValue().getTelString()); });
        this.mailCol.setCellValueFactory(s -> { return new SimpleStringProperty(s.getValue().getMailString()); });
        
        //Pulsanti
        HBox buttons = new HBox();
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(10);
        this.primaryAddButton = new Button("Aggiungi");
        this.primaryModifyButton = new Button("Modifica");
        this.primaryRemoveButton = new Button("Rimuovi");
        buttons.getChildren().addAll(this.primaryAddButton, this.primaryModifyButton, this.primaryRemoveButton);
        
        VBox.setVgrow(this.contactTable, Priority.ALWAYS);
        root.getChildren().addAll(mb, hbox, this.contactTable, buttons);
        
        this.primaryScene = new Scene(root, 600, 600);
        
    }
    
    // Inizializzazione vista aggiunta contatto
    
    private void setAddView(){
        VBox root = new VBox();
        root.setSpacing(15);
        root.setAlignment(Pos.CENTER);
        
        //Titolo scena
        Font f = new Font(30);
        Label title = new Label("Aggiunta contatto");
        title.setFont(f);
        
        //Labels + Textfields
        String[] labelText = {"Nome", "Cognome", "Telefono 1 (opzionale)", "Telefono 2 (opzionale)", "Telefono 3 (opzionale)", "E-mail 1 (opzionale)", "E-mail 2 (opzionale)", "E-mail 3 (opzionale)"};
        Label[] labels = new Label[8];
        HBox[] hbox = new HBox[8];
        this.addTf = new TextField[8];
        for(int i = 0; i < 8; i++){
            labels[i] = new Label(labelText[i]);
            this.addTf[i] = new TextField();
            hbox[i] = new HBox();
            hbox[i].setSpacing(10);
            hbox[i].setAlignment(Pos.CENTER);
            hbox[i].getChildren().addAll(labels[i], this.addTf[i]);
        }
        
        //Pulsanti
        HBox buttons = new HBox();
        buttons.setSpacing(30);
        buttons.setAlignment(Pos.CENTER);
        this.addViewConfButton = new Button("Conferma");
        this.addViewCancelButton = new Button("Annulla");
        buttons.getChildren().addAll(this.addViewConfButton, this.addViewCancelButton);
        
        root.getChildren().add(title);
        for(int i = 0; i < 8; i++){
            root.getChildren().add(hbox[i]);
        }
        root.getChildren().add(buttons);
        
        this.addScene = new Scene(root, 600, 600);
        
    }
    
    // Inizializzazione vista modifica contatto
    
    private void setModifyView(){
        VBox root = new VBox();
        root.setSpacing(15);
        root.setAlignment(Pos.CENTER);
        
        //Titolo scena
        Font f = new Font(30);
        Label title = new Label("Modifica contatto");
        title.setFont(f);
        
        //Labels + Textfields
        String[] labelText = {"Nome", "Cognome", "Telefono 1", "Telefono 2", "Telefono 3", "E-mail 1", "E-mail 2", "E-mail 3"};
        Label[] labels = new Label[8];
        HBox[] hbox = new HBox[8];
        this.modifyTf = new TextField[8];
        for(int i = 0; i < 8; i++){
            labels[i] = new Label(labelText[i]);
            this.modifyTf[i] = new TextField();
            hbox[i] = new HBox();
            hbox[i].setSpacing(10);
            hbox[i].setAlignment(Pos.CENTER);
            hbox[i].getChildren().addAll(labels[i], this.modifyTf[i]);
        }
        
        //Pulsanti
        HBox buttons = new HBox();
        buttons.setSpacing(30);
        buttons.setAlignment(Pos.CENTER);
        this.modifyViewConfButton = new Button("Conferma");
        this.modifyViewCancelButton = new Button("Annulla");
        buttons.getChildren().addAll(this.modifyViewConfButton, this.modifyViewCancelButton);
        
        root.getChildren().add(title);
        for(int i = 0; i < 8; i++){
            root.getChildren().add(hbox[i]);
        }
        root.getChildren().add(buttons);
        
        this.modifyScene = new Scene(root, 600, 600);
    }
    
    // Inizializzazione vista conferma rimozione contatto
    
    private void setDeleteView(){
        VBox root = new VBox();
        root.setSpacing(50);
        root.setAlignment(Pos.CENTER);
        Label question = new Label("Sei sicuro di voler rimuovere il contatto?");
        this.deleteConfirm = new Button("Si");
        this.deleteCancel = new Button("No");
        HBox buttons = new HBox();
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(20);
        buttons.getChildren().addAll(this.deleteConfirm, this.deleteCancel);
        root.getChildren().addAll(question, buttons);
        Scene deleteScene = new Scene(root, 300, 200);
        this.deleteStage = new Stage();
        this.deleteStage.setScene(deleteScene);
    }
    
    private void initBindings(){
        BooleanBinding bb = Bindings.isEmpty(this.contactTable.getSelectionModel().getSelectedItems());
        this.primaryModifyButton.disableProperty().bind(bb);
        this.primaryRemoveButton.disableProperty().bind(bb);
        this.addTf[3].disableProperty().bind(Bindings.not(this.addTf[2].textProperty().isNotEmpty()));
        this.addTf[4].disableProperty().bind(Bindings.not(this.addTf[3].textProperty().isNotEmpty()));
        this.addTf[6].disableProperty().bind(Bindings.not(this.addTf[5].textProperty().isNotEmpty()));
        this.addTf[7].disableProperty().bind(Bindings.not(this.addTf[6].textProperty().isNotEmpty()));
        this.modifyTf[3].disableProperty().bind(Bindings.not(this.modifyTf[2].textProperty().isNotEmpty()));
        this.modifyTf[4].disableProperty().bind(Bindings.not(this.modifyTf[3].textProperty().isNotEmpty()));
        this.modifyTf[6].disableProperty().bind(Bindings.not(this.modifyTf[5].textProperty().isNotEmpty()));
        this.modifyTf[7].disableProperty().bind(Bindings.not(this.modifyTf[6].textProperty().isNotEmpty()));
    }
    
    // Associazione delle azioni dei pulsanti ai rispettivi metodi
    
    private void initButtons(){
        
        this.primaryAddButton.setOnAction(event -> this.primaryAddAction());
        this.primaryModifyButton.setOnAction(event -> this.primaryModifyAction());
        this.primaryRemoveButton.setOnAction(event -> this.askDelete());
        this.deleteConfirm.setOnAction(event -> this.deleteContact());
        this.deleteCancel.setOnAction(event -> {this.deleteStage.hide();});
        this.addViewConfButton.setOnAction(event -> this.addContact());
        this.addViewCancelButton.setOnAction(event -> this.cancelAddOperation());
        this.modifyViewConfButton.setOnAction(event -> this.editContact());
        this.modifyViewCancelButton.setOnAction(event -> this.cancelModifyOperation());
        this.searchButton.setOnAction(event -> this.searchContact());
        this.searchCancelButton.setOnAction(event -> this.cancelSearch());
        this.saveOption.setOnAction(event -> this.saveRubrica());
        this.loadOption.setOnAction(event -> this.loadRubrica());

    }
    
    // Inizializzazione dei messaggi di notifica in caso di errore
    
    private void initNotify(){
        this.notifyLabel = new Label(" Contatto non valido. Inserire almeno nome o cognome,\n    eventuali numeri di telefono contenenti solo cifre,\neventuali indirizzi e-mail nella forma 'prefisso@domainName'");
        this.notifyFileLabel = new Label("Errore nel caricamento/salvataggio del file");
        //this.notifyLabel.setAlignment(Pos.CENTER);
    }
    
    // Annullamento dell'operazione di ricerca, il textfield per la ricerca viene svuotato ed � visualizzata nuovamente la lista originale
    
    private void cancelSearch(){
        HBox hbox = (HBox)this.searchCancelButton.getParent();
        hbox.getChildren().remove(this.searchCancelButton);
        //hbox.getChildren().add(this.searchButton);
        this.showRubrica();
        this.ricercaTf.clear();
    }
    
    private void cancelAddOperation(){
        this.resetNotify();
        this.stage.setScene(this.primaryScene);
        this.resetAddFields();
    }
    
    private void cancelModifyOperation(){
        this.resetNotify();
        this.stage.setScene(this.primaryScene);
        this.resetModifyFields();
    }
    
    private void resetNotify(){
        VBox v = (VBox)stage.getScene().getRoot();
        if(v.getChildren().contains(notifyLabel)){
            v.getChildren().remove(notifyLabel);
        }
        if(v.getChildren().contains(notifyFileLabel)){
            v.getChildren().remove(notifyFileLabel);
        }
    }
    
    // Svuota il contenuto dei textfield nella scena di aggiunta contatto
    
    private void resetAddFields(){
        for(int i = 0; i < 8; i++){
            this.addTf[i].clear();
        }
    }
    
    // Svuota il contenuto dei textfield nella scena di modifica contatto

    private void resetModifyFields(){
        for(int i = 0; i < 8; i++){
            this.modifyTf[i].clear();
        }
    }
    
    private void primaryAddAction(){
        
    }
    
    private void primaryModifyAction(){
        
    }
}
