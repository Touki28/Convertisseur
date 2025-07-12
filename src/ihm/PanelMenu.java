package src.ihm;

import src.Controleur;

import javax.swing.*;

import java.awt.GridLayout;
import java.awt.event.*;

public class PanelMenu extends JPanel implements ActionListener
{
	private Controleur ctrl;
	
	private JButton    btnArgent;
	private JButton    btnDistance;
	private JButton    btnTemperature;
	private JButton    btnVitesse;

	public PanelMenu( Controleur ctrl )
	{
		this.ctrl = ctrl;
		
		this.setLayout( new GridLayout( 1, 4, 10, 10 ) );
		
		/*-------------------------------*/
		/* Création des composants       */
		/*-------------------------------*/
		
		this.btnArgent      = new JButton( "Argent"      );
		this.btnDistance    = new JButton( "Distance"    );
		this.btnTemperature = new JButton( "Temperature" );
		this.btnVitesse     = new JButton( "Vitesse"     );
		
		/*-------------------------------*/
		/* Positionnement des composants */
		/*-------------------------------*/
		
		this.positionnementPanels( this.btnArgent       );
		this.positionnementPanels( this.btnDistance     );
		this.positionnementPanels( this.btnTemperature  );
		this.positionnementPanels( this.btnVitesse      );

		/*-------------------------------*/
		/* Activation des composants     */
		/*-------------------------------*/
		this.btnArgent     .addActionListener( this );
		this.btnDistance   .addActionListener( this );
		this.btnTemperature.addActionListener( this );
		this.btnVitesse    .addActionListener( this );
	}

	private void positionnementPanels( JButton b )
	{
		JPanel panelTmp;

		panelTmp = new JPanel( new GridLayout( 3, 1 ) );
		panelTmp.add( new JPanel() );
		panelTmp.add( b );

		this.add( panelTmp );
	}

	public void actionPerformed( ActionEvent e )
	{
		if ( e.getSource() == this.btnArgent      ) this.ctrl.panelConvertisseur( "Argent"      );
		if ( e.getSource() == this.btnDistance    ) this.ctrl.panelConvertisseur( "Distance"    );
		if ( e.getSource() == this.btnTemperature ) this.ctrl.panelConvertisseur( "Temperature" );
		if ( e.getSource() == this.btnVitesse     ) this.ctrl.panelConvertisseur( "Vitesse"     );
	}
}
