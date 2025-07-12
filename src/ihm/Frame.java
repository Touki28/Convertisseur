package src.ihm;

import src.Controleur;

import javax.swing.*;

import java.awt.FlowLayout;
import java.awt.GridLayout;

public class Frame extends JFrame
{
	private JPanel             panelContenue;
	
	private PanelMenu          panelMenu;
	private PanelConvertisseur panelArgent;
	private PanelConvertisseur panelDistance;
	private PanelConvertisseur panelTemperature;
	private PanelConvertisseur panelVitesse;

	public Frame( Controleur ctrl )
	{
		this.setTitle   ("Convertisseur");
		this.setSize    ( 750, 500 );
		this.setLocation(  20,  20 );

		/*-------------------------------*/
		/* Création des composants       */
		/*-------------------------------*/
		this.panelContenue = new JPanel( new GridLayout( 3, 1 ) );

		this.panelMenu        = new PanelMenu          ( ctrl );
		this.panelArgent      = new PanelConvertisseur ( ctrl, "Euro &lt;=&gt; Francs", "Argent" );
		this.panelDistance    = new PanelConvertisseur ( ctrl, "Miles &lt;=&gt; KiloMètre", "Distance", true );
		this.panelTemperature = new PanelConvertisseur ( ctrl, "Celsius &lt;=&gt; Fahrenheit &lt;=&gt; Kelvin", "Temperature" );
		this.panelVitesse     = new PanelConvertisseur ( ctrl, "Km/h &lt;=&gt; m/s &lt;=&gt; Noeuds", "Vitesse" );

		/*-------------------------------*/
		/* Positionnement des composants */
		/*-------------------------------*/
		this.panelContenue.add( new JPanel()   );
		this.panelContenue.add( this.panelMenu );

		this.add( this.panelContenue );

		this.setVisible( true );
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}

	public void panelConvertisseur( String panel )
	{
		this.panelContenue.removeAll();

		this.panelContenue.setLayout( new FlowLayout() );

		switch ( panel )
		{
			case "Argent"      ->{ this.panelContenue.add( this.panelArgent      ) ; }
			case "Distance"    ->{ this.panelContenue.add( this.panelDistance    ) ; }
			case "Temperature" ->{ this.panelContenue.add( this.panelTemperature ) ; }
			case "Vitesse"     ->{ this.panelContenue.add( this.panelVitesse     ) ; }

			case "Menu"        ->
			{
				this.panelContenue.setLayout( new GridLayout( 3, 1 ) );
				this.panelContenue.add( new JPanel()   );
				this.panelContenue.add( this.panelMenu );
			}
		}
		this.majContenue();
	}

	public void majContenue()
	{
		this.panelContenue.revalidate();
		this.panelContenue.repaint   ();
	}
}
