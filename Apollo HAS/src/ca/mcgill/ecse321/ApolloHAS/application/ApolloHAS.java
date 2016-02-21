package ca.mcgill.ecse321.ApolloHAS.application;

import ca.mcgill.ecse321.ApolloHAS.persistence.PersistenceApolloHAS;
//import ca.mcgill.ecse321.ApolloHAS.view.ApolloHASPage;

public class ApolloHAS {

	public static void main(String[] args) {
		//load model
		PersistenceApolloHAS.loadApolloHASModel();
			
		//start UI
//		java.awt.EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				new ApolloHAS().setVisible(true);
//			}
//		});

	}

}
