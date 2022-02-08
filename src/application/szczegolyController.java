package application;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import application.MainController.CustomIntegerStringConverter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.util.Callback;
import javafx.util.converter.DateStringConverter;


public class szczegolyController {
	
	@FXML
    private Label koszt_dnia;

    @FXML
    private Label poj_sil;

    @FXML
    private Label imie3;

    @FXML
    private Label id_prac;

    @FXML
    private Label miejscowosc;

    @FXML
    private Label kraj_prod;

    @FXML
    private Label imie4;

    @FXML
    private Label id_kli4;

    @FXML
    private Label telefon3;

    @FXML
    private Label data_wyp;

    @FXML
    private Label koszt;

    @FXML
    private Label id_sam2;

    @FXML
    private Label marka;

    @FXML
    private Label nr_dowodu;

    @FXML
    private Label model;

    @FXML
    private Label id_kli;

    @FXML
    private AnchorPane anchorpane;

    @FXML
    private Label id_sam;

    @FXML
    private Label data_zwr;

    @FXML
    private Label id_prac3;

    @FXML
    private Label pesel3;

    @FXML
    private Label id_wyp;

    @FXML
    private Label ulica;

    @FXML
    private Label nr_rej;

    @FXML
    private Label nazwisko3;

    @FXML
    private Label nazwisko4;

    @FXML
    private Label rok_prod;

	
	@FXML
	private void initialize() throws ClassNotFoundException, SQLException {
		lines();
		
		refresh();
		
	}
	
	public void refresh() throws ClassNotFoundException, SQLException {

		Statement stmt = zadania.DbAccess.DbAccess();
		
		ResultSet rs = stmt.executeQuery("SELECT wypozyczenia.id_wyp, samochody.model, pracownicy.nazwisko, klienci.nazwisko, wypozyczenia.data_wyp, wypozyczenia.data_zwr,"
				+ " wypozyczenia.koszt, samochody.*, pracownicy.*, klienci.* FROM wypozyczenia, samochody, pracownicy, klienci WHERE wypozyczenia.id_sam = samochody.id_sam "
				+ "AND wypozyczenia.id_prac = pracownicy.id_prac AND wypozyczenia.id_kli = klienci.id_kli AND `id_wyp` LIKE '"+zadania.DbAccess.getId()+"';");
		
		while(rs.next()) {
			id_wyp.setText(String.valueOf(rs.getInt(1)));
			id_sam.setText(String.valueOf(rs.getString(2)));
			id_prac.setText(String.valueOf(rs.getString(3)));
			id_kli.setText(String.valueOf(rs.getString(4)));
			data_wyp.setText(String.valueOf(rs.getDate(5)));
			data_zwr.setText(String.valueOf(rs.getDate(6)));
			koszt.setText(String.valueOf(rs.getInt(7)));
			
			id_sam2.setText(String.valueOf(rs.getInt(8)));
			nr_rej.setText(rs.getString(9));
			marka.setText(rs.getString(10));
			model.setText(rs.getString(11));
			rok_prod.setText(String.valueOf(rs.getInt(12)));
			kraj_prod.setText(rs.getString(13));
			poj_sil.setText(String.valueOf(rs.getInt(14)));
			koszt_dnia.setText(String.valueOf(rs.getInt(15)));
			
			id_prac3.setText(String.valueOf(rs.getInt(16)));
			nazwisko3.setText(rs.getString(17));
			imie3.setText(rs.getString(18));
			telefon3.setText(rs.getString(19));
			pesel3.setText(rs.getString(20));
			
			id_kli4.setText(String.valueOf(rs.getInt(21)));
			nazwisko4.setText(rs.getString(22));
			imie4.setText(rs.getString(23));
			nr_dowodu.setText(rs.getString(24));
			miejscowosc.setText(rs.getString(25));
			ulica.setText(rs.getString(26));
		}
		
		
	}
	
	public void lines() {
	      Line vline = new Line(); 
	      Line hline = new Line();
	         
	      vline.setStartX(237.0); 
	      vline.setStartY(0.0); 
	      vline.setEndX(237.0); 
	      vline.setEndY(620.0); 
	      
	      hline.setStartX(0.0);
	      hline.setStartY(330.0);
	      hline.setEndX(490.0); 
	      hline.setEndY(330.0); 
	      
	      anchorpane.getChildren().add(vline);
	      anchorpane.getChildren().add(hline);
	}
    
}
