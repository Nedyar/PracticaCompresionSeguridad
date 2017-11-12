package Pruebas;


import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Ventana de Inicio del programa
 * 
 * @author Nedyar
 */
public class VentanaExaminar {

	private JFrame frame;
	private JTextField txtRuta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaExaminar window = new VentanaExaminar();
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
	public VentanaExaminar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 340, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 87, 87, 87, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		frame.getContentPane().setLayout(gridBagLayout);

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
				FileNameExtensionFilter filtro = new FileNameExtensionFilter("Texto (*.txt)", "txt");

				// Le indicamos el filtro
				fc.setFileFilter(filtro);

				// Abrimos la ventana, guardamos la opcion seleccionada por el usuario
				int seleccion = fc.showOpenDialog(frame);

				// Si el usuario, pincha en aceptar
				if (seleccion == JFileChooser.APPROVE_OPTION) {
					// Seleccionamos el fichero
					File[] ficheros = fc.getSelectedFiles();
					txtRuta.setText(ficheros[0].getPath());
				} else {
					System.out.println("Selección de archivo cancelada");
				}
			}
		});
		JLabel lblPrueba = new JLabel("prueba");
		GridBagConstraints gbc_lblPrueba = new GridBagConstraints();
		gbc_lblPrueba.anchor = GridBagConstraints.NORTH;
		gbc_lblPrueba.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblPrueba.insets = new Insets(0, 0, 5, 0);
		gbc_lblPrueba.gridx = 0;
		gbc_lblPrueba.gridy = 0;
		frame.getContentPane().add(lblPrueba, gbc_lblPrueba);

		txtRuta = new JTextField();
		txtRuta.setHorizontalAlignment(SwingConstants.LEFT);
		txtRuta.setEditable(false);
		txtRuta.setText("ruta");
		GridBagConstraints gbc_txtRuta = new GridBagConstraints();
		gbc_txtRuta.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtRuta.anchor = GridBagConstraints.WEST;
		gbc_txtRuta.insets = new Insets(0, 0, 5, 0);
		gbc_txtRuta.gridx = 0;
		gbc_txtRuta.gridy = 1;
		frame.getContentPane().add(txtRuta, gbc_txtRuta);
		txtRuta.setColumns(10);

		GridBagConstraints gbc_btnExaminar = new GridBagConstraints();
		gbc_btnExaminar.anchor = GridBagConstraints.EAST;
		gbc_btnExaminar.gridx = 1;
		gbc_btnExaminar.gridy = 1;
		frame.getContentPane().add(btnExaminar, gbc_btnExaminar);
	}

}
