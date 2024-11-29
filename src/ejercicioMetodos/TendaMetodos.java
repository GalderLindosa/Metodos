package ejercicioMetodos;
import java.util.Scanner;
public class TendaMetodos {
	Scanner teclado = new Scanner(System.in);


	public static void mostrarProductos (String libros[], double precio[]) {

		for (int i = 0; i<libros.length;i++) {
			if (libros[i]!=null) {
			System.out.println(libros[i]+" cuesta "+precio[i]+"€");
			}
		}
	}






	public static void nuevoArt(String libros[], double precio[], double precios,	String libro ) {
		Scanner teclado = new Scanner(System.in);
		boolean enc=false;
		System.out.println("Introduce el nombre del articulo:");
		libro=teclado.nextLine();

		System.out.println("Introduce su precio");
		precios=teclado.nextDouble();

		for (int i = 0;i<libros.length && enc==false;i++) {

			if (i>libros.length) {
				System.out.println("No tienes espacio");
				enc=true;
			}
			if (libros[i]==null && enc==false) {
				libros[i]=libro;
				precio[i]=precios;
				enc=true;
			}
			if (libro.equalsIgnoreCase(libros[i]) && enc==false) {
				System.out.println("Ese articulo ya existe");
				enc=true;
			}
		}
	} 



	public static void obtenerPrecios(String libros[], double precio[], String producto) {
		boolean enc=false;
		Scanner teclado = new Scanner(System.in);
		System.out.println("¿Cual es e nombre del producto?");
		producto=teclado.nextLine();
		for (int i = 0;i<libros.length && enc==false;i++) {
			if (producto.equalsIgnoreCase(libros[i])) {
				System.out.println("El precio es: " +precio[i]);
				enc=true;
			}
			else if (producto.equalsIgnoreCase(null)){
				System.out.println("El articulo no existe");
				enc=true;
			}					
		}
	}
	public static void IVAprod(String libros[], double precio[], String producto) {
		boolean enc=false;
		double iva;
		Scanner teclado = new Scanner(System.in);
		System.out.println("¿Cual es e nombre del producto?");
		producto=teclado.nextLine();
		for (int i = 0;i<precio.length && enc==false;i++) {
			if (producto.equalsIgnoreCase(libros[i])) {
				iva=precio[i]*21/100;
				System.out.println("EL IVA de "+libros[i]+" es:"+iva);
				enc=true;
			}
			if (precio[i]==0){
				System.out.println("El articulo no existe");
				enc=true;
			}
			if(precio[0]==0) {
				System.out.println("No hay articulos en la tienda");
			}

		}
	}

	

	public static void Cambprod(String libros[], double precio[], String producto, double nuevoprecio) {
		boolean enc=false;
		Scanner teclado = new Scanner(System.in);
		System.out.println("¿Cual es e nombre del producto?");
		producto=teclado.nextLine();
		System.out.println("Introduce el nuevo precio:");
		nuevoprecio=teclado.nextDouble();
		for (int i = 0;i<precio.length && enc==false;i++) {
			if (producto.equalsIgnoreCase(libros[i])) {
				precio[i]=nuevoprecio;
				System.out.println("El precio ha sido modificado.");
				enc=true;
			}
			if (precio[i]==0){
				System.out.println("El articulo no existe");
				enc=true;
			}
		}
	}


	public static void eliminar(String libros[], double precio[], String producto) {
		boolean enc=false;
		Scanner teclado = new Scanner(System.in);
		System.out.println("¿Cual es e nombre del producto?");
		producto=teclado.nextLine();
		for (int i = 0;i<libros.length && enc==false;i++) {
			if (producto.equalsIgnoreCase(libros[i])) {
				libros[i]=null;
				precio[i]=0;
				
				enc=true;
			}
			 if (producto.equalsIgnoreCase(null)){
				System.out.println("El articulo no existe");
				enc=true;
			}					
		}


	}
	public static void OrdenarMen(String libros[], double precio[], String producto ) {
		double aux;
		String aux2;
		for(int i = 0;i<precio.length;i++)
		{
			for(int j =0; j<precio.length - i -1; j++)
			{
				if(precio[j]>precio[j+1])
				{
					aux= precio[j];
					precio[j] = precio[j+1];
					precio[j+1] = aux;
					aux2= libros[j];
					libros[j] = libros[j+1];
					libros[j+1] = aux2;
				}
			}
		}
		for(int i = 0;i<precio.length;i++)
		{
			if (!libros.equals(null)) {
			System.out.println(libros[i]+" "+precio[i]);
			}
			}
	}

	
	public static void main(String[] args) {

		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		String libros[] = new String[]{"Dandadan","Berserk","El señor de los anillos","Dragon ball","Nacidos de la bruma","El principe de la niebla","El detective esqueleto",null,null,null};
		double precio[] = new double[] {22,25,26,21,17,24,30,0,0,0};
		int menu;
		do {
			System.out.println("*****************************************************");
			System.out.println("1.- Añadir artículos y precios");
			System.out.println("2.- Mostrar productos de la tienda");
			System.out.println("3.- Obtener el precio de un producto");
			System.out.println("4.- Obtener el IVA de un producto");
			System.out.println("5.- Modificar el precio de un producto");
			System.out.println("6.- Eliminar un producto");
			System.out.println("7. Salir");
			System.out.println("8.- Ordenar Menor a Mayor");
			System.out.println("9.- Ordenar Mayor Menor");
			System.out.println("10.- Ordenar productos");
			System.out.println("¿Que quieres hacer?");

			menu = teclado.nextInt();
			switch (menu) {
			case 1:
				nuevoArt(libros,precio, menu, null);
				break;
			case 2:
				mostrarProductos(libros,precio);
				break;
			case 3:
				obtenerPrecios(libros,precio, null);
				break;
			case 4:
				IVAprod(libros, precio, null);
				break;
			case 5:
				Cambprod(libros, precio, null, menu);
				break;
			case 6:
				eliminar(libros, precio, null);
				break;
			case 7:
				break;
			 case 8:
				 OrdenarMen(libros, precio, null);
             	break;
             case 9:
             	break;
             case 10:
             	break;
			default:
			}

		}while(menu!=7);













		teclado.close();
	}

}

