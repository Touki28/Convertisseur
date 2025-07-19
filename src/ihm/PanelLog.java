package src.ihm;

import src.Controleur;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.event.*;

public class PanelLog extends JPanel implements ActionListener
{
	private Controleur ctrl;

	private JTextArea  txtLog;
	private JButton    btnEffacer;
	
	public PanelLog( Controleur ctrl )
	{
		JScrollPane spLog;
		JPanel      panelTmp;

		this.ctrl = ctrl;
		
		this.setLayout( new BorderLayout() );
		/*-------------------------------*/
		/* Création des composants       */
		/*-------------------------------*/
		this.txtLog = new JTextArea();
		this.txtLog.setEditable( false );

		this.majPanelLog(); //Rempli le JTextArea si besoin

		spLog = new JScrollPane( this.txtLog );

		this.btnEffacer = new JButton( "Effacer" );

		/*-------------------------------*/
		/* Positionnement des composants */
		/*-------------------------------*/
		panelTmp = new JPanel();
		panelTmp.add( new JLabel( "<html><h1>Logs du convertisseur</h1></html>") );

		this.add( panelTmp, BorderLayout.NORTH  );

		panelTmp = new JPanel();
		panelTmp.add( this.btnEffacer );

		
		this.add( spLog   , BorderLayout.CENTER );
		this.add( panelTmp, BorderLayout.SOUTH  );

		/*-------------------------------*/
		/* Activation des composants     */
		/*-------------------------------*/

		this.btnEffacer.addActionListener( this );

	}

	public void actionPerformed ( ActionEvent e )
	{
		if ( e.getSource() == this.btnEffacer )
		{
			this.ctrl.supprimerLog();
		}
	}

	public void majPanelLog()
	{
		this.txtLog.setText(""); //Vide

		for ( String s : Controleur.getLog() )
		{
			this.txtLog.append( s + "\n" );
		}
	}
}
