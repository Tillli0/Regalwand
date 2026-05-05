
/**
 * Beschreiben Sie hier die Klasse Regal.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
import sas.*;
import java.awt.Color; 
class Grundelement
{
    protected final static int PIXEL_PRO_RASTER_BREITE = 40;
    protected final static int PIXEL_PRO_RASTER_HOEHE = 48;
    protected final static int SOCKELHOEHE = 10;
    private int rasterBreite;
    private int rasterHoehe;
    private int xPos = 0;
    private int yPos = 0;
    private Color farbe;
    private Sprite regal;
    
    /**
     * Konstruktor für Objekte der Klasse Regal
     */
    protected Grundelement(int pRasterBreite, int pRasterHoehe, Color pFarbe)
    { 
       rasterBreite = pRasterBreite;
       rasterHoehe = pRasterHoehe;
       farbe = pFarbe;
       regal = new Sprite();
       Sprite sockel = rechteckMitRand(pRasterBreite * PIXEL_PRO_RASTER_BREITE, SOCKELHOEHE, 0, farbe);
       Sprite korpus = rechteckMitRand(pRasterBreite * PIXEL_PRO_RASTER_BREITE, pRasterHoehe * PIXEL_PRO_RASTER_HOEHE+1, 4, farbe);
       sockel.move(0,pRasterHoehe * PIXEL_PRO_RASTER_HOEHE);
       regal.add(sockel);
       regal.add(korpus);
    }
   
    protected Sprite rechteckMitRand(int breite, int hoehe, int rand, Color farbe){
        Rectangle aussenRechteck = new Rectangle(0,0,breite, hoehe, Color.BLACK);
        Rectangle innenRechteck1  = new Rectangle(1,1,breite-2,hoehe-2, farbe);
        Rectangle innenRechteck2  = new Rectangle(rand,rand,breite-2*rand,hoehe-2*rand, Color.BLACK);
        Rectangle innenRechteck3  = new Rectangle(rand+1,rand+1,breite-2*rand-2,hoehe-2*rand-2, farbe);
        Sprite rmr = new Sprite();
        rmr.add(aussenRechteck);
        rmr.add(innenRechteck1);
        rmr.add(innenRechteck2);
        rmr.add(innenRechteck3);
        return rmr;
    }
    
    public Sprite gibGrafik(){
      return regal;
    }
    
    public int hoeheInPixel(){
        return SOCKELHOEHE + PIXEL_PRO_RASTER_HOEHE * rasterHoehe;
    }
    
    public int breiteInPixel(){
        return PIXEL_PRO_RASTER_BREITE * rasterBreite;
    }
    
    public void setPosition(int pX, int pY) {
        xPos = pX;
        yPos = pY;
        regal.moveTo(xPos, yPos);
    }
}

