package application;


import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.converter.DateStringConverter;
import javafx.util.converter.IntegerStringConverter;

public class MainController {
	
	@FXML
    private CheckBox editButton;
	
	@FXML
    private CheckBox constraintButton;

	@FXML
	private Button Dodaj;

	@FXML
	private Button Usun;

	@FXML
	private Button Szukaj;
	
	@FXML
	private Button Szczegoly;
	
	@FXML
	private Button odswiez;
	
	@FXML
    private javafx.scene.control.TabPane TabPane;
	
	@FXML
    public Tab WYPOZYCZENIA;
	
	@FXML
    public Tab KLIENCI;
	
	@FXML
    public Tab SAMOCHODY;
	
	@FXML
    public Tab PRACOWNICY;

	@FXML
	public TableView<Wypozyczenia> tableView;
	
	@FXML
	public TableView<Klienci> tableView1;
	
	@FXML
	public TableView<Samochody> tableView2;
	
	@FXML
	public TableView<Pracownicy> tableView3;

	//wypozyczenia
	
	@FXML
	private TableColumn<Wypozyczenia, Integer> ID_WYP;

	@FXML
	private TableColumn<Wypozyczenia, String> SAMOCHOD;

	@FXML
	private TableColumn<Wypozyczenia, String> PRACOWNIK;
	
	@FXML
	private TableColumn<Wypozyczenia, String> PRACOWNIKIMIE;
	
	@FXML
	private TableColumn<Wypozyczenia, String> KLIENT;
	
	@FXML
	private TableColumn<Wypozyczenia, String> KLIENTIMIE;
	
	@FXML
	private TableColumn<Wypozyczenia, Date> DATA_WYP;
	
	@FXML
	private TableColumn<Wypozyczenia, Date> DATA_ZWR;
	
	@FXML
	private TableColumn<Wypozyczenia, Integer> KOSZT;
	
	//klienci
	
	@FXML
	private TableColumn<Klienci, Integer> ID_KLI1;
	
	@FXML
	private TableColumn<Klienci, String> NAZWISKO1;
	
	@FXML
	private TableColumn<Klienci, String> IMIE;
	
	@FXML
	private TableColumn<Klienci, String> NR_DOWODU;
	
	@FXML
	private TableColumn<Klienci, String> MIEJSCOWOSC;
	
	@FXML
	private TableColumn<Klienci, String> ULICA;
	
	//samochody
	@FXML
	private TableColumn<Samochody, Integer> ID_SAM2;
	
	@FXML
	private TableColumn<Samochody, String> NR_REJ;
	
	@FXML
	private TableColumn<Samochody, String> MARKA;
	
	@FXML
	private TableColumn<Samochody, String> MODEL;
	
	@FXML
	private TableColumn<Samochody, Integer> ROK_PROD;
	
	@FXML
	private TableColumn<Samochody, String> KRAJ_PROD;
	
	@FXML
	private TableColumn<Samochody, Integer> POJ_SIL;
	
	@FXML
	private TableColumn<Samochody, Integer> KOSZT_DNIA;
	
	//pracownicy
	
	@FXML
	private TableColumn<Pracownicy, Integer> ID_PRAC3;
	
	@FXML
	private TableColumn<Pracownicy, String> IMIE3;
	
	@FXML
	private TableColumn<Pracownicy, String> NAZWISKO3;
	
	@FXML
	private TableColumn<Pracownicy, String> TELEFON;
	
	@FXML
	private TableColumn<Pracownicy, String> PESEL;

	@FXML
	ObservableList<Wypozyczenia> oblist = FXCollections.observableArrayList();
	
	@FXML
	ObservableList<Klienci> oblist1 = FXCollections.observableArrayList();
	
	@FXML
	ObservableList<Samochody> oblist2 = FXCollections.observableArrayList();
	
	@FXML
	ObservableList<Pracownicy> oblist3 = FXCollections.observableArrayList();
	
	@FXML
    private ComboBox<String> comboboxSZKOL;

    @FXML
    private ComboBox<String> comboboxSZ;
	
	ObservableList<String> options = FXCollections.observableArrayList("Wypo¿yczenia", "Klienci", "Samochody", "Pracownicy");
    
    ObservableList<String> optionsSZ1 = FXCollections.observableArrayList("ID_WYP", "MODEL", "KLIENT_NAZW", "PRACOWNIK_NAZW", "KOSZT");
    
    ObservableList<String> optionsSZ2 = FXCollections.observableArrayList("ID_KLI", "IMIE", "NAZWISKO", "NR_DOWODU", "MIEJSCOWOSC");
    
    ObservableList<String> optionsSZ3 = FXCollections.observableArrayList("ID_SAM", "NR_REJ", "MARKA", "MODEL", "ROK_PROD", "POJ_SIL");
    
    ObservableList<String> optionsSZ4 = FXCollections.observableArrayList("ID_PRAC","NAZWISKO", "IMIE", "TELEFON", "PESEL");
    
    @FXML
    private TextField textfieldSZ;
	
	@FXML
	private void initialize() throws ClassNotFoundException, SQLException {

		comboboxSZ.getItems().addAll(options);
    	comboboxSZKOL.getItems().addAll(optionsSZ1);
    	
		comboboxSZ.getSelectionModel().select(0);
		comboboxSZKOL.getSelectionModel().select(0);
		
		refresh();
		
		tableView.setEditable(false);
		tableView1.setEditable(false);
		tableView2.setEditable(false);
		tableView3.setEditable(false);

		zadania.DbAccess.ConstraintOn();
	}
	
	//WYPOZYCZENIA EDIT
	//ID JEST WALIDOWANE
	
	@FXML
    void edit1wyp(CellEditEvent<Wypozyczenia, Integer> event) throws ClassNotFoundException, SQLException {
		Statement stmt = zadania.DbAccess.DbAccess();
		Wypozyczenia wypozyczenie = tableView.getSelectionModel().getSelectedItem();
		if(event.getNewValue() == null) { zadania.DbAccess.showAlertWarning(null, "Pole nie mo¿e byæ puste!"); refresh(); return; }
		
		Boolean check = tableView.getItems().stream().anyMatch(Check -> event.getNewValue().equals(Check.getId_wyp()));
		if(event.getNewValue() == -1) { refresh(); return; }
		
		
			if(!check)
				stmt.executeUpdate("UPDATE `wypozyczenia` SET `id_wyp`='"+event.getNewValue()+"' WHERE id_wyp = '"+wypozyczenie.getId_wyp()+"'");
			else 
				zadania.DbAccess.showAlertWarning(null, "Ju¿ jest takie id!");

			refresh();
    }
	
	@FXML
    void edit1sam(CellEditEvent<Wypozyczenia, Integer> event) throws ClassNotFoundException, SQLException {
		Statement stmt = zadania.DbAccess.DbAccess();
		Wypozyczenia wypozyczenie = tableView.getSelectionModel().getSelectedItem();
		if(String.valueOf(event.getNewValue()).isEmpty()) { zadania.DbAccess.showAlertWarning(null, "Pole nie mo¿e byæ puste!"); refresh(); return; }
		
			stmt.executeUpdate("UPDATE `samochody`, `wypozyczenia` SET `model`='"+event.getNewValue()+"' WHERE samochody.id_sam = wypozyczenia.id_sam AND wypozyczenia.id_wyp = '"+wypozyczenie.getId_wyp()+"'");
			
			refresh();
    }

