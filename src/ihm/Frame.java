package src.ihm;

import src.Controleur;

import javax.swing.*;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import java.lang.reflect.Field;

public class Frame extends JFrame
{
	private JPanel             panelPrincipale;
	
	private PanelMenu          panelMenu;
	private PanelConvertisseur panelArgent;
	private PanelConvertisseur panelDistance;
	private PanelConvertisseur panelTemperature;
	private PanelConvertisseur panelVitesse;

	public Frame( Controleur ctrl )
	{
		this.setTitle   ( "Convertisseur" );
		this.setSize    ( 750, 500        );
		this.setLocation(  20,  20        );

		/*-------------------------------*/
		/* Création des composants       */
		/*-------------------------------*/
		this.panelPrincipale  = new JPanel( new GridLayout( 3, 1 ) );

		this.panelMenu        = new PanelMenu          ( ctrl                                                                 );
		this.panelArgent      = new PanelConvertisseur ( ctrl, "Euro &lt;=&gt; Francs"                        , "Argent"      );
		this.panelDistance    = new PanelConvertisseur ( ctrl, "Miles &lt;=&gt; KiloMètre"                    , "Distance"    );
		this.panelTemperature = new PanelConvertisseur ( ctrl, "Celsius &lt;=&gt; Fahrenheit &lt;=&gt; Kelvin", "Temperature" );
		this.panelVitesse     = new PanelConvertisseur ( ctrl, "Km/h &lt;=&gt; m/s &lt;=&gt; Noeuds"          , "Vitesse"     );

		/*-------------------------------*/
		/* Positionnement des composants */
		/*-------------------------------*/
		this.panelPrincipale.add( new JPanel()   );
		this.panelPrincipale.add( this.panelMenu );

		this.add( this.panelPrincipale );

		this.setVisible( true );
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}

	public String[] getLibellerPanels()
	{
		Field [] fields = Frame.class.getDeclaredFields();
		String[] sRet   = new String[fields.length];

		for ( int cpt = 0; cpt < sRet.length; cpt++ )
			if ( fields[cpt].getName() != "panelPrincipale" && fields[cpt].getName() != "panelMenu" )
				sRet[cpt] = fields[cpt].getName();

		return sRet;
	}

	public void panelConvertisseur( String panel )
	{
		// Reset le contenue du panelPrincipale
		this.panelPrincipale.removeAll();

		this.panelPrincipale.setLayout( new FlowLayout() );

		switch ( panel ) //Place le bon panel suivant l'option demandée
		{
			case "Argent"      ->{ this.panelPrincipale.add( this.panelArgent      ) ; }
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
		this.majContenue();
	}

	// Met a jour le panelPrincipale
	public void majContenue()
	{
		this.panelPrincipale.revalidate();
		this.panelPrincipale.repaint   ();
	}
}
