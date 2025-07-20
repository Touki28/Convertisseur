package src.metier;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;

public class Convertisseur
{

	private static final String[] DEVISES_AIRE = new String[]
	{
		"Kilomètre carré",
		"Mètre carré",
		"Mille carré",
		"Yard carré",
		"Pied carré",
		"Pouce carré",
		"Hectare",
		"Acre anglo-saxonne"
	};

	private static final String[] DEVISES_ANGLE_PLAN = new String[]
	{
		"Degré",
		"Grade",
		"Mil angulaire",
		"Minute d'arc",
		"Radian",
		"Seconde d'arc"
	};

	private static final String[] DEVISES_CONSOMMATION_DE_CARBURANT = new String[]
	{
		"Mille par gallon américain",
		"Mille par gallon impérial",
		"Kilomètre par litre",
		"Litre aux 100 kilomètres"
	};

	private static final String[] DEVISES_DEBIT_BINAIRE = new String[]
	{
		"Bit par seconde",
		"Kilobit par seconde",
		"Kilobyte par seconde",
		"Kibibyte par seconde",
		"Mégabit par seconde",
		"Mégabyte par seconde",
		"Mébibit par seconde",
		"Gigabit par seconde",
		"Gigabyte par seconde",
		"Gibibit par seconde",
		"Térabit par seconde",
		"Térabyte par seconde",
		"Térabibit par seconde"
	};

	private static final String[] DEVISES_FREQUENCE = new String[]
	{
		"Hertz",
		"Kilohertz",
		"Mégahertz",
		"Gigahertz"
	};

	private static final String[] DEVISES_LONGUEUR = new String[]
	{
		"Kilomètre",
		"Mètre",
		"Centimètre",
		"Millimètre",
		"Micromètre",
		"Nanomètre",
		"Mile",
		"Yard",
		"Pied",
		"Pouce",
		"Mille Marin"
	};

	private static final String[] DEVISES_MASSE = new String[]
	{
		"Tonne",
		"Kilogramme",
		"Gramme",
		"Milligramme",
		"Microgramme",
		"Tonne longue",
		"Tonne courte",
		"Stone",
		"Livre",
		"Once"
	};

	private static final String[] DEVISES_PRESSION = new String[]
	{
		"Atmosphère",
		"Bar",
		"Pascal",
		"Psi",
		"Torr"
	};

	private static final String[] DEVISES_TAILLE_DE_DONNEES = new String[]
	{
		"Bit",
		"Kilobit",
		"Kibibit",
		"Mégabit",
		"Mébibit",
		"Gigabit",
		"Gibibit",
		"Térabit",
		"Tébibit",
		"Pétabit",
		"Pébibit",
		"Octet",
		"Kilobyte",
		"Kibibyte",
		"Mégabyte",
		"Mébibyte",
		"Gigabyte",
		"Gibibyte",
		"Térabyte",
		"Tebibyte",
		"Petabyte",
		"Pebibyte"
	};

	private static final String[] DEVISES_TEMPS = new String[]
	{
		"Nanoseconde",
		"Microseconde",
		"Milliseconde",
		"Seconde",
		"Minute",
		"Heure",
		"Jour",
		"Semaine",
		"Mois",
		"Année",
		"Décennie",
		"Siècle"
	};

	private static final String[] DEVISES_TEMPERATURE = new String[]
	{
		"Degré Celsius",
		"Degré Fahrenheit",
		"Kelvin"
	};

	private static final String[] DEVISES_VITESSE = new String[]
	{
		"Mille par heure",
		"Pied par seconde",
		"Mètre par seconde",
		"Kilomètre par heure",
		"Noeud"
	};

	private static final String[] DEVISES_VOLUME = new String[]
	{
		"Gallon américain",
		"Quart américain",
		"Pinte américaine liquide",
		"Tasse américaine",
		"Once liquide américaine",
		"Cuillère à soupe américaine",
		"Cuillère à café américaine",
		"Mètre cube",
		"Litre",
		"Millilitre",
		"Gallon impérial",
		"Quart impérial",
		"Pinte impériale",
		"Tasse impériale",
		"Once liquide impériale",
		"Cuillère à soupe impériale",
		"Cuillère à café impériale",
		"Pied cube",
		"Pouce cube"
	};

	private static final String[] DEVISES_ENERGIE = new String[]
	{
		"Joule",
		"Kilojoule",
		"Petite calorie",
		"Kilocalorie",
		"Watt-heure",
		"Kilowatt-heure",
		"Électronvolt",
		"British Thermal Unit",
		"Therm américain",
		"Pied-livre"
	};

	private static File fichier = new File( "./log.data" );

	//Classe utilitaire – instanciation interdite
	private Convertisseur(){} 

