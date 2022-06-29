import java.sql.ResultSet;
import java.sql.SQLException;

public class test {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		Login login = new Login("jairo@gmail.com", "1234");
		ResultSet r = login.Ingresar();
		if (r.next()) {

			if (r.getInt("idRol") == 1) {
				System.out.println("soy administrador");
				Usuario u = new Usuario(r.getInt("idUsuario"), r.getString("Nombre"), r.getString("Apellido"),
						r.getString("dni"), r.getString("correo"),r.getString("pass"), r.getInt("EsFrecuente"),
						r.getInt("idRol"), r.getInt("idDomicilio"));
				
				PanelAdmin p=new PanelAdmin(u);
				

			} else {
				System.out.print("soy usuario comun");
				Usuario u = new Usuario(r.getInt("idUsuario"), r.getString("Nombre"), r.getString("Apellido"),
						r.getString("dni"), r.getNString("correo"), r.getString("pass"), r.getInt("EsFrecuente"),
						r.getInt("idRol"), r.getInt("idDomicilio"));

			}
		} else {
			System.out.println("Usuario o contraseña incorrecto");
		}

	}

}