    @FXML
    void edit1prac(CellEditEvent<Wypozyczenia, Integer> event) throws ClassNotFoundException, SQLException {
    	Statement stmt = zadania.DbAccess.DbAccess();
		Wypozyczenia wypozyczenie = tableView.getSelectionModel().getSelectedItem();
		if(String.valueOf(event.getNewValue()).isEmpty()) { zadania.DbAccess.showAlertWarning(null, "Pole nie mo¿e byæ puste!"); refresh(); return; }
		
		stmt.executeUpdate("UPDATE `pracownicy`, `wypozyczenia` SET `nazwisko`='"+event.getNewValue()+"' WHERE pracownicy.id_prac = wypozyczenia.id_prac AND wypozyczenia.id_wyp = '"+wypozyczenie.getId_wyp()+"'");
    
		refresh();
    }
    
    @FXML
    void edit1pracimie(CellEditEvent<Wypozyczenia, Integer> event) throws ClassNotFoundException, SQLException {
    	Statement stmt = zadania.DbAccess.DbAccess();
		Wypozyczenia wypozyczenie = tableView.getSelectionModel().getSelectedItem();
		if(String.valueOf(event.getNewValue()).isEmpty()) { zadania.DbAccess.showAlertWarning(null, "Pole nie mo¿e byæ puste!"); refresh(); return; }
		
		stmt.executeUpdate("UPDATE `pracownicy`, `wypozyczenia` SET `imie`='"+event.getNewValue()+"' WHERE pracownicy.id_prac = wypozyczenia.id_prac AND wypozyczenia.id_wyp = '"+wypozyczenie.getId_wyp()+"'");
    
		refresh();
    }

    @FXML
    void edit1kli(CellEditEvent<Wypozyczenia, Integer> event) throws ClassNotFoundException, SQLException {
    	Statement stmt = zadania.DbAccess.DbAccess();
		Wypozyczenia wypozyczenie = tableView.getSelectionModel().getSelectedItem();
		if(String.valueOf(event.getNewValue()).isEmpty()) { zadania.DbAccess.showAlertWarning(null, "Pole nie mo¿e byæ puste!"); refresh(); return; }
		
		stmt.executeUpdate("UPDATE `klienci`, `wypozyczenia` SET `nazwisko`='"+event.getNewValue()+"' WHERE klienci.id_kli = wypozyczenia.id_kli AND wypozyczenia.id_wyp = '"+wypozyczenie.getId_wyp()+"'");
    
		refresh();
    }
    
    @FXML
    void edit1kliimie(CellEditEvent<Wypozyczenia, Integer> event) throws ClassNotFoundException, SQLException {
    	Statement stmt = zadania.DbAccess.DbAccess();
		Wypozyczenia wypozyczenie = tableView.getSelectionModel().getSelectedItem();
		if(String.valueOf(event.getNewValue()).isEmpty()) { zadania.DbAccess.showAlertWarning(null, "Pole nie mo¿e byæ puste!"); refresh(); return; }
		
		stmt.executeUpdate("UPDATE `klienci`, `wypozyczenia` SET `imie`='"+event.getNewValue()+"' WHERE klienci.id_kli = wypozyczenia.id_kli AND wypozyczenia.id_wyp = '"+wypozyczenie.getId_wyp()+"'");
    
		refresh();
    }

    @FXML
    void edit1datawyp(CellEditEvent<Wypozyczenia, Date> event) throws ClassNotFoundException, SQLException {
    	Statement stmt = zadania.DbAccess.DbAccess();
		Wypozyczenia wypozyczenie = tableView.getSelectionModel().getSelectedItem();
		if(String.valueOf(event.getNewValue()).isEmpty()) { zadania.DbAccess.showAlertWarning(null, "Pole nie mo¿e byæ puste!"); refresh(); return; }
		
		String data = new SimpleDateFormat("yyyyy-MM-dd").format(event.getNewValue()); 
		
		stmt.executeUpdate("UPDATE `wypozyczenia` SET `data_wyp`='"+data+"' WHERE id_wyp = '"+wypozyczenie.getId_wyp()+"'");
    
		refresh();
    }

    @FXML
    void edit1datazwr(CellEditEvent<Wypozyczenia, Date> event) throws ClassNotFoundException, SQLException {
    	Statement stmt = zadania.DbAccess.DbAccess();
		Wypozyczenia wypozyczenie = tableView.getSelectionModel().getSelectedItem();
		if(String.valueOf(event.getNewValue()).isEmpty()) { zadania.DbAccess.showAlertWarning(null, "Pole nie mo¿e byæ puste!"); refresh(); return; }
		
		String data = new SimpleDateFormat("yyyyy-MM-dd").format(event.getNewValue());
		
		stmt.executeUpdate("UPDATE `wypozyczenia` SET `data_zwr`='"+data+"' WHERE id_wyp = '"+wypozyczenie.getId_wyp()+"'");
    
		refresh();
    }

    @FXML
    void edit1koszt(CellEditEvent<Wypozyczenia, Integer> event) throws ClassNotFoundException, SQLException {
    	Statement stmt = zadania.DbAccess.DbAccess();
		Wypozyczenia wypozyczenie = tableView.getSelectionModel().getSelectedItem();
		if(event.getNewValue() == -1) { refresh(); return; }
		if(event.getNewValue() == null) { zadania.DbAccess.showAlertWarning(null, "Pole nie mo¿e byæ puste!"); refresh(); return; }
		
		stmt.executeUpdate("UPDATE `wypozyczenia` SET `koszt`='"+event.getNewValue()+"' WHERE id_wyp = '"+wypozyczenie.getId_wyp()+"'");
    
		refresh();
    }
    
    //KLIENCI
    
    @FXML
    void edit2kli(CellEditEvent<Klienci, Integer> event) throws ClassNotFoundException, SQLException {
    	Statement stmt = zadania.DbAccess.DbAccess();
		Klienci klient = tableView1.getSelectionModel().getSelectedItem();
		if(event.getNewValue() == null) { zadania.DbAccess.showAlertWarning(null, "Pole nie mo¿e byæ puste!"); refresh2(); return; }
		
		Boolean check = tableView1.getItems().stream().anyMatch(Check -> event.getNewValue().equals(Check.getId_kli()));
		if(event.getNewValue() == -1) { refresh2(); return; }
		
		if(!check)
			stmt.executeUpdate("UPDATE `klienci` SET `id_kli`='"+event.getNewValue()+"' WHERE id_kli = '"+klient.getId_kli()+"'");
		else 
			zadania.DbAccess.showAlertWarning(null, "Ju¿ jest takie id!");
		
		refresh2();
	}

