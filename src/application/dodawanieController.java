package application;

import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.function.UnaryOperator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextFormatter.Change;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

public class dodawanieController {

	@FXML
	private Label datawyp;

	@FXML
	private TextField szesc;

	@FXML
	private DatePicker piec;

	@FXML
	private Label idkli1;

	@FXML
	private Label idwyp;

	@FXML
	private TextField piecT;
	
	@FXML
	private TextField siedem;

	@FXML
	private Button dodawaniePrzycisk;

	@FXML
	private Label miejscowosc;

	@FXML
	private TextField trzy;

	@FXML
	private Label datazwr;

	@FXML
	private TextField dwa;

	@FXML
	private TextField czteryT;

	@FXML
	private Label koszt;

	@FXML
	private Label imie;

	@FXML
	private Label idsam;

	@FXML
	private DatePicker cztery;

	@FXML
	private Label ulica;

	@FXML
	private Label nazwisko;

	@FXML
	private TextField jeden;

	@FXML
	private Label nrdowodu;

	@FXML
	private TextField id;

	@FXML
	private Label idkli;

	@FXML
	private Label idprac;
	
	@FXML
	private Label pojsil;
	
	@FXML
	private Label kosztdnia;
	
	@FXML
	private Label idsam1;
	
	@FXML
	private Label nrrej;
	
	@FXML
	private Label marka;
	
	@FXML
	private Label model;
	
	@FXML
	private Label rokprod;
	
	@FXML
	private Label krajprod;
	
	@FXML
	private Label idprac4;
	
	@FXML
	private Label telefon;
	
	@FXML
	private Label pesel;

	@FXML
	private ComboBox<String> combobox;
	
	@FXML
	private ComboBox<Sam> combobox1;
	
	@FXML
	ObservableList<Sam> oblist1 = FXCollections.observableArrayList();
	
	public ObservableList<Sam> IDSAMFUNC() throws ClassNotFoundException, SQLException {
		Statement stmt = zadania.DbAccess.DbAccess();

		ResultSet rs = stmt.executeQuery("SELECT id_sam, model FROM samochody");
		
		oblist1.clear();
		
		while(rs.next()) {
			oblist1.add(new Sam(rs.getInt("id_sam"), rs.getString("model")));
		}
		
		return oblist1;
	}
	
	@FXML
	private ComboBox<Prac> combobox2;
	
	@FXML
	ObservableList<Prac> oblist2 = FXCollections.observableArrayList();
	
	public ObservableList<Prac> IDPRACFUNC() throws ClassNotFoundException, SQLException {
		Statement stmt = zadania.DbAccess.DbAccess();

		ResultSet rs = stmt.executeQuery("SELECT id_prac, nazwisko, imie FROM pracownicy");
		
		oblist2.clear();
		
		while(rs.next()) {
			oblist2.add(new Prac(rs.getInt("id_prac"), rs.getString("nazwisko"), rs.getString("imie")));
		}
		
		return oblist2;
	}
	
	@FXML
	private ComboBox<Kli> combobox3;
	
	@FXML
	ObservableList<Kli> oblist3 = FXCollections.observableArrayList();
	
	public ObservableList<Kli> IDKLIFUNC() throws ClassNotFoundException, SQLException {
		Statement stmt = zadania.DbAccess.DbAccess();

		ResultSet rs = stmt.executeQuery("SELECT id_kli, nazwisko, imie FROM klienci");
		
		oblist3.clear();
		
		while(rs.next()) {
			oblist3.add(new Kli(rs.getInt("id_kli"), rs.getString("nazwisko"),  rs.getString("imie")));
		}
		
		return oblist3;
	}

	ObservableList<String> options = FXCollections.observableArrayList("Wypo¿yczenia", "Klienci", "Samochody", "Pracownicy");

	@FXML
	private void initialize() throws ClassNotFoundException, SQLException, IOException {
		combobox.getItems().addAll(options);
		combobox1.getItems().addAll(IDSAMFUNC());
		combobox2.getItems().addAll(IDPRACFUNC());
		combobox3.getItems().addAll(IDKLIFUNC());
		change(null);
	}

