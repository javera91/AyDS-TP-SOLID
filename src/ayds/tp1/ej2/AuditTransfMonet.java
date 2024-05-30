/*package ayds.tp1.ej2;

public class AuditTransfMonet {

	public void transferenciaRealizada(Transferencia transferencia) {
        if(this.esTransferenciaImportante(transferencia)) {
            String auditor=this.obtenerDireccionMailAuditor();
            String mensaje=this.componerMensajeAviso(transferencia);
            ConexionMail conexionMail=null;
            try {
				conexionMail = this.abrirConexionMail();
                conexionMail.enviar(new Mail().to(auditor).withBody(mensaje));
            } finally {
            if(conexionMail!=null)
              conexionMail.cerrar();
            }
        }
    }
    private boolean esTransferenciaImportante(Transferencia transferencia) {
       return transferencia.importe()>50000;
    }
    private String obtenerDireccionMailAuditor() {
       return "mail-auditor";
    }
    private String componerMensajeAviso(Transferencia transferencia) {
       return "aviso-transferencia-importante";    
    }
    private ConexionMail abrirConexionMail() {
       return ConexionMail.getInstance();
    }
}
*/
package ayds.tp1.ej2;

public class AuditTransfMonet {
    private TransferenciaImportanteChecker transferenciaImportanteChecker;
    private MailSender mailSender;

    public AuditTransfMonet(TransferenciaImportanteChecker transferenciaImportanteChecker, MailSender mailSender) {
        this.transferenciaImportanteChecker = transferenciaImportanteChecker;
        this.mailSender = mailSender;
    }

    public void transferenciaRealizada(Transferencia transferencia) {
        if (transferenciaImportanteChecker.esTransferenciaImportante(transferencia)) {
            String auditor = mailSender.obtenerDireccionMailAuditor();
            String mensaje = mailSender.componerMensajeAviso(transferencia);
            mailSender.enviarAviso(auditor, mensaje);
        }
    }
}

