package com.example.service;

import org.springframework.stereotype.Service;

import com.example.model.Cadeira;
import java.util.*;


@Service
public class CadeiraService {
	
	List<Cadeira> cadeiras;
	
	public CadeiraService() {
		this.cadeiras = new ArrayList();
	}
	
	public List<Cadeira> getCadeiras(){
		return this.cadeiras;
	
	}
	
	public Cadeira getCadeiraPorId(int id) {
		for (Cadeira cadeiras: this.cadeiras) {
			if (cadeiras.getId() == id) {
				
				return cadeiras;
			}
		}
		
		return null;
	}
	
	public boolean createCadeira(Cadeira disciplina) {
		this.cadeiras.add(disciplina);
		return true;
	}
	
	public boolean deleteCadeira(int id) {
		Cadeira disciplina = null;
		for(Cadeira a: this.cadeiras) {
			if(a.getId() == id) {
				disciplina = a;
			}
		}
		
		return false;
	}
	
	 public List<Cadeira> getOrdered() {
	        Collections.sort(cadeiras, new Comparator<Cadeira>() {
	            @Override
	            public int compare(Cadeira cadeiras, Cadeira cad1) {
	                if (cad1.getNota() == cadeiras.getNota()) {
	                    return 0;
	                }
	                else if (cad1.getNota() < cadeiras.getNota()) {
	                    return -1;
	                }
	                return 1;
	            }
	        });
	        return cadeiras;
	    }

}