	//regexy
	//text
	UnaryOperator<Change> literkiFilter = change -> {
	    String newText = change.getControlNewText();
	    if (newText.matches("^[A-Z][A-Za-z]{0,24}$")) { 
	        return change;
	    }
	    return null;
	};
	
	UnaryOperator<Change> literki12Filter = change -> {
	    String newText = change.getControlNewText();
	    if (newText.matches("^[A-Z][A-Za-z]{0,11}$")) { 
	        return change;
	    }
	    return null;
	};
	
	UnaryOperator<Change> spacjaFilter = change -> {
	    String newText = change.getControlNewText();
	    if (newText.matches("^[A-Z][A-Za-z\\s]{0,24}$")) { 
	        return change;
	    }
	    return null;
	};
	
	UnaryOperator<Change> spacja12Filter = change -> {
	    String newText = change.getControlNewText();
	    if (newText.matches("^[A-Z][A-Za-z\\s]{0,11}$")) { 
	        return change;
	    }
	    return null;
	};
	
	//numerki
	//obce klucze musza byc uzupelnione bo alert, glowne id tabeli nie musi byc podane bo AI
	 UnaryOperator<Change> idFilter = change -> {
	    String newText = change.getControlNewText();
	    if (newText.matches("^[0-9]{0,4}")) { 
	        return change;
	    }
	    return null;
	};
	
	UnaryOperator<Change> telefonFilter = change -> {
	    String newText = change.getControlNewText();
	    if (newText.matches("^[0-9]{0,9}")) { 
	        return change;
	    }
	    return null;
	};
	
	UnaryOperator<Change> nrrejFilter = change -> {
	    String newText = change.getControlNewText();
	    if (newText.matches("^[A-Z-]{0,4}[A-Z0-9]{0,4}")) { 
	        return change;
	    }
	    return null;
	};
	
	UnaryOperator<Change> nrdowFilter = change -> {
	    String newText = change.getControlNewText();
	    if (newText.matches("^[A-Z]{0,2}[0-9]{0,7}+")) { 
	        return change;
	    }
	    return null;
	};
	
	UnaryOperator<Change> peselFilter = change -> {
	    String newText = change.getControlNewText();
	    if (newText.matches("^[0-9]{0,11}")) { 
	        return change;
	    }
	    return null;
	};
	
	//0,6 bo i tak nie moze  byc puste to sie alert zrobi, a jak calkiem zla kwota to latwiej zmienic
	UnaryOperator<Change> kosztFilter = change -> {
	    String newText = change.getControlNewText();
	    if (newText.matches("^[0-9]{0,6}")) { 
	        return change;
	    }
	    return null;
	};
	
