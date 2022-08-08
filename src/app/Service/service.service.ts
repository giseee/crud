import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Persona } from '../Modelos/Persona';
@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  constructor(private http:HttpClient) { }
  Url='http://localhost:9090/crud/personas';
  getPersonas(){
    return this.http.get<Persona[]>(this.Url+"/listar");
  }
  createPersona(persona:Persona){  
    return this.http.post<Persona>(this.Url+"/add",persona);
  }
  getPersonaId(id:number){
  return this.http.get<Persona>(this.Url+"/"+{id});
  }
  updatePersona(persona:Persona){
    return this.http.put<Persona>(this.Url+"/"+persona.id,persona);
  }
  deletePersona(persona:Persona){
    return this.http.delete<Persona>(this.Url+"/"+persona.id);
  }
}
