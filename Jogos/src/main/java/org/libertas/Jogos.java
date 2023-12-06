package org.libertas;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.libertas.bd.JogosDAO;

import com.google.gson.Gson;


public class Jogos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Jogos() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		//out.println("Executando método GET");
		JogosDAO jdao = new JogosDAO();
		List<org.libertas.bd.Jogos> lista = jdao.listar();
		Gson gson = new Gson();
		out.print(gson.toJson(lista));
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		try {
		//PEGA O BOBY DA REQUISIÇÃO CONTENDO OS DADOS PARA SER INSERIDO 
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = request.getReader();
		String line;
		while ((line = reader.readLine()) !=null) {
			sb.append(line);
		}
			String boby = sb.toString();
			
			//TRANSFORMA O PARAÊMETRO DO BODY EM OBJETO JSON
			Gson gson = new Gson();
			org.libertas.bd.Jogos j = gson.fromJson(boby, org.libertas.bd.Jogos.class);
			
			//INSERE OBJETO NO BANCO DE DADOS
			JogosDAO pdao = new JogosDAO();
			pdao.inserir(j);
			
			Retorno r = new Retorno(true, "Registro inserido com sucesso");
			out.print(gson.toJson(r));
			
	 } catch (Exception e) {
		 e.printStackTrace();
		 Gson gson = new Gson();
		 Retorno r = new Retorno(false, e.getMessage());
			out.print(gson.toJson(r));
		}
}
		
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			//PEGA O BOBY DA REQUISIÇÃO CONTENDO OS DADOS PARA SER INSERIDO 
			StringBuilder sb = new StringBuilder();
			BufferedReader reader = request.getReader();
			String line;
			while ((line = reader.readLine()) !=null) {
				sb.append(line);
			}
				String boby = sb.toString();
				
				//TRANSFORMA O PARAÊMETRO DO BODY EM OBJETO JSON
				Gson gson = new Gson();
				org.libertas.bd.Jogos j = gson.fromJson(boby, org.libertas.bd.Jogos.class);
				
				//INSERE OBJETO NO BANCO DE DADOS
				JogosDAO pdao = new JogosDAO();
				pdao.alterar(j);
				
				Retorno r = new Retorno(true, "Registro alterado com sucesso!!!");
				out.print(gson.toJson(r));
				
		 } catch (Exception e) {
			 e.printStackTrace();
			 Gson gson = new Gson();
			 Retorno r = new Retorno(false, e.getMessage());
			 out.print(gson.toJson(r));out.print(e.getMessage());
			}
	}
	
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			//pega o id passando por parâmetro 
			String id = request.getRequestURI();
			id = id.substring(id.lastIndexOf("/")+1);
			
			JogosDAO jdao = new JogosDAO();
			org.libertas.bd.Jogos j = new org.libertas.bd.Jogos();
			j.setId(Integer.parseInt(id));
			jdao.excluir(j);
			
			Retorno r = new Retorno(true, "Registro excluído com sucesso");
			Gson gson = new Gson();
			out.print(gson.toJson(r));
		} catch (Exception e) {
			e.printStackTrace();
			Gson gson = new Gson();
			Retorno r = new Retorno(false, e.getMessage());
			out.print(gson.toJson(r));
		}
		
		
		
		
	}

}
