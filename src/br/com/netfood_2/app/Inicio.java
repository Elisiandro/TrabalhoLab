package br.com.netfood_2.app;

import br.com.netfood_2.dao.GarcomDao;
import br.com.netfood_2.entity.Garcom;
import br.com.netfood_2.rn.GarcomRN;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Elisiandro
 */
public class Inicio {
    public static void main(String[] args) {
        
        /*Garcom garcom = new Garcom();
        garcom.setEmail("augusto@gmail.com");
        garcom.setNome("Augusto");
        
        GarcomDao dao = new GarcomDao();
        dao.salvar(garcom);
                */
        
        inserir();
        
        //listarTodos();
        //remover();
        
        //GarcomDao dao = new GarcomDaoJpa();
        //dao.salvar(garcom);
        
    }
    
    public static void inserir() {
        String nome = JOptionPane.showInputDialog("Nome: ");
        String email = JOptionPane.showInputDialog("Email: ");
        double salario = 0;
        salario = Double.parseDouble(JOptionPane.showInputDialog("Salario: "));
        Garcom garcom = new Garcom();
        garcom.setNome(nome);
        garcom.setEmail(email);
        garcom.setSalario(salario);

        GarcomRN rn = new GarcomRN();
        try {
            rn.salvar(garcom);
            JOptionPane.showMessageDialog(null, garcom.getNome() + " cadastrado com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }        
    }

    public static void remover() {
        Garcom pessoa = procurar();
        if (pessoa == null) {
            JOptionPane.showMessageDialog(null, "ID nao encontrado!");
        } else {
            GarcomDao dao = new GarcomDao();
            dao.remover(pessoa.getId());
            JOptionPane.showMessageDialog(null, pessoa.getNome() + 
                    " removido com sucesso!");
        }
    }

    public static void atualizar() {
        Garcom pessoa = procurar();
        if (pessoa == null) {
            JOptionPane.showMessageDialog(null, "ID nao encontrado!");
        } else {
            GarcomDao dao = new GarcomDao();
            String nome = JOptionPane.showInputDialog("Nome: ");
            String email = JOptionPane.showInputDialog("Email: ");
            pessoa.setNome(nome);
            pessoa.setEmail(email);
            dao.salvar(pessoa);
            JOptionPane.showMessageDialog(null, pessoa.getNome() + 
                    " atualizado com sucesso");
        }

    }

    public static void listarTodos() {
        GarcomDao dao = new GarcomDao();

        List<Garcom> listaPessoas = dao.getList();

        String pessoas = "";
        for (Garcom p : listaPessoas) {
            pessoas+= p.getNome()+" - "+p.getEmail()+"\n";
        }
        
        JOptionPane.showMessageDialog(null, "Lista de Pessoas: \n"+pessoas);
    }

    public static void visualizar() {
        Garcom pessoa = procurar();
        JOptionPane.showMessageDialog(null, 
                pessoa.getNome() + " - " + pessoa.getEmail());
    }

    private static Garcom procurar() {
        Long id = Long.valueOf(JOptionPane.showInputDialog("Id: "));

        GarcomDao dao = new GarcomDao();
        Garcom pessoa = dao.encontrar(id);

        return (pessoa);
    }
}
