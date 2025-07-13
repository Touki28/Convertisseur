package src.ihm;

import src.Controleur;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.*;

public class PanelMenu extends JPanel implements ActionListener
{
	private Controleur ctrl;
	
	private JList      lstChoix;
	private JButton    btnChoix;

	public PanelMenu( Controleur ctrl )
	{
		JScrollPane spChoix;
		JPanel      panelTmp, panelBtn;

		this.ctrl = ctrl;

		/*-------------------------------*/
		/* Création des composants       */
		/*-------------------------------*/

		this.lstChoix = new JList<>    ( Controleur.getLibellerPanels() );
		this.lstChoix.setSelectedIndex( 0 );
		
		spChoix       = new JScrollPane( this.lstChoix );
		spChoix.setPreferredSize( new Dimension( 200, 100 ) );

		this.btnChoix = new JButton( "Confirmation" );
		
		/*-------------------------------*/
		/* Positionnement des composants */
		/*-------------------------------*/
		panelTmp = new JPanel();
		panelTmp.setLayout( new BorderLayout() );

		panelBtn = new JPanel();
		panelBtn.add( this.btnChoix );

		panelTmp.add( spChoix , BorderLayout.CENTER );
		panelTmp.add( panelBtn, BorderLayout.SOUTH  );

		this.add( panelTmp );
		/*-------------------------------*/
		/* Activation des composants     */
		/*-------------------------------*/

		this.btnChoix.addActionListener( this );
	}

	public void actionPerformed( ActionEvent e )
	{
		if ( e.getSource() == this.btnChoix )
		{
			this.ctrl.panelConvertisseur( (String)this.lstChoix.getSelectedValue() );
		}
	}
}
