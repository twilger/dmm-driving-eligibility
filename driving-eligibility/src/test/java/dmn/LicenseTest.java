package dmn;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.dmn.api.core.DMNContext;
import org.kie.dmn.api.core.DMNModel;
import org.kie.dmn.api.core.DMNResult;
import org.kie.dmn.api.core.DMNRuntime;

import model.Person;

public class LicenseTest {
	private DMNRuntime dmnRuntime;
	private DMNModel dmnModel;
	private DMNContext dmnContext;

	@Before
	public void before() {
		KieServices kieServices = KieServices.Factory.get();

		KieContainer kieContainer = kieServices.getKieClasspathContainer();
		dmnRuntime = kieContainer.newKieSession().getKieRuntime( DMNRuntime.class );
		dmnModel = dmnRuntime.getModel("http://www.trisotech.com/definitions/_90a17b17-c884-4fa9-ba59-7a47899d89b2", "driving-eligibility");
		
		dmnContext = dmnRuntime.newContext();		
	}

/*	
	@Test
	public void testUS() {		
		Person person = new Person("Tom", 35, "123 Tramway Ln.", "Albuquerque", "NM", "87123", "United States");

		dmnContext.set("Person", person);

		DMNResult dmnResult = dmnRuntime.evaluateAll(dmnModel, dmnContext);
		//Assert.assertEquals(dmnResult.getDecisionResults().size(), 1);
		Assert.assertEquals(dmnResult.getDecisionResults().get(0).getResult(), Boolean.TRUE);

		person.setAge(15);
		dmnResult = dmnRuntime.evaluateAll(dmnModel, dmnContext);

		//Assert.assertEquals(dmnResult.getDecisionResults().size(), 1);
		Assert.assertEquals(dmnResult.getDecisionResults().get(0).getResult(), Boolean.FALSE);
	}
	
	@Test
	public void testGermany() {		
		Person person = new Person("Tom", 35, "123 Tramway Ln.", "Albuquerque", "NM", "87123", "Germany");

		dmnContext.set("Person", person);

		DMNResult dmnResult = dmnRuntime.evaluateAll(dmnModel, dmnContext);
		Assert.assertEquals(dmnResult.getDecisionResults().size(), 1);
		Assert.assertEquals(dmnResult.getDecisionResults().get(0).getResult(), Boolean.TRUE);

		person.setAge(15);
		dmnResult = dmnRuntime.evaluateAll(dmnModel, dmnContext);

		Assert.assertEquals(dmnResult.getDecisionResults().size(), 1);
		Assert.assertEquals(dmnResult.getDecisionResults().get(0).getResult(), Boolean.FALSE);
	}
*/
}
