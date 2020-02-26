package ejemplomap;

import com.teamdev.jxbrowser.browser.Browser;
import com.teamdev.jxbrowser.engine.Engine;
import com.teamdev.jxbrowser.engine.EngineOptions;
import static com.teamdev.jxbrowser.engine.RenderingMode.HARDWARE_ACCELERATED;
import com.teamdev.jxmaps.swing.MapView;
import com.teamdev.jxmaps.*;
import java.awt.BorderLayout;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class EjemploMap extends MapView{
    
     private Map map;

    public EjemploMap(double latitud, double longitud) {
        
        JFrame fr = new JFrame();
        
        setOnMapReadyHandler(new MapReadyHandler() {
            @Override
            public void onMapReady(MapStatus status) throws UnsupportedOperationException {
                
                try {
                    
                    if (status == MapStatus.MAP_STATUS_OK) {
                         EngineOptions options
                = EngineOptions.newBuilder(HARDWARE_ACCELERATED).licenseKey("1BNDHFSC1FUO06W85DSCFTB7D3UWGB9NQU13RBIXZ27HMG851HR951OME5V2HMAVNQ62O3").build();
        Engine engine = Engine.newInstance(options);
        Browser browser = engine.newBrowser();
                        
                        map = getMap();
                        MapOptions mapOptions = new MapOptions();
                        MapTypeControlOptions controlOptions = new MapTypeControlOptions();
                        mapOptions.setMapTypeControlOptions(controlOptions);
                        
                        map.setOptions(mapOptions);
                        map.setCenter(new LatLng(latitud, longitud));
                        map.setZoom(11.0);
                        
                        Marker mark = new Marker(map);
                       mark.setPosition(map.getCenter());
                        
                    }
                    
                } catch (UnsupportedOperationException e) {
                    JOptionPane.showMessageDialog(null, " Error al cargar mapa " + e);
                }
                
            }
        });
        
        fr.add(this, BorderLayout.CENTER);
        fr.setSize(700, 500);
        fr.setLocationRelativeTo(null);
        fr.setVisible(true);
        
    }

    /**
     * @param args the command line arguments
     */
    
    static Scanner leer = new Scanner(System.in);
    public static void main(String[] args) {
        
        System.out.println(" Ingrese latitud");
        double latitud = leer.nextDouble();
        System.out.println(" Ingrese longitud");
        double longitud= leer.nextDouble();
        EjemploMap temp= new EjemploMap(latitud, longitud);
    }

}
