
/**
 * Beschreiben Sie hier die Klasse Regal.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
import sas.*;
import java.awt.Color;
public class Regal extends Grundelement
{
    

    /**
     * Konstruktor für Objekte der Klasse Regal
     */
    public Regal(int pX, int pY, int pBreite, int pHoehe, Color pFarbe) 
    {
        super(pBreite, pHoehe, pFarbe);
        for (int i= 0; i < pHoehe-1; i++) {
          Sprite brett = this.rechteckMitRand(this.breiteInPixel()-8, 4 , 4, pFarbe);
          Sprite grafik = this.gibGrafik();
          brett.moveTo(4,PIXEL_PRO_RASTER_HOEHE*(i+1));
          this.gibGrafik().add(brett);
        }
       this.setPosition(pX, pY);
    }

}