    @FXML
    void edit2nazwisko(CellEditEvent<Klienci, String> event) throws ClassNotFoundException, SQLException {
    	Statement stmt = zadania.DbAccess.DbAccess();
		Klienci klient = tableView1.getSelectionModel().getSelectedItem();
		if(String.valueOf(event.getNewValue()).isEmpty()) { zadania.DbAccess.showAlertWarning(null, "Pole nie mo¿e byæ puste!"); refresh2(); return; }
		
		stmt.executeUpdate("UPDATE `klienci` SET `nazwisko`='"+event.getNewValue()+"' WHERE id_kli = '"+klient.getId_kli()+"'");
		
		refresh2();
    }

    @FXML
    void edit2imie(CellEditEvent<Klienci, String> event) throws ClassNotFoundException, SQLException {
    	Statement stmt = zadania.DbAccess.DbAccess();
		Klienci klient = tableView1.getSelectionModel().getSelectedItem();
		if(String.valueOf(event.getNewValue()).isEmpty()) { zadania.DbAccess.showAlertWarning(null, "Pole nie mo¿e byæ puste!"); refresh2(); return; }
		
		stmt.executeUpdate("UPDATE `klienci` SET `imie`='"+event.getNewValue()+"' WHERE id_kli = '"+klient.getId_kli()+"'");
		
		refresh2();
    }

    @FXML
    void edit2nrdowodu(CellEditEvent<Klienci, String> event) throws ClassNotFoundException, SQLException {
    	Statement stmt = zadania.DbAccess.DbAccess();
		Klienci klient = tableView1.getSelectionModel().getSelectedItem();
		if(String.valueOf(event.getNewValue()).isEmpty()) { zadania.DbAccess.showAlertWarning(null, "Pole nie mo¿e byæ puste!"); refresh2(); return; }
		
		stmt.executeUpdate("UPDATE `klienci` SET `nr_dowodu`='"+event.getNewValue()+"' WHERE id_kli = '"+klient.getId_kli()+"'");
		
		refresh2();
    }

    @FXML
    void edit2miejscowosc(CellEditEvent<Klienci, String> event) throws ClassNotFoundException, SQLException {
    	Statement stmt = zadania.DbAccess.DbAccess();
		Klienci klient = tableView1.getSelectionModel().getSelectedItem();
		if(String.valueOf(event.getNewValue()).isEmpty()) { zadania.DbAccess.showAlertWarning(null, "Pole nie mo¿e byæ puste!"); refresh2(); return; }
		
		stmt.executeUpdate("UPDATE `klienci` SET `miejscowosc`='"+event.getNewValue()+"' WHERE id_kli = '"+klient.getId_kli()+"'");

		refresh2();
    }

    @FXML
    void edit2ulica(CellEditEvent<Klienci, String> event) throws ClassNotFoundException, SQLException {
    	Statement stmt = zadania.DbAccess.DbAccess();
		Klienci klient = tableView1.getSelectionModel().getSelectedItem();
		if(String.valueOf(event.getNewValue()).isEmpty()) { zadania.DbAccess.showAlertWarning(null, "Pole nie mo¿e byæ puste!"); refresh2(); return; }
		
		stmt.executeUpdate("UPDATE `klienci` SET `ulica`='"+event.getNewValue()+"' WHERE id_kli = '"+klient.getId_kli()+"'");
		
		refresh2();
    }
    
    //SAMOCHODY EDIT

    @FXML
    void edit3sam(CellEditEvent<Samochody, Integer> event) throws ClassNotFoundException, SQLException {
    	Statement stmt = zadania.DbAccess.DbAccess();
		Samochody samochod = tableView2.getSelectionModel().getSelectedItem();
		if(event.getNewValue() == null) { zadania.DbAccess.showAlertWarning(null, "Pole nie mo¿e byæ puste!"); refresh3(); return; }
		
		Boolean check = tableView2.getItems().stream().anyMatch(Check -> event.getNewValue().equals(Check.getId_sam()));
		if(event.getNewValue() == -1) { refresh3(); return; }
		
		if(!check)
			stmt.executeUpdate("UPDATE `samochody` SET `id_sam`='"+event.getNewValue()+"' WHERE id_sam = '"+samochod.getId_sam()+"'");
		else
			zadania.DbAccess.showAlertWarning(null, "Ju¿ jest takie id!");
		
		refresh3();
    }

    @FXML
    void edit3nrrej(CellEditEvent<Samochody, String> event) throws ClassNotFoundException, SQLException {
    	Statement stmt = zadania.DbAccess.DbAccess();
		Samochody samochod = tableView2.getSelectionModel().getSelectedItem();
		if(String.valueOf(event.getNewValue()).isEmpty()) { zadania.DbAccess.showAlertWarning(null, "Pole nie mo¿e byæ puste!"); refresh3(); return; }
		
		stmt.executeUpdate("UPDATE `samochody` SET `nr_rej`='"+event.getNewValue()+"' WHERE id_sam = '"+samochod.getId_sam()+"'");
		
		refresh3();
    }

    @FXML
    void edit3marka(CellEditEvent<Samochody, String> event) throws ClassNotFoundException, SQLException {
    	Statement stmt = zadania.DbAccess.DbAccess();
		Samochody samochod = tableView2.getSelectionModel().getSelectedItem();
		if(String.valueOf(event.getNewValue()).isEmpty()) { zadania.DbAccess.showAlertWarning(null, "Pole nie mo¿e byæ puste!"); refresh3(); return; }
		
		stmt.executeUpdate("UPDATE `samochody` SET `marka`='"+event.getNewValue()+"' WHERE id_sam = '"+samochod.getId_sam()+"'");
		
		refresh3();
    }

    @FXML
    void edit3model(CellEditEvent<Samochody, String> event) throws ClassNotFoundException, SQLException {
    	Statement stmt = zadania.DbAccess.DbAccess();
		Samochody samochod = tableView2.getSelectionModel().getSelectedItem();
		if(String.valueOf(event.getNewValue()).isEmpty()) { zadania.DbAccess.showAlertWarning(null, "Pole nie mo¿e byæ puste!"); refresh3(); return; }
		
		stmt.executeUpdate("UPDATE `samochody` SET `model`='"+event.getNewValue()+"' WHERE id_sam = '"+samochod.getId_sam()+"'");
		
		refresh3();
    }

    @FXML
    void edit3rokprod(CellEditEvent<Samochody, Integer> event) throws ClassNotFoundException, SQLException {
    	Statement stmt = zadania.DbAccess.DbAccess();
		Samochody samochod = tableView2.getSelectionModel().getSelectedItem();
		if(event.getNewValue() == -1) { refresh2(); return; }
		if(event.getNewValue() == null) { zadania.DbAccess.showAlertWarning(null, "Pole nie mo¿e byæ puste!"); refresh3(); return; }
		
		stmt.executeUpdate("UPDATE `samochody` SET `rok_prod`='"+event.getNewValue()+"' WHERE id_sam = '"+samochod.getId_sam()+"'");
		
		refresh3();
    }

    @FXML
    void edit3krajprod(CellEditEvent<Samochody, String> event) throws ClassNotFoundException, SQLException {
    	Statement stmt = zadania.DbAccess.DbAccess();
		Samochody samochod = tableView2.getSelectionModel().getSelectedItem();
		if(String.valueOf(event.getNewValue()).isEmpty()) { zadania.DbAccess.showAlertWarning(null, "Pole nie mo¿e byæ puste!"); refresh3(); return; }
		
		stmt.executeUpdate("UPDATE `samochody` SET `kraj_prod`='"+event.getNewValue()+"' WHERE id_sam = '"+samochod.getId_sam()+"'");
		
		refresh3();
    }

