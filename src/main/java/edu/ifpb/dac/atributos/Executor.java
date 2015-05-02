package edu.ifpb.dac.atributos;

import edu.ifpb.dac.Dao;
import edu.ifpb.dac.DaoJPA;
import edu.ifpb.dac.atributos.Pessoa.Sexo;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Date;

/**
 *
 * @author Ricardo Job
 */
public class Executor {
    
    static Dao dao = new DaoJPA("mapeamento");
//    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("mapeamento");
//    private static EntityManager em = emf.createEntityManager();

    public static void main(String[] args) {
        
        Endereco endereco = new Endereco("Vila do Chaves", " Bairro do Kiko");
        Pessoa pessoa = new Pessoa();
        pessoa.setAniversario(new Date());
        pessoa.setCpf("097766");
        pessoa.setNome("Chaves");
        pessoa.setSexo(Sexo.Masculino);
        pessoa.setVersao("1.0.0");
        pessoa.setEndereco(endereco);
        pessoa.addEmail("chaves@gmail.com");
        pessoa.addEmail("chaves2@hotmail.com");
        //Foto a ser salva 640x480
        pessoa.setFoto(carregaArquivo("/imagens/chaves.jpg"));
       // dao.save(pessoa);
        //Localizando e exibindo a foto
        //exibeFoto(pessoa.getId());
        
       //exibeFoto(40);
        
        Aluno aluno = new Aluno("Job", "12365");       
         dao.save(aluno);
        aluno = new Aluno("kiko", "5896");       
         dao.save(aluno);
//        Aluno a = (Aluno) dao.find(Aluno.class, 401);
//        System.out.print("Antes da atualização: "+a);
//        System.out.println("\tmatricula: "+a.getMatriculaFormatada());
//        a.setMatricula("265555");
////        dao.update(a);
//        a = (Aluno) dao.find(Aluno.class, 401);
//        System.out.print("Depois da atualização: "+a);
//        System.out.println("\tmatricula: "+a.getMatriculaFormatada());
        
    }
    
    private static void exibeFoto(int id) {

//        em.getTransaction().begin();
        Pessoa p = (Pessoa) dao.find(Pessoa.class, id);
        new ExibeFoto(p.getFoto()).setVisible(true);
//        em.getTransaction().commit();
    }
    
    public static byte[] carregaArquivo(String nomeArquivo) {
        try {
            URL url = Executor.class.getResource(nomeArquivo);
            File arquivo = new File(url.toURI());
            byte[] ramFoto = new byte[(int) arquivo.length()];
            try (FileInputStream fis = new FileInputStream(arquivo)) {
                byte[] buffer = new byte[1024 * 4];
                int bytesLidos = -1;
                int inicio = 0;
                while ((bytesLidos = fis.read(buffer)) != -1) {
                    System.arraycopy(buffer, 0, ramFoto, inicio, bytesLidos);
                    inicio += bytesLidos;
                }
            }
            return ramFoto;
        } catch (URISyntaxException | IOException e) {
            return null;
        }
        
    }
}
