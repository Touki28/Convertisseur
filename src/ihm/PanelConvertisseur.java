package src.ihm;

import src.Controleur;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;

public class PanelConvertisseur extends JPanel implements ActionListener
{
	private Controleur        ctrl;
	private String            type;

	private JComboBox<String> cbEntrer;
	private JTextField        txtEntrer;
	private JComboBox<String> cbSortie;
	private JTextField        txtSortie;

	private JButton           btnRetour;

	public PanelConvertisseur( Controleur ctrl, String type )
	{
		JPanel      panelSaisies, panelBas;
		JLabel      lblTitre;

		this.ctrl = ctrl;
		this.type = type;

		this.setLayout( new BorderLayout() );

		/*-------------------------------*/
		/* Création des composants       */
		/*-------------------------------*/

		lblTitre = new JLabel ( "<html><h1>" + type + "</h1></html>" , SwingConstants.CENTER );

		this.cbEntrer  = new JComboBox<String>( Controleur.getDevises( type ) );
		this.txtEntrer = new JTextField       ( 20                            );
		this.cbSortie  = new JComboBox<String>( Controleur.getDevises( type ) );
		this.txtSortie = new JTextField       ( 20                            );

		this.txtEntrer.setToolTipText( "Saisissez la valeur à convertir" );
		this.cbSortie.setSelectedIndex( 1 );
		this.txtSortie.setEditable( false );
		
		this.btnRetour = new JButton( "Retour" );

		/*-------------------------------*/
		/* Positionnement des composants */
		/*-------------------------------*/

		// Création et positionnement de notre panel avec les JTextfield et les JComboBox
		panelSaisies = new JPanel( new GridLayout( 1, 3 ) );

		panelSaisies.add( this.creerPanelSaisie( cbEntrer, txtEntrer           ) );
		panelSaisies.add( new JLabel( "<html><h1>-></h1></html>", SwingConstants.CENTER ) );
		panelSaisies.add( this.creerPanelSaisie( cbSortie, txtSortie           ) );

		/* --------- Catégories -------- */
		this.add( panelSaisies , BorderLayout.CENTER );

		// Panel avec le bouton retour
		panelBas = new JPanel();
		panelBas.add( this.btnRetour );


		this.add( lblTitre     , BorderLayout.NORTH  );
		this.add( panelBas     , BorderLayout.SOUTH  );

		/*-------------------------------*/
		/* Activation des composants     */
		/*-------------------------------*/

		this.cbEntrer .addActionListener( this );
		this.cbSortie .addActionListener( this );
		this.txtEntrer.addActionListener( this );
		this.btnRetour.addActionListener( this );
	}

	private JPanel creerPanelSaisie( JComboBox<String> cb, JTextField txt )
	{
		JPanel panelTmp, panelRet;

		panelRet = new JPanel( new GridLayout( 2, 1 ) );

		panelTmp = new JPanel();
		panelTmp.add( cb       );
		panelRet.add( panelTmp );

		panelTmp = new JPanel();
		panelTmp.add( txt      );
		panelRet.add( panelTmp );

		return panelRet;
	}

	public void actionPerformed( ActionEvent e )
	{
		if ( e.getSource() == this.cbEntrer || e.getSource() == this.cbSortie )
		{
			if ( this.cbEntrer.getSelectedItem().equals( this.cbSortie.getSelectedItem() ) )
			{
				if ( e.getSource() == this.cbEntrer )
				{
					if( this.cbEntrer.getSelectedIndex() == 0 )
						this.cbSortie.setSelectedIndex( 1 );
					else 
						this.cbSortie.setSelectedIndex( this.cbEntrer.getSelectedIndex() - 1 );
				}
				else
				{
					if( this.cbSortie.getSelectedIndex() == 0 )
						this.cbEntrer.setSelectedIndex( 1 );
					else
						this.cbEntrer.setSelectedIndex( this.cbSortie.getSelectedIndex() - 1 );
				}
			}
			
			this.reinitChamps();
		}

		if ( e.getSource() == this.txtEntrer  )
		{
			this.saisie();
		}

		// Demande à la frame par le controleur de réafficher le menu
		if ( e.getSource() == this.btnRetour )
		{
			this.ctrl.panelConvertisseur( "Menu" );
		}
	}

	private void saisie()
	{
		double valeur, resultat;
		String calcul;
		try
		{	
			// Remplace les ',' par des '.' pour pouvoir écrire soit des virgule ou des points sans problème
			valeur = Double.parseDouble( this.txtEntrer.getText().replace( ',' , '.' ) );

			// Calcul le résultat avec ( type, uniteSrc, uniteDst, valeur )
			resultat = Controleur.calculer( this.type, this.cbEntrer.getSelectedItem().toString(),
			                                           this.cbSortie.getSelectedItem().toString(), valeur );

			//Affichage le résultat dans le TextField au format a 2 chiffres après la virgule
			this.txtSortie.setText( "" + resultat );

			calcul = this.txtEntrer.getText() + " -> " + resultat;

			//Ajout au logs
			this.ctrl.ajouterLog( this.cbEntrer.getSelectedItem().toString(),
			                      this.cbSortie.getSelectedItem().toString(), calcul );
		}
		catch ( NumberFormatException ex ) //Erreur si la données entrer dans le JTextField n'est pas un nombre
		{
			JOptionPane.showMessageDialog( this, "Veuillez entrer un nombre valide.", "Erreur de saisie", JOptionPane.ERROR_MESSAGE );
		}
		catch ( Exception ex ) //Sortie d'erreur par default ( pour le débuggage ou autre )
		{
			JOptionPane.showMessageDialog( this, "Une erreur est survenue.", "Erreur", JOptionPane.ERROR_MESSAGE );
		}
	}

	private void reinitChamps()
	{
		this.txtEntrer.setText( "" );
		this.txtSortie.setText( "" );
	}
}
