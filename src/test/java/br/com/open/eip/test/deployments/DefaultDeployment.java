package br.com.open.eip.test.deployments;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;



public class DefaultDeployment {

	private WebArchive webArchive;

	File[] files = Maven.resolver().loadPomFromFile("pom.xml")
			.importRuntimeDependencies()
			.resolve()
			.withTransitivity()
			.asFile();



	public  DefaultDeployment() throws URISyntaxException {


		File projectDefaults = new File(((URI)Thread.currentThread().getContextClassLoader().getResource("project-dev.yml").toURI()));
		File[] files = Maven.resolver().loadPomFromFile("pom.xml").importRuntimeDependencies().resolve().withTransitivity().asFile();
		this.webArchive = ShrinkWrap.create(WebArchive.class, "scaffoldTest.war")
				.addPackages(true, "br.com.open.eip")
				.addAsResource("META-INF/persistence.xml","META-INF/persistence.xml")
				.addAsResource(projectDefaults, "/project-defaults.yml")
				.addAsLibraries(files);
	}

	public WebArchive getArchive() {
		return this.webArchive;
	}

}
