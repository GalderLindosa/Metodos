package ejercicioMetodos;
import java.util.Scanner;
public class MenuMetodos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		char menu;
		int b [] = new int [10];
		System.out.println("A. Doblar array");
		System.out.println("B. Escribir numeros y sacar media");
		System.out.println("C. Mostrar numeros diferentes");
		menu = teclado.next().charAt(0);
		switch (menu) {
		case 'A':
			doblearray(teclado,b);
			break;
		case 'B':
			IntroducirNum(teclado);
			break;
		case 'C':
			NoRepNum(teclado, b);
			break;
		default: System.out.println("Opcion no valida");
		}
	}

	public static void doblearray(Scanner teclado, int b[] ) {
		int a [] = new int [] {386,276,404,147,70,5,259,152,357,12};
		String nombre;
		System.out.println("Introduzca su nombre: ");
		nombre = teclado.next();
		System.out.println("Array A:");
		for(int i : a) {
			System.out.print(i+" ");
		}
		System.out.println(" ");
		System.out.println("Array b:");
		for (int i = 0; i<a.length;i++) {

			b[i]=a[i]*2;
			System.out.print(b[i]+" ");
		}
		System.out.println(" ");
		System.out.println(nombre.toUpperCase());
	}

	public static void IntroducirNum(Scanner teclado) {
		int num;
		String salir;
		int cont=0;
		double med=0;
		do {
			System.out.println("Introduce un numero:");
			num=teclado.nextInt();
			if (num>0) {
				for (int i = 0;i<num;i++) {
					System.out.print("*");

				}
				med=med+num;
				cont++;
			}

			if (num<0) {
				System.out.println("?");
			}
			System.out.println();
			System.out.println("¿Quieres continuar introduciendo números (S/s -->SI N/n -->NO)?:");
			salir = teclado.next();

		}while(salir.equalsIgnoreCase("s"));
		System.out.println("Se han introducido "+cont +" números positivos y su media es: "+(med/cont));
	}

	public static void NoRepNum (Scanner teclado, int b []) {
		int num=1;
		boolean enc;
		for (int i = 0; i<b.length;i++) {
			enc=false;
			System.out.println("Introduce numero "+i);
			num=teclado.nextInt();
			for (int j=0;j<b.length&&!enc;j++) {
				if (b[j]==num) {
					enc=true;
				}
			}
			if (num<=10 && num>0 && !enc) {
				b[i]=num;
			}
		}
		for(int i : b) {
			if (i!=0) {
				System.out.print(i+" ");
			}
		}
	}
}
