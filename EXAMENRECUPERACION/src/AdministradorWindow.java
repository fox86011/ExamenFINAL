import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class AdministradorWindow extends JDialog {
    private JTextField txt_usuario;
    private JPasswordField pf_password;
    private JButton INGRESARButton;
    private JButton REGRESARButton;
    private JPanel ADMINISTRADOR;
    private Usuario usuario;

    public AdministradorWindow(JFrame parent) {
        super(parent);
        setTitle("Administrador");
        setContentPane(ADMINISTRADOR);
        setMinimumSize(new Dimension(450, 474));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        INGRESARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = txt_usuario.getText();
                String password = String.valueOf(pf_password.getPassword());
                usuario = getAuthenticatedUser(user, password);
                if (usuario != null) {
                    // El usuario se autenticó correctamente, mostrar la ventana de registro
                    RegistroWindow registroWindow = new RegistroWindow(null);
                    registroWindow.setVisible(true);
                    dispose(); // Cerrar esta ventana
                } else {
                    // Mostrar un mensaje de error
                    JOptionPane.showMessageDialog(AdministradorWindow.this, "Usuario o contraseña incorrectos");
                }
            }
        });
        REGRESARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Agregar lógica para regresar a la ventana anterior
            }
        });
    }

    private Usuario getAuthenticatedUser(String user, String password) {
        Usuario usuario = null;
        final String BD_URL = "jdbc:mysql://localhost/ExamenRecuperacion";
        final String Username = "root";
        final String PASSWORD = "";
        try {
            Connection con = DriverManager.getConnection(BD_URL, Username, PASSWORD);
            Statement stmt = con.createStatement();
            String sql = "select usuario from usuarios where usuario=? and password=? ";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, user);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                usuario = new Usuario();
                usuario.Usuario = resultSet.getString("usuario");
                usuario.Password = resultSet.getString("password");
            }
            stmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return usuario;
    }
}
