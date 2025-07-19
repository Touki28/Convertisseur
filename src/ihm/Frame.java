package src.ihm;

import src.Controleur;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

public class Frame extends JFrame
{
	private JPanel             panelPrincipale;
	
	private PanelMenu          panelMenu;
	private PanelLog           panelLog;
	
	private PanelConvertisseur panelMonnaie;
	private PanelConvertisseur panelDistance;
	private PanelConvertisseur panelTemperature;
	private PanelConvertisseur panelVitesse;

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

		this.panelMenu        = new PanelMenu          ( ctrl                                                                 );
		this.panelLog         = new PanelLog           ( ctrl                                                                 );

		this.panelMonnaie     = new PanelConvertisseur ( ctrl, "Euro &lt;=&gt; Francs"                        , "Monnaie"     );
		this.panelDistance    = new PanelConvertisseur ( ctrl, "Miles &lt;=&gt; KiloMètre"                    , "Distance"    );
		this.panelTemperature = new PanelConvertisseur ( ctrl, "Celsius &lt;=&gt; Fahrenheit &lt;=&gt; Kelvin", "Temperature" );
		this.panelVitesse     = new PanelConvertisseur ( ctrl, "Km/h &lt;=&gt; m/s &lt;=&gt; Noeuds"          , "Vitesse"     );

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

		switch ( panel ) //Place le bon panel suivant l'option demandée
		{
			case "Monnaie"     ->{ this.panelPrincipale.add( this.panelMonnaie     ) ; }
			case "Distance"    ->{ this.panelPrincipale.add( this.panelDistance    ) ; }
			case "Temperature" ->{ this.panelPrincipale.add( this.panelTemperature ) ; }
			case "Vitesse"     ->{ this.panelPrincipale.add( this.panelVitesse     ) ; }

			case "Menu"        ->
			{
				this.panelPrincipale.setLayout( new GridLayout( 3, 1 ) );
				this.panelPrincipale.add      ( new JPanel    ()       );
				this.panelPrincipale.add      ( this.panelMenu         );
			}
		}
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
