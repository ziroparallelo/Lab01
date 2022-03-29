package it.polito.tdp.parole;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.parole.model.ParolaNonTrovata;
import it.polito.tdp.parole.model.Parole;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Parole model;
	
	private List<Float> tempo = new LinkedList<Float>();
	
    @FXML
    private TextArea txtTempo;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCancella;

    @FXML
    private Button btnInserisci;

    @FXML
    private Button btnReset;

    @FXML
    private TextField txtParola;

    @FXML
    private TextArea txtResult;

    @FXML
    void doCancella(ActionEvent event) 
    {
    	String s = txtParola.getText();
    	try {
			model.cancella(s);
			txtResult.setText(model.toString());
		} catch (ParolaNonTrovata e) {
			// TODO Auto-generated catch block
			System.err.println("Parola non trovata");
			txtResult.setText(model.toString()+"\n\nParola non trovata!");
		}
    	tempo.add((float) System.nanoTime());
    	txtTempo.setText(tempo.toString());
    }

    @FXML
    void doInsert(ActionEvent event) 
    {
    	String s = txtParola.getText();
    	model.addParola(s);
    	txtResult.setText(model.toString());
    	tempo.add((float) System.nanoTime());
    	txtTempo.setText(tempo.toString());
    }

    @FXML
    void doReset(ActionEvent event) 
    {
    	model.reset();
    	txtResult.clear();
    	tempo.add((float) System.nanoTime());
    	txtTempo.setText(tempo.toString());
    }
    
    public void setModel(Parole model)
    {
    	this.model = model;
    }
    
    @FXML
    void initialize() {
        assert btnCancella != null : "fx:id=\"btnCancella\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTempo != null : "fx:id=\"txtTempo\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
