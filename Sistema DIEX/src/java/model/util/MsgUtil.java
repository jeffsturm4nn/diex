package model.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author LUAN, Jefferson Sales
 */
public final class MsgUtil {
    
    private MsgUtil(){
        
    }
    
    public static void enviarMensagem(FacesMessage.Severity severity, String summary, String component, boolean _transient) {
        
        FacesMessage message = new FacesMessage(severity, summary, "");
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(component, message);
        context.getExternalContext().getFlash().setKeepMessages(_transient);
    }
    
    public static void enviarMensagemDeErro(String summary, String component, boolean _transient){
        enviarMensagem(FacesMessage.SEVERITY_ERROR, summary, component, _transient);
    }
    
    public static void enviarMensagemDeAlerta(String summary, String component, boolean _transient){
        enviarMensagem(FacesMessage.SEVERITY_WARN, summary, component, _transient);
    }
    
    public static void enviarMensagem(String summary, String component, boolean _transient){
        enviarMensagem(FacesMessage.SEVERITY_INFO, summary, component, _transient);
    }
}
