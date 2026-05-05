/**
 * Prüft die Korrektheit eines Eingabestrings für die Regalwand
 * und liefert Breite, Höhe, Typ und Farbe des geüwnschten Tegalelementes
 * 
 * @author Klaus Dingemann
 * @version 03.08.2017
 */
import sas.*;
import java.awt.Color;
public class Regalstring {
  String regal;
  /**
   * Konstruktor für Objekte der Klasse Regalstring
  */

  public Regalstring(String pRegal) {
    regal = pRegal;
  }
    
  public boolean istRegalstring() {
    boolean korrekt = true;
    if (regal.length()!=4) {
        regal="";
        korrekt=false;
    } else {
        int breite = (int) regal.charAt(0);
        int hoehe = (int) regal.charAt(1);
        char element = regal.charAt(2);
        char farbe = regal.charAt(3);
        korrekt = (breite > 0 && breite < 7) &&
                  (hoehe > 0 && hoehe < 5) &&
                  (element == 's' || element == 'r') &&
                  (farbe == 'w' || farbe == 'r' || farbe == 'y' || farbe == 'g' || farbe == 'b' || farbe == 'p');
    }
    return korrekt;
  }
    
  String getRegalstring(){
    return regal;
  }
    
  int gibBreite(){
    return Tools.stringToInt(regal.substring(0,1)); 
  }
    
  int gibHoehe() { 
    return Tools.stringToInt(regal.substring(1,2)); 
  }
    
  char gibElement(){
    return regal.charAt(2);
  }
    
  Color gibFarbe(){
    Color farbe = Color.WHITE;
    switch (regal.substring(3,4)) {
      case "w": farbe= Color.WHITE; break;
      case "r": farbe = Color.RED; break;
      case "y": farbe=Color.YELLOW; break;
      case "g": farbe=Color.GREEN;break;
      case "b": farbe=Color.GRAY;break;
      case "p": farbe=Color.PINK;break;
    }
    return farbe;
  }
    
}
