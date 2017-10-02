import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.BorderLayout;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

/**
 * @author Nedyar
 */
public class Main {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton btnExaminar = new JButton("Examinar...");

		btnExaminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// Creamos el objeto JFileChooser
				JFileChooser fc = new JFileChooser();

				// Indicamos que podemos seleccionar varios ficheros
				fc.setMultiSelectionEnabled(true);

				// Indicamos lo que podemos seleccionar
				fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

				// Creamos el filtro
				FileNameExtensionFilter filtro = new FileNameExtensionFilter("*Texto", "txt");

				// Le indicamos el filtro
				fc.setFileFilter(filtro);

				// Abrimos la ventana, guardamos la opcion seleccionada por el usuario
				int seleccion = fc.showOpenDialog(frame);

				// Si el usuario, pincha en aceptar
				if (seleccion == JFileChooser.APPROVE_OPTION) {

					// Seleccionamos el fichero
					File[] ficheros = fc.getSelectedFiles();
				}
			}
		});

		frame.getContentPane().add(btnExaminar, BorderLayout.SOUTH);
	}

}
