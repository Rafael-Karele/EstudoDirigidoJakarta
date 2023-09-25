/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB31/SingletonEjbClass.java to edit this template
 */
package util;

import atuacao.Atuacao;
import endereco.Endereco;
import grupo.Grupo;
import grupo.GrupoBeanLocal;
import java.time.LocalDate;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import pessoa.Pessoa;
import pessoa.PessoaBeanLocal;
import telefone.Telefone;

/**
 *
 * @author rktds
 */
@Singleton
@Startup
public class CargaDados implements CargaDadosLocal {
    
    @Inject
    private PessoaBeanLocal pessoaBean;
    
    @PostConstruct
    @Override
    public void popularBanco() {
        Endereco end1 = new Endereco();
        end1.setLogradouro("1");
        end1.setBairro("Humberto");
        end1.setNumero(1111);
        end1.setTipoLogradouro(Endereco.TipoLogradouro.RUA);

        Endereco end2 = new Endereco();
        end2.setLogradouro("2");
        end2.setBairro("Doisberto");
        end2.setNumero(2222);
        end2.setTipoLogradouro(Endereco.TipoLogradouro.AVENIDA);

        Endereco end3 = new Endereco();
        end3.setLogradouro("3");
        end3.setBairro("Trêsberto");
        end3.setNumero(3333);
        end3.setTipoLogradouro(Endereco.TipoLogradouro.AVENIDA);

        Endereco end4 = new Endereco();
        end4.setLogradouro("4");
        end4.setBairro("Quatroberto");
        end4.setNumero(4444);
        end4.setTipoLogradouro(Endereco.TipoLogradouro.PRACA);

        Telefone tel1 = new Telefone();
        tel1.setDdd((byte) 11);
        tel1.setNumero(11111111);

        Telefone tel2 = new Telefone();
        tel2.setDdd((byte) 12);
        tel2.setNumero(12121212);

        Telefone tel3 = new Telefone();
        tel3.setDdd((byte) 13);
        tel3.setNumero(13131313);

        Telefone tel4 = new Telefone();
        tel4.setDdd((byte) 22);
        tel4.setNumero(22222222);

        Telefone tel5 = new Telefone();
        tel5.setDdd((byte) 44);
        tel5.setNumero(44444444);

        Telefone tel6 = new Telefone();
        tel6.setDdd((byte) 45);
        tel6.setNumero(45454545);

        Pessoa anaZaira = new Pessoa();
        anaZaira.setNome("Ana Zaira");
        anaZaira.setEmail("ana@mail.com");
        anaZaira.setEndereco(end1);
        anaZaira.getTelefones().add(tel1);
        anaZaira.getTelefones().add(tel2);
        anaZaira.getTelefones().add(tel3);
        anaZaira.setNascimento(LocalDate.of(2001, 1, 1));

        Pessoa beatrizYana = new Pessoa();
        beatrizYana.setNome("Beatriz Yana");
        beatrizYana.setEmail("beatriz@mail.com");
        beatrizYana.setEndereco(end2);
        beatrizYana.getTelefones().add(tel4);
        beatrizYana.setNascimento(LocalDate.of(2002, 2, 2));

        Pessoa ceciliaXerxes = new Pessoa();
        ceciliaXerxes.setNome("Cecília Xerxes");
        ceciliaXerxes.setEmail("cecilia@mail.com");
        ceciliaXerxes.setEndereco(end3);
        ceciliaXerxes.setNascimento(LocalDate.of(2003, 3, 3));

        Pessoa deboraWendel = new Pessoa();
        deboraWendel.setNome("Débora Wendel");
        deboraWendel.setEmail("debora@mail.com");
        deboraWendel.setEndereco(end4);
        deboraWendel.getTelefones().add(tel5);
        deboraWendel.getTelefones().add(tel6);
        deboraWendel.setNascimento(LocalDate.of(2004, 4, 4));

        Grupo grupo = new Grupo();
        grupo.setNome("Estudo I");
        grupo.setAtivo(Boolean.FALSE);

        Grupo grupo2 = new Grupo();
        grupo2.setNome("Estudo II");
        grupo2.setAtivo(Boolean.TRUE);

        Grupo grupo3 = new Grupo();
        grupo3.setNome("Estudo III");
        grupo3.setAtivo(Boolean.FALSE);

        Grupo grupo4 = new Grupo();
        grupo4.setNome("Estudo IV");
        grupo4.setAtivo(Boolean.TRUE);

        anaZaira.getLideranca().add(grupo);
        beatrizYana.getLideranca().add(grupo2);
        ceciliaXerxes.getLideranca().add(grupo3);
        beatrizYana.getLideranca().add(grupo4);

        Atuacao atuacao = new Atuacao();
        atuacao.setInicio(LocalDate.of(2011, 1, 1));
        atuacao.setTermino(LocalDate.of(2021, 11, 11));
        atuacao.setGrupo(grupo);
        atuacao.setPessoa(anaZaira);

        Atuacao atuacao1 = new Atuacao();
        atuacao1.setInicio(LocalDate.of(2012, 1, 1));
        atuacao1.setTermino(LocalDate.of(2022, 11, 11));
        atuacao1.setGrupo(grupo);
        atuacao1.setPessoa(anaZaira);

        Atuacao atuacao2 = new Atuacao();
        atuacao2.setInicio(LocalDate.of(2012, 1, 2));
        atuacao2.setTermino(LocalDate.of(2021, 1, 12));
        atuacao2.setGrupo(grupo);
        atuacao2.setPessoa(beatrizYana);

        Atuacao atuacao3 = new Atuacao();
        atuacao3.setInicio(LocalDate.of(2013, 1, 3));
        atuacao3.setTermino(LocalDate.of(2021, 11, 13));
        atuacao3.setGrupo(grupo);
        atuacao3.setPessoa(ceciliaXerxes);

        Atuacao atuacao4 = new Atuacao();
        atuacao4.setInicio(LocalDate.of(2014, 1, 4));
        atuacao4.setTermino(LocalDate.of(2021, 1, 14));
        atuacao4.setGrupo(grupo);
        atuacao4.setPessoa(deboraWendel);

        Atuacao atuacao5 = new Atuacao();
        atuacao5.setInicio(LocalDate.of(2012, 1, 2));
        atuacao5.setGrupo(grupo2);
        atuacao5.setPessoa(beatrizYana);

        Atuacao atuacao6 = new Atuacao();
        atuacao6.setInicio(LocalDate.of(2012, 1, 2));
        atuacao6.setGrupo(grupo2);
        atuacao6.setPessoa(deboraWendel);

        Atuacao atuacao7 = new Atuacao();
        atuacao7.setInicio(LocalDate.of(2012, 1, 3));
        atuacao7.setTermino(LocalDate.of(2023, 1, 13));
        atuacao7.setGrupo(grupo3);
        atuacao7.setPessoa(ceciliaXerxes);

        Atuacao atuacao8 = new Atuacao();
        atuacao8.setInicio(LocalDate.of(2012, 1, 3));
        atuacao8.setTermino(LocalDate.of(2023, 1, 13));
        atuacao8.setGrupo(grupo3);
        atuacao8.setPessoa(deboraWendel);

        Atuacao atuacao9 = new Atuacao();
        atuacao9.setInicio(LocalDate.of(2012, 1, 4));
        atuacao9.setTermino(LocalDate.of(2024, 1, 14));
        atuacao9.setGrupo(grupo4);
        atuacao9.setPessoa(beatrizYana);

        Atuacao atuacao10 = new Atuacao();
        atuacao10.setInicio(LocalDate.of(2012, 1, 4));
        atuacao10.setTermino(LocalDate.of(2024, 1, 14));
        atuacao10.setGrupo(grupo4);
        atuacao10.setPessoa(ceciliaXerxes);

        Atuacao atuacao11 = new Atuacao();
        atuacao11.setInicio(LocalDate.of(2012, 1, 4));
        atuacao11.setTermino(LocalDate.of(2024, 1, 14));
        atuacao11.setGrupo(grupo4);
        atuacao11.setPessoa(deboraWendel);

        anaZaira.getAtuacoes().add(atuacao);
        anaZaira.getAtuacoes().add(atuacao1);

        beatrizYana.getAtuacoes().add(atuacao2);
        beatrizYana.getAtuacoes().add(atuacao5);
        beatrizYana.getAtuacoes().add(atuacao9);

        ceciliaXerxes.getAtuacoes().add(atuacao3);
        ceciliaXerxes.getAtuacoes().add(atuacao7);
        ceciliaXerxes.getAtuacoes().add(atuacao10);

        deboraWendel.getAtuacoes().add(atuacao4);
        deboraWendel.getAtuacoes().add(atuacao6);
        deboraWendel.getAtuacoes().add(atuacao8);
        deboraWendel.getAtuacoes().add(atuacao11);

        grupo.getAtuacoes().add(atuacao);
        grupo.getAtuacoes().add(atuacao1);
        grupo.getAtuacoes().add(atuacao2);
        grupo.getAtuacoes().add(atuacao3);
        grupo.getAtuacoes().add(atuacao4);

        grupo2.getAtuacoes().add(atuacao5);
        grupo2.getAtuacoes().add(atuacao6);

        grupo3.getAtuacoes().add(atuacao7);
        grupo3.getAtuacoes().add(atuacao8);

        grupo4.getAtuacoes().add(atuacao9);
        grupo4.getAtuacoes().add(atuacao10);
        grupo4.getAtuacoes().add(atuacao11);

        pessoaBean.salvar(anaZaira);
        pessoaBean.salvar(beatrizYana);
        pessoaBean.salvar(ceciliaXerxes);
        pessoaBean.salvar(deboraWendel);
    }
    
}
