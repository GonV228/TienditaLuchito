
package Controlador;
///importar clases
import VistaLogin.Login;
import VistaAdministrador.MenuAdministrador;
import VistaAdministrador.Administrador;
import VistaInventario.Inventario;
import VistaVentas.Ventas;
import VistaAdministrador.Administrador_RegistrarUsers;

//importar librerias
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class CMenuAdministrador implements ActionListener{
    //inicialización
    MenuAdministrador vista;
    private String nombre;
    private String apellido;
    private String correo;
    private byte[] imagen;
    //inicialización del dao para poder traer al menu los datos del usuario que inicia sesión
    
    //constructor
    public CMenuAdministrador(MenuAdministrador menu, String name, String address, String email, byte[] img){
        this.vista=menu;
        this.nombre=name;
        this.apellido=address;
        this.correo=email;
        this.imagen=img;
        menu.setVisible(true);
        menu.setTitle("Administrador");
        menu.setLocationRelativeTo(null); //centrar ventana
        vista.jbtnAdminEmpleados.addActionListener(this);
        vista.jbtnInventario.addActionListener(this);
        vista.jbtnVentas.addActionListener(this);
        vista.jbtnCerrarSesion.addActionListener(this);
        
        UsuarioEnSesion(name, address,email, img);
        System.out.println("constructor");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //ADMINISTRAR EMPLEADOS
        if(e.getSource()==vista.jbtnAdminEmpleados){
            
            //System.out.println(UsuarioEnSesion(nombre, apellido, correo, imagen));
            Administrador adm=new Administrador();//instanciar
            CAdministrador controlador=new CAdministrador(adm);
            vista.PrincipalMenu.removeAll();
            vista.PrincipalMenu.setLayout(new BorderLayout());
            vista.PrincipalMenu.add(adm.getContentPane(),BorderLayout.CENTER);
            vista.PrincipalMenu.revalidate();
            vista.PrincipalMenu.repaint();
            UsuarioEnSesion(nombre, apellido, correo, imagen);
        }
        
        //INVENTARIO
        if(e.getSource()==vista.jbtnInventario){
            Inventario vistaInve=new Inventario();
            CInventario controlador=new CInventario(vistaInve);
            vista.PrincipalMenu.removeAll();
            vista.PrincipalMenu.setLayout(new BorderLayout());
            vista.PrincipalMenu.add(vistaInve.getContentPane(),BorderLayout.CENTER);
            vista.PrincipalMenu.revalidate();
            vista.PrincipalMenu.repaint();
        }
        //VENTAS
        if(e.getSource()==vista.jbtnVentas){
            Ventas vistaVen=new Ventas();
            CVentas controlador=new CVentas(vistaVen);
        }
        //CERRAR SESIÓN
        if(e.getSource()==vista.jbtnCerrarSesion){
            Login vistaLogin=new Login();
            ControladorLogin controlador=new ControladorLogin(vistaLogin);
            vista.dispose();
        }
        
    }
    
    ////////////////////////////////////////////////////////////////////////////////////////
    //Procesos
    ////////////////////////////////////////////////////////////////////////////////////////
    
    public String UsuarioEnSesion(String nom, String ape,String corre, byte[] imgByte){
        String nombreUser=(nom+" "+ape);
        vista.JlabelNombreUsuario.setText(nombreUser);
        vista.JlabelCorreo.setText(corre);
        
        if(imgByte!=null){
            System.out.println("Updating image with byte array of length: " + imgByte.length); // Depuración
        
            ImageIcon imagenIcon=new ImageIcon(imgByte);
            Icon icon = imagenIcon;
            
            // Actualizar la imagen en el hilo de despacho de eventos
            //PROHIBIDO BORRAR ESTE BLOQUE DE CODIGO
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    vista.rspanelImagen.setImagen(icon);
                    vista.rspanelImagen.revalidate(); // Forzar actualización de diseño
                    vista.rspanelImagen.repaint();    // Volver a pintar el componente
                }
            });
           
        } else {
            System.out.println("a llorar");
        }
        
        
    return nombreUser;
    }
    
}