    @FXML
    void edit3pojsil(CellEditEvent<Samochody, Integer> event) throws ClassNotFoundException, SQLException {
    	Statement stmt = zadania.DbAccess.DbAccess();
		Samochody samochod = tableView2.getSelectionModel().getSelectedItem();
		if(event.getNewValue() == -1) { refresh3(); return; }
		if(event.getNewValue() == null) { zadania.DbAccess.showAlertWarning(null, "Pole nie mo¿e byæ puste!"); refresh3(); return; }
		
		stmt.executeUpdate("UPDATE `samochody` SET `poj_sil`='"+event.getNewValue()+"' WHERE id_sam = '"+samochod.getId_sam()+"'");
		
		refresh3();
    }

    @FXML
    void edit3kosztdnia(CellEditEvent<Samochody, Integer> event) throws ClassNotFoundException, SQLException {
    	Statement stmt = zadania.DbAccess.DbAccess();
		Samochody samochod = tableView2.getSelectionModel().getSelectedItem();
		if(event.getNewValue() == -1) { refresh3(); return; }
		if(event.getNewValue() == null) { zadania.DbAccess.showAlertWarning(null, "Pole nie mo¿e byæ puste!"); refresh3(); return; }
		
		stmt.executeUpdate("UPDATE `samochody` SET `koszt_dnia`='"+event.getNewValue()+"' WHERE id_sam = '"+samochod.getId_sam()+"'");
		
		refresh3();
    }

    //PRACOWNICY EDIT
    
    @FXML
    void edit4prac(CellEditEvent<Pracownicy, Integer> event) throws ClassNotFoundException, SQLException {
    	Statement stmt = zadania.DbAccess.DbAccess();
		Pracownicy pracownik = tableView3.getSelectionModel().getSelectedItem();
		if(event.getNewValue() == null) { zadania.DbAccess.showAlertWarning(null, "Pole nie mo¿e byæ puste!"); refresh4(); return; }
		
		Boolean check = tableView3.getItems().stream().anyMatch(Check -> event.getNewValue().equals(Check.getId_prac()));
		if(event.getNewValue() == -1) { refresh4(); return; }
		
		if(!check)
			stmt.executeUpdate("UPDATE `pracownicy` SET `id_prac`='"+event.getNewValue()+"' WHERE id_prac = '"+pracownik.getId_prac()+"'");
		else
			zadania.DbAccess.showAlertWarning(null, "Ju¿ jest takie id!");
		
		refresh4();
    }

    @FXML
    void edit4nazwisko(CellEditEvent<Pracownicy, String> event) throws ClassNotFoundException, SQLException {
    	Statement stmt = zadania.DbAccess.DbAccess();
		Pracownicy pracownik = tableView3.getSelectionModel().getSelectedItem();
		if(String.valueOf(event.getNewValue()).isEmpty()) { zadania.DbAccess.showAlertWarning(null, "Pole nie mo¿e byæ puste!"); refresh4(); return; }
		
		stmt.executeUpdate("UPDATE `pracownicy` SET `nazwisko`='"+event.getNewValue()+"' WHERE id_prac = '"+pracownik.getId_prac()+"'");

		refresh4();
    }

    @FXML
    void edit4imie(CellEditEvent<Pracownicy, String> event) throws ClassNotFoundException, SQLException {
    	Statement stmt = zadania.DbAccess.DbAccess();
		Pracownicy pracownik = tableView3.getSelectionModel().getSelectedItem();
		if(String.valueOf(event.getNewValue()).isEmpty()) { zadania.DbAccess.showAlertWarning(null, "Pole nie mo¿e byæ puste!"); refresh4(); return; }
		
		stmt.executeUpdate("UPDATE `pracownicy` SET `imie`='"+event.getNewValue()+"' WHERE id_prac = '"+pracownik.getId_prac()+"'");

		refresh4();
    }

    @FXML
    void edit4telefon(CellEditEvent<Pracownicy, String> event) throws ClassNotFoundException, SQLException {
    	Statement stmt = zadania.DbAccess.DbAccess();
		Pracownicy pracownik = tableView3.getSelectionModel().getSelectedItem();
		if(String.valueOf(event.getNewValue()).isEmpty()) { zadania.DbAccess.showAlertWarning(null, "Pole nie mo¿e byæ puste!"); refresh4(); return; }
		
		stmt.executeUpdate("UPDATE `pracownicy` SET `telefon`='"+event.getNewValue()+"' WHERE id_prac = '"+pracownik.getId_prac()+"'");

		refresh4();
    }

    @FXML
    void edit4pesel(CellEditEvent<Pracownicy, Integer> event) throws ClassNotFoundException, SQLException {
    	Statement stmt = zadania.DbAccess.DbAccess();
		Pracownicy pracownik = tableView3.getSelectionModel().getSelectedItem();
		if(event.getNewValue() == null) { zadania.DbAccess.showAlertWarning(null, "Pole nie mo¿e byæ puste!"); refresh4(); return; }
		
		stmt.executeUpdate("UPDATE `pracownicy` SET `pesel`='"+event.getNewValue()+"' WHERE id_prac = '"+pracownik.getId_prac()+"'");

		refresh4();
    }
    
    //Convertery

	public class CustomIntegerStringConverter extends IntegerStringConverter {
	    private final IntegerStringConverter converter = new IntegerStringConverter();
	    Wypozyczenia wypozyczenie = tableView.getSelectionModel().getSelectedItem();
	    
	    @Override
	    public String toString(Integer object) {
	        try {
	            return converter.toString(object);
	        } catch (NumberFormatException e) {
	            zadania.DbAccess.showAlertWarning(e, "Ka¿de pole musi byæ uzupe³nione poprawnie!");
	        }
	        return null;
	    }

	    @Override
	    public Integer fromString(String string) {
	        try {
	            return converter.fromString(string);
	        } catch (NumberFormatException e) {
	        	zadania.DbAccess.showAlertWarning(e, "Ka¿de pole musi byæ uzupe³nione poprawnie!");
	        	return -1;
	        }
	    }
	}
	
	//ODŒWIE¯ANIE TABEL
	
