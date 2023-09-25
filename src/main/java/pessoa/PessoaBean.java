/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package pessoa;

import grupo.Grupo;
import java.time.LocalDate;
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
public class PessoaBean implements PessoaBeanLocal {

    @PersistenceContext
    EntityManager em;

    @Override
    public void salvar(Pessoa pessoa) {
        em.persist(pessoa);
    }

    @Override
    public Pessoa buscar(Long id) {
        return em.find(Pessoa.class, id);
    }  
    
    // Quais as pessoas (dados completos) cadastradas?
    @Override
    public List<Pessoa> buscarTodasPessoas(){
        Query q = em.createQuery("SELECT p FROM Pessoa p");
        return (List<Pessoa>) q.getResultList();
    }
    
    // Quais os nomes das pessoas?
    @Override
    public List<String> buscarTodosNomes(){
        Query q = em.createQuery("SELECT p.nome FROM Pessoa p");
        return (List<String>) q.getResultList();
    }
    
    
    // Quais as pessoas (nome) e seus respectivos endereços (dados completos)?
    @Override
    public List<Object> buscarNomesEEnderecos(){
        Query q = em.createQuery("SELECT p.nome, p.endereco FROM Pessoa p");
        return (List<Object>) q.getResultList();
    }
    
    // Quais pessoas (dados completos) moram em avenidas?
    @Override
    public List<Pessoa> buscarPessoasEmAvenidas(){
        Query q = em.createQuery("SELECT p FROM Pessoa p WHERE p.endereco.tipoLogradouro = 1");
        return (List<Pessoa>) q.getResultList();
    }
    
    // Quais pessoas (dados completos) não moram em praças?
    @Override
    public List<Pessoa> buscarPessoasNaoMoramEmPraca(){
        Query q = em.createQuery("SELECT p FROM Pessoa p WHERE p.endereco.tipoLogradouro <> 2");
        return (List<Pessoa>) q.getResultList();
    }
    
    // Quais pessoas (nomes) e seus respectivos telefones (dados completos)?
    @Override
    public List<Pessoa> buscarNomesETelefones(){
        Query q = em.createQuery("SELECT p.nome, t FROM Pessoa p JOIN p.telefones t");
        return (List<Pessoa>) q.getResultList();
    }
    
    // Quais as pessoas (dados completos) que nasceram entre abril de 2001 e abril de 2004?
    @Override
    public List<Pessoa> buscarEntre2001e2004() {
        LocalDate dataInicio = LocalDate.of(2001, 4, 1);
        LocalDate dataFim = LocalDate.of(2004, 4, 30);

        Query q = em.createQuery("SELECT p FROM Pessoa p WHERE p.nascimento BETWEEN :dataInicio AND :dataFim");
        q.setParameter("dataInicio", dataInicio);
        q.setParameter("dataFim", dataFim);

        return q.getResultList();
    }

    // a) Elaborar método para receber quaisquer datas a serem pesquisados ao contrário de fixá-las na JPQL
    // b) Tal método pode ter variados formatos: receber um short para o ano e um byte para o mês, ou uma enumeração para o mês; a data inicial e a data final completas; e outras.
    
