package src.ihm;

import src.Controleur;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;

public class PanelConvertisseur extends JPanel implements ActionListener
{
	private Controleur     ctrl;
	
	private JButton        btnRetour;

	private JRadioButton[] ensRb;
	
	private JComboBox      cbEntrer;
	private JTextField     txtEntrer;
	private JComboBox      cbSortie;
	private JTextField     txtSortie;

	public PanelConvertisseur( Controleur ctrl, String titre, String type )
	{
		String[]    categories;
		ButtonGroup btgType;
		JPanel      panelChoix, panelSaisies, panelBas, panelTmp;
		JLabel      lblTitre;

		// si pas de categories alors categories = null
		categories = Controleur.getCategories( type );

		this.ctrl = ctrl;

		this.setLayout( new BorderLayout() );

		/*-------------------------------*/
		/* Création des composants       */
		/*-------------------------------*/

		lblTitre       = new JLabel ( "<html><h1>" + titre + "</h1></html>" , SwingConstants.CENTER );
		this.btnRetour = new JButton( "Retour" );

		/* --------- Catégories -------- */
		if ( categories != null )
		{
			btgType    = new ButtonGroup();
			this.ensRb = new JRadioButton[ categories.length ];

			for( int cpt = 0; cpt < this.ensRb.length; cpt++ )
				this.ensRb[cpt] = new JRadioButton( categories[cpt] );

			if ( this.ensRb.length > 0 ) this.ensRb[0].setSelected( true );

			for ( JRadioButton rb : this.ensRb )
				btgType.add( rb );
		}
		else
		{
			btgType    = null;
			this.ensRb = null;
		}

		this.cbEntrer  = new JComboBox<>( Controleur.getDevises( type ) );
		this.txtEntrer = new JTextField ( 20                            );
		this.cbSortie  = new JComboBox<>( Controleur.getDevises( type ) );
		this.txtSortie = new JTextField ( 20                            );

		this.cbSortie.setSelectedIndex( 1 );
		this.txtSortie.setEditable( false );
		
		/*-------------------------------*/
		/* Positionnement des composants */
		/*-------------------------------*/

		// Création et positionnement de notre panel avec les JTextfield et les JComboBox
		panelSaisies = new JPanel( new GridLayout( 1, 3 ) );

		panelSaisies.add( this.positionnementPanelSaisie( cbEntrer, txtEntrer           ) );
		panelSaisies.add( new JLabel( "<html><h1>-></h1></html>", SwingConstants.CENTER ) );
		panelSaisies.add( this.positionnementPanelSaisie( cbSortie, txtSortie           ) );

		// Panel avec le bouton retour
		panelBas = new JPanel();
		panelBas.add( this.btnRetour );

		/* --------- Catégories -------- */
		if ( categories != null )
		{
			// Panel avec les choix des catégories avec les JRadioButton
			panelChoix = new JPanel();

			for ( JRadioButton rb : this.ensRb )
				panelChoix.add( rb );

			panelTmp = new JPanel( new GridLayout( 2, 1 ) );
			panelTmp.add( panelChoix   );
			panelTmp.add( panelSaisies );
			
			this.add( panelTmp , BorderLayout.CENTER );
		}
		else
		{
			this.add( panelSaisies , BorderLayout.CENTER );
		}

		this.add( lblTitre     , BorderLayout.NORTH  );
		this.add( panelBas     , BorderLayout.SOUTH  );

		/*-------------------------------*/
		/* Activation des composants     */
		/*-------------------------------*/

		/* --------- Catégories -------- */
		if ( categories != null )
			for ( JRadioButton rb : this.ensRb )
				rb.addActionListener( this );


		this.cbEntrer .addActionListener( this );
		this.cbSortie .addActionListener( this );
		this.txtEntrer.addActionListener( this );
		this.btnRetour.addActionListener( this );
	}

	private JPanel positionnementPanelSaisie( JComboBox cb, JTextField txt )
	{
		JPanel panelTmp, panelRet;

		panelRet = new JPanel( new GridLayout( 2, 1 ) );

		panelTmp = new JPanel();
		panelTmp.add( cb );
		panelRet.add( panelTmp );

		panelTmp = new JPanel();
		panelTmp.add( txt );
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
			
			this.txtEntrer.setText( "" );
			this.txtSortie.setText( "" );
		}


		if ( this.ensRb != null )
		{
			for ( JRadioButton rb : this.ensRb )
			if ( e.getSource() == rb )
			{
				this.txtEntrer.setText( "" );
				this.txtSortie.setText( "" );
			}
		}

		if ( e.getSource() == this.txtEntrer  )
		{
			double valeur;
			String type = "";
			try
			{
				if ( this.ensRb != null )
					for ( JRadioButton rb : this.ensRb )
						if ( rb.isSelected() ) type += rb.getText() + "|";
				
				type += this.cbEntrer.getSelectedItem().toString() + "->" +
				        this.cbSortie.getSelectedItem().toString();

				valeur = Double.parseDouble( this.txtEntrer.getText().replace( ',' , '.' ) );

				this.txtSortie.setText( String.format( "%.2f", this.ctrl.calculer( type, valeur ) ) );
			}
			catch (NumberFormatException ex)
			{
				JOptionPane.showMessageDialog( this, "Veuillez entrer un nombre valide.", "Erreur de saisie", JOptionPane.ERROR_MESSAGE );
			}
			catch (Exception ex)
			{
				JOptionPane.showMessageDialog( this, "Une erreur est survenue.", "Erreur", JOptionPane.ERROR_MESSAGE );
			}

		}

		if ( e.getSource() == this.btnRetour )
		{
			this.ctrl.panelConvertisseur( "Menu" );
		}
	}
}