	@FXML
	void change(ActionEvent event) throws IOException {
		
		id.clear();
		jeden.clear();
		dwa.clear();
		trzy.clear();
		cztery.setValue(null);
		czteryT.clear();
		piec.setValue(null);
		piecT.clear();
		szesc.clear();
		siedem.clear();

//		id.setVisible(true);
		id.setTextFormatter(new TextFormatter<Integer>(idFilter));
		combobox1.setVisible(false);
		combobox2.setVisible(false);
		combobox3.setVisible(false);
		jeden.setVisible(false);
		dwa.setVisible(false);
		trzy.setVisible(false);
		cztery.setVisible(false);
		czteryT.setVisible(false);
		piec.setVisible(false);
		piecT.setVisible(false);
		szesc.setVisible(false);
		siedem.setVisible(false);
		
		idwyp.setVisible(false);
		idsam.setVisible(false);
		idprac.setVisible(false);
		idkli.setVisible(false);
		datawyp.setVisible(false);
		datazwr.setVisible(false);
		koszt.setVisible(false);
		
		idkli1.setVisible(false);
		nazwisko.setVisible(false);
		imie.setVisible(false);
		nrdowodu.setVisible(false);
		miejscowosc.setVisible(false);
		ulica.setVisible(false);
		
		idsam1.setVisible(false);
		nrrej.setVisible(false);
		marka.setVisible(false);
		model.setVisible(false);
		rokprod.setVisible(false);
		krajprod.setVisible(false);
		pojsil.setVisible(false);
		kosztdnia.setVisible(false);
		
		idprac4.setVisible(false);
		telefon.setVisible(false);
		pesel.setVisible(false);
		
		if (combobox.getValue().equals("Wypo¿yczenia")) {
			combobox1.setVisible(true);
			combobox2.setVisible(true);
			combobox3.setVisible(true);
			cztery.setVisible(true);
			piec.setVisible(true);
			szesc.setVisible(true);
			szesc.setTextFormatter(new TextFormatter<Integer>(kosztFilter));
			
//			idwyp.setVisible(true);
			idsam.setVisible(true);
			idprac.setVisible(true);
			idkli.setVisible(true);
			datawyp.setVisible(true);
			datazwr.setVisible(true);
			koszt.setVisible(true);

		} else if (combobox.getValue().equals("Klienci")) {
			jeden.setVisible(true);
			jeden.setTextFormatter(new TextFormatter<String>(literkiFilter));
			dwa.setVisible(true);
			dwa.setTextFormatter(new TextFormatter<String>(literkiFilter));
			trzy.setVisible(true);
			trzy.setTextFormatter(new TextFormatter<Integer>(nrdowFilter));
			czteryT.setVisible(true);
			czteryT.setTextFormatter(new TextFormatter<String>(spacjaFilter));
			piecT.setVisible(true);
			piecT.setTextFormatter(new TextFormatter<String>(literkiFilter));
			
//			idkli1.setVisible(true);
			nazwisko.setVisible(true);
			imie.setVisible(true);
			nrdowodu.setVisible(true);
			miejscowosc.setVisible(true);
			ulica.setVisible(true);
		} else if(combobox.getValue().equals("Samochody")) {
			jeden.setVisible(true);
			jeden.setTextFormatter(new TextFormatter<String>(nrrejFilter));
			dwa.setVisible(true);
			dwa.setTextFormatter(new TextFormatter<String>(literki12Filter));
			trzy.setVisible(true);
			trzy.setTextFormatter(new TextFormatter<String>(literki12Filter));
			czteryT.setVisible(true);
			czteryT.setTextFormatter(new TextFormatter<Integer>(idFilter));
			piecT.setVisible(true);
			piecT.setTextFormatter(new TextFormatter<String>(spacja12Filter));
			szesc.setVisible(true);
			szesc.setTextFormatter(new TextFormatter<Integer>(idFilter));
			siedem.setVisible(true);
			siedem.setTextFormatter(new TextFormatter<Integer>(kosztFilter));
			
//			idsam1.setVisible(true);
			nrrej.setVisible(true);
			marka.setVisible(true);
			model.setVisible(true);
			rokprod.setVisible(true);
			krajprod.setVisible(true);
			pojsil.setVisible(true);
			kosztdnia.setVisible(true);
		} else if(combobox.getValue().equals("Pracownicy")) {
			jeden.setVisible(true);
			jeden.setTextFormatter(new TextFormatter<String>(literkiFilter));
			dwa.setVisible(true);
			dwa.setTextFormatter(new TextFormatter<String>(literkiFilter));
			trzy.setVisible(true);
			trzy.setTextFormatter(new TextFormatter<Integer>(telefonFilter));
			czteryT.setVisible(true);
			czteryT.setTextFormatter(new TextFormatter<Integer>(peselFilter));
			
//			idprac4.setVisible(true);
			nazwisko.setVisible(true);
			imie.setVisible(true);
			telefon.setVisible(true);
			pesel.setVisible(true);
			
		}
	}

