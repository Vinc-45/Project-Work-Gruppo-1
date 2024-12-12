package it.unisa.diem.softeng.gruppo1;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * @brief Classe che inizializza l'applicazione.
 */
public class Rubrica extends Application {

    public static void main(String args[]) {
        
        
    launch(args);
   
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        GestioneRubrica rubrica = new GestioneRubrica();
        InterfacciaUtente view = new InterfacciaUtente(rubrica);
        view.setStage(primaryStage);
        Stage stage = view.getStage();
        stage.setScene(view.getPrimaryScene());
        stage.show();
    }
} 
