package dscatividade2.Atividade2.controle;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import dscatividade2.Atividade2.entidades.Disciplina;
import dscatividade2.Atividade2.servicos.DisciplinaService;

@RestController
public class DisciplinaController {
	
	@Autowired
	private DisciplinaService disciplinaService;
	
		@GetMapping("/api/disciplinas")
		public ResponseEntity<List<Disciplina>> getAllDisciplinas(){
			return new ResponseEntity<List<Disciplina>>(disciplinaService.getAllDisciplinas(), HttpStatus.OK);
		}
		
		@GetMapping("/api/disciplina/{id}")
		public ResponseEntity<Disciplina> getDisciplinaForId(@PathVariable Integer id){
			try {
				return new ResponseEntity<Disciplina>(disciplinaService.getDisciplinaForId(id), HttpStatus.OK);
			}catch (NoSuchElementException aiobe){
				return new ResponseEntity<Disciplina>(new Disciplina(null), HttpStatus.NOT_FOUND);
			}
		}
		
		@PutMapping("/api/disciplinas/like/{id}")
		public ResponseEntity<Disciplina> setLikeDisciplinaForId(@PathVariable Integer id){
			try {
				return new ResponseEntity<Disciplina>(disciplinaService.getDisciplinaForId(id), HttpStatus.OK);
			} catch (NoSuchElementException aiobe){
				return new ResponseEntity<Disciplina>(new Disciplina(null), HttpStatus.NOT_FOUND);
			}
		}
		
		@PutMapping("/api/disciplinas/nota/{id}")
		public ResponseEntity<Disciplina> uppdateNoteDisciplina(@PathVariable Integer id, Double nota){
			try {
				return new ResponseEntity<Disciplina>(disciplinaService.uppdateNoteDisciplina(id, nota), HttpStatus.OK);
			}catch(NoSuchElementException aiobe){
				return new ResponseEntity<Disciplina>(new Disciplina(null), HttpStatus.NOT_FOUND);
			}
		}
		
		@PutMapping("/api/disciplinas/comentarios/{id}")
		public ResponseEntity<Disciplina> uppdateCommentDisciplina(@PathVariable Integer id, String comentario){
			try {
				return new ResponseEntity<Disciplina>(disciplinaService.uppdateCommentDisciplina(id, comentario), HttpStatus.OK);
			}catch(NoSuchElementException aiobe) {
				return new ResponseEntity<Disciplina>(new Disciplina(null), HttpStatus.NOT_FOUND);
			}
		}
}