	@FXML
	void dodaj(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
		
		if (
			(combobox.getValue().equals("Wypo¿yczenia") && (combobox1.getValue() == null || combobox2.getValue() == null || combobox3.getValue() == null 
				|| cztery.getValue() == null || piec.getValue() == null || szesc.getText().trim().isEmpty() || cztery.getValue().isAfter(piec.getValue()))) ||
			(combobox.getValue().equals("Klienci") && (jeden.getText().trim().isEmpty() || dwa.getText().trim().isEmpty() || trzy.getText().trim().isEmpty() || !trzy.getText().matches("^[A-Z]{2}[0-9]{7}")
				|| czteryT.getText().trim().isEmpty() || piecT.getText().trim().isEmpty() )) ||
			(combobox.getValue().equals("Samochody") && (jeden.getText().trim().isEmpty() || !jeden.getText().matches("^[A-Z]{3}\\-[A-Z0-9]{4}") || dwa.getText().trim().isEmpty() || trzy.getText().trim().isEmpty() 
				|| czteryT.getText().trim().isEmpty() || piecT.getText().trim().isEmpty() || szesc.getText().trim().isEmpty() || siedem.getText().trim().isEmpty() )) ||
			(combobox.getValue().equals("Pracownicy") && (jeden.getText().trim().isEmpty() || dwa.getText().trim().isEmpty() || trzy.getText().trim().isEmpty() || trzy.getText().length() != 9
				|| czteryT.getText().trim().isEmpty() || czteryT.getText().length() != 11))
				) {
			zadania.DbAccess.showAlertWarning(null, "Ka¿de pole musi byæ uzupe³nione poprawnie!");
			return;
		}

		try {
			if (combobox.getValue().equals("Wypo¿yczenia"))
				if (id.getText().isEmpty())
					zadania.DbAccess.Dodaj(null, combobox1.getSelectionModel().getSelectedItem().getID(), combobox2.getSelectionModel().getSelectedItem().getID(),
							combobox3.getSelectionModel().getSelectedItem().getID(), Date.valueOf(cztery.getValue()),
							Date.valueOf(piec.getValue()), Integer.parseInt(szesc.getText()));
				else
					zadania.DbAccess.Dodaj(Integer.parseInt(id.getText()), combobox1.getSelectionModel().getSelectedItem().getID(),
							combobox2.getSelectionModel().getSelectedItem().getID(), combobox3.getSelectionModel().getSelectedItem().getID(),
							Date.valueOf(cztery.getValue()), Date.valueOf(piec.getValue()),
							Integer.parseInt(szesc.getText()));
			else if (combobox.getValue().equals("Klienci"))
				if (id.getText().isEmpty())
					zadania.DbAccess.Dodaj2(null, jeden.getText(), dwa.getText(), trzy.getText(), czteryT.getText(),
							piecT.getText());
				else
					zadania.DbAccess.Dodaj2(Integer.parseInt(id.getText()), jeden.getText(), dwa.getText(),
							trzy.getText(), czteryT.getText(), piecT.getText());
			else if (combobox.getValue().equals("Samochody"))
				if (id.getText().isEmpty())
					zadania.DbAccess.Dodaj3(null, jeden.getText(), dwa.getText(), trzy.getText(),
							Integer.parseInt(czteryT.getText()), piecT.getText(), Integer.parseInt(szesc.getText()),
							Integer.parseInt(siedem.getText()));
				else
					zadania.DbAccess.Dodaj3(Integer.parseInt(id.getText()), jeden.getText(), dwa.getText(),
							trzy.getText(), Integer.parseInt(czteryT.getText()), piecT.getText(),
							Integer.parseInt(szesc.getText()), Integer.parseInt(siedem.getText()));
			else if (combobox.getValue().equals("Pracownicy"))
				if (id.getText().isEmpty())
					zadania.DbAccess.Dodaj4(null, jeden.getText(), dwa.getText(), trzy.getText(), czteryT.getText());
				else
					zadania.DbAccess.Dodaj4(Integer.parseInt(id.getText()), jeden.getText(), dwa.getText(),
							trzy.getText(), czteryT.getText());
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR, "Któregoœ ID nie ma prawdopodobnie w tabelach.", ButtonType.OK);
			alert.setTitle("Œmieræ");
			alert.setHeaderText("B³¹d zwi¹zany z relacjami tabel!");
			((Stage) alert.getDialogPane().getScene().getWindow()).setAlwaysOnTop(true);
			alert.showAndWait();
			return;
		}

		((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
	}
}
