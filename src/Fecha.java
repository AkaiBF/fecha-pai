/**
 * Clase Fecha
 * 
 * Clase para definir una fecha con control de excepciones para sólo aceptar fechas válidas. Aún en desarrollo.
 * 
 * @author Ernesto Echeverría González
 * @version 0.0.1
 * @since 17-02-2017
 * 
 * For further information contact the author via e-mail:
 * alu0100881622@ull.edu.es
*/
public class Fecha {
  private int day;
  private int month;
  private int year;
  
  public Fecha() {
    day = 1;
    month = 1;
    year = 1800;
  }
  
  public Fecha(int day, int month, int year) {
    this.day = day;
    this.month = month;
    this.year = year;
  }
  
  public boolean esBisiesto() {
    if(year%400 == 0) return true;
    if(year%100 == 0) return false;
    if(year%4 == 0) return true;
    return false;
  }
  
  public boolean esFechaValida() {
    if(day < 1 || month < 1 || month > 12) return false;
    switch(month) {
      case 1:
      case 3:
      case 5:
      case 7:
      case 8:
      case 10:
      case 12:
        if(day <= 31) return true;
        return false;
      case 4:
      case 6:
      case 9:
      case 11:
        if(day <= 30) return true;
        return false;
      case 2:
        if((this.esBisiesto() && day <= 29) || day <= 28) return true;
        return false;
    }
    return false;
  }
  
  public String getDiaDeSemana() {
    int monthcode = 0;
    if(!esBisiesto()) {
      switch(month) {
        case 1:
        case 10:
          monthcode = 0;
        break;
        case 5:
          monthcode = 1;
        break;
        case 8:
          monthcode = 2;
        break;
        case 2:
        case 3:
        case 11:
          monthcode = 3;
        break;
        case 6:
          monthcode = 4;
        break;
        case 9:
        case 12:
          monthcode = 5;
        break;
        case 4:
        case 7:
          monthcode = 6;
      }
    } 
    else {
      switch(month) {
        case 10:
          monthcode = 0;
        break;
        case 5:
          monthcode = 1;
        break;
        case 2:
        case 8:
          monthcode = 2;
        break;
        case 3:
        case 11:
          monthcode = 3;
        break;
        case 6:
          monthcode = 4;
        break;
        case 9:
        case 12:
          monthcode = 5;
        break;
        case 1:
        case 4:
        case 7:
          monthcode = 6;
        break;
      }  
    } int weekday = (day + monthcode + (year%100) + ((year%100)/4) + (year/100 +1))%7;
    switch(weekday) {
      case 0:
        return "Sábado";
      case 1:
        return "Domingo";
      case 2:
        return "Lunes";
      case 3:
        return "Martes";
      case 4:
        return "Miércoles";
      case 5:
        return "Jueves";
      case 6:
        return "Viernes";
    }
    return "Error";
  }
  
  public void setFecha(int year, int month, int day) {
    this.day = day;
    this.month = month;
    this.year = year;
    //Excepción con esFechaValida
  }
  
  /*
  public void setAnio() {
    //Comprobar que el año está entre dos valores o enviar excepción
  }
  
  public void setMes() {
    
  }
  
  public void setDia() {
    
  }*/
  
  public void setDay(int day) {
    this.day = day;
  }
  
  public void setMonth(int month) {
    this.month = month;
  }
  
  public void setYear(int year) {
    this.year = year;
  }
  
  public int getAnio() {
    return year;
  }
  
  public int getMes() {
    return month;
  }
  
  public int getDia() {
    return day;
  }
  
  public String toString() {
    String stringMonth = new String();
    switch(month) {
      case 1:
        stringMonth = "enero";
      break;
      case 2:
        stringMonth = "febrero";
      break;
      case 3:
        stringMonth = "marzo";
      break;
      case 4:
        stringMonth = "abril";
      break;
      case 5:
        stringMonth = "mayo";
      break;
      case 6:
        stringMonth = "junio";
      break;
      case 7:
        stringMonth = "julio";
      break;
      case 8:
        stringMonth = "agosto";
      break;
      case 9:
        stringMonth = "septiembre";
      break;
      case 10:
        stringMonth = "octubre";
      break;
      case 11:
        stringMonth = "noviembre";
      break;
      case 12:
        stringMonth = "diciembre";
      break;
    }
    String output = new String(getDiaDeSemana() + ", " + day + " de " + stringMonth + " de " + year);
    return output;
  }
  
  public Fecha siguienteDia() {
    Fecha next = new Fecha(day + 1, month, year);
    if(next.esFechaValida()) return next;
    next.setDay(1);
    next.setMonth(month + 1);
    if(next.esFechaValida()) return next;
    next.setMonth(1);
    next.setYear(year + 1);
    return next;
  }
  
  public Fecha siguienteMes() {
    Fecha next = new Fecha(day, month, year);
    
    if(day == 31) {
      switch(this.getMes()) {
        case 3:
        case 5:
        case 8:
        case 10:
          this.setDay(30);
        break;
        default:
      }
    }
    if(this.getMes() == 1 && this.getDia() > 28) {
      if(this.esBisiesto()) {
        this.setDay(29);
      }
      else {
        this.setDay(28);
      }
    }
    if(this.getMes() == 12) {
      this.setYear(this.getAnio() + 1);
      this.setMonth(1);
    }
    else {
      this.setMonth(this.getMes() + 1);
    }
    return next;
  }

  public Fecha siguienteAnio() {
    Fecha next = new Fecha(day, month, year + 1);
    if(getDia() == 29 && getMes() == 2) next.setDay(28);
    return next;
  }
}