package holamundofx;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class HolaMundo2 extends Application {
	
	Label mensaje;
	Button helloButton;
	Button goodbyeButton;
	Button quitButton;

	@Override
	public void start(Stage stage) throws Exception {
		System.out.println("Ejecutándose el métodi start()");
		
		EventHandler<ActionEvent> manejadorEvento = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent evento) {
				Button boton = (Button) evento.getSource();
				
				if (boton.equals(helloButton)) {
					mensaje.setText("Hola Mundo");
					System.out.println(boton.getText());
				} else if (boton.equals(goodbyeButton)) {
					mensaje.setText("Adios");
				} else {
					Platform.exit();
				}
				
			}
	};
		
		
		mensaje = new Label("¡Primera aplicación FX!");
		//mensaje.setFont(new Font(40.0));
		
		// Cramos los botones
		
		helloButton = new Button("Di Hola");
		
		
//		// Creamos manejador de eventos.
//		helloButton.setOnAction(new EventHandler<ActionEvent>() {
//			
//			@Override
//			public void handle(ActionEvent arg0) {
//				mensaje.setText("Hola Mundo!!!!");
		        
//				
//			}
//		});
		
		// Expresión lambda
		
		helloButton.setOnAction(manejadorEvento);
		
		goodbyeButton = new Button("Di Adiós");
		goodbyeButton.setOnAction(manejadorEvento);
		
		quitButton = new Button("Terminar");
		quitButton.setOnAction(manejadorEvento);
		
		// Contenedor para los botones
		HBox botonera = new HBox(helloButton,goodbyeButton,quitButton);
		botonera.setSpacing(50);
		botonera.setPadding(new Insets(8));
	
		botonera.setAlignment(Pos.CENTER);
		
		
		BorderPane root = new BorderPane();
		
		root.setCenter(mensaje);
		
		root.setBottom(botonera);
		
		// Mete el scene grapg en el scene. El primer parámetro
		// es el node root del arbol de nodos. En este caso es 
		// el contenedor BorderPane
		
		Scene scene = new Scene(root, 450, 200);
		
		// Coloca el scene en la ventana (stage) 
		stage.setScene(scene);
		
		// Pone un título a la ventana
		stage.setTitle("Programa JavaFX");
		
		// Muestra la ventana.
		stage.show();
		

	}
	
	

	

	public static void main(String[] args) {
		System.out.println("Ejecutándose el métodi main()");

		launch(args);

	}

}
