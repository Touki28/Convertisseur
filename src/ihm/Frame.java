package src.ihm;

import src.Controleur;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

public class Frame extends JFrame
{
	private JPanel               panelPrincipale;
	
	private PanelMenu            panelMenu;
	private PanelLog             panelLog;
	
	private PanelConvertisseur[] ensPanelConvertisseur;

	public Frame( Controleur ctrl )
	{
		this.setTitle   ( "Convertisseur" );
		this.setSize    ( 1000, 500       );
		this.setLocation(   20,  20       );

		this.setLayout( new BorderLayout() );

		/*-------------------------------*/
		/* Création des composants       */
		/*-------------------------------*/
		this.panelPrincipale  = new JPanel( new GridLayout( 3, 1 ) );

		this.panelMenu = new PanelMenu ( ctrl );
		this.panelLog  = new PanelLog  ( ctrl );

		this.ensPanelConvertisseur = new PanelConvertisseur[Controleur.getLibConvertisseurs().length];
		for ( int cpt = 0; cpt < this.ensPanelConvertisseur.length; cpt++ )
			this.ensPanelConvertisseur[cpt] = new PanelConvertisseur( ctrl, Controleur.getLibConvertisseurs()[cpt] );
			

		/*-------------------------------*/
		/* Positionnement des composants */
		/*-------------------------------*/
		this.panelPrincipale.add( new JPanel()   );
		this.panelPrincipale.add( this.panelMenu );

		this.add( this.panelPrincipale, BorderLayout.CENTER );
		this.add( this.panelLog       , BorderLayout.EAST   );

		this.setVisible( true );
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}

	public void afficherPanel( String panel )
	{
		// Reset le contenue du panelPrincipale
		this.panelPrincipale.removeAll();

		this.panelPrincipale.setLayout( new FlowLayout() );

		for ( int cpt = 0; cpt < Controleur.getLibConvertisseurs().length; cpt++ )
		{
			if ( panel.equals( Controleur.getLibConvertisseurs()[cpt] ) )
			{
				this.panelPrincipale.add( this.ensPanelConvertisseur[cpt] );
				this.majPanelPrincipal();
				return;
			}
		}

		this.panelPrincipale.setLayout( new GridLayout( 3, 1 ) );
		this.panelPrincipale.add      ( new JPanel    ()       );
		this.panelPrincipale.add      ( this.panelMenu         );

		this.majPanelPrincipal();
	}

	// Met a jour le panelPrincipale
	public void majPanelPrincipal()
	{
		this.panelPrincipale.revalidate();
		this.panelPrincipale.repaint   ();
	}

	public void majPanelLog()
	{
		this.panelLog.majPanelLog();
		
		this.panelLog.revalidate();
		this.panelLog.repaint   ();
	}
}