	@FXML
	public void refresh() throws ClassNotFoundException, SQLException {

		Statement stmt = zadania.DbAccess.DbAccess();

		ResultSet rs = stmt.executeQuery("SELECT wypozyczenia.id_wyp, samochody.model, pracownicy.nazwisko as nazwisko_prac, pracownicy.imie as imie_prac, "
				+ "klienci.nazwisko as nazwisko_kli, klienci.imie as imie_kli, wypozyczenia.data_wyp, wypozyczenia.data_zwr, wypozyczenia.koszt "
				+ "FROM wypozyczenia, samochody, pracownicy, klienci WHERE wypozyczenia.id_sam = samochody.id_sam "
				+ "AND wypozyczenia.id_prac = pracownicy.id_prac AND wypozyczenia.id_kli = klienci.id_kli ORDER BY wypozyczenia.id_wyp;");

		oblist.clear();
		tableView.getItems().clear();

		while (rs.next()) {
			oblist.add(new Wypozyczenia(rs.getInt("ID_WYP"), rs.getString("MODEL"), rs.getString("NAZWISKO_PRAC"), rs.getString("IMIE_PRAC"), rs.getString("NAZWISKO_KLI"), 
					rs.getString("IMIE_KLI"), rs.getDate("DATA_WYP"), rs.getDate("DATA_ZWR"), rs.getInt("KOSZT")));
		}

		ID_WYP.setCellValueFactory(new PropertyValueFactory<>("id_wyp"));
		ID_WYP.setCellFactory(TextFieldTableCell.<Wypozyczenia, Integer>forTableColumn(new CustomIntegerStringConverter()));

		SAMOCHOD.setCellValueFactory(new PropertyValueFactory<>("samochod"));
		SAMOCHOD.setCellFactory(TextFieldTableCell.<Wypozyczenia>forTableColumn());
		
		PRACOWNIK.setCellValueFactory(new PropertyValueFactory<>("pracownik"));
		PRACOWNIK.setCellFactory(TextFieldTableCell.<Wypozyczenia>forTableColumn());
		
		PRACOWNIKIMIE.setCellValueFactory(new PropertyValueFactory<>("pracownikImie"));
		PRACOWNIKIMIE.setCellFactory(TextFieldTableCell.<Wypozyczenia>forTableColumn());
		
		KLIENT.setCellValueFactory(new PropertyValueFactory<>("klient"));
		KLIENT.setCellFactory(TextFieldTableCell.<Wypozyczenia>forTableColumn());
		
		KLIENTIMIE.setCellValueFactory(new PropertyValueFactory<>("klientImie"));
		KLIENTIMIE.setCellFactory(TextFieldTableCell.<Wypozyczenia>forTableColumn());
		
		DATA_WYP.setCellValueFactory(new PropertyValueFactory<>("data_wyp"));
		DATA_WYP.setCellFactory(
		         new Callback<TableColumn<Wypozyczenia,Date>, TableCell<Wypozyczenia,Date>>() {
		         @Override public TableCell<Wypozyczenia,Date> call( TableColumn<Wypozyczenia,Date> c ) {
		             return new TextFieldTableCell<>(new DateStringConverter("yyyy-MM-dd")); }});

		DATA_ZWR.setCellValueFactory(new PropertyValueFactory<>("data_zwr"));
		DATA_ZWR.setCellFactory(
		         new Callback<TableColumn<Wypozyczenia,Date>, TableCell<Wypozyczenia,Date>>() {
		         @Override public TableCell<Wypozyczenia,Date> call( TableColumn<Wypozyczenia,Date> c ) {
		             return new TextFieldTableCell<>(new DateStringConverter("yyyy-MM-dd")); }});
		
		KOSZT.setCellValueFactory(new PropertyValueFactory<>("koszt"));
		KOSZT.setCellFactory(TextFieldTableCell.<Wypozyczenia, Integer>forTableColumn(new CustomIntegerStringConverter()));

		tableView.setItems(oblist);
		tableView.refresh();
	}
	
	@FXML
	public void refresh2() throws ClassNotFoundException, SQLException {

		Statement stmt = zadania.DbAccess.DbAccess();

		ResultSet rs = stmt.executeQuery("SELECT * FROM `klienci`");

		oblist1.clear();
		tableView1.getItems().clear();

		while (rs.next()) {
			oblist1.add(new Klienci(rs.getInt("ID_KLI"), rs.getString("NAZWISKO"), rs.getString("IMIE"), rs.getString("NR_DOWODU"), 
					rs.getString("MIEJSCOWOSC"), rs.getString("ULICA")));
		}

		ID_KLI1.setCellValueFactory(new PropertyValueFactory<>("id_kli"));
		ID_KLI1.setCellFactory(TextFieldTableCell.<Klienci, Integer>forTableColumn(new CustomIntegerStringConverter()));
		
		NAZWISKO1.setCellValueFactory(new PropertyValueFactory<>("nazwisko"));
		NAZWISKO1.setCellFactory(TextFieldTableCell.forTableColumn());
		
		IMIE.setCellValueFactory(new PropertyValueFactory<>("imie"));
		IMIE.setCellFactory(TextFieldTableCell.forTableColumn());
		
		NR_DOWODU.setCellValueFactory(new PropertyValueFactory<>("nr_dowodu"));
		NR_DOWODU.setCellFactory(TextFieldTableCell.forTableColumn());
		
		MIEJSCOWOSC.setCellValueFactory(new PropertyValueFactory<>("miejscowosc"));
		MIEJSCOWOSC.setCellFactory(TextFieldTableCell.forTableColumn());
		
		ULICA.setCellValueFactory(new PropertyValueFactory<>("ulica"));
		ULICA.setCellFactory(TextFieldTableCell.forTableColumn());

		tableView1.setItems(oblist1);
		tableView1.refresh();
	}
	
	@FXML
	public void refresh3() throws ClassNotFoundException, SQLException {

		Statement stmt = zadania.DbAccess.DbAccess();

		ResultSet rs = stmt.executeQuery("SELECT * FROM `samochody`");

		oblist2.clear();
		tableView2.getItems().clear();

		while (rs.next()) {
			oblist2.add(new Samochody(rs.getInt("ID_SAM"), rs.getString("NR_REJ"), rs.getString("MARKA"), rs.getString("MODEL"), 
					rs.getInt("ROK_PROD"), rs.getString("KRAJ_PROD"), rs.getInt("POJ_SIL"), rs.getInt("KOSZT_DNIA")));
		}

		ID_SAM2.setCellValueFactory(new PropertyValueFactory<>("id_sam"));
		ID_SAM2.setCellFactory(TextFieldTableCell.<Samochody, Integer>forTableColumn(new CustomIntegerStringConverter()));
		
		NR_REJ.setCellValueFactory(new PropertyValueFactory<>("nr_rej"));
		NR_REJ.setCellFactory(TextFieldTableCell.forTableColumn());
		
		MARKA.setCellValueFactory(new PropertyValueFactory<>("marka"));
		MARKA.setCellFactory(TextFieldTableCell.forTableColumn());
		
		MODEL.setCellValueFactory(new PropertyValueFactory<>("model"));
		MODEL.setCellFactory(TextFieldTableCell.forTableColumn());
		
		ROK_PROD.setCellValueFactory(new PropertyValueFactory<>("rok_prod"));
		ROK_PROD.setCellFactory(TextFieldTableCell.<Samochody, Integer>forTableColumn(new CustomIntegerStringConverter()));
		
		KRAJ_PROD.setCellValueFactory(new PropertyValueFactory<>("kraj_prod"));
		KRAJ_PROD.setCellFactory(TextFieldTableCell.forTableColumn());
		
		POJ_SIL.setCellValueFactory(new PropertyValueFactory<>("poj_sil"));
		POJ_SIL.setCellFactory(TextFieldTableCell.<Samochody, Integer>forTableColumn(new CustomIntegerStringConverter()));
		
		KOSZT_DNIA.setCellValueFactory(new PropertyValueFactory<>("koszt_dnia"));
		KOSZT_DNIA.setCellFactory(TextFieldTableCell.<Samochody, Integer>forTableColumn(new CustomIntegerStringConverter()));

		tableView2.setItems(oblist2);
		tableView2.refresh();
	}
	
