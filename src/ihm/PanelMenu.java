package src.ihm;

import src.Controleur;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.*;

public class PanelMenu extends JPanel implements ActionListener
{
	private Controleur ctrl;
	
	private JList<String> lstChoix;
	private JButton       btnConfirmer;

	public PanelMenu( Controleur ctrl )
	{
		JScrollPane spChoix;
		JPanel      panelTmp, panelBtn;

		this.ctrl = ctrl;

		/*-------------------------------*/
		/* Création des composants       */
		/*-------------------------------*/

		this.lstChoix = new JList<>( Controleur.getLibConvertisseurs() );
		this.lstChoix.setSelectedIndex( 0 );
		
		spChoix       = new JScrollPane( this.lstChoix );
		spChoix.setPreferredSize( new Dimension( 200, 100 ) );

		this.btnConfirmer = new JButton( "Confirmation" );
		
		/*-------------------------------*/
		/* Positionnement des composants */
		/*-------------------------------*/
		
		panelTmp = new JPanel();
		panelTmp.setLayout( new BorderLayout() );

		panelBtn = new JPanel();
		panelBtn.add( this.btnConfirmer );

		panelTmp.add( spChoix , BorderLayout.CENTER );
		panelTmp.add( panelBtn, BorderLayout.SOUTH  );

		this.add( panelTmp );

		/*-------------------------------*/
		/* Activation des composants     */
		/*-------------------------------*/

		this.btnConfirmer.addActionListener( this );
	}

	public void actionPerformed( ActionEvent e )
	{
		if ( e.getSource() == this.btnConfirmer )
		{
			this.ctrl.panelConvertisseur( this.lstChoix.getSelectedValue() );
		}
	}
}
