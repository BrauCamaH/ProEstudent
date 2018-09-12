
package reportes;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import proestudent.Conexion;

/**
 *
 * @author ACER
 */
public class ReporteUsuarios {
    public void generarReporte(){
        try {
            Conexion conexion= new Conexion();
            
            JasperReport reporte =(JasperReport) JRLoader.loadObject("Reporte.jasper");
            Map parametro = new HashMap();
   
            JasperPrint j = JasperFillManager.fillReport(reporte, parametro, conexion.getConexion());
            JasperViewer jv = new JasperViewer(j,false);
            jv.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(ReporteUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
           

    }
}