	public static String[] getLibConvertisseurs()
	{
		return new String[]
		{
			"Aire",
			"Angle plan",
			"Consommation de carburant",
			"Débit binaire",
			"Fréquence",
			"Longueur",
			"Masse",
			"Pression",
			"Taille de données",
			"Temps",
			"Température",
			"Vitesse",
			"Volume",
			"Énergie"
		};
	}

	public static String[] getDevises( String nom )
	{
		switch ( nom )
		{
			case "Aire"                      ->{ return Convertisseur.DEVISES_AIRE                      ; }
			case "Angle plan"                ->{ return Convertisseur.DEVISES_ANGLE_PLAN                ; }
			case "Consommation de carburant" ->{ return Convertisseur.DEVISES_CONSOMMATION_DE_CARBURANT ; }
			case "Débit binaire"             ->{ return Convertisseur.DEVISES_DEBIT_BINAIRE             ; }
			case "Fréquence"                 ->{ return Convertisseur.DEVISES_FREQUENCE                 ; }
			case "Longueur"                  ->{ return Convertisseur.DEVISES_LONGUEUR                  ; }
			case "Masse"                     ->{ return Convertisseur.DEVISES_MASSE                     ; }
			case "Pression"                  ->{ return Convertisseur.DEVISES_PRESSION                  ; }
			case "Taille de données"         ->{ return Convertisseur.DEVISES_TAILLE_DE_DONNEES         ; }
			case "Temps"                     ->{ return Convertisseur.DEVISES_TEMPS                     ; }
			case "Température"               ->{ return Convertisseur.DEVISES_TEMPERATURE               ; }
			case "Vitesse"                   ->{ return Convertisseur.DEVISES_VITESSE                   ; }
			case "Volume"                    ->{ return Convertisseur.DEVISES_VOLUME                    ; }
			case "Énergie"                   ->{ return Convertisseur.DEVISES_ENERGIE                   ; }

			default                          ->{ return new String[] { "ex1", "ex2" }                   ; }
		}
	}

