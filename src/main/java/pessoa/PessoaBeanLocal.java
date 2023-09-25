/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package pessoa;

import grupo.Grupo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author rktds
 */
@Local
public interface PessoaBeanLocal {

    void salvar(Pessoa pessoa);

    Pessoa buscar(Long id);

    List<Pessoa> buscarTodasPessoas();

    List<String> buscarTodosNomes();

    List<Object> buscarNomesEEnderecos();

    List<Pessoa> buscarPessoasEmAvenidas();

    List<Pessoa> buscarPessoasNaoMoramEmPraca();

    List<Pessoa> buscarNomesETelefones();

    List<Pessoa> buscarEntre2001e2004();
    
    List<Pessoa> buscarPessoasDoParana(String prefixo);
    
    List<Pessoa> buscarPessoasSemTelefone();
    
    List<Object[]> buscarQntTelefones();
    
    List<String> buscarLideres();
    
    List<Grupo> buscarGruposLideradoPorBeatrizYana();
    
    List<Object[]> buscarGruposCecila();
    
    List<Object[]> buscarGruposEMembros();
    
    List<String> buscarGruposMaisDeTresAtuacoes();
    
    List<String> buscarMembrosAPartir2012();
    
    List<Object[]> buscarMembrosSemTermino();
    
    List<Object[]> buscarInformacoesGrupos();

    }
