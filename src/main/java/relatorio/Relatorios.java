/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package relatorio;

import grupo.GrupoBeanLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import pessoa.PessoaBeanLocal;
import util.Util;

/**
 *
 * @author rktds
 */
@Transactional
@WebServlet(name = "Relatorios", urlPatterns = {"/Relatorios"})
public class Relatorios extends HttpServlet {
    
    @Inject
    private PessoaBeanLocal pessoaBean;
    
    @Inject
    private GrupoBeanLocal grupoBean;
    

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Relatorios</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("<h2>Consulta 1.A: Quais as pessoas (dados completos) cadastradas? Por meio de Query</h2>");
            out.println("<p><pre>"
                    + Util.toJson(pessoaBean.buscarTodasPessoas())
                    + "</pre></p>");
            
            out.println("<h2>Consulta 2.A: Quais os nomes das pessoas?</h2>");
            out.println("<p><pre>"
                    + Util.toJson(pessoaBean.buscarTodosNomes())
                    + "</pre></p>");
            
            out.println("<h2>Consulta 3.A: Quais as pessoas (nome) e seus respectivos endereços (dados completos)? Por meio de Query</h2>");
            out.println("<p><pre>"
                    + Util.toJson(pessoaBean.buscarNomesEEnderecos())
                    + "</pre></p>");
            
            out.println("<h2>Consulta 4.A: Quais pessoas (dados completos) moram em avenidas? Por meio de Query</h2>");
            out.println("<p><pre>"
                    + Util.toJson(pessoaBean.buscarPessoasEmAvenidas())
                    + "</pre></p>");
            
            out.println("<h2>Consulta 5.A: Quais pessoas (dados completos) não moram em praças? Por meio de Query</h2>");
            out.println("<p><pre>"
                    + Util.toJson(pessoaBean.buscarPessoasNaoMoramEmPraca())
                    + "</pre></p>");
            
            out.println("<h2>Consulta 6.A: Quais pessoas (nomes) e seus respectivos telefones (dados completos)? Por meio de Query</h2>");
            out.println("<p><pre>"
                    + Util.toJson(pessoaBean.buscarNomesETelefones())
                    + "</pre></p>");
            
            out.println("<h2>Consulta 7.A: Quais as pessoas (dados completos) que nasceram entre abril de 2001 e abril de 2004? Por meio de Query</h2>");
            out.println("<p><pre>"
                    + Util.toJson(pessoaBean.buscarEntre2001e2004())
                    + "</pre></p>");
            
            out.println("<h2>Consulta 8.A/B: Quais pessoas (dados completos) têm telefone do estado do Paraná? E do Rio de Janeiro? Por meio de Query</h2>");
            out.println("<p><pre>"
                    + Util.toJson(pessoaBean.buscarPessoasDoParana("PR"))
                    + "</pre></p>");
            out.println("<p><pre>"
                    + Util.toJson(pessoaBean.buscarPessoasDoParana("RJ"))
                    + "</pre></p>");
            
            out.println("<h2>Consulta 9.A: Quais pessoas (dados completos) não possuem telefone? Por meio de Query</h2>");
            out.println("<p><pre>"
                    + Util.toJson(pessoaBean.buscarPessoasSemTelefone())
                    + "</pre></p>");
            
            out.println("<h2>Consulta 10.A: Quantos telefones cada pessoa (nome) tem? Por meio de Query</h2>");
            out.println("<p><pre>"
                    + Util.toJson(pessoaBean.buscarQntTelefones())
                    + "</pre></p>");
            
            out.println("<h2>Consulta 11.A: Quais grupos (dados completos) não estão ativos? Por meio de Query</h2>");
            out.println("<p><pre>"
                    + Util.toJson(grupoBean.buscarGruposInativos())
                    + "</pre></p>");
            
            out.println("<h2>Consulta 12.A: Quais são os líderes (nomes) dos grupos (nomes)? Por meio de Query</h2>");
            out.println("<p><pre>"
                    + Util.toJson(pessoaBean.buscarLideres())
                    + "</pre></p>");
            
            out.println("<h2>Consulta 13.A: Quais são os membros (nomes) do grupo com nome “Estudo IV” com ordenação alfabética\n" +
                "inversa? Por meio de Query</h2>");
            out.println("<p><pre>"
                    + Util.toJson(grupoBean.buscarMembrosEstudoIV())
                    + "</pre></p>");
            
            out.println("<h2>Consulta 14.A: Quais são os grupos (dados completos) liderados por “Beatriz Yana”? Por meio de Query</h2>");
            out.println("<p><pre>"
                    + Util.toJson(pessoaBean.buscarGruposLideradoPorBeatrizYana())
                    + "</pre></p>");
            
            out.println("<h2>Consulta 15.A: Quais são as datas de início e de término da atuação e os grupos (nomes) nos quais “Cecília\n" +
                "Xerxes” é membro? Por meio de Query</h2>");
            out.println("<p><pre>"
                    + Util.toJson(pessoaBean.buscarGruposCecila())
                    + "</pre></p>");
            
            out.println("<h2>Consulta 16.A: Quais são os grupos (dados completos) que contêm “II” em seus nomes? Por meio de Query</h2>");
            out.println("<p><pre>"
                    + Util.toJson(grupoBean.buscarGruposComII())
                    + "</pre></p>");
            
            out.println("<h2>Consulta 17.A: Quais são os grupos (nomes) e os respectivos totais de membros distintos já alocados? Por meio de Query</h2>");
            out.println("<p><pre>"
                    + Util.toJson(pessoaBean.buscarGruposEMembros())
                    + "</pre></p>");
            
            out.println("<h2>Consulta 18.A: Quais grupos (nomes) têm 3 ou mais atuações de membros e quanto são esses totais de atuações? Por meio de Query</h2>");
            out.println("<p><pre>"
                    + Util.toJson(pessoaBean.buscarGruposMaisDeTresAtuacoes())
                    + "</pre></p>");
            
            out.println("<h2>Consulta 19.A: Quais membros (nomes) entraram a partir de 2012 no primeiro grupo? Por meio de Query</h2>");
            out.println("<p><pre>"
                    + Util.toJson(pessoaBean.buscarMembrosAPartir2012())
                    + "</pre></p>");
            
            out.println("<h2>Consulta 21.A: Quais os grupos (nomes) e respectivos membros (nomes) que não possuem data de término de\n" +
                "atuação em seus grupos? Por meio de Query</h2>");
            out.println("<p><pre>"
                    + Util.toJson(pessoaBean.buscarMembrosSemTermino())
                    + "</pre></p>");
            
            out.println("<h2>Consulta 22.A: Quais são os grupos (nomes) e líderes (nomes) com respectivos membros (nomes)? Por meio de Query</h2>");
            out.println("<p><pre>"
                    + Util.toJson(pessoaBean.buscarInformacoesGrupos())
                    + "</pre></p>");
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
