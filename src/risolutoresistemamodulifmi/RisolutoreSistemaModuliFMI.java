/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package risolutoresistemamodulifmi;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author matti
 */
public class RisolutoreSistemaModuliFMI extends Application {
    
    @Override
    public void start(Stage primaryStage) {   
        
        Scene Esercizio2;
        Scene Esercizio3;
        Scene Esercizio4;
        
        //<editor-fold desc="Menu">
        Button btnEs2 = new Button("Esercizio 2");
        Button btnEs3 = new Button("Esercizio 3");
        Button btnEs4 = new Button("Esercizio 4");
        
        ToolBar menu = new ToolBar(
                btnEs2,
                new Separator(),
                btnEs3,
                new Separator(),
                btnEs4
        );
        
        //</editor-fold>
        
        //<editor-fold desc="Esercizio1 - Scena1">
        GridPane rootEs2 = new GridPane();
        GridPane GpSistema = new GridPane();
        
        Label Titolo = new Label("Inserisci i dati:");
        rootEs2.setConstraints(Titolo, 0, 0);
        Label LblSis1 = new Label("x = ");
        GpSistema.setConstraints(LblSis1, 0, 1);
        Label LblSis2 = new Label("x = ");
        GpSistema.setConstraints(LblSis2, 0, 2);
        
        ValueBox Operatore1 = new ValueBox();
        ValueBox Operatore2 = new ValueBox();
        ValueBox Modulo1 = new ValueBox();
        ValueBox Modulo2 = new ValueBox();
        GpSistema.setConstraints(Operatore1, 1, 1);
        GpSistema.setConstraints(Operatore2, 1, 2);
        Label LblMod1 = new Label(" (mod ");
        Label LblMod2 = new Label(" (mod ");
        GpSistema.setConstraints(LblMod1, 2, 1);
        GpSistema.setConstraints(LblMod2, 2, 2);
        GpSistema.setConstraints(Modulo1, 3, 1);
        GpSistema.setConstraints(Modulo2, 3, 2);
        Label LblModChius1 = new Label(" )");
        Label LblModChius2 = new Label(" )");
        GpSistema.setConstraints(LblModChius1, 4, 1);
        GpSistema.setConstraints(LblModChius2, 4, 2);
        
        GpSistema.getChildren().addAll(LblSis1, LblSis2, Operatore1, Operatore2, Modulo1, Modulo2, LblMod1, LblMod2, LblModChius2, LblModChius1);
        
        rootEs2.setConstraints(GpSistema, 0,1);
        
        Label lblRisultato = new Label();
        
        Button btnRisolviEs2 = new Button();
        btnRisolviEs2.setText("Risolvi");
        btnRisolviEs2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Risolutore risolutore = new Risolutore(Integer.parseInt(Operatore1.getText()),Integer.parseInt(Operatore2.getText()),Integer.parseInt(Modulo1.getText()),Integer.parseInt(Modulo2.getText()));
                lblRisultato.setText(risolutore.risolviSistema());
            }
        });
        
        rootEs2.setConstraints(lblRisultato, 0,3);
        
        
        
        Titolo.setPadding(new Insets(0,0,0,10));
        GpSistema.setPadding(new Insets(0,0,0,10));
        btnRisolviEs2.setMaxWidth(165);
        btnRisolviEs2.setMinWidth(165);
        HBox contenitore = new HBox();
        contenitore.getChildren().add(btnRisolviEs2);
        contenitore.setPadding(new Insets(0,0,0,10));
        rootEs2.setConstraints(contenitore, 0,2);
        lblRisultato.setPadding(new Insets(0,0,0,10));
        rootEs2.getChildren().addAll(Titolo, GpSistema, contenitore, lblRisultato, menu);
        
        rootEs2.getColumnConstraints().add(new ColumnConstraints(920));
        rootEs2.setVgap(15);
        
        
        Esercizio2 = new Scene(rootEs2, 920, 550);
        //</editor-fold>
        
        GridPane rootEs3 = new GridPane();
        rootEs3.getColumnConstraints().add(new ColumnConstraints(920));
        HBox HBEs3 = new HBox();
        HBEs3.setPadding(new Insets(10,0,0,10));
        Label LblX = new Label("x");
        LblX.setPadding(new Insets(12,0,0,0));
        ValueBox Esponente = new ValueBox();
        
        HBox HBInterna = new HBox();
        HBInterna.setPadding(new Insets(10,0,0,0));
        Label LblUguale = new Label(" = ");

        ValueBox Numero = new ValueBox();

        Label LblModulo = new Label(" mod ");

        ValueBox Modulo = new ValueBox();
        
        HBInterna.getChildren().addAll(LblUguale, Numero, LblModulo, Modulo);

        
        
        
        HBEs3.getChildren().addAll(LblX, Esponente,HBInterna );
        
        
        
        rootEs3.add(HBEs3, 0, 1);
        
        HBox contenitore2 = new HBox();
        contenitore2.setPadding(new Insets(10,0,0,10));
        Button btnRisolviEs3 = new Button("Risolvi");
        btnRisolviEs3.setMaxWidth(205);
        btnRisolviEs3.setMinWidth(205);
        contenitore2.getChildren().add(btnRisolviEs3);
        rootEs3.add(contenitore2, 0, 2);
        
        
        Esercizio3 = new Scene(rootEs3, 920, 550);
        
       
       
       GridPane rootEs4 = new GridPane();
       rootEs4.getColumnConstraints().add(new ColumnConstraints(920));

        Esercizio4 = new Scene(rootEs4, 920, 550);
        
       
       
       
       btnEs2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                rootEs3.getChildren().remove(menu);
                rootEs4.getChildren().remove(menu);
                rootEs2.getChildren().remove(menu);
                rootEs2.getChildren().add(menu);
                primaryStage.setScene(Esercizio2);
            }
        });
        
        btnEs3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               rootEs4.getChildren().remove(menu);
               rootEs2.getChildren().remove(menu);
               rootEs3.getChildren().remove(menu);
               rootEs3.getChildren().add(menu);
               primaryStage.setScene(Esercizio3);
            }
        });
        
        btnEs4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                rootEs3.getChildren().remove(menu);
                rootEs2.getChildren().remove(menu);
                rootEs4.getChildren().remove(menu);
                rootEs4.getChildren().add(menu);
                primaryStage.setScene(Esercizio4);
            }
        });
       
        
        primaryStage.setTitle("Risolutore Sistemi FMI");
        primaryStage.setScene(Esercizio2);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
