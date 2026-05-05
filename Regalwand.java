
/**
 * Mit diesem Programm können sich Kunden einen Möbelhauses interaktiv 
 * eine Schrankwand zusammenstellen
 * 
 * @author Klaus Dingemann
 * @version 03.08.2017
 */
import sas.*;
import sasio.*;
import java.awt.Color;
public class Regalwand {
  private static int WANDHOEHE = 250;//Höhe der Wand
  private View view;
  private Grundelement[] regalwand;
  private int anzahlElemente;//Anzahl der Schrankwandelemente
  private int rasterBreite;//Schrankwandbreite in Rasterm
  private int xNext;//Position des aktuellen Elementes
  private int yNext;//y-Position des aktuellen Elementes
  private Textfield textfeld;
  private Regalstring regstring;
    
  public Regalwand() {
    view = new View (800, 300, "Schrankwand");
    anzahlElemente = 0;
    rasterBreite = 0;
    xNext = 0;
    yNext = 0;
    Rectangle hintergrund = new Rectangle(0, 0, 800, WANDHOEHE, new Color(200,200,200));
    //Die maximale Schrankwandbreite beträt 20 Raster
    regalwand = new Grundelement[20];
    textfeld = new Textfield(5, 260,50,20,"24sr",view); 
  }
    
  private void neuesElement(int pBreite, int pHoehe, char pTyp, Color pFarbe) {
    //Berechnung der y-Position des Schrankwandelementes
    yNext = WANDHOEHE - pHoehe * Grundelement.PIXEL_PRO_RASTER_HOEHE - Grundelement.SOCKELHOEHE;
    if (pTyp == 'r') {
      //neues Regalelement
      regalwand[anzahlElemente] = new Regal(xNext, yNext, pBreite, pHoehe, pFarbe);
    } else {
      //neues Schrankelement
      regalwand[anzahlElemente] = new Schrank(xNext, yNext, pBreite, pHoehe, pFarbe);
    } 
    Sprite element = regalwand[anzahlElemente].gibGrafik();
    rasterBreite = rasterBreite + pBreite;
    anzahlElemente = anzahlElemente + 1;
    //Berechnung der X-Position des nächsten Elementes
    xNext = xNext + pBreite * Grundelement.PIXEL_PRO_RASTER_BREITE;
  }  
  
  public void fuehreAus() {
    String eingabe = ""; 
    boolean ende=false;
    textfeld.setActivated(true);
    while (rasterBreite<20) {
      if (textfeld.enterPressed()) {
          Regalstring regalstring = new Regalstring(textfeld.getText());
          if (regalstring.istRegalstring()) {
              neuesElement(regalstring.gibBreite(), regalstring.gibHoehe(), regalstring.gibElement(), regalstring.gibFarbe());
          }
          textfeld.deleteText();
          textfeld.setActivated(true);
      }
      view.wait(50);
    }   
 }
}