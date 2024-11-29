package ejercicioMetodos;

import java.util.Scanner;
public class TiendaSinHuecos {
        
   /*
    * 1.- Añadir artículos y precios
2.- Mostrar productos de la tienda
3.- Obtener el precio de un producto
4.- Obtener el IVA de un producto
5.- Modificar el precio de un producto
6.- Eliminar un producto
7.- Salir
¿Qué quieres hacer?
    */
        static int numProductos=0;
        
        public static void main(String[] args) {
                // TODO Auto-generated method stub
                Scanner teclado=new Scanner(System.in);
                boolean continuar=true;
                String[] productos= new String[50];
                float[] precios=new float[10];
                precios[0]=0f;
                precios[1]=7;
                precios[2]=4;
                precios[3]=3;
               	precios[4]=8;
          		precios[5]=1;
                precios[6]=34;
  				precios[7]=89;
                precios[8]=33;
                precios[9]=11;
                														
                while (continuar)
                {
                        System.out.println("1.- Añadir artículos y precios\n2.- Mostrar productos de la tienda\n3.- Obtener el precio de un producto\n4.- Obtener el IVA de un producto\n5.- Modificar el precio de un producto\n6.- Eliminar un producto\n7.- Salir\n¿Qué quieres hacer?");
                        int opcion=teclado.nextInt();
                        teclado.nextLine();
                        switch (opcion)
                        {
                                case 1:
                                        aniadirArticulos(teclado,productos,precios);
                                        break;
                                case 2:
                                        mostrar(productos,precios);
                                        break;
                                case 3:
                                        obtenerPrecioProducto(teclado,productos,precios);
                                        break;
                                case 4:
                                        obtenerIVAProducto(teclado,productos,precios);
                                        break;
                                case 5:
                                        modificarPrecio(teclado,productos,precios);
                                        break;
                                case 6:
                                        eliminarProducto(teclado,productos,precios);
                                        break;
                                case 7:
                                        continuar=false;
                                        break;
                                case 8:
                                		MayorMenor(teclado, productos, precios, opcion);
                                	break;
                                case 9:
                            		MayorMenor(teclado, productos, precios, opcion);
                                	break;
                                case 10:
                                	break;
                                
                        }
                }// fin del while
                teclado.close();
        }
        
        public static void mostrar(String[] productos,float[] precios)
        {
                // si está vacío decirselo al usuario
                // en caso contrario mostrarlo
                if (numProductos==0)
                        System.out.println("No hay productos");
                else
                        for (int contador=0;contador<numProductos;contador++)
                                System.out.println(productos[contador]+" cuesta "+precios[contador]);
                        
        }
        public static int comprobarProducto(Scanner teclado,String[] productos, float[] precios)
        {
                // si está vacío decirselo al usuario
                // en caso contrario
                // pedir producto
                // buscarlo
                // si no está advertirlo
                int posicion=-1;
                boolean encontrado=false;
                if (numProductos==0)
                        System.out.println("No hay productos");
                else
                {
                        System.out.println("Introducir articulo");
                        String producto=teclado.nextLine();
                        for (int contador=0;contador<numProductos&&!encontrado;contador++)
                        {
                                if (productos[contador].equalsIgnoreCase(producto))
                                {
                                        encontrado=true;
                                        posicion=contador;
                                }
                        }
                        
                }
                if (!encontrado)
                        System.out.println("No existe ese producto");
                return posicion;
        }
        public static void obtenerPrecioProducto(Scanner teclado,String[] productos, float[] precios)
        {
        
                // si está vacío decirselo al usuario
                // en caso contrario
                // pedir producto
                // buscarlo
                // si no está advertirlo
                // en caso contrario mostrar precio"cuesta "+precios[contador]+"euros"
                int posicion=comprobarProducto(teclado, productos,precios);
                if (posicion>=0)
                        System.out.println("cuesta "+precios[posicion]+"euros");
                
        }
        public static void obtenerIVAProducto(Scanner teclado,String[] productos, float[] precios)
        {
                // si está vacío decirselo al usuario
                // en caso contrario
                // pedir producto
                // buscarlo
                // si no está advertirlo
                // en caso contrario mostrar IVA de ese producto
                int posicion=comprobarProducto(teclado, productos,precios);
                if (posicion>=0)
                        System.out.println("su IVA es "+precios[posicion]*0.21+"euros");
        }
        public static void modificarPrecio(Scanner teclado,String[] productos, float[] precios)
        {
                // si está vacío decirselo al usuario
                // en caso contrario
                // pedir producto
                // buscarlo
                // si no está advertirlo
                // en caso contrario pedir nuevo precio y cambiarlo
                int posicion=comprobarProducto(teclado, productos,precios);
                if (posicion>=0)
                {
                        System.out.println("Introducir precio");
                        precios[posicion]=teclado.nextFloat();
                        teclado.nextLine();
                }
        }
        public static void eliminarProducto(Scanner teclado,String[] productos, float[] precios)
        {
                // si está vacío decirselo al usuario
                // en caso contrario
                // pedir producto
                // buscarlo
                // si no está advertirlo
                // en caso contrario desplazar todos los que están a la derecha de él 1 a la izquierda
                int posicion=comprobarProducto(teclado, productos,precios);
                if (posicion>=0)
                {
                        for(int j=posicion;j<numProductos-1;j++)
                        {
                                productos[j]=productos[j+1];
                                precios[j]=precios[j+1];
                        }
                        productos[numProductos-1]="";
                        precios[numProductos-1]=0;
                        numProductos--;
                        
                }
        }
        public static void aniadirArticulos(Scanner teclado,String[] productos, float[] precios)
        {
                // si el array está lleno le advierto al usuario y no hago nada                
                // mientras quiera continuar añade más articulos al final del array
                if (numProductos==productos.length)
                        System.out.println("No caben mas productos");
                else
                {        boolean continuar=true;
                        while (continuar)
                        {
                                System.out.println("Introducir articulo");
                                productos[numProductos]=teclado.nextLine();
                                System.out.println("Introducir precio");
                                precios[numProductos]=teclado.nextFloat();
                                teclado.nextLine();
                                numProductos++;
                                System.out.println("Quiere cntinuar añadiendo? S/s en caso de que si");
                                if (!teclado.nextLine().equalsIgnoreCase("S"))
                                        continuar=false;
                        }
                }
                
        }
        public static void MayorMenor(Scanner teclado,String[] productos, float[] precios, int opcion) {
        	float aux;
    		String aux2;
    		for(int i = 0;i<precios.length;i++)
    		{
    			for(int j =0; j<precios.length - i -1; j++)
    			{
    				if (precios[j]>precios[j+1]&& opcion==8 || (precios[j]<precios[j+1]&& opcion==9))
    				{
    					
    					aux= precios[j];
    					precios[j] = precios[j+1];
    					precios[j+1] = aux;
    					aux2= productos[j];
    					productos[j] = productos[j+1];
    					productos[j+1] = aux2;
    				}
    			}
    		}
    		for(int i = 0;i<precios.length;i++)
    			System.out.println(precios[i]);
    }

}

		