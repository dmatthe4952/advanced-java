package maven_project.eclpse_maven_DAO;

import org.junit.Test;

import junit.framework.Assert;

public class ProfileTest {
	
	@Test
	public void testLoadDbConfig() {
		var props = Profile.getProperties("db");
		Assert.assertEquals(props.getProperty("database"), "test_people");
	}

}
