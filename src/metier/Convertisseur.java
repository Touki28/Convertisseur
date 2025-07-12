package src.metier;

public class Convertisseur
{
	private static final String[] CATEGORIES_DISTANCE = new String[] { "Nautique", "Terrestre"            };
	
	private static final String[] DEVISES_MONNAIE     = new String[] { "Euro"    , "Franc"                };
	private static final String[] DEVISES_DISTANCE    = new String[] { "Miles"   , "KiloMètre"            };
	private static final String[] DEVISES_TEMPERATURE = new String[] { "Celsius" , "Fahrenheit", "Kelvin" };
	private static final String[] DEVISES_VITESSE     = new String[] { "Km/h"    , "m/s"       , "Noeuds" };

	public static String[] getDevises( String nom )
	{
		switch ( nom )
		{
			case "Argent"      ->{ return Convertisseur.DEVISES_MONNAIE     ; }
			case "Distance"    ->{ return Convertisseur.DEVISES_DISTANCE    ; }
			case "Temperature" ->{ return Convertisseur.DEVISES_TEMPERATURE ; }
			case "Vitesse"     ->{ return Convertisseur.DEVISES_VITESSE     ; }

			default            ->{ return null                              ; }
		}
	}

	public static String[] getCategories( String nom )
	{
		switch ( nom )
		{
			case "Distance"    ->{ return Convertisseur.CATEGORIES_DISTANCE ; }

			default            ->{ return null                              ; }
		}
	}

	public double calculer( String type, double valeur )
	{
		double resultat = 0.0;

		switch ( type )
		{
			case "Euro->Franc"                ->{ resultat =     valeur * 6.55957               ; }
			case "Franc->Euro"                ->{ resultat =     valeur / 6.55957               ; }

			case "Nautique|KiloMètre->Miles"  ->{ resultat =     valeur * 0.539957              ; }
			case "Nautique|Miles->KiloMètre"  ->{ resultat =     valeur / 0.539957              ; }
			case "Terrestre|KiloMètre->Miles" ->{ resultat =     valeur * 0.621371              ; }
			case "Terrestre|Miles->KiloMètre" ->{ resultat =     valeur / 0.621371              ; }

			case "Celsius->Fahrenheit"        ->{ resultat = (   valeur * 1.8 ) + 32            ; }
			case "Celsius->Kelvin"            ->{ resultat =     valeur + 273.15                ; }
			case "Fahrenheit->Celsius"        ->{ resultat = (   valeur - 32 ) / 1.8            ; }
			case "Fahrenheit->Kelvin"         ->{ resultat = ( ( valeur - 32 ) / 1.8 ) + 273.15 ; }
			case "Kelvin->Celsius"            ->{ resultat =     valeur - 273.15                ; }
			case "Kelvin->Fahrenheit"         ->{ resultat = ( ( valeur - 273.15 ) * 1.8 ) + 32 ; }

			case "Km/h->m/s"                  ->{ resultat =     valeur / 3.6                   ; }
			case "Km/h->Noeuds"               ->{ resultat =     valeur / 1.852                 ; }
			case "m/s->Km/h"                  ->{ resultat =     valeur * 3.6                   ; }
			case "m/s->Noeuds"                ->{ resultat =     valeur * 1.94384               ; }
			case "Noeuds->Km/h"               ->{ resultat =     valeur * 1.852                 ; }
			case "Noeuds->m/s"                ->{ resultat =     valeur / 1.94384               ; }
		}

		return resultat;
	}
}
