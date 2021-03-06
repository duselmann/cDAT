package gov.cida.cdat.service;


import static org.junit.Assert.assertTrue;
import gov.cida.cdat.control.Control;
import gov.cida.cdat.control.Time;
import gov.cida.cdat.control.Worker;
import gov.cida.cdat.exception.CdatException;

import org.junit.Test;


public class DelegatorAutoStartTest {

	private static Service session;
	
	
	@Test
	public void testAutoStart() throws Exception {
		session = Service.open();

		session.setAutoStart(true);
		
		try {
		
			final Boolean[] processCalled = new Boolean[1];
			final String workerName = session.addWorker("autoStartTest",  new Worker() {
				@Override
				public boolean process() throws CdatException {
					processCalled[0] = true;
					return false; // tell the system that there NO more to process
				}
			});
	
			Time.waitForResponse(processCalled,100);
			
			assertTrue("process should be called without explicit start message when autostart",
					processCalled[0]);
			
			session.send(workerName, Control.Stop);
			
		} finally {
			session.close();
		}
	}
}
