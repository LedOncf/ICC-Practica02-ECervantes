import java.util.Scanner ;

/**
 * Programa para simulación del rendimiento de inversión dado monto, fecha de inicio y fin
 * Objetivo: Comprender el manejo de clases, sus métodos y aplicarlos a objetos
 * @author Cervantes Fabela Edgar Leonardo
 * @version 1.0
 */
public class TiempoDeInversion{
  public static void main(String [] args) {
    Scanner in = new Scanner(System.in) ;
    //Bienvenida
    System.out.println("Sea bienvenid@ al simulador de inversión") ;
    System.out.println("¿Cuál es su nombre?") ;
    String name = in.nextLine() ;
    String answer ;
      do{
      //Saludar, pedir monto, fecha de inicio y fin
      System.out.println("Hola " + name + ". Dime, ¿cuál es el monto que deseas invertir?") ;
      double monto = in.nextDouble() ;
      in.nextLine() ;
      if (monto < 0){
        System.out.println(monto + "no es una cantidad válida") ;
      }

      System.out.println("Ingresa la fecha del inicio de inversión:") ;
      System.out.println("Día:") ;
      int beginDay = in.nextInt() ;
      in.nextLine() ;
      System.out.println("Nombre del mes:") ;
      String beginMonth = in.nextLine() ;
      System.out.println("Año:") ;
      int beginYear = in.nextInt() ;
      in.nextLine() ;
      Fecha begin = new Fecha(beginDay, beginMonth, beginYear) ;

      System.out.println("Ingresa la fecha del fin de inversión:") ;
      System.out.println("Día:") ;
      int endDay = in.nextInt() ;
      in.nextLine() ;
      System.out.println("Nombre del mes:") ;
      String endMonth = in.nextLine() ;
      System.out.println("Año:") ;
      int endYear = in.nextInt() ;
      in.nextLine() ;
      Fecha end = new Fecha(endDay, endMonth, endYear) ;
      
      //Mostrar días de inversión y rendimiento al 12%
      int investmentDays = begin.difference(end) ;
      double rendimiento = monto * (0.12/365.0) * investmentDays ;
      System.out.println("Días de inversión: " + investmentDays) ;
      System.out.println("Rendimiento generado: " + rendimiento) ;
      
      //Preguntar por otra simulación
      System.out.println("¿Desea realizar otra simulación? (s/n)") ;
      answer = in.nextLine() ;
      answer = answer.toLowerCase() ;
      }while (answer.charAt(0) == 's') ;
  }
}
