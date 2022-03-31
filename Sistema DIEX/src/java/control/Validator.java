package control;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import model.util.CpfUtil;
import model.util.DataUtil;
import model.util.EmailUtil;
import model.util.HoraUtil;
import model.util.RgUtil;

/**
 * 
 * @author Alexandre Jorge, Jefferson Sales
 */

@ManagedBean
@RequestScoped
public class Validator {

    public boolean validaCpf(String cpf) {

        try {
            CpfUtil.validarCpf(cpf);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public boolean validarData(String data) {
        
        try{
            DataUtil.validarData(data);
            return true;
        }
        catch(IllegalArgumentException e){
            return false;
        }
    }
    
    public boolean validarEmail(String email){
        
        try{
            EmailUtil.validarEmail(email);
            return true;
        }
        catch(IllegalArgumentException e){
            return false;
        }
    }
    
    public boolean validarRg(String rg){
        
        try{
            RgUtil.validarRG(rg);
            return true;
        }
        catch(IllegalArgumentException e){
            return false;
        }
    }
    
    public boolean validarHora(String hora){
        
        try{
            HoraUtil.validarHora(hora);
            return true;
        }
        catch(IllegalArgumentException e){
            return false;
        }
    }
}
