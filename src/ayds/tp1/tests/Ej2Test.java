package ayds.tp1.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import ayds.tp1.ej2.AuditTransfMonet;
import ayds.tp1.ej2.ConexionMail;
import ayds.tp1.ej2.Mail;
import ayds.tp1.ej2.Transferencia;

public class Ej2Test {

	@Test
	public void test() {
		
		Transferencia transferencia = new Transferencia(100000);
		AuditTransfMonet auditTransfMonet = new AuditTransfMonet();
		
		assertEquals(ConexionMail.getInstance().getQueue().size(), 0);
		
		auditTransfMonet.transferenciaRealizada(transferencia);
		
		assertEquals(ConexionMail.getInstance().getQueue().size(), 1);
		
		Mail expectedMail = ConexionMail.getInstance().getQueue().get(0);

		assertEquals(expectedMail.getAuditor(),"mail-auditor");
		assertEquals(expectedMail.getMensaje() ,"aviso-transferencia-importante");
	}

}
