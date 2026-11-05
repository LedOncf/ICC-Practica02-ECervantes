/**
 * Clase para el manejo de fechas en el formato dd/mes/año donde el mes puede ser expresado en número o letras
 * Objetivo: Entender como se construye una clase, que son los atributos, y los distintos tipos de métodos, además de usar conocimiento sobre bucles y condicionales
 * @author Cervantes Fabela Edgar Leonardo
 * @version 1.0
 */ 
public class Fecha{

  private int day ;
  private int month ;
  private int year ;

/**
 * Constructor por omisión. Construye la fecha 01/01/2026 
 */
  public Fecha(){
    setDay(1) ;
    setMonth(1) ;
    setYear(2026) ;
  }

/**
 * Constructor de una fecha a partir del día, el mes, el año
 * @param d - valor para el día
 * @param m - valor para el mes
 * @param y - valor para el año
 */
  public Fecha(int d, int m, int y){
    setYear(y) ;
    setMonth(m) ;
    setDay(d) ;
  }

/**
 * Constructor de una fecha con numero de día y año, y cadena para el mes
 * @param d - valor para el día
 * @param m - cadena con el nombre del mes
 * @param y - valor para el año
 */
  public Fecha(int d, String m, int y){
    setYear(y) ;
    setMonth(monthToNum(m)) ;
    setDay(d) ;
  }



/**
 * Método para obtener el número de día 
 * @return int - el día del objeto Fecha 
 */
  public int getDay(){
    return day ;
  }

/**
 * Método para obtener el número de mes 
 * @return int - el mes del objeto Fecha 
 */
  public int getMonth(){
    return month ;
  }

/**
 * Método para obtener el número de año 
 * @return int - el año del objeto Fecha 
 */
  public int getYear(){
    return year ;
  }

/**
 * Método para asignar el día 
 * @param d - el día para el objeto Fecha 
 */
  public void setDay(int d){
    if (d > 0 && d <= daysInMonth(getMonth())){
      day = d ;
    } else {
      System.out.println(d + " no es un valor apropiado para el día") ;
    }
  }

/**
 * Método para asignar el mes 
 * @param m - el mes para el objeto Fecha 
 */
  public void setMonth(int m){
    if (m > 0 && m <= 12){
      month = m ;
    } else {
      System.out.println(m + " no es un valor apropiado para el mes") ;
    }
  }

/**
 * Método para asignar el año 
 * @param y - el año para el objeto Fecha 
 */
  public void setYear(int y){
    if (y > 0){
      year = y ;
    } else {
      System.out.println(y + " no es un valor apropiado para el año") ;
    }
  }

/**
 * Método para saber cuántos días hay en el mes dado 
 * @param m - el mes a analizar
 * @return int - número de días en el mes 
 */
  private int daysInMonth(int m){
    if (m == 2){
      if (isLeap(getYear())){
        return 29 ;
      } else {
        return 28 ;
      }
    } else if (m < 8){
      if (m % 2 == 1){
        return 31 ;
      } else {
        return 30 ;
      }
    } else {
      if (m % 2 == 1){
        return 30 ;
      } else {
        return 31 ;
      }
    }    
  }

/**
 * Método para ver si el año es bisiesto o no
 * @param y - año a analizar 
 * @return boolean - indicar si el año bisiesto o no
 */
  private boolean isLeap(int y){
    return ((y % 4 == 0 && y % 100 != 0) || (y % 400 == 0)) ;
  }

/**
 * Método para obtener los días transcurridos del año
 * @return int - días transcurridos en el año 
 */
  public int daysPassed(){
    int result = 0, i = 1 ; 
    while(i < getMonth()){
      result += daysInMonth(i) ;
        i++ ;
    }
    result += getDay() ;
    return result ; 
  }

/**
 * Método para obtener la diferencia en días, entre dos fechas
 * @param x - Objeto de la clase Fecha a comparar
 * @return int - diferencia en días entre las fechas 
 */
  public int difference(Fecha x){
    int result = 0 ;
    if (getYear() == x.getYear()){
      return x.daysPassed() - daysPassed() ;
    }

    int daysInYear;
    if (isLeap(getYear())){
      daysInYear = 366 ;
    } else {
      daysInYear = 365 ;
    }
    result = daysInYear - daysPassed() ;
    int y = getYear() + 1 ;
    while (y <x.getYear()){
      if (isLeap(y)){
        result += 366 ;
      } else {
        result += 365 ;
      }
      y++ ;
    }
    result += x.daysPassed() ;
    return result ; 
  }

/**
 * Método para a partir de los días transcurridos del año, dar la fecha
 * @param dd - días transcurridos
 * @param yy - año del que se parte
 * @return Objeto - un objeto de la Clase Fecha teniendo como atributos los valores adecuados luego del cálculo a partir de los días transcurridos 
 */
  public Fecha dateFromDays(int dd, int yy){
    if (dd <= 0) {
      System.out.println("El valor "+ dd + "no es válido para los días") ;
    }
    if (yy <= 0){
      System.out.println("El valor "+ yy + "no es válido para el año") ;
    }
    Fecha x = new Fecha(1,1,yy) ;
    int mm = 1 ;
    while (dd > x.daysInMonth(mm)){
      dd -= x.daysInMonth(mm) ;
      mm++ ; 
    }
    x.setMonth(mm) ;  
    x.setDay(dd) ;
    return x ;
  }

/**
 * Método para modificar una fecha sumando o restando días
 * @param d - días a sumar o restar
 * @return Objeto - un objeto de la clase Fecha con las modificaciones correspondientes
 */
  public Fecha modDate(int d){
    int totalDays = daysPassed() + d ;
    int currentYear = getYear() ;
    while (totalDays <= 0){
      currentYear-- ;
      if (isLeap(currentYear)){
        totalDays += 366 ;
      } else {
        totalDays += 365 ;
      }
    }
    int limit;
    if (isLeap(currentYear)){
      limit = 366 ;
    } else {
      limit = 365 ;
    }
    while (totalDays > limit){
      totalDays -= limit ;
      currentYear++ ;

      if (isLeap(currentYear)){
        limit = 366 ;
      } else {
        limit = 365 ;
      }
    }
    return dateFromDays(totalDays, currentYear) ;
  }

/**
 * Método para determinar si dos fechas son iguales
 * @param x - objeto de la clase fecha a comparar
 * @return boolean - resultado de la comparación
 */
  public boolean equal(Fecha x){
    return getDay() == x.getDay() &&
           getMonth() == x.getMonth() &&
           getYear() == x.getYear() ;
  }

/**
 * Método para devolver el número correspondiente a un mes a partir de que reciba una cadena con su nombre
 * @param str - cadena con el nombre del mes
 * @return int - número del mes dado
 */
  public int monthToNum(String str){
    int num = 0 ;
    str = str.trim() ;
    str = str.toLowerCase() ;
    if (str.equals("enero")){
      num = 1 ;
    } else if (str.equals("febrero")){
      num = 2 ;
    } else if (str.equals("marzo")){
      num = 3 ;
    } else if (str.equals("abril")){
      num = 4 ;
    } else if (str.equals("mayo")){
      num = 5 ;
    } else if (str.equals("junio")){
      num = 6 ;
    } else if (str.equals("julio")){
      num = 7 ;
    } else if (str.equals("agosto")){
      num = 8 ;
    } else if (str.equals("septiembre")){
      num = 9 ;
    } else if (str.equals("octubre")){
      num = 10 ;
    } else if (str.equals("noviembre")){
      num = 11 ;
    } else if (str.equals("diciembre")){
      num = 12 ;
    } else {
      System.out.println("Nombre no válido de mes") ;
    }
    return num ;
  }

/**
 * Método que devuelve la cadena del mes a partir del número
 * @param num - número del mes 
 * @return String - nombre del mes
 */

  public String numToMonth(int num){
    String str = "" ;
    if (num == 1) {
      str = "enero" ;
    } else if (num == 2) {
      str = "febrero" ;
    } else if (num == 3) {
      str = "marzo" ;
    } else if (num == 4) {
      str = "abril" ;
    } else if (num == 5) {
      str = "mayo" ;
    } else if (num == 6) {
      str = "junio" ;
    } else if (num == 7) {
      str = "julio" ;
    } else if (num == 8) {
      str = "agosto" ;
    } else if (num == 9) {
      str = "septiembre" ;
    } else if (num == 10) {
      str = "octubre" ;
    } else if (num == 11) {
      str = "noviembre" ;
    } else if (num == 12) {
      str = "diciembre" ;
    } else {
      System.out.println("Número inválido para el mes") ;
    }
    return str ;
  }

/**
 * Método para representar una fecha con el formato dd/mes/aaaa
 * @return String - cadena de la fecha con el formato dd/mes/aaaa
 */
  public String format(){
    String m = numToMonth(getMonth()) ;
    String date = "" ;

    if (getDay()<10) {
      date = "0" ;
    }
    return date + getDay() + "/" + m + "/" + getYear() ;
  }
}
