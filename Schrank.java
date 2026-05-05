
/**
 * Beschreiben Sie hier die Klasse Schrank.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
import sas.*;
import java.awt.Color;
public class Schrank extends Grundelement
{

    /**
     * Konstruktor für Objekte der Klasse Schrank
     */
    public Schrank(int pX, int pY, int pBreite, int pHoehe, Color pFarbe)
    {
        super(pBreite, pHoehe, pFarbe);
        Sprite grafik = this.gibGrafik();
        int tuerBreite = this.breiteInPixel()/2- 4;
        int tuerHoehe = this.hoeheInPixel() - SOCKELHOEHE-7;
        Sprite tuerLinks = this.rechteckMitRand(tuerBreite,tuerHoehe,0, pFarbe);
        Circle knopf = new Circle(tuerBreite * 0.8, pHoehe * PIXEL_PRO_RASTER_HOEHE / 2 - 2, 2, Color.BLACK);
        tuerLinks.add(knopf);
        tuerLinks.moveTo(4, 4);
        this.gibGrafik().add(tuerLinks);
        Sprite tuerRechts = this.rechteckMitRand(tuerBreite, tuerHoehe,0, pFarbe);
        knopf = new Circle(tuerBreite * 0.2, pHoehe * PIXEL_PRO_RASTER_HOEHE / 2 - 2, 2, Color.BLACK);
        tuerRechts.add(knopf);
        tuerRechts.moveTo(this.breiteInPixel()/2,4);
        this.gibGrafik().add(tuerRechts);
        this.setPosition(pX, pY);
    }

}