    // Quais pessoas (dados completos) têm telefone do estado do Paraná? E do Rio de Janeiro?
    // a) Um prefixo de referência é fornecido como parâmetro ao método e a consulta deve localizar todos os prefixos daquele estado.
    @Override
    public List<Pessoa> buscarPessoasDoParana(String prefixo) {
        Query q;
        switch (prefixo) {
            case "SP":
                q = em.createQuery("SELECT p FROM Pessoa p JOIN p.telefones t WHERE t.ddd BETWEEN 11 AND 19");
                break;
            case "RJ":
                q = em.createQuery("SELECT p FROM Pessoa p JOIN p.telefones t WHERE t.ddd BETWEEN 21 AND 24");
                break;
            case "ES":
                q = em.createQuery("SELECT p FROM Pessoa p JOIN p.telefones t WHERE t.ddd BETWEEN 27 AND 28");
                break;
            case "MG":
                q = em.createQuery("SELECT p FROM Pessoa p JOIN p.telefones t WHERE t.ddd BETWEEN 31 AND 38");
                break;
            case "PR":
                q = em.createQuery("SELECT p FROM Pessoa p JOIN p.telefones t WHERE t.ddd BETWEEN 41 AND 46");
                break;
            case "SC":
                q = em.createQuery("SELECT p FROM Pessoa p JOIN p.telefones t WHERE t.ddd BETWEEN 47 AND 49");
                break;
            case "RS":
                q = em.createQuery("SELECT p FROM Pessoa p JOIN p.telefones t WHERE t.ddd BETWEEN 51 AND 55");
                break;
            case "DF":
                q = em.createQuery("SELECT p FROM Pessoa p JOIN p.telefones t WHERE t.ddd = 61");
                break;
            case "GO":
                q = em.createQuery("SELECT p FROM Pessoa p JOIN p.telefones t WHERE t.ddd = 62 OR 64");
                break;
            case "TO":
                q = em.createQuery("SELECT p FROM Pessoa p JOIN p.telefones t WHERE t.ddd = 63");
                break;
            case "MT":
                q = em.createQuery("SELECT p FROM Pessoa p JOIN p.telefones t WHERE t.ddd BETWEEN 65 AND 66");
                break;
            case "MS":
                q = em.createQuery("SELECT p FROM Pessoa p JOIN p.telefones t WHERE t.ddd = 67");
                break;
            case "AC":
                q = em.createQuery("SELECT p FROM Pessoa p JOIN p.telefones t WHERE t.ddd = 68");
                break;
            case "RO":
                q = em.createQuery("SELECT p FROM Pessoa p JOIN p.telefones t WHERE t.ddd = 69");
                break;
            case "BA":
                q = em.createQuery("SELECT p FROM Pessoa p JOIN p.telefones t WHERE t.ddd BETWEEN 71 AND 77");
                break;
            case "SE":
                q = em.createQuery("SELECT p FROM Pessoa p JOIN p.telefones t WHERE t.ddd = 79");
                break;
            case "PE":
                q = em.createQuery("SELECT p FROM Pessoa p JOIN p.telefones t WHERE t.ddd = 81 OR 87");
                break;
            case "AL":
                q = em.createQuery("SELECT p FROM Pessoa p JOIN p.telefones t WHERE t.ddd = 82");
                break;
            case "PB":
                q = em.createQuery("SELECT p FROM Pessoa p JOIN p.telefones t WHERE t.ddd = 83");
                break;
            case "RN":
                q = em.createQuery("SELECT p FROM Pessoa p JOIN p.telefones t WHERE t.ddd = 84");
                break;
            case "CE":
                q = em.createQuery("SELECT p FROM Pessoa p JOIN p.telefones t WHERE t.ddd = 85 OR 88");
                break;
            case "PI":
                q = em.createQuery("SELECT p FROM Pessoa p JOIN p.telefones t WHERE t.ddd = 86 OR 89");
                break;
            case "PA":
                q = em.createQuery("SELECT p FROM Pessoa p JOIN p.telefones t WHERE t.ddd = 91 OR 93 OR 94");
                break;
            case "AM":
                q = em.createQuery("SELECT p FROM Pessoa p JOIN p.telefones t WHERE t.ddd = 92 OR 97");
                break;
            case "RR":
                q = em.createQuery("SELECT p FROM Pessoa p JOIN p.telefones t WHERE t.ddd = 95");
                break;
            case "AP":
                q = em.createQuery("SELECT p FROM Pessoa p JOIN p.telefones t WHERE t.ddd = 96");
                break;
            case "MA":
                q = em.createQuery("SELECT p FROM Pessoa p JOIN p.telefones t WHERE t.ddd = 98 OR 99");
                break;
            default:
                return null;
        }

        return (List<Pessoa>) q.getResultList();
    }

    
    
    // Quais pessoas (dados completos) não possuem telefone?
    @Override
    public List<Pessoa> buscarPessoasSemTelefone() {
        Query q = em.createQuery("SELECT p FROM Pessoa p LEFT JOIN p.telefones t WHERE t IS NULL");
        return (List<Pessoa>) q.getResultList();
    }

    // Quantos telefones cada pessoa (nome) tem?
    // a)Dica: junção, agrupamento e função de contagem.
    @Override
    public List<Object[]> buscarQntTelefones() {
        Query q = em.createQuery("SELECT p.nome, COUNT(t) FROM Pessoa p LEFT JOIN p.telefones t GROUP BY p.nome");
        return (List<Object[]>) q.getResultList();
    }
    
    // Quais grupos (dados completos) não estão ativos?
    // Codigo feito no GrupoBean

    // Quais são os líderes (nomes) dos grupos (nomes)?
    @Override
    public List<String> buscarLideres() {
        Query q = em.createQuery("SELECT p.nome, g.nome FROM Pessoa p JOIN p.lideranca g");
        return (List<String>) q.getResultList();
    }
    
