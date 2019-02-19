package br.com.open.eip.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith (Suite.class)
@SuiteClasses({ProdutoRepositoryTest.class,ProdutoEndpointTest.class})
public class ProdutoTestSuite {
}
