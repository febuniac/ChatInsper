package mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import mvc.model.Parametros;
import mvc.model.ChatDAO;
import mvc.model.Usuario;
import mvc.model.UsuarioDAO;

@Controller
public class ChatController {


    @RequestMapping("/")
    public String execute() {
        System.out.println("Lógica do MVC");
        return "formulario-registro";
    }
    

    @RequestMapping("ChatInsper")
    public String ChatInsper(Model model,Usuario usuario, HttpSession session, Parametros parametro) {
    	parametro.setUsuario((String) session.getAttribute("usuarioLogado"));
		ChatDAO dao = new ChatDAO();
		model.addAttribute("mensagens_", dao.getLista());
        return "telaChat";
    }
    
    @RequestMapping("apagaMensagem")
    public String apagaMensagem(){
    ChatDAO dao = new ChatDAO();
    dao.apaga();
	return "redirect: ChatInsper";
    }
    
    @RequestMapping("adicionaMensagem")
    public String adiciona(@Valid Parametros parametro,HttpSession session, BindingResult result) {
    	if(result.hasErrors()) {
    	    return "telaChat";
    	}
    	ChatDAO dao = new ChatDAO();
    	parametro.setUsuario((String) session.getAttribute("usuarioLogado"));
    	//System.out.println(session.getAttribute("usuarioLogado"));
    	dao.adiciona(parametro);
        return "redirect:ChatInsper";
    }
    
    @RequestMapping("listaMensagem")
    public String lista(Model model) {
        ChatDAO dao = new ChatDAO();
        model.addAttribute("mensagens_", dao.getLista());
        return "telaChat";
    }
    @Controller
    public class LoginController{
        @RequestMapping("registro")
        public String registro() {
            return "formulario-registro";
        }
        
        @RequestMapping(value = "efetuaRegistro", method = RequestMethod.POST)
        public String upload(Usuario usuario) throws IOException {
        	UsuarioDAO dao = new UsuarioDAO();
        	dao.adiciona(usuario);
           return "redirect:login";
       } 
        @RequestMapping("login")
        public String login() {
            return "formulario-login";
        }
        @RequestMapping("efetuaLogin")
        public String efetuaLogin(Usuario usuario, HttpSession session) {
            if(new UsuarioDAO().existeUsuario(usuario)) {
                session.setAttribute("usuarioLogado", usuario.getLogin());
                return "menu";
            }
            return "redirect:login";
        }

    }
    @RequestMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:login";
    }

    @RequestMapping(value = "getImage", method = RequestMethod.GET)
    public void showImage(@RequestParam("login") String login, HttpServletResponse response,HttpServletRequest request) 
            throws ServletException, IOException{
    	UsuarioDAO dao = new UsuarioDAO();
    	response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
    	response.getOutputStream().write(dao.buscaFoto(login));
    	response.getOutputStream().close();
    }
    @RequestMapping("Jquery")
    public String Jquery(Model model){
    	ChatDAO dao = new ChatDAO();
    	model.addAttribute("mensagens_",dao.getLista());
    	dao.close();
    	return "lista";
    }
}