package mvc.model;


//import java.util.Calendar;
import javax.validation.constraints.*;

//import org.springframework.format.annotation.DateTimeFormat;


public class Tarefa {
    private Long id;
    @NotNull(message="Por favor entre uma mensagem")
    @Size(min=1, message="Mensagem deve ter um texto para ser enviada")
    private String mensagem;
    private String usuario;

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getMensagem() {return mensagem;}{
    }
    
    public void setMensagem(String mensagem) {this.mensagem = mensagem;}
    public String getUsuario() {return usuario;}
    public void setUsuario(String usuario) {this.usuario = usuario;}

}