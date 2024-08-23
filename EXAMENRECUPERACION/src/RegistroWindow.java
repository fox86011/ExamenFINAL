import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistroWindow extends JDialog {
    private JTextField txt_Estudiante;
    private JTextField txt_materia;
    private JTextField txt_calificacion;
    private JButton registrarButton;
    private JPanel Registro;
    public RegistroWindow(JFrame parent) {
        super(parent);
        setTitle("REGISTRO");
        setContentPane(Registro);
        setMinimumSize(new Dimension(450, 474));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        setVisible(true);
    }

}


}
