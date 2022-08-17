package guru.springframework.repositories.reactive;

import guru.springframework.domain.Recipe;
import org.bson.assertions.Assertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataMongoTest
public class RecipeReactiveRepositoryTest {

	@Autowired
	RecipeReactiveRepository recipeReactiveRepository;

	@Before
	public void setUp() throws Exception{
		recipeReactiveRepository.deleteAll().block();
	}

	@Test
	public void testRecipeSave() throws Exception {
		Recipe recipe = new Recipe();
		recipe.setDescription("yummy");

		recipeReactiveRepository.save(recipe).block();

		Long count = recipeReactiveRepository.count().block();

		Assert.assertEquals(Long.valueOf(1L), count);
	}

}
