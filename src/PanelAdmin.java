import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PanelAdmin {

	Scanner t=new Scanner(System.in);
	Conexion conn=new Conexion();
	private String[][] matrizResultado;
	public PanelAdmin(Usuario u) throws SQLException{
		
		System.out.println("Menu Administrador");
		System.out.println("1 Ver listado productos");
		System.out.println("2 Cargar productos a la aplicación");
		System.out.println("3 Modificar los datos de los productos cargados");
		System.out.println("4 Ver todos los usuarios que realizaron una compra");
		System.out.println("5 Ver listado de productos seleccionados por el usuario");
		
		int op=t.nextInt();
		
		if(op==1) {			
			String sql="select * from Productos;";
			ResultSet r=conn.devolverConsulta(sql);
			
			System.out.println("idProducto| \t Nombre|\t CodigoBarras|\t Stock|\t categoria|\t Precio");
			
			while(r.next()) {
				
				System.out.println(r.getInt("idProducto")+"\t"+r.getString("Nombre")+"\t"+
				r.getString("CodigoBarras")+"\t"+r.getString("Stock")+
				"\t"+r.getString("idcategoria")+"\t"+r.getString("Precio"));
			}
		}
		

	}
}