    // Quais são os membros (nomes) do grupo com nome “Estudo IV” com ordenação alfabética inversa?
    // a)Elaborar método genérico para receber quaisquer nomes a serem pesquisados ao contrário de fixar o nome na JPQL
    // Codigo feito no GrupoBean
    
    // Quais são os grupos (dados completos) liderados por “Beatriz Yana”?
    // a) Elaborar método para receber quaisquer nomes a serem pesquisados ao contrário de fixar o nome na JPQL
    @Override
    public List<Grupo> buscarGruposLideradoPorBeatrizYana() {
        Query q = em.createQuery("SELECT g FROM Pessoa p JOIN p.lideranca g WHERE p.nome = 'Beatriz Yana'");
        return (List<Grupo>) q.getResultList();
    }
    
    // Quais são as datas de início e de término da atuação e os grupos (nomes) nos quais “Cecília Xerxes” é membro?
    // a) Elaborar método para receber quaisquer nomes a serem pesquisados ao contrário de fixar o nome na JPQL
    @Override
    public List<Object[]> buscarGruposCecila() {
        Query q = em.createQuery("SELECT a.inicio, a.termino, a.grupo.nome FROM Pessoa p JOIN p.atuacoes a JOIN a.grupo g WHERE p.nome = 'Cecília Xerxes'");
        return (List<Object[]>) q.getResultList();
    }
    
    // Quais são os grupos (dados completos) que contêm “II” em seus nomes?
    // a) Elaborar método para receber quaisquer nomes a serem pesquisados ao contrário de fixar o nome na JPQL
    // Codigo feito no GrupoBean
    
    // Quais são os grupos (nomes) e os respectivos totais de membros distintos já alocados?
    @Override
    public List<Object[]> buscarGruposEMembros() {
        Query q = em.createQuery("SELECT g.nome, COUNT(DISTINCT p) FROM Pessoa p JOIN p.atuacoes a JOIN a.grupo g GROUP BY g.nome");
        return (List<Object[]>) q.getResultList();
    }
    
    // Quais grupos (nomes) têm 3 ou mais atuações de membros e quanto são esses totais de atuações?
    // a) Elaborar método para receber quaisquer totais a serem pesquisados ao contrário de fixar o número na JPQL
    @Override
    public List<String> buscarGruposMaisDeTresAtuacoes() {
        Query q = em.createQuery("SELECT g.nome, COUNT(a) FROM Grupo g JOIN g.atuacoes a GROUP BY g.nome HAVING COUNT(a) >= 3");
        return (List<String>) q.getResultList();
    }
    
    // Quais membros (nomes) entraram a partir de 2012 no primeiro grupo?
    // a) Elaborar método para receber quaisquer IDs de grupos e datas a serem pesquisados ao contrário de fixar tais parâmetros na JPQL
    @Override
    public List<String> buscarMembrosAPartir2012() {
        Query q = em.createQuery("SELECT DISTINCT p.nome FROM Pessoa p JOIN p.atuacoes a JOIN a.grupo g WHERE YEAR(a.inicio) >= 2012 AND g = (SELECT MIN(g2) FROM Grupo g2)");
        return (List<String>) q.getResultList();
    }
    
    
    // Quais os grupos (nomes), membros (nomes) e as respectivas datas de entrada daqueles que entraram a partir de 2012 em qualquer grupo?
    // Empregar a DTO “MembroDto” para acomodar os dados de resposta.
    // Ordenação por nome do grupo e data de início da atuação
    // Elaborar método para receber quaisquer IDs de grupos e datas a serem pesquisados ao contrário de fixar tais parâmetros na JPQL
    
    // Quais os grupos (nomes) e respectivos membros (nomes) que não possuem data de término de atuação em seus grupos?
    @Override
    public List<Object[]> buscarMembrosSemTermino() {
        Query q = em.createQuery("SELECT g.nome, p.nome FROM Pessoa p JOIN p.atuacoes a JOIN a.grupo g WHERE a.termino IS NULL");
        return (List<Object[]>) q.getResultList();
    }
    
    // Quais são os grupos (nomes) e líderes (nomes) com respectivos membros (nomes)?
    // a) Ordenação por nome de grupo, líder e membro.
    @Override
    public List<Object[]> buscarInformacoesGrupos() {
        Query q = em.createQuery("SELECT g.nome, p.nome, m.nome FROM Pessoa p JOIN p.lideranca g LEFT JOIN g.atuacoes a LEFT JOIN a.pessoa m ORDER BY g.nome, p.nome, m.nome");
        return (List<Object[]>) q.getResultList();
    }
}
