class Principal {
  public static void main(String[] args){
    Fecha hoy = new Fecha(31, 12, 2017);
    System.out.println(hoy.getDiaDeSemana());
    System.out.println(hoy);
    System.out.println(hoy.siguienteDia());
  }
}