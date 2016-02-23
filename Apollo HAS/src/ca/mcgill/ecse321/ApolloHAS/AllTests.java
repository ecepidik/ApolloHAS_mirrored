package ca.mcgill.ecse321.ApolloHAS;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import ca.mcgill.ecse321.ApolloHAS.controller.TestApolloHASAlbumController;
import ca.mcgill.ecse321.ApolloHAS.persistence.TestPersistenceApolloHAS;

@RunWith(Suite.class)
@SuiteClasses({TestApolloHASAlbumController.class, TestPersistenceApolloHAS.class})
public class AllTests {

}
