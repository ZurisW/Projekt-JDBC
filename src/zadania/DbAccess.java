package zadania;

import java.sql.*;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class DbAccess {
	
	public static Statement DbAccess() throws ClassNotFoundException, SQLException{
		Statement stmt = null;
		try {
			String url = "jdbc:mysql://localhost/baza1";
			String user = "root";
			String password= "";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);
			stmt = con.createStatement();
			
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR, "Prawdopodobnie w³¹cz xamppa", ButtonType.OK);
			alert.setTitle("Œmieræ");
			alert.setHeaderText("Nie uda³o po³¹czyæ siê z baz¹ danych!");
			alert.showAndWait();
			System.exit(0);
		}
		return stmt;
	}
	
	
	public static void Dodaj(Integer id_wyp, int id_sam, int id_prac, int id_kli, Date data_wyp, Date data_zwr, int koszt) throws ClassNotFoundException, SQLException {
		Statement stmt = DbAccess();
		
		stmt.executeUpdate("INSERT INTO `wypozyczenia`(`id_wyp`, `id_sam`, `id_prac`, `id_kli`, `data_wyp`, `data_zwr`, `koszt`) "
				+ "VALUES ("+id_wyp+",'"+id_sam+"','"+id_prac+"','"+id_kli+"','"+data_wyp+"','"+data_zwr+"','"+koszt+"')");

	}
	
	public static void Dodaj2(Integer id_kli, String nazwisko, String imie, String nr_dowodu, String miejscowosc, String ulica) throws ClassNotFoundException, SQLException {
		Statement stmt = DbAccess();
		
		stmt.executeUpdate("INSERT INTO `klienci`(`id_kli`, `nazwisko`, `imie`, `nr_dowodu`, `miejscowosc`, `ulica`) "
				+ "VALUES ("+id_kli+",'"+nazwisko+"','"+imie+"','"+nr_dowodu+"','"+miejscowosc+"','"+ulica+"')");

	}
	
	public static void Dodaj3(Integer id_sam, String nr_rej, String marka, String model, int rok_prod, String kraj_prod, int poj_sil, int koszt_dnia) throws ClassNotFoundException, SQLException {
		Statement stmt = DbAccess();
		
		stmt.executeUpdate("INSERT INTO `samochody`(`id_sam`, `nr_rej`, `marka`, `model`, `rok_prod`, `kraj_prod`, `poj_sil`, `koszt_dnia`) "
				+ "VALUES ("+id_sam+",'"+nr_rej+"','"+marka+"','"+model+"','"+rok_prod+"','"+kraj_prod+"','"+poj_sil+"','"+koszt_dnia+"')");

	}
	
	public static void Dodaj4(Integer id_prac, String nazwisko, String imie, String telefon, String pesel) throws ClassNotFoundException, SQLException {
		Statement stmt = DbAccess();
		
		stmt.executeUpdate("INSERT INTO `pracownicy`(`id_prac`, `nazwisko`, `imie`, `telefon`, `pesel`) "
				+ "VALUES ("+id_prac+",'"+nazwisko+"','"+imie+"','"+telefon+"','"+pesel+"')");

	}
	
	public static void ConstraintOff() throws ClassNotFoundException, SQLException {
		Statement stmt = DbAccess();
		
		stmt.executeQuery("SET GLOBAL FOREIGN_KEY_CHECKS=0;");
	}
	
	public static void ConstraintOn() throws ClassNotFoundException, SQLException {
		Statement stmt = DbAccess();
		
		stmt.executeQuery("SET GLOBAL FOREIGN_KEY_CHECKS=1;");
	}
	
	public static void showAlertWarning(Exception e, String info){
		Alert alert = new Alert(AlertType.WARNING, info, ButtonType.OK);
		alert.setTitle("Ostrze¿enie");
		alert.setHeaderText("Uwaga!");
		((Stage) alert.getDialogPane().getScene().getWindow()).setAlwaysOnTop(true);
		alert.showAndWait();
	}
	

    private static int id;
    
    public static int getId() {
		return id;
	}

	public static void setId(int id) {
		DbAccess.id = id;
	}

}

