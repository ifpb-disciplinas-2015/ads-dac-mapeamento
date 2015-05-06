package br.edu.ifpb.dac.mapeamento.core;

import br.edu.ifpb.dac.mapeamento.entidades.Dao.DAOJPA;
import br.edu.ifpb.dac.mapeamento.entidades.Dao.DAO;
import br.edu.ifpb.dac.mapeamento.entidades.Aluno;

/**
 * @author job
 */
public class TestarAccess {
    public static void main(String[] args) {
        DAO<Aluno> dao = new DAOJPA<>();
        
        Aluno aluno = new Aluno("Job", "1234");
        aluno.addTelefone("9899.9000");
        System.out.println(dao.salvar(aluno));
    }
}