	@FXML
	public void refresh4() throws ClassNotFoundException, SQLException {

		Statement stmt = zadania.DbAccess.DbAccess();

		ResultSet rs = stmt.executeQuery("SELECT * FROM `pracownicy`");

		oblist3.clear();
		tableView3.getItems().clear();

		while (rs.next()) {
			oblist3.add(new Pracownicy(rs.getInt("ID_PRAC"), rs.getString("IMIE"), rs.getString("NAZWISKO"), rs.getString("TELEFON"), 
					rs.getString("PESEL")));
		}

		ID_PRAC3.setCellValueFactory(new PropertyValueFactory<>("id_prac"));
		ID_PRAC3.setCellFactory(TextFieldTableCell.<Pracownicy, Integer>forTableColumn(new CustomIntegerStringConverter()));
		
		NAZWISKO3.setCellValueFactory(new PropertyValueFactory<>("nazwisko"));
		NAZWISKO3.setCellFactory(TextFieldTableCell.forTableColumn());
		
		IMIE3.setCellValueFactory(new PropertyValueFactory<>("imie"));
		IMIE3.setCellFactory(TextFieldTableCell.forTableColumn());
		
		TELEFON.setCellValueFactory(new PropertyValueFactory<>("telefon"));
		TELEFON.setCellFactory(TextFieldTableCell.forTableColumn());
		
		PESEL.setCellValueFactory(new PropertyValueFactory<>("pesel"));
		PESEL.setCellFactory(TextFieldTableCell.forTableColumn());

		tableView3.setItems(oblist3);
		tableView3.refresh();
	}

