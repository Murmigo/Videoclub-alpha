
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jaime Sotelo
 *         David Virtus
 *         Luis Alberto Feliz
 *         Yoel Cano
 *         Hector García
 *         Luis Guillermo Abarca
 */
public class Inicio extends javax.swing.JFrame {
    
    //conectar a la base de datos
    private Statement estado, estadoPeliculas;
    private ResultSet resultadoConsulta, resultadoConsultaPelicula;
    private Connection conexion;
    
    public ArrayList<Pelicula> listaPeliculas = new ArrayList <Pelicula>(); 
    public ArrayList<Usuario> listaUsuarios = new ArrayList <Usuario>();
    public ArrayList<Prestamos> listaPrestamos = new ArrayList<Prestamos>();
    ArrayList <String> generos = new ArrayList<>();
    /**
     * Creates new form Inicio
     */
    
    //Empieza el inicio
    public Inicio() {
        initComponents();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1/videoclub", "root", "");
            estado = conexion.createStatement();
            estadoPeliculas = conexion.createStatement();
            resultadoConsulta = estado.executeQuery("Select * from usuarios");
            while(resultadoConsulta.next()){
                Usuario usu = new Usuario();
                usu.apellido = resultadoConsulta.getString(3);
                usu.dni = resultadoConsulta.getString(1);
                usu.email = resultadoConsulta.getString(5);
                usu.nombre = resultadoConsulta.getString(2);
                usu.penalizacion = resultadoConsulta.getInt(4);
                
                listaUsuarios.add(usu);
            }
            resultadoConsultaPelicula = estadoPeliculas.executeQuery("Select * from peliculas");
            while(resultadoConsultaPelicula.next()){
                Pelicula peli = new Pelicula();
                peli.año = resultadoConsultaPelicula.getInt(3);
                peli.clasificacion = resultadoConsultaPelicula.getString(7);
                peli.genero = resultadoConsultaPelicula.getString(5);
                peli.id = resultadoConsultaPelicula.getInt(1);
                peli.imdb = resultadoConsultaPelicula.getInt(6);
                peli.pais = resultadoConsultaPelicula.getString(4);
                peli.resumen = resultadoConsultaPelicula.getString(8);
                peli.titulo = resultadoConsultaPelicula.getString(2);

                listaPeliculas.add(peli);
            }
        }
        catch (Exception e){
        }
        definirGeneros();
    }
    
    private void definirGeneros()
    {
    
    for(int i = 0; i<listaPeliculas.size(); i++){
        for(int j = 0; j<=generos.size(); j++){
            if(!listaPeliculas.get(i).genero.equals(generos.get(j)))
            {
                generos.add(listaPeliculas.get(i).genero);
            }
        }
    }
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Connect = new javax.swing.JButton();
        IntroducirNombre = new javax.swing.JTextField();
        IntroducirClave = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Connect.setText("Connect");
        Connect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConnectActionPerformed(evt);
            }
        });

        IntroducirNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        IntroducirNombre.setText("Introduce tu Nombre");
        IntroducirNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        IntroducirNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IntroducirNombreActionPerformed(evt);
            }
        });

        IntroducirClave.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        IntroducirClave.setText("Introduce tu Clave");
        IntroducirClave.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(306, 306, 306)
                .addComponent(Connect, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(223, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(IntroducirNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                    .addComponent(IntroducirClave))
                .addGap(214, 214, 214))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(208, Short.MAX_VALUE)
                .addComponent(IntroducirNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(IntroducirClave, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Connect)
                .addGap(195, 195, 195))
        );

        Connect.getAccessibleContext().setAccessibleParent(null);
        IntroducirNombre.getAccessibleContext().setAccessibleParent(null);
        IntroducirClave.getAccessibleContext().setAccessibleParent(null);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IntroducirNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IntroducirNombreActionPerformed
        
    }//GEN-LAST:event_IntroducirNombreActionPerformed

    private void ConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConnectActionPerformed
         if(IntroducirNombre.getText().equals("admin") && IntroducirClave.getText().equals("admin"))
        {
            new Admin(listaUsuarios,listaPeliculas).setVisible(true);
        } else{
            boolean encontrado = false;
            int contador = 0;
            while(!encontrado && contador < listaUsuarios.size())
            {
                if(listaUsuarios.get(contador).nombre.equalsIgnoreCase(IntroducirNombre.getText()))
                {
                    encontrado = true;
                    new PerfilUsuario(listaUsuarios.get(contador),listaUsuarios, listaPeliculas).setVisible(true);
                }
                contador++;
            }
        }
    }//GEN-LAST:event_ConnectActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Connect;
    private javax.swing.JTextField IntroducirClave;
    private javax.swing.JTextField IntroducirNombre;
    // End of variables declaration//GEN-END:variables
}
