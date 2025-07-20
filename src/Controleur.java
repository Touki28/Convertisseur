package src;

import src.ihm.Frame;
import src.metier.Convertisseur;

public class Controleur
{
	private Frame ihm;

	public Controleur()
	{
		this.ihm = new Frame ( this );
	}

	/* Accesseurs */
	public static String[] getDevises           ( String nom ) { return Convertisseur.getDevises          ( nom ) ; }
	public static String[] getLibConvertisseurs ()             { return Convertisseur.getLibConvertisseurs()      ; }
	public static String[] getLog               ()             { return Convertisseur.getLog              ()      ; }

	public static double calculer ( String type, String uniteSrc, String uniteDst, double valeur )
	{
		return Convertisseur.calculer( type,  uniteSrc, uniteDst, valeur );
	}

	public void ajouterLog( String entrer, String sortie, String resultat )
	{
		Convertisseur.ajouterLog( entrer, sortie, resultat );
		this.ihm.majPanelLog();
	}

	public void supprimerLog()
	{
		Convertisseur.supprimerLog();
		this.ihm.majPanelLog();
	}

	public void panelConvertisseur( String panel ) { this.ihm.afficherPanel( panel ) ; }

	public static void main( String[] args )
	{
		new Controleur();
	}
}