	@FXML
	void dodawanie(ActionEvent event) throws ClassNotFoundException, SQLException {
		try {
			// przejscie na dodawanie.fxml
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/ui/dodawanie.fxml"));
			Stage stage = new Stage();

			stage.setTitle("Dodawanie do bazy danych");
			stage.setScene(new Scene((Parent) loader.load()));
			
			//nie mozna kliknac maina dopoki sie nie zamorduje okna
			stage.initModality(Modality.WINDOW_MODAL);
			stage.setAlwaysOnTop(true);
			
			stage.showAndWait();

			refresh();
			refresh2();
			refresh3();
			refresh4();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void usuwanie(ActionEvent event) throws ClassNotFoundException, SQLException {

		Statement stmt = zadania.DbAccess.DbAccess();
		Wypozyczenia wypozyczenie = tableView.getSelectionModel().getSelectedItem();
		Klienci klient = tableView1.getSelectionModel().getSelectedItem();
		Samochody samochod = tableView2.getSelectionModel().getSelectedItem();
		Pracownicy pracownik = tableView3.getSelectionModel().getSelectedItem();
		
		if((WYPOZYCZENIA.isSelected() && tableView.getSelectionModel().isEmpty()) 
				|| (KLIENCI.isSelected() && tableView1.getSelectionModel().isEmpty()) 
				|| (SAMOCHODY.isSelected() && tableView2.getSelectionModel().isEmpty()) 
				|| (PRACOWNICY.isSelected() && tableView3.getSelectionModel().isEmpty())) {
			
			Alert alert = new Alert(AlertType.WARNING, "Musisz najpierw wybraæ rekord do usuniêcia", ButtonType.OK);
			alert.setTitle("Ostrze¿enie");
			alert.setHeaderText("Nie wiadomo co usun¹æ!");
			((Stage) alert.getDialogPane().getScene().getWindow()).setAlwaysOnTop(true);
			alert.showAndWait();
			return;
		}
			
		if (WYPOZYCZENIA.isSelected()) {
			int id = wypozyczenie.getId_wyp();
			stmt.executeUpdate("DELETE FROM `wypozyczenia` WHERE `id_wyp`= '" + id + "'");
			refresh();
		} else if (KLIENCI.isSelected()) {
			int id = klient.getId_kli();
			stmt.executeUpdate("DELETE FROM `klienci` WHERE `id_kli`= '" + id + "'");
			refresh2();
		} else if (SAMOCHODY.isSelected()) {
			int id = samochod.getId_sam();
			stmt.executeUpdate("DELETE FROM `samochody` WHERE `id_sam`= '" + id + "'");
			refresh3();
		} else if (PRACOWNICY.isSelected()) {
			int id = pracownik.getId_prac();
			stmt.executeUpdate("DELETE FROM `pracownicy` WHERE `id_prac`= '" + id + "'");
			refresh4();
		}
	}

	@FXML
	void szukaj(ActionEvent event) throws ClassNotFoundException, SQLException {
		if(textfieldSZ.getText().trim().equals("")) { zadania.DbAccess.showAlertWarning(null, "Podaj frazê do wyszukania!"); return; }
		if (comboboxSZ.getValue().equals("Wypo¿yczenia")) {
			if(comboboxSZKOL.getSelectionModel().getSelectedIndex() == 3)
				refreshSZ("pracownicy.nazwisko", textfieldSZ.getText());
			else if(comboboxSZKOL.getSelectionModel().getSelectedIndex() == 2)
				refreshSZ("klienci.nazwisko", textfieldSZ.getText());
			else
				refreshSZ(comboboxSZKOL.getValue(), textfieldSZ.getText());
		} else if (comboboxSZ.getValue().equals("Klienci")) {
			refreshSZ1(comboboxSZKOL.getValue(), textfieldSZ.getText());
		} else if (comboboxSZ.getValue().equals("Samochody")) {
			refreshSZ2(comboboxSZKOL.getValue(), textfieldSZ.getText());
		} else if (comboboxSZ.getValue().equals("Pracownicy")) {
			refreshSZ3(comboboxSZKOL.getValue(), textfieldSZ.getText());
		}
	}
	
	@FXML
	void szczegoly(ActionEvent event) throws ClassNotFoundException, SQLException{
		try {
			
			if(WYPOZYCZENIA.isSelected() && tableView.getSelectionModel().isEmpty()) {
				zadania.DbAccess.showAlertWarning(null, "Musisz wybraæ rekord do pokazania szczegó³ów!");
				return;
			}
			
			zadania.DbAccess.setId((tableView.getSelectionModel().getSelectedItem().getId_wyp()));

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/ui/szczegoly.fxml"));
			Stage stage = new Stage();

			stage.setTitle("Podgl¹d powi¹zanych tabel");
			stage.setScene(new Scene((Parent) loader.load()));

			stage.initModality(Modality.WINDOW_MODAL);
			stage.setAlwaysOnTop(true);
			
			stage.showAndWait();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void enter(KeyEvent key) throws ClassNotFoundException, SQLException {
		if (key.getCode() == KeyCode.ENTER) {
			szukaj(null);
		}
	}

	@FXML
	void change1(Event event) throws ClassNotFoundException, SQLException {
		try {
			if (WYPOZYCZENIA.isSelected()) {
				comboboxSZ.getSelectionModel().select(0);
				Szczegoly.setVisible(true);
				refresh();
			}
		} catch (Exception e) {

		}

	}

	@FXML
	void change2(Event event) throws ClassNotFoundException, SQLException {
		if (KLIENCI.isSelected()) {
			comboboxSZ.getSelectionModel().select(1);
			comboboxSZKOL.getSelectionModel().select(0);
			Szczegoly.setVisible(false);
			refresh2();
		}
	}

	@FXML
	void change3(Event event) throws ClassNotFoundException, SQLException {
		if (SAMOCHODY.isSelected()) {
			comboboxSZ.getSelectionModel().select(2);
			comboboxSZKOL.getSelectionModel().select(0);
			Szczegoly.setVisible(false);
			refresh3();
		}
	}

	@FXML
	void change4(Event event) throws ClassNotFoundException, SQLException {
		if (PRACOWNICY.isSelected()) {
			comboboxSZ.getSelectionModel().select(3);
			comboboxSZKOL.getSelectionModel().select(0);
			Szczegoly.setVisible(false);
			refresh4();
		}
	}

	@FXML
	void edit(ActionEvent event) {
		if (editButton.isSelected()) {
			tableView.setEditable(true);
			tableView1.setEditable(true);
			tableView2.setEditable(true);
			tableView3.setEditable(true);

		} else {
			tableView.setEditable(false);
			tableView1.setEditable(false);
			tableView2.setEditable(false);
			tableView3.setEditable(false);
		}
	}

	@FXML
	void constraint(ActionEvent event) throws ClassNotFoundException, SQLException {
		if (constraintButton.isSelected()) {
			zadania.DbAccess.ConstraintOn();
		} else {
			ButtonType tak = new ButtonType("TAK", ButtonData.OK_DONE);
			ButtonType nie = new ButtonType("NIE", ButtonData.CANCEL_CLOSE);
			Alert alert = new Alert(AlertType.WARNING, "Na pewno chcesz kontynuowaæ?", tak, nie);
			alert.setTitle("Ostrze¿enie");
			alert.setHeaderText("Chcesz wy³¹czyæ na tê sesjê sprawdzanie kluczów obcych!");
			((Stage) alert.getDialogPane().getScene().getWindow()).setAlwaysOnTop(true);
			Optional<ButtonType> result = alert.showAndWait();

			if (result.get() == tak) {
				zadania.DbAccess.ConstraintOff();
				constraintButton.setSelected(false);
			} else {
				constraintButton.setSelected(true);
			}
		}
	}

	@FXML
	void tabeleSZ(ActionEvent event) {
		if (comboboxSZ.getValue().equals("Wypo¿yczenia")) {
			TabPane.getSelectionModel().select(0);
			comboboxSZKOL.getItems().clear();
			comboboxSZKOL.getItems().addAll(optionsSZ1);
			comboboxSZKOL.getSelectionModel().select(0);
		} else if (comboboxSZ.getValue().equals("Klienci")) {
			TabPane.getSelectionModel().select(1);
			comboboxSZKOL.getItems().clear();
			comboboxSZKOL.getItems().addAll(optionsSZ2);
			comboboxSZKOL.getSelectionModel().select(0);
		} else if (comboboxSZ.getValue().equals("Samochody")) {
			TabPane.getSelectionModel().select(2);
			comboboxSZKOL.getItems().clear();
			comboboxSZKOL.getItems().addAll(optionsSZ3);
			comboboxSZKOL.getSelectionModel().select(0);
		} else if (comboboxSZ.getValue().equals("Pracownicy")) {
			TabPane.getSelectionModel().select(3);
			comboboxSZKOL.getItems().clear();
			comboboxSZKOL.getItems().addAll(optionsSZ4);
			comboboxSZKOL.getSelectionModel().select(0);
		}
	}

	@FXML
	void odswiezanie(ActionEvent event) throws ClassNotFoundException, SQLException {
		refresh();
		refresh2();
		refresh3();
		refresh4();
		textfieldSZ.setText("");
	}

    
	public void refreshSZ(String text, String text1) throws ClassNotFoundException, SQLException {

		Statement stmt = zadania.DbAccess.DbAccess();

		ResultSet rs = stmt.executeQuery("SELECT wypozyczenia.id_wyp, samochody.model, pracownicy.nazwisko as nazwisko_prac, pracownicy.imie as imie_prac, "
				+ "klienci.nazwisko as nazwisko_kli, klienci.imie as imie_kli, wypozyczenia.data_wyp, wypozyczenia.data_zwr, wypozyczenia.koszt "
				+ "FROM wypozyczenia, samochody, pracownicy, klienci WHERE wypozyczenia.id_sam = samochody.id_sam "
				+ "AND wypozyczenia.id_prac = pracownicy.id_prac AND wypozyczenia.id_kli = klienci.id_kli AND "+text+" LIKE '"+text1+"' "
				+ "ORDER BY wypozyczenia.id_wyp;");
		
		oblist.clear();
		tableView.getItems().clear();

		while (rs.next()) {
			oblist.add(new Wypozyczenia(rs.getInt("ID_WYP"), rs.getString("MODEL"), rs.getString("NAZWISKO_PRAC"), rs.getString("IMIE_PRAC"), rs.getString("NAZWISKO_KLI"), 
					rs.getString("IMIE_KLI"), rs.getDate("DATA_WYP"), rs.getDate("DATA_ZWR"), rs.getInt("KOSZT")));
		}

		ID_WYP.setCellValueFactory(new PropertyValueFactory<>("id_wyp"));
		ID_WYP.setCellFactory(TextFieldTableCell.<Wypozyczenia, Integer>forTableColumn(new CustomIntegerStringConverter()));

		SAMOCHOD.setCellValueFactory(new PropertyValueFactory<>("samochod"));
		SAMOCHOD.setCellFactory(TextFieldTableCell.<Wypozyczenia>forTableColumn());
		
		PRACOWNIK.setCellValueFactory(new PropertyValueFactory<>("pracownik"));
		PRACOWNIK.setCellFactory(TextFieldTableCell.<Wypozyczenia>forTableColumn());
		
		PRACOWNIKIMIE.setCellValueFactory(new PropertyValueFactory<>("pracownikImie"));
		PRACOWNIKIMIE.setCellFactory(TextFieldTableCell.<Wypozyczenia>forTableColumn());
		
		KLIENT.setCellValueFactory(new PropertyValueFactory<>("klient"));
		KLIENT.setCellFactory(TextFieldTableCell.<Wypozyczenia>forTableColumn());
		
		KLIENTIMIE.setCellValueFactory(new PropertyValueFactory<>("klientImie"));
		KLIENTIMIE.setCellFactory(TextFieldTableCell.<Wypozyczenia>forTableColumn());
		
		DATA_WYP.setCellValueFactory(new PropertyValueFactory<>("data_wyp"));
		DATA_WYP.setCellFactory(
		         new Callback<TableColumn<Wypozyczenia,Date>, TableCell<Wypozyczenia,Date>>() {
		         @Override public TableCell<Wypozyczenia,Date> call( TableColumn<Wypozyczenia,Date> c ) {
		             return new TextFieldTableCell<>(new DateStringConverter("yyyy-MM-dd")); }});

		DATA_ZWR.setCellValueFactory(new PropertyValueFactory<>("data_zwr"));
		DATA_ZWR.setCellFactory(
		         new Callback<TableColumn<Wypozyczenia,Date>, TableCell<Wypozyczenia,Date>>() {
		         @Override public TableCell<Wypozyczenia,Date> call( TableColumn<Wypozyczenia,Date> c ) {
		             return new TextFieldTableCell<>(new DateStringConverter("yyyy-MM-dd")); }});
		
		KOSZT.setCellValueFactory(new PropertyValueFactory<>("koszt"));
		KOSZT.setCellFactory(TextFieldTableCell.<Wypozyczenia, Integer>forTableColumn(new CustomIntegerStringConverter()));
		
//    	System.out.println(oblist);

		tableView.setItems(oblist);
		tableView.refresh();

//    	System.out.println(tableView);
	}
    
    
	public void refreshSZ1(String text, String text1) throws ClassNotFoundException, SQLException {

		Statement stmt = zadania.DbAccess.DbAccess();

		ResultSet rs = stmt.executeQuery("SELECT * FROM `klienci` WHERE `"+text+"` LIKE '"+text1+"'");

		oblist1.clear();
		tableView1.getItems().clear();

		while (rs.next()) {
			oblist1.add(new Klienci(rs.getInt("ID_KLI"), rs.getString("NAZWISKO"), rs.getString("IMIE"), rs.getString("NR_DOWODU"), 
					rs.getString("MIEJSCOWOSC"), rs.getString("ULICA")));
		}

		ID_KLI1.setCellValueFactory(new PropertyValueFactory<>("id_kli"));
		ID_KLI1.setCellFactory(TextFieldTableCell.<Klienci, Integer>forTableColumn(new CustomIntegerStringConverter()));
		
		NAZWISKO1.setCellValueFactory(new PropertyValueFactory<>("nazwisko"));
		NAZWISKO1.setCellFactory(TextFieldTableCell.forTableColumn());
		
		IMIE.setCellValueFactory(new PropertyValueFactory<>("imie"));
		IMIE.setCellFactory(TextFieldTableCell.forTableColumn());
		
		NR_DOWODU.setCellValueFactory(new PropertyValueFactory<>("nr_dowodu"));
		NR_DOWODU.setCellFactory(TextFieldTableCell.forTableColumn());
		
		MIEJSCOWOSC.setCellValueFactory(new PropertyValueFactory<>("miejscowosc"));
		MIEJSCOWOSC.setCellFactory(TextFieldTableCell.forTableColumn());
		
		ULICA.setCellValueFactory(new PropertyValueFactory<>("ulica"));
		ULICA.setCellFactory(TextFieldTableCell.forTableColumn());

		tableView1.setItems(oblist1);
		tableView1.refresh();
	}
	
	
	public void refreshSZ2(String text, String text1) throws ClassNotFoundException, SQLException {

		Statement stmt = zadania.DbAccess.DbAccess();

		ResultSet rs = stmt.executeQuery("SELECT * FROM `samochody` WHERE `"+text+"` LIKE '"+text1+"'");

		oblist2.clear();
		tableView2.getItems().clear();

		while (rs.next()) {
			oblist2.add(new Samochody(rs.getInt("ID_SAM"), rs.getString("NR_REJ"), rs.getString("MARKA"), rs.getString("MODEL"), 
					rs.getInt("ROK_PROD"), rs.getString("KRAJ_PROD"), rs.getInt("POJ_SIL"), rs.getInt("KOSZT_DNIA")));
		}

		ID_SAM2.setCellValueFactory(new PropertyValueFactory<>("id_sam"));
		ID_SAM2.setCellFactory(TextFieldTableCell.<Samochody, Integer>forTableColumn(new CustomIntegerStringConverter()));
		
		NR_REJ.setCellValueFactory(new PropertyValueFactory<>("nr_rej"));
		NR_REJ.setCellFactory(TextFieldTableCell.forTableColumn());
		
		MARKA.setCellValueFactory(new PropertyValueFactory<>("marka"));
		MARKA.setCellFactory(TextFieldTableCell.forTableColumn());
		
		MODEL.setCellValueFactory(new PropertyValueFactory<>("model"));
		MODEL.setCellFactory(TextFieldTableCell.forTableColumn());
		
		ROK_PROD.setCellValueFactory(new PropertyValueFactory<>("rok_prod"));
		ROK_PROD.setCellFactory(TextFieldTableCell.<Samochody, Integer>forTableColumn(new CustomIntegerStringConverter()));
		
		KRAJ_PROD.setCellValueFactory(new PropertyValueFactory<>("kraj_prod"));
		KRAJ_PROD.setCellFactory(TextFieldTableCell.forTableColumn());
		
		POJ_SIL.setCellValueFactory(new PropertyValueFactory<>("poj_sil"));
		POJ_SIL.setCellFactory(TextFieldTableCell.<Samochody, Integer>forTableColumn(new CustomIntegerStringConverter()));
		
		KOSZT_DNIA.setCellValueFactory(new PropertyValueFactory<>("koszt_dnia"));
		KOSZT_DNIA.setCellFactory(TextFieldTableCell.<Samochody, Integer>forTableColumn(new CustomIntegerStringConverter()));

		tableView2.setItems(oblist2);
		tableView2.refresh();
	}
	
	
	public void refreshSZ3(String text, String text1) throws ClassNotFoundException, SQLException {

		Statement stmt = zadania.DbAccess.DbAccess();

		ResultSet rs = stmt.executeQuery("SELECT * FROM `pracownicy` WHERE `"+text+"` LIKE '"+text1+"'");

		oblist3.clear();
		tableView3.getItems().clear();

		while (rs.next()) {
			oblist3.add(new Pracownicy(rs.getInt("ID_PRAC"), rs.getString("IMIE"), rs.getString("NAZWISKO"), rs.getString("TELEFON"), 
					rs.getString("PESEL")));
		}

		ID_PRAC3.setCellValueFactory(new PropertyValueFactory<>("id_prac"));
		ID_PRAC3.setCellFactory(TextFieldTableCell.<Pracownicy, Integer>forTableColumn(new CustomIntegerStringConverter()));
		
		NAZWISKO3.setCellValueFactory(new PropertyValueFactory<>("nazwisko"));
		NAZWISKO3.setCellFactory(TextFieldTableCell.forTableColumn());
		
		IMIE3.setCellValueFactory(new PropertyValueFactory<>("imie"));
		IMIE3.setCellFactory(TextFieldTableCell.forTableColumn());
		
		TELEFON.setCellValueFactory(new PropertyValueFactory<>("telefon"));
		TELEFON.setCellFactory(TextFieldTableCell.forTableColumn());
		
		PESEL.setCellValueFactory(new PropertyValueFactory<>("pesel"));
		PESEL.setCellFactory(TextFieldTableCell.forTableColumn());

		tableView3.setItems(oblist3);
		tableView3.refresh();
	}
}