	/* Perfermet de faire les opérations et de renvoyer un résultat */
	public static double calculer( String type, String uniteSrc, String uniteDst, double valeur )
	{
		// Traitement spécifique de la consommation de carburant
		if ( type.equals( "Consommation de carburant" ) ) 
		{
			// Conversion en km/L
			double kmParLitre = switch ( uniteSrc )
			{
				case "Litre aux 100 kilomètres"   -> 100.0 / valeur;
				case "Mille par gallon américain" -> valeur * 1.609344 / 3.785411784;
				case "Mille par gallon impérial"  -> valeur * 1.609344 / 4.54609;
				case "Kilomètre par litre"        -> valeur;
				default                           -> throw new IllegalArgumentException( "Unité source non reconnue" );
			};

			return switch ( uniteDst )
			{
				case "Litre aux 100 kilomètres"   -> 100.0 / kmParLitre;
				case "Mille par gallon américain" -> kmParLitre * 3.785411784 / 1.609344;
				case "Mille par gallon impérial"  -> kmParLitre * 4.54609 / 1.609344;
				case "Kilomètre par litre"        -> kmParLitre;
				default                           -> throw new IllegalArgumentException( "Unité destination non reconnue" );
			};
		}
		else if ( type.equals( "Température" ) ) // Traitement spécifique de la température
		{
			double celsius = switch ( uniteSrc )
			{
				case "Degré Fahrenheit" -> ( valeur - 32 ) * 5 / 9;
				case "Kelvin"           ->   valeur - 273.15;
				case "Degré Celsius"    ->   valeur;
				default                 -> throw new IllegalArgumentException( "Unité source non reconnue" );
			};

			return switch ( uniteDst )
			{
				case "Degré Fahrenheit" -> celsius * 9 / 5 + 32;
				case "Kelvin"           -> celsius + 273.15;
				case "Degré Celsius"    -> celsius;
				default                 -> throw new IllegalArgumentException( "Unité destination non reconnue" );
			};
		}
		else
		{
			// Tableaux de conversion vers l'unité pivot pour chaque type
			Map<String, Double> map = new HashMap<>();

			switch ( type )
			{
				case "Aire" -> map = Map.ofEntries
				(
					Map.entry( "Kilomètre carré"   , 1e6            ),
					Map.entry( "Mètre carré"       , 1.0            ),
					Map.entry( "Mille carré"       , 2589988.110336 ),
					Map.entry( "Yard carré"        , 0.83612736     ),
					Map.entry( "Pied carré"        , 0.09290304     ),
					Map.entry( "Pouce carré"       , 0.00064516     ),
					Map.entry( "Hectare"           , 10000.0        ),
					Map.entry( "Acre anglo-saxonne", 4046.8564224   )
				);
				case "Angle plan" -> map = Map.ofEntries
				(
					Map.entry( "Radian"       , 1.0                      ),
					Map.entry( "Degré"        , Math.PI / 180            ),
					Map.entry( "Grade"        , Math.PI / 200            ),
					Map.entry( "Mil angulaire", Math.PI / 3200           ),
					Map.entry( "Minute d'arc" , Math.PI / ( 180 * 60   ) ),
					Map.entry( "Seconde d'arc", Math.PI / ( 180 * 3600 ) )
				);
				case "Débit binaire" -> map = Map.ofEntries
				(
					Map.entry( "Bit par seconde"      , 1.0            ),
					Map.entry( "Kilobit par seconde"  , 1e3            ),
					Map.entry( "Kilobyte par seconde" , 8e3            ),
					Map.entry( "Kibibyte par seconde" , 8192.0         ),
					Map.entry( "Mégabit par seconde"  , 1e6            ),
					Map.entry( "Mégabyte par seconde" , 8e6            ),
					Map.entry( "Mébibit par seconde"  , 1.048576e6     ),
					Map.entry( "Gigabit par seconde"  , 1e9            ),
					Map.entry( "Gigabyte par seconde" , 8e9            ),
					Map.entry( "Gibibit par seconde"  , 1.073741824e9  ),
					Map.entry( "Térabit par seconde"  , 1e12           ),
					Map.entry( "Térabyte par seconde" , 8e12           ),
					Map.entry( "Tébibit par seconde"  , 1.099511628e12 )
				);
				case "Fréquence" -> map = Map.ofEntries
				(
					Map.entry( "Hertz"    , 1.0 ),
					Map.entry( "Kilohertz", 1e3 ),
					Map.entry( "Mégahertz", 1e6 ),
					Map.entry( "Gigahertz", 1e9 )
				);
				case "Longueur" -> map = Map.ofEntries
				(
					Map.entry( "Kilomètre"  , 1000.0   ),
					Map.entry( "Mètre"      , 1.0      ),
					Map.entry( "Centimètre" , 0.01     ),
					Map.entry( "Millimètre" , 0.001    ),
					Map.entry( "Micromètre" , 1e-6     ),
					Map.entry( "Nanomètre"  , 1e-9     ),
					Map.entry( "Mile"       , 1609.344 ),
					Map.entry( "Yard"       , 0.9144   ),
					Map.entry( "Pied"       , 0.3048   ),
					Map.entry( "Pouce"      , 0.0254   ),
					Map.entry( "Mille Marin", 1852.0   )
				);
				case "Masse" -> map = Map.ofEntries
				(
					Map.entry( "Tonne"       , 1000.0         ),
					Map.entry( "Kilogramme"  , 1.0            ),
					Map.entry( "Gramme"      , 0.001          ),
					Map.entry( "Milligramme" , 1e-6           ),
					Map.entry( "Microgramme" , 1e-9           ),
					Map.entry( "Tonne longue", 1016.0469088   ),
					Map.entry( "Tonne courte", 907.18474      ),
					Map.entry( "Stone"       , 6.35029318     ),
					Map.entry( "Livre"       , 0.45359237     ),
					Map.entry( "Once"        , 0.028349523125 )
				);
				case "Pression" -> map = Map.ofEntries
				(
					Map.entry( "Pascal"    , 1.0      ),
					Map.entry( "Bar"       , 1e5      ),
					Map.entry( "Atmosphère", 101325.0 ),
					Map.entry( "Psi"       , 6894.76  ),
					Map.entry( "Torr"      , 133.322  )
				);
				case "Taille de données" -> map = Map.ofEntries
				(
					Map.entry( "Bit"     , 1.0                  ),
					Map.entry( "Kilobit" , 1e3                  ),
					Map.entry( "Kibibit" , 1024.0               ),
					Map.entry( "Mégabit" , 1e6                  ),
					Map.entry( "Mébibit" , 1.048576e6           ),
					Map.entry( "Gigabit" , 1e9                  ),
					Map.entry( "Gibibit" , 1.073741824e9        ),
					Map.entry( "Térabit" , 1e12                 ),
					Map.entry( "Tébibit" , 1.099511628e12       ),
					Map.entry( "Pétabit" , 1e15                 ),
					Map.entry( "Pébibit" , 1.125899907e15       ),
					Map.entry( "Octet"   , 8.0                  ),
					Map.entry( "Kilobyte", 8e3                  ),
					Map.entry( "Kibibyte", 8192.0               ),
					Map.entry( "Mégabyte", 8e6                  ),
					Map.entry( "Mébibyte", 8.388608e6           ),
					Map.entry( "Gigabyte", 8e9                  ),
					Map.entry( "Gibibyte", 8.589934592e9        ),
					Map.entry( "Térabyte", 8e12                 ),
					Map.entry( "Tebibyte", 8.796093022208e12    ),
					Map.entry( "Pétabyte", 8e15                 ),
					Map.entry( "Pebibyte", 9.007199254740992e15 )
				);
				case "Temps" -> map = Map.ofEntries
				(
					Map.entry( "Nanoseconde"  , 1e-9     ),
					Map.entry( "Microseconde" , 1e-6     ),
					Map.entry( "Milliseconde" , 1e-3     ),
					Map.entry( "Seconde"      , 1.0      ),
					Map.entry( "Minute"       , 60.0     ),
					Map.entry( "Heure"        , 3600.0   ),
					Map.entry( "Jour"         , 86400.0  ),
					Map.entry( "Semaine"      , 604800.0 ),
					Map.entry( "Mois"         , 2.628e6  ),
					Map.entry( "Année"        , 3.154e7  ),
					Map.entry( "Décennie"     , 3.154e8  ),
					Map.entry( "Siècle"       , 3.154e9  )
				);
				case "Vitesse" -> map = Map.ofEntries
				(
					Map.entry( "Kilomètre par heure", 1000.0 / 3600   ),
					Map.entry( "Mètre par seconde"  , 1.0             ),
					Map.entry( "Mille par heure"    , 1609.344 / 3600 ),
					Map.entry( "Noeud"              , 1852.0 / 3600   ),
					Map.entry( "Pied par seconde"   , 0.3048          )
				);
				case "Volume" -> map = Map.ofEntries
				(
					Map.entry( "Mètre cube"                 , 1.0         ),
					Map.entry( "Litre"                      , 0.001       ),
					Map.entry( "Millilitre"                 , 1e-6        ),
					Map.entry( "Gallon américain"           , 0.00378541  ),
					Map.entry( "Quart américain"            , 0.000946353 ),
					Map.entry( "Pinte américaine liquide"   , 0.000473176 ),
					Map.entry( "Tasse américaine"           , 0.000236588 ),
					Map.entry( "Once liquide américaine"    , 2.9574e-5   ),
					Map.entry( "Cuillère à soupe américaine", 1.4787e-5   ),
					Map.entry( "Cuillère à café américaine" , 4.9289e-6   ),
					Map.entry( "Gallon impérial"            , 0.00454609  ),
					Map.entry( "Quart impérial"             , 0.00113652  ),
					Map.entry( "Pinte impériale"            , 0.000568261 ),
					Map.entry( "Tasse impériale"            , 0.000284131 ),
					Map.entry( "Once liquide impériale"     , 2.8413e-5   ),
					Map.entry( "Cuillère à soupe impériale" , 1.7758e-5   ),
					Map.entry( "Cuillère à café impériale"  , 5.9194e-6   ),
					Map.entry( "Pied cube"                  , 0.0283168   ),
					Map.entry( "Pouce cube"                 , 1.6387e-5   )
				);
				case "Énergie" -> map = Map.ofEntries
				(
					Map.entry( "Joule"               , 1.0         ),
					Map.entry( "Kilojoule"           , 1000.0      ),
					Map.entry( "Petite calorie"      , 4.184       ),
					Map.entry( "Kilocalorie"         , 4184.0      ),
					Map.entry( "Watt-heure"          , 3600.0      ),
					Map.entry( "Kilowatt-heure"      , 3.6e6       ),
					Map.entry( "Électronvolt"        , 1.60218e-19 ),
					Map.entry( "British Thermal Unit", 1055.06     ),
					Map.entry( "Therm américain"     , 1.05506e8   ),
					Map.entry( "Pied-livre"          , 1.35582     )
				);

				default        -> throw new IllegalArgumentException( "Type inconnu" );
			}
			
			double facteurSrc = map.getOrDefault( uniteSrc, 1.0 );
			double facteurDst = map.getOrDefault( uniteDst, 1.0 );
			return valeur * ( facteurSrc / facteurDst );
		}
	}

	public static String[] getLog()
	{
		List<String> lstLog = new ArrayList<String>();
		Scanner      sc;

		try
		{
			sc = new Scanner ( new FileInputStream ( Convertisseur.fichier ), "UTF8" );

			while ( sc.hasNextLine() )
				lstLog.add( sc.nextLine() );
			
		}
		catch ( Exception e ) { e.printStackTrace(); }

		return lstLog.toArray( new String[0] );
	}

	public static void ajouterLog( String entrer, String sortie, String resultat )
	{
		PrintWriter pw;
		
		try
		{
			pw = new PrintWriter( new OutputStreamWriter( new FileOutputStream( Convertisseur.fichier, true ), "UTF8" ) );

			pw.println( entrer + " -> " + sortie + ":" );
			pw.println( "   " + resultat );
			pw.println();

			pw.close();
		}
		catch ( Exception e ) { e.printStackTrace(); }
	}

	public static void supprimerLog()
	{
		try
		{
			new FileOutputStream( Convertisseur.fichier ).close();
		}
		catch (IOException e) { e.printStackTrace(); }
	}
}
