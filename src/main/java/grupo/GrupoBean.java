/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package grupo;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author rktds
 */
@Stateless
public class GrupoBean implements GrupoBeanLocal {
    
    @PersistenceContext
    EntityManager em;

    // Quais grupos (dados completos) não estão ativos?
    @Override
    public List<Grupo> buscarGruposInativos(){
        Query q = em.createQuery("SELECT g FROM Grupo g WHERE g.ativo = false");
        return (List<Grupo>) q.getResultList();
    }
    
    // Quais são os membros (nomes) do grupo com nome “Estudo IV” com ordenação alfabética inversa?
    @Override
    public List<String> buscarMembrosEstudoIV() {
        Query q = em.createQuery("SELECT p.nome FROM Grupo g JOIN g.atuacoes a JOIN a.pessoa p WHERE g.nome = :nomeGrupo ORDER BY p.nome DESC");
        q.setParameter("nomeGrupo", "Estudo IV");
        return (List<String>) q.getResultList();
    }
    
    // Quais são os grupos (dados completos) que contêm “II” em seus nomes?
    // a) Elaborar método para receber quaisquer nomes a serem pesquisados ao contrário de fixar o nome na JPQL
    @Override
    public List<Grupo> buscarGruposComII(){
        Query q = em.createQuery("SELECT g FROM Grupo g WHERE g.nome LIKE '%II%'");
        return (List<Grupo>) q.getResultList();
    }
    
}
