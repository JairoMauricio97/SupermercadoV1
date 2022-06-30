import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PanelAdmin {

	Scanner t=new Scanner(System.in);
	Conexion conn=new Conexion();
	private String[][] matrizResultado;
	int fila;
	int columna;
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
			
			r.last();//se posiciona en la ultima
			
			fila=r.getRow()+1;
			columna=6;
			this.matrizResultado=new String[fila][columna];
			
			this.matrizResultado[0][0]="idProducto";
			this.matrizResultado[0][1]="Nombre";
			this.matrizResultado[0][2]="Codigo";
			this.matrizResultado[0][3]="Stock";
			this.matrizResultado[0][4]="categoria";
			this.matrizResultado[0][5]="Precio";
			
			r.beforeFirst();
			int fila=1;
			//System.out.println("idProducto| \t Nombre|\t CodigoBarras|\t Stock|\t categoria|\t Precio");
			
			while(r.next()) {
				
			/*	System.out.println(r.getInt("idProducto")+"\t"+r.getString("Nombre")+"\t"+
				r.getString("CodigoBarras")+"\t"+r.getString("Stock")+
				"\t"+r.getString("idcategoria")+"\t"+r.getString("Precio"));
				*/
				this.matrizResultado[fila][0]=""+r.getInt("idProducto");
				this.matrizResultado[fila][1]=r.getString("Nombre");
				this.matrizResultado[fila][2]=r.getString("CodigoBarras");
				this.matrizResultado[fila][3]=r.getString("Stock");
				this.matrizResultado[fila][4]=r.getString("idcategoria");
				this.matrizResultado[fila][5]=r.getString("Precio");
				fila++;
				
			}
			this.Mostrar_matriz(matrizResultado, this.fila, columna);
		}
		

	}
	
	public void Mostrar_matriz(String[][] m, int f, int c) {
		
		for(int i=0;i<f;i++) {
			System.out.print("\n");
			for(int j=0;j<c;j++) {
				System.out.print("\t"+m[i][j]+"\t");
			}
		}
		
		
	}
	
}
