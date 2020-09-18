package org.serratec.backend.projeto02.services;

import java.util.ArrayList;
import java.util.List;

import org.serratec.backend.projeto02.dominio.Conta;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

	public TodoService(){
		
		todos.add(new Conta(1,"Compras","Ir no mercado e fazer compras."));
		todos.add(new Conta(2,"Remédio","Passar na farmácia com a receita."));
		todos.add(new Conta(3,"Aula","Acessar o Teams para fazer aula."));
		
	}
	private List<Conta> todos = new ArrayList<Conta>();
	int contador =3;
	
	

	public List<Conta> listaTodos() {
		return this.todos;
	}

	public Conta getTodo(Integer id) {

		for (Conta todo : todos) {
			if (id == todo.getId())
				return todo;
		}

		return null;
	}

	public Conta criaTodo(Conta todo) {
		
		Conta obj = new Conta(++contador, todo.getTitulo(), todo.getDescricao());
		todos.add(obj);
		return obj;
	}
	
	public Conta atualizaTodo(Conta newTodo,Integer id) {
		
		for (Conta todo : todos) {
			if (todo.getId().equals(id)) {
				todo.setTitulo(newTodo.getTitulo());
				todo.setDescricao(newTodo.getTitulo());
				return todo;
			}
		}
		
		return null;	
	}
	
	public void apagaTodo(Integer id) {
		
		for (Conta todo : todos) {
			if (todo.getId().equals(id)) {
				todos.remove(todo);
				break;
			}
		}
	}
}
