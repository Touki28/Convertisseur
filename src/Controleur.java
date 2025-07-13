package src;

import src.ihm.Frame;
import src.metier.Convertisseur;

public class Controleur
{
	private Convertisseur metier;
	private Frame         ihm;

	public Controleur()
	{
		this.metier = new Convertisseur();
		this.ihm    = new Frame        ( this );
	}

	/* Accesseurs */
	public static String[] getDevises       ( String nom ){ return Convertisseur.getDevises       ( nom ) ; }
	public static String[] getCategories    ( String nom ){ return Convertisseur.getCategories    ( nom ) ; }
	public static String[] getLibellerPanels()            { return Frame        .getLibellerPanels()      ; }

	public void panelConvertisseur( String panel ){ this.ihm.afficherPanel( panel ) ; }

	public double calculer( String type, double valeur ){ return this.metier.calculer( type, valeur ) ; }

	public static void main( String[] args )
	{
		new Controleur();
	}
}