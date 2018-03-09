package dmn;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.dmn.api.core.DMNContext;
import org.kie.dmn.api.core.DMNDecisionResult;
import org.kie.dmn.api.core.DMNModel;
import org.kie.dmn.api.core.DMNResult;
import org.kie.dmn.api.core.DMNRuntime;
import org.kie.dmn.api.core.ast.InputDataNode;

import model.Person;
import model.PracticeLogEntry;

public class DMNRunner {

	public static void main(String[] args) {
			KieServices kieServices = KieServices.Factory.get();
	
			//KieContainer kieContainer = kieServices.getKieClasspathContainer(Thread.currentThread().getContextClassLoader());
			KieContainer kieContainer = kieServices.getKieClasspathContainer();
			
			DMNRuntime dmnRuntime = kieContainer.newKieSession().getKieRuntime( DMNRuntime.class );
			DMNModel dmnModel = dmnRuntime.getModel("http://www.trisotech.com/definitions/_90a17b17-c884-4fa9-ba59-7a47899d89b2", "driving-eligibility");
			
			if (dmnModel != null) {
				System.out.println("DMN Model: " + dmnModel.toString());			
			} else {
				System.out.println("DMN Model is null!");
			}
			
			// <<< optional check
			Set<InputDataNode> inputs = dmnModel.getInputs();
			for (InputDataNode inputDataNode : inputs) {
				System.out.println(inputDataNode.getType());
			}
			//  optional check >>>
			
			DMNContext dmnContext = dmnRuntime.newContext();
			
			Person person = createPerson();
			
			dmnContext.set("Person", person);
	
			DMNResult dmnResult = dmnRuntime.evaluateAll(dmnModel, dmnContext);
	
			for (DMNDecisionResult dr : dmnResult.getDecisionResults()) {
				System.out.println("Decision '" + dr.getDecisionName() + "' : " + dr.getResult());
			}
	}
	
	public static Person createPerson() {
		Person retVal;
		
		retVal = new Person("Tom", 22, "123 Tramway Ln.", "Albuquerque", "NM", "87123", "United States");
		
		// add the practice log entries
		
		retVal.getPracticeLogEntries().add(new PracticeLogEntry("2018-01-02T09:00:00", "2018-01-02T15:00:00"));
		retVal.getPracticeLogEntries().add(new PracticeLogEntry("2018-01-03T09:00:00", "2018-01-03T15:00:00"));
		retVal.getPracticeLogEntries().add(new PracticeLogEntry("2018-01-04T09:00:00", "2018-01-04T15:00:00"));
		
		
		return retVal;
	}

}
