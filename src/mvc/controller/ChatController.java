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

import mvc.model.Tarefa;
import mvc.model.TarefaDAO;
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
    public String ChatInsper(Model model,Usuario usuario, HttpSession session, Tarefa tarefa) {
    	tarefa.setUsuario((String) session.getAttribute("usuarioLogado"));
		TarefaDAO dao = new TarefaDAO();
		model.addAttribute("tarefas", dao.getLista());
        return "telaChat";
    }
    
    @RequestMapping("apagaMensagem")
    public String apagaMensagem(){
    TarefaDAO dao = new TarefaDAO();
    dao.apaga();
	return "redirect: ChatInsper";
    }
    
    @RequestMapping("adicionaMensagem")
    public String adiciona(@Valid Tarefa tarefa,HttpSession session, BindingResult result) {
    	if(result.hasErrors()) {
    	    return "telaChat";
    	}
    	TarefaDAO dao = new TarefaDAO();
    	tarefa.setUsuario((String) session.getAttribute("usuarioLogado"));
    	//System.out.println(session.getAttribute("usuarioLogado"));
    	dao.adiciona(tarefa);
        return "redirect:ChatInsper";
    }
    
    @RequestMapping("listaTarefa")
    public String lista(Model model) {
        TarefaDAO dao = new TarefaDAO();
        model.addAttribute("tarefas", dao.getLista());
        return "telaChat";
    }
    @RequestMapping("removeTarefa")
    public String remove(Tarefa tarefa) {
        TarefaDAO dao = new TarefaDAO();
        dao.remove(tarefa);
        return "redirect:listaTarefas";
    }
    @RequestMapping("mostraTarefa")
    public String mostra(Long id, Model model) {
        TarefaDAO dao = new TarefaDAO();
        model.addAttribute("tarefa", dao.buscaPorId(id));
        return "mostra";
    }
    @RequestMapping("alteraTarefa")
    public String altera(Tarefa tarefa) {
           TarefaDAO dao = new TarefaDAO();
           dao.altera(tarefa);
           return "redirect:listaTarefas";
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
    	TarefaDAO dao = new TarefaDAO();
    	model.addAttribute("tarefas",dao.getLista());
    	dao.close();
    	return "lista";
    